package com.example.signup;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.*;

public class HelloController {
    @FXML
    private Label welcomeText;

    public TextField username;
    public PasswordField passwordInput;
    public Text passworderror;
    public Text usernameerror;

    public AnchorPane pnLoginPage;
    @FXML
    protected void onLoginButtonClick() throws IOException {
//        welcomeText.setText("Welcome to JavaFX Application!");

        try (Connection c = SQLConnection.getConnection();
             Statement statement = c.createStatement()){
            String query = "SELECT * FROM users";
            ResultSet res = statement.executeQuery(query);

            while(res.next()){
                if(username.getText().equals(res.getString("username")) && passwordInput.getText().equals(res.getString("password"))){
                    AnchorPane p  = (AnchorPane) pnLoginPage;
                    Parent scene = FXMLLoader.load(getClass().getResource("home.fxml"));
                    p.getChildren().clear();
                    p.getChildren().add(scene);
                }
                else if(username.getText().equals(res.getString("username")) && !passwordInput.getText().equals(res.getString("password"))){
                    passworderror.setText("Incorrect Password.");
                    break;
                }
                else if(!username.getText().equals(res.getString("username")) && passwordInput.getText().equals(res.getString("password"))){
                    usernameerror.setText("Incorrect Username.");
                    break;
                }
                else{
                    passworderror.setText("Username/Password incorrect.");
                    break;
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @FXML
    protected void onSignupButtonClick() throws IOException{
        AnchorPane p  = (AnchorPane) pnLoginPage;
        Parent scene = FXMLLoader.load(getClass().getResource("sign-up.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }
}