package view;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.ImageEffects;



public class InterfaceView {
	
	private BorderPane rootLayout;
	private Stage primaryStage;
	
	private File workingImage;
	private File currentImage;
	
	public InterfaceView(Stage primary){
		primaryStage=primary;
	    primaryStage.setTitle("Pixelmatic");
	    createRootLayout();
	}
	
	public void show(){
		primaryStage.show();
	}
	public void createRootLayout() {
		rootLayout = new BorderPane();
		rootLayout.setPrefSize(600,500);
	    rootLayout.setTop(createMenuBar());
	    
	    currentImage=new File("src/view/image_2.jpeg");
		workingImage=new File("src/view/image_2_grey.jpeg");
	    //toolBar.setOrientation(null);
	    rootLayout.setBottom(createToolbar());
	    //String image_links = new File("Pixelmatic/src/image_1.gif").toURI().toString();
		//rootLayout.setLeft(createFunctionBar());
		//rootLayout.setBottom(createHBox());
		
		
	    Scene scene = new Scene(rootLayout);
	    
	    primaryStage.setScene(scene);
	    
	}
	public File getCurrentImage(){
		return currentImage;
	}
	public File getWorkingImage(){
		return workingImage;
	}
	public ToolBar createToolbar(){
		Button but_img1 = new Button("image1");
	    but_img1.setPrefSize(100, 20);
	    //String image_links1 = new File("Pixelmatic/src/image_1.gif").toURI().toString(); 
        ImageView image = new ImageView(currentImage.toURI().toString());
	    but_img1.setOnAction(actionEvent -> showImage(image));
	    
	    Button but_img2 = new Button("image2");
	    but_img2.setPrefSize(100, 20);
	    //String image_links2 = new File("Pixelmatic/src/pixelmatic/image_2.jpeg").toURI().toString(); 
	    
	    // Don't respect MVC change it !!!!
	    try {
			ImageEffects.blackAndWhite(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ImageView  image2= new ImageView(workingImage.toURI().toString());
        but_img2.setOnAction(actionEvent -> showImage(image2));
        
		ToolBar toolBar = new ToolBar(
	    	     but_img1,
	    	     but_img2
	    	 );
		
		return toolBar;
	}
	public HBox createHBox() {
	    HBox hbox = new HBox();
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);
	    hbox.setStyle("-fx-background-color: #336699;");
	    
	    Button but_img1 = new Button("image1");
	    but_img1.setPrefSize(100, 20);
	    //String image_links1 = new File("Pixelmatic/src/image_1.gif").toURI().toString(); 
        //ImageView image = new ImageView(image_links1);
	    //but_img1.setOnAction(actionEvent -> showImage(image));
	    
	    Button but_img2 = new Button("image2");
	    but_img2.setPrefSize(100, 20);
	    //String image_links2 = new File("Pixelmatic/src/image_2.jpeg").toURI().toString(); 
        //ImageView  image2= new ImageView(image_links2);
        //but_img2.setOnAction(actionEvent -> showImage(image2));
        
	    //hbox.getChildren().addAll(but_img1, but_img2);

	    return hbox;
	}
	
	public MenuBar createMenuBar() {
		MenuBar menuBar = new MenuBar();
	    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
	   
	    
	    Menu pixelmaticMenu = new Menu("Pixelmatic");
	    Menu fileMenu = new Menu("Fichier");
	    Menu editMenu = new Menu("Edition");
	    Menu helpMenu = new Menu("Aide");
	    MenuItem exitMenuItem = new MenuItem("Exit");
	    pixelmaticMenu.getItems().addAll(exitMenuItem);
	    
	    exitMenuItem.setOnAction(actionEvent -> Platform.exit());
	    
	    menuBar.getMenus().addAll(pixelmaticMenu,fileMenu,editMenu,helpMenu);
	    return menuBar;
	}
    public FlowPane createFunctionBar() {
	    FlowPane flow = new FlowPane();
	    flow.setPadding(new Insets(5, 0, 5, 0));
	    flow.setVgap(4);
	    flow.setHgap(4);
	    flow.setPrefWrapLength(170); // preferred width allows for two columns
	    flow.setStyle("-fx-background-color: DAE6F3;");
	    
	    String image_links1 = new File("Pixelmatic/src/image_1.gif").toURI().toString(); 
        //Image img = new Image(imageURI);
	    ImageView image1 = new ImageView(image_links1);
        flow.getChildren().add(image1);
    
	    String image_links2 = new File("Pixelmatic/src/image_2.jpeg").toURI().toString(); 
        //Image img2 = new Image(image);
	    ImageView image2 = new ImageView(image_links2);
        flow.getChildren().add(image2);
	    return flow;
	}
    
    public void showImage(ImageView img){
    	rootLayout.setCenter(img);
    }
    
    
    
	
}
