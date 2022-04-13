package uz.maniac4j.views;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import uz.maniac4j.views.about.AboutView;
import uz.maniac4j.views.block.BlockView;
import uz.maniac4j.views.blockquizzes.BlockQuizzesView;
import uz.maniac4j.views.category.CategoryView;
import uz.maniac4j.views.participant.ParticipantView;
import uz.maniac4j.views.participantblock.ParticipantBlockView;
import uz.maniac4j.views.participantblockdetails.ParticipantBlockDetailsView;
import uz.maniac4j.views.quiz.QuizView;
import uz.maniac4j.views.settings.SettingsView;
import uz.maniac4j.views.user.UserView;
import uz.maniac4j.views.userblockdetails.UserBlockDetailsView;
import uz.maniac4j.views.usertest.UserTestView;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    /**
     * A simple navigation item component, based on ListItem element.
     */
    public static class MenuItemInfo extends ListItem {

        private final Class<? extends Component> view;

        public MenuItemInfo(String menuTitle, String iconClass, Class<? extends Component> view) {
            this.view = view;
            RouterLink link = new RouterLink();
            link.addClassNames("menu-item-link");
            link.setRoute(view);

            Span text = new Span(menuTitle);
            text.addClassNames("menu-item-text");

            link.add(new LineAwesomeIcon(iconClass), text);
            add(link);
        }

        public Class<?> getView() {
            return view;
        }

        /**
         * Simple wrapper to create icons using LineAwesome iconset. See
         * https://icons8.com/line-awesome
         */
        @NpmPackage(value = "line-awesome", version = "1.3.0")
        public static class LineAwesomeIcon extends Span {
            public LineAwesomeIcon(String lineawesomeClassnames) {
                addClassNames("menu-item-icon");
                if (!lineawesomeClassnames.isEmpty()) {
                    addClassNames(lineawesomeClassnames);
                }
            }
        }

    }

    private H1 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addToNavbar(true, createHeaderContent());
        addToDrawer(createDrawerContent());
    }

    private Component createHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.addClassNames("view-toggle");
        toggle.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        toggle.getElement().setAttribute("aria-label", "Menu toggle");

        viewTitle = new H1();
        viewTitle.addClassNames("view-title");

        Header header = new Header(toggle, viewTitle);
        header.addClassNames("view-header");
        return header;
    }

    private Component createDrawerContent() {
        H2 appName = new H2("Quiz UI");
        appName.addClassNames("app-name");

        com.vaadin.flow.component.html.Section section = new com.vaadin.flow.component.html.Section(appName,
                createNavigation(), createFooter());
        section.addClassNames("drawer-section");
        return section;
    }

    private Nav createNavigation() {
        Nav nav = new Nav();
        nav.addClassNames("menu-item-container");
        nav.getElement().setAttribute("aria-labelledby", "views");

        // Wrap the links in a list; improves accessibility
        UnorderedList list = new UnorderedList();
        list.addClassNames("navigation-list");
        nav.add(list);

        for (MenuItemInfo menuItem : createMenuItems()) {
            list.add(menuItem);

        }
        return nav;
    }

    private MenuItemInfo[] createMenuItems() {
        return new MenuItemInfo[]{ //
                new MenuItemInfo("Category", "la la-columns", CategoryView.class), //

                new MenuItemInfo("Quiz", "la la-columns", QuizView.class), //

                new MenuItemInfo("Block", "la la-columns", BlockView.class), //

                new MenuItemInfo("Block Quizzes", "la la-columns", BlockQuizzesView.class), //

                new MenuItemInfo("Participant", "la la-columns", ParticipantView.class), //

                new MenuItemInfo("Participant Block", "la la-th-list", ParticipantBlockView.class), //

                new MenuItemInfo("Participant Block Details", "la la-list", ParticipantBlockDetailsView.class), //

                new MenuItemInfo("Settings", "la la-user", SettingsView.class), //

                new MenuItemInfo("User", "la la-th-list", UserView.class), //

                new MenuItemInfo("User Block Details", "la la-list", UserBlockDetailsView.class), //

                new MenuItemInfo("User Test", "la la-file", UserTestView.class), //

                new MenuItemInfo("About", "la la-file", AboutView.class), //

        };
    }

    private Footer createFooter() {
        Footer layout = new Footer();
        layout.addClassNames("footer");

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
