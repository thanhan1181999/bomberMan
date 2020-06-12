/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametuviet.SKvoiManHinhGame;

import gametuviet.GameTuViet;
import static gametuviet.GameTuViet.screen;
import gametuviet.ManHinhGame;
import static gametuviet.ManHinhGame.canhThucThe;
import static gametuviet.ManHinhGame.enemy;
import static gametuviet.ManHinhGame.level;
import static gametuviet.ManHinhGame.newGame;
import static gametuviet.ManHinhGame.tim1;
import static gametuviet.ManHinhGame.x;
import static gametuviet.ManHinhGame.y;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author An
 */
public class setEndGame {
     ImageIcon win = new ImageIcon(getClass()
             .getResource("/resources/icon/you-win-comic-speech-bubble-cartoon-eps-vector_csp38170947.jpg"));
     ImageIcon lose = new ImageIcon(getClass()
             .getResource("/resources/icon/you-lose-comic-speech-bubble-cartoon-clipart-vector_csp38170951.jpg"));
     JLabel j1=new JLabel(win);
     JLabel j2=new JLabel(lose);
    public void endGame(int i){
                  JFrame jframe=new JFrame();
                  j1.setSize(450,419);j2.setSize(450,419);
                  jframe.setSize(450,419);
                  jframe.setLayout(null);
                  jframe.setLocationRelativeTo(null);//cho khugn game vao giua man hin        
                  if(i==0) jframe.setContentPane(j2); else jframe.setContentPane(j1);                           
                  jframe.setVisible(true);
                  JButton n1=new JButton("CHƠI LẠI");
                  n1.setBounds(100, 300, 100, 50);
                  JButton n2=new JButton("THOÁT");
                  n2.setBounds(210, 300, 100, 50);
                  jframe.add(n1);jframe.add(n2);
              n1.addActionListener(
                  new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                   GameTuViet.iTrangThai=0;
                 level=1;
                 enemy.clear();
                 ManHinhGame.endGame=false;
                 ManHinhGame.portal=null;
                 ManHinhGame.nhapTuFile();screen.setSize(50+x*canhThucThe+50,40+y*canhThucThe+100);
                 tim1=System.currentTimeMillis();
                  jframe.dispose();
                }
                }
              );
             n2.addActionListener(
                  new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                  System.exit(0);
                }
                }
              );
    }
}
