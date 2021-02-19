package Controller.Administrator;

import Controller.Controller;
import Model.Validation.Notification;
import Service.Admin.AdminService;
import View.Administrator.AdministratorAddEmployeeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class AdministratorAddEmployeeController {
    private final AdministratorAddEmployeeView administratorAddEmployeeView;
    private final AdminService adminService;

    public AdministratorAddEmployeeController(AdministratorAddEmployeeView administratorAddEmployeeView, AdminService adminService) {
        this.administratorAddEmployeeView = administratorAddEmployeeView;
        this.adminService = adminService;
        administratorAddEmployeeView.setBtnAddEmployee(new AddEmployee());
        administratorAddEmployeeView.setBtnBack(new Back());
    }

    public AdministratorAddEmployeeView getAdministratorAddEmployeeView() {
        return administratorAddEmployeeView;
    }

    private class AddEmployee implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = administratorAddEmployeeView.getTfNume();
            String username = administratorAddEmployeeView.getTfUserName();
            String password = administratorAddEmployeeView.getTfPassword();
            Notification<Boolean> addEmployee = null;
            addEmployee = adminService.addEmployee(name, username, password);
            if(addEmployee != null){
                if (addEmployee.hasErrors()) {
                    JOptionPane.showMessageDialog(administratorAddEmployeeView.getContentPane(), addEmployee.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(administratorAddEmployeeView.getContentPane(), "Employee added successfully!");
                }
            }
        }
    }

    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getAdministratorController().getAdministratorView().setVisible(true);
            Controller.getAdministratorAddEmployeeController().getAdministratorAddEmployeeView().setVisible(false);
        }
    }
}