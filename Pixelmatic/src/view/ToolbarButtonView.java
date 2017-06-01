package view;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import controller.ButtonEffectHandling;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.scene.text.Text;

public class ToolbarButtonView {
	
		public static ToolBar createToolbar(){
			
			ToolBar toolBar;
			
			Button buttonNoneEffect = new Button("Non-Modifie");
		
		    buttonNoneEffect.setOnAction(actionEvent -> {
				try {
					ButtonEffectHandling.showBaseImage();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		    
	        
		    MenuItem itemEffectBlackWhite = new MenuItem("Noir/Blanc");
		    
		    itemEffectBlackWhite.setOnAction(actionEvent -> {
				try {
					ButtonEffectHandling.useBlackAndWhiteEffect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		    
		    Button itemEffectFlou1 = new Button("Flou");
			
		    
	        itemEffectFlou1.setOnAction(actionEvent -> {
	        	
	        	
	        	int strength;
	        	List<Integer> choices = new ArrayList<>();
	        	choices.add(1);
	        	choices.add(2);
	        	choices.add(3);
	        	choices.add(5);
	        	choices.add(10);
	        	ChoiceDialog<Integer> dialog = new ChoiceDialog<>(1, choices);
	        	dialog.setTitle("Niveau de flou");
	        	dialog.setHeaderText(null);
	        	dialog.setContentText("Choisissez le niveau de flou que vous désirez :");

	        	Optional<Integer> result = dialog.showAndWait();
	        	
	        	if (result.isPresent()){
	        	    strength= result.get();
	        	    
	        	}else 
	        		strength=0;
	        	
				try {
					ButtonEffectHandling.useFlouIncrementalEffect(strength);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
	        
	        Button itemEffectLuminosite = new Button("Luminosite");
			
		    
	        itemEffectLuminosite.setOnAction(actionEvent -> {
	        	
	        	
	        	int strength;
	        	List<Integer> choices = new ArrayList<>();
	        	choices.add(1);
	        	choices.add(2);
	        	choices.add(3);
	        	choices.add(5);
	        	choices.add(10);
	        	ChoiceDialog<Integer> dialog = new ChoiceDialog<>(1, choices);
	        	dialog.setTitle("Niveau de Luminosite");
	        	dialog.setHeaderText(null);
	        	dialog.setContentText("Choisissez le niveau de luminosite que vous désirez :");

	        	Optional<Integer> result = dialog.showAndWait();
	        	
	        	if (result.isPresent()){
	        	    strength= result.get();
	        	    
	        	}else 
	        		strength=0;
	        	
				try {
					ButtonEffectHandling.useLuminosityIncrementalEffect(strength);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
	        
	        
	        MenuItem itemEffectSepia = new MenuItem("Sepia");
			
		    
	        
	        itemEffectSepia.setOnAction(actionEvent -> {
				
					try {
						ButtonEffectHandling.useSepiaEffect();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        
	        MenuItem itemEffectNegatif = new MenuItem("Negatif");
			
		    
	        itemEffectNegatif.setOnAction(actionEvent -> {
				
					try {
						ButtonEffectHandling.useNegativeEffect();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        MenuItem itemEffectAccentuation = new MenuItem("Accentuation");
			
		    
	        itemEffectAccentuation.setOnAction(actionEvent -> {
				
					try {
						ButtonEffectHandling.useAccentuationEffect();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        
	        MenuItem itemEffectEstampage = new MenuItem("Estampage");
			
		    
	        itemEffectEstampage.setOnAction(actionEvent -> {
				
					try {
						ButtonEffectHandling.useEstampageEffect();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        MenuItem itemEffectPosterisation = new MenuItem("Posterisation");
			
		    
	        itemEffectPosterisation.setOnAction(actionEvent -> {
				
					try {
						ButtonEffectHandling.usePosterizeEffect();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        
	        Button buttonTestDylan = new Button("Dylan");
			
	      
	        buttonTestDylan.setOnAction(actionEvent -> {
				
					try {
						ButtonEffectHandling.testDylan();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        
	        
	       MenuItem itemEffectMirror = new MenuItem("Mirroir");
		    
		    itemEffectMirror.setOnAction(actionEvent -> {
				try {
					ButtonEffectHandling.useMirrorEffect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		    
		       MenuItem itemEffect180 = new MenuItem("180°");
			    
			    itemEffect180.setOnAction(actionEvent -> {
					try {
						ButtonEffectHandling.use180Effect();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
		    
		    
		    
	        Button buttonTestJorge =new Button("Jorge");
			
	        
	        buttonTestJorge.setOnAction(actionEvent -> {
				
					try {
						ButtonEffectHandling.testJorge();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        
	        MenuButton menuButtonStructure=new MenuButton("Structure");
	        menuButtonStructure.getItems().addAll(itemEffectMirror, itemEffect180);
	        
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
	        
			toolBar = new ToolBar(
					buttonNoneEffect,
		    	    menuButtonColor,
		    	    menuButtonContour,
		    	    menuButtonStructure,
		    	    itemEffectFlou1,
		    	    itemEffectLuminosite,
		    	    buttonTestDylan,
		    	    buttonTestJorge
		    	     
		    	 );
			toolBar.setOrientation(Orientation.VERTICAL);
			toolBar.setPrefWidth(100);
			buttonNoneEffect.setPrefWidth(toolBar.getPrefWidth());
			menuButtonColor.setPrefWidth(toolBar.getPrefWidth());
			menuButtonContour.setPrefWidth(toolBar.getPrefWidth());
			menuButtonStructure.setPrefWidth(toolBar.getPrefWidth());
			itemEffectFlou1.setPrefWidth(toolBar.getPrefWidth());
			itemEffectLuminosite.setPrefWidth(toolBar.getPrefWidth());
			buttonTestDylan.setPrefWidth(toolBar.getPrefWidth());
			buttonTestJorge.setPrefWidth(toolBar.getPrefWidth());
		
			
			return toolBar;
		}
}
