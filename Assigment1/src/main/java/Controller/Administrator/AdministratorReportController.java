package Controller.Administrator;

import Controller.Controller;
import Model.Validation.Notification;
import Service.Admin.AdminService;
import View.Administrator.AdministratorReportView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class AdministratorReportController {
    private final AdministratorReportView administratorReportView;
    private final AdminService adminService;
    private JList<String> list;
    private ArrayList<String> employeeList;

    public AdministratorReportController(AdministratorReportView administratorGenerateReportEmployeeView, AdminService adminService) {
        this.administratorReportView = administratorGenerateReportEmployeeView;
        this.adminService = adminService;
        administratorGenerateReportEmployeeView.setBtnBack(new Back());
    }

    public AdministratorReportView getAdministratorReportView() {
        return administratorReportView;
    }

    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getAdministratorController().getAdministratorView().setVisible(true);
            Controller.getAdministratorGenerateReportEmployeeController().getAdministratorGenerateReportEmployeeView().setVisible(false);
        }
    }

    public void readData(String name, Date dateFrom, Date dateTo){
        employeeList = new ArrayList<>(1000);
        Notification<ArrayList<String>> readData = null;
        readData = adminService.printEmployeeActivityList(name,dateFrom,dateTo);
        if(readData != null){
            if (readData.hasErrors()) {
                JOptionPane.showMessageDialog(administratorReportView.getContentPane(), readData.getFormattedErrors());
            } else {
                for (String employeeListLoc : readData.getResult()) {
                    employeeList.add(employeeListLoc);
                }
                list = new JList<String>(employeeList.toArray(new String[employeeList.size()]));
                administratorReportView.getScrollPane().setViewportView(list);
                list.setLayoutOrientation(JList.VERTICAL);
            }
        }
    }
}