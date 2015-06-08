/**
* @author Van den Heuvel Mike
* @version 1,0
*/

public class oef7{

	public static void main(String args[]){
		int a[] = {12,34,56,78,123,234,99,88};
		int b[] = {0,0,0,0,0,0,0,0};
		
		for(int j = 0;j<8;j++){
			int grootste = 0;
			int getal = 0;
			for(int i = 0;i<8;i++){
				if(a[i]>grootste){
					grootste=a[i];
					getal=i;
				}
			}
		
			b[j]=grootste;
			a[getal]=0;
		}

		for(int k =0;k<8;k++){
			System.out.println(b[k]+ " ");
		}
	}

}