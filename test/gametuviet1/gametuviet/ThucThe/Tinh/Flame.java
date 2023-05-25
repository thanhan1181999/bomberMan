/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametuviet.ThucThe.Tinh;

import gametuviet.ManHinhGame;
import static gametuviet.ManHinhGame.canhThucThe;
import gametuviet.ThucThe.ThucThe;
import javax.swing.ImageIcon;

/**
 *
 * @author An
 */
public class Flame extends ThucThe{
    ImageIcon iconFlameUD = new ImageIcon(getClass().getResource("/resources/icon/explosion_vertical.png"));
    ImageIcon iconFlameLR = new ImageIcon(getClass().getResource("/resources/icon/explosion_horizontal.png"));
     final ImageIcon[] iconBrick = {
        new ImageIcon(getClass().getResource("/resources/icon/brick_exploded.png")),
        new ImageIcon(getClass().getResource("/resources/icon/brick_exploded1.png")),
        new ImageIcon(getClass().getResource("/resources/icon/brick_exploded2.png"))
    };
    public Flame(char ttt,char tt,int i,int j){
        xx=j;yy=i;
        realDoc=i*32;realNgang=j*32;
        switch(tt){
            case 'u':if(ttt=='b')this.setIcon(iconBrick[2]);else this.setIcon(iconFlameUD);break;
            case 'd':if(ttt=='b')this.setIcon(iconBrick[2]);else this.setIcon(iconFlameUD);break;
            case 'l':if(ttt=='b')this.setIcon(iconBrick[2]);else this.setIcon(iconFlameLR);break;
            case 'r':if(ttt=='b')this.setIcon(iconBrick[2]);else this.setIcon(iconFlameLR);break;
        } 
        this.setBounds(xx*canhThucThe,yy*canhThucThe,canhThucThe,canhThucThe);
    }
}
