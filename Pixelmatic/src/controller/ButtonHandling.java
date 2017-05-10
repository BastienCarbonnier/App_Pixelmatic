package controller;

import java.io.File;
import java.io.IOException;

import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import model.BlackAndWhiteEffect;
import model.FlouEffect;
import model.IOFile;
import model.ModifyPath;
import view.InterfaceView;

public class ButtonHandling {
	
	public static void showBaseImage(){
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		InterfaceView.showImage(WorkArea.getBaseImagePath());
	}
	public static void applyEffectBlackAndWhite() throws IOException{
		
		/*String basePath="src/view/image_2.jpg";
		String currentPath="src/view/image_2_tmp.jpg";
		
		WorkArea.setCurrentImagePath(currentPath);
		WorkArea.setBaseImagePath(basePath);*/
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		String baseImagePath=WorkArea.getBaseImagePath();
		String currentImagePath=ModifyPath.hideFilePathName(ModifyPath.addToPath(WorkArea.getBaseImagePath(),"_tmp"));
		
		IOFile.askcopy(baseImagePath,currentImagePath);
		
		WorkArea.setCurrentImagePath(currentImagePath);
		
		BlackAndWhiteEffect.applyEffect(currentImagePath);
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	public static void applyEffectGaussian() throws IOException{
		
		if (WorkArea.getBaseImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		
		String baseImagePath=WorkArea.getBaseImagePath();
		String currentImagePath=ModifyPath.hideFilePathName(ModifyPath.addToPath(WorkArea.getBaseImagePath(),"_tmp"));
		
		IOFile.askcopy(baseImagePath,currentImagePath);
		WorkArea.setCurrentImagePath(currentImagePath);
		
		FlouEffect.applyEffect(currentImagePath);
		
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
}
