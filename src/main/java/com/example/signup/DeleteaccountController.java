package com.example.signup;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteaccountController {
    public TextField deleteusername;
    public PasswordField deletepassword;
    public AnchorPane pndelete;
    public void onDeleteButtonClick() throws IOException{
        try (Connection c = SQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "DELETE FROM users WHERE username =? AND password =?"
             )){

            statement.setString(1, deleteusername.getText());
            statement.setString(2, deletepassword.getText());
            statement.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Account successfully deleted!");
            alert.setHeaderText("Account Deleted");
            alert.showAndWait();


            AnchorPane p  = (AnchorPane) pndelete;
            Parent scene = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            p.getChildren().clear();
            p.getChildren().add(scene);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
