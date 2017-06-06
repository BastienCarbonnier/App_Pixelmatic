package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WorkingImage {
	private static String currentImagePath;
	private static String baseImagePath;
	
	public WorkingImage(){
		baseImagePath=null;
		currentImagePath=null;
	}
	
	public static String getCurrentImagePath(){
		return currentImagePath;
	}
	public static String getBaseImagePath(){
		return baseImagePath;
	}
	public static void setCurrentImagePath(String image){
		currentImagePath=image;
	}
	public static void setBaseImagePath(String image){
		baseImagePath=image;
	}
	
	
	
}
