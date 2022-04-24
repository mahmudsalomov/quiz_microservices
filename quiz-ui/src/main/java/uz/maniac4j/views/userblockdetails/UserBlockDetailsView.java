package uz.maniac4j.views.userblockdetails;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import uz.maniac4j.views.MainLayout;

@PageTitle("User Block Details")
@Route(value = "user-block-details", layout = MainLayout.class)
public class UserBlockDetailsView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    public UserBlockDetailsView() {
        name = new TextField("Your name");
        sayHello = new Button("Say hello");
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);

        add(name, sayHello);
    }

}
