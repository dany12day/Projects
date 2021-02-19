package Controller.Employee;

import Controller.Controller;
import Model.Validation.Notification;
import Service.Employee.EmployeeService;
import View.Employee.EmployeeReadClientView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class EmployeeReadClientController {
    private final EmployeeReadClientView employeeReadClientView;
    private final EmployeeService employeeService;
    public EmployeeReadClientController(EmployeeReadClientView employeeReadClientView, EmployeeService employeeService) {
        this.employeeReadClientView = employeeReadClientView;
        this.employeeService=employeeService;
        employeeReadClientView.setBtnBack(new Back());
        employeeReadClientView.setBtnRead(new Read());
    }

    public EmployeeReadClientView getEmployeeReadClientView() {
        return employeeReadClientView;
    }

    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(true);
            Controller.getEmployeeReadClientController().getEmployeeReadClientView().setVisible(false);
        }
    }

    private class Read implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String personalNumericCode = employeeReadClientView.getTfPersonalNumericCode();
            Notification<String> read = null;
            read = employeeService.readClient(personalNumericCode);
            if(read != null){
                if (read.hasErrors()) {
                    JOptionPane.showMessageDialog(employeeReadClientView.getContentPane(), read.getFormattedErrors());
                } else {
                    JOptionPane.showMessageDialog(employeeReadClientView.getContentPane(), read.getResult());
                }
            }
        }
    }
}