package controller;

import java.io.File;

import javafx.application.Platform;
import javafx.scene.image.Image;
import model.IOFile;

public class IOController {
	public static void openImage(File file){
		IOFile.selectImage(file);
		System.out.println(WorkArea.getCurrentImagePath());
	}
	public static void saveImage(){
		
	}
	public static void exit(){
		
		Platform.exit();
	}
}
