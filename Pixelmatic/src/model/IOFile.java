package model;
import java.io.*;
import java.util.*;

import controller.WorkArea;

import java.nio.file.*;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.DirectoryChooser;
import static java.nio.file.StandardCopyOption.*;
public class IOFile {
	
	
	public static String selectImage(File fichier){
		
		String image_link="";
		if (fichier != null) {
			//copy de l'image dans le dossier du projet
            WorkArea.setCurrentImagePath(fichier.getPath());
            
        }
		
		return image_link;
	}


	
	public static String save(String ImagePath) throws IOException{
		int rep;
		String image_link;
		Scanner entier = new Scanner(System.in); 
		System.out.println("Enregistrer l'image ? (0/1)");
		rep=entier.nextInt();
		Scanner chemin=new Scanner(System.in);
		if(rep == 1) {
			System.out.println("Veuillez saisir l'emplacement de l'image :"); 
			image_link = chemin.nextLine(); //saisie de la source
			askcopy(ImagePath, image_link);
			
			return image_link;
		}
		else {
			new File(ImagePath).delete();
			return ImagePath;
		}
	}
	
    public static void askcopy(String start, String dest) throws IOException{

        Path source= Paths.get(start); //création des variables fichier
        Path destination=Paths.get(dest);
        Files.copy(source, destination,REPLACE_EXISTING);
    }

}



