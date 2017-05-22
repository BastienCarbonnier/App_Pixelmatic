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
			
			Button buttonNoneEffect = new Button("Non-Modifie");
		
		    buttonNoneEffect.setOnAction(actionEvent -> ButtonHandling.showBaseImage());
		    
	        
		    MenuItem itemEffectBlackWhite = new MenuItem("Noir/Blanc");
		    
		    itemEffectBlackWhite.setOnAction(actionEvent -> {
				try {
					ButtonHandling.useBlackAndWhiteEffect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		    
		    MenuItem itemEffectFlou1 = new MenuItem("Flou Gaussien");
			
		    
	        itemEffectFlou1.setOnAction(actionEvent -> {
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
	        
	        MenuItem itemEffectSepia = new MenuItem("Sepia");
			
		    
	        
	        itemEffectSepia.setOnAction(actionEvent -> {
				
					try {
						ButtonHandling.useSepiaEffect();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        
	        MenuItem itemEffectNegatif = new MenuItem("Negatif");
			
		    
	        itemEffectNegatif.setOnAction(actionEvent -> {
				
					try {
						ButtonHandling.useNegativeEffect();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        MenuItem itemEffectAccentuation = new MenuItem("Accentuation");
			
		    
	        itemEffectAccentuation.setOnAction(actionEvent -> {
				
					try {
						ButtonHandling.useAccentuationEffect();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        
	        MenuItem itemEffectEstampage = new MenuItem("Estampage");
			
		    
	        itemEffectEstampage.setOnAction(actionEvent -> {
				
					try {
						ButtonHandling.useEstampageEffect();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        MenuItem itemEffectPosterisation = new MenuItem("Posterisation");
			
		    
	        itemEffectPosterisation.setOnAction(actionEvent -> {
				
					try {
						ButtonHandling.usePosterizeEffect();
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
	        		 itemEffectBlackWhite,
		    	     itemEffectSepia,
		    	     itemEffectNegatif,
		    	     itemEffectPosterisation
		    	     
	        		);
	        MenuButton menuButtonContour = new MenuButton("Contour");
	        menuButtonContour.getItems().addAll(
		    	     itemEffectAccentuation,
		    	     itemEffectEstampage
	        		);
	        MenuButton menuButtonFlou = new MenuButton("Flou");
	        menuButtonFlou.getItems().addAll(
		    	     itemEffectFlou1,
		    	     itemEffect4
	        		);
			toolBar = new ToolBar(
					buttonNoneEffect,
		    	    menuButtonColor,
		    	    menuButtonContour,
		    	    menuButtonFlou,
		    	    buttonTestDylan,
		    	    buttonTestJorge
		    	     
		    	 );
			toolBar.setOrientation(Orientation.VERTICAL);
			toolBar.setPrefWidth(100);
			buttonNoneEffect.setPrefWidth(toolBar.getPrefWidth());
			menuButtonColor.setPrefWidth(toolBar.getPrefWidth());
			menuButtonContour.setPrefWidth(toolBar.getPrefWidth());
			menuButtonFlou.setPrefWidth(toolBar.getPrefWidth());
			buttonTestDylan.setPrefWidth(toolBar.getPrefWidth());
			buttonTestJorge.setPrefWidth(toolBar.getPrefWidth());
		
			
			return toolBar;
		}
}
