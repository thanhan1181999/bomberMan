/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametuviet.SKvoiManHinhGame;

import static gametuviet.GameTuViet.screen;
import static gametuviet.ManHinhGame.newGame;
import static gametuviet.ManHinhGame.*;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 *
 * @author An
 */
public class SetMenu {
    public static void setMenu(){
        mb=new JMenuBar(); mb.setForeground(Color.ORANGE);  
        chucNang=new JMenu("MENU");//chucNang.setBounds(0,0,50,30);
        help=new JMenu("HELP");//help.setBounds(50,0,100,30);
        
        newGame=new JMenuItem("NEW GAME");
        exit=new JMenuItem("EXIT");  
        diemCao=new JMenuItem("HIGH SORCE");
        huongDanChoi=new JMenuItem("HƯỚNG DẪN CHƠI");
        infor=new JMenuItem("PRODUCED");
        chucNang.add(newGame);chucNang.add(diemCao);chucNang.add(exit);help.add(huongDanChoi);help.add(infor);
        mb.add(chucNang);mb.add(help);
        pane.add(lev);lev.setBounds(0,0,50,32);
        pane.add(time);time.setBounds(50,0,100,32);
        paneMenu.add(mb);
        
        pane.setSize(50+x*canhThucThe+50,50+y*canhThucThe+50);
        pane.setBounds(0,32,32*x+100,32*y+100);
        pane.setBackground(Color.magenta);
        paneMenu.setSize(50+x*canhThucThe+50,32);
        paneMenu.setBounds(0,0,32*x+100,32);
    }
}
