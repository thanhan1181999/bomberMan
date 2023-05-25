package gametuviet;
import static gametuviet.GameTuViet.screen;
import static gametuviet.SKvoiManHinhGame.SetMenu.setMenu;
import gametuviet.ThucThe.Dong.Balloon;
import gametuviet.ThucThe.Dong.Bomber;
import gametuviet.ThucThe.Dong.Enemy;
import gametuviet.ThucThe.Dong.Oneal;
import gametuviet.ThucThe.ThucThe;
import gametuviet.ThucThe.Tinh.Brick;
import gametuviet.ThucThe.Tinh.Grass;
import gametuviet.ThucThe.Tinh.Item;
import gametuviet.ThucThe.Tinh.Portal;
import gametuviet.ThucThe.Tinh.Wall;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

import gametuviet.ThucThe.Dong.Bom;
import static gametuviet.SKvoiManHinhGame.SkBomberDichuyen.suKienBomberDichuyen;
import gametuviet.ThucThe.Tinh.Flame;
import static gametuviet.SKvoiManHinhGame.setSuKien.setSuKien;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ScrollPane;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Pane;
import jdk.nashorn.internal.runtime.Source;
/**
 *
 * @author An
 */
public class ManHinhGame extends JFrame {
    public static final int canhThucThe=32;//canh 
    public static int x=31;
    public static int y=13;
    public static int level=1;
    public static ThucThe[][] mang=new ThucThe[y][x];
    public static JPanel pane=new JPanel();
    public static Vector<Enemy> enemy=new Vector<Enemy>();
    public static Vector<Item> item=new Vector<Item>();
    public static boolean coBom=false;
    public static boolean coBom1=false;
    public static Bom b;
    public static Bomber bomber;
    public static Bom b1;
    public static char[] dieuKhien={'u','d','l','r'};
    public static boolean endGame=false;
    //dohoa
    public static JPanel paneMenu=new JPanel();
    public static JMenuBar mb; 
    public static JMenu chucNang,edit,help;
    public static JMenuItem newGame,diemCao,exit,huongDanChoi,infor;
    public static int[][] diem=new int[10][2];
    private static LoadLevel ll=new LoadLevel();
    public static Portal portal;
    public static JLabel lev=new JLabel("Level "+String.valueOf(level));
    public static long tim1=1,tim2=2;
    public static JLabel time=new JLabel("Time "+String.valueOf(tim2-tim1));
   
    ManHinhGame(){
        super("BOMBERMAN GAME FUN");
        tim1=System.currentTimeMillis();
        nhapTuFile();
        setMenu();
        setSuKien();
        //khoi tao man hinh
        this.add(pane);this.add(paneMenu);
        this.setSize(50+x*canhThucThe+50,40+y*canhThucThe+100);//cai chieu dai rong cho khung anh game
        this.setLocationRelativeTo(null);//cho khugn game vao giua man hinh
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//nhan thoat se dung chung trinh
        suKienBomberDichuyen(this);   
      }
    
    public void update() throws InterruptedException{
        if(coBom) b.updateBom();//update bom
        //update vitri enemy
        for (Enemy tt:enemy){
                if(tt.getLife()&&tt instanceof Balloon) tt.update();
                if(tt.getLife() && tt instanceof Oneal){ Oneal oneal=(Oneal)tt; oneal.update();}
        }                
        kiemTraBomberEnemy();//bomberAndItem();
        checkNextLv();nextLv();
        pane.repaint();
        Thread.sleep(500);
        //set thoi gian
        tim2=System.currentTimeMillis();
        time.setText("Time : "+String.valueOf(TimeUnit.MILLISECONDS.toSeconds(tim2-tim1)));
    }
    //=====================================================================
    void kiemTraBomberEnemy(){
        for (Enemy tt:enemy)
            if(tt.getLife()==true)   
               if(bomber.getRealDoc()-32<tt.getRealDoc()&&tt.getRealDoc()<bomber.getRealDoc()&& bomber.getXx()==tt.getXx()||
                  tt.getRealDoc()<bomber.getRealDoc()+32 && tt.getRealDoc()>bomber.getRealDoc() &&bomber.getXx()==tt.getXx()||
                  bomber.getRealNgang()-32<tt.getRealNgang() && tt.getRealNgang()<bomber.getRealNgang()&& bomber.getYy()==tt.getYy()||
                  bomber.getRealNgang()<tt.getRealNgang()&& bomber.getRealNgang()+32>tt.getRealNgang()&& bomber.getYy()==tt.getYy() ){
                          endGame=true;
                      }            
    }
    void bomberAndItem(){
        if(!item.isEmpty())
        for(Item x:item)
            if (x.getHien()==true)
            if (bomber.getXx()==x.getXx()&&bomber.getYy()==x.getYy()){
                pane.remove(x);
                x.setHien(false);
                //set cac su kiem item o day
            }
    }
    //=====================================================================
    
