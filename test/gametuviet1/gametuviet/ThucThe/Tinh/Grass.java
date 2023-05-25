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
public class Grass extends ThucThe{
    final ImageIcon iconGrass = new ImageIcon(getClass().getResource("/resources/icon/grass.png"));
    public Grass(int i,int j){
        tenThucThe="Grass";
        this.setIcon(iconGrass);
       this.setBounds(j*canhThucThe,i*canhThucThe, canhThucThe, canhThucThe);
       this.setVisible(true);
    }   
}
