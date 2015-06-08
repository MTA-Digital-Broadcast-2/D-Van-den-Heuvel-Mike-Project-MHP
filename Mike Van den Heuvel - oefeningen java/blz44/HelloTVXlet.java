package hellotvxlet;

import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import org.havi.ui.event.*;

public class HelloTVXlet implements Xlet{

  
    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug = true;
    
    MijnComponent mc = new MijnComponent(50,50,300,200);
    
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
      if(debug)System.out.println("Xlet initialiseren");
      this.actueleXletContext = context;
      
      HSceneTemplate sceneTemplate = new HSceneTemplate();
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f,1.0f), HSceneTemplate.REQUIRED);
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f,0.0f), HSceneTemplate.REQUIRED);
      
      scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
      
      scene.add(mc);
      
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
        
}
