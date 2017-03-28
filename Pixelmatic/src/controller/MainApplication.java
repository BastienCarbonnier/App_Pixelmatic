package controller;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import model.ImageEffects;
import model.Model;
import view.InterfaceView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class MainApplication extends Application {
	
	
	
	public void start(Stage primaryStage) {
		
	    InterfaceView app=new InterfaceView(primaryStage);
	    
	    
			/*try {
				ImageEffects.blackAndWhite(app);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	    
	    
	    app.show();
	    
	}
	public static void main(String[] args) {
		launch(args);
		
	}
}
