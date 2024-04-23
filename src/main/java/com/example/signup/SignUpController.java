package com.example.signup;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.*;

public class SignUpController {

    public TextField usernameInput;
    public PasswordField passwordInput;
    public Text errortext;
    public AnchorPane pnSignupPage;

    public void onLoginButtonClick() throws IOException {
        try (Connection c = SQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "INSERT INTO users (username, password) VALUES(?, ?)"
             )){
            String username = usernameInput.getText();
            String password = passwordInput.getText();

            PreparedStatement statement1 = c.prepareStatement(
                    "SELECT * FROM users WHERE username =?"
            );

            statement1.setString(1, username);
            ResultSet res = statement1.executeQuery();

            if(res.next()){
                errortext.setText("This username already exist!");
            } else if (usernameInput.getText().isEmpty() || passwordInput.getText().isEmpty()) {
                errortext.setText("Invalid Username / Password");
            } else{
                statement.setString(1, username);
                statement.setString(2, password);
                statement.executeUpdate();
                System.out.println("Account created!");
            }
            AnchorPane p  = (AnchorPane) pnSignupPage;
            Parent scene = FXMLLoader.load(getClass().getResource("home.fxml"));
            p.getChildren().clear();
            p.getChildren().add(scene);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
