package Controller.Administrator;

import Controller.Controller;
import Model.Validation.Notification;
import Service.Admin.AdminService;
import View.Administrator.AdministratorReadEmployeeView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class AdministratorReadEmployeeController {
    private final AdministratorReadEmployeeView administratorReadEmployeeView;
    private final AdminService adminService;
    private JList<String> list;
    private ArrayList<String> employeeList;

    public AdministratorReadEmployeeController(AdministratorReadEmployeeView administratorReadEmployeeView, AdminService adminService) {
        this.administratorReadEmployeeView = administratorReadEmployeeView;
        this.adminService = adminService;
        administratorReadEmployeeView.setBtnBack(new Back());
    }

    public AdministratorReadEmployeeView getAdministratorReadEmployeeView() {
        return administratorReadEmployeeView;
    }

    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getAdministratorController().getAdministratorView().setVisible(true);
            Controller.getAdministratorReadEmployeeController().getAdministratorReadEmployeeView().setVisible(false);
        }
    }

    public void readData(){
        employeeList = new ArrayList<>(100);
        Notification<ArrayList<String>> readData = null;
        readData = adminService.printEmployeeList();
        if(readData != null){
            if (readData.hasErrors()) {
                JOptionPane.showMessageDialog(administratorReadEmployeeView.getContentPane(), readData.getFormattedErrors());
            } else {
                for (String employeeListLoc : readData.getResult()) {
                    employeeList.add(employeeListLoc);
                }
                list = new JList<String>(employeeList.toArray(new String[employeeList.size()]));
                administratorReadEmployeeView.getScrollPane().setViewportView(list);
                list.setLayoutOrientation(JList.VERTICAL);
            }
        }
    }
}