package controller;

import java.io.File;
import java.io.IOException;

import javafx.application.Platform;
import javafx.scene.image.Image;
import model.IOFile;
import view.InterfaceView;

public class IOController {
	public static void openImage(File selectedFile){
		/*
		if(WorkArea.getBaseImagePath()!=WorkArea.getCurrentImagePath()) {
			File current=new File(WorkArea.getCurrentImagePath());
			current.delete();
		}*/
		if(WorkArea.getCurrentImagePath()!=null) {
			File current=new File(WorkArea.getCurrentImagePath());
			WorkArea.setCurrentImagePath(null);
			current.delete();
		}
		String name=IOFile.selectImage(selectedFile);
		
		if(name==null){
			InterfaceView.showInfoMessage("Aucune image de selectionné");
			return;
		}
		WorkArea.setBaseImagePath(name);
		InterfaceView.showImage(WorkArea.getBaseImagePath());
	}
	public static void saveAsImage() throws IOException{
		if (WorkArea.getBaseImagePath()!=null)
			IOFile.saveAs(WorkArea.getCurrentImagePath()!=null?WorkArea.getCurrentImagePath():WorkArea.getBaseImagePath());
		else
			InterfaceView.showErrorMessage("Aucune image n'est en train d'être modifié");
	}
	public static void saveImage() throws IOException {
		if (WorkArea.getBaseImagePath()!=null)
			IOFile.save(WorkArea.getCurrentImagePath()!=null?WorkArea.getCurrentImagePath():WorkArea.getBaseImagePath());
		else
			InterfaceView.showErrorMessage("Aucune image n'est en train d'être modifié");
	}
	public static void exit(){
		/*
		if(WorkArea.getBaseImagePath()!=WorkArea.getCurrentImagePath()) {
			File current=new File(WorkArea.getCurrentImagePath());
			current.delete();
		}*/
		if(WorkArea.getCurrentImagePath()!=null) {
			File current=new File(WorkArea.getCurrentImagePath());
			WorkArea.setCurrentImagePath(null);
			current.delete();
		}
		Platform.exit();
	}
}
