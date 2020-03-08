/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssimentJava;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author lenovo
 */
public class Ex1 extends Application{
   private ListView<String> listViewName,listViewName1;
    private Button butn;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        listViewName=new ListView<>();
        butn=new Button("Copy");
        listViewName1=new ListView<>();
        
        HBox hBox =new HBox(15,listViewName,butn,listViewName1);
        
        hBox.setAlignment(Pos.CENTER);
       
        Scene Scene=new Scene(hBox,600,500);
        primaryStage.setTitle("Multibul Selection Lists");
        primaryStage.setScene(Scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
        listViewName.getItems().addAll("white","black","red","blue","pink","yellow","green","gray","lightblue");
        listViewName.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        eventHandler1 event=new eventHandler1();
        butn.addEventFilter(MouseEvent.MOUSE_CLICKED, event);
    }
      private class eventHandler1 implements EventHandler<Event>{
         Alert a=new Alert(Alert.AlertType.WARNING);
        @Override
        public void handle(Event event) {
            if(event.getSource() == butn){
              ArrayList<String> item=new ArrayList<>() ;
            item.addAll(listViewName.getSelectionModel().getSelectedItems());
         
            listViewName1.getItems().setAll(item);
            if(item.isEmpty()==true){
                a.setTitle("WARNING ABOUT INFORMATION");
                a.setContentText("NOT Selsectiom Item");
                a.showAndWait();
        }}
        
    }}
    
}
