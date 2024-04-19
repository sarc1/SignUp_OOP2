package com.example.signup;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class EditplaylistController {
    public AnchorPane pneditplaylist;
    public void onAddSongButtonClick() throws IOException{
        AnchorPane p  = pneditplaylist;
        Parent scene = FXMLLoader.load(getClass().getResource("addsong.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }

    public void onRemoveSongButtonClick() throws IOException{
        AnchorPane p  = (AnchorPane) pneditplaylist;
        Parent scene = FXMLLoader.load(getClass().getResource("removesong.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }
    public void onViewSongButtonClick() throws IOException{
        AnchorPane p  = (AnchorPane) pneditplaylist;
        Parent scene = FXMLLoader.load(getClass().getResource("viewsong.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }

    public void onHomePageButtonClick() throws IOException{
        AnchorPane p  = (AnchorPane) pneditplaylist;
        Parent scene = FXMLLoader.load(getClass().getResource("home.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }
}
