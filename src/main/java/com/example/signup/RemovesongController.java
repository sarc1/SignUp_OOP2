package com.example.signup;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.*;

public class RemovesongController {
    public TextField songremoveinput;
    public Text removeerror;
    public AnchorPane pnremovesong;
    public void onRemoveButtonClick() throws IOException{
        try (Connection c = SQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "DELETE FROM playlist WHERE songtitle =?"
             )){
            Statement statement1 = c.createStatement();
            String query1 = "SELECT * FROM playlist WHERE songtitle = songtitle";

            ResultSet res = statement1.executeQuery(query1);
            if(res.next()){
                String song = songremoveinput.getText();
                statement.setString(1, song);
                statement.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Song successfully deleted!");
                alert.setHeaderText("Deleted a song");
                alert.showAndWait();
            }else{
                removeerror.setText("This song title does not exist in the playlist");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void onBackButtonClick() throws IOException{
        AnchorPane p  = (AnchorPane) pnremovesong;
        Parent scene = FXMLLoader.load(getClass().getResource("editplaylist.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }
}
