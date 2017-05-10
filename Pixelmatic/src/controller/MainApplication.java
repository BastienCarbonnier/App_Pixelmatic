package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import model.ModifyPath;
import view.InterfaceView;

public class MainApplication extends Application {
		
	
	
	public void start(Stage primaryStage) {
		
		WorkArea currentArea=new WorkArea();
	    InterfaceView app=new InterfaceView(primaryStage,currentArea);
	  
	    app.show();
	    
	}
	public static void main(String[] args) {
		launch(args);
	}
}
