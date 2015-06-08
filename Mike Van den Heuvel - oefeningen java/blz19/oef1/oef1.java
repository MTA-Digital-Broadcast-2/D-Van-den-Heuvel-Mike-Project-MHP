/**
* De klasse EersteProg is een java applicatie
*
* @author Van den Heuvel Mike
* @version 1,0
*/

public class oef1{

	public static void main(String args[]){
		for(int i=1;i<=9;i++){
			for(int j=1;j<=9;j++){
				int opl = i*j;
				System.out.print(i+"X"+j+"="+opl+", ");
			}
			System.out.print("\n");
		}
	}

}