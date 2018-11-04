
import java.text.*;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class ShowTimeandTicket extends JFrame{
	private JComboBox number_box;
	private Film f= null;
	private String title;
	public ShowTimeandTicket(String title){
		ShowTimeandTicket temp_frame= this;
		this.title = title;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
		String ticketType[] = {"Child", "Adult", "Senior", "Student"};
		
		for(Film t:CinemaService.getInstance().getKioskControl().getFilm()){
			if(t.getTitle().equals(title)){
				f = t;
			}
		}
		setBounds(100, 100, 560, 420);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ShowTimeLabel = new JLabel("Show Time");
		ShowTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ShowTimeLabel.setBounds(91, 62, 119, 50);
		contentPane.add(ShowTimeLabel);
		
		JLabel TicketType = new JLabel("Ticket Type");
		TicketType.setHorizontalAlignment(SwingConstants.CENTER);
		TicketType.setBounds(321, 62, 88, 50);
		contentPane.add(TicketType);
		
		JLabel TicketNumber = new JLabel("Number");
		TicketNumber.setHorizontalAlignment(SwingConstants.CENTER);
		TicketNumber.setBounds(446, 62, 53, 50);
		contentPane.add(TicketNumber);
		
		JComboBox showTime_box = new JComboBox<String>();
		for(Screen t:f.getScreen()){
			showTime_box.addItem("screen"+t.getScreenType()+" " + formatter.format(t.getDate().getTime()));
		}
		showTime_box.addItemListener(new ItemListener() {

	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                if (e.getStateChange() == ItemEvent.SELECTED) {
	                    // refresh the content in number_box
	                	int index=showTime_box.getSelectedIndex();
	                	int count = 0;
	            		for(boolean s:f.getScreen().get(index).getList()){
	            			if(s == false){
	            				count++;
	            			}
	            		}
	            		number_box.removeAllItems();
	            		for(int i = 1;i<count+1;i++){
	            			number_box.addItem(i);
	            		}
	                }
	            }
	        });
		
		showTime_box.setBounds(91, 142, 200, 24);
		contentPane.add(showTime_box);
		
		JComboBox ticketType_box = new JComboBox<String>(ticketType);
		ticketType_box.setBounds(320, 142, 81, 24);
		contentPane.add(ticketType_box);
		
		number_box = new JComboBox<String>();
		int index = showTime_box.getSelectedIndex();
		int count = 0;
		for(boolean s:f.getScreen().get(index).getList()){
			if(s == false){
				count++;
			}
		}
		for(int i = 1;i<count+1;i++){
			number_box.addItem(i);
		}
		number_box.setBounds(436, 142, 76, 24);
		contentPane.add(number_box);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new BriefInfFrame();
				dispose();
				return;
			}
		});
		
		btnBack.setBounds(14, 333, 113, 27);
		contentPane.add(btnBack);
		
		JButton btnConfirm= new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = showTime_box.getSelectedIndex();
				int type = f.getScreen().get(index).getScreenType();
				if(f.getScreen().get(index).getDate().getTime().before((new GregorianCalendar().getTime()))){
					JOptionPane.showMessageDialog(null, "Sorry, time limit for this one has exceeded, please choose another one or exit. ");
					return;
				}
				else{
				switch(type){
				case 1:
					new ScreenFrame1(type,f.getScreen().get(index).getDate(),(int)number_box.getSelectedItem(),(String)ticketType_box.getSelectedItem(),f);
					break;
				case 2:
					new ScreenFrame2(type,f.getScreen().get(index).getDate(),(int)number_box.getSelectedItem(),(String)ticketType_box.getSelectedItem(),f);
					break;
				case 3:
					new ScreenFrame3(type,f.getScreen().get(index).getDate(),(int)number_box.getSelectedItem(),(String)ticketType_box.getSelectedItem(),f);
					break;
				default:
					break;
				}
				dispose();
				return;
				}
			}
		});
		btnConfirm.setBounds(399, 333, 113, 27);
		contentPane.add(btnConfirm);
		//this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	}
}
