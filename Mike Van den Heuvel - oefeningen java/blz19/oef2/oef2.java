/**
* De klasse EersteProg is een java applicatie
*
* @author Van den Heuvel Mike
* @version 1,0
*/

public class oef2{

	public static void main(String args[]){
		for(int j = 0;j<4;j++){
			for(int i = 1;i<=7;i++){
				if(i==1){
					System.out.print("zondag ");
				}else if(i==2){
					System.out.print("maandag ");
				}else if(i==3){
					System.out.print("dinsdag ");
				}else if(i==4){
					System.out.print("woensdag ");
				}else if(i==5){
					System.out.print("donderdag ");
				}else if(i==6){
					System.out.print("vrijdag ");
				}else if(i==7){
					System.out.print("zaterdag ");
				}
				System.out.println((j*7)+i +" februari");
			}
		}
	}

}