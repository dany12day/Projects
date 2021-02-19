package View.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;
// de completat
public class EmployeePayBillView extends JFrame{

    private JLabel jAccountIdentificationNumber;
    private JTextField tfAccountIdentificationNumber;
    private JLabel jType;
    private JTextField tfType;
    private JLabel jMoney;
    private JTextField tfMoney;
    private JLabel jTarget;
    private JTextField tfTarget;
    private JButton btnPay;
    private JButton btnBack;

    public EmployeePayBillView() throws HeadlessException {
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
        add(jTarget);
        add(tfTarget);
        add(btnPay);
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
        jTarget = new JLabel("Target");
        tfTarget = new JTextField("Target");
        btnPay = new JButton("Pay");
        btnBack = new JButton("Back");

    }

    public void setBtnBack(ActionListener registerButtonListener) {
        btnBack.addActionListener(registerButtonListener);
    }

    public void setBtnPay(ActionListener registerButtonListener) {
        btnPay.addActionListener(registerButtonListener);
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

    public String getTfTarget() {
        return tfTarget.getText();
    }
}
