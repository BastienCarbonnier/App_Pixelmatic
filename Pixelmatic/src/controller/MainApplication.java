package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import view.InterfaceView;

public class MainApplication extends Application {
		
	private final static String base_image="src/view/image_2.jpg";
	
	public void start(Stage primaryStage) {
		
		WorkArea currentArea=new WorkArea(base_image);
	    InterfaceView app=new InterfaceView(primaryStage,currentArea);
	    
	    app.show();
	    
	}
	public static void main(String[] args) {
		launch(args);
	}
}
