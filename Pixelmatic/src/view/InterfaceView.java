package view;

import java.io.File;
import controller.WorkArea;
import controller.ButtonHandling;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;




public class InterfaceView {
	
	
	private Stage primaryStage;
	
	private WorkArea currentArea;
	private static BorderPane rootLayout;
	
	public InterfaceView(Stage primary,WorkArea area){
		primaryStage=primary;
	    primaryStage.setTitle("Pixelmatic");
	    currentArea=area;
	    
	    createRootLayout();
	}
	
	public void show(){
		primaryStage.show();
	}
	public void createRootLayout() {
		
		rootLayout = new BorderPane();
		rootLayout.setPrefSize(600,500);
		
		MenuBar menu=MenuBarView.createMenuBar();
		menu.prefWidthProperty().bind(primaryStage.widthProperty());
	    rootLayout.setTop(menu);
		
	    rootLayout.setBottom(ToolbarButtonView.createToolbar());
	    showImage(WorkArea.getBaseImagePath());
	    Scene scene = new Scene(rootLayout);
	    primaryStage.setScene(scene);
	    
	}
    
    public static void showImage(String img){
    	rootLayout.setCenter(new ImageView(new File(img).toURI().toString()));
    	System.out.println(img);
    }
     
    
	
}
