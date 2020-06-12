package gametuviet.ThucThe.Dong;

import static gametuviet.ManHinhGame.canhThucThe;
import gametuviet.ThucThe.ThucThe;
import gametuviet.ThucThe.Tinh.Brick;
import gametuviet.ThucThe.Tinh.Wall;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.Random;
import javax.swing.ImageIcon;
import static jdk.nashorn.internal.objects.NativeMath.random;
/**
 * @author An
 */
public class Balloon extends Enemy {
    final ImageIcon[] iconBallom = {
        new ImageIcon(getClass().getResource("/resources/icon/balloom_left1.png")),
        new ImageIcon(getClass().getResource("/resources/icon/balloom_left2.png")),
        new ImageIcon(getClass().getResource("/resources/icon/balloom_left3.png")),
        new ImageIcon(getClass().getResource("/resources/icon/balloom_right1.png")),
        new ImageIcon(getClass().getResource("/resources/icon/balloom_right2.png")),
        new ImageIcon(getClass().getResource("/resources/icon/balloom_right3.png"))
    };
    ImageIcon iconBallomDead = new ImageIcon(getClass().getResource("/resources/icon/balloom_dead.png"));
    /*
    khoi tao
    */
    public Balloon(int kitu,int i,int j,int soHang,int soCot){
        tenThucThe="Balloon";
        switch (kitu){
            case 0:this.setIcon(iconBallom[0]);break;
            case 1:this.setIcon(iconBallom[1]);break;
            case 2:this.setIcon(iconBallom[2]);break;
            case 3:this.setIcon(iconBallom[3]);break;
            case 4:this.setIcon(iconBallom[4]);break;
            case 5:this.setIcon(iconBallom[5]);break;
        }
       xx=j;yy=i;
       realDoc=yy*32;realNgang=xx*32;realDoc=yy*32;realNgang=xx*32;
       this.setBounds(j*canhThucThe,i*canhThucThe, canhThucThe, canhThucThe);
    }
    
    public void setIcon(char x){
        switch(x){
            case 'u':this.setIcon(iconBallom[0]);break;
            case 'd':this.setIcon(iconBallom[3]);break;
            case 'l':this.setIcon(iconBallom[0]);break;
            case 'r':this.setIcon(iconBallom[3]);break;
        }
    }
}
