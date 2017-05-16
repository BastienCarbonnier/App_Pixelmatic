package view;


import java.io.IOException;
import controller.ButtonHandling;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;


public class ToolbarButtonView {
	
		public static ToolBar createToolbar(){
			ToolBar toolBar;
			
			Button buttonEffect1 = new Button("Non-Modifie");
		
		    buttonEffect1.setOnAction(actionEvent -> ButtonHandling.showBaseImage());
		    
	        
		    MenuItem itemEffect2 = new MenuItem("Noir/Blanc");
		    
		    itemEffect2.setOnAction(actionEvent -> {
				try {
					ButtonHandling.useBlackAndWhiteEffect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		    
		    MenuItem itemEffect3 = new MenuItem("Flou Gaussien");
			
		    
	        itemEffect3.setOnAction(actionEvent -> {
				try {
					ButtonHandling.useGaussianEffect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
	        
	        MenuItem itemEffect4 = new MenuItem("Trouble");
			
		    
	        itemEffect4.setOnAction(actionEvent -> {
				try {
					ButtonHandling.useBlurEffect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
	        
	        MenuItem itemEffect5 = new MenuItem("Sepia");
			
		    
	        
	        itemEffect5.setOnAction(actionEvent -> {
				
					try {
						ButtonHandling.useSepiaEffect();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        
	        MenuItem itemEffect6 = new MenuItem("Negatif");
			
		    
	        itemEffect6.setOnAction(actionEvent -> {
				
					try {
						ButtonHandling.useNegativeEffect();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        MenuItem itemEffect7 = new MenuItem("Accentuation");
			
		    
	        itemEffect7.setOnAction(actionEvent -> {
				
					try {
						ButtonHandling.useAccentuationEffect();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        
	        MenuItem itemEffect8 = new MenuItem("Estampage");
			
		    
	        itemEffect8.setOnAction(actionEvent -> {
				
					try {
						ButtonHandling.useEstampageEffect();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        
	        Button buttonTestDylan = new Button("Dylan");
			
	      
	        buttonTestDylan.setOnAction(actionEvent -> {
				
					try {
						ButtonHandling.testDylan();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        
	        Button buttonTestJorge = new Button("Jorge");
			
	        
	        buttonTestJorge.setOnAction(actionEvent -> {
				
					try {
						ButtonHandling.testJorge();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        
	        MenuButton menuButtonColor = new MenuButton("Couleur");
	        menuButtonColor.getItems().addAll(
	        		 itemEffect2,
		    	     itemEffect5,
		    	     itemEffect6
		    	     
	        		);
	        MenuButton menuButtonContour = new MenuButton("Contour");
	        menuButtonContour.getItems().addAll(
		    	     itemEffect7,
		    	     itemEffect8
	        		);
	        MenuButton menuButtonFlou = new MenuButton("Flou");
	        menuButtonFlou.getItems().addAll(
		    	     itemEffect3,
		    	     itemEffect4
	        		);
			toolBar = new ToolBar(
					buttonEffect1,
		    	    menuButtonColor,
		    	    menuButtonContour,
		    	    menuButtonFlou,
		    	    buttonTestDylan,
		    	    buttonTestJorge
		    	     
		    	 );
			toolBar.setOrientation(Orientation.VERTICAL);
			toolBar.setPrefWidth(100);
			buttonEffect1.setPrefWidth(100);
			menuButtonColor.setPrefWidth(100);
			menuButtonContour.setPrefWidth(100);
			menuButtonFlou.setPrefWidth(100);
			buttonTestDylan.setPrefWidth(100);
			buttonTestJorge.setPrefWidth(100);
		
			
			return toolBar;
		}
}
