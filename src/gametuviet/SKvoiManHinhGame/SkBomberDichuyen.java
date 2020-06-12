/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametuviet.SKvoiManHinhGame;

import gametuviet.ManHinhGame;
import static gametuviet.ManHinhGame.b;
import static gametuviet.ManHinhGame.bomber;
import static gametuviet.ManHinhGame.coBom;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author An
 */
public class SkBomberDichuyen {
    public static void suKienBomberDichuyen(JFrame x){
        /**
         * cai su kien phim cho man hinh chinh di chuyen cho bomber
         */
        x.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {}
            //xx la toa do ngang tren man hinh, x la toa do doc max
            //yy la toa do doc , y max
            @Override
            public void keyReleased(KeyEvent e) {             
                switch(e.getKeyCode()){
                case KeyEvent.VK_UP:
                    if(bomber.checkDiChuyen('u')) try {
                       bomber.diChuyen('u');bomber.setIcon('u');
                    } 
                    catch (InterruptedException ex) {
                    Logger.getLogger(ManHinhGame.class.getName()).log(Level.SEVERE, null, ex);}                   
                    break;
                case KeyEvent.VK_DOWN:
                    if(bomber.checkDiChuyen('d')) try {
                       bomber.diChuyen('d');bomber.setIcon('d');
                      } 
                    catch (InterruptedException ex) {
                    Logger.getLogger(ManHinhGame.class.getName()).log(Level.SEVERE, null, ex);}                    
                    break;
                case KeyEvent.VK_LEFT:
                     if(bomber.checkDiChuyen('l')) try {
                       bomber.diChuyen('l');bomber.setIcon('l');
                     } 
                     catch (InterruptedException ex) {
                           Logger.getLogger(ManHinhGame.class.getName()).log(Level.SEVERE, null, ex);}  
                     break;
                case KeyEvent.VK_RIGHT:
                   if(bomber.checkDiChuyen('r')) try {
                       bomber.diChuyen('r');bomber.setIcon('r');
                   } 
                   catch (InterruptedException ex) {
                          Logger.getLogger(ManHinhGame.class.getName()).log(Level.SEVERE, null, ex);}
                   break;
                case KeyEvent.VK_SPACE:if (!coBom){
                    b=bomber.suKienDatBom();coBom=true;
                }
                break;                
               }
            }
        });      
     
    }
}
