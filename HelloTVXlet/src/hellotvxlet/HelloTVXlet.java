package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import java.awt.event.*;
import org.havi.ui.event.*;
import org.dvb.event.*;

public class HelloTVXlet implements Xlet, UserEventListener{

    
    // Van den Heuvel Mike
    // Sudoku
    
    // af en toe update de tekst op de knoppen niet maar ze worden wel gewijzigd in de code
    // als je vervolgens op een andere toets drukt update het wel
    
    
  
    private XletContext actueleXletContext;
    private boolean debug = true;
    
    private HScene scene;
    //private HScene scene2;
    
    private HTextButton knop11,knop12,knop13;
    private HTextButton knop21,knop22,knop23;
    private HTextButton knop31,knop32,knop33;
    
    private int currentRIJ = 0;
    private int currentCOL = 0;
    
    private int[][] numbers = new int[3][3];
    
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
      if(debug)System.out.println("Xlet initialiseren");
      this.actueleXletContext = context;
      
      HSceneTemplate sceneTemplate = new HSceneTemplate();
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f,1.0f), HSceneTemplate.REQUIRED);
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f,0.0f), HSceneTemplate.REQUIRED);
      
      scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
      //scene2 = HSceneFactory.getInstance().getBestScene(sceneTemplate);
      
      //knop11.setTextContent("5", HTextButton.NORMAL_STATE);
      
      knop11 = new HTextButton("11");
      knop11.setLocation(50,50);
      knop11.setSize(50,50);
      knop11.setBackground(new DVBColor(150,150,150,255));
      knop11.setBackgroundMode(HVisible.BACKGROUND_FILL);  
      scene.add(knop11);
      knop11.requestFocus();
      
      knop12 = new HTextButton("12");
      knop12.setLocation(100,50);
      knop12.setSize(50,50);
      knop12.setBackground(new DVBColor(150,150,150,255));
      knop12.setBackgroundMode(HVisible.BACKGROUND_FILL);  
      scene.add(knop12);
      
      knop13 = new HTextButton("13");
      knop13.setLocation(150,50);
      knop13.setSize(50,50);
      knop13.setBackground(new DVBColor(150,150,150,255));
      knop13.setBackgroundMode(HVisible.BACKGROUND_FILL);  
      scene.add(knop13);
      
      
      knop21 = new HTextButton("21");
      knop21.setLocation(50,100);
      knop21.setSize(50,50);
      knop21.setBackground(new DVBColor(150,150,150,255));
      knop21.setBackgroundMode(HVisible.BACKGROUND_FILL);  
      scene.add(knop21);
      
      knop22 = new HTextButton("22");
      knop22.setLocation(100,100);
      knop22.setSize(50,50);
      knop22.setBackground(new DVBColor(150,150,150,255));
      knop22.setBackgroundMode(HVisible.BACKGROUND_FILL);  
      scene.add(knop22);
      
      knop23 = new HTextButton("23");
      knop23.setLocation(150,100);
      knop23.setSize(50,50);
      knop23.setBackground(new DVBColor(150,150,150,255));
      knop23.setBackgroundMode(HVisible.BACKGROUND_FILL);  
      scene.add(knop23);
      
      
      knop31 = new HTextButton("31");
      knop31.setLocation(50,150);
      knop31.setSize(50,50);
      knop31.setBackground(new DVBColor(150,150,150,255));
      knop31.setBackgroundMode(HVisible.BACKGROUND_FILL);  
      scene.add(knop31);
      
      knop32 = new HTextButton("32");
      knop32.setLocation(100,150);
      knop32.setSize(50,50);
      knop32.setBackground(new DVBColor(150,150,150,255));
      knop32.setBackgroundMode(HVisible.BACKGROUND_FILL);  
      scene.add(knop32);
      
      knop33 = new HTextButton("33");
      knop33.setLocation(150,150);
      knop33.setSize(50,50);
      knop33.setBackground(new DVBColor(150,150,150,255));
      knop33.setBackgroundMode(HVisible.BACKGROUND_FILL);  
      scene.add(knop33);
      
      
      knop11.setFocusTraversal(knop31, knop21, knop13, knop12);//op    neer    links    rechts
      knop12.setFocusTraversal(knop32, knop22, knop11, knop13);
      knop13.setFocusTraversal(knop33, knop23, knop12, knop11);
      knop21.setFocusTraversal(knop11, knop31, knop23, knop22);
      knop22.setFocusTraversal(knop12, knop32, knop21, knop23);
      knop23.setFocusTraversal(knop13, knop33, knop22, knop21);
      knop31.setFocusTraversal(knop21, knop11, knop33, knop32);
      knop32.setFocusTraversal(knop22, knop12, knop31, knop33);
      knop33.setFocusTraversal(knop23, knop13, knop32, knop31);
      
      updateGrid();
    }
    

    public void startXlet(){
        if(debug)System.out.println("Xlet starten");
        
        EventManager manager = EventManager.getInstance();
        
        UserEventRepository repos = new UserEventRepository("keys");
        
        repos.addKey(org.havi.ui.event.HRcEvent.VK_NUMPAD1);
        repos.addKey(org.havi.ui.event.HRcEvent.VK_NUMPAD2);
        repos.addKey(org.havi.ui.event.HRcEvent.VK_NUMPAD3);
        repos.addKey(org.havi.ui.event.HRcEvent.VK_NUMPAD4);
        repos.addKey(org.havi.ui.event.HRcEvent.VK_NUMPAD5);
        repos.addKey(org.havi.ui.event.HRcEvent.VK_NUMPAD6);
        repos.addKey(org.havi.ui.event.HRcEvent.VK_NUMPAD7);
        repos.addKey(org.havi.ui.event.HRcEvent.VK_NUMPAD8);
        repos.addKey(org.havi.ui.event.HRcEvent.VK_NUMPAD9);
        repos.addKey(org.havi.ui.event.HRcEvent.VK_DOWN);
        repos.addKey(org.havi.ui.event.HRcEvent.VK_LEFT);
        repos.addKey(org.havi.ui.event.HRcEvent.VK_RIGHT);
        repos.addKey(org.havi.ui.event.HRcEvent.VK_UP);
        
        manager.addUserEventListener(this,repos);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
    
    public void userEventReceived(org.dvb.event.UserEvent e){
        if(e.getType() == KeyEvent.KEY_PRESSED){
            //System.out.println("pushed button");
            switch(e.getCode()){
                case HRcEvent.VK_UP:
                    if(currentRIJ == 0){
                        currentRIJ=numbers.length-1;
                    }else{
                        currentRIJ--;
                    }
                    break;
                case HRcEvent.VK_DOWN:
                    if(currentRIJ == numbers.length-1){
                        currentRIJ=0;
                    }else{
                        currentRIJ++;
                    }
                    break;
                case HRcEvent.VK_LEFT:
                    if(currentCOL == 0){
                        currentCOL=numbers.length-1;
                    }else{
                        currentCOL--;
                    }
                    break;
                case HRcEvent.VK_RIGHT:
                    if(currentCOL == numbers.length-1){
                        currentCOL=0;
                    }else{
                        currentCOL++;
                    }
                    break;
                default:
                    numbers[currentRIJ][currentCOL]=e.getCode()-96;
                    updateGrid();
                    //System.out.println(e.getCode()-96);
                    break;
            }
            
            //debug rij collom
            //System.out.println(currentRIJ + "," + currentCOL);
            //System.out.println(HRcEvent.VK_NUMPAD9-96);
            //System.out.println(numbers[0][0]+","+numbers[0][1]+","+numbers[0][2]);
            //System.out.println(numbers[1][0]+","+numbers[1][1]+","+numbers[1][2]);
            //System.out.println(numbers[2][0]+","+numbers[2][1]+","+numbers[2][2]);
            
        }
    }
    
    public void updateGrid(){
        knop11.setTextContent(Integer.toString(numbers[0][0]), HTextButton.NORMAL_STATE);
        knop12.setTextContent(Integer.toString(numbers[0][1]), HTextButton.NORMAL_STATE);
        knop13.setTextContent(Integer.toString(numbers[0][2]), HTextButton.NORMAL_STATE);
        knop21.setTextContent(Integer.toString(numbers[1][0]), HTextButton.NORMAL_STATE);
        knop22.setTextContent(Integer.toString(numbers[1][1]), HTextButton.NORMAL_STATE);
        knop23.setTextContent(Integer.toString(numbers[1][2]), HTextButton.NORMAL_STATE);
        knop31.setTextContent(Integer.toString(numbers[2][0]), HTextButton.NORMAL_STATE);
        knop32.setTextContent(Integer.toString(numbers[2][1]), HTextButton.NORMAL_STATE);
        knop33.setTextContent(Integer.toString(numbers[2][2]), HTextButton.NORMAL_STATE);
        scene.repaint();
    }
        
}
