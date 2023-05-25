/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametuviet.ThucThe.Dong;

import static gametuviet.ManHinhGame.canhThucThe;
import gametuviet.ThucThe.ThucThe;
import gametuviet.ThucThe.Tinh.Brick;
import gametuviet.ThucThe.Tinh.Grass;
import gametuviet.ThucThe.Tinh.Wall;
import static gametuviet.ManHinhGame.mang;
import static gametuviet.ManHinhGame.x;
import static gametuviet.ManHinhGame.y;
/**
 *
 * @author An
 */
public class ThucTheDong extends ThucThe{
    protected boolean life=true;
    
    //kiem tra co di chuyen theo huong nhap vao duoc khong
    //x ngang man hinh,y doc man hinh
    public boolean checkDiChuyen(char t){
        switch(t){
            case 'u':if(this.yy>2 && !(mang[this.yy-1][this.xx] instanceof Wall)
                    && !(mang[this.yy-1][this.xx] instanceof Brick) 
                    &&!(mang[this.yy-1][this.xx] instanceof Bom)) return true;                                               
                     break;
            case 'd':if(this.yy<y-1 && !(mang[this.yy+1][this.xx] instanceof Wall)
                    && !(mang[this.yy+1][this.xx] instanceof Brick)
                    &&!(mang[this.yy+1][this.xx] instanceof Bom))return true;                
                     break;
            case 'l':if(this.xx>2 && !(mang[this.yy][this.xx-1] instanceof Wall)
                    && !(mang[this.yy][this.xx-1] instanceof Brick)
                    &&!(mang[this.yy][this.xx-1] instanceof Bom)) return true;                     
                     break;
            case 'r':if(this.xx<x-1 && !(mang[this.yy][this.xx+1] instanceof Wall)
                    && !(mang[this.yy][this.xx+1] instanceof Brick)
                    &&!(mang[this.yy][this.xx+1] instanceof Bom))return true;                     
                     break;
        }
        return false;
    }
    //ham the hien su di chuyen cua thuc the chay, nhanh hay cham
    //thay doi toa do cua thuc the cho phu hop
    public void diChuyen(char t) throws InterruptedException{
        switch(t){
             case'u':if(checkDiChuyen(t)){
                 this.yy=this.yy-1;
                  realDoc=yy*32;realNgang=xx*32;
                 this.setBounds(this.xx*canhThucThe,this.yy*canhThucThe,canhThucThe,canhThucThe);
             }
             break;
             case'd':if(checkDiChuyen(t)){                 
                 this.yy=this.yy+1;
                  realDoc=yy*32;realNgang=xx*32;
                 this.setBounds(this.xx*canhThucThe,this.yy*canhThucThe,canhThucThe,canhThucThe);
             }
             break;
             case'l':if(checkDiChuyen(t)){               
                 this.xx=this.xx-1;
                  realDoc=yy*32;realNgang=xx*32;
                 this.setBounds(this.xx*canhThucThe,this.yy*canhThucThe,canhThucThe,canhThucThe);
             }
             break;
             case'r':if(checkDiChuyen(t)){                
                 this.xx=this.xx+1;
                  realDoc=yy*32;realNgang=xx*32;
                 this.setBounds(this.xx*canhThucThe,this.yy*canhThucThe,canhThucThe,canhThucThe);
             }
             break;
        }
    }
    public void setLife(boolean ttt){life=ttt;}
    public boolean getLife(){return life;}
    
}
