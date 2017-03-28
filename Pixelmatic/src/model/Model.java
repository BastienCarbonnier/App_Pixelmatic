package model;
import java.io.File;

import javafx.scene.image.Image;
public class Model {

	public Model(){
		
	}
	
	public static Image getImage(String path){
		
		/*String imageURI = new File(path).toURI().toString(); 
		Image image = new Image(imageURI);
		*/
		File file = new File(path);
        Image image = new Image(file.toURI().toString());
		return image;
	}
}

