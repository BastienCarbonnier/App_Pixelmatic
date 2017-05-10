package view;


import java.io.IOException;
import controller.ButtonHandling;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;


public class ToolbarButtonView {
	
		public static ToolBar createToolbar(){
			Button buttonEffect1 = new Button("Non-Modifie");
		
		    buttonEffect1.autosize();
		    
	        buttonEffect1.setOnAction(actionEvent -> ButtonHandling.showBaseImage());
		    
		    Button buttonEffect2 = new Button("Noir/Blanc");
		    buttonEffect2.autosize();
		    buttonEffect2.setOnAction(actionEvent -> {
				try {
					ButtonHandling.useBlackAndWhiteEffect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		    
		    Button buttonEffect3 = new Button("Flou Gaussien");
			
		    buttonEffect3.autosize();
	        buttonEffect3.setOnAction(actionEvent -> {
				try {
					ButtonHandling.useGaussianEffect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
	        
	        Button buttonEffect4 = new Button("Trouble");
			
		    buttonEffect4.autosize();
	        buttonEffect4.setOnAction(actionEvent -> {
				try {
					ButtonHandling.useBlurEffect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
	        
	        Button buttonEffect5 = new Button("Sepia");
			
		    buttonEffect5.autosize();
	        buttonEffect5.setOnAction(actionEvent -> {
				
					try {
						ButtonHandling.useSepiaEffect();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        
	        Button buttonEffect6 = new Button("Negatif");
			
		    buttonEffect6.autosize();
	        buttonEffect6.setOnAction(actionEvent -> {
				
					try {
						ButtonHandling.useNegativeEffect();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        Button buttonEffect7 = new Button("Accentuation");
			
		    buttonEffect7.autosize();
	        buttonEffect7.setOnAction(actionEvent -> {
				
					try {
						ButtonHandling.useAccentuationEffect();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        
	        Button buttonEffect8 = new Button("Estampage");
			
		    buttonEffect8.autosize();
	        buttonEffect8.setOnAction(actionEvent -> {
				
					try {
						ButtonHandling.useEstampageEffect();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        
			ToolBar toolBar = new ToolBar(
		    	     buttonEffect1,
		    	     buttonEffect2,
		    	     //buttonEffect3,
		    	     //buttonEffect4,
		    	     buttonEffect5,
		    	     buttonEffect6,
		    	     buttonEffect7,
		    	     buttonEffect8
		    	 );
			
			return toolBar;
		}
}
