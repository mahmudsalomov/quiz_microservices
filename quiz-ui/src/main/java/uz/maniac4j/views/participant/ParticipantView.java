package uz.maniac4j.views.participant;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
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
import uz.maniac4j.data.entity.Participant;
import uz.maniac4j.data.service.ParticipantService;
import uz.maniac4j.views.MainLayout;

@PageTitle("Participant")
@Route(value = "participant/:participantID?/:action?(edit)", layout = MainLayout.class)
@Uses(Icon.class)
public class ParticipantView extends Div implements BeforeEnterObserver {

    private final String PARTICIPANT_ID = "participantID";
    private final String PARTICIPANT_EDIT_ROUTE_TEMPLATE = "participant/%s/edit";

    private Grid<Participant> grid = new Grid<>(Participant.class, false);

    private TextField firstName;
    private TextField lastName;
    private TextField email;
    private TextField phone;
    private DatePicker dateOfBirth;
    private TextField username;
    private TextField password;
    private Checkbox active;

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private BeanValidationBinder<Participant> binder;

    private Participant participant;

    private final ParticipantService participantService;

    @Autowired
    public ParticipantView(ParticipantService participantService) {
        this.participantService = participantService;
        addClassNames("participant-view");

        // Create UI
        SplitLayout splitLayout = new SplitLayout();

        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);

        add(splitLayout);

        // Configure Grid
        grid.addColumn("firstName").setAutoWidth(true);
        grid.addColumn("lastName").setAutoWidth(true);
        grid.addColumn("email").setAutoWidth(true);
        grid.addColumn("phone").setAutoWidth(true);
        grid.addColumn("dateOfBirth").setAutoWidth(true);
        grid.addColumn("username").setAutoWidth(true);
        grid.addColumn("password").setAutoWidth(true);
        LitRenderer<Participant> activeRenderer = LitRenderer.<Participant>of(
                "<vaadin-icon icon='vaadin:${item.icon}' style='width: var(--lumo-icon-size-s); height: var(--lumo-icon-size-s); color: ${item.color};'></vaadin-icon>")
                .withProperty("icon", active -> active.isActive() ? "check" : "minus").withProperty("color",
                        active -> active.isActive()
                                ? "var(--lumo-primary-text-color)"
                                : "var(--lumo-disabled-text-color)");

        grid.addColumn(activeRenderer).setHeader("Active").setAutoWidth(true);

        grid.setItems(query -> participantService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);

        // when a row is selected or deselected, populate form
        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                UI.getCurrent().navigate(String.format(PARTICIPANT_EDIT_ROUTE_TEMPLATE, event.getValue().getId()));
            } else {
                clearForm();
                UI.getCurrent().navigate(ParticipantView.class);
            }
        });

        // Configure Form
        binder = new BeanValidationBinder<>(Participant.class);

        // Bind fields. This is where you'd define e.g. validation rules

        binder.bindInstanceFields(this);

        cancel.addClickListener(e -> {
            clearForm();
            refreshGrid();
        });

        save.addClickListener(e -> {
            try {
                if (this.participant == null) {
                    this.participant = new Participant();
                }
                binder.writeBean(this.participant);

                participantService.update(this.participant);
                clearForm();
                refreshGrid();
                Notification.show("Participant details stored.");
                UI.getCurrent().navigate(ParticipantView.class);
            } catch (ValidationException validationException) {
                Notification.show("An exception happened while trying to store the participant details.");
            }
        });

    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        Optional<UUID> participantId = event.getRouteParameters().get(PARTICIPANT_ID).map(UUID::fromString);
        if (participantId.isPresent()) {
            Optional<Participant> participantFromBackend = participantService.get(participantId.get());
            if (participantFromBackend.isPresent()) {
                populateForm(participantFromBackend.get());
            } else {
                Notification.show(
                        String.format("The requested participant was not found, ID = %s", participantId.get()), 3000,
                        Notification.Position.BOTTOM_START);
                // when a row is selected but the data is no longer available,
                // refresh grid
                refreshGrid();
                event.forwardTo(ParticipantView.class);
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
        firstName = new TextField("First Name");
        lastName = new TextField("Last Name");
        email = new TextField("Email");
        phone = new TextField("Phone");
        dateOfBirth = new DatePicker("Date Of Birth");
        username = new TextField("Username");
        password = new TextField("Password");
        active = new Checkbox("Active");
        Component[] fields = new Component[]{firstName, lastName, email, phone, dateOfBirth, username, password,
                active};

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

    private void populateForm(Participant value) {
        this.participant = value;
        binder.readBean(this.participant);

    }
}
