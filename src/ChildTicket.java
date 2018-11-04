public class ChildTicket extends Ticket {
	public ChildTicket(int id, Film f, Screen s, String st){
		super(id, f, s, st);
		setDiscount(0.5);
		setType("Child");
	}
}
