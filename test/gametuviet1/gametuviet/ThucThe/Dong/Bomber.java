package gametuviet.ThucThe.Dong;

import gametuviet.ManHinhGame;
import static gametuviet.ManHinhGame.canhThucThe;
import static gametuviet.ManHinhGame.enemy;
import static gametuviet.ManHinhGame.mang;
import static gametuviet.ManHinhGame.pane;
import gametuviet.ThucThe.ThucThe;
import gametuviet.ThucThe.Tinh.Flame;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author An
 */
public class Bomber extends ThucTheDong {
    final ImageIcon[] iconBomberUp = {
        new ImageIcon(getClass().getResource("/resources/icon/player_up.png")),
        new ImageIcon(getClass().getResource("/resources/icon/player_up_1.png")),
        new ImageIcon(getClass().getResource("/resources/icon/player_up_2.png"))
    };
    final ImageIcon[] iconBomberDown = {
        new ImageIcon(getClass().getResource("/resources/icon/player_down.png")),
        new ImageIcon(getClass().getResource("/resources/icon/player_down_1.png")),
        new ImageIcon(getClass().getResource("/resources/icon/player_down_2.png"))
    };
    final ImageIcon[] iconBomberLeft = {
        new ImageIcon(getClass().getResource("/resources/icon/player_left.png")),
        new ImageIcon(getClass().getResource("/resources/icon/player_left_1.png")),
        new ImageIcon(getClass().getResource("/resources/icon/player_left_2.png"))
    };
    final ImageIcon[] iconBomberRight = {
        new ImageIcon(getClass().getResource("/resources/icon/player_right.png")),
        new ImageIcon(getClass().getResource("/resources/icon/player_right_1.png")),
        new ImageIcon(getClass().getResource("/resources/icon/player_right_2.png"))
    };
    
    /*
    khoi tao,i toa do doc, j toa do ngang
    */
    public Bomber(int x,int i,int j,int soHang,int soCot){
        tenThucThe="Bomber";
        switch (x){
            case 0:this.setIcon(iconBomberUp[0]);break;
            case 1:this.setIcon(iconBomberUp[1]);break;
            case 2:this.setIcon(iconBomberUp[2]);break;
        }
        this.yy = i;//toa do doc
        this.xx = j;//toa do ngang
       realDoc=yy*32;realNgang=xx*32;
       this.setBounds(j*canhThucThe,i*canhThucThe, canhThucThe, canhThucThe);
    }
    public Bom suKienDatBom(){
        //tạo ra một quả bom
        Bom b=new Bom(yy,xx);
        mang[yy][xx]=b;
        pane.add(b,0);                        
        //thêm các flame của quả bom vào pane, cho hiện ẩn
        for(int i=0;i<=3;i++){
            if(b.getFlame()[i]!='w')
                pane.add(b.getFlameMain()[i],0);
            b.getFlameMain()[i].setVisible(false);
            }
        return b;
    }
    
    public void setIcon(char x){
        switch(x){
            case 'u':this.setIcon(iconBomberUp[0]);break;
            case 'd':this.setIcon(iconBomberDown[0]);break;
            case 'l':this.setIcon(iconBomberLeft[0]);break;
            case 'r':this.setIcon(iconBomberRight[0]);break;
        }
    }
}