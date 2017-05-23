package view;

import java.awt.Desktop;
import java.awt.Desktop.Action;
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
import model.IOFile;

public class MenuBarView {
	
	public static MenuBar createMenuBar() {
		MenuBar menuBar = new MenuBar();
	    
	    
	    Menu pixelmaticMenu = new Menu("Pixelmatic");
	    Menu fileMenu = new Menu("Fichier");
	    Menu editMenu = new Menu("Edition");
	    Menu helpMenu = new Menu("Aide");
	    MenuItem exitMenuItem = new MenuItem("Exit");
	    MenuItem openMenuItem = new MenuItem("Open");
	    MenuItem saveMenuItem = new MenuItem("Save");
	    MenuItem saveAsMenuItem = new MenuItem("SaveAs..");
	    MenuItem getHelpItem= new MenuItem("get help");
	    
	    
	        
	    pixelmaticMenu.getItems().addAll(exitMenuItem);
	    fileMenu.getItems().addAll(openMenuItem, saveMenuItem, saveAsMenuItem);
	    helpMenu.getItems().addAll(getHelpItem);
	    exitMenuItem.setOnAction(actionEvent -> {
			try {
				IOController.exit();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	    
	    openMenuItem.setOnAction(actionEvent -> {	    
	    	
		    	FileChooser fileChooser = new FileChooser(); 
		        File file = fileChooser.showOpenDialog(null); 
		        IOController.openImage(file);
			
		});
	    getHelpItem.setOnAction(actionEvent -> {
	    	IOFile.openBrowser();

	    });
	    saveAsMenuItem.setOnAction(actionEvent -> {	    
	        try {
				IOController.saveAsImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	    
	    
	    saveMenuItem.setOnAction(actionEvent -> {	    
	        try {
				IOController.saveImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	    menuBar.getMenus().addAll(pixelmaticMenu,fileMenu,editMenu,helpMenu);
	    return menuBar;
	}
}
