
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class BriefInfFrame extends JFrame{
	/**
	 * Create the frame.
	 * This is the frame of ChooseFilm, user is able to choose film from this frame
	 */
	public BriefInfFrame() {
		int count= 0;
		CinemaService.getInstance().getKioskControl().setFilm(CinemaService.getInstance().getKioskControl().readFilm());
		CinemaService.getInstance().getKioskControl().setScreen(CinemaService.getInstance().getKioskControl().readScreen());
		CinemaService.getInstance().getKioskControl().setTicket(CinemaService.getInstance().getKioskControl().readTicket());
		BriefInfFrame temp_frame = this;
		setTitle("Film");
		for(Film temp:CinemaService.getInstance().getKioskControl().getFilm()){
			count++;
		}
		String[] title = new String[count];
		int[] length = new int[count];
		JButton[] buybutton = new JButton[count];
		JButton[] detailbutton = new JButton[count];
		int c = 0;
		for(Film temp:CinemaService.getInstance().getKioskControl().getFilm()){
			title[c] = temp.getTitle();
			length[c]= temp.getLength();
			c++;
		}
		this.setLayout(new GridLayout(count+1,5));
		JLabel title_label = new JLabel("title");
		this.add(title_label);
		JLabel length_label = new JLabel("length");
		this.add(length_label);
		JLabel poster_label = new JLabel("poster");
		this.add(poster_label);
		JLabel detailbutton_label = new JLabel("");
		this.add(detailbutton_label);
		JLabel buybutton_label = new JLabel("");
		this.add(buybutton_label);
		for(int i =0; i<count; i++){
			JLabel title_l = new JLabel(title[i]);
			this.add(title_l);
			JLabel length_l = new JLabel(length[i]+" min");
			this.add(length_l);
			JLabel poster_l = new JLabel("");
			poster_l.setIcon(new ImageIcon(title[i]+".png"));
			this.add(poster_l);
			detailbutton[i] = new JButton("detail");
			detailbutton[i].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for(int i = 0; i<detailbutton.length; i++){
					if(detailbutton[i]==e.getSource()){
						new DetailInfFrame(title[i]);
						break;
					}
					}
					dispose();
					return;
				}
			});
			
			this.add(detailbutton[i]);
			
			buybutton[i] = new JButton("buy");
			buybutton[i].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for(int i = 0; i<buybutton.length;i++){
						if(buybutton[i]==e.getSource()){
							new ShowTimeandTicket(title[i]);
							break;
						}
					}
					dispose();
					return;
				}
			});
			
			this.add(buybutton[i]);
		}
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
}
}
