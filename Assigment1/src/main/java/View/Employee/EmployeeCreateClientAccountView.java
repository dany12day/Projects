package View.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;
// de completat
public class EmployeeCreateClientAccountView extends JFrame{
    private JLabel jAccountIdentificationNumber;
    private JTextField tfAccountIdentificationNumber;
    private JLabel jType;
    private JTextField tfType;
    private JLabel jMoney;
    private JTextField tfMoney;
    private JButton btnCreate;
    private JButton btnBack;

    public EmployeeCreateClientAccountView() throws HeadlessException {
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
        add(btnCreate);
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
        btnCreate = new JButton("Create");
        btnBack = new JButton("Back");

    }

    public void setBtnBack(ActionListener registerButtonListener) {
        btnBack.addActionListener(registerButtonListener);

    }
    public void setBtnCreate(ActionListener registerButtonListener) {
        btnCreate.addActionListener(registerButtonListener);
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

}
