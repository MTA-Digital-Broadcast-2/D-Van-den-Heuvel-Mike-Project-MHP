public class StudentWerknemer extends PartTimeWerknemer {

	public StudentWerknemer( String voornaam, String achternaam, int nr, float sal, int urengw)
		{
		super(voornaam, achternaam, nr, sal,urengw);
		this.setRSZ(5.0f);
		}


}