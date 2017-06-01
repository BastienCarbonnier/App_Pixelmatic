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
import model.WorkingImage;
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
 * @see		WorkingImage
 */

public class ButtonEffectHandling {
	
	
	public static void showBaseImage() throws IOException{
		
		if (WorkingImage.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		if (WorkingImage.getCurrentImagePath()!=null){
			String baseImagePath=WorkingImage.getBaseImagePath();
			
			String currentImagePath=ModifyPath.addToPath(WorkingImage.getBaseImagePath(),"_tmp");
			IOFile.askcopy(baseImagePath,currentImagePath);
			WorkingImage.setCurrentImagePath(currentImagePath);
		}
		InterfaceView.showImage(WorkingImage.getBaseImagePath());
	}
	
	public static void copyImageWithRightPath() throws IOException{
		
		if (WorkingImage.getCurrentImagePath()==null){
			String baseImagePath=WorkingImage.getBaseImagePath();
			
			String currentImagePath=ModifyPath.addToPath(WorkingImage.getBaseImagePath(),"_tmp");
			IOFile.askcopy(baseImagePath,currentImagePath);
			
			WorkingImage.setCurrentImagePath(currentImagePath);
		}
	}
	
	public static void useBlackAndWhiteEffect() throws IOException{
		
		if (WorkingImage.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		copyImageWithRightPath();
		ColorEffects.applyBlackAndWhiteEffect(WorkingImage.getCurrentImagePath());
		
		
		InterfaceView.showImage(WorkingImage.getCurrentImagePath());
	}
	
	public static void useFlouIncrementalEffect(int strength) throws IOException{
		if (WorkingImage.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}

		copyImageWithRightPath();
		FlouEffects.applyFlouIncrementalEffect(WorkingImage.getCurrentImagePath(),strength);
		
		InterfaceView.showImage(WorkingImage.getCurrentImagePath());
	}
	
	public static void useLuminosityIncrementalEffect(int strength) throws IOException{
		if (WorkingImage.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}

		copyImageWithRightPath();
		ColorEffects.applyLuminosityEffect(WorkingImage.getCurrentImagePath(),strength);
		
		InterfaceView.showImage(WorkingImage.getCurrentImagePath());
	}
		
	public static void useSepiaEffect() throws IOException{
		
		if (WorkingImage.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		copyImageWithRightPath();		
		ColorEffects.applySepiaEffect(WorkingImage.getCurrentImagePath());
		
		InterfaceView.showImage(WorkingImage.getCurrentImagePath());
	}
	
	public static void useNegativeEffect() throws IOException{
		
		if (WorkingImage.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		copyImageWithRightPath();	
		
		
		ColorEffects.applyNegativeEffect(WorkingImage.getCurrentImagePath());
		
		InterfaceView.showImage(WorkingImage.getCurrentImagePath());
	}
	
	
	public static void usePosterizeEffect() throws IOException{
		
		if (WorkingImage.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		copyImageWithRightPath();	
				
		ColorEffects.applyPosterizeEffect(WorkingImage.getCurrentImagePath());
		
		InterfaceView.showImage(WorkingImage.getCurrentImagePath());
	}
	public static void useAccentuationEffect() throws IOException{
		
		if (WorkingImage.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		copyImageWithRightPath();	
		
		ContourEffects.applyAccentuationEffect(WorkingImage.getCurrentImagePath());
		
		InterfaceView.showImage(WorkingImage.getCurrentImagePath());
	}
	
	public static void useEstampageEffect() throws IOException{
		
		if (WorkingImage.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		copyImageWithRightPath();	
		
		StructureEffects.applyMirrorEffect(WorkingImage.getCurrentImagePath());
		
		InterfaceView.showImage(WorkingImage.getCurrentImagePath());
	}
		
	public static void useMirrorEffect() throws IOException{
		
		if (WorkingImage.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		copyImageWithRightPath();	
		
		StructureEffects.applyMirrorEffect(WorkingImage.getCurrentImagePath());
		
		InterfaceView.showImage(WorkingImage.getCurrentImagePath());
	}
	
	
public static void use180Effect() throws IOException{
		
		if (WorkingImage.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image"); 
			return;
		}
		
		copyImageWithRightPath();	
		
		StructureEffects.apply180Effect(WorkingImage.getCurrentImagePath());
		
		InterfaceView.showImage(WorkingImage.getCurrentImagePath());
	}


	public static void testDylan() throws IOException{
		
		if (WorkingImage.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		copyImageWithRightPath();
		
		//ColorEffects.test(WorkArea.getCurrentImagePath(), 10);
		
		InterfaceView.showImage(WorkingImage.getCurrentImagePath());
	}
	public static void testJorge() throws IOException{
		
		if (WorkingImage.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		copyImageWithRightPath();
		
		StructureEffects.test(WorkingImage.getCurrentImagePath());
		
		InterfaceView.showImage(WorkingImage.getCurrentImagePath());
	}
}
