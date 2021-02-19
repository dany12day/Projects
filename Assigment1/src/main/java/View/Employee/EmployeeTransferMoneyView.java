package View.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;
// de completat
public class EmployeeTransferMoneyView extends JFrame{
    private JLabel jAccountIdentificationNumber;
    private JTextField tfAccountIdentificationNumber;
    private JLabel jType;
    private JTextField tfType;
    private JLabel jMoney;
    private JTextField tfMoney;
    private JLabel jTargetAccountIdentificationNumber;
    private JTextField tfTargetAccountIdentificationNumber;
    private JLabel jTargetAccountType;
    private JTextField tfTargetAccountType;
    private JButton btnTransfer;
    private JButton btnBack;

    public EmployeeTransferMoneyView() throws HeadlessException {
        setSize(500, 700);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(jAccountIdentificationNumber);
        add(tfAccountIdentificationNumber);
        add(jType);
        add(tfType);
        add(jMoney);
        add(tfMoney);
        add(jTargetAccountIdentificationNumber);
        add(tfTargetAccountIdentificationNumber);
        add(jTargetAccountType);
        add(tfTargetAccountType);
        add(btnTransfer);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        jAccountIdentificationNumber = new JLabel("Account Identification Number");
        tfAccountIdentificationNumber = new JTextField("Account_Identification_Number");
        jType = new JLabel("Type");
        tfType = new JTextField("Type");
        jMoney = new JLabel("Money");
        tfMoney = new JTextField("Money");
        jTargetAccountIdentificationNumber = new JLabel("Target Account Identification Number");
        tfTargetAccountIdentificationNumber = new JTextField("Target_Account_Identification_Number");
        jTargetAccountType = new JLabel("Target Account Type");
        tfTargetAccountType = new JTextField("Target_Account_Type");
        btnTransfer = new JButton("Transfer");
        btnBack = new JButton("Back");

    }

    public void setBtnBack(ActionListener registerButtonListener) {
        btnBack.addActionListener(registerButtonListener);
    }
    public void setBtnTransfer(ActionListener registerButtonListener) {
        btnTransfer.addActionListener(registerButtonListener);
    }

    public String getTfAccountIdentificationNumber() {
        return tfAccountIdentificationNumber.getText();
    }

    public String getTfType() {
        return tfType.getText();
    }

    public String getTfMoney() {
        return tfMoney.getText();
    }

    public String getTfTargetAccountIdentificationNumber() {
        return tfTargetAccountIdentificationNumber.getText();
    }

    public String getTfTargetAccountType() {
        return tfTargetAccountType.getText();
    }
}
