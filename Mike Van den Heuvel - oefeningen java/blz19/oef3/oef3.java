/**
* @author Van den Heuvel Mike
* @version 1,0
*/

public class oef3{

	public static void main(String args[]){
		double getal=0;
		for(int i=1;i<10000;i++){
			if(i%2==0){
				getal-=(1/i);
			}else{
				getal+=(1/i);
			}
		}
		double pi=4*getal;
		System.out.println(pi);
	}

}