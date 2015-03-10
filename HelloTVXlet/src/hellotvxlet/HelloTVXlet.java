package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import java.awt.event.*;
import org.havi.ui.event.*;
import org.dvb.event.*;
import java.util.Random;

public class HelloTVXlet implements Xlet, UserEventListener{

    
    // Van den Heuvel Mike
    // Sudoku
    
    // af en toe update de tekst op de knoppen niet maar ze worden wel gewijzigd in de code
    // als je vervolgens op een andere toets drukt update het wel
    
    
  
    private XletContext actueleXletContext;
    private boolean debug = true;
    
    private HScene scene;
    //private HScene scene2;
    
    private HTextButton knop11,knop12,knop13,knop14,knop15,knop16,knop17,knop18,knop19;
    private HTextButton knop21,knop22,knop23,knop24,knop25,knop26,knop27,knop28,knop29;
    private HTextButton knop31,knop32,knop33,knop34,knop35,knop36,knop37,knop38,knop39;
    private HTextButton knop41,knop42,knop43,knop44,knop45,knop46,knop47,knop48,knop49;
    private HTextButton knop51,knop52,knop53,knop54,knop55,knop56,knop57,knop58,knop59;
    private HTextButton knop61,knop62,knop63,knop64,knop65,knop66,knop67,knop68,knop69;
    private HTextButton knop71,knop72,knop73,knop74,knop75,knop76,knop77,knop78,knop79;
    private HTextButton knop81,knop82,knop83,knop84,knop85,knop86,knop87,knop88,knop89;
    private HTextButton knop91,knop92,knop93,knop94,knop95,knop96,knop97,knop98,knop99;
    
    private int currentRIJ;
    private int currentCOL;
    private int locRIJ, locCOL;
    private int numberCount;
    
    private Random rd = new Random();
    
    private boolean[][] locked = new boolean[9][9];
    private int[][] numbers = new int[9][9];
    
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
      
      knop11 = new HTextButton("11",50,50,50,50);
      knop12 = new HTextButton("12",100,50,50,50);
      knop13 = new HTextButton("13",150,50,50,50);
      knop14 = new HTextButton("14",200,50,50,50);
      knop15 = new HTextButton("15",250,50,50,50);
      knop16 = new HTextButton("16",300,50,50,50);
      knop17 = new HTextButton("17",350,50,50,50);
      knop18 = new HTextButton("18",400,50,50,50);
      knop19 = new HTextButton("19",450,50,50,50);
      knop21 = new HTextButton("21",50,100,50,50);
      knop22 = new HTextButton("22",100,100,50,50);
      knop23 = new HTextButton("23",150,100,50,50);
      knop24 = new HTextButton("24",200,100,50,50);
      knop25 = new HTextButton("25",250,100,50,50);
      knop26 = new HTextButton("26",300,100,50,50);
      knop27 = new HTextButton("27",350,100,50,50);
      knop28 = new HTextButton("28",400,100,50,50);
      knop29 = new HTextButton("29",450,100,50,50);
      knop31 = new HTextButton("31",50,150,50,50);
      knop32 = new HTextButton("32",100,150,50,50);
      knop33 = new HTextButton("33",150,150,50,50);
      knop34 = new HTextButton("34",200,150,50,50);
      knop35 = new HTextButton("35",250,150,50,50);
      knop36 = new HTextButton("36",300,150,50,50);
      knop37 = new HTextButton("37",350,150,50,50);
      knop38 = new HTextButton("38",400,150,50,50);
      knop39 = new HTextButton("39",450,150,50,50);
      knop41 = new HTextButton("41",50,200,50,50);
      knop42 = new HTextButton("42",100,200,50,50);
      knop43 = new HTextButton("43",150,200,50,50);
      knop44 = new HTextButton("44",200,200,50,50);
      knop45 = new HTextButton("45",250,200,50,50);
      knop46 = new HTextButton("46",300,200,50,50);
      knop47 = new HTextButton("47",350,200,50,50);
      knop48 = new HTextButton("48",400,200,50,50);
      knop49 = new HTextButton("49",450,200,50,50);
      knop51 = new HTextButton("51",50,250,50,50);
      knop52 = new HTextButton("52",100,250,50,50);
      knop53 = new HTextButton("53",150,250,50,50);
      knop54 = new HTextButton("54",200,250,50,50);
      knop55 = new HTextButton("55",250,250,50,50);
      knop56 = new HTextButton("56",300,250,50,50);
      knop57 = new HTextButton("57",350,250,50,50);
      knop58 = new HTextButton("58",400,250,50,50);
      knop59 = new HTextButton("59",450,250,50,50);
      knop61 = new HTextButton("61",50,300,50,50);
      knop62 = new HTextButton("62",100,300,50,50);
      knop63 = new HTextButton("63",150,300,50,50);
      knop64 = new HTextButton("64",200,300,50,50);
      knop65 = new HTextButton("65",250,300,50,50);
      knop66 = new HTextButton("66",300,300,50,50);
      knop67 = new HTextButton("67",350,300,50,50);
      knop68 = new HTextButton("68",400,300,50,50);
      knop69 = new HTextButton("69",450,300,50,50);
      knop71 = new HTextButton("71",50,350,50,50);
      knop72 = new HTextButton("72",100,350,50,50);
      knop73 = new HTextButton("73",150,350,50,50);
      knop74 = new HTextButton("74",200,350,50,50);
      knop75 = new HTextButton("75",250,350,50,50);
      knop76 = new HTextButton("76",300,350,50,50);
      knop77 = new HTextButton("77",350,350,50,50);
      knop78 = new HTextButton("78",400,350,50,50);
      knop79 = new HTextButton("79",450,350,50,50);
      knop81 = new HTextButton("81",50,400,50,50);
      knop82 = new HTextButton("82",100,400,50,50);
      knop83 = new HTextButton("83",150,400,50,50);
      knop84 = new HTextButton("84",200,400,50,50);
      knop85 = new HTextButton("85",250,400,50,50);
      knop86 = new HTextButton("86",300,400,50,50);
      knop87 = new HTextButton("87",350,400,50,50);
      knop88 = new HTextButton("88",400,400,50,50);
      knop89 = new HTextButton("89",450,400,50,50);
      knop91 = new HTextButton("91",50,450,50,50);
      knop92 = new HTextButton("92",100,450,50,50);
      knop93 = new HTextButton("93",150,450,50,50);
      knop94 = new HTextButton("94",200,450,50,50);
      knop95 = new HTextButton("97",250,450,50,50);
      knop96 = new HTextButton("96",300,450,50,50);
      knop97 = new HTextButton("97",350,450,50,50);
      knop98 = new HTextButton("98",400,450,50,50);
      knop99 = new HTextButton("99",450,450,50,50);
      
