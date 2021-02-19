package View.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;
// de completat
public class EmployeeReadClientView extends JFrame{

    private JLabel jPersonalNumericCode;
    private JTextField tfPersonalNumericCode;
    private JButton btnRead;
    private JButton btnBack;

    public EmployeeReadClientView() throws HeadlessException {
        setSize(500, 700);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(jPersonalNumericCode);
        add(tfPersonalNumericCode);
        add(btnRead);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {
        jPersonalNumericCode = new JLabel("Personal Numeric Code");
        tfPersonalNumericCode = new JTextField("Personal_Numeric_Code");
        btnRead = new JButton("Read");
        btnBack = new JButton("Back");

    }

    public void setBtnBack(ActionListener registerButtonListener) {
        btnBack.addActionListener(registerButtonListener);
    }

    public String getTfPersonalNumericCode() {
        return tfPersonalNumericCode.getText();
    }

    public void setBtnRead(ActionListener registerButtonListener) {
        btnRead.addActionListener(registerButtonListener);
    }
}
