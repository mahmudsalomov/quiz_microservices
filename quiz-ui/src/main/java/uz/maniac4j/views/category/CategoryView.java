package uz.maniac4j.views.category;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import uz.maniac4j.data.entity.Category;
import uz.maniac4j.data.service.CategoryService;
import uz.maniac4j.views.MainLayout;

@PageTitle("Category")
@Route(value = "category/:categoryID?/:action?(edit)", layout = MainLayout.class)
public class CategoryView extends Div implements BeforeEnterObserver {

    private final String CATEGORY_ID = "categoryID";
    private final String CATEGORY_EDIT_ROUTE_TEMPLATE = "category/%s/edit";

    private Grid<Category> grid = new Grid<>(Category.class, false);

    private TextField name;
    private TextField description;
    private TextField organization;

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private BeanValidationBinder<Category> binder;

    private Category category;

    private final CategoryService categoryService;

    @Autowired
    public CategoryView(CategoryService categoryService) {
        this.categoryService = categoryService;
        addClassNames("category-view");

        // Create UI
        SplitLayout splitLayout = new SplitLayout();

        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);

        add(splitLayout);

        // Configure Grid
        grid.addColumn("name").setAutoWidth(true);
        grid.addColumn("description").setAutoWidth(true);
        grid.addColumn("organization").setAutoWidth(true);
        grid.setItems(query -> categoryService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);

        // when a row is selected or deselected, populate form
        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                UI.getCurrent().navigate(String.format(CATEGORY_EDIT_ROUTE_TEMPLATE, event.getValue().getId()));
            } else {
                clearForm();
                UI.getCurrent().navigate(CategoryView.class);
            }
        });

        // Configure Form
        binder = new BeanValidationBinder<>(Category.class);

        // Bind fields. This is where you'd define e.g. validation rules

        binder.bindInstanceFields(this);

        cancel.addClickListener(e -> {
            clearForm();
            refreshGrid();
        });

        save.addClickListener(e -> {
            try {
                if (this.category == null) {
                    this.category = new Category();
                }
                binder.writeBean(this.category);

                categoryService.update(this.category);
                clearForm();
                refreshGrid();
                Notification.show("Category details stored.");
                UI.getCurrent().navigate(CategoryView.class);
            } catch (ValidationException validationException) {
                Notification.show("An exception happened while trying to store the category details.");
            }
        });

    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        Optional<UUID> categoryId = event.getRouteParameters().get(CATEGORY_ID).map(UUID::fromString);
        if (categoryId.isPresent()) {
            Optional<Category> categoryFromBackend = categoryService.get(categoryId.get());
            if (categoryFromBackend.isPresent()) {
                populateForm(categoryFromBackend.get());
            } else {
                Notification.show(String.format("The requested category was not found, ID = %s", categoryId.get()),
                        3000, Notification.Position.BOTTOM_START);
                // when a row is selected but the data is no longer available,
                // refresh grid
                refreshGrid();
                event.forwardTo(CategoryView.class);
            }
        }
    }

    private void createEditorLayout(SplitLayout splitLayout) {
        Div editorLayoutDiv = new Div();
        editorLayoutDiv.setClassName("editor-layout");

        Div editorDiv = new Div();
        editorDiv.setClassName("editor");
        editorLayoutDiv.add(editorDiv);

        FormLayout formLayout = new FormLayout();
        name = new TextField("Name");
        description = new TextField("Description");
        organization = new TextField("Organization");
        Component[] fields = new Component[]{name, description, organization};

        formLayout.add(fields);
        editorDiv.add(formLayout);
        createButtonLayout(editorLayoutDiv);

        splitLayout.addToSecondary(editorLayoutDiv);
    }

    private void createButtonLayout(Div editorLayoutDiv) {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setClassName("button-layout");
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save, cancel);
        editorLayoutDiv.add(buttonLayout);
    }

    private void createGridLayout(SplitLayout splitLayout) {
        Div wrapper = new Div();
        wrapper.setClassName("grid-wrapper");
        splitLayout.addToPrimary(wrapper);
        wrapper.add(grid);
    }

    private void refreshGrid() {
        grid.select(null);
        grid.getLazyDataView().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(Category value) {
        this.category = value;
        binder.readBean(this.category);

    }
}
