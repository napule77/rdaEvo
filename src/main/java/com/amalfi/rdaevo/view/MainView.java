package com.amalfi.rdaevo.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import jakarta.servlet.http.HttpServletRequest;

@Route
public class MainView extends VerticalLayout implements BeforeEnterObserver {

    String username;

    public MainView() {

        HttpServletRequest request = (HttpServletRequest) VaadinService.getCurrentRequest();
        this.username = (String) request.getSession().getAttribute("username");
    }


    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        //Notification.show("User not logged! Please login...", 2000, Notification.Position.MIDDLE);
        if (username == null) {
           // UI.getCurrent().navigate("/login");
            event.forwardTo("/login");
        }
    }

}