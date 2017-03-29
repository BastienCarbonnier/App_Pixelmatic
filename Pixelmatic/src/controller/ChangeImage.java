package controller;

import java.io.IOException;

import model.ImageEffects;

public class ChangeImage {
	
	public static String applyBlackAndWhite(String ImagePath){
		String bwPath="";
		try {
			bwPath=ImageEffects.blackAndWhite(ImagePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bwPath;
	}
}
