package controller;

import java.io.File;
import java.io.IOException;

import javafx.application.Platform;
import javafx.scene.image.Image;
import model.IOFile;

public class IOController {
	public static void openImage(File selectedFile){
		
		WorkArea.setBaseImagePath(IOFile.selectImage(selectedFile));
	}
	public static void saveAsImage() throws IOException{
		System.out.println(WorkArea.getBaseImagePath());
		IOFile.saveAs(WorkArea.getCurrentImagePath());
	}
	public static void exit(){
		if(WorkArea.getBaseImagePath()!=WorkArea.getCurrentImagePath()) {
			File current=new File(WorkArea.getCurrentImagePath());
			current.delete();
		}
			Platform.exit();
	}
}
