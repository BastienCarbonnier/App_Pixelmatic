package controller;

import java.io.File;
import java.io.IOException;

import javafx.application.Platform;
import javafx.scene.image.Image;
import model.IOFile;
import view.InterfaceView;

public class IOController {
	public static void openImage(File selectedFile){
		if(WorkArea.getBaseImagePath()!=WorkArea.getCurrentImagePath()) {
			File current=new File(WorkArea.getCurrentImagePath());
			current.delete();
		}
		String name=IOFile.selectImage(selectedFile);
		
		if(name==null){
			InterfaceView.showErrorMessage("Choisissez d'abord une image");
			return;
		}
		WorkArea.setBaseImagePath(name);
		InterfaceView.showImage(WorkArea.getBaseImagePath());
	}
	public static void saveAsImage() throws IOException{
		IOFile.saveAs(WorkArea.getCurrentImagePath());
	}
	public static void saveImage() throws IOException {
		IOFile.save(WorkArea.getCurrentImagePath());
	}
	public static void exit(){
		if(WorkArea.getBaseImagePath()!=WorkArea.getCurrentImagePath()) {
			File current=new File(WorkArea.getCurrentImagePath());
			current.delete();
		}
			Platform.exit();
	}
}
