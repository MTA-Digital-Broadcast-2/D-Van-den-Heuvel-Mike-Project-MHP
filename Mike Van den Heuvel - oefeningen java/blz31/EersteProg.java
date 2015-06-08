public class EersteProg
{
public static void main(String [] args)
	{
	//oef 1
	Werknemer herman=new Werknemer("Herman", "Hermans", 1, 1000.0f);
	Werknemer bert=new Werknemer("Bert", "Blokker", 2, 100.0f);
	Werknemer werker=new Werknemer("Werker", "Werkmans", 3, 2000.0f);
	Werknemer koen=new Werknemer("Koen", "Soontjens", 4, 3000.0f);


	//oef 2
	herman.salarisVerhogen(10);
	bert.salarisVerhogen(10);

	System.out.println(herman.voornaam + " verdient " + herman.getSalaris());
	System.out.println(bert.voornaam + " verdient " + bert.getSalaris());


	//oef 3
	
	PartTimeWerknemer interim1=new PartTimeWerknemer("Interim", "1", 3, 12.0f,20);
	PartTimeWerknemer zwangervrouw=new PartTimeWerknemer("Zwangere", "Vrouw", 4, 14.0f,20);

	interim1.salarisVerhogen(10);
	zwangervrouw.salarisVerhogen(10);

	System.out.println(interim1.voornaam + " verdient " + interim1.getSalaris());
	System.out.println(zwangervrouw.voornaam + " verdient " + zwangervrouw.getSalaris());


	//oef 6
	interim1.setRSZ(2.0f);
		System.out.println(interim1.voornaam + " betaalt " + interim1.getRSZ() +"% RSZ");

	//oef 7
	StudentWerknemer bertblokker=new StudentWerknemer("Bert", "Blokker", 7, 9.0f,20);
	System.out.println(bertblokker.voornaam + " betaalt " + bertblokker.getRSZ() +"% RSZ");


	herman.betaal();
	interim1.betaal();
	bertblokker.betaal();


	Faktuur fak= new Faktuur(1,50);
	Faktuur fak2=new Faktuur(2,100);
	fak.betaal();
	fak2.betaal();



	}

}