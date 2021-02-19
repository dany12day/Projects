package Controller.Employee;

import Controller.Controller;
import Model.Validation.Notification;
import Service.Employee.EmployeeService;
import View.Employee.EmployeeDeleteClientView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class EmployeeDeleteClientController {
    private final EmployeeDeleteClientView employeeDeleteClientView;
    private final EmployeeService employeeService;

    public EmployeeDeleteClientController(EmployeeDeleteClientView employeeDeleteClientView, EmployeeService employeeService) {
        this.employeeDeleteClientView = employeeDeleteClientView;
        this.employeeService=employeeService;
        employeeDeleteClientView.setBtnBack(new Back());
        employeeDeleteClientView.setBtnDelete(new Delete());
    }

    public EmployeeDeleteClientView getEmployeeDeleteClientView() {
        return employeeDeleteClientView;
    }

    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(true);
            Controller.getEmployeeDeleteClientController().getEmployeeDeleteClientView().setVisible(false);
        }
    }

    private class Delete implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String personalNumericCode = employeeDeleteClientView.getTfPersonalNumericCode();
            Notification<Boolean> delete = null;
            delete = employeeService.deleteClient(personalNumericCode);
            if(delete != null){
                if (delete.hasErrors()) {
                    JOptionPane.showMessageDialog(employeeDeleteClientView.getContentPane(), delete.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(employeeDeleteClientView.getContentPane(), "Client deleted successfully!");

                }
            }
        }
    }
}