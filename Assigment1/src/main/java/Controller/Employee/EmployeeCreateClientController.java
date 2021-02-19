package Controller.Employee;

import Controller.Controller;
import Model.Validation.Notification;
import Service.Employee.EmployeeService;
import View.Employee.EmployeeCreateClientView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class EmployeeCreateClientController {
    private final EmployeeCreateClientView employeeCreateClientView;
    private final EmployeeService employeeService;

    public EmployeeCreateClientController(EmployeeCreateClientView employeeCreateClientView, EmployeeService employeeService) {
        this.employeeCreateClientView = employeeCreateClientView;
        this.employeeService=employeeService;
        employeeCreateClientView.setBtnBack(new Back());
        employeeCreateClientView.setBtnCreate(new Create());
    }

    public EmployeeCreateClientView getEmployeeCreateClientView() {
        return employeeCreateClientView;
    }

    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(true);
            Controller.getEmployeeCreateClientController().getEmployeeCreateClientView().setVisible(false);
        }
    }

    private class Create implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = employeeCreateClientView.getTfName();
            String accountIdentificationNumber = employeeCreateClientView.getTfAccountIdentificationNumber();
            String address = employeeCreateClientView.getTfAddress();
            String identityCardNumber = employeeCreateClientView.getTfIdentityCardNumber();
            String personalNumericCode = employeeCreateClientView.getTfPersonalNumericCode();
            Notification<Boolean> create = null;
            create = employeeService.addClient(name, accountIdentificationNumber, address, identityCardNumber, personalNumericCode);
            if(create != null){
                if (create.hasErrors()) {
                    JOptionPane.showMessageDialog(employeeCreateClientView.getContentPane(), create.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(employeeCreateClientView.getContentPane(), "Client added successfully!");
                }
            }
        }
    }
}