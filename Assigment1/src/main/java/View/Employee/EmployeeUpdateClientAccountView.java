package View.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;
// de completat
public class EmployeeUpdateClientAccountView extends JFrame{
    private JLabel jChoseAccount;
    private JLabel jSelectAccountIdentificationNumber;
    private JTextField tfSelectAccountIdentificationNumber;
    private JLabel jSelectType;
    private JTextField tfSelectType;
    private JLabel jModify;
    private JLabel jAccountIdentificationNumber;
    private JTextField tfAccountIdentificationNumber;
    private JButton btnChangeAccountIdentificationNumber;
    private JLabel jType;
    private JTextField tfType;
    private JButton btnChangeType;
    private JLabel jMoney;
    private JTextField tfMoney;
    private JButton btnChangeMoney;
    private JLabel jDate;
    private JTextField tfDate;
    private JButton btnChangeDate;
    private JButton btnBack;

    public EmployeeUpdateClientAccountView() throws HeadlessException {
        setSize(500, 700);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(jChoseAccount);
        add(jSelectAccountIdentificationNumber);
        add(tfSelectAccountIdentificationNumber);
        add(jSelectType);
        add(tfSelectType);
        add(jModify);
        add(jAccountIdentificationNumber);
        add(tfAccountIdentificationNumber);
        add(btnChangeAccountIdentificationNumber);
        add(jType);
        add(tfType);
        add(btnChangeType);
        add(jMoney);
        add(tfMoney);
        add(btnChangeMoney);
        add(jDate);
        add(tfDate);
        add(btnChangeDate);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        jChoseAccount = new JLabel("Chose Account");
        jSelectAccountIdentificationNumber = new JLabel("Select Account Identification Number");
        tfSelectAccountIdentificationNumber = new JTextField("Select_Account_Identification_Number");
        jSelectType = new JLabel("Select Type");
        tfSelectType = new JTextField("Select Type");
        jModify = new JLabel("Modify");
        jAccountIdentificationNumber = new JLabel("Account Identification Number");
        tfAccountIdentificationNumber = new JTextField("Account_Identification_Number");
        btnChangeAccountIdentificationNumber = new JButton("Change Account Identification Number");
        jType = new JLabel("Type");
        tfType = new JTextField("Type");
        btnChangeType = new JButton("Change Type");
        jMoney = new JLabel("Money");
        tfMoney = new JTextField("Money");
        btnChangeMoney = new JButton("Change Money");
        jDate = new JLabel("Date");
        tfDate = new JTextField("Date");
        btnChangeDate = new JButton("Change Date");
        btnBack = new JButton("Back");

    }

    public void setBtnChangeAccountIdentificationNumber(ActionListener registerButtonListener) {
        btnChangeAccountIdentificationNumber.addActionListener(registerButtonListener);
    }

    public void setBtnChangeMoney(ActionListener registerButtonListener) {
        btnChangeMoney.addActionListener(registerButtonListener);
    }

    public void setBtnChangeType(ActionListener registerButtonListener) {
        btnChangeType.addActionListener(registerButtonListener);
    }

    public void setBtnChangeDate(ActionListener registerButtonListener) {
        btnChangeDate.addActionListener(registerButtonListener);
    }

    public void setBtnBack(ActionListener registerButtonListener) {
        btnBack.addActionListener(registerButtonListener);
    }

    public String getTfSelectAccountIdentificationNumber() {
        return tfSelectAccountIdentificationNumber.getText();
    }

    public String getTfSelectType() {
        return tfSelectType.getText();
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

    public String getTfDate() {
        return tfDate.getText();
    }
}
