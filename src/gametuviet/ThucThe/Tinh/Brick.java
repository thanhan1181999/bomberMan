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
public class Brick extends ThucThe{
    final ImageIcon[] iconBrick = {
        new ImageIcon(getClass().getResource("/resources/icon/brick.png")),
        new ImageIcon(getClass().getResource("/resources/icon/brick_exploded.png")),
        new ImageIcon(getClass().getResource("/resources/icon/brick_exploded1.png")),
        new ImageIcon(getClass().getResource("/resources/icon/brick_exploded2.png"))
    };
    public Brick(int i,int j){
        tenThucThe="Brick";
        this.setIcon(iconBrick[0]);
       this.setBounds(j*canhThucThe,i*canhThucThe, canhThucThe, canhThucThe);
    }
}
