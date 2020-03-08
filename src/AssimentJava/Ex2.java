/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssimentJava;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author lenovo
 */
public class Ex2 extends Application{
    

    private TextField textField;
    private Label message,temprature;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
           textField=new TextField();
        message=new Label("Enter Celsise Temprature");
        temprature=new Label("");
        RadioButton choise1=new RadioButton("Fehrnaite");
        RadioButton choise2=new RadioButton("Kelvine");
        choise1.setSelected(true);
        ToggleGroup myToggle=new ToggleGroup();
        choise1.setToggleGroup(myToggle);
        choise2.setToggleGroup(myToggle);
        HBox hbox1=new HBox(choise1,choise2);
        hbox1.setAlignment(Pos.CENTER);
        
      choise1.setOnAction(event ->{
           temprature.setText("New Temprature in is:"+((Double.parseDouble(textField.getText())*(1.8))+32));
      });
       choise2.setOnAction(event ->{
           temprature.setText("New Temprature in is:"+((Double.parseDouble(textField.getText())+273.15)));
      });
     
        VBox vBox=new VBox(4,message,textField,hbox1,temprature); 
        vBox.setAlignment(Pos.CENTER);
        Scene s1=new Scene(vBox,300,350);
       primaryStage.setTitle("Temprature Converter");
       primaryStage.setScene(s1);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
}
