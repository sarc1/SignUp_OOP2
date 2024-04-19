package com.example.signup;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    public TextField username;
    public PasswordField passwordInput;

    public AnchorPane pnLoginPage;
    @FXML
    protected void onLoginButtonClick() throws IOException {
        welcomeText.setText("Welcome to JavaFX Application!");
        String usernamead = "admin";
        String passwordad = "admin";

        if(username.getText().equals(usernamead) && passwordInput.getText().equals(passwordad)){

            AnchorPane p  = (AnchorPane) pnLoginPage;
            Parent scene = FXMLLoader.load(getClass().getResource("home.fxml"));
            p.getChildren().clear();
            p.getChildren().add(scene);
        }
    }
}