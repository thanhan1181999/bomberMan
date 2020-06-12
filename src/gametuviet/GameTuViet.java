/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametuviet;

import static gametuviet.ManHinhGame.endGame;
import static gametuviet.ManHinhGame.level;
import static gametuviet.ManHinhGame.portal;
import gametuviet.SKvoiManHinhGame.setEndGame;
import gametuviet.ThucThe.Tinh.Wall;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author An
 */
public class GameTuViet {
    public static ManHinhGame screen;
    public static int iTrangThai=0;
    public static void main(String[] args) throws InterruptedException {
        screen=new ManHinhGame();
        screen.setVisible(true);
        setEndGame seg;
        
        while (true){  
                  while (iTrangThai == 1){//đang tạm dừng 
                    Thread.sleep(300);//chờ hiệu lệnh chạy tiếp hoặc dừng công việc 
                  }
                 if (iTrangThai == 2) break;
                 screen.update();
                 if(endGame==true){
                      iTrangThai=1;
                      if(level==3 && portal.getHien()==true) {seg=new setEndGame();seg.endGame(1);}
                      else {seg=new setEndGame();seg.endGame(0);}
                 }
             }        
    }
    
}
