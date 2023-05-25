package gametuviet;

import gametuviet.ThucThe.ThucThe;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
/**
 *
 * @author An
 */
public class LoadLevel {
    private int level,soHang,soCot;
    private char[][] map; 
    public int getLevel(){return level;}
    public int getSoHang(){return soHang;}
    public int getSoCot(){return soCot;}
    public char[][] getMap(){return map;}
    /**
     * doc tu file
     * if la gi thi them vao map
     */
    public void loadMap(int x){
        try{
                        String path=new String("/resources/levels/Level"+String.valueOf(x)+".txt");
			URL absPath = LoadLevel.class.getResource(path);
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(absPath.openStream()));
			int x1 = Integer.parseInt(in.readLine());
			int x2 = Integer.parseInt(in.readLine());
			int x3 = Integer.parseInt(in.readLine());
                        map=new char[x2+2][x3+2];
                        String data;
			for(int i = 0; i < x2; ++i) {
				data=in.readLine();
                                for (int j=0; j<x3;j++) map[i+1][j+1]=data.charAt(j);
 			}		                      
			in.close();
                        level=x1;soHang=x2;soCot=x3;
        }
        catch(Exception o){
            o.printStackTrace();
        }
    }
}
