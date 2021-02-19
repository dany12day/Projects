package Controller.Administrator;

import Controller.Controller;
import View.Administrator.AdministratorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 18/03/2017 modified by Ghere Daniel.
 */
public class AdministratorController {
    private final AdministratorView administratorView;

    public AdministratorController(AdministratorView administratorView) {
        this.administratorView = administratorView;
        administratorView.setCreateEmployee(new CreateEmployeeListener());
        administratorView.setReadEmployee(new ReadEmployeeButtonListener());
        administratorView.setUpdateEmployee(new UpdateEmployeeButtonListener());
        administratorView.setDeleteEmployee(new DeleteEmployeeButtonListener());
        administratorView.setGenerateReportEmployee(new GenerateReportEmployeeButtonListener());
        administratorView.setbtnBackAdmin(new BackListener());
    }

    public AdministratorView getAdministratorView() {
        return administratorView;
    }

    private class CreateEmployeeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getAdministratorController().getAdministratorView().setVisible(false);
            Controller.getAdministratorAddEmployeeController().getAdministratorAddEmployeeView().setVisible(true);
        }
    }

    private class ReadEmployeeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getAdministratorReadEmployeeController().readData();
            Controller.getAdministratorController().getAdministratorView().setVisible(false);
            Controller.getAdministratorReadEmployeeController().getAdministratorReadEmployeeView().setVisible(true);
        }
    }

    private class UpdateEmployeeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getAdministratorController().getAdministratorView().setVisible(false);
            Controller.getAdministratorUpdateEmployeeController().getAdministratorUpdateEmployeeView().setVisible(true);
        }
    }

    private class DeleteEmployeeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getAdministratorController().getAdministratorView().setVisible(false);
            Controller.getAdministratorDeleteEmployeeController().getAdministratorDeleteEmployeeView().setVisible(true);
        }
    }

    private class GenerateReportEmployeeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getAdministratorController().getAdministratorView().setVisible(false);
            Controller.getAdministratorGenerateReportEmployeeController().getAdministratorGenerateReportEmployeeView().setVisible(true);
        }
    }

    private class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Controller.getAdministratorController().getAdministratorView().setVisible(false);
            Controller.getLoginController().getLoginView().setVisible(true);
        }
    }
}