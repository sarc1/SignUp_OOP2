package com.example.signup;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.signup.HelloController.currentUser;

public class ViewsongController {
    public Text displaysongs;
    public AnchorPane pnView;

    public void onDisplayButtonClick() throws IOException{
        try(Connection c = SQLConnection.getConnection();
            Statement statement = c.createStatement()){

            StringBuilder sb = new StringBuilder();

            String query = "SELECT * FROM playlist WHERE userid=" + currentUser;
            ResultSet res = statement.executeQuery(query);

            while(res.next()){
                sb.append(res.getString("songtitle") + "\n");
            }
            displaysongs.setText(sb.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void onBackButtonClick() throws IOException{
        AnchorPane p  = (AnchorPane) pnView;
        Parent scene = FXMLLoader.load(getClass().getResource("home.fxml"));
        p.getChildren().clear();
        p.getChildren().add(scene);
    }
}
