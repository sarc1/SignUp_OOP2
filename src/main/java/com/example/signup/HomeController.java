package com.example.signup;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HomeController {
    public AnchorPane pnHomePage;
    public void onChangeUsernameButtonClick() throws IOException {
        AnchorPane p  = (AnchorPane) pnHomePage;
        Parent scene = FXMLLoader.load(getClass().getResource("usernamechange.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }

    public void onChangePasswordButtonClick() throws IOException{
        AnchorPane p  = (AnchorPane) pnHomePage;
        Parent scene = FXMLLoader.load(getClass().getResource("passwordchange.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }
}
