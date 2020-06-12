/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametuviet.ThucThe;

import javax.swing.JLabel;

/**
 *
 * @author An
 */
public abstract class ThucThe extends JLabel{
    protected String tenThucThe;
    protected int xx,yy;
    protected int realDoc,realNgang;
    public String getTen(){return tenThucThe;}
    public void setTen(String x){tenThucThe=x;}

    public int getXx() {
        return xx;
    }

    public int getRealDoc() {
        return realDoc;
    }

    public void setRealDoc(int realDoc) {
        this.realDoc = realDoc;
    }

    public int getRealNgang() {
        return realNgang;
    }

    public void setRealNgang(int realNgang) {
        this.realNgang = realNgang;
    }

    public void setXx(int xx) {
        this.xx = xx;
    }

    public int getYy() {
        return yy;
    }

    public void setYy(int yy) {
        this.yy = yy;
    }
    
}
