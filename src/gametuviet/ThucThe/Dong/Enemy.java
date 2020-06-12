package gametuviet.ThucThe.Dong;

import static gametuviet.ManHinhGame.canhThucThe;
import static gametuviet.ManHinhGame.dieuKhien;
import gametuviet.ThucThe.ThucThe;
import gametuviet.ThucThe.Tinh.Brick;
import gametuviet.ThucThe.Tinh.Wall;
import java.util.Random;
/**
 * @author An
 */
public class Enemy extends ThucTheDong{
    //khi đi từ 1 ô đến ô bên cạnh, cần chạy tocDo[speed] bước
    protected int[] tocDo={32,16,8,4,2,1};//đi 32 buoc 1 o,di 16 buoc 1 o
    protected int speed=4;//chi so toc do tu 0 den 4
    protected int dau=0;
    protected int cuoi=tocDo[speed];//
    protected boolean canSinhSo=true;
    protected int huongCu=0;
    //sinh so : khi đã đi từ 1 ô đến 1 ô bên cạnh, cần sinh ra hướng đi mới
    public boolean getCanSinhSo(){return canSinhSo;}
    public void setCanSinhSo(boolean t){canSinhSo=t;}
    //huong cu : khi đang đi từ 1 ô đến 1 ô bên cạnh, không cần sinh hướng đi mới
    public int getHuongCu(){return huongCu;}
    public void setHuongCu(int t){huongCu=t;}
     public void setSpeed(int x){speed=x;}
    public int sinhSo(){
         Random rd=new Random();
         return Math.abs(rd.nextInt()%4);
    }
    public int sinhSpeed(){
         Random rd=new Random();
         return Math.abs(rd.nextInt()%3)+2;
    }
    /**
     * ham di chuyen kiem tra co can sinh huong di ko
     * @param t 
     */
    void update(char t){
        if(dau<cuoi){
            dau++;
             switch(t){
             case'u':if(checkDiChuyen(t)){
                 realDoc=realDoc-(int) (32/tocDo[speed]);
                 this.setBounds(realNgang,realDoc,canhThucThe,canhThucThe);
                 if(this instanceof Oneal){Oneal x=(Oneal)this;x.setIcon('u');}
                 else{Balloon x=(Balloon)this;x.setIcon('u');}
             }
             break;
             case'd':if(checkDiChuyen(t)){                 
                 realDoc=realDoc+(int) (32/tocDo[speed]);
                    this.setBounds(realNgang,realDoc,canhThucThe,canhThucThe);
                 if(this instanceof Oneal){Oneal x=(Oneal)this;x.setIcon('d');}
                 else{Balloon x=(Balloon)this;x.setIcon('d');}
             }
             break;
             case'l':if(checkDiChuyen(t)){               
                 realNgang=realNgang-(int) (32/tocDo[speed]);
                    this.setBounds(realNgang,realDoc,canhThucThe,canhThucThe);
                  if(this instanceof Oneal){Oneal x=(Oneal)this;x.setIcon('l');}
                 else{Balloon x=(Balloon)this;x.setIcon('l');}
             }
             break;
             case'r':if(checkDiChuyen(t)){                
                 realNgang=realNgang+(int) (32/tocDo[speed]);
                    this.setBounds(realNgang,realDoc,canhThucThe,canhThucThe);
                 if(this instanceof Oneal){Oneal x=(Oneal)this;x.setIcon('r');}
                 else{Balloon x=(Balloon)this;x.setIcon('r');}
             }
             break;
            }
        }
        else
        if (dau==cuoi){
            dau=0;
             switch(t){
             case'u':if(checkDiChuyen(t)){
                 yy=yy-1;
                 realDoc=yy*32;
                 this.setBounds(realNgang,realDoc,canhThucThe,canhThucThe);
             }
             break;
             case'd':if(checkDiChuyen(t)){                 
                 yy=yy+1;
                 realDoc=yy*32;
                    this.setBounds(realNgang,realDoc,canhThucThe,canhThucThe);
             }
             break;
             case'l':if(checkDiChuyen(t)){
                 xx=xx-1;
                 realNgang=xx*32;
                    this.setBounds(realNgang,realDoc,canhThucThe,canhThucThe);
             }
             break;
             case'r':if(checkDiChuyen(t)){                
                 xx=xx+1;
                 realNgang=xx*32;
                    this.setBounds(realNgang,realDoc,canhThucThe,canhThucThe);
             }
             break;
            }
            canSinhSo=true;
            if(this instanceof Oneal){
                //oneal được sinh tốc độ mới, khi bắt đầu một lần di chuyển sang ô bên cạnh
                speed=sinhSpeed();cuoi=tocDo[speed];
            }
        }
    }
    
    public void update(){
        if(canSinhSo==true){
            canSinhSo=false;
            int i=this.sinhSo();
            if ( !(!this.checkDiChuyen('u') &&!this.checkDiChuyen('d') &&!this.checkDiChuyen('l') &&
            !this.checkDiChuyen('r')) ){
                while(!this.checkDiChuyen(dieuKhien[i])) i=this.sinhSo(); 
                update(dieuKhien[i]);huongCu=i;
            }
        }
        else{
            update(dieuKhien[huongCu]);
        }   
    }
}
