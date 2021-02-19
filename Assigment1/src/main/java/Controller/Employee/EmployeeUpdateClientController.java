package Controller.Employee;

import Controller.Controller;
import Model.Validation.Notification;
import Service.Employee.EmployeeService;
import View.Employee.EmployeeUpdateClientView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class EmployeeUpdateClientController {
    private final EmployeeUpdateClientView employeeUpdateClientView;
    private final EmployeeService employeeService;
    public EmployeeUpdateClientController(EmployeeUpdateClientView employeeUpdateClientView, EmployeeService employeeService) {
        this.employeeUpdateClientView = employeeUpdateClientView;
        this.employeeService=employeeService;
        employeeUpdateClientView.setBtnBack(new Back());
        employeeUpdateClientView.setBtnModifyAccountIdentificationNumber(new ModifyClientIdentificationNumber());
        employeeUpdateClientView.setBtnModifyAddress(new ModifyAddress());
        employeeUpdateClientView.setBtnModifyIdentityCardNumber(new ModifyIdentityCardNumber());
        employeeUpdateClientView.setBtnModifyName(new ModifyName());
        employeeUpdateClientView.setBtnModifyPersonalNumericCode(new ModifyPersonalNumericCode());
    }

    public EmployeeUpdateClientView getEmployeeUpdateClientView() {
        return employeeUpdateClientView;
    }

    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(true);
            Controller.getEmployeeUpdateClientController().getEmployeeUpdateClientView().setVisible(false);
        }
    }

    private class ModifyClientIdentificationNumber implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String clientIdentificationNumber = employeeUpdateClientView.getTfAccountIdentificationNumber();
            String selectPersonalNumericCode = employeeUpdateClientView.getTfSelectPersonalNumericCode();
            Notification<Boolean> modifyClientIdentificationNumber = null;
            modifyClientIdentificationNumber = employeeService.changeClientAccountIdentificationNumber(selectPersonalNumericCode,clientIdentificationNumber);
            if(modifyClientIdentificationNumber != null){
                if (modifyClientIdentificationNumber.hasErrors()) {
                    JOptionPane.showMessageDialog(employeeUpdateClientView.getContentPane(), modifyClientIdentificationNumber.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(employeeUpdateClientView.getContentPane(), "Client identification number modified successfully!");
                }
            }
        }
    }

    private class ModifyAddress implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String address = employeeUpdateClientView.getTfAddress();
            String selectPersonalNumericCode = employeeUpdateClientView.getTfSelectPersonalNumericCode();
            Notification<Boolean> modifyAddress = null;
            modifyAddress = employeeService.changeClientAddress(selectPersonalNumericCode,address);
            if(modifyAddress != null){
                if (modifyAddress.hasErrors()) {
                    JOptionPane.showMessageDialog(employeeUpdateClientView.getContentPane(), modifyAddress.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(employeeUpdateClientView.getContentPane(), "Client address modified successfully!");
                }
            }
        }
    }

    private class ModifyIdentityCardNumber implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String identityCardNumber = employeeUpdateClientView.getTfIdentityCardNumber();
            String selectPersonalNumericCode = employeeUpdateClientView.getTfSelectPersonalNumericCode();
            Notification<Boolean> modifyIdentityCardNumber = null;
            modifyIdentityCardNumber = employeeService.changeClientIdentityCardNumber(selectPersonalNumericCode,identityCardNumber);
            if(modifyIdentityCardNumber != null){
                if (modifyIdentityCardNumber.hasErrors()) {
                    JOptionPane.showMessageDialog(employeeUpdateClientView.getContentPane(), modifyIdentityCardNumber.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(employeeUpdateClientView.getContentPane(), "Client identity card number modified successfully!");
                }
            }
        }
    }

    private class ModifyName implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = employeeUpdateClientView.getTfName();
            String selectPersonalNumericCode = employeeUpdateClientView.getTfSelectPersonalNumericCode();
            Notification<Boolean> modifyName = null;
            modifyName = employeeService.changeClientName(selectPersonalNumericCode,name);
            if(modifyName != null){
                if (modifyName.hasErrors()) {
                    JOptionPane.showMessageDialog(employeeUpdateClientView.getContentPane(), modifyName.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(employeeUpdateClientView.getContentPane(), "Client name modified successfully!");
                }
            }
        }
    }

    private class ModifyPersonalNumericCode implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String personalNumericCode = employeeUpdateClientView.getTfPersonalNumericCode();
            String selectPersonalNumericCode = employeeUpdateClientView.getTfSelectPersonalNumericCode();
            Notification<Boolean> modifyPersonalNumericCode = null;
            modifyPersonalNumericCode = employeeService.changeClientPersonalNumericCode(selectPersonalNumericCode,personalNumericCode);
            if(modifyPersonalNumericCode != null){
                if (modifyPersonalNumericCode.hasErrors()) {
                    JOptionPane.showMessageDialog(employeeUpdateClientView.getContentPane(), modifyPersonalNumericCode.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(employeeUpdateClientView.getContentPane(), "Client personal numeric code modified successfully!");
                }
            }
        }
    }
}