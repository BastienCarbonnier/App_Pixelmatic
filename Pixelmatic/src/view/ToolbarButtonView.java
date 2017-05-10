package view;


import java.io.IOException;
import controller.ButtonHandling;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;


public class ToolbarButtonView {
	
		public static ToolBar createToolbar(){
			Button buttonEffect1 = new Button("Non-Modifie");
		
		    buttonEffect1.autosize();
		    
	        //ImageView image = new ImageView(new File("src/view/image_2.jpeg").toURI().toString());
	        buttonEffect1.setOnAction(actionEvent -> ButtonHandling.showBaseImage());
		    
		    Button buttonEffect2 = new Button("Noir/Blanc");
		    buttonEffect2.autosize();
		    buttonEffect2.setOnAction(actionEvent -> {
				try {
					ButtonHandling.applyEffectBlackAndWhite();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		    
		    Button buttonEffect3 = new Button("Flou Gaussien");
			
		    buttonEffect3.autosize();
	        buttonEffect3.setOnAction(actionEvent -> {
				try {
					ButtonHandling.applyEffectGaussian();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
	        
			ToolBar toolBar = new ToolBar(
		    	     buttonEffect1,
		    	     buttonEffect2,
		    	     buttonEffect3
		    	 );
			
			return toolBar;
		}
}
