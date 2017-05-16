package view;


import java.io.IOException;
import controller.ButtonHandling;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;


public class ToolbarButtonView {
	
		public static ToolBar createToolbar(){
			ToolBar toolBar;
			Button buttonEffect1 = new Button("Non-Modifie");
		
		    buttonEffect1.autosize();
		    
	        buttonEffect1.setOnAction(actionEvent -> ButtonHandling.showBaseImage());
		    
		    Button buttonEffect2 = new Button("Noir/Blanc");
		    //buttonEffect2.autosize();
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
			
		    //buttonEffect5.autosize();
	        
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
	        
	        Button buttonTestDylan = new Button("Dylan");
			
	        buttonTestDylan.autosize();
	        buttonTestDylan.setOnAction(actionEvent -> {
				
					try {
						ButtonHandling.testDylan();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        
	        Button buttonTestJorge = new Button("Jorge");
			
	        buttonTestJorge.autosize();
	        buttonTestJorge.setOnAction(actionEvent -> {
				
					try {
						ButtonHandling.testJorge();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			});
	        
	        
			toolBar = new ToolBar(
		    	     buttonEffect1,
		    	     buttonEffect2,
		    	     //buttonEffect3,
		    	     //buttonEffect4,
		    	     buttonEffect5,
		    	     buttonEffect6,
		    	     buttonEffect7,
		    	     buttonEffect8,
		    	     buttonTestDylan,
		    	     buttonTestJorge
		    	     
		    	 );
			toolBar.setOrientation(Orientation.VERTICAL);
			toolBar.setPrefWidth(100);
			
			buttonEffect1.setPrefWidth(100);
			buttonEffect2.setPrefWidth(100);
			buttonEffect3.setPrefWidth(100);
			buttonEffect4.setPrefWidth(100);
			buttonEffect5.setPrefWidth(100);
			buttonEffect6.setPrefWidth(100);
			buttonEffect7.setPrefWidth(100);
			buttonEffect8.setPrefWidth(100);
			buttonTestDylan.setPrefWidth(100);
			buttonTestJorge.setPrefWidth(100);
		
			
			return toolBar;
		}
}