      knop11.setForeground(new DVBColor(0,0,0,255));
      knop12.setForeground(new DVBColor(0,0,0,255));
      knop13.setForeground(new DVBColor(0,0,0,255));
      knop14.setForeground(new DVBColor(0,0,0,255));
      knop15.setForeground(new DVBColor(0,0,0,255));
      knop16.setForeground(new DVBColor(0,0,0,255));
      knop17.setForeground(new DVBColor(0,0,0,255));
      knop18.setForeground(new DVBColor(0,0,0,255));
      knop19.setForeground(new DVBColor(0,0,0,255));
      knop21.setForeground(new DVBColor(0,0,0,255));
      knop22.setForeground(new DVBColor(0,0,0,255));
      knop23.setForeground(new DVBColor(0,0,0,255));
      knop24.setForeground(new DVBColor(0,0,0,255));
      knop25.setForeground(new DVBColor(0,0,0,255));
      knop26.setForeground(new DVBColor(0,0,0,255));
      knop27.setForeground(new DVBColor(0,0,0,255));
      knop28.setForeground(new DVBColor(0,0,0,255));
      knop29.setForeground(new DVBColor(0,0,0,255));
      knop31.setForeground(new DVBColor(0,0,0,255));
      knop32.setForeground(new DVBColor(0,0,0,255));
      knop33.setForeground(new DVBColor(0,0,0,255));
      knop34.setForeground(new DVBColor(0,0,0,255));
      knop35.setForeground(new DVBColor(0,0,0,255));
      knop36.setForeground(new DVBColor(0,0,0,255));
      knop37.setForeground(new DVBColor(0,0,0,255));
      knop38.setForeground(new DVBColor(0,0,0,255));
      knop39.setForeground(new DVBColor(0,0,0,255));
      knop41.setForeground(new DVBColor(0,0,0,255));
      knop42.setForeground(new DVBColor(0,0,0,255));
      knop43.setForeground(new DVBColor(0,0,0,255));
      knop44.setForeground(new DVBColor(0,0,0,255));
      knop45.setForeground(new DVBColor(0,0,0,255));
      knop46.setForeground(new DVBColor(0,0,0,255));
      knop47.setForeground(new DVBColor(0,0,0,255));
      knop48.setForeground(new DVBColor(0,0,0,255));
      knop49.setForeground(new DVBColor(0,0,0,255));
      knop51.setForeground(new DVBColor(0,0,0,255));
      knop52.setForeground(new DVBColor(0,0,0,255));
      knop53.setForeground(new DVBColor(0,0,0,255));
      knop54.setForeground(new DVBColor(0,0,0,255));
      knop55.setForeground(new DVBColor(0,0,0,255));
      knop56.setForeground(new DVBColor(0,0,0,255));
      knop57.setForeground(new DVBColor(0,0,0,255));
      knop58.setForeground(new DVBColor(0,0,0,255));
      knop59.setForeground(new DVBColor(0,0,0,255));
      knop61.setForeground(new DVBColor(0,0,0,255));
      knop62.setForeground(new DVBColor(0,0,0,255));
      knop63.setForeground(new DVBColor(0,0,0,255));
      knop64.setForeground(new DVBColor(0,0,0,255));
      knop65.setForeground(new DVBColor(0,0,0,255));
      knop66.setForeground(new DVBColor(0,0,0,255));
      knop67.setForeground(new DVBColor(0,0,0,255));
      knop68.setForeground(new DVBColor(0,0,0,255));
      knop69.setForeground(new DVBColor(0,0,0,255));
      knop71.setForeground(new DVBColor(0,0,0,255));
      knop72.setForeground(new DVBColor(0,0,0,255));
      knop73.setForeground(new DVBColor(0,0,0,255));
      knop74.setForeground(new DVBColor(0,0,0,255));
      knop75.setForeground(new DVBColor(0,0,0,255));
      knop76.setForeground(new DVBColor(0,0,0,255));
      knop77.setForeground(new DVBColor(0,0,0,255));
      knop78.setForeground(new DVBColor(0,0,0,255));
      knop79.setForeground(new DVBColor(0,0,0,255));
      knop81.setForeground(new DVBColor(0,0,0,255));
      knop82.setForeground(new DVBColor(0,0,0,255));
      knop83.setForeground(new DVBColor(0,0,0,255));
      knop84.setForeground(new DVBColor(0,0,0,255));
      knop85.setForeground(new DVBColor(0,0,0,255));
      knop86.setForeground(new DVBColor(0,0,0,255));
      knop87.setForeground(new DVBColor(0,0,0,255));
      knop88.setForeground(new DVBColor(0,0,0,255));
      knop89.setForeground(new DVBColor(0,0,0,255));
      knop91.setForeground(new DVBColor(0,0,0,255));
      knop92.setForeground(new DVBColor(0,0,0,255));
      knop93.setForeground(new DVBColor(0,0,0,255));
      knop94.setForeground(new DVBColor(0,0,0,255));
      knop95.setForeground(new DVBColor(0,0,0,255));
      knop96.setForeground(new DVBColor(0,0,0,255));
      knop97.setForeground(new DVBColor(0,0,0,255));
      knop98.setForeground(new DVBColor(0,0,0,255));
      knop99.setForeground(new DVBColor(0,0,0,255));
      
