package hellotvxlet;

import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import org.havi.ui.event.*;

public class HelloTVXlet implements Xlet, HActionListener {

  
    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug = true;
    
    private HStaticText titel;
    private HTextButton knop1,knop2,knop3,knop4,knop5;
    
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
      if(debug)System.out.println("Xlet initialiseren");
      this.actueleXletContext = context;
      
      HSceneTemplate sceneTemplate = new HSceneTemplate();
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f,1.0f), HSceneTemplate.REQUIRED);
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f,0.0f), HSceneTemplate.REQUIRED);
      
      scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
      
      titel = new HStaticText("Wie wordt multimiljonair?");
      titel.setLocation(150, 100);
      titel.setSize(400, 40);
      titel.setBackground(new DVBColor(0,0,0,179));
      titel.setBackgroundMode(HVisible.BACKGROUND_FILL);   
      
      knop1 = new HTextButton("knop1");
      knop1.setLocation(150, 150);
      knop1.setSize(200,50);
      knop1.setBackground(new DVBColor(0,0,0,179));
      knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop2 = new HTextButton("knop2");
      knop2.setLocation(350, 150);
      knop2.setSize(200,50);
      knop2.setBackground(new DVBColor(0,0,0,179));
      knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop3 = new HTextButton("knop3");
      knop3.setLocation(150, 220);
      knop3.setSize(200,50);
      knop3.setBackground(new DVBColor(0,0,0,179));
      knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop4 = new HTextButton("knop4");
      knop4.setLocation(350, 220);
      knop4.setSize(200,50);
      knop4.setBackground(new DVBColor(0,0,0,179));
      knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop5 = new HTextButton("hulplijn");
      knop5.setLocation(175, 290);
      knop5.setSize(350,50);
      knop5.setBackground(new DVBColor(0,0,0,179));
      knop5.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop1.setFocusTraversal(null, knop3, null, knop2);
      knop2.setFocusTraversal(null, knop4, knop1, null);
      knop3.setFocusTraversal(knop1, knop5, null, knop4);
      knop4.setFocusTraversal(knop2, knop5, knop3, null);
      knop5.setFocusTraversal(knop3, null, null, null);
      
      scene.add(titel);
      scene.add(knop1);
      scene.add(knop2);
      scene.add(knop3);
      scene.add(knop4);
      scene.add(knop5);
      
      knop1.requestFocus();
      
      knop1.setActionCommand("knop1");
      knop2.setActionCommand("knop2");
      knop3.setActionCommand("knop3");
      knop4.setActionCommand("knop4");
      knop5.setActionCommand("hulplijn");
      
      knop1.addHActionListener(this);
      knop2.addHActionListener(this);
      knop3.addHActionListener(this);
      knop4.addHActionListener(this);
      knop5.addHActionListener(this);
      
    }
    

    public void startXlet() {
        if(debug)System.out.println("Xlet starten");
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void actionPerformed(ActionEvent e) {
        
        String knop = e.getActionCommand();
        
        if(knop == "knop1"){
            knop1.setBackground(new DVBColor(255,0,0,179));
        }else if(knop == "knop2"){
            knop2.setBackground(new DVBColor(255,0,0,179));
        }else if(knop == "knop3"){
            knop3.setBackground(new DVBColor(0,255,0,179));
        }else if(knop == "knop4"){
            knop4.setBackground(new DVBColor(255,0,0,179));
        }else if(knop == "hulplijn"){
            knop5.setBackground(new DVBColor(0,0,255,179));
            knop1.setBackground(new DVBColor(0,0,255,179));
            knop1.requestFocus();
            knop2.setBackground(new DVBColor(0,0,255,179));
            knop2.requestFocus();
            knop3.requestFocus();
            knop3.setFocusTraversal(null, null, null, knop4);
            knop4.setFocusTraversal(null, null, knop3, null);
            knop5.setFocusTraversal(knop3, null, null, null);
        }
    }
        
}
