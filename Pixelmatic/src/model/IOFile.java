package model;
import java.io.*;
import java.io.FileInputStream;
import java.util.*;
import java.nio.file.*;

import javafx.scene.image.Image;

public class IOFile {
	
	
	public static String Select(){
		
		String image_link;
		Scanner sc = new Scanner(System.in); 
        System.out.println("Veuillez saisir la source de l'image :"); 
        image_link = sc.nextLine(); //saisie de la source
		return image_link;
	}



	public static String Save(String ImagePath) throws IOException{
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
	
    private static void askcopy(String start, String dest) throws IOException{

        Path source= Paths.get(start); //création des variables fichier
        Path destination=Paths.get(dest);
        Files.copy(source, destination);
    }

}