      knop11.setBackground(new DVBColor(255,255,255,255));
      knop12.setBackground(new DVBColor(255,255,255,255));
      knop13.setBackground(new DVBColor(255,255,255,255));
      knop14.setBackground(new DVBColor(150,150,150,255));
      knop15.setBackground(new DVBColor(150,150,150,255));
      knop16.setBackground(new DVBColor(150,150,150,255));
      knop17.setBackground(new DVBColor(255,255,255,255));
      knop18.setBackground(new DVBColor(255,255,255,255));
      knop19.setBackground(new DVBColor(255,255,255,255));
      knop21.setBackground(new DVBColor(255,255,255,255));
      knop22.setBackground(new DVBColor(255,255,255,255));
      knop23.setBackground(new DVBColor(255,255,255,255));
      knop24.setBackground(new DVBColor(150,150,150,255));
      knop25.setBackground(new DVBColor(150,150,150,255));
      knop26.setBackground(new DVBColor(150,150,150,255));
      knop27.setBackground(new DVBColor(255,255,255,255));
      knop28.setBackground(new DVBColor(255,255,255,255));
      knop29.setBackground(new DVBColor(255,255,255,255));
      knop31.setBackground(new DVBColor(255,255,255,255));
      knop32.setBackground(new DVBColor(255,255,255,255));
      knop33.setBackground(new DVBColor(255,255,255,255));
      knop34.setBackground(new DVBColor(150,150,150,255));
      knop35.setBackground(new DVBColor(150,150,150,255));
      knop36.setBackground(new DVBColor(150,150,150,255));
      knop37.setBackground(new DVBColor(255,255,255,255));
      knop38.setBackground(new DVBColor(255,255,255,255));
      knop39.setBackground(new DVBColor(255,255,255,255));
      knop41.setBackground(new DVBColor(150,150,150,255));
      knop42.setBackground(new DVBColor(150,150,150,255));
      knop43.setBackground(new DVBColor(150,150,150,255));
      knop44.setBackground(new DVBColor(255,255,255,255));
      knop45.setBackground(new DVBColor(255,255,255,255));
      knop46.setBackground(new DVBColor(255,255,255,255));
      knop47.setBackground(new DVBColor(150,150,150,255));
      knop48.setBackground(new DVBColor(150,150,150,255));
      knop49.setBackground(new DVBColor(150,150,150,255));
      knop51.setBackground(new DVBColor(150,150,150,255));
      knop52.setBackground(new DVBColor(150,150,150,255));
      knop53.setBackground(new DVBColor(150,150,150,255));
      knop54.setBackground(new DVBColor(255,255,255,255));
      knop55.setBackground(new DVBColor(255,255,255,255));
      knop56.setBackground(new DVBColor(255,255,255,255));
      knop57.setBackground(new DVBColor(150,150,150,255));
      knop58.setBackground(new DVBColor(150,150,150,255));
      knop59.setBackground(new DVBColor(150,150,150,255));
      knop61.setBackground(new DVBColor(150,150,150,255));
      knop62.setBackground(new DVBColor(150,150,150,255));
      knop63.setBackground(new DVBColor(150,150,150,255));
      knop64.setBackground(new DVBColor(255,255,255,255));
      knop65.setBackground(new DVBColor(255,255,255,255));
      knop66.setBackground(new DVBColor(255,255,255,255));
      knop67.setBackground(new DVBColor(150,150,150,255));
      knop68.setBackground(new DVBColor(150,150,150,255));
      knop69.setBackground(new DVBColor(150,150,150,255));
      knop71.setBackground(new DVBColor(255,255,255,255));
      knop72.setBackground(new DVBColor(255,255,255,255));
      knop73.setBackground(new DVBColor(255,255,255,255));
      knop74.setBackground(new DVBColor(150,150,150,255));
      knop75.setBackground(new DVBColor(150,150,150,255));
      knop76.setBackground(new DVBColor(150,150,150,255));
      knop77.setBackground(new DVBColor(255,255,255,255));
      knop78.setBackground(new DVBColor(255,255,255,255));
      knop79.setBackground(new DVBColor(255,255,255,255));
      knop81.setBackground(new DVBColor(255,255,255,255));
      knop82.setBackground(new DVBColor(255,255,255,255));
      knop83.setBackground(new DVBColor(255,255,255,255));
      knop84.setBackground(new DVBColor(150,150,150,255));
      knop85.setBackground(new DVBColor(150,150,150,255));
      knop86.setBackground(new DVBColor(150,150,150,255));
      knop87.setBackground(new DVBColor(255,255,255,255));
      knop88.setBackground(new DVBColor(255,255,255,255));
      knop89.setBackground(new DVBColor(255,255,255,255));
      knop91.setBackground(new DVBColor(255,255,255,255));
      knop92.setBackground(new DVBColor(255,255,255,255));
      knop93.setBackground(new DVBColor(255,255,255,255));
      knop94.setBackground(new DVBColor(150,150,150,255));
      knop95.setBackground(new DVBColor(150,150,150,255));
      knop96.setBackground(new DVBColor(150,150,150,255));
      knop97.setBackground(new DVBColor(255,255,255,255));
      knop98.setBackground(new DVBColor(255,255,255,255));
      knop99.setBackground(new DVBColor(255,255,255,255));
      
      
      knop11.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop12.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop13.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop14.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop15.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop16.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop17.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop18.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop19.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop21.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop22.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop23.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop24.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop25.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop26.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop27.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop28.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop29.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop31.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop32.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop33.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop34.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop35.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop36.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop37.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop38.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop39.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop41.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop42.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop43.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop44.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop45.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop46.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop47.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop48.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop49.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop51.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop52.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop53.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop54.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop55.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop56.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop57.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop58.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop59.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop61.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop62.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop63.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop64.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop65.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop66.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop67.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop68.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop69.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop71.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop72.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop73.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop74.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop75.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop76.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop77.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop78.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop79.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop81.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop82.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop83.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop84.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop85.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop86.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop87.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop88.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop89.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop91.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop92.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop93.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop94.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop95.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop96.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop97.setBackgroundMode(HVisible.BACKGROUND_FILL);
      knop98.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      knop99.setBackgroundMode(HVisible.BACKGROUND_FILL); 
      
