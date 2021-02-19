package View.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;
// de completat
public class EmployeeUpdateClientView extends JFrame{
    private JLabel jChoseClient;
    private JLabel jSelectPersonalNumericCode;
    private JTextField tfSelectPersonalNumericCode;
    private JLabel jModify;
    private JLabel jName;
    private JTextField tfName;
    private JButton btnModifyName;
    private JLabel jIdentityCardNumber;
    private JTextField tfIdentityCardNumber;
    private JButton btnModifyIdentityCardNumber;
    private JLabel jPersonalNumericCode;
    private JTextField tfPersonalNumericCode;
    private JButton btnModifyPersonalNumericCode;
    private JLabel jAddress;
    private JTextField tfAddress;
    private JButton btnModifyAddress;
    private JLabel jAccountIdentificationNumber;
    private JTextField tfAccountIdentificationNumber;
    private JButton btnModifyAccountIdentificationNumber;
    private JButton btnBack;

    public EmployeeUpdateClientView() throws HeadlessException {
        setSize(500, 700);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(jChoseClient);
        add(jSelectPersonalNumericCode);
        add(tfSelectPersonalNumericCode);
        add(jModify);
        add(jName);
        add(tfName);
        add(btnModifyName);
        add(jIdentityCardNumber);
        add(tfIdentityCardNumber);
        add(btnModifyIdentityCardNumber);
        add(jPersonalNumericCode);
        add(tfPersonalNumericCode);
        add(btnModifyPersonalNumericCode);
        add(jAddress);
        add(tfAddress);
        add(btnModifyAddress);
        add(jAccountIdentificationNumber);
        add(tfAccountIdentificationNumber);
        add(btnModifyAccountIdentificationNumber);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        jChoseClient = new JLabel("Chose Client");
        jSelectPersonalNumericCode = new JLabel("Select Personal Numeric Code");
        tfSelectPersonalNumericCode = new JTextField("Select Personal_Numeric_Code");
        jModify = new JLabel("Modify");
        jName = new JLabel("Name");
        tfName = new JTextField("Nmae");
        btnModifyName = new JButton("Modify Name");
        jIdentityCardNumber = new JLabel("Identity Card Number");
        tfIdentityCardNumber = new JTextField("Identity_Card_Number");
        btnModifyIdentityCardNumber = new JButton("Modify Identity CardNumber");
        jPersonalNumericCode = new JLabel("Personal Numeric Code");
        tfPersonalNumericCode = new JTextField("Personal_Numeric_Code");
        btnModifyPersonalNumericCode = new JButton("Modify Personal Numeric Code");
        jAddress = new JLabel("Address");
        tfAddress = new JTextField("Address");
        btnModifyAddress = new JButton("Modify Address");
        jAccountIdentificationNumber = new JLabel("Account Identification Number");
        tfAccountIdentificationNumber = new JTextField("Account_Identification_Number");
        btnModifyAccountIdentificationNumber = new JButton("Modify Account Identification Number");
        btnBack = new JButton("Back");

    }

    public void setBtnModifyName(ActionListener registerButtonListener) {
        btnModifyName.addActionListener(registerButtonListener);
    }

    public void setBtnModifyIdentityCardNumber(ActionListener registerButtonListener) {
        btnModifyIdentityCardNumber.addActionListener(registerButtonListener);
    }

    public void setBtnModifyPersonalNumericCode(ActionListener registerButtonListener) {
        btnModifyPersonalNumericCode.addActionListener(registerButtonListener);
    }

    public void setBtnModifyAddress(ActionListener registerButtonListener) {
        btnModifyAddress.addActionListener(registerButtonListener);
    }

    public void setBtnModifyAccountIdentificationNumber(ActionListener registerButtonListener) {
        btnModifyAccountIdentificationNumber.addActionListener(registerButtonListener);
    }

    public void setBtnBack(ActionListener registerButtonListener) {
        btnBack.addActionListener(registerButtonListener);
    }

    public String getTfSelectPersonalNumericCode() {
        return tfSelectPersonalNumericCode.getText();
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
