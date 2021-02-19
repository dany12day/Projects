package Controller.Employee;

import Controller.Controller;
import Model.Validation.Notification;
import Service.Employee.EmployeeService;
import View.Employee.EmployeePayBillView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class EmployeePayBillController {
    private final EmployeePayBillView employeePayBillView;
    private final EmployeeService employeeService;
    public EmployeePayBillController(EmployeePayBillView employeePayBillView, EmployeeService employeeService) {
        this.employeePayBillView = employeePayBillView;
        this.employeeService=employeeService;
        employeePayBillView.setBtnBack(new Back());
        employeePayBillView.setBtnPay(new Pay());
    }

    public EmployeePayBillView getEmployeePayBillView() {
        return employeePayBillView;
    }

    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(true);
            Controller.getEmployeePayBillController().getEmployeePayBillView().setVisible(false);
        }
    }

    private class Pay implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String accountIdentificationNumber = employeePayBillView.getTfAccountIdentificationNumber();
            String type = employeePayBillView.getTfType();
            String money = employeePayBillView.getTfMoney();
            String pay = employeePayBillView.getTfTarget();
            Notification<Boolean> payN = null;
            payN = employeeService.pay(accountIdentificationNumber,type,money,pay);
            if(payN != null){
                if (payN.hasErrors()) {
                    JOptionPane.showMessageDialog(employeePayBillView.getContentPane(), payN.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(employeePayBillView.getContentPane(), "Payment done successfully!");
                }
            }
        }
    }
}