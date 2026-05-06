package com.example.dynamic_ride_allocator.Controllers.AdminControllers;

import com.example.dynamic_ride_allocator.Controllers.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ManageUsersScreenController {
    public Button btnBlock;

    public void btnDashboardAction(MouseEvent mouseEvent) throws IOException {
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Layouts/admin_dashboard.fxml")));
        Stage s=(Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        s.setTitle("Admin Dashboard");
        s.setScene(new Scene(root));
    }

    public void btnApproveRidersAction(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Layouts/approve_drivers_screen.fxml")));
        Stage s = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        s.setTitle("Admin Dashboard/Approve Drivers");
        s.setScene(new Scene(root));
    }

    public void btnManageUsersAction(MouseEvent mouseEvent) throws IOException {
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Layouts/manage_users_screen.fxml")));
        Stage s=(Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        s.setTitle("Admin Dashboard/Manage Users");
        s.setScene(new Scene(root));
    }

    public void btnProfileAction(MouseEvent mouseEvent) throws IOException {
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Layouts/admin_profile_screen.fxml")));
        Stage s=(Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        s.setTitle("Admin Dashboard/Admin Profile");
        s.setScene(new Scene(root));
    }

    public void btnLogoutAction(MouseEvent mouseEvent) throws IOException {
        LoginController.currentUser=null;
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Layouts/welcome.fxml")));
        Stage s=(Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        s.setTitle("Admin Dashboard");
        s.setScene(new Scene(root));
    }

}