      scene.add(knop11);
      scene.add(knop12); 
      scene.add(knop13);
      scene.add(knop14);
      scene.add(knop15); 
      scene.add(knop16);
      scene.add(knop17);
      scene.add(knop18); 
      scene.add(knop19);
      scene.add(knop21);
      scene.add(knop22); 
      scene.add(knop23);
      scene.add(knop24);
      scene.add(knop25); 
      scene.add(knop26);
      scene.add(knop27);
      scene.add(knop28); 
      scene.add(knop29);
      scene.add(knop31);
      scene.add(knop32); 
      scene.add(knop33);
      scene.add(knop34);
      scene.add(knop35); 
      scene.add(knop36);
      scene.add(knop37);
      scene.add(knop38); 
      scene.add(knop39);
      scene.add(knop41);
      scene.add(knop42); 
      scene.add(knop43);
      scene.add(knop44);
      scene.add(knop45); 
      scene.add(knop46);
      scene.add(knop47);
      scene.add(knop48); 
      scene.add(knop49);
      scene.add(knop51);
      scene.add(knop52); 
      scene.add(knop53);
      scene.add(knop54);
      scene.add(knop55); 
      scene.add(knop56);
      scene.add(knop57);
      scene.add(knop58); 
      scene.add(knop59);
      scene.add(knop61);
      scene.add(knop62); 
      scene.add(knop63);
      scene.add(knop64);
      scene.add(knop65); 
      scene.add(knop66);
      scene.add(knop67);
      scene.add(knop68); 
      scene.add(knop69);
      scene.add(knop71);
      scene.add(knop72); 
      scene.add(knop73);
      scene.add(knop74);
      scene.add(knop75); 
      scene.add(knop76);
      scene.add(knop77);
      scene.add(knop78); 
      scene.add(knop79);
      scene.add(knop81);
      scene.add(knop82); 
      scene.add(knop83);
      scene.add(knop84);
      scene.add(knop85); 
      scene.add(knop86);
      scene.add(knop87);
      scene.add(knop88); 
      scene.add(knop89);
      scene.add(knop91);
      scene.add(knop92); 
      scene.add(knop93);
      scene.add(knop94);
      scene.add(knop95); 
      scene.add(knop96);
      scene.add(knop97);
      scene.add(knop98); 
      scene.add(knop99);
      
