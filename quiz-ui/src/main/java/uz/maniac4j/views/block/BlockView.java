package uz.maniac4j.views.block;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import uz.maniac4j.data.entity.Block;
import uz.maniac4j.data.service.BlockService;
import uz.maniac4j.views.MainLayout;

@PageTitle("Block")
@Route(value = "block/:blockID?/:action?(edit)", layout = MainLayout.class)
@Uses(Icon.class)
public class BlockView extends Div implements BeforeEnterObserver {

    private final String BLOCK_ID = "blockID";
    private final String BLOCK_EDIT_ROUTE_TEMPLATE = "block/%s/edit";

    private Grid<Block> grid = new Grid<>(Block.class, false);

    private TextField name;
    private TextField description;
    private TextField type;
    private TextField timeLimit;
    private Checkbox active;

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private BeanValidationBinder<Block> binder;

    private Block block;

    private final BlockService blockService;

    @Autowired
    public BlockView(BlockService blockService) {
        this.blockService = blockService;
        addClassNames("block-view");

        // Create UI
        SplitLayout splitLayout = new SplitLayout();

        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);

        add(splitLayout);

        // Configure Grid
        grid.addColumn("name").setAutoWidth(true);
        grid.addColumn("description").setAutoWidth(true);
        grid.addColumn("type").setAutoWidth(true);
        grid.addColumn("timeLimit").setAutoWidth(true);
        LitRenderer<Block> activeRenderer = LitRenderer.<Block>of(
                "<vaadin-icon icon='vaadin:${item.icon}' style='width: var(--lumo-icon-size-s); height: var(--lumo-icon-size-s); color: ${item.color};'></vaadin-icon>")
                .withProperty("icon", active -> active.isActive() ? "check" : "minus").withProperty("color",
                        active -> active.isActive()
                                ? "var(--lumo-primary-text-color)"
                                : "var(--lumo-disabled-text-color)");

        grid.addColumn(activeRenderer).setHeader("Active").setAutoWidth(true);

        grid.setItems(query -> blockService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);

        // when a row is selected or deselected, populate form
        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                UI.getCurrent().navigate(String.format(BLOCK_EDIT_ROUTE_TEMPLATE, event.getValue().getId()));
            } else {
                clearForm();
                UI.getCurrent().navigate(BlockView.class);
            }
        });

        // Configure Form
        binder = new BeanValidationBinder<>(Block.class);

        // Bind fields. This is where you'd define e.g. validation rules

        binder.bindInstanceFields(this);

        cancel.addClickListener(e -> {
            clearForm();
            refreshGrid();
        });

        save.addClickListener(e -> {
            try {
                if (this.block == null) {
                    this.block = new Block();
                }
                binder.writeBean(this.block);

                blockService.update(this.block);
                clearForm();
                refreshGrid();
                Notification.show("Block details stored.");
                UI.getCurrent().navigate(BlockView.class);
            } catch (ValidationException validationException) {
                Notification.show("An exception happened while trying to store the block details.");
            }
        });

    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        Optional<UUID> blockId = event.getRouteParameters().get(BLOCK_ID).map(UUID::fromString);
        if (blockId.isPresent()) {
            Optional<Block> blockFromBackend = blockService.get(blockId.get());
            if (blockFromBackend.isPresent()) {
                populateForm(blockFromBackend.get());
            } else {
                Notification.show(String.format("The requested block was not found, ID = %s", blockId.get()), 3000,
                        Notification.Position.BOTTOM_START);
                // when a row is selected but the data is no longer available,
                // refresh grid
                refreshGrid();
                event.forwardTo(BlockView.class);
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
        type = new TextField("Type");
        timeLimit = new TextField("Time Limit");
        active = new Checkbox("Active");
        Component[] fields = new Component[]{name, description, type, timeLimit, active};

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

    private void populateForm(Block value) {
        this.block = value;
        binder.readBean(this.block);

    }
}
