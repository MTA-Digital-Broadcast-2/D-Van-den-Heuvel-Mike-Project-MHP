/**
* @author Van den Heuvel Mike
* @version 1,0
*/

public class oef6{

	public static void main(String args[]){
		int a[] = {12,34,56,78,123,234,99,88};

		int grootste = 0;

		for(int i = 0;i<8;i++){
			if(a[i]>grootste){
				grootste=a[i];
			}
		}
		System.out.println(grootste);
	}

}