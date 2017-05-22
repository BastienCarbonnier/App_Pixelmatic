package view;

import java.awt.Image;
import java.io.File;
import controller.WorkArea;
import controller.IOController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.event.EventHandler;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.event.*;

/**
 * This class is the nerve center of our application.
 * It allow us to create all the components we need 
 * and assemble them to obtain the user interface.
 * This is the main class of view package.
 * <p>
 * InterfaceView got two properties :
 * -	primaryStage (the main window)
 * -	rootLayout (the main layout)
 * <p>
 * In order to use this class's properties in all our 
 * program, we choose initialize them in static.
 * 
 * @author Bastien Carbonnier
 * @see		Stage
 * @see		BorderPane
 */

public class InterfaceView {
	
	/**
	 * This properties corresponding to the application's window.
	 * @see		Stage
	 * */
	private static Stage primaryStage;
	
	/**
	 * This properties corresponding to the application's form.
	 * With this BorderPane Layout, we can put some elements in
	 * the left, in the center, in the right, in the top or in
	 * the bottom of the Stage were it will be affected.
	 * 
	 * @see		BorderPane
	 * */
	private static BorderPane rootLayout;
	
	/**
	 * This constructor configure the primary Stage by using the one 
	 * which is in the parameters.
	 * It set the title of the stage and it initial size and to finish,
	 * It execute createRootLayout() method.
	 * 
	 * @param	primary initial Stage given by the MainApplication
	 * @see		Stage
	 * 
	 */
	
	public InterfaceView(Stage primary){
		primaryStage=primary;
	    primaryStage.setTitle("Pixelmatic");
	    primaryStage.setMinHeight(300);
	    primaryStage.setMinWidth(500);
	    
	    
	    createRootLayout();
	}
	
	/**
	 * This method show the primary Stage which is actually the 
	 * main window of our application.
	 * 
	 * @see		Stage
	 */
	
	public void show(){
		primaryStage.show();
	}
	
	/**
	 * This method create the root layout of the application.
	 * It create all component that will be necessary and assemble it 
	 * on the BorderPane.
	 * Component :
	 * -	MenuBar
	 * -	ToolBar
	 *
	 * And to finish, it create the Scene and use it to create the primary 
	 * Stage (the main window).
	 * 
	 * @see		BorderPane
	 * @see		MenuBar
	 * @see		Stage
	 * @see		Scene
	 */
	
	public void createRootLayout() {
		
		rootLayout = new BorderPane();
		
		// Create menu for the top of the layout
		MenuBar menu=MenuBarView.createMenuBar();
		menu.prefWidthProperty().bind(primaryStage.widthProperty());
	    rootLayout.setTop(menu);
	    
	    // Create toolbar for the left of the layout
	    rootLayout.setLeft(ToolbarButtonView.createToolbar());
	    
	    /** 
	     * Create a button for center of the layout.
	     * It will be created only one time in the launch of the 
	     * application.
	     * */
	    
	    rootLayout.setCenter(createButtonFirstImageSelection());
	    
	    Scene scene = new Scene(rootLayout);
	    primaryStage.setScene(scene);
	    
	}
    
	/**
     * We create a button that will be used only one time, when we'll
     * open the application.
     * <p>
     * We have configured this button so that it can receive an image 
     * by drag and drop.
     * @return	A button plainly configured
     * 
     * */
	public static Button createButtonFirstImageSelection(){
		Button buttonFirstSelectImage=new Button("Cliquez ou deposez une image...");
	    buttonFirstSelectImage.setFont(new Font(20));
	    buttonFirstSelectImage.setPrefSize(400, 200);
	    
	    // Set OnClick event
	    buttonFirstSelectImage.setOnAction(actionEvent -> {
	    	FileChooser fileChooser = new FileChooser(); 
	    	fileChooser.setInitialFileName(WorkArea.getBaseImagePath());
	        File file = fileChooser.showOpenDialog(null); 
	        IOController.openImage(file);
		});
	    
	    // Set OnDrag events
	    buttonFirstSelectImage.setOnDragOver(event -> {
            event.acceptTransferModes(TransferMode.COPY);
        });
	    
	    buttonFirstSelectImage.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            if (db.hasImage()||db.hasFiles()) {
                	File dropped=db.getFiles().get(0);  	
                	IOController.openImage(dropped);                	                
                event.setDropCompleted(true);
            }
        });
	    return buttonFirstSelectImage;
	}
	
	
	/**
	 * This method draw the image (corresponding to the String path 
	 * passed in parameter) on the center of the screen by using the root 
	 * BorderPane. 
	 *
	 * This method auto-adjust the size of the image for the window with 
	 * security margin.
	 * 
	 * @param  img  the location of the image
	 * @see			ImageView
	 * @see			BorderPane
	 */
    public static void showImage(String img){
    	ImageView image=new ImageView(new File(img).toURI().toString());
    	
    	if (image.getImage().getWidth()>500||image.getImage().getHeight()>500){
    		image.setPreserveRatio(true);
    		image.setFitHeight(600);
    		image.setFitWidth(600);
    		primaryStage.setMinHeight(600+100);
    	    primaryStage.setMinWidth(600+140);
    	}else{
    		primaryStage.setMinHeight(image.getImage().getHeight()+100);
    	    primaryStage.setMinWidth(image.getImage().getWidth()+140);
    	}
    	rootLayout.setCenter(image);
    	
    	System.out.println(img);
    	
    }
   
    /**
	 * This method show a Pop-up window with a warning form. 
	 * It takes in parameter the message that will be print 
	 * on the Screen.
	 * 
	 * @param  message  message we want to show
	 * @see				Alert
	 * 
	 */
    
    public static void showErrorMessage(String message){
	    Alert alert = new Alert(AlertType.WARNING);
	    alert.setTitle("Warning Dialog");
	    alert.setHeaderText(message);
	    alert.setContentText(null);
	    alert.showAndWait();
    }
    
    /**
	 * This method show a Pop-up window with an informational form. 
	 * It takes in parameter the message that will be print 
	 * on the Screen.
	 * 
	 * @param  message  message we want to show
	 * @see				Alert
	 * 
	 */
    public static void showInfoMessage(String message){
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Information Dialog");
	    alert.setHeaderText(message);
	    alert.setContentText(null);
	    alert.showAndWait();
    }
       
    
	
}
