/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametuviet.ThucThe.Dong;

import gametuviet.ManHinhGame;
import static gametuviet.ManHinhGame.b;
import static gametuviet.ManHinhGame.bomber;
import static gametuviet.ManHinhGame.canhThucThe;
import static gametuviet.ManHinhGame.pane;
import gametuviet.ThucThe.Tinh.Brick;
import gametuviet.ThucThe.Tinh.Flame;
import gametuviet.ThucThe.Tinh.Grass;
import gametuviet.ThucThe.Tinh.Wall;
import javax.swing.ImageIcon;
import static gametuviet.ManHinhGame.mang;
import static gametuviet.ManHinhGame.coBom;
import static gametuviet.ManHinhGame.enemy;
import static gametuviet.ManHinhGame.item;
import static gametuviet.ManHinhGame.portal;
import gametuviet.ThucThe.Tinh.Item;
/**
 *
 * @author An
 */
public class Bom extends ThucTheDong{
    final ImageIcon iconBomb[] = {
        new ImageIcon(getClass().getResource("/resources/icon/bomb.png")),
        new ImageIcon(getClass().getResource("/resources/icon/bomb_1.png")),
        new ImageIcon(getClass().getResource("/resources/icon/bomb_2.png"))
    };  
    ImageIcon iconFlameCenter[] = {
        new ImageIcon(getClass().getResource("/resources/icon/bomb_exploded.png")),
        new ImageIcon(getClass().getResource("/resources/icon/bomb_exploded1.png")),
        new ImageIcon(getClass().getResource("/resources/icon/bomb_exploded2.png"))
    };
   
    private char[] flame=new char[4];
    private Flame[] flameMain=new Flame[4];
    private char[] brick=new char[4]; 
    private int tgDau=0;
    private int tgCuoi=5;
    private int dem=0;  
   
    public Bom(int i,int j){
        tenThucThe="Bom";
        life=true;
        this.xx=j;
        this.yy=i;
        this.setIcon(iconBomb[2]);
        this.setBounds(this.xx*canhThucThe,this.yy*canhThucThe,canhThucThe,canhThucThe);
        
        flame[0]=this.checkFlame('u');
        flame[1]=this.checkFlame('d');
        flame[2]=this.checkFlame('l');
        flame[3]=this.checkFlame('r');
                    
        flameMain[0]=new Flame(flame[0],'u',yy-1,xx);
        flameMain[1]=new Flame(flame[1],'d',yy+1,xx);
        flameMain[2]=new Flame(flame[2],'l',yy,xx-1);
        flameMain[3]=new Flame(flame[3],'r',yy,xx+1);
    }
    
    public void updateBom() throws InterruptedException{
        if(tgDau<tgCuoi-1) {
            dem=(dem+1)%3; this.setIcon(iconBomb[dem]);
            tgDau++;
        }
        else
        if(tgDau==tgCuoi-1){ 
            this.setIcon(iconFlameCenter[0]);
            for (int i=0; i<=3; i++) flameMain[i].setVisible(true);
            tgDau++;
        }
        else
        if (tgDau==tgCuoi){
            coBom=false;
            //cap nhật lại mảng cho ko có bom de check ko di vo bom dk
            mang[b.getYy()][b.getXx()]=new Grass(b.getYy(),b.getXx());
            //xoa trong pane  
            pane.remove(b);
            for (int i=0; i<=3; i++) pane.remove(flameMain[i]);
            
            for (int i=0; i<=3; i++){
                int bi=b.getFlameMain()[i].getYy();
                int bj=b.getFlameMain()[i].getXx();
                int rd=b.getFlameMain()[i].getRealDoc();
                int rn=b.getFlameMain()[i].getRealNgang();
                //neu flame trung brick thi xoa brick
                if (mang[bi][bj] instanceof Brick){
                    pane.remove(mang[bi][bj]);
                    mang[bi][bj]=new Grass(bi,bj);
                    //neu no gach o vi tri cong, hien cong
                    if(portal.getXx()==bj && portal.getYy()==bi) pane.add(portal,0);
                    //neu no gach o item hien item
                    for (Item x:item){
                        System.out.println(x.getXx()+" "+x.getYy());
                        if(bi==x.getYy() && bj==x.getXx()){                            
                            pane.add(x,0);x.setHien(true);
                        }
                    }
                    System.out.println(item.size());
                }
                //neu bomber dung o noi co flame thi chet
                if(bi==bomber.getYy()&&bj==bomber.getXx()) ManHinhGame.endGame =true;
                //neu enemy dung o cho flame thi chet
                for (Enemy x:enemy)
                  if(x.getLife()==true)
                {
                     if(rd-32<x.getRealDoc()&&x.getRealDoc()<rd&& bj==x.getXx()||
                     rd<x.getRealDoc() && x.getRealDoc()<rd+32&&bj==x.getXx()||
                     rn-32<x.getRealNgang() && x.getRealNgang()<rn&& bi==x.getYy()||
                     rn<x.getRealNgang()&&x.getRealNgang()<rn+32&& bi==x.getYy()||
                      bi==x.getYy()&&bj==x.getXx()){
                          x.setVisible(false);
                          x.setLife(false);
                      }
                  }
                }
            
            } 
                
        }
    char checkFlame(char t){
        switch(t){
            case 'u':if(mang[this.yy-1][this.xx] instanceof Wall) return 'w';
                     if(mang[this.yy-1][this.xx] instanceof Brick) return 'b';
                     break;
            case 'd':if (mang[this.yy+1][this.xx] instanceof Wall) return 'w';
                     if (mang[this.yy+1][this.xx] instanceof Brick) return 'b';
                     break;
            case 'l':if (mang[this.yy][this.xx-1] instanceof Wall) return 'w';
                     if (mang[this.yy][this.xx-1] instanceof Brick) return 'b';
                     break;
            case 'r':if (mang[this.yy][this.xx+1] instanceof Wall) return 'w';
                     if (mang[this.yy][this.xx+1] instanceof Brick) return 'b';
                     break;
        }
        return 'x';
    } 
    
    public void setAnh(int t){
       this.setIcon(iconBomb[t]);
    }    
    public char[] getFlame(){
        return flame;
    } 
    public Flame[] getFlameMain(){
        return flameMain;
    }

    public boolean getLife() {
        return life;
    }
}
