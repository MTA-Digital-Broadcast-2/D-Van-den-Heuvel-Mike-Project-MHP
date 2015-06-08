public class PartTimeWerknemer extends Werknemer {

	public int urenGewerkt;

	public PartTimeWerknemer( String voornaam, String achternaam, int nr, float sal, int urengw)
		{
		super(voornaam, achternaam, nr, sal);
		this.urenGewerkt=urengw;
		}

	public float getWeekLoon() {
	return this.salaris * (float)urenGewerkt;

	}


public void salarisVerhogen(int percentage)	{
	if (percentage>5) { System.out.println("Fout: parttimewerknemer kunnen niet meer dan 5% opslag krijgen"); }
		else
		super.salarisVerhogen(percentage); // roep methode van Werknemer aan
		

	}
	

}