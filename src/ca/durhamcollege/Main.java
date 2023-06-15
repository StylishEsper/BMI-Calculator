//Group:            15
//Name:             Ahmed Butt, Michai Pryce
//Student ID:       100770449, 100668094
//Last Modified:    December 16, 2020
//Project:          OOP3200-F2020-JavaLab5

package ca.durhamcollege;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.util.Locale;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Java Lab 5");
        DateFormat DF = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);
        GridPane gridPane = new GridPane();

        Scene scene = new Scene(gridPane, 320, 480);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        //Creating a label for height
        Label myHeight = new Label("My Height (in):    ");
        HBox hbox = new HBox(10, myHeight);

        //Setting font size to 20
        hbox.setStyle("-fx-font-size: 20;");
        gridPane.add(hbox,0,0);

        //Creating a TextField Control for height
        TextField height = new TextField();
        gridPane.add(height,1,0);

        //Creating a label for weight
        Label myWeight = new Label("My Weight (lbs):    ");
        hbox = new HBox(10, myWeight);
        hbox.setStyle("-fx-font-size: 20");
        gridPane.add(hbox,0,1);

        //Creating a TextField Control for weight
        TextField weight = new TextField();
        gridPane.add(weight,1,1);

        //Creating a button that runs BMI calculation
        Button calculateBMI = new Button("Calculate BMI");
        calculateBMI.setStyle("-fx-font-size: 20; -fx-translate-x: 80; -fx-translate-y: 20;");
        gridPane.add(calculateBMI, 0,2);

        //Creating a TextField Control for BMI
        TextField txtBMI = new TextField();
        txtBMI.setStyle("-fx-translate-x: 70; -fx-translate-y: 40;");
        gridPane.add(txtBMI,0,3);

        //Creating a label for BMI scale
        Label scale = new Label("");
        hbox = new HBox(10, scale);
        hbox.setStyle("-fx-font-size: 20; -fx-translate-x: 95; -fx-translate-y: 50;");
        gridPane.add(hbox,0,5);

        //Event: calculate BMI when button is clicked, find BMI scale based on result, display on screen
        class ButtonClickHandler implements EventHandler<ActionEvent>
        {
            @Override
            public void handle(ActionEvent event)
            {
                double bmi = (double)Math.round((Double.parseDouble(weight.getText()) /
                        (Double.parseDouble(height.getText()) * Double.parseDouble(height.getText())) * 703) * 100) / 100;
                txtBMI.setText(String.valueOf(bmi));
                if (bmi >= 30)
                {
                    scale.setText("Obese");
                }
                else if (bmi >= 25 && bmi <= 29.9)
                {
                    scale.setText("Overweight");
                }
                else if (bmi >= 18.5 && bmi <= 24.9)
                {
                    scale.setText("Normal");
                }
                else
                {
                    scale.setText("Underweight");
                }
            }
        }

        calculateBMI.setOnAction(new ButtonClickHandler());
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
