package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import view.InterfaceView;

public class MainApplication extends Application {
		
	
	
	public void start(Stage primaryStage) {
		
		
	    InterfaceView app=new InterfaceView(primaryStage);
	  
	    app.show();
	    
	}
	public static void main(String[] args) {
		launch(args);
	}
}
