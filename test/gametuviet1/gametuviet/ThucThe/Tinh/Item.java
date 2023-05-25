/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametuviet.ThucThe.Tinh;

import static gametuviet.ManHinhGame.canhThucThe;
import gametuviet.ThucThe.ThucThe;
import javax.swing.ImageIcon;

/**
 *
 * @author An
 */
public class Item extends ThucThe{
   final ImageIcon iconBombItems = new ImageIcon(getClass().getResource("/resources/icon/powerup_bombs.png")); 
   final ImageIcon iconFlameItems = new ImageIcon(getClass().getResource("/resources/icon/powerup_flames.png"));
   final ImageIcon iconSpeedItems = new ImageIcon(getClass().getResource("/resources/icon/powerup_speed.png"));
   final ImageIcon iconGrass = new ImageIcon(getClass().getResource("/resources/icon/grass.png"));
   private boolean hien=false;
   public Item(char x,int i,int j){
       switch(x){
           case 'b':this.setIcon(iconBombItems);tenThucThe="BombItem";break;
           case 'f':this.setIcon(iconFlameItems);tenThucThe="FlameItem";break;
           case 's':this.setIcon(iconSpeedItems);tenThucThe="SpeedItem";break;
       }
    yy=i;xx=j;
     this.setBounds(j*canhThucThe,i*canhThucThe, canhThucThe, canhThucThe);
   } 
   
   public void setHien(boolean x){hien=x;}
   public boolean getHien(){return hien;}
}
