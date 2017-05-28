package controller;


import java.io.IOException;
import java.net.URISyntaxException;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.ColorEffects;
import model.ContourEffects;
import model.FlouEffects;
import model.IOFile;
import model.ModifyPath;
import model.StructureEffects;
import view.InterfaceView;

/**
 * This class handle all Button in our application.
 * When a button event happen the method that it call
 * is located in this class. 
 * <p>
 * This is why we can find it in the controller package because 
 * it bind the view's method and the model's method.
 *   
 * @author Bastien Carbonnier
 * 
 * @see		WorkArea
 */

public class ButtonHandling {
	
	
	public static void showBaseImage() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		if (WorkArea.getCurrentImagePath()!=null){
			String baseImagePath=WorkArea.getBaseImagePath();
			
			String currentImagePath=ModifyPath.addToPath(WorkArea.getBaseImagePath(),"_tmp");
			IOFile.askcopy(baseImagePath,currentImagePath);
			WorkArea.setCurrentImagePath(currentImagePath);
		}
		InterfaceView.showImage(WorkArea.getBaseImagePath());
	}
	
	public static void copyImageWithRightPath() throws IOException{
		
		if (WorkArea.getCurrentImagePath()==null){
			String baseImagePath=WorkArea.getBaseImagePath();
			
			String currentImagePath=ModifyPath.addToPath(WorkArea.getBaseImagePath(),"_tmp");
			IOFile.askcopy(baseImagePath,currentImagePath);
			
			WorkArea.setCurrentImagePath(currentImagePath);
		}
	}
	
	public static void useBlackAndWhiteEffect() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		copyImageWithRightPath();
		ColorEffects.applyBlackAndWhiteEffect(WorkArea.getCurrentImagePath());
		
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	
	public static void useFlouIncrementalEffect(int strength) throws IOException{
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}

		copyImageWithRightPath();
		FlouEffects.applyFlouIncrementalEffect(WorkArea.getCurrentImagePath(),strength);
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	
	public static void useLuminosityIncrementalEffect(int strength) throws IOException{
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}

		copyImageWithRightPath();
		ColorEffects.applyLuminosityEffect(WorkArea.getCurrentImagePath(),strength);
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	
	public static void useBlurEffect() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		copyImageWithRightPath();
		
		FlouEffects.applyBlurEffect(WorkArea.getCurrentImagePath());
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	
	public static void useSepiaEffect() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		copyImageWithRightPath();		
		ColorEffects.applySepiaEffect(WorkArea.getCurrentImagePath());
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	
	public static void useNegativeEffect() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		copyImageWithRightPath();	
		
		
		ColorEffects.applyNegativeEffect(WorkArea.getCurrentImagePath());
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	
	
	public static void usePosterizeEffect() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		copyImageWithRightPath();	
				
		ColorEffects.applyPosterizeEffect(WorkArea.getCurrentImagePath());
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	public static void useAccentuationEffect() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		copyImageWithRightPath();	
		
		ContourEffects.applyAccentuationEffect(WorkArea.getCurrentImagePath());
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	
	public static void useEstampageEffect() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		copyImageWithRightPath();	
		
		ContourEffects.applyEstampageEffect(WorkArea.getCurrentImagePath());
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	public static void testDylan() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		copyImageWithRightPath();
		
		//ColorEffects.test(WorkArea.getCurrentImagePath(), 10);
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	public static void testJorge() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		copyImageWithRightPath();
		
		StructureEffects.test(WorkArea.getCurrentImagePath());
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
}
