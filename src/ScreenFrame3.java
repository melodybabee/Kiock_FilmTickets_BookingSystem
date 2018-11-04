
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
public class ScreenFrame3 extends JFrame implements ActionListener{
	private JPanel contentPane;
	private ArrayList<JButton> selectedbutton=new ArrayList<>();
	private JButton [][]buttongroup=new JButton[5][];
	private Screen screen;
	private JButton btnBack;
	private JButton btnChoose;
	private JButton btnReset;
	private Film f;
	private String ticketType;
	int ticketNum;
	public ScreenFrame3(int type, GregorianCalendar time, int ticketNum, String ticketType, Film f){
		ScreenFrame3 temp_frame= this;
		this.ticketNum = ticketNum;
		this.f = f;
		this.ticketType = ticketType;
		setTitle("Screen3");
		setBounds(100, 100, 924, 600);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(87, 13, 722, 393);
		contentPane.add(panel);
		panel.setLayout(null);
		buttongroup[0]=new JButton[6];
		buttongroup[1]=new JButton[6];
		buttongroup[2]=new JButton[6];
		buttongroup[3]=new JButton[6];
		buttongroup[4]=new JButton[8];
		for(int j = 5; j>=4; j--){
			for(int i= 3; i>= 0; i--){
				buttongroup[i][j] = new JButton("" +(j+1));
				buttongroup[i][j].setBounds(50+20+(5-j)*78, 93+(3-i)*60, 50, 27);
				buttongroup[i][j].addActionListener(this);
				panel.add(buttongroup[i][j]);
			}
		}
		
		for(int j = 3; j>=2; j--){
			for(int i= 3; i>= 0; i--){
				buttongroup[i][j] = new JButton("" +(j+1));
				buttongroup[i][j].setBounds(70+(5-j)*78+86, 93+(3-i)*60, 50, 27);
				buttongroup[i][j].addActionListener(this);
				panel.add(buttongroup[i][j]);
			}
		}
		
		for(int j = 1; j>=0; j--){
			for(int i= 3; i>= 0; i--){
				buttongroup[i][j] = new JButton("" +(j+1));
				buttongroup[i][j].setBounds(78+(5-j)*78+164, 93+(3-i)*60, 50, 27);
				buttongroup[i][j].addActionListener(this);
				panel.add(buttongroup[i][j]);
			}
		}
		
		for(int i = 7; i>=0; i--){
			buttongroup[4][i] = new JButton(""+ (i+1));
			buttongroup[4][i].setBounds(78+(7-i)*78, 55, 50, 27);
			buttongroup[4][i].addActionListener(this);
			panel.add(buttongroup[4][i]);
		}
		
		JButton scr = new JButton("Screen");
		scr.setBounds(68, 335, 557, 27);
		panel.add(scr);
		
		JLabel lblNewLabel = new JLabel("A");
		lblNewLabel.setBounds(14, 287, 75, 29);
		contentPane.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel("A");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(815, 287, 75, 29);
		contentPane.add(label);
		
		JLabel lblB = new JLabel("B");
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setBounds(14, 231, 75, 29);
		contentPane.add(lblB);
		
		JLabel label_1 = new JLabel("B");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(815, 231, 75, 29);
		contentPane.add(label_1);
		
		JLabel lblC = new JLabel("C");
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setBounds(14, 171, 75, 29);
		contentPane.add(lblC);
		
		JLabel label_2 = new JLabel("C");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(815, 171, 75, 29);
		contentPane.add(label_2);
		
		JLabel lblD = new JLabel("D");
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setBounds(14, 110, 75, 29);
		contentPane.add(lblD);
		
		JLabel label_3 = new JLabel("D");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(815, 110, 75, 29);
		contentPane.add(label_3);
		
		JLabel lblE = new JLabel("E");
		lblE.setHorizontalAlignment(SwingConstants.CENTER);
		lblE.setBounds(17, 55, 72, 18);
		contentPane.add(lblE);
		
		JLabel label_4 = new JLabel("E");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(815, 55, 72, 18);
		contentPane.add(label_4);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(this);
		btnBack.setBounds(14, 427, 113, 27);
		contentPane.add(btnBack);
		
		btnChoose = new JButton("Confirm");
		btnChoose.addActionListener(this);

		btnChoose.setBounds(777, 427, 113, 27);
		contentPane.add(btnChoose);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(this);
		btnReset.setBounds(385, 427, 113, 27);
		contentPane.add(btnReset);
		
		for(Screen s:CinemaService.getInstance().getKioskControl().getScreen()){
			if(s.getScreenType()==type && s.getDate().equals(time)){
				screen = s;
			}
		}
		
		for(int i = 0;i<screen.getList().length;i++){
		if(screen.getSeat(i)&&i<=23){
			buttongroup[i/6][i%6].setEnabled(false);
		}
		else if(screen.getSeat(i)&&i>23){
			buttongroup[4][i-24].setEnabled(false);
		}
		}
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton jb=(JButton)e.getSource();
		if(jb==btnBack){
			dispose();
			new BriefInfFrame();
			return;
		}
		else if(jb==btnReset){
			for(int i=0;i<selectedbutton.size();i++){
				selectedbutton.get(i).setEnabled(true);
			}
			selectedbutton.clear();
		}
		else if(jb==btnChoose){
			if(selectedbutton.size()==ticketNum){
			int[] index = new int[selectedbutton.size()];
			String[] seats = new String[selectedbutton.size()];
			int count = 0;
			for(JButton sjb: selectedbutton){
				for (int i = 0; i < 4; i++) {
		            for (int j = 0; j < 6; j++) {	            		
		                if (buttongroup[i][j] == sjb) {
		                	index[count] = i*6+j;
		                	switch(i){
		                	case 0:
		                		seats[count]= "A"+(j+1);
		                		break;
		                	case 1:
		                		seats[count]= "B"+(j+1);
		                		break;
		                	case 2:
		                		seats[count]= "C"+(j+1);
		                		break;
		                	case 3:
		                		seats[count]= "D"+(j+1);
		                		break;
		                	default:
		                		break;
		                	}
							}
		                }
		        }
				for(int i=0;i<8;i++){
					if(buttongroup[4][i]==sjb){
						index[count] = 24+i;
						seats[count]= "E"+(i+1);
					}
				}
				count++;
			}
			new PayConfirm(f, screen, ticketNum, ticketType, seats, index );
			dispose();		
			return;
			}
			else{
				JOptionPane.showMessageDialog(null, "Wrong ticket number!the seat number is: "+ ticketNum + ", But you select "+selectedbutton.size()+" seat(s)");
				btnReset.doClick();
				return;
			}
		}
		else{
		 for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 6; j++) {	            		
	                if (buttongroup[i][j] == e.getSource()) {
	                	buttongroup[i][j].setEnabled(false);
	                	selectedbutton.add(buttongroup[i][j]);
						}
	                }
	        }
		 for (int i= 0; i<8; i++){
			 if (buttongroup[4][i] == e.getSource()) {
             	buttongroup[4][i].setEnabled(false);
             	selectedbutton.add(buttongroup[4][i]);
		 }
	     }
	     }
		return;
		}
	public static void main(String argsp[]){
		CinemaService.getInstance().getKioskControl().setFilm(CinemaService.getInstance().getKioskControl().readFilm());
		CinemaService.getInstance().getKioskControl().setScreen(CinemaService.getInstance().getKioskControl().readScreen());
		//new ScreenFrame3(3, new GregorianCalendar(2017, 5, 14, 20, 30), 4, "Child");
	}
}
