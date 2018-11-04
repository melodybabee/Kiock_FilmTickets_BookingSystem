public class SeniorTicket extends Ticket {
	public SeniorTicket(int id, Film f, Screen s, String st){
		super(id, f, s, st);
		setDiscount(0.8);
		setType("Senior");
	}
}
