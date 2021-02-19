package Controller.Employee;

import Controller.Controller;
import Model.Validation.Notification;
import Service.Employee.EmployeeService;
import View.Employee.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class EmployeeTransferMoneyController {
    private final EmployeeTransferMoneyView employeeTransferMoneyView;
    private final EmployeeService employeeService;
    public EmployeeTransferMoneyController(EmployeeTransferMoneyView employeeTransferMoneyView, EmployeeService employeeService) {
        this.employeeTransferMoneyView = employeeTransferMoneyView;
        this.employeeService=employeeService;
        employeeTransferMoneyView.setBtnBack(new Back());
        employeeTransferMoneyView.setBtnTransfer(new Transfer());
    }

    public EmployeeTransferMoneyView getEmployeeTransferMoneyView() {
        return employeeTransferMoneyView;
    }

    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(true);
            Controller.getEmployeeTransferMoneyController().getEmployeeTransferMoneyView().setVisible(false);
        }
    }

    private class Transfer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String accountIdentificationNumber = employeeTransferMoneyView.getTfAccountIdentificationNumber();
            String type = employeeTransferMoneyView.getTfType();
            String money = employeeTransferMoneyView.getTfMoney();
            String targetAccountIdentificationNumber = employeeTransferMoneyView.getTfTargetAccountIdentificationNumber();
            String targetAccountType = employeeTransferMoneyView.getTfTargetAccountType();
            Notification<Boolean> transfer = null;
            transfer = employeeService.transfer(accountIdentificationNumber,type,money,targetAccountIdentificationNumber,targetAccountType);
            if(transfer != null){
                if (transfer.hasErrors()) {
                    JOptionPane.showMessageDialog(employeeTransferMoneyView.getContentPane(), transfer.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(employeeTransferMoneyView.getContentPane(), "Transfer done successfully!");
                }
            }
        }
    }
}