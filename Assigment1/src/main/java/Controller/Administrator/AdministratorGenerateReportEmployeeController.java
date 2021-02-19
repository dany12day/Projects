package Controller.Administrator;

import Controller.Controller;
import Service.Admin.AdminService;
import View.Administrator.AdministratorGenerateReportEmployeeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class AdministratorGenerateReportEmployeeController {
    private final AdministratorGenerateReportEmployeeView administratorGenerateReportEmployeeView;
    private final AdminService adminService;

    public AdministratorGenerateReportEmployeeController(AdministratorGenerateReportEmployeeView administratorGenerateReportEmployeeView, AdminService adminService) {
        this.administratorGenerateReportEmployeeView = administratorGenerateReportEmployeeView;
        this.adminService = adminService;
        administratorGenerateReportEmployeeView.setBtnBack(new Back());
        administratorGenerateReportEmployeeView.setBtnSearch(new Search());
    }

    public AdministratorGenerateReportEmployeeView getAdministratorGenerateReportEmployeeView() {
        return administratorGenerateReportEmployeeView;
    }


    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getAdministratorReportController().getAdministratorReportView().setVisible(false);
            Controller.getAdministratorGenerateReportEmployeeController().getAdministratorGenerateReportEmployeeView().setVisible(true);
        }
    }

    private class Search implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getAdministratorReportController().readData(administratorGenerateReportEmployeeView.getTfSelectEmployee(), Date.valueOf(administratorGenerateReportEmployeeView.getTfDateFrom()), Date.valueOf(administratorGenerateReportEmployeeView.getTfDateTo()));
            Controller.getAdministratorReportController().getAdministratorReportView().setVisible(true);
            Controller.getAdministratorGenerateReportEmployeeController().getAdministratorGenerateReportEmployeeView().setVisible(false);
        }
    }
}