package model;

import java.io.File;

public class ModifyPath {
	
	public static String addToPath(String imagePath,String supp){
		
		
        String[] splitPath=imagePath.split("\\.");
        String fileExt=splitPath[splitPath.length-1];
        String filePath="";
        
        filePath=splitPath[0];
        for(int i=1;i<splitPath.length-1;i++)
        	filePath=filePath+"."+splitPath[i];
        filePath=filePath+supp+"."+fileExt;
        
		return filePath;
	}
	public static String hideFilePathName(String imagePath){
        String[] splitPath=imagePath.split(File.separator);
        String filePath="";
        String fileName=splitPath[splitPath.length-1];
        for(int i=0;i<splitPath.length-2;i++)
        	filePath=filePath+File.separator+splitPath[i];
        filePath=filePath+File.separator+"."+fileName;
		return filePath;
	}
	
}
