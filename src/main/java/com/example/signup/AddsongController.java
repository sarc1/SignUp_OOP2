package com.example.signup;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.signup.HelloController.currentUser;

public class AddsongController {

    @FXML
    TextField songinput;
    @FXML
    Text addsongerror;
    @FXML
    public AnchorPane pnaddsong;
    public void onAddToPlaylistButtonClick() throws IOException{
        try (Connection c = SQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "INSERT INTO playlist (songtitle, userid) VALUES (?, ?)"
             )){
            String songtitle = songinput.getText();
            PreparedStatement statement1 = c.prepareStatement(
                    "SELECT * FROM playlist WHERE songtitle =? AND userid=?"
            );
            statement1.setString(1, songtitle);
            statement1.setString(2, String.valueOf(currentUser));
            ResultSet res = statement1.executeQuery();

            if(res.next()){
                addsongerror.setText("Song already on the playlist.");
            }
            else if(songtitle.isEmpty()){
                addsongerror.setText("Invalid song title.");
            } else{
                statement.setString(1,songtitle);
                statement.setString(2, String.valueOf(currentUser));
                statement.executeUpdate();
                System.out.println("Song Added Successfully");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Song successfully added!");
                alert.setHeaderText("Song added");
                alert.showAndWait();

                AnchorPane p  = (AnchorPane) pnaddsong;
                Parent scene = FXMLLoader.load(getClass().getResource("editplaylist.fxml"));
                p.getChildren().clear();
                p.getChildren().add(scene);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
