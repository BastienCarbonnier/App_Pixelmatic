package controller;

import java.io.File;
import javafx.print.*;
import java.io.IOException;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import model.IOFile;
import view.InterfaceView;

public class IOController {
	public static void openImage(File selectedFile){
		if(model.WorkingImage.getCurrentImagePath()!=null) {
			File current=new File(model.WorkingImage.getCurrentImagePath());
			model.WorkingImage.setCurrentImagePath(null);
			current.delete();
		}
		String name=IOFile.selectImage(selectedFile);	
		if(name==null){
			InterfaceView.showInfoMessage("Aucune image de selectionné");
			return;
		}
		model.WorkingImage.setBaseImagePath(name);
		InterfaceView.showImage(model.WorkingImage.getBaseImagePath());
	}
	
	
	public static void saveAsImage() throws IOException{
		if (model.WorkingImage.getBaseImagePath()!=null)
			IOFile.saveAs(model.WorkingImage.getCurrentImagePath()!=null?model.WorkingImage.getCurrentImagePath():model.WorkingImage.getBaseImagePath());
		else
			InterfaceView.showErrorMessage("Aucune image n'est en train d'être modifié");
	}
	public static void saveImage() throws IOException {
		if (model.WorkingImage.getBaseImagePath()!=null)
			IOFile.save(model.WorkingImage.getCurrentImagePath()!=null?model.WorkingImage.getCurrentImagePath():model.WorkingImage.getBaseImagePath());
		else
			InterfaceView.showErrorMessage("Aucune image n'est en train d'être modifié");
	}
	
	
	public static void saveExit() throws IOException {
		String res=InterfaceView.showSaveMessage();
		if(res=="Oui") 
			{IOFile.save(model.WorkingImage.getCurrentImagePath());}
		if(res=="Non" || res=="Oui")
			{exit();}
		return;				
	}
	
	
	public static void print() {
		ImageView image;
		if(model.WorkingImage.getCurrentImagePath()!=null) {
			image=new ImageView(new File(model.WorkingImage.getCurrentImagePath()).toURI().toString());
		}
		else if(model.WorkingImage.getBaseImagePath()!=null) {
			image=new ImageView(new File(model.WorkingImage.getBaseImagePath()).toURI().toString());
		}
		else {
			InterfaceView.showErrorMessage("Aucune image sélectionnée");
			return;
		}
		PrinterJob job = PrinterJob.createPrinterJob();
		if(job.showPrintDialog(null)) {		
			boolean success = job.printPage(image);
				if (success) {
					job.endJob(); 
				}
		}

	}
	
	
	public static void exit(){

		if(model.WorkingImage.getCurrentImagePath()!=null) {
			File current=new File(model.WorkingImage.getCurrentImagePath());
			model.WorkingImage.setCurrentImagePath(null);
			current.delete();
		}
		Platform.exit();
	}
}
