package Controller.Administrator;

import Controller.Controller;
import Model.Validation.Notification;
import Service.Admin.AdminService;
import View.Administrator.AdministratorDeleteEmployeeView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class AdministratorDeleteEmployeeController {
    private final AdministratorDeleteEmployeeView administratorDeleteEmployeeView;
    private final AdminService adminService;

    public AdministratorDeleteEmployeeController(AdministratorDeleteEmployeeView administratorDeleteEmployeeView, AdminService adminService) {
        this.administratorDeleteEmployeeView = administratorDeleteEmployeeView;
        this.adminService = adminService;
        administratorDeleteEmployeeView.setBtnBack(new Back());
        administratorDeleteEmployeeView.setBtnDelete(new DeleteEmployee());
    }

    public AdministratorDeleteEmployeeView getAdministratorDeleteEmployeeView() {
        return administratorDeleteEmployeeView;
    }

    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getAdministratorController().getAdministratorView().setVisible(true);
            Controller.getAdministratorDeleteEmployeeController().getAdministratorDeleteEmployeeView().setVisible(false);
        }
    }

    private class DeleteEmployee implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = administratorDeleteEmployeeView.getUserName();
            String password = administratorDeleteEmployeeView.getPassword();
            Notification<Boolean> deleteEmployee = null;
            deleteEmployee = adminService.deleteEmployee(username, password );
            if(deleteEmployee != null){
                if (deleteEmployee.hasErrors()) {
                    JOptionPane.showMessageDialog(administratorDeleteEmployeeView.getContentPane(), deleteEmployee.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(administratorDeleteEmployeeView.getContentPane(), "Employee deleted successfully!");
                }
            }
        }
    }

}