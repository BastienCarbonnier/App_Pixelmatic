package model;
import java.io.*;
import java.util.*;

import controller.IOController;

import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import model.WorkingImage;
import java.net.*;
import java.nio.file.*;
//

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.*;
import view.InterfaceView;
import javafx.stage.Window;
import static java.nio.file.StandardCopyOption.*;
public class IOFile {
	
	
	public static String selectImage(File selectedFile){
		if (selectedFile==null)
			return null;
		model.WorkingImage.setBaseImagePath(selectedFile.getPath());
		return selectedFile.getPath();
		
	}

	public static String save(String ImagePath) throws IOException {
		String dest=model.WorkingImage.getBaseImagePath();
		askcopy(ImagePath, dest);
		if (ImagePath!=dest)
			new File(ImagePath).delete();
		model.WorkingImage.setCurrentImagePath(null);
		return ImagePath;
		
	}
	
	public static String saveAs(String ImagePath) throws IOException{
			String filename=new File(model.WorkingImage.getBaseImagePath()).getName();
			String[] nom=filename.split("\\.");
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Save As..");
			fileChooser.setInitialFileName(nom[0]);
			fileChooser.setInitialDirectory(new File(new File(ImagePath).getParent()));											 //permet d'ouvrir directement dans le dossier de l'image source
			File selectedFile = fileChooser.showSaveDialog(null);																	//fenetre de sélection 
			if(selectedFile==null)
				return model.WorkingImage.getCurrentImagePath()!=null?model.WorkingImage.getCurrentImagePath():model.WorkingImage.getBaseImagePath();				// retourne l'image courrante si on annule
			askcopy(ImagePath, selectedFile.getPath()+".png");		
			
			new File(WorkingImage.getCurrentImagePath()).delete();
			model.WorkingImage.setCurrentImagePath(null);
			IOController.openImage(new File(selectedFile.getPath()+".png"));
		 	return selectedFile.getPath();
		
	}

	
    public static void askcopy(String start, String dest) throws IOException{
        Path source= Paths.get(start); 
        Path destination=Paths.get(dest);
        Files.copy(source, destination,REPLACE_EXISTING); 
        if((new File(start).length())!=(new File(dest).length())) { 
        	InterfaceView.showErrorMessage("Il y eu une erreur lors de la copie, veuillez réessayer");
        }
    }


	public static void openBrowser() {

		        String url ="http://infolimon.iutmontp.univ-montp2.fr/~meunierd/web-as-meunierd/Pixelmatic/";

		        if(Desktop.getDesktop().isSupported(Action.BROWSE)){
		            Desktop desktop=Desktop.getDesktop(); 
		            try {
		                desktop.browse(new URI(url));
		            } catch (IOException | URISyntaxException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }
		        }else{
		            Runtime runtime = Runtime.getRuntime();
		            try {
		                runtime.exec("xdg-open " + url);
		            } catch (IOException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }
		        }
	}

}


