package view;

import java.io.File;
import java.io.IOException;

import controller.WorkArea;
import controller.ButtonHandling;
import controller.IOController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;




public class InterfaceView {
	
	
	private Stage primaryStage;
	
	private WorkArea currentArea;
	private static BorderPane rootLayout;
	
	public InterfaceView(Stage primary,WorkArea area){
		primaryStage=primary;
	    primaryStage.setTitle("Pixelmatic");
	    primaryStage.setMinHeight(400);
	    primaryStage.setMinWidth(400);
	    //primaryStage.setFullScreen(true);
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
	    
	    Button buttonFirstSelectImage = new Button("Cliquez pour selectionner une image...");
	    buttonFirstSelectImage.autosize();
	    buttonFirstSelectImage.setOnAction(actionEvent -> {
	    	FileChooser fileChooser = new FileChooser(); 
	        File file = fileChooser.showOpenDialog(null); 
	        IOController.openImage(file);
		});
	    rootLayout.setCenter(buttonFirstSelectImage);
	    //showImage(WorkArea.getBaseImagePath());
	    //showImage("src/view/image_2.jpg");
	    Scene scene = new Scene(rootLayout);
	    primaryStage.setScene(scene);
	    
	}
    
    public static void showImage(String img){
    	ImageView image=new ImageView(new File(img).toURI().toString());
    	rootLayout.setCenter(image);
    	rootLayout.setPrefSize(image.getImage().getWidth()+50,image.getImage().getHeight()+50);
    	System.out.println(img);
    }
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
    	
    	
    	//rootLayout.setPrefSize(image.getImage().getWidth()+50,image.getImage().getHeight()+50);
    	
    }
    
     
    
	
}
