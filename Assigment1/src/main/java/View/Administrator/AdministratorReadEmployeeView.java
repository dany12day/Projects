package View.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.BoxLayout.Y_AXIS;
// de completat
public class AdministratorReadEmployeeView extends JFrame{
    private JScrollPane scrollPane;
    private JButton btnBack;

    public AdministratorReadEmployeeView() throws HeadlessException {
        setSize(500, 700);
        setLocationRelativeTo(null);
        initializeFields();
        setLayout(new BoxLayout(getContentPane(), Y_AXIS));
        add(scrollPane);
        add(btnBack);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(false);
    }

    private void initializeFields() {

        scrollPane = new JScrollPane();


        scrollPane.setPreferredSize(new Dimension(500, 600));
        btnBack = new JButton("Back");

    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setBtnBack(ActionListener registerButtonListener) {
        btnBack.addActionListener(registerButtonListener);
    }

}
