
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class LoadFilm extends JFrame{
		public LoadFilm(){
			CinemaService.getInstance().getKioskControl().setFilm(CinemaService.getInstance().getKioskControl().readFilm());
			CinemaService.getInstance().getKioskControl().setScreen(CinemaService.getInstance().getKioskControl().readScreen());
			CinemaService.getInstance().getKioskControl().setTicket(CinemaService.getInstance().getKioskControl().readTicket());
			LoadFilm temp_frame = this;
			this.setLayout(new BorderLayout());
			Integer day[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
			String month[] = {"Jan. ","Feb. ","Mar. ","Apr. ","May  ","Jun  ","July ","Aug  ","Sept.","Oct. ","Nov. ","Dec.  "};
			Integer year[] = new Integer[1];
			year[0] = 2017;
			Integer minute[] = new Integer[60];
			for(int i=0;i<60;i++){
				minute[i] = i;
			}
			Integer hour[] = new Integer[24];
			for(int i=0;i<24;i++){
				hour[i]=i;
			}
			String screenType[] = {"screen1", "screen2", "screen3"};
			JPanel basicInfoPane1 = new JPanel(new BorderLayout());
			JLabel basicInfoL1 = new JLabel("This is for loading a film");
			JLabel basicInfoL2 = new JLabel("Please enter the following information:");
			basicInfoPane1.add(basicInfoL1,BorderLayout.NORTH);
			basicInfoPane1.add(basicInfoL2,BorderLayout.SOUTH);
			
			JPanel inputPane1 = new JPanel(new GridLayout(5,2));
			
			JLabel title_label = new JLabel("title");
			JTextField title_text = new JTextField();
			inputPane1.add(title_label);
			inputPane1.add(title_text);
			
			JLabel director_label = new JLabel("director");
			JTextField director_text = new JTextField();
			inputPane1.add(director_label);
			inputPane1.add(director_text);
			
			JLabel actor_label = new JLabel("actor");
			JTextField actor_text = new JTextField();
			inputPane1.add(actor_label);
			inputPane1.add(actor_text);
			
			JLabel language_label = new JLabel("language");
			JTextField language_text = new JTextField();
			inputPane1.add(language_label);
			inputPane1.add(language_text);
			
			JLabel length_label = new JLabel("length");
			JTextField length_text = new JTextField();
			inputPane1.add(length_label);
			inputPane1.add(length_text);
			
			
			JPanel inputPane2 = new JPanel(new GridLayout(7,2));
			JLabel show_day = new JLabel("The day");
			JComboBox day_box = new JComboBox(day);
			inputPane2.add(show_day);
			inputPane2.add(day_box);
			
			JLabel show_month = new JLabel("The month");
			JComboBox month_box = new JComboBox(month);
			inputPane2.add(show_month);
			inputPane2.add(month_box);
			
			JLabel show_year = new JLabel("The year");
			JComboBox year_box = new JComboBox(year);
			inputPane2.add(show_year);
			inputPane2.add(year_box);
			
			JLabel show_minute = new JLabel("The minute ");
			JComboBox minute_box = new JComboBox(minute);
			inputPane2.add(show_minute);
			inputPane2.add(minute_box);
			
			JLabel show_hour = new JLabel("The hour");
			JComboBox hour_box = new JComboBox(hour);
			inputPane2.add(show_hour);
			inputPane2.add(hour_box);
			
			JLabel screen = new JLabel("The screen type");
			JComboBox screen_box = new JComboBox(screenType);
			inputPane2.add(screen);
			inputPane2.add(screen_box);
			
			JButton addMore = new JButton("Save and add another");
			addMore.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String title = title_text.getText();
					String director = director_text.getText();
					String actor = actor_text.getText();
					String language = language_text.getText();
					int length = Integer.parseInt(length_text.getText());
					int day = (int) day_box.getSelectedItem();
					int month = month_box.getSelectedIndex()+1;
					int year = 2017-year_box.getSelectedIndex();
					int minute = (int) minute_box.getSelectedItem();
					int hour = (int) hour_box.getSelectedItem();
					int type = screen_box.getSelectedIndex()+1;
					if(title.equals("") || director.equals("") || actor.equals("")||language.equals("")){
						JOptionPane.showMessageDialog(null, "Please enter all the quired information!");
						return;
					}
					else{
						boolean flag = false;
	
					    switch(type){
					    case 1:
					    	Screen1 screen1;
					    	for(Film temp:CinemaService.getInstance().getKioskControl().getFilm()){
					    		if (temp.getTitle().equals(title)){
					    		flag = true;
					    		screen1 = new Screen1(new GregorianCalendar(year,month,day,hour,minute));
					    		temp.addScreen(screen1);
					    		CinemaService.getInstance().getKioskControl().addScreen(screen1);
					    		break;
					    		}
					    	}
					    	if(flag){
					    	break;
					    	}
					    	else{
					    		Film f = new Film(title, director, actor, language, length);
					    		screen1 = new Screen1(new GregorianCalendar(year,month,day,hour,minute));
					    		f.addScreen(screen1);
					    		CinemaService.getInstance().getKioskControl().addFilm(f);
					    		CinemaService.getInstance().getKioskControl().addScreen(screen1);
					    	}
					    	break;
					    case 2:
					    	Screen2 screen2;
					    	for(Film temp:CinemaService.getInstance().getKioskControl().getFilm()){
					    		if (temp.getTitle().equals(title)){
					    		flag = true;
					    		screen2 = new Screen2(new GregorianCalendar(year,month,day,hour,minute));
					    		temp.addScreen(screen2);
					    		CinemaService.getInstance().getKioskControl().addScreen(screen2);
					    		break;
					    		}
					    	}
					    	if(flag){
					    		break;
					    	}
					    	else{
					    		Film f = new Film(title, director, actor, language, length);
					    		screen2 = new Screen2(new GregorianCalendar(year,month,day,hour,minute));
					    		f.addScreen(screen2);
					    		CinemaService.getInstance().getKioskControl().addFilm(f);
					    		CinemaService.getInstance().getKioskControl().addScreen(screen2);
					    	}
					    	break;
					    case 3:
					    	Screen3 screen3;
					    	for(Film temp:CinemaService.getInstance().getKioskControl().getFilm()){
					    		if (temp.getTitle().equals(title)){
					    		flag = true;
					    		screen3 = new Screen3(new GregorianCalendar(year,month,day,hour,minute));
					    		temp.addScreen(screen3);
					    		CinemaService.getInstance().getKioskControl().addScreen(screen3);
					    		break;
					    		}
					    	}
					    	if(flag){
					    		break;
					    	}
					    	else{
					    		Film f = new Film(title, director, actor, language, length);
					    		screen3 = new Screen3(new GregorianCalendar(year,month,day,hour,minute));
					    		f.addScreen(screen3);
					    		CinemaService.getInstance().getKioskControl().addFilm(f);
					    		CinemaService.getInstance().getKioskControl().addScreen(screen3);
					    	}
					    	break;
					    default:
					    	break;
					    }
						//temp_frame.dispose();
					    JOptionPane.showMessageDialog(null, "Load successful!");
					    //CinemaService.getInstance().getKioskControl().saveFilm();
					    //CinemaService.getInstance().getKioskControl().saveScreen();
						return;
					}
				}
				
			});
			
			JButton save = new JButton("Save and quit");
			save.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String title = title_text.getText();
					String director = director_text.getText();
					String actor = actor_text.getText();
					String language = language_text.getText();
					int length = Integer.parseInt(length_text.getText());
					int day = (int) day_box.getSelectedItem();
					int month = month_box.getSelectedIndex();
					int year = 2017-year_box.getSelectedIndex();
					int minute = (int) minute_box.getSelectedItem();
					int hour = (int) hour_box.getSelectedItem();
					int type = screen_box.getSelectedIndex()+1;
					if(title.equals("") || director.equals("") || actor.equals("")||language.equals("")){
						JOptionPane.showMessageDialog(null, "Please enter all the quired information!");
						return;
					}
					else{
						boolean flag = false;
	
					    switch(type){
					    case 1:
					    	Screen1 screen1;
					    	for(Film temp:CinemaService.getInstance().getKioskControl().getFilm()){
					    		if (temp.getTitle().equals(title)){
					    		flag = true;
					    		screen1 = new Screen1(new GregorianCalendar(year,month,day,hour,minute));
					    		temp.addScreen(screen1);
					    		CinemaService.getInstance().getKioskControl().addScreen(screen1);
					    		break;
					    		}
					    	}
					    	if(flag){
					    		break;
					    	}
					    	else{
					    		Film f = new Film(title, director, actor, language, length);
					    		screen1 = new Screen1(new GregorianCalendar(year,month,day,hour,minute));
					    		f.addScreen(screen1);
					    		CinemaService.getInstance().getKioskControl().addFilm(f);
					    		CinemaService.getInstance().getKioskControl().addScreen(screen1);
					    	}
					    	break;
					    case 2:
					    	Screen2 screen2;
					    	for(Film temp:CinemaService.getInstance().getKioskControl().getFilm()){
					    		if (temp.getTitle().equals(title)){
					    		flag = true;
					    		screen2 = new Screen2(new GregorianCalendar(year,month,day,hour,minute));
					    		temp.addScreen(screen2);
					    		CinemaService.getInstance().getKioskControl().addScreen(screen2);
					    		break;
					    		}
					    	}
					    	if(flag){
					    		break;
					    	}
					    	else{
					    		Film f = new Film(title, director, actor, language, length);
					    		screen2 = new Screen2(new GregorianCalendar(year,month,day,hour,minute));
					    		f.addScreen(screen2);
					    		CinemaService.getInstance().getKioskControl().addFilm(f);
					    		CinemaService.getInstance().getKioskControl().addScreen(screen2);
					    	}
					    	break;
					    case 3:
					    	Screen3 screen3;
					    	for(Film temp:CinemaService.getInstance().getKioskControl().getFilm()){
					    		if (temp.getTitle().equals(title)){
					    		flag = true;
					    		screen3 = new Screen3(new GregorianCalendar(year,month,day,hour,minute));
					    		temp.addScreen(screen3);
					    		CinemaService.getInstance().getKioskControl().addScreen(screen3);
					    		break;
					    		}
					    	}
					    	if(flag){
					    		break;
					    	}
					    	else{
					    		Film f = new Film(title, director, actor, language, length);
					    		screen3 = new Screen3(new GregorianCalendar(year,month,day,hour,minute));
					    		f.addScreen(screen3);
					    		CinemaService.getInstance().getKioskControl().addFilm(f);
					    		CinemaService.getInstance().getKioskControl().addScreen(screen3);
					    	}
					    	break;
					    default:
					    	break;
					    }
						temp_frame.dispose();
						CinemaService.getInstance().getKioskControl().saveFilm();
					    CinemaService.getInstance().getKioskControl().saveScreen();
					    new BriefInfFrame();
						return;
					}
				}
				
			});
			
			inputPane2.add(addMore);
			inputPane2.add(save);
			this.add(basicInfoPane1,BorderLayout.NORTH);
			this.add(inputPane1,BorderLayout.CENTER);
			this.add(inputPane2,BorderLayout.SOUTH);
			this.pack();
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.setLocationRelativeTo(null);
		}
	}

