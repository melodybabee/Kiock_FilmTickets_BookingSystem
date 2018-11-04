public class AdultTicket extends Ticket{
	public AdultTicket(int id, Film f, Screen s, String st){
		super(id, f, s, st);
		setType("Adult");
	}
}
