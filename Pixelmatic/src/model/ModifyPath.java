package model;

public class ModifyPath {
	
	public static String addToPath(String imagePath,String supp){
		
		String bwPath="";
        for (int i=0;i<imagePath.length()-size_ext(imagePath);i++)
        	bwPath=bwPath+imagePath.substring(i,i+1);
        bwPath=bwPath+supp+imagePath.substring(imagePath.length()-size_ext(imagePath),imagePath.length());
        
		return bwPath;
	}
	
	public static int size_ext(String path){
		//String[] sep_ext=path.split(".");
		//System.out.println(sep_ext[0]);
		return 5;//sep_ext[1].length();
	}
}
