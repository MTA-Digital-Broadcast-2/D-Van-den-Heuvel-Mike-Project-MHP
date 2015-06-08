/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

/**
 *
 * @author student
 */

import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;

public class MijnComponent extends HComponent{
    
    int x,y,b,h;
    
    public MijnComponent(int x,int y,int b,int h){
        this.setBounds(x,y,b,h);
        this.x=x;
        this.y=y;
        this.b=b/2;
        this.h=h/2;
    }
    
    public void paint(Graphics g){
        g.setColor(new DVBColor(0,0,0,100));
        g.fillRoundRect(x+10, y+10, b, h, 50, 50);
        g.setColor(new DVBColor(0,0,250,100));
        g.fillRoundRect(x, y, b, h, 50, 50);
        g.setColor(new DVBColor(255,255,0,150));
        g.drawString("tekst", x+(b/2)-20, y+(h/2)+5);
    }
    
}

