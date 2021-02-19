package View.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;
// de completat
public class EmployeeCreateClientView extends JFrame{
    private JLabel jName;
    private JTextField tfName;
    private JLabel jIdentityCardNumber;
    private JTextField tfIdentityCardNumber;
    private JLabel jPersonalNumericCode;
    private JTextField tfPersonalNumericCode;
    private JLabel jAddress;
    private JTextField tfAddress;
    private JLabel jAccountIdentificationNumber;
    private JTextField tfAccountIdentificationNumber;
    private JButton btnCreate;
    private JButton btnBack;

    public EmployeeCreateClientView() throws HeadlessException {
        setSize(500, 700);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(jName);
        add(tfName);
        add(jIdentityCardNumber);
        add(tfIdentityCardNumber);
        add(jPersonalNumericCode);
        add(tfPersonalNumericCode);
        add(jAddress);
        add(tfAddress);
        add(jAccountIdentificationNumber);
        add(tfAccountIdentificationNumber);
        add(btnCreate);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        jName = new JLabel("Name");
        tfName = new JTextField("Name");
        jIdentityCardNumber = new JLabel("Identity Card Number");
        tfIdentityCardNumber = new JTextField("Identity_Card_Number");
        jPersonalNumericCode = new JLabel("Personal Numeric Code");
        tfPersonalNumericCode = new JTextField("Personal_Numeric_Code");
        jAddress = new JLabel("Address");
        tfAddress = new JTextField("Address");
        jAccountIdentificationNumber = new JLabel("Account Identification Number");
        tfAccountIdentificationNumber = new JTextField("Account_Identification_Number");
        btnCreate = new JButton("Create");
        btnBack = new JButton("Back");

    }

    public void setBtnBack(ActionListener registerButtonListener) {
        btnBack.addActionListener(registerButtonListener);
    }

    public void setBtnCreate(ActionListener registerButtonListener) {
        btnCreate.addActionListener(registerButtonListener);
    }

    public String getTfName() {
        return tfName.getText();
    }

    public String getTfIdentityCardNumber() {
        return tfIdentityCardNumber.getText();
    }

    public String getTfPersonalNumericCode() {
        return tfPersonalNumericCode.getText();
    }

    public String getTfAddress() {
        return tfAddress.getText();
    }

    public String getTfAccountIdentificationNumber() {
        return tfAccountIdentificationNumber.getText();
    }
}
