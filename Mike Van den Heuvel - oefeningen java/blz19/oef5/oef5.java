/**
* @author Van den Heuvel Mike
* @version 1,0
*/

public class oef5{

	public static void main(String args[]){
		for(int i=3;i<100;i++){
			boolean priem = true;
			for(int j=2;j<i-1;j++){
				if(i%j==0){
					priem=false;
				}
			}
			
			if(priem == true){
				System.out.println(i+" ");
			}
		}
	}

}