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
		InterfaceView.showImage(WorkArea.getBaseImagePath());
	}
	public static void applyEffectBlackAndWhite() throws IOException{
		
		String basePath="src/view/image_2.jpg";
		String currentPath="src/view/image_2_tmp.jpg";
		
		WorkArea.setCurrentImagePath(currentPath);
		WorkArea.setBaseImagePath(basePath);
		IOFile.askcopy(WorkArea.getBaseImagePath(),ModifyPath.addToPath(WorkArea.getBaseImagePath(),"_tmp"));
		//IOFile.askcopy(basePath,currentPath);
		
		WorkArea.setCurrentImagePath("src/view/image_2_tmp.jpg");
		BlackAndWhiteEffect.applyEffect("src/view/image_2_tmp.jpg");
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	public static void applyEffectGaussian() throws IOException{
		//String currentPath="src/view/image_2.jpg";
		//WorkArea.setCurrentImagePath(currentPath);
		if (WorkArea.getCurrentImagePath()==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		FlouEffect.applyEffect(new File(WorkArea.getCurrentImagePath()).toURI().toString());
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
}
