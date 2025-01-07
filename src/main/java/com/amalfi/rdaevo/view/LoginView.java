package com.amalfi.rdaevo.view;

import com.amalfi.rdaevo.dto.LoginDTO;
import com.amalfi.rdaevo.dto.UserLoggedDTO;
import com.amalfi.rdaevo.model.Utenti;
import com.amalfi.rdaevo.model.UtenzaView;
import com.amalfi.rdaevo.service.DTOServiceResult;
import com.amalfi.rdaevo.service.UtentiService;
import com.amalfi.rdaevo.service.UtenzeService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Route("login")
@PageTitle("Login | Vaadin CRM")
public class LoginView extends VerticalLayout {

    private TextField usernameField = new TextField("Username");
    private PasswordField passwordField = new PasswordField("Password");
    private Button loginButton = new Button("Login");

    Button saveButton;

    Dialog dialog;

    @Autowired
    UtentiService userService;

    @Autowired
    UtenzeService utenzeService;

    private String livelloScelto;

    public LoginView() {
        createLoginForm();
    }

    private void createLoginForm() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        add(new H1("Login"), usernameField, passwordField, loginButton);

        loginButton.addClickListener(event -> {
            String username = usernameField.getValue();
            String password = passwordField.getValue();
            try {
                // Replace with your actual authentication logic
                DTOServiceResult<UserLoggedDTO> uDtop = authenticate(username, password);
                Utenti u = uDtop.getData().getUtente();
                if (u != null) {
                    Notification.show("Login successful!");
                    // Redirect to the main view or another view
                    HttpServletRequest request = (HttpServletRequest) VaadinService.getCurrentRequest();
                    request.getSession().setAttribute("username", u.getEmail());
                    //getUI().ifPresent(ui -> ui.navigate("/"));
                    List<UtenzaView> utenze = uDtop.getData().getUtenzeLivelli();
                    creaPopup(utenze);
                } else {
                    Notification.show(uDtop.getMessage().getTexts().toString(), 3000, Notification.Position.MIDDLE);
                    passwordField.setValue("");
                }
            } catch (UnsupportedEncodingException e) {

                Notification.show("Invalid username or password.", 3000, Notification.Position.MIDDLE);
                passwordField.setValue("");
            } catch (NoSuchAlgorithmException e) {
                Notification.show("Invalid username or password.", 3000, Notification.Position.MIDDLE);
                passwordField.setValue("");
            }
        });
    }


    private void creaPopup(List<UtenzaView> utenze) {
        dialog = new Dialog();

        dialog.setHeaderTitle("Scegli Livello Utenza");

        VerticalLayout dialogLayout = createDialogLayout(utenze);
        dialog.add(dialogLayout);

        saveButton = new Button("Save", event -> {

            HttpServletRequest request = (HttpServletRequest) VaadinService.getCurrentRequest();
            request.getSession().setAttribute("livello", livelloScelto);
            dialog.close();
            getUI().ifPresent(ui -> ui.navigate("/"));
        });
        Button cancelButton = new Button("Chiudi", e -> dialog.close());
        saveButton.setEnabled(false);
        dialog.getFooter().add(cancelButton);
        dialog.getFooter().add(saveButton);
        dialog.open();

    }

    private VerticalLayout createDialogLayout(List<UtenzaView> utenze) {

        ComboBox<String> combo = new ComboBox<>("Tipologia Utenza Login");

        List<String> livelli = new ArrayList<>(0);
        for(UtenzaView u : utenze) {
            livelli.add(u.getLivello() + " - " + u.getDescrizione());
        }
        combo.setItems(livelli);
        combo.setAllowCustomValue(true);
        combo.addValueChangeListener(event -> {
            this.livelloScelto = combo.getValue();
            saveButton.setEnabled(true);

        });

        VerticalLayout dialogLayout = new VerticalLayout(combo);
        dialogLayout.setPadding(false);
        dialogLayout.setSpacing(false);
        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        dialogLayout.getStyle().set("width", "18rem").set("max-width", "100%");

        return dialogLayout;
    }

    // **Example of a simple authentication method**
    private DTOServiceResult<UserLoggedDTO> authenticate(String username, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail(username);
        loginDTO.setPassword(password);
        return userService.login(loginDTO);

    }
}