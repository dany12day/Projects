package Controller.Administrator;

import Controller.Controller;
import Model.Validation.Notification;
import Service.Admin.AdminService;
import Service.User.AuthenticationService;
import View.Administrator.AdministratorUpdateEmployeeView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class AdministratorUpdateEmployeeController {
    private final AdministratorUpdateEmployeeView administratorUpdateEmployeeView;
    private final AdminService adminService;
    private final AuthenticationService authenticationService;

    public AdministratorUpdateEmployeeController(AdministratorUpdateEmployeeView administratorUpdateEmployeeView, AdminService adminService, AuthenticationService authenticationService) {
        this.administratorUpdateEmployeeView = administratorUpdateEmployeeView;
        this.adminService = adminService;
        this.authenticationService =authenticationService ;
        administratorUpdateEmployeeView.setBtnNewName(new NewName());
        administratorUpdateEmployeeView.setBtnNewUserName(new NewUserName());
        administratorUpdateEmployeeView.setBtnNewPassword(new NewPassword());
        administratorUpdateEmployeeView.setBtnBack(new Back());
    }

    public AdministratorUpdateEmployeeView getAdministratorUpdateEmployeeView() {
        return administratorUpdateEmployeeView;
    }

    private class NewName implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = administratorUpdateEmployeeView.getNewName();
            String username = administratorUpdateEmployeeView.getUserName();
            String password = administratorUpdateEmployeeView.getPassword();
            Notification<Boolean> newName = null;
            newName = adminService.updateName(username, password , name);
            if(newName != null){
                if (newName.hasErrors()) {
                    JOptionPane.showMessageDialog(administratorUpdateEmployeeView.getContentPane(), newName.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(administratorUpdateEmployeeView.getContentPane(), "Employee name modified successfully!");
                }
            }
        }
    }

    private class NewUserName implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String newUsername = administratorUpdateEmployeeView.getNewUserName();
            String username = administratorUpdateEmployeeView.getUserName();
            String password = administratorUpdateEmployeeView.getPassword();
            Notification<Boolean> newUserName = null;
            newUserName = authenticationService.UpdateUsername(username, password , newUsername);
            if(newUserName != null){
                if (newUserName.hasErrors()) {
                    JOptionPane.showMessageDialog(administratorUpdateEmployeeView.getContentPane(), newUserName.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(administratorUpdateEmployeeView.getContentPane(), "Employee username modified successfully!");
                }
            }
        }
    }

    private class NewPassword implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String newPassword = administratorUpdateEmployeeView.getNewPassword();
            String username = administratorUpdateEmployeeView.getUserName();
            String password = administratorUpdateEmployeeView.getPassword();
            Notification<Boolean> newPasswordN = null;
            newPasswordN = authenticationService.UpdatePassword(username, password , newPassword);
            if(newPasswordN != null){
                if (newPasswordN.hasErrors()) {
                    JOptionPane.showMessageDialog(administratorUpdateEmployeeView.getContentPane(), newPasswordN.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(administratorUpdateEmployeeView.getContentPane(), "Employee password modified successfully!");
                }
            }
        }
    }

    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getAdministratorController().getAdministratorView().setVisible(true);
            Controller.getAdministratorUpdateEmployeeController().getAdministratorUpdateEmployeeView().setVisible(false);
        }
    }
}