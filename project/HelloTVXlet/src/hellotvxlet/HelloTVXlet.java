package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import java.awt.event.*;
import org.havi.ui.event.*;
import org.dvb.event.*;
import java.util.Random;

public class HelloTVXlet implements Xlet,UserEventListener, HActionListener{

    
    // Van den Heuvel Mike
    // Sudoku
    
    // af en toe update de tekst op de knoppen niet maar ze worden wel gewijzigd in de code
    // als je vervolgens op een andere toets drukt update het wel
    
    //DRUK ESCAPE VOOR OPTIONS
  
    private XletContext actueleXletContext;
    private boolean debug = true;
    
    private HScene scene;
    //private HScene scene2;
    
    private int currentRIJ, currentCOL;
    int toXup, toXdown, toXleft, toXright, toYup, toYdown, toYleft, toYright;
    
    private Random rd = new Random();
    
    private HStaticText optionsText;
    private HTextButton buttons[][] = new HTextButton[9][9];
    private HTextButton newSudoku, retrySudoku, CheckSudoku, showSudoku;
    private boolean options;
    private boolean[][] locked = new boolean[9][9];
    private int[][] solution = new int[9][9];
    private int[][] numbers = new int[9][9];
    private int[][] tempSudoku = new int[][]{
        {3,2,9,6,5,7,8,4,1},
        {7,4,5,8,3,1,2,9,6},
        {6,1,8,2,4,9,3,7,5},
        {1,9,3,4,6,8,5,2,7},
        {2,7,6,1,9,5,4,8,3},
        {8,5,4,3,7,2,6,1,9},
        {4,3,2,7,1,6,9,5,8},
        {5,8,7,9,2,3,1,6,4},
        {9,6,1,5,8,4,7,3,2}
    };
    
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
      if(debug)System.out.println("Xlet initialiseren");
      this.actueleXletContext = context;
      
      HSceneTemplate sceneTemplate = new HSceneTemplate();
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f,1.0f), HSceneTemplate.REQUIRED);
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f,0.0f), HSceneTemplate.REQUIRED);
      
      scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
      
      optionsText = new HStaticText("Options",525,100,150,50);
      scene.add(optionsText);
      
      newSudoku = new HTextButton("New Sudoku", 525,150,150,50);
      newSudoku.setForeground(new DVBColor(0,0,0,255));
      newSudoku.setBackground(new DVBColor(255,255,255,255));
      newSudoku.setBackgroundMode(HVisible.BACKGROUND_FILL);
      newSudoku.setActionCommand("newSudoku");
      newSudoku.addHActionListener(this);
      scene.add(newSudoku);
      
      retrySudoku = new HTextButton("Retry", 525,215,150,50);
      retrySudoku.setForeground(new DVBColor(0,0,0,255));
      retrySudoku.setBackground(new DVBColor(255,255,255,255));
      retrySudoku.setBackgroundMode(HVisible.BACKGROUND_FILL);
      retrySudoku.setActionCommand("retrySudoku");
      retrySudoku.addHActionListener(this);
      scene.add(retrySudoku);
      
      CheckSudoku = new HTextButton("Check Solution", 525,280,150,50);
      CheckSudoku.setForeground(new DVBColor(0,0,0,255));
      CheckSudoku.setBackground(new DVBColor(255,255,255,255));
      CheckSudoku.setBackgroundMode(HVisible.BACKGROUND_FILL);
      CheckSudoku.setActionCommand("checkSudoku");
      CheckSudoku.addHActionListener(this);
      scene.add(CheckSudoku);
      
      showSudoku = new HTextButton("Show Solution", 525,345,150,50);
      showSudoku.setForeground(new DVBColor(0,0,0,255));
      showSudoku.setBackground(new DVBColor(255,255,255,255));
      showSudoku.setBackgroundMode(HVisible.BACKGROUND_FILL);
      showSudoku.setActionCommand("showSudoku");
      showSudoku.addHActionListener(this);
      scene.add(showSudoku);
      
      newSudoku.setFocusTraversal(showSudoku, retrySudoku, null, null);
      retrySudoku.setFocusTraversal(newSudoku, CheckSudoku, null, null);
      CheckSudoku.setFocusTraversal(retrySudoku, showSudoku, null, null);
      showSudoku.setFocusTraversal(CheckSudoku, newSudoku, null, null);
      
      for(int i = 0;i<numbers.length;i++){
          for(int j = 0;j<numbers.length;j++){
            buttons[i][j]=new HTextButton("",(j*50)+50,(i*50)+50,50,50);
            buttons[i][j].setForeground(new DVBColor(0,0,0,255));
            scene.add(buttons[i][j]);
        }
      }
      
      colorSudoku();
      
      for(int i = 0;i<numbers.length;i++){
          for(int j = 0;j<numbers.length;j++){
              if(i>0){
                  toXup=i-1;
              }else{
                  toXup=8;
              }
              
              if(i<8){
                  toXdown=i+1;
              }else{
                  toXdown=0;
              }
              
              if(j>0){
                  toYleft=j-1;
              }else{
                  toYleft=8;
              }
              
              if(j<8){
                  toYright=j+1;
              }else{
                  toYright=0;
              }
              
              toXleft=i;
              toXright=i;
              toYup=j;
              toYdown=j;
               
              //System.out.println(toXup+","+toYup+"---"+toXdown+","+toYdown+"---"+toXleft+","+toYleft+"---"+toXright+","+toYright);
              buttons[i][j].setFocusTraversal(buttons[toXup][toYup], buttons[toXdown][toYdown], buttons[toXleft][toYleft], buttons[toXright][toYright]);
        }
      }
      
      
      
      generateSudoku();
    }
    

    public void startXlet(){
        if(debug)System.out.println("Xlet starten");
        
        EventManager manager = EventManager.getInstance();
        
        UserEventRepository repos = new UserEventRepository("keys");
        
        repos.addKey(org.havi.ui.event.HRcEvent.VK_NUMPAD0);
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
        repos.addKey(org.havi.ui.event.HRcEvent.VK_ESCAPE);
        
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
                    if(currentRIJ == 0 && !options){
                        currentRIJ=numbers.length-1;
                    }else if(!options){
                        currentRIJ--;
                    }
                    break;
                case HRcEvent.VK_DOWN:
                    if(currentRIJ == numbers.length-1 && !options){
                        currentRIJ=0;
                    }else if(!options){
                        currentRIJ++;
                    }
                    break;
                case HRcEvent.VK_LEFT:
                    if(currentCOL == 0 && !options){
                        currentCOL=numbers.length-1;
                    }else if(!options){
                        currentCOL--;
                    }
                    break;
                case HRcEvent.VK_RIGHT:
                    if(currentCOL == numbers.length-1 && !options){
                        currentCOL=0;
                    }else if(!options){
                        currentCOL++;
                    }
                    break;
                case HRcEvent.VK_ESCAPE:
                    if(options){
                        options = false;
                        buttons[currentRIJ][currentCOL].requestFocus();
                    }else{
                        options = true;
                        newSudoku.requestFocus();
                    }
                    break;
                default:
                    if(!locked[currentRIJ][currentCOL] && !options){
                        numbers[currentRIJ][currentCOL]=e.getCode()-96;
                        updateGrid();
                    }
                    //System.out.println(e.getCode()-96);
                    break;
            }
            
        }
    }
    
    public void colorSudoku(){
        for(int i = 0;i<buttons.length;i++){
          for(int j = 0;j<buttons.length;j++){
            buttons[i][j].setBackground(new DVBColor(255,255,255,255));
            buttons[i][j].setBackgroundMode(HVisible.BACKGROUND_FILL);
        }
      }
        
        for(int i = 3;i<6;i++){
          for(int j = 0;j<3;j++){
            buttons[i][j].setBackground(new DVBColor(150,150,150,255));
            buttons[i][j+6].setBackground(new DVBColor(150,150,150,255));
        }
      }
      
      for(int i = 0;i<3;i++){
          for(int j = 3;j<6;j++){
            buttons[i][j].setBackground(new DVBColor(150,150,150,255));
            buttons[i+6][j].setBackground(new DVBColor(150,150,150,255));
        }
      }
    }
    
    public void generateSudoku(){ 
        
        currentRIJ = 0;
        currentCOL = 0;
        options = false;
        buttons[currentRIJ][currentCOL].requestFocus();
        
        for(int i = 0;i<numbers.length;i++){
            for(int j = 0;j<numbers.length;j++){
                numbers[i][j]=tempSudoku[i][j];
                locked[i][j]=true;
            }
        }
        
        int swapCount = 100; 
        int removeCount = 41;
        
        for(int j = 0;j<numbers.length;j=j+3){
            for(int i = 0;i<swapCount;i++){
                swapRows(j+rd.nextInt(3),j+rd.nextInt(3));
                swapCols(j+rd.nextInt(3),j+rd.nextInt(3));
            }
        }
        
        for(int i = 0;i<swapCount;i++){
            swapBlocksRow(rd.nextInt(3),rd.nextInt(3));
            swapBlocksCol(rd.nextInt(3),rd.nextInt(3));
        }
        
        for(int i = 0;i<numbers.length;i++){
            for(int j = 0;j<numbers.length;j++){
                solution[i][j]=numbers[i][j];
            }
        }
        
        for(int i = 0;i<removeCount;i++){
            removeNumber(rd.nextInt(9),rd.nextInt(9));
        }
        
        updateGrid();
    }
    
    public void removeNumber(int row, int col){
        numbers[row][col]=0;
        locked[row][col]=false;
    }
    
    public void swapRows(int row1, int row2){
        int tempNum;
        
        for(int i = 0;i<numbers.length;i++){
            tempNum = numbers[row1][i];
            numbers[row1][i] = numbers[row2][i];
            numbers[row2][i] = tempNum;
        }
    }
    
    public void swapCols(int col1, int col2){
        int tempNum;
        
        for(int i = 0;i<numbers.length;i++){
            tempNum = numbers[i][col1];
            numbers[i][col1] = numbers[i][col2];
            numbers[i][col2] = tempNum;
        }
    }
    
    public void swapBlocksRow(int block1, int block2)
    {
        for(int i = 0;i<3;i++){
            swapRows(block1*3+i,block2*3+i);
        }
    }
    
    public void swapBlocksCol(int block1, int block2)
    {
        for(int i = 0;i<3;i++){
            swapCols(block1*3+i,block2*3+i);
        }
    }
    
    public void updateGrid(){    
        for(int i = 0;i<numbers.length;i++){
          for(int j = 0;j<numbers.length;j++){
              if(numbers[i][j]!=0){
                  buttons[i][j].setTextContent(Integer.toString(numbers[i][j]), HTextButton.NORMAL_STATE);
              }else{
                  buttons[i][j].setTextContent("", HTextButton.NORMAL_STATE);
              }
          }
        }
        
        scene.repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("newSudoku")){
            System.out.println("newSudoku");
            
            colorSudoku();
            generateSudoku();
        }else if(e.getActionCommand().equals("retrySudoku")){
            System.out.println("retrySudoku");
            
            for(int i = 0;i<numbers.length;i++){
                for(int j = 0;j<numbers.length;j++){
                    if(locked[i][j]){
                        numbers[i][j]=solution[i][j];
                    }else{
                        numbers[i][j]=0;
                    }
                }
            }
            colorSudoku();
            updateGrid();
        }else if(e.getActionCommand().equals("checkSudoku")){
            System.out.println("checkSudoku");
            
            boolean solved = true;
            for(int i = 0;i<numbers.length;i++){
                for(int j = 0;j<numbers.length;j++){
                    if(solution[i][j]!=numbers[i][j]){
                        solved = false;
                        buttons[i][j].setBackground(new DVBColor(230,0,0,255));
                    }
                }
            }
            if(solved){
                generateSudoku();
            }
            updateGrid();
        }else if(e.getActionCommand().equals("showSudoku")){
            System.out.println("showSudoku");
            
            for(int i = 0;i<numbers.length;i++){
                for(int j = 0;j<numbers.length;j++){
                    numbers[i][j]=solution[i][j];
                }
            }
            colorSudoku();
            updateGrid();
        }
    }
        
}
