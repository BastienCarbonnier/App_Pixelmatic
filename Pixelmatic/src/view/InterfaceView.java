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
	
	public HBox createHBox() {
	    HBox hbox = new HBox();
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);
	    hbox.setStyle("-fx-background-color: #336699;");
	    
	    Button but_img1 = new Button("image1");
	    but_img1.setPrefSize(100, 20);
	    
	    Button but_img2 = new Button("image2");
	    but_img2.setPrefSize(100, 20);
	    
	    return hbox;
	}
	
	
    public FlowPane createFunctionBar() {
	    FlowPane flow = new FlowPane();
	    flow.setPadding(new Insets(5, 0, 5, 0));
	    flow.setVgap(4);
	    flow.setHgap(4);
	    flow.setPrefWrapLength(170); // preferred width allows for two columns
	    flow.setStyle("-fx-background-color: DAE6F3;");
	    
	    String image_links1 = new File("Pixelmatic/src/image_1.gif").toURI().toString(); 
        
	    ImageView image1 = new ImageView(image_links1);
        flow.getChildren().add(image1);
    
	    String image_links2 = new File("Pixelmatic/src/image_2.jpeg").toURI().toString(); 
       
	    ImageView image2 = new ImageView(image_links2);
        flow.getChildren().add(image2);
	    return flow;
	}
    
    public static void showImage(String img){
    	rootLayout.setCenter(new ImageView(new File(img).toURI().toString()));
    	System.out.println(img);
    }
    public BorderPane getRootLayout(){
    	return rootLayout;
    }
    
    
	
}
