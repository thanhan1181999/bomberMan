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
public class Portal extends ThucThe{
    final ImageIcon iconPortal = new ImageIcon(getClass().getResource("/resources/icon/portal.png"));
    final ImageIcon iconBrick = new ImageIcon(getClass().getResource("/resources/icon/brick.png"));
    private boolean Hien=false;
    /**
     * hien anh cua cong khi chua pha va da pha da
     **/
    public Portal(int i,int j){
        tenThucThe="Portal";
        yy=i;xx=j;
        this.setIcon(iconPortal);
       this.setBounds(j*canhThucThe,i*canhThucThe, canhThucThe, canhThucThe);
    }
    public void setHien(boolean x){Hien=x;this.setIcon(iconPortal);}
    public boolean getHien(){return Hien;};
}
