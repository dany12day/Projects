package Controller;

import Model.User;
import Model.Validation.Notification;
import Repository.User.AuthenticationException;
import Service.User.AuthenticationService;
import View.LoginView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class LoginController {
    private final LoginView loginView;
    private final AuthenticationService authenticationService;

    public LoginController(LoginView loginView, AuthenticationService authenticationService) {
        this.loginView = loginView;
        this.authenticationService = authenticationService;
        loginView.setLoginButtonListener(new LoginButtonListener());

    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = loginView.getUsername();
            String password = loginView.getPassword();
            Notification<User> loginNotification = null;
            try {
                loginNotification = authenticationService.login(username, password);
            } catch (AuthenticationException e1) {
                e1.printStackTrace();
            }
            if (loginNotification != null) {
                if (loginNotification.hasErrors()) {
                    JOptionPane.showMessageDialog(loginView.getContentPane(), loginNotification.getFormattedErrors());
                } else {
                    if(authenticationService.getRole(username,password).equals("administrator")) {
                        Controller.getAdministratorController().getAdministratorView().setVisible(true);
                    }
                    if(authenticationService.getRole(username,password).equals("employee")) {
                        Controller.getEmployeeController().getEmployeeView().setVisible(true);
                    }
                    Controller.getLoginController().getLoginView().setVisible(false);
                }
            }
        }
    }

    public LoginView getLoginView() {
        return loginView;
    }
}