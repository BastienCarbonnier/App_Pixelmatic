package controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WorkArea {
	private static String currentImagePath;
	private static String baseImagePath;
	
	public WorkArea(String image){
		baseImagePath=image;
		
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
	public int getHeightCurrentImage(){
		return (int) new Image(currentImagePath).getHeight();
	}
	public int getWidthCurrentImage(){
		return (int) new Image(currentImagePath).getWidth();
	}
	
}
