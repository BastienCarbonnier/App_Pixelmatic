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
	public static void applyEffect1() throws IOException{
		//IOFile.askcopy(WorkArea.getCurrentImagePath(),ModifyPath.addToPath(WorkArea.getCurrentImagePath(),"tmp"));
		BlackAndWhiteEffect.applyEffect(WorkArea.getCurrentImagePath());
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
	public static void applyEffect2() throws IOException{
		FlouEffect.applyEffect(new File(WorkArea.getCurrentImagePath()).toURI().toString());
		InterfaceView.showImage(WorkArea.getCurrentImagePath());
	}
}
