package com.example.signup;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HomeController {
    public AnchorPane pnHomePage;

    public void onViewPlaylistButtonClick() throws IOException{
        AnchorPane p  = (AnchorPane) pnHomePage;
        Parent scene = FXMLLoader.load(getClass().getResource("viewsong.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }

    public void onEditPlaylistButtonClick() throws IOException{
        AnchorPane p  = (AnchorPane) pnHomePage;
        Parent scene = FXMLLoader.load(getClass().getResource("editplaylist.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }
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

    public void onLogoutButtonClick() throws IOException {
        AnchorPane p  = (AnchorPane) pnHomePage;
        Parent scene = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }
    public void onDeleteButtonClick() throws IOException{
        AnchorPane p  = (AnchorPane) pnHomePage;
        Parent scene = FXMLLoader.load(getClass().getResource("deleteaccount.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }
}
