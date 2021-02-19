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
public class EmployeeUpdateClientAccountController {
    private final EmployeeUpdateClientAccountView employeeUpdateClientAccountView;
    private final EmployeeService employeeService;
    public EmployeeUpdateClientAccountController(EmployeeUpdateClientAccountView employeeUpdateClientAccountView, EmployeeService employeeService) {
        this.employeeUpdateClientAccountView = employeeUpdateClientAccountView;
        this.employeeService=employeeService;
        employeeUpdateClientAccountView.setBtnBack(new Back());
        employeeUpdateClientAccountView.setBtnChangeAccountIdentificationNumber(new ChangeAccountIdentificationNumber());
        employeeUpdateClientAccountView.setBtnChangeDate(new ChangeDate());
        employeeUpdateClientAccountView.setBtnChangeMoney(new ChangeMoney());
        employeeUpdateClientAccountView.setBtnChangeType(new ChangeType());
    }

    public EmployeeUpdateClientAccountView getEmployeeUpdateClientAccountView() {
        return employeeUpdateClientAccountView;
    }

    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(true);
            Controller.getEmployeeUpdateClientAccountController().getEmployeeUpdateClientAccountView().setVisible(false);
        }
    }

    private class ChangeAccountIdentificationNumber implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectAccountIdentificationNumber = employeeUpdateClientAccountView.getTfSelectAccountIdentificationNumber();
            String selectType = employeeUpdateClientAccountView.getTfSelectType();
            String accountIdentificationNumber = employeeUpdateClientAccountView.getTfAccountIdentificationNumber();
            Notification<Boolean> changeAccountIdentificationNumber = null;
            changeAccountIdentificationNumber = employeeService.changeAccountIdentificationNumber(selectAccountIdentificationNumber, selectType, accountIdentificationNumber);
            if(changeAccountIdentificationNumber != null){
                if (changeAccountIdentificationNumber.hasErrors()) {
                    JOptionPane.showMessageDialog(employeeUpdateClientAccountView.getContentPane(), changeAccountIdentificationNumber.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(employeeUpdateClientAccountView.getContentPane(), "Client account identification number modified successfully!");
                }
            }
        }
    }

    private class ChangeDate implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String date = employeeUpdateClientAccountView.getTfDate();
            String selectAccountIdentificationNumber = employeeUpdateClientAccountView.getTfSelectAccountIdentificationNumber();
            String selectType = employeeUpdateClientAccountView.getTfSelectType();
            Notification<Boolean> changeDate = null;
            changeDate = employeeService.changeAccountDate(selectAccountIdentificationNumber, selectType, date);
            if(changeDate != null){
                if (changeDate.hasErrors()) {
                    JOptionPane.showMessageDialog(employeeUpdateClientAccountView.getContentPane(), changeDate.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(employeeUpdateClientAccountView.getContentPane(), "Client account date modified successfully!");
                }
            }
        }
    }

    private class ChangeMoney implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String money = employeeUpdateClientAccountView.getTfMoney();
            String selectAccountIdentificationNumber = employeeUpdateClientAccountView.getTfSelectAccountIdentificationNumber();
            String selectType = employeeUpdateClientAccountView.getTfSelectType();
            Notification<Boolean> changeMoney = null;
            changeMoney = employeeService.changeAccountMoney(selectAccountIdentificationNumber, selectType, money);
            if(changeMoney != null){
                if (changeMoney.hasErrors()) {
                    JOptionPane.showMessageDialog(employeeUpdateClientAccountView.getContentPane(), changeMoney.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(employeeUpdateClientAccountView.getContentPane(), "Client account money modified successfully!");
                }
            }
        }
    }

    private class ChangeType implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String type = employeeUpdateClientAccountView.getTfType();
            String selectAccountIdentificationNumber = employeeUpdateClientAccountView.getTfSelectAccountIdentificationNumber();
            String selectType = employeeUpdateClientAccountView.getTfSelectType();
            Notification<Boolean> changeType = null;
            changeType = employeeService.changeAccountType(selectAccountIdentificationNumber, selectType, type);
            if(changeType != null){
                if (changeType.hasErrors()) {
                    JOptionPane.showMessageDialog(employeeUpdateClientAccountView.getContentPane(), changeType.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(employeeUpdateClientAccountView.getContentPane(), "Client account type modified successfully!");
                }
            }
        }
    }
}