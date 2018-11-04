public class StudentTicket extends Ticket {
	private int studentID;
	public StudentTicket(int id, Film f, Screen s, String st){
		super(id, f, s, st);
		setDiscount(0.75);
		setType("Student");
}
	public int getStudentID(){
		return studentID;
	}
	
	public void setStudentID(int id){
		studentID = id;
	}
	
}
