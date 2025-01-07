package com.amalfi.rdaevo.view;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import jakarta.servlet.http.HttpServletRequest;

@Route
public class MainView extends VerticalLayout implements BeforeEnterObserver {

    String username;
    String livello;

    public MainView() {

        HttpServletRequest request = (HttpServletRequest) VaadinService.getCurrentRequest();
        this.username = (String) request.getSession().getAttribute("username");
        this.livello = (String) request.getSession().getAttribute("livello");
    }


    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        //Notification.show("User not logged! Please login...", 2000, Notification.Position.MIDDLE);
        if (username == null) {
            // UI.getCurrent().navigate("/login");
            event.forwardTo("/login");
        } else {
            VerticalLayout todosList = new VerticalLayout();
            TextField taskField = new TextField();
            Button addButton = new Button("Add");
            addButton.addClickListener(click -> {
                Checkbox checkbox = new Checkbox(taskField.getValue());
                todosList.add(checkbox);
            });
            addButton.addClickShortcut(Key.ENTER);

            add(
                    new H1("Benvenuto " + username + " , livello : " + livello),
                    todosList,
                    new HorizontalLayout(
                            taskField,
                            addButton
                    )
            );
        }
    }

}