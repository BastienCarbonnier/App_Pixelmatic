package model;
import java.io.File;
import java.util.*;

import javafx.scene.image.Image;

public class IOFile {
	
	
	public static String Select(){
		
		String image_link;
		Scanner sc = new Scanner(System.in); 
        System.out.println("Veuillez saisir la source de l'image :"); 
        image_link = sc.nextLine(); //saisie de la source
		return image_link;
	}



	public static String Save(String ImagePath){
		char rep;
		File original=new File(ImagePath);
		String image_link;
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enregistrer l'image ? (y/N");
		rep=sc.nextLine();
		if(rep == 'y' || rep=='Y') {
			System.out.println("Veuillez saisir l'emplacement de l'image :"); 
			image_link = sc.nextLine(); //saisie de la source
			copy(original, image_link);
			return image_link;
		}
		
		else {
			File modified=new File(ImagePath).delete();
			return ImagePath;
		}
	}
	
    private static boolean copy(String start, String dest){

        boolean result=false; 
        File original=new File(start); //création des variables fichier
        File modified=new File(dest);
        result=hardcopy(original, modified);
		return result;
    }

    private static boolean hardcopy(File original, File modified) {
    	boolean result=false;
        FileInputStream fileOriginal=null;
        FileOutputStream fileModified=null;
        try{
            fileOriginal=new FileInputStream(original);
            fileModified=new FileOutputStream(modified));
            byte buffer[]=new byte[512*1024];
            while((int reading=filesource.read(buffer))!=-1){
                fileModified.write(buffer,0,reading);
            }
        result=true;
        }
        catch(FileNotFoundException nf){
            nf.printStackTrace();
        }
        catch(IOException io) {
            io.printStackTrace();
        }
        finally {
            try {
                fileOriginal.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            try{
                fileModified.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        } 
        return result;
    }
}



