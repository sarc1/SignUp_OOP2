package com.example.signup;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.*;

public class UsernamechangeController {
    public TextField oldusername;
    public TextField newusername;
    public Text oldusernameerror;
    public PasswordField passwordInput;
    public AnchorPane pnChangeUsername;

    @FXML
    protected void onChangeButtonClick() throws IOException{
        try (Connection c = SQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "UPDATE users SET username =? WHERE username =?"
             )){
            PreparedStatement statement1 = c.prepareStatement(
                    "SELECT * FROM users WHERE username =?"
            );
            statement1.setString(1, oldusername.getText());
            ResultSet res = statement1.executeQuery();
            if(res.next()){
                statement.setString(1,newusername.getText());
                statement.setString(2, res.getString("username"));
                statement.executeUpdate();

            }
            else{
                oldusernameerror.setText("Username not found.");
            }
            AnchorPane p  = (AnchorPane) pnChangeUsername;
            Parent scene = FXMLLoader.load(getClass().getResource("home.fxml"));
            p.getChildren().clear();
            p.getChildren().add(scene);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
