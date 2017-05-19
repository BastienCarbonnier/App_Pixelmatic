package model;
import java.io.*;
import java.util.*;
import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import controller.WorkArea;
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
		WorkArea.setBaseImagePath(selectedFile.getPath());
		WorkArea.setCurrentImagePath(selectedFile.getPath());
		return selectedFile.getPath();
		
	}

	public static String save(String ImagePath) throws IOException {
		String dest=WorkArea.getBaseImagePath();
		System.out.println("source :"+ImagePath+" destination :"+dest);
		askcopy(ImagePath, dest);
		new File(ImagePath).delete();
		return ImagePath;
		
	}
	
	public static String saveAs(String ImagePath) throws IOException{
			String filename=new File(WorkArea.getBaseImagePath()).getName();
			String[] nom=filename.split("\\.");
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Save As..");
			fileChooser.setInitialFileName(nom[0]);
			fileChooser.setInitialDirectory(new File(new File(ImagePath).getParent())); //permet d'ouvrir directement dans le dossier de l'image source
			File selectedFile = fileChooser.showSaveDialog(null);		//fenetre de sélection 
			if(selectedFile==null)
				return WorkArea.getCurrentImagePath();// retourne l'image courrante si on annule
			
			askcopy(ImagePath, selectedFile.getPath()+".png");		
			//if ()
			return selectedFile.getPath();
		
	}

	
    public static void askcopy(String start, String dest) throws IOException{
        Path source= Paths.get(start); //création des variables fichier
        Path destination=Paths.get(dest);
        Files.copy(source, destination,REPLACE_EXISTING); //copie
        if((new File(start).length())!=(new File(dest).length())) { // on teste le bon déroulement de la copie
        	InterfaceView.showErrorMessage("Il y eu une erreur lors de la copie, veuillez réessayer");
        }
    }


	public static void openBrowser() {

		        String url = "test.html";

		        if(Desktop.getDesktop().isSupported(Action.BROWSE)){
		            Desktop desktop = Desktop.getDesktop();
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


