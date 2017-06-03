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
import javafx.stage.Window;
import model.IOFile;
import view.InterfaceView;

public class IOController {
	public static void openImage(File selectedFile){
		if(model.WorkingImage.getCurrentImagePath()!=null) {
			boolean exit=true;
			try {
				exit=saveExit();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!exit)
				return;
		}
		String name=IOFile.selectImage(selectedFile);	
		if(name==null){
			InterfaceView.showInfoMessage("Aucune image selectionnée");
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
	
	
	public static boolean saveExit() throws IOException {
		String res=InterfaceView.showSaveMessage();
		if(res=="Oui") 
			{IOFile.saveAs(model.WorkingImage.getCurrentImagePath());}
		else if (res=="Non"){
			File current=new File(model.WorkingImage.getCurrentImagePath());
			current.delete();
			model.WorkingImage.setCurrentImagePath(null);
		}
		else
			return false;
		return true;			
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
		
		if(job.showPrintDialog(image.getScene().getWindow())) {		
			boolean success = job.printPage(image);
				if (success) {
					job.endJob(); 
				}
		}

	}
	
	
	public static void exit(){
		boolean exit=true;
		if(model.WorkingImage.getCurrentImagePath()!=null) {
			
			try {
				exit=saveExit();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (exit)
			Platform.exit();
		
	}
}
