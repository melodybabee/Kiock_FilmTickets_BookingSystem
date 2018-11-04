
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
public class KioskControl {
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	private ArrayList<Film> films = new ArrayList<Film>();
	private ArrayList<Screen> screens = new ArrayList<Screen>();
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
	
	public void creatTicket(Ticket t) {
		tickets.add(t);
	}

	public void addFilm(Film f){
		films.add(f);
	}
	
	public ArrayList<Film> getFilm(){
		return films;
	}
	
	public void addScreen(Screen s){
		screens.add(s);
	}
	
	public ArrayList<Screen> getScreen(){
		return screens;
	}
	
	public void setScreen(ArrayList<Screen> s){
		screens = s;
	}

	public void setFilm(ArrayList<Film> f){
		films = f;
	}
	
	public void setTicket(ArrayList<Ticket> t){
		tickets = t;
	}
	
	
	
	public int createTicketID(){
		int ticID = 00000000;
		int ticDigit[] = new int[8];
		StringBuffer strBuffer = new StringBuffer();
		String s = "00000000";
		while(true){
		boolean mark = false;
		for(int i=0;i<8;i++){
		ticDigit[i] = 1 + (int)(Math.random()*4);
		strBuffer.append(ticDigit[i]);
		}
		s = strBuffer.toString();
		ticID = Integer.parseInt(s);
		for(Ticket b: tickets){
			if(b.getID()==ticID){
				mark = true;
				break;
			}
		}
		if (mark == false){
			return ticID;
		}
		else
			continue;
	  }
	}
	
	public ArrayList<Ticket> readTicket() {
		ArrayList<Ticket> temp = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					new File("tickets")));
			temp = (ArrayList<Ticket>) ois.readObject();
			ois.close();

		} catch (FileNotFoundException e) {
			return new ArrayList<Ticket>();
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<Ticket>();
		}
		return temp;
	}
	
	public void writeData(Ticket t, String type){
		try{
			File myFile=new File("ticket"+tickets.size()+".txt");
			FileWriter fw=new FileWriter(myFile,true);
			BufferedWriter writer=new BufferedWriter(fw);
			writer.write("Movie name: " + t.getFilm().getTitle());
			writer.newLine();
			writer.write("Screen: " + t.getScreen().getScreenType());
			writer.newLine();
			writer.write("Time: " + formatter.format(t.getScreen().getDate().getTime()));
			writer.newLine();
			writer.write("TicketType: " + type);
			writer.newLine();
			writer.write("Seat: " + t.getSeat());
			writer.newLine();
			writer.write("Ticket ID: "+ t.getID());
			writer.newLine();
			if(type.equals("Student")){
				StudentTicket stu = (StudentTicket)t;
				writer.write("Student ID: "+ stu.getStudentID());
				writer.newLine();
			}
			writer.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void generateReport(){
		try{
			File myFile=new File("report.txt");
			FileWriter fw=new FileWriter(myFile,true);
			BufferedWriter writer=new BufferedWriter(fw);
			int[] saleOfFilm = new int[films.size()];
			String[] filmName = new String[films.size()];
			int count1 = 0;
			for(Film f: films){//get all the film titles
				filmName[count1]=f.getTitle();
				count1++;
			}
			
			for(int i= 0; i<films.size();i++){//count sale of each film
				int count2 = 0;
			for(Ticket t: tickets){
				if(t.getFilm().getTitle().equals(filmName[i])){
					count2++;
				}
			}
			saleOfFilm[i] = count2;
			}
			
			int[] saleOfTicketType = new int[4];
			int[] count = {0, 0, 0, 0};
			String[] ticketType = {"Child","Adult","Senior","Student"};
			for(Ticket t: tickets){
				switch(t.getType()){
				case "Child":
					count[0]++;
					break;
				case "Adult":
					count[1]++;
					break;
				case "Senior":
					count[2]++;
					break;
				case "Student":
					count[3]++;
					break;
				default:
					break;
				}
			}
			for(int i=0; i<count.length;i++){
				saleOfTicketType[i]=count[i];
			}
			
			for(int i=0; i<saleOfFilm.length; i++){
				writer.write("Movie name: " + filmName[i] + "  Sales: " + saleOfFilm[i]);
				writer.newLine();
			}
			writer.write("--------------------------------------------------");
			writer.newLine();
			writer.write("The total number of tickets sold is:    " + tickets.size());
			writer.newLine();
			for(int i=0; i<saleOfTicketType.length; i++){
				writer.write("Ticket type: " + ticketType[i] + "  Sales: " + saleOfTicketType[i]);
				writer.newLine();
			}
			writer.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public ArrayList<Film> readFilm() {
		ArrayList<Film> temp = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					new File("films")));
			temp = (ArrayList<Film>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			return new ArrayList<Film>();
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<Film>();
		}
		return temp;
	}
	
	public ArrayList<Screen> readScreen() {
		ArrayList<Screen> temp = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					new File("screens")));
			temp = (ArrayList<Screen>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			return new ArrayList<Screen>();
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<Screen>();
		}
		return temp;
	}
	
	
	public void saveTicket() {
		try {
			ObjectOutputStream oo = new ObjectOutputStream(
					new FileOutputStream(new File("tickets")));
			oo.writeObject(this.tickets);
			oo.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void saveFilm() {
		try {
			ObjectOutputStream oo = new ObjectOutputStream(
					new FileOutputStream(new File("films")));
			oo.writeObject(films);
			oo.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void saveScreen() {
		try {
			ObjectOutputStream oo = new ObjectOutputStream(
					new FileOutputStream(new File("screens")));
			oo.writeObject(screens);
			oo.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
