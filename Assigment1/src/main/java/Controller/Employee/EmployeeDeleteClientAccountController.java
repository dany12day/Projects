package Controller.Employee;

import Controller.Controller;
import Model.Validation.Notification;
import Service.Employee.EmployeeService;
import View.Employee.EmployeeDeleteClientAccountView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class EmployeeDeleteClientAccountController {
    private final EmployeeDeleteClientAccountView employeeDeleteClientAccountView;
    private final EmployeeService employeeService;

    public EmployeeDeleteClientAccountController(EmployeeDeleteClientAccountView employeeDeleteClientAccountView, EmployeeService employeeService) {
        this.employeeDeleteClientAccountView = employeeDeleteClientAccountView;
        this.employeeService=employeeService;
        employeeDeleteClientAccountView.setBtnBack(new Back());
        employeeDeleteClientAccountView.setBtnDelete((new Delete()));
    }

    public EmployeeDeleteClientAccountView getEmployeeDeleteClientAccountView() {
        return employeeDeleteClientAccountView;
    }

    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(true);
            Controller.getEmployeeDeleteClientAccountController().getEmployeeDeleteClientAccountView().setVisible(false);
        }
    }

    private class Delete implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String accountIdentificationNumber = employeeDeleteClientAccountView.getTfAccountIdentificationNumber();
            String type = employeeDeleteClientAccountView.getTfType();
            Notification<Boolean> delete = null;
            delete = employeeService.deleteClientAccount(accountIdentificationNumber, type);
            if(delete != null){
                if (delete.hasErrors()) {
                    JOptionPane.showMessageDialog(employeeDeleteClientAccountView.getContentPane(), delete.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(employeeDeleteClientAccountView.getContentPane(), "Client account deleted successfully!");
                }
            }
        }
    }
}