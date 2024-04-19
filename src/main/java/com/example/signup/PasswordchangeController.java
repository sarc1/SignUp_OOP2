package com.example.signup;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordchangeController {
    public TextField username;
    public PasswordField oldpassword;
    public PasswordField newpassword;
    public Text accounterror;
    public AnchorPane pnChangePassword;

    protected void onChangePasswordButtonClick() throws IOException{
        try (Connection c = SQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "UPDATE users SET password =? WHERE password =?"
             )){
            PreparedStatement statement1 = c.prepareStatement(
                    "SELECT * FROM users WHERE username =? AND password =?"
            );

            statement1.setString(1, username.getText());
            statement1.setString(2, oldpassword.getText());
            ResultSet res = statement.executeQuery();

            if(res.next()){
                statement.setString(1, newpassword.getText());
                statement.setString(2, res.getString("password"));
                statement.executeUpdate();
            }else{
                accounterror.setText("Account does not exist.");
            }
            AnchorPane p  = (AnchorPane) pnChangePassword;
            Parent scene = FXMLLoader.load(getClass().getResource("home.fxml"));
            p.getChildren().clear();
            p.getChildren().add(scene);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