      knop11.requestFocus();
      currentRIJ = 0;
      currentCOL = 0;
      
      knop11.setFocusTraversal(knop91, knop21, knop19, knop12);//op    neer    links    rechts
      knop12.setFocusTraversal(knop92, knop22, knop11, knop13);
      knop13.setFocusTraversal(knop93, knop23, knop12, knop14);
      knop14.setFocusTraversal(knop94, knop24, knop13, knop15);//op    neer    links    rechts
      knop15.setFocusTraversal(knop95, knop25, knop14, knop16);
      knop16.setFocusTraversal(knop96, knop26, knop15, knop17);
      knop17.setFocusTraversal(knop97, knop27, knop16, knop18);//op    neer    links    rechts
      knop18.setFocusTraversal(knop98, knop28, knop17, knop19);
      knop19.setFocusTraversal(knop99, knop29, knop18, knop11);
      knop21.setFocusTraversal(knop11, knop31, knop29, knop22);//op    neer    links    rechts
      knop22.setFocusTraversal(knop12, knop32, knop21, knop23);
      knop23.setFocusTraversal(knop13, knop33, knop22, knop24);
      knop24.setFocusTraversal(knop14, knop34, knop23, knop25);//op    neer    links    rechts
      knop25.setFocusTraversal(knop15, knop35, knop24, knop26);
      knop26.setFocusTraversal(knop16, knop36, knop25, knop27);
      knop27.setFocusTraversal(knop17, knop37, knop26, knop28);//op    neer    links    rechts
      knop28.setFocusTraversal(knop18, knop38, knop27, knop29);
      knop29.setFocusTraversal(knop19, knop39, knop28, knop21);
      knop31.setFocusTraversal(knop21, knop41, knop39, knop32);//op    neer    links    rechts
      knop32.setFocusTraversal(knop22, knop42, knop31, knop33);
      knop33.setFocusTraversal(knop23, knop43, knop32, knop34);
      knop34.setFocusTraversal(knop24, knop44, knop33, knop35);//op    neer    links    rechts
      knop35.setFocusTraversal(knop25, knop45, knop34, knop36);
      knop36.setFocusTraversal(knop26, knop46, knop35, knop37);
      knop37.setFocusTraversal(knop27, knop47, knop36, knop38);//op    neer    links    rechts
      knop38.setFocusTraversal(knop28, knop48, knop37, knop39);
      knop39.setFocusTraversal(knop29, knop49, knop38, knop31);
      knop41.setFocusTraversal(knop31, knop51, knop49, knop42);//op    neer    links    rechts
      knop42.setFocusTraversal(knop32, knop52, knop41, knop43);
      knop43.setFocusTraversal(knop33, knop53, knop42, knop44);
      knop44.setFocusTraversal(knop34, knop54, knop43, knop45);//op    neer    links    rechts
      knop45.setFocusTraversal(knop35, knop55, knop44, knop46);
      knop46.setFocusTraversal(knop36, knop56, knop45, knop47);
      knop47.setFocusTraversal(knop37, knop57, knop46, knop48);//op    neer    links    rechts
      knop48.setFocusTraversal(knop38, knop58, knop47, knop49);
      knop49.setFocusTraversal(knop39, knop59, knop48, knop41);
      knop51.setFocusTraversal(knop41, knop61, knop59, knop52);//op    neer    links    rechts
      knop52.setFocusTraversal(knop42, knop62, knop51, knop53);
      knop53.setFocusTraversal(knop43, knop63, knop52, knop54);
      knop54.setFocusTraversal(knop44, knop64, knop53, knop55);//op    neer    links    rechts
      knop55.setFocusTraversal(knop45, knop65, knop54, knop56);
      knop56.setFocusTraversal(knop46, knop66, knop55, knop57);
      knop57.setFocusTraversal(knop47, knop67, knop56, knop58);//op    neer    links    rechts
      knop58.setFocusTraversal(knop48, knop68, knop57, knop59);
      knop59.setFocusTraversal(knop49, knop69, knop58, knop51);
      knop61.setFocusTraversal(knop51, knop71, knop69, knop62);//op    neer    links    rechts
      knop62.setFocusTraversal(knop52, knop72, knop61, knop63);
      knop63.setFocusTraversal(knop53, knop73, knop62, knop64);
      knop64.setFocusTraversal(knop54, knop74, knop63, knop65);//op    neer    links    rechts
      knop65.setFocusTraversal(knop55, knop75, knop64, knop66);
      knop66.setFocusTraversal(knop56, knop76, knop65, knop67);
      knop67.setFocusTraversal(knop57, knop77, knop66, knop68);//op    neer    links    rechts
      knop68.setFocusTraversal(knop58, knop78, knop67, knop69);
      knop69.setFocusTraversal(knop59, knop79, knop68, knop61);
      knop71.setFocusTraversal(knop61, knop81, knop79, knop72);//op    neer    links    rechts
      knop72.setFocusTraversal(knop62, knop82, knop71, knop73);
      knop73.setFocusTraversal(knop63, knop83, knop72, knop74);
      knop74.setFocusTraversal(knop64, knop84, knop73, knop75);//op    neer    links    rechts
      knop75.setFocusTraversal(knop65, knop85, knop74, knop76);
      knop76.setFocusTraversal(knop66, knop86, knop75, knop77);
      knop77.setFocusTraversal(knop67, knop87, knop76, knop78);//op    neer    links    rechts
      knop78.setFocusTraversal(knop68, knop88, knop77, knop79);
      knop79.setFocusTraversal(knop69, knop89, knop78, knop71);
      knop81.setFocusTraversal(knop71, knop91, knop89, knop82);//op    neer    links    rechts
      knop82.setFocusTraversal(knop72, knop92, knop81, knop83);
      knop83.setFocusTraversal(knop73, knop93, knop82, knop84);
      knop84.setFocusTraversal(knop74, knop94, knop83, knop85);//op    neer    links    rechts
      knop85.setFocusTraversal(knop75, knop95, knop84, knop86);
      knop86.setFocusTraversal(knop76, knop96, knop85, knop87);
      knop87.setFocusTraversal(knop77, knop97, knop86, knop88);//op    neer    links    rechts
      knop88.setFocusTraversal(knop78, knop98, knop87, knop89);
      knop89.setFocusTraversal(knop79, knop99, knop88, knop81);
      knop91.setFocusTraversal(knop81, knop11, knop99, knop92);//op    neer    links    rechts
      knop92.setFocusTraversal(knop82, knop12, knop91, knop93);
      knop93.setFocusTraversal(knop83, knop13, knop92, knop94);
      knop94.setFocusTraversal(knop84, knop14, knop93, knop95);//op    neer    links    rechts
      knop95.setFocusTraversal(knop85, knop15, knop94, knop96);
      knop96.setFocusTraversal(knop86, knop16, knop95, knop97);
      knop97.setFocusTraversal(knop87, knop17, knop96, knop98);//op    neer    links    rechts
      knop98.setFocusTraversal(knop88, knop18, knop97, knop99);
      knop99.setFocusTraversal(knop89, knop19, knop98, knop91);
      
