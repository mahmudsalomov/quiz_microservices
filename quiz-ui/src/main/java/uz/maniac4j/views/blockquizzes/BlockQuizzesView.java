package uz.maniac4j.views.blockquizzes;

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
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import uz.maniac4j.data.entity.Quiz;
import uz.maniac4j.data.service.QuizService;
import uz.maniac4j.views.MainLayout;

@PageTitle("Block Quizzes")
@Route(value = "block-quizzes/:quizID?/:action?(edit)", layout = MainLayout.class)
public class BlockQuizzesView extends Div implements BeforeEnterObserver {

    private final String QUIZ_ID = "quizID";
    private final String QUIZ_EDIT_ROUTE_TEMPLATE = "block-quizzes/%s/edit";

    private Grid<Quiz> grid = new Grid<>(Quiz.class, false);

    private TextField text;
    private TextField answerFirst;
    private TextField answerSecond;
    private TextField answerThird;
    private TextField answerFourth;
    private TextField rate;
    private TextField rightAnswer;
    private TextField category;

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private BeanValidationBinder<Quiz> binder;

    private Quiz quiz;

    private final QuizService quizService;

    @Autowired
    public BlockQuizzesView(QuizService quizService) {
        this.quizService = quizService;
        addClassNames("block-quizzes-view");

        // Create UI
        SplitLayout splitLayout = new SplitLayout();

        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);

        add(splitLayout);

        // Configure Grid
        grid.addColumn("text").setAutoWidth(true);
        grid.addColumn("answerFirst").setAutoWidth(true);
        grid.addColumn("answerSecond").setAutoWidth(true);
        grid.addColumn("answerThird").setAutoWidth(true);
        grid.addColumn("answerFourth").setAutoWidth(true);
        grid.addColumn("rate").setAutoWidth(true);
        grid.addColumn("rightAnswer").setAutoWidth(true);
        grid.addColumn("category").setAutoWidth(true);
        grid.setItems(query -> quizService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);

        // when a row is selected or deselected, populate form
        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                UI.getCurrent().navigate(String.format(QUIZ_EDIT_ROUTE_TEMPLATE, event.getValue().getId()));
            } else {
                clearForm();
                UI.getCurrent().navigate(BlockQuizzesView.class);
            }
        });

        // Configure Form
        binder = new BeanValidationBinder<>(Quiz.class);

        // Bind fields. This is where you'd define e.g. validation rules
        binder.forField(rate).withConverter(new StringToIntegerConverter("Only numbers are allowed")).bind("rate");

        binder.bindInstanceFields(this);

        cancel.addClickListener(e -> {
            clearForm();
            refreshGrid();
        });

        save.addClickListener(e -> {
            try {
                if (this.quiz == null) {
                    this.quiz = new Quiz();
                }
                binder.writeBean(this.quiz);

                quizService.update(this.quiz);
                clearForm();
                refreshGrid();
                Notification.show("Quiz details stored.");
                UI.getCurrent().navigate(BlockQuizzesView.class);
            } catch (ValidationException validationException) {
                Notification.show("An exception happened while trying to store the quiz details.");
            }
        });

    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        Optional<UUID> quizId = event.getRouteParameters().get(QUIZ_ID).map(UUID::fromString);
        if (quizId.isPresent()) {
            Optional<Quiz> quizFromBackend = quizService.get(quizId.get());
            if (quizFromBackend.isPresent()) {
                populateForm(quizFromBackend.get());
            } else {
                Notification.show(String.format("The requested quiz was not found, ID = %s", quizId.get()), 3000,
                        Notification.Position.BOTTOM_START);
                // when a row is selected but the data is no longer available,
                // refresh grid
                refreshGrid();
                event.forwardTo(BlockQuizzesView.class);
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
        text = new TextField("Text");
        answerFirst = new TextField("Answer First");
        answerSecond = new TextField("Answer Second");
        answerThird = new TextField("Answer Third");
        answerFourth = new TextField("Answer Fourth");
        rate = new TextField("Rate");
        rightAnswer = new TextField("Right Answer");
        category = new TextField("Category");
        Component[] fields = new Component[]{text, answerFirst, answerSecond, answerThird, answerFourth, rate,
                rightAnswer, category};

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

    private void populateForm(Quiz value) {
        this.quiz = value;
        binder.readBean(this.quiz);

    }
}
