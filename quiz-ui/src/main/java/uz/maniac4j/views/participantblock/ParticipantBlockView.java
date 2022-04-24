package uz.maniac4j.views.participantblock;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
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
import java.time.Duration;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import uz.maniac4j.data.entity.ParticipantBlock;
import uz.maniac4j.data.service.ParticipantBlockService;
import uz.maniac4j.views.MainLayout;

@PageTitle("Participant Block")
@Route(value = "participant-block/:participantBlockID?/:action?(edit)", layout = MainLayout.class)
@Uses(Icon.class)
public class ParticipantBlockView extends Div implements BeforeEnterObserver {

    private final String PARTICIPANTBLOCK_ID = "participantBlockID";
    private final String PARTICIPANTBLOCK_EDIT_ROUTE_TEMPLATE = "participant-block/%s/edit";

    private Grid<ParticipantBlock> grid = new Grid<>(ParticipantBlock.class, false);

    private TextField description;
    private TextField block;
    private DateTimePicker startDate;
    private DateTimePicker endDate;
    private TextField status;
    private TextField result;
    private Checkbox access;

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private BeanValidationBinder<ParticipantBlock> binder;

    private ParticipantBlock participantBlock;

    private final ParticipantBlockService participantBlockService;

    @Autowired
    public ParticipantBlockView(ParticipantBlockService participantBlockService) {
        this.participantBlockService = participantBlockService;
        addClassNames("participant-block-view");

        // Create UI
        SplitLayout splitLayout = new SplitLayout();

        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);

        add(splitLayout);

        // Configure Grid
        grid.addColumn("description").setAutoWidth(true);
        grid.addColumn("block").setAutoWidth(true);
        grid.addColumn("startDate").setAutoWidth(true);
        grid.addColumn("endDate").setAutoWidth(true);
        grid.addColumn("status").setAutoWidth(true);
        grid.addColumn("result").setAutoWidth(true);
        LitRenderer<ParticipantBlock> accessRenderer = LitRenderer.<ParticipantBlock>of(
                "<vaadin-icon icon='vaadin:${item.icon}' style='width: var(--lumo-icon-size-s); height: var(--lumo-icon-size-s); color: ${item.color};'></vaadin-icon>")
                .withProperty("icon", access -> access.isAccess() ? "check" : "minus").withProperty("color",
                        access -> access.isAccess()
                                ? "var(--lumo-primary-text-color)"
                                : "var(--lumo-disabled-text-color)");

        grid.addColumn(accessRenderer).setHeader("Access").setAutoWidth(true);

        grid.setItems(query -> participantBlockService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);

        // when a row is selected or deselected, populate form
        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                UI.getCurrent().navigate(String.format(PARTICIPANTBLOCK_EDIT_ROUTE_TEMPLATE, event.getValue().getId()));
            } else {
                clearForm();
                UI.getCurrent().navigate(ParticipantBlockView.class);
            }
        });

        // Configure Form
        binder = new BeanValidationBinder<>(ParticipantBlock.class);

        // Bind fields. This is where you'd define e.g. validation rules

        binder.bindInstanceFields(this);

        cancel.addClickListener(e -> {
            clearForm();
            refreshGrid();
        });

        save.addClickListener(e -> {
            try {
                if (this.participantBlock == null) {
                    this.participantBlock = new ParticipantBlock();
                }
                binder.writeBean(this.participantBlock);

                participantBlockService.update(this.participantBlock);
                clearForm();
                refreshGrid();
                Notification.show("ParticipantBlock details stored.");
                UI.getCurrent().navigate(ParticipantBlockView.class);
            } catch (ValidationException validationException) {
                Notification.show("An exception happened while trying to store the participantBlock details.");
            }
        });

    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        Optional<UUID> participantBlockId = event.getRouteParameters().get(PARTICIPANTBLOCK_ID).map(UUID::fromString);
        if (participantBlockId.isPresent()) {
            Optional<ParticipantBlock> participantBlockFromBackend = participantBlockService
                    .get(participantBlockId.get());
            if (participantBlockFromBackend.isPresent()) {
                populateForm(participantBlockFromBackend.get());
            } else {
                Notification.show(String.format("The requested participantBlock was not found, ID = %s",
                        participantBlockId.get()), 3000, Notification.Position.BOTTOM_START);
                // when a row is selected but the data is no longer available,
                // refresh grid
                refreshGrid();
                event.forwardTo(ParticipantBlockView.class);
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
        description = new TextField("Description");
        block = new TextField("Block");
        startDate = new DateTimePicker("Start Date");
        startDate.setStep(Duration.ofSeconds(1));
        endDate = new DateTimePicker("End Date");
        endDate.setStep(Duration.ofSeconds(1));
        status = new TextField("Status");
        result = new TextField("Result");
        access = new Checkbox("Access");
        Component[] fields = new Component[]{description, block, startDate, endDate, status, result, access};

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

    private void populateForm(ParticipantBlock value) {
        this.participantBlock = value;
        binder.readBean(this.participantBlock);

    }
}
