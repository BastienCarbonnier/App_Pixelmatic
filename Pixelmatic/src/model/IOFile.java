package model;
import java.io.*;
import java.util.*;

import controller.WorkArea;

import java.nio.file.*;
//

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.*;
import javafx.stage.Window;
import static java.nio.file.StandardCopyOption.*;
public class IOFile {
	
	
	public static String selectImage(File selectedFile){
		if (selectedFile==null)
			return null;
		
		return selectedFile.getPath();
		
	}


	
	public static String saveAs(String ImagePath) throws IOException{

			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Save As..");
			fileChooser.setInitialFileName(ImagePath);
			File selectedFile = fileChooser.showOpenDialog(null);
			System.out.println(selectedFile.getPath());
			askcopy(ImagePath, selectedFile.getPath());			
			return selectedFile.getPath();
		
	}

	
    public static void askcopy(String start, String dest) throws IOException{

        Path source= Paths.get(start); //création des variables fichier
        Path destination=Paths.get(dest);
        Files.copy(source, destination,REPLACE_EXISTING);
    }

}



