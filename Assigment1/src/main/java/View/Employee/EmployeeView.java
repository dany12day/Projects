package View.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

/**
 * Created by Alex on 18/03/2017.
 */
public class EmployeeView extends JFrame {

    private JButton btnCreateClient;
    private JButton btnReadClient;
    private JButton btnUpdateClient;
    private JButton btnDeleteClient;
    private JButton btnCreateClientAccount;
    private JButton btnReadClientAccount;
    private JButton btnUpdateClientAccount;
    private JButton btnDeleteClientAccount;
    private JButton btnTransferMoney;
    private JButton btnPayBill;
    private JButton btnBackEmployee;

    public EmployeeView() throws HeadlessException {
        setSize(500, 700);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(btnCreateClient);
        add(btnReadClient);
        add(btnUpdateClient);
        add(btnDeleteClient);
        add(btnCreateClientAccount);
        add(btnReadClientAccount);
        add(btnUpdateClientAccount);
        add(btnDeleteClientAccount);
        add(btnTransferMoney);
        add(btnPayBill);
        add(btnBackEmployee);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        btnCreateClient = new JButton("CreateClient");
        btnReadClient = new JButton("ReadClient");
        btnUpdateClient = new JButton("UpdateClient");
        btnDeleteClient = new JButton("DeleteClient");
        btnCreateClientAccount = new JButton("CreateClientAccount");
        btnReadClientAccount = new JButton("ReadClientAccount");
        btnUpdateClientAccount = new JButton("UpdateClientAccount");
        btnDeleteClientAccount = new JButton("DeleteClientAccount");
        btnTransferMoney = new JButton("TransferMoney");
        btnPayBill = new JButton("PayBill");
        btnBackEmployee = new JButton("Back");
    }


    public void setCreateClient(ActionListener loginButtonListener) {
        btnCreateClient.addActionListener(loginButtonListener);
    }

    public void setReadClient(ActionListener registerButtonListener) {
        btnReadClient.addActionListener(registerButtonListener);
    }

    public void setUpdateClient(ActionListener loginButtonListener) {
        btnUpdateClient.addActionListener(loginButtonListener);
    }

    public void setDeleteClient(ActionListener registerButtonListener) {
        btnDeleteClient.addActionListener(registerButtonListener);
    }

    public void setCreateClientAccount(ActionListener loginButtonListener) {
        btnCreateClientAccount.addActionListener(loginButtonListener);
    }

    public void setReadClientAccount(ActionListener loginButtonListener) {
        btnReadClientAccount.addActionListener(loginButtonListener);
    }

    public void setUpdateClientAccount(ActionListener registerButtonListener) {
        btnUpdateClientAccount.addActionListener(registerButtonListener);
    }

    public void setDeleteClientAccount(ActionListener loginButtonListener) {
        btnDeleteClientAccount.addActionListener(loginButtonListener);
    }

    public void setTransferMoney(ActionListener registerButtonListener) {
        btnTransferMoney.addActionListener(registerButtonListener);
    }

    public void setPayBill(ActionListener loginButtonListener) {
        btnPayBill.addActionListener(loginButtonListener);
    }

    public void setBackEmployee(ActionListener loginButtonListener) {
        btnBackEmployee.addActionListener(loginButtonListener);
    }
}