      generateSudoku();
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
                    if(!locked[currentRIJ][currentCOL]){
                        numbers[currentRIJ][currentCOL]=e.getCode()-96;
                        updateGrid();
                    }
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
    
    public void generateSudoku(){
        numberCount = 30;
        boolean containsNum;
        
        while(numberCount != 0){
            int num = rd.nextInt(9);
        
            locRIJ = rd.nextInt(9);
            locCOL = rd.nextInt(9);

            containsNum = false;
            if(numbers[locRIJ][locCOL]>0){
                containsNum = true;
            }

            for(int i = 0;i<numbers.length-1;i++){
                if(numbers[i][locCOL]==num){
                    containsNum=true;
                }
            }

            for(int i = 0;i<numbers.length-1;i++){
                if(numbers[locRIJ][i]==num){
                    containsNum=true;
                }
            }

            if(!containsNum){
                numbers[locRIJ][locCOL]=num;
                locked[locRIJ][locCOL]=true;
                numberCount--;
            }
        }
        
        updateGrid();
    }
    
    public void updateGrid(){
        knop11.setTextContent(Integer.toString(numbers[0][0]), HTextButton.NORMAL_STATE);
        knop12.setTextContent(Integer.toString(numbers[0][1]), HTextButton.NORMAL_STATE);
        knop13.setTextContent(Integer.toString(numbers[0][2]), HTextButton.NORMAL_STATE);
        knop14.setTextContent(Integer.toString(numbers[0][3]), HTextButton.NORMAL_STATE);
        knop15.setTextContent(Integer.toString(numbers[0][4]), HTextButton.NORMAL_STATE);
        knop16.setTextContent(Integer.toString(numbers[0][5]), HTextButton.NORMAL_STATE);
        knop17.setTextContent(Integer.toString(numbers[0][6]), HTextButton.NORMAL_STATE);
        knop18.setTextContent(Integer.toString(numbers[0][7]), HTextButton.NORMAL_STATE);
        knop19.setTextContent(Integer.toString(numbers[0][8]), HTextButton.NORMAL_STATE);
        knop21.setTextContent(Integer.toString(numbers[1][0]), HTextButton.NORMAL_STATE);
        knop22.setTextContent(Integer.toString(numbers[1][1]), HTextButton.NORMAL_STATE);
        knop23.setTextContent(Integer.toString(numbers[1][2]), HTextButton.NORMAL_STATE);
        knop24.setTextContent(Integer.toString(numbers[1][3]), HTextButton.NORMAL_STATE);
        knop25.setTextContent(Integer.toString(numbers[1][4]), HTextButton.NORMAL_STATE);
        knop26.setTextContent(Integer.toString(numbers[1][5]), HTextButton.NORMAL_STATE);
        knop27.setTextContent(Integer.toString(numbers[1][6]), HTextButton.NORMAL_STATE);
        knop28.setTextContent(Integer.toString(numbers[1][7]), HTextButton.NORMAL_STATE);
        knop29.setTextContent(Integer.toString(numbers[1][8]), HTextButton.NORMAL_STATE);
        knop31.setTextContent(Integer.toString(numbers[2][0]), HTextButton.NORMAL_STATE);
        knop32.setTextContent(Integer.toString(numbers[2][1]), HTextButton.NORMAL_STATE);
        knop33.setTextContent(Integer.toString(numbers[2][2]), HTextButton.NORMAL_STATE);
        knop34.setTextContent(Integer.toString(numbers[2][3]), HTextButton.NORMAL_STATE);
        knop35.setTextContent(Integer.toString(numbers[2][4]), HTextButton.NORMAL_STATE);
        knop36.setTextContent(Integer.toString(numbers[2][5]), HTextButton.NORMAL_STATE);
        knop37.setTextContent(Integer.toString(numbers[2][6]), HTextButton.NORMAL_STATE);
        knop38.setTextContent(Integer.toString(numbers[2][7]), HTextButton.NORMAL_STATE);
        knop39.setTextContent(Integer.toString(numbers[2][8]), HTextButton.NORMAL_STATE);
        knop41.setTextContent(Integer.toString(numbers[3][0]), HTextButton.NORMAL_STATE);
        knop42.setTextContent(Integer.toString(numbers[3][1]), HTextButton.NORMAL_STATE);
        knop43.setTextContent(Integer.toString(numbers[3][2]), HTextButton.NORMAL_STATE);
        knop44.setTextContent(Integer.toString(numbers[3][3]), HTextButton.NORMAL_STATE);
        knop45.setTextContent(Integer.toString(numbers[3][4]), HTextButton.NORMAL_STATE);
        knop46.setTextContent(Integer.toString(numbers[3][5]), HTextButton.NORMAL_STATE);
        knop47.setTextContent(Integer.toString(numbers[3][6]), HTextButton.NORMAL_STATE);
        knop48.setTextContent(Integer.toString(numbers[3][7]), HTextButton.NORMAL_STATE);
        knop49.setTextContent(Integer.toString(numbers[3][8]), HTextButton.NORMAL_STATE);
        knop51.setTextContent(Integer.toString(numbers[4][0]), HTextButton.NORMAL_STATE);
        knop52.setTextContent(Integer.toString(numbers[4][1]), HTextButton.NORMAL_STATE);
        knop53.setTextContent(Integer.toString(numbers[4][2]), HTextButton.NORMAL_STATE);
        knop54.setTextContent(Integer.toString(numbers[4][3]), HTextButton.NORMAL_STATE);
        knop55.setTextContent(Integer.toString(numbers[4][4]), HTextButton.NORMAL_STATE);
        knop56.setTextContent(Integer.toString(numbers[4][5]), HTextButton.NORMAL_STATE);
        knop57.setTextContent(Integer.toString(numbers[4][6]), HTextButton.NORMAL_STATE);
        knop58.setTextContent(Integer.toString(numbers[4][7]), HTextButton.NORMAL_STATE);
        knop59.setTextContent(Integer.toString(numbers[4][8]), HTextButton.NORMAL_STATE);
        knop61.setTextContent(Integer.toString(numbers[5][0]), HTextButton.NORMAL_STATE);
        knop62.setTextContent(Integer.toString(numbers[5][1]), HTextButton.NORMAL_STATE);
        knop63.setTextContent(Integer.toString(numbers[5][2]), HTextButton.NORMAL_STATE);
        knop64.setTextContent(Integer.toString(numbers[5][3]), HTextButton.NORMAL_STATE);
        knop65.setTextContent(Integer.toString(numbers[5][4]), HTextButton.NORMAL_STATE);
        knop66.setTextContent(Integer.toString(numbers[5][5]), HTextButton.NORMAL_STATE);
        knop67.setTextContent(Integer.toString(numbers[5][6]), HTextButton.NORMAL_STATE);
        knop68.setTextContent(Integer.toString(numbers[5][7]), HTextButton.NORMAL_STATE);
        knop69.setTextContent(Integer.toString(numbers[5][8]), HTextButton.NORMAL_STATE);
        knop71.setTextContent(Integer.toString(numbers[6][0]), HTextButton.NORMAL_STATE);
        knop72.setTextContent(Integer.toString(numbers[6][1]), HTextButton.NORMAL_STATE);
        knop73.setTextContent(Integer.toString(numbers[6][2]), HTextButton.NORMAL_STATE);
        knop74.setTextContent(Integer.toString(numbers[6][3]), HTextButton.NORMAL_STATE);
        knop75.setTextContent(Integer.toString(numbers[6][4]), HTextButton.NORMAL_STATE);
        knop76.setTextContent(Integer.toString(numbers[6][5]), HTextButton.NORMAL_STATE);
        knop77.setTextContent(Integer.toString(numbers[6][6]), HTextButton.NORMAL_STATE);
        knop78.setTextContent(Integer.toString(numbers[6][7]), HTextButton.NORMAL_STATE);
        knop79.setTextContent(Integer.toString(numbers[6][8]), HTextButton.NORMAL_STATE);
        knop81.setTextContent(Integer.toString(numbers[7][0]), HTextButton.NORMAL_STATE);
        knop82.setTextContent(Integer.toString(numbers[7][1]), HTextButton.NORMAL_STATE);
        knop83.setTextContent(Integer.toString(numbers[7][2]), HTextButton.NORMAL_STATE);
        knop84.setTextContent(Integer.toString(numbers[7][3]), HTextButton.NORMAL_STATE);
        knop85.setTextContent(Integer.toString(numbers[7][4]), HTextButton.NORMAL_STATE);
        knop86.setTextContent(Integer.toString(numbers[7][5]), HTextButton.NORMAL_STATE);
        knop87.setTextContent(Integer.toString(numbers[7][6]), HTextButton.NORMAL_STATE);
        knop88.setTextContent(Integer.toString(numbers[7][7]), HTextButton.NORMAL_STATE);
        knop89.setTextContent(Integer.toString(numbers[7][8]), HTextButton.NORMAL_STATE);
        knop91.setTextContent(Integer.toString(numbers[8][0]), HTextButton.NORMAL_STATE);
        knop92.setTextContent(Integer.toString(numbers[8][1]), HTextButton.NORMAL_STATE);
        knop93.setTextContent(Integer.toString(numbers[8][2]), HTextButton.NORMAL_STATE);
        knop94.setTextContent(Integer.toString(numbers[8][3]), HTextButton.NORMAL_STATE);
        knop95.setTextContent(Integer.toString(numbers[8][4]), HTextButton.NORMAL_STATE);
        knop96.setTextContent(Integer.toString(numbers[8][5]), HTextButton.NORMAL_STATE);
        knop97.setTextContent(Integer.toString(numbers[8][6]), HTextButton.NORMAL_STATE);
        knop98.setTextContent(Integer.toString(numbers[8][7]), HTextButton.NORMAL_STATE);
        knop99.setTextContent(Integer.toString(numbers[8][8]), HTextButton.NORMAL_STATE);
        scene.repaint();
    }
        
}
