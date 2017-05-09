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
	    
	    
	        
	    pixelmaticMenu.getItems().addAll(exitMenuItem);
	    fileMenu.getItems().addAll(openMenuItem);
	    exitMenuItem.setOnAction(actionEvent -> Platform.exit());
	    openMenuItem.setOnAction(actionEvent -> {
	    	FileChooser fileChooser = new FileChooser(); 
	        File file = fileChooser.showOpenDialog(null); 
	        IOController.openImage(file);
		});
	    
	    menuBar.getMenus().addAll(pixelmaticMenu,fileMenu,editMenu,helpMenu);
	    return menuBar;
	}
}
