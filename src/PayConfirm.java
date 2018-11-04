
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
public class PayConfirm extends JFrame{
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
	public PayConfirm(Film f, Screen s, int ticketNum, String ticketType, String[] seats, int[] seatIndex){
		PayConfirm temp_frame= this;
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBounds(100, 100, 756, 491);
		switch(ticketType){
		case "Child":
			for(int i = 0;i<ticketNum; i++){
				tickets.add(new ChildTicket(CinemaService.getInstance().getKioskControl().createTicketID(),f, s, seats[i]));
			}
			break;
		case "Adult":
			for(int i = 0;i<ticketNum; i++){
				tickets.add(new AdultTicket(CinemaService.getInstance().getKioskControl().createTicketID(),f, s, seats[i]));
			}
			break;
		case "Senior":
			for(int i = 0;i<ticketNum; i++){
				tickets.add(new SeniorTicket(CinemaService.getInstance().getKioskControl().createTicketID(),f, s, seats[i]));
			}
			break;
		case "Student":
			for(int i = 0;i<ticketNum; i++){
				tickets.add(new StudentTicket(CinemaService.getInstance().getKioskControl().createTicketID(),f, s, seats[i]));
			}
			break;
		default:
			break;
		}
		
		JTextArea txtrDdd = new JTextArea();
		for(Ticket t:tickets){
		txtrDdd.append(f.getTitle()+" " + " Screen " + s.getScreenType() + " Time: " + formatter.format(s.getDate().getTime()) + 
				"Ticket Type: "+ ticketType + " Seat: " + t.getSeat() + " Ticket ID: " + t.getID() + "\n");
		}
		txtrDdd.append("The total price is: "+ TotalPrice(tickets) + " pounds\n");
		txtrDdd.setBounds(31, 48, 662, 301);
		contentPane.add(txtrDdd);
		txtrDdd.setEditable(false);
		
		
		JLabel stuText = new JLabel("Please enter your student ID if you are buying student tickets:");
		stuText.setBounds(31, 350, 500, 30);
		contentPane.add(stuText);
		
		JTextField stuID = new JTextField();
		stuID.setBounds(500, 360, 200, 30);
		contentPane.add(stuID);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BriefInfFrame();
				return;
			}
		});
		
		btnBack.setBounds(329, 394, 167, 27);
		contentPane.add(btnBack);
		
		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ticketType.equals("Student")){
					int count = 1;
					for(Ticket t: tickets){
						StudentTicket stu = (StudentTicket)t;
						stu.setStudentID(Integer.parseInt(stuID.getText()));
						CinemaService.getInstance().getKioskControl().creatTicket(stu);
						CinemaService.getInstance().getKioskControl().writeData(stu, ticketType);
						count++;
					}
					s.setSeat(seatIndex);
					CinemaService.getInstance().getKioskControl().saveTicket();
					CinemaService.getInstance().getKioskControl().saveScreen();
					CinemaService.getInstance().getKioskControl().saveFilm();
				}
				else {
					int count = 1;
					for(Ticket t: tickets){
						CinemaService.getInstance().getKioskControl().creatTicket(t);
						CinemaService.getInstance().getKioskControl().writeData(t, ticketType);
						count++;
					}
					s.setSeat(seatIndex);
					CinemaService.getInstance().getKioskControl().saveTicket();
					CinemaService.getInstance().getKioskControl().saveScreen();
					CinemaService.getInstance().getKioskControl().saveFilm();
				}
				 JOptionPane.showMessageDialog(null, "successful!");
				dispose();
				new BriefInfFrame();
				return;
			}
		});
		btnPay.setBounds(526, 394, 167, 27);
		contentPane.add(btnPay);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	
	
	public double TotalPrice(ArrayList<Ticket>t){
		double total = 0.0;
		for(Ticket ti: t){
			total += ti.getDiscount()*ti.getPrice();
		}
		return total;
	}
	
	public static void main(String argsp[]){
		CinemaService.getInstance().getKioskControl().setFilm(CinemaService.getInstance().getKioskControl().readFilm());
		CinemaService.getInstance().getKioskControl().setScreen(CinemaService.getInstance().getKioskControl().readScreen());
		CinemaService.getInstance().getKioskControl().setTicket(CinemaService.getInstance().getKioskControl().readTicket());
		String[] seat = {"A1", "A2"};
		int[] index= {0,1};
		new PayConfirm(CinemaService.getInstance().getKioskControl().getFilm().get(0),CinemaService.getInstance().getKioskControl().getFilm().get(0).getScreen().get(0),2,"Child",seat,index);
	}
}
