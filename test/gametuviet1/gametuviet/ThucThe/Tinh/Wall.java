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
public class Wall extends ThucThe{
    private final ImageIcon iconWall = new ImageIcon(getClass().getResource("/resources/icon/wall.png"));
    public Wall(int i,int j){
        this.setIcon(iconWall);
        tenThucThe="Wall";
        this.setBounds(j*canhThucThe,i*canhThucThe, canhThucThe, canhThucThe);
    }   
}
