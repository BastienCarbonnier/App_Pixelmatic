package view;

import java.io.File;
import java.io.IOException;

import controller.IOController;
import controller.WorkArea;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class MenuBarView {
	
	public static MenuBar createMenuBar() {
		MenuBar menuBar = new MenuBar();
	    
	    
	    Menu pixelmaticMenu = new Menu("Pixelmatic");
	    Menu fileMenu = new Menu("Fichier");
	    Menu editMenu = new Menu("Edition");
	    Menu helpMenu = new Menu("Aide");
	    MenuItem exitMenuItem = new MenuItem("Exit");
	    MenuItem openMenuItem = new MenuItem("Open");
	    MenuItem saveAsMenuItem = new MenuItem("SaveAs..");
	    
	    
	        
	    pixelmaticMenu.getItems().addAll(exitMenuItem);
	    fileMenu.getItems().addAll(openMenuItem, saveAsMenuItem);
	    
	    exitMenuItem.setOnAction(actionEvent -> IOController.exit());
	    
	    openMenuItem.setOnAction(actionEvent -> {	    
	    	
		    	FileChooser fileChooser = new FileChooser(); 
		        File file = fileChooser.showOpenDialog(null); 
		        IOController.openImage(file);
			
		});
	    
	    saveAsMenuItem.setOnAction(actionEvent -> {	    
	        try {
				IOController.saveAsImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	    
	    menuBar.getMenus().addAll(pixelmaticMenu,fileMenu,editMenu,helpMenu);
	    return menuBar;
	}
}
