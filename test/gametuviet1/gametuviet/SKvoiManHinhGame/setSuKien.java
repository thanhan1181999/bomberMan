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
import static gametuviet.ManHinhGame.diemCao;
import static gametuviet.ManHinhGame.enemy;
import static gametuviet.ManHinhGame.exit;
import static gametuviet.ManHinhGame.huongDanChoi;
import static gametuviet.ManHinhGame.infor;
import static gametuviet.ManHinhGame.level;
import static gametuviet.ManHinhGame.newGame;
import static gametuviet.ManHinhGame.tim1;
import static gametuviet.ManHinhGame.x;
import static gametuviet.ManHinhGame.y;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author An
 */
public class setSuKien {
    public static void setSuKien(){
        //set su kien menu
        newGame.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                 GameTuViet.iTrangThai=0;
                 level=1;
                 enemy.clear();
                 ManHinhGame.endGame=false;
                 ManHinhGame.portal=null;
                 ManHinhGame.nhapTuFile();screen.setSize(50+x*canhThucThe+50,40+y*canhThucThe+100);
                 tim1=System.currentTimeMillis();
                }
            }
        );
        huongDanChoi.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                  JFrame jframe=new JFrame();
                  jframe.setSize(400,250);
                  jframe.setLayout(null);
                  jframe.setLocationRelativeTo(null);//cho khugn game vao giua man hin
                  JLabel jlabel1=new JLabel("Di chuyển lên : UP");
                  JLabel jlabel2=new JLabel("Di chuyển xuống : DOWN");
                  JLabel jlabel3=new JLabel("Di chuyển sang trái : LEFT");
                  JLabel jlabel4=new JLabel("Di chuyển sang phải : RIGHT");
                  JLabel jlabel5=new JLabel("Đặt bom : SPACE");
                  JLabel jlabel=new JLabel();
                  jlabel1.setBounds(100, 0,200,40);jlabel1.setForeground(Color.RED);
                  jlabel2.setBounds(100,40,200,40);jlabel2.setForeground(Color.RED);
                  jlabel3.setBounds(100,80,200,40);jlabel3.setForeground(Color.RED);
                  jlabel4.setBounds(100,120,200,40);jlabel4.setForeground(Color.RED);
                  jlabel5.setBounds(100,160,200,40);jlabel5.setForeground(Color.RED);
                  jlabel.setIcon(new javax.swing.ImageIcon(getClass()
                          .getResource("/resources/icon/anh-bia-buon-nhat-cho-facebook-5.jpg")));//duong dan anh
                  jframe.setContentPane(jlabel);
                  jframe.add(jlabel1);jframe.add(jlabel2);jframe.add(jlabel3);jframe.add(jlabel4);jframe.add(jlabel5);               
        jframe.setVisible(true);
               }
            }
        );
        infor.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFrame jframe=new JFrame();
                  jframe.setSize(400,100);
                  jframe.setLayout(null);
                  jframe.setLocationRelativeTo(null);//cho khugn game vao giua man hin
                  JLabel jlabel1=new JLabel("MADE BY NGUYỄN THÀNH AN,NGUYỄN VĂN THƯỜNG");
                  jframe.add(jlabel1);jlabel1.setBounds(30, 0,370,60);
                  jframe.setVisible(true);
                }
            }
        );
        diemCao.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                 
                }
            }
        );       
        exit.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                 System.exit(0);
                }
            }
        );
    }
}
