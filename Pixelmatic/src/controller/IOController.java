package controller;

import java.io.File;
import java.io.IOException;

import javafx.application.Platform;
import javafx.scene.image.Image;
import model.IOFile;
import model.WorkingImage;
import view.InterfaceView;

public class IOController {
	public static void openImage(File selectedFile){
		/*
		if(WorkArea.getBaseImagePath()!=WorkArea.getCurrentImagePath()) {
			File current=new File(WorkArea.getCurrentImagePath());
			current.delete();
		}*/
		if(WorkingImage.getCurrentImagePath()!=null) {
			File current=new File(WorkingImage.getCurrentImagePath());
			WorkingImage.setCurrentImagePath(null);
			current.delete();
		}
		String name=IOFile.selectImage(selectedFile);
		
		if(name==null){
			InterfaceView.showInfoMessage("Aucune image de selectionné");
			return;
		}
		WorkingImage.setBaseImagePath(name);
		InterfaceView.showImage(WorkingImage.getBaseImagePath());
	}
	public static void saveAsImage() throws IOException{
		if (WorkingImage.getBaseImagePath()!=null)
			IOFile.saveAs(WorkingImage.getCurrentImagePath()!=null?WorkingImage.getCurrentImagePath():WorkingImage.getBaseImagePath());
		else
			InterfaceView.showErrorMessage("Aucune image n'est en train d'être modifié");
	}
	public static void saveImage() throws IOException {
		if (WorkingImage.getBaseImagePath()!=null)
			IOFile.save(WorkingImage.getCurrentImagePath()!=null?WorkingImage.getCurrentImagePath():WorkingImage.getBaseImagePath());
		else
			InterfaceView.showErrorMessage("Aucune image n'est en train d'être modifié");
	}
	
	/*
	public static void saveExit() throws IOException {
		String res=InterfaceView.showSaveMessage();
		if(res.equals("Oui")) 
			{IOFile.save(WorkArea.getCurrentImagePath());}
		if(res.equals("Non") || res.equals("Oui"))
			{exit();}
		return;
					
	}*/
	public static void exit() throws IOException{
		
		if(WorkingImage.getCurrentImagePath()!=null) {
			
			String res=InterfaceView.showSaveMessage();
			
			if(res.equals("Oui")) 
				IOFile.save(WorkingImage.getCurrentImagePath());
			else if(res.equals("Non")){
				File current=new File(WorkingImage.getCurrentImagePath());
				WorkingImage.setCurrentImagePath(null);
				current.delete();
			}
			else
				return;
		}
		Platform.exit();
	}
}