    //========================================================================
    public static void nhapTuFile(){
        pane.removeAll();
        pane.add(lev);lev.setBounds(0,0,50,32);
        pane.add(time);time.setBounds(50,0,100,32);
        ll.loadMap(level);
        level=ll.getLevel();
        lev.setText("Level "+String.valueOf(level));
        y=ll.getSoHang();
        x=ll.getSoCot();
        pane.setSize(50+x*canhThucThe+50,50+y*canhThucThe+50);
        pane.setBounds(0,32,32*x+100,32*y+100);
        mang=new ThucThe[y+2][x+2];
        System.out.println(level+" "+y+" "+x);//1 13 31
        //them vao man hinh cac thuc the
        //truyen vao moi thuc the toa do doc-ngang
        pane.setLayout(null);
        for (int i=1; i<=y;i++){
            for (int j=1; j<=x; j++){
                System.out.print(ll.getMap()[i][j]);
                switch(ll.getMap()[i][j]){
                    case '#':mang[i][j]=new Wall(i,j);pane.add(mang[i][j]);break;                            
                    case '*':mang[i][j]=new Brick(i,j);pane.add(mang[i][j]);pane.add(new Grass(i,j));break;                             
                    case 'x':mang[i][j]=new Brick(i,j);portal=new Portal(i, j);                           
                            pane.add(mang[i][j]);
                            pane.add(new Grass(i,j));break;                             
                    case ' ':mang[i][j]=new Grass(i,j);pane.add(mang[i][j]);break;                             
                    case 'b':mang[i][j]=new Brick(i,j);
                            Item it=new Item('b',i,j);
                            item.add(it);
                            pane.add(mang[i][j]);pane.add(new Grass(i,j));break;
                    case 'f':mang[i][j]=new Brick(i,j);
                            it=new Item('b',i,j);
                            item.add(it);
                            pane.add(mang[i][j]);pane.add(new Grass(i,j));break;
                    case 's':
                            mang[i][j]=new Brick(i,j);
                            it=new Item('b',i,j);
                            item.add(it);
                            pane.add(mang[i][j]);pane.add(new Grass(i,j));break;
                    case 'p':mang[i][j]=new Bomber(0,i,j,y,x);bomber=(Bomber) mang[i][j];
                    pane.add(new Grass(i,j));pane.add(bomber, 0);break;
                    case 'B':mang[i][j]=new Balloon(0,i,j,x,y);
                            enemy.add((Enemy) mang[i][j]);
                            pane.add(mang[i][j],0);pane.add(new Grass(i,j));break;
                    case 'O':mang[i][j]=new Oneal(mang,0,i,j,y,x);
                            enemy.add((Enemy) mang[i][j]);
                            pane.add(mang[i][j],0);pane.add(new Grass(i,j));break;
                }                
            }
            System.out.println();
        }
        
    }
    //========================================================================
    public void checkNextLv(){
         int dem=0;
        if(!enemy.isEmpty())
         for (Enemy tt:enemy){
             if(tt.getLife()==true) dem++;
         }   
        if(dem==0) portal.setHien(true);
    }
    public void nextLv(){
        if(portal.getHien()==true)
        if (portal.getYy()==bomber.getYy()&&portal.getXx()==bomber.getXx()){
           if(level<=4){level++;nhapTuFile(); this.setSize(50+x*canhThucThe+50,40+y*canhThucThe+100);}
           else {
               endGame=true;//thang
           };
        }
    }
    //==========================================================================
}           