package model;

import java.io.File;

import controller.WorkArea;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;

public class FlouEffect {
	public static void applyEffect(String imagePath){
		ImageView image=new ImageView(imagePath);
		image.setEffect(new GaussianBlur());
	}
}
