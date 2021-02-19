package Controller.Employee;

import Controller.Controller;
import Model.Validation.Notification;
import Service.Employee.EmployeeService;
import View.Employee.EmployeeCreateClientAccountView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class EmployeeCreateClientAccountController {
    private final EmployeeCreateClientAccountView employeeCreateClientAccountView;
    private final EmployeeService employeeService;

    public EmployeeCreateClientAccountController(EmployeeCreateClientAccountView administratorGenerateReportEmployeeView, EmployeeService employeeService) {
        this.employeeCreateClientAccountView = administratorGenerateReportEmployeeView;
        this.employeeService=employeeService;
        administratorGenerateReportEmployeeView.setBtnCreate(new Crate());
        administratorGenerateReportEmployeeView.setBtnBack(new Back());
    }

    public EmployeeCreateClientAccountView getEmployeeCreateClientAccountView() {
        return employeeCreateClientAccountView;
    }

    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(true);
            Controller.getEmployeeCreateClientAccountController().getEmployeeCreateClientAccountView().setVisible(false);
        }
    }

    private class Crate implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String accountIdentificationNumber = employeeCreateClientAccountView.getTfAccountIdentificationNumber();
            String type = employeeCreateClientAccountView.getTfType();
            String money = employeeCreateClientAccountView.getTfMoney();
            LocalDate myObj = LocalDate.now();
            Notification<Boolean> crate = null;
            crate = employeeService.addClientAccount(accountIdentificationNumber, type, money, myObj);

            if(crate != null){
                if (crate.hasErrors()) {
                    JOptionPane.showMessageDialog(employeeCreateClientAccountView.getContentPane(), crate.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(employeeCreateClientAccountView.getContentPane(), "Client account created successfully!");
                }
            }
        }
    }
}