package Controller.Employee;

import Controller.Controller;
import View.Employee.EmployeeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class EmployeeController {
    private final EmployeeView employeeView;

    public EmployeeController(EmployeeView employeeView) {
        this.employeeView = employeeView;
        employeeView.setCreateClient(new CreateClientButtonListener());
        employeeView.setReadClient(new ReadClientButtonListener());
        employeeView.setUpdateClient(new UpdateClientButtonListener());
        employeeView.setDeleteClient(new DeleteClientButtonListener());
        employeeView.setCreateClientAccount(new CreateClientAccountButtonListener());
        employeeView.setReadClientAccount(new ReadClientAccountListener());
        employeeView.setUpdateClientAccount(new UpdateClientAccountButtonListener());
        employeeView.setDeleteClientAccount(new DeleteClientAccountButtonListener());
        employeeView.setTransferMoney(new TransferMoneyButtonListener());
        employeeView.setPayBill(new PayBillButtonListener());
        employeeView.setBackEmployee(new BackListener());
    }

    public EmployeeView getEmployeeView() {
        return employeeView;
    }

    private class CreateClientButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(false);
            Controller.getEmployeeCreateClientController().getEmployeeCreateClientView().setVisible(true);
        }
    }

    private class ReadClientButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(false);
            Controller.getEmployeeReadClientController().getEmployeeReadClientView().setVisible(true);
        }
    }

    private class UpdateClientButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(false);
            Controller.getEmployeeUpdateClientController().getEmployeeUpdateClientView().setVisible(true);
        }
    }

    private class DeleteClientButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(false);
            Controller.getEmployeeDeleteClientController().getEmployeeDeleteClientView().setVisible(true);
        }
    }

    private class CreateClientAccountButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(false);
            Controller.getEmployeeCreateClientAccountController().getEmployeeCreateClientAccountView().setVisible(true);
        }
    }

    private class ReadClientAccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(false);
            Controller.getEmployeeReadClientAccountController().getEmployeeReadClientAccountView().setVisible(true);
        }
    }

    private class UpdateClientAccountButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(false);
            Controller.getEmployeeUpdateClientAccountController().getEmployeeUpdateClientAccountView().setVisible(true);
        }
    }

    private class DeleteClientAccountButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(false);
            Controller.getEmployeeDeleteClientAccountController().getEmployeeDeleteClientAccountView().setVisible(true);
        }
    }

    private class TransferMoneyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(false);
            Controller.getEmployeeTransferMoneyController().getEmployeeTransferMoneyView().setVisible(true);
        }
    }

    private class PayBillButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(false);
            Controller.getEmployeePayBillController().getEmployeePayBillView().setVisible(true);
        }
    }

    private class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getEmployeeController().getEmployeeView().setVisible(false);
            Controller.getLoginController().getLoginView().setVisible(true);
        }
    }
}
