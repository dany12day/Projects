package Controller.Employee;

import Controller.Controller;
import Model.Validation.Notification;
import Service.Employee.EmployeeService;
import View.Employee.EmployeeReadClientAccountView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class EmployeeReadClientAccountController {
    private final EmployeeReadClientAccountView employeeReadClientAccountView;
    private final EmployeeService employeeService;
    public EmployeeReadClientAccountController(EmployeeReadClientAccountView employeeReadClientAccountView, EmployeeService employeeService) {
        this.employeeReadClientAccountView = employeeReadClientAccountView;
        this.employeeService=employeeService;
        employeeReadClientAccountView.setBtnBack(new Back());
        employeeReadClientAccountView.setBtnRead(new Read());
    }

    public EmployeeReadClientAccountView getEmployeeReadClientAccountView() {
        return employeeReadClientAccountView;
    }

    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(true);
            Controller.getEmployeeReadClientAccountController().getEmployeeReadClientAccountView().setVisible(false);
        }
    }

    private class Read implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String accountIdentificationNumber = employeeReadClientAccountView.getTfAccountIdentificationNumber();
            String type = employeeReadClientAccountView.getTfType();
            Notification<String> read = null;
            read = employeeService.readClientAccount(accountIdentificationNumber, type);
            if(read != null){
                if (read.hasErrors()) {
                    JOptionPane.showMessageDialog(employeeReadClientAccountView.getContentPane(), read.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(employeeReadClientAccountView.getContentPane(), read.getResult());
                }
            }
        }
    }
}