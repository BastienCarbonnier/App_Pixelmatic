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



public class InterfaceView {
	
	
	private static Stage primaryStage;
	
	
	private static BorderPane rootLayout;
	
	public InterfaceView(Stage primary){
		primaryStage=primary;
	    primaryStage.setTitle("Pixelmatic");
	    primaryStage.setMinHeight(400);
	    primaryStage.setMinWidth(400);
	    
	    
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
	    
	    rootLayout.setLeft(ToolbarButtonView.createToolbar());
	    
	    /*
        Text texte=new Text(10,10,"déposer une image ici");
        texte.setScaleX(2);
        texte.setScaleY(2.5);
        texte.autosize();
        rootLayout.setCenter(texte);

        texte.setOnDragOver(event -> {
            event.acceptTransferModes(TransferMode.COPY);
            
        });

        texte.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            if (db.hasImage()||db.hasFiles()) {

                	File dropped=db.getFiles().get(0);  	
                	IOController.openImage(dropped);                	                
                event.setDropCompleted(true);
            }
        });*/
	    
	    Button buttonFirstSelectImage=new Button("Cliquez ou deposez une image...");
	    buttonFirstSelectImage.setFont(new Font(20));
	    buttonFirstSelectImage.setPrefSize(400, 200);
	    
	    buttonFirstSelectImage.setOnAction(actionEvent -> {
	    	FileChooser fileChooser = new FileChooser(); 
	    	fileChooser.setInitialFileName(WorkArea.getBaseImagePath());
	        File file = fileChooser.showOpenDialog(null); 
	        //System.out.println(file.getAbsolutePath());
	        IOController.openImage(file);
		});
	    
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
	    
	    rootLayout.setCenter(buttonFirstSelectImage);
	    
	    Scene scene = new Scene(rootLayout);
	    primaryStage.setScene(scene);
	    
	}
    
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
    /*
    public static void showErrorMessage(String t){
    	
    	Text text=new Text(t);
    	text.setFont(Font.getDefault());
    	
    	Stage errorStage=new Stage();
    	//tell stage it is meant to pop-up (Modal)
        errorStage.initModality(Modality.APPLICATION_MODAL);
    	errorStage.setTitle("Pixelmatic");
    	errorStage.setMaxHeight(100);
    	errorStage.setMinHeight(100);
    	errorStage.setMaxWidth(200);
    	errorStage.setMinWidth(200);
    	
    	BorderPane errorLayout=new BorderPane();
    	errorLayout.setPrefSize(100,200);
    	errorLayout.setCenter(text);
    	
    	Button buttonClosePopUp = new Button("Fermer");
    	buttonClosePopUp.autosize();
    	buttonClosePopUp.setOnAction(actionEvent -> {
	    	errorStage.close();
		});
    	
    	BorderPane.setAlignment(buttonClosePopUp, Pos.CENTER);
    	errorLayout.setBottom(buttonClosePopUp);
    	
    	Scene errorScene = new Scene(errorLayout);
    	errorStage.setScene(errorScene);
    
    	errorStage.showAndWait();
    	
    }*/
    public static void showErrorMessage(String t){
	    Alert alert = new Alert(AlertType.WARNING);
	    alert.setTitle("Warning Dialog");
	    alert.setHeaderText(t);
	    alert.setContentText(null);
	    alert.showAndWait();
    }
    public static void showInfoMessage(String t){
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Information Dialog");
	    alert.setHeaderText(t);
	    alert.setContentText(null);
	    alert.showAndWait();
    }
    
    
    public static void showPopUp(Popup pop){
    	pop.show(primaryStage);
    }
     
    
	
}
