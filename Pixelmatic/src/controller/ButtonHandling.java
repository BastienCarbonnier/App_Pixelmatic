package controller;


import java.io.IOException;
import java.net.URISyntaxException;

import model.ColorEffects;
import model.ContourEffects;
import model.FlouEffects;
import model.IOFile;
import model.ModifyPath;
import model.StructureEffects;
import view.InterfaceView;

public class ButtonHandling {
	
	public static void showBaseImage(){
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		InterfaceView.showImage(WorkArea.getBaseImagePath());
	}
	public static void useBlackAndWhiteEffect() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		String currentImagePath;
		String baseImagePath;
		System.out.println(WorkArea.getCurrentImagePath());
		if (WorkArea.getCurrentImagePath()==null){
			baseImagePath=WorkArea.getBaseImagePath();
			
			currentImagePath=ModifyPath.addToPath(WorkArea.getBaseImagePath(),"_tmp");
			IOFile.askcopy(baseImagePath,currentImagePath);
			
			WorkArea.setCurrentImagePath(currentImagePath);
		}
		System.out.println(WorkArea.getCurrentImagePath());
		ColorEffects.applyBlackAndWhiteEffect(WorkArea.getCurrentImagePath());
		
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	public static void useFlouIncrementalEffect(int strength) throws IOException{
		
		
		String baseImagePath=WorkArea.getBaseImagePath();
		String currentImagePath=ModifyPath.addToPath(WorkArea.getBaseImagePath(),"_tmp");
		
		IOFile.askcopy(baseImagePath,currentImagePath);
		WorkArea.setCurrentImagePath(currentImagePath);
		
		FlouEffects.applyFlouIncrementalEffect(currentImagePath,strength);
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	
	public static void useBlurEffect() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		String baseImagePath=WorkArea.getBaseImagePath();
		String currentImagePath=ModifyPath.addToPath(WorkArea.getBaseImagePath(),"_tmp");
		
		IOFile.askcopy(baseImagePath,currentImagePath);
		
		WorkArea.setCurrentImagePath(currentImagePath);
		
		FlouEffects.applyBlurEffect(currentImagePath);
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	
	public static void useSepiaEffect() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		String baseImagePath=WorkArea.getBaseImagePath();
		String currentImagePath=ModifyPath.addToPath(WorkArea.getBaseImagePath(),"_tmp");
		
		IOFile.askcopy(baseImagePath,currentImagePath);
		WorkArea.setCurrentImagePath(currentImagePath);
		
		ColorEffects.applySepiaEffect(currentImagePath);
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	
	public static void useNegativeEffect() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		String baseImagePath=WorkArea.getBaseImagePath();
		String currentImagePath=ModifyPath.addToPath(WorkArea.getBaseImagePath(),"_tmp");
		
		IOFile.askcopy(baseImagePath,currentImagePath);
		WorkArea.setCurrentImagePath(currentImagePath);
		
		ColorEffects.applyNegativeEffect(currentImagePath);
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	
	
	public static void usePosterizeEffect() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		String baseImagePath=WorkArea.getBaseImagePath();
		String currentImagePath=ModifyPath.addToPath(WorkArea.getBaseImagePath(),"_tmp");
		
		IOFile.askcopy(baseImagePath,currentImagePath);
		WorkArea.setCurrentImagePath(currentImagePath);
		
		ColorEffects.applyPosterizeEffect(currentImagePath);
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	public static void useAccentuationEffect() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		String baseImagePath=WorkArea.getBaseImagePath();
		String currentImagePath=ModifyPath.addToPath(WorkArea.getBaseImagePath(),"_tmp");
		
		IOFile.askcopy(baseImagePath,currentImagePath);
		WorkArea.setCurrentImagePath(currentImagePath);
		
		ContourEffects.applyAccentuationEffect(currentImagePath);
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	
	public static void useEstampageEffect() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		String baseImagePath=WorkArea.getBaseImagePath();
		String currentImagePath=ModifyPath.addToPath(WorkArea.getBaseImagePath(),"_tmp");
		
		IOFile.askcopy(baseImagePath,currentImagePath);
		WorkArea.setCurrentImagePath(currentImagePath);
		
		ContourEffects.applyEstampageEffect(currentImagePath);
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	public static void testDylan() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		String baseImagePath=WorkArea.getBaseImagePath();
		String currentImagePath=ModifyPath.addToPath(WorkArea.getBaseImagePath(),"_tmp");
		
		IOFile.askcopy(baseImagePath,currentImagePath);
		WorkArea.setCurrentImagePath(currentImagePath);
		
		ColorEffects.test(currentImagePath);
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	public static void testJorge() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		String baseImagePath=WorkArea.getBaseImagePath();
		String currentImagePath=ModifyPath.addToPath(WorkArea.getBaseImagePath(),"_tmp");
		
		IOFile.askcopy(baseImagePath,currentImagePath);
		WorkArea.setCurrentImagePath(currentImagePath);
		
		StructureEffects.test(currentImagePath);
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
}
