package gametuviet.ThucThe.Dong;

import gametuviet.ManHinhGame;
import static gametuviet.ManHinhGame.bomber;
import static gametuviet.ManHinhGame.canhThucThe;
import static gametuviet.ManHinhGame.dieuKhien;
import gametuviet.ThucThe.ThucThe;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
/**
 *
 * @author An
 */
public class Oneal extends Enemy {
    final ImageIcon[] iconOneal = {
        new ImageIcon(getClass().getResource("/resources/icon/oneal_left1.png")),
        new ImageIcon(getClass().getResource("/resources/icon/oneal_left2.png")),
        new ImageIcon(getClass().getResource("/resources/icon/oneal_left3.png")),
        new ImageIcon(getClass().getResource("/resources/icon/oneal_right1.png")),
        new ImageIcon(getClass().getResource("/resources/icon/oneal_right2.png")),
        new ImageIcon(getClass().getResource("/resources/icon/oneal_right3.png"))
    };
    ImageIcon iconOnealDead = new ImageIcon(getClass().getResource("/resources/icon/oneal_dead.png"));
    /*
    khoi tao
    */
   
    public Oneal(ThucThe[][] mang,int t,int i,int j,int soHang,int soCot){
        tenThucThe="Oneal";
        switch (t){
            case 0:this.setIcon(iconOneal[0]);break;
            case 1:this.setIcon(iconOneal[1]);break;
            case 2:this.setIcon(iconOneal[2]);break;
            case 3:this.setIcon(iconOneal[3]);break;
            case 4:this.setIcon(iconOneal[4]);break;
            case 5:this.setIcon(iconOneal[5]);break;
        }       
        xx=j;yy=i;realDoc=yy*32;realNgang=xx*32;
        this.setBounds(j*canhThucThe,i*canhThucThe, canhThucThe, canhThucThe);
     }
    
    public int AI(){
      if( xx<bomber.getXx() ){
         if(this.checkDiChuyen('r')) return 3;
      }
      if( xx>bomber.getXx() ){
         if(this.checkDiChuyen('l')) return 2;
      }
      if(xx==bomber.getXx()){
          if(yy<bomber.getYy()) if(this.checkDiChuyen('d')) return 1;
          if(yy>bomber.getYy()) if(this.checkDiChuyen('u')) return 0;
      }
      return 4;
    }
    @Override
    public void update(){
        if(canSinhSo==true){
            canSinhSo=false;
            if(this.AI()!=4){
                update(dieuKhien[this.AI()]);huongCu=this.AI();
            }
            else{
                //khi sinh được hướng, và check hướng đó đi được,update hướng
                 int i=this.sinhSo();
                 if ( !(!this.checkDiChuyen('u') &&!this.checkDiChuyen('d') &&!this.checkDiChuyen('l') &&
                 !this.checkDiChuyen('r')) ){
                     while(!this.checkDiChuyen(dieuKhien[i])) i=this.sinhSo();
                     update(dieuKhien[i]);huongCu=i;
                 }
            }
        }
        else{
            update(dieuKhien[huongCu]);
        }   
    }
    
    public void setIcon(char x){
        switch(x){
            case 'u':this.setIcon(iconOneal[0]);break;
            case 'd':this.setIcon(iconOneal[3]);break;
            case 'l':this.setIcon(iconOneal[0]);break;
            case 'r':this.setIcon(iconOneal[3]);break;
        }
    }
}
    
