
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrameMain extends JFrame{
	public FrameMain(){
		CinemaService.getInstance().getKioskControl().setFilm(CinemaService.getInstance().getKioskControl().readFilm());
		CinemaService.getInstance().getKioskControl().setScreen(CinemaService.getInstance().getKioskControl().readScreen());
		CinemaService.getInstance().getKioskControl().setTicket(CinemaService.getInstance().getKioskControl().readTicket());
		
		setTitle("Welcome");
		setBounds(100, 100, 450, 320);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcome = new JLabel("Welcome!");
		welcome.setBounds(134, 92, 168, 18);
		contentPane.add(welcome);
		
		JButton adminBtn = new JButton("Admin");
		adminBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			new LoadFilm();
			dispose();
			return;
				}	
			});
		adminBtn.setBounds(134, 144, 148, 27);
		contentPane.add(adminBtn);
		
		JButton customerBtn = new JButton("Customer");
		customerBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			new BriefInfFrame();
			dispose();
			return;
				}	
			});
		customerBtn.setBounds(134, 224, 148, 27);
		contentPane.add(customerBtn);
		
		JLabel ImageLabel = new JLabel("");
		ImageLabel.setIcon(new ImageIcon("kiosk.png"));
		ImageLabel.setBounds(114, 13, 202, 74);
		contentPane.add(ImageLabel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FrameMain();
		AutoReporter a = new AutoReporter();//at the end of the day(24:00) generate a report
		a.start();
	}

}
