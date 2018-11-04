
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
public class DetailInfFrame extends JFrame{
	private String title;
	public DetailInfFrame(String title){
		DetailInfFrame temp_frame = this;
		this.title = title;
		setTitle("detail infomation");
		setSize(2000,2000);
		setResizable(true);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Film f = null;
		for(Film temp:CinemaService.getInstance().getKioskControl().getFilm()){
			if(temp.getTitle().equals(title))
				f = temp;
		}
		setBounds(100, 100, 800, 800);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setIcon(new ImageIcon(f.getTitle()+".png"));
		imageLabel.setBounds(48, 98, 118, 176);
		contentPane.add(imageLabel);
		
		JLabel movieName = new JLabel("Movie name");
		movieName.setHorizontalAlignment(SwingConstants.CENTER);
		movieName.setBounds(218, 57, 111, 18);
		contentPane.add(movieName);
		
		JLabel titleLable = new JLabel(f.getTitle());
		titleLable.setHorizontalAlignment(SwingConstants.CENTER);
		titleLable.setBounds(375, 57, 201, 18);
		contentPane.add(titleLable);
		
		JLabel director = new JLabel("Director");
		director.setHorizontalAlignment(SwingConstants.CENTER);
		director.setBounds(218, 98, 111, 18);
		contentPane.add(director);
		
		JLabel directorLabel = new JLabel(f.getDirector());
		directorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		directorLabel.setBounds(375, 98, 201, 18);
		contentPane.add(directorLabel);
		
		JLabel actor = new JLabel("Actor");
		actor.setHorizontalAlignment(SwingConstants.CENTER);
		actor.setBounds(218, 139, 111, 18);
		contentPane.add(actor);
		
		JLabel actorLabel = new JLabel(f.getActor());
		actorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		actorLabel.setBounds(375, 139, 201, 18);
		contentPane.add(actorLabel);
		
		JLabel language = new JLabel("Language");
		language.setHorizontalAlignment(SwingConstants.CENTER);
		language.setBounds(218, 180, 111, 18);
		contentPane.add(language);
		
		JLabel languageLabel = new JLabel(f.getLanguage());
		languageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		languageLabel.setBounds(375, 180, 201, 18);
		contentPane.add(languageLabel);
		
		JLabel length = new JLabel("Length");
		length.setHorizontalAlignment(SwingConstants.CENTER);
		length.setBounds(218, 221, 111, 18);
		contentPane.add(length);
		
		JLabel lengthLabel = new JLabel(f.getLength()+"min");
		lengthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lengthLabel.setBounds(375, 221, 201, 18);
		contentPane.add(lengthLabel);
		int i = 0;
		for(Screen s: f.getScreen()){
			i++;
			switch(s.getScreenType()){
				case 1:
					JLabel jb1 = new JLabel("screen 1 " + formatter.format(s.getDate().getTime()));
					jb1.setBounds(300, 221+i*40, 200, 20);
					contentPane.add(jb1);
					break;
				case 2:
					JLabel jb2 = new JLabel("screen 2 " + formatter.format(s.getDate().getTime()));
					jb2.setBounds(300, 221+i*40, 200, 20);
					contentPane.add(jb2);
					break;
				case 3:
					JLabel jb3 = new JLabel("screen 3 " + formatter.format(s.getDate().getTime()));
					jb3.setBounds(300, 221+i*40, 200, 20);
					contentPane.add(jb3);
					break;
				default:
					break;
			}
		}
		i++;
		JButton jb = new JButton("back");
		jb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				temp_frame.dispose();
				new BriefInfFrame();
				return;
			}
		});
		jb.setBounds(300, 221+i*40, 200, 20);
		contentPane.add(jb);
		//this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	public static void main(String argsp[]){
		CinemaService.getInstance().getKioskControl().setFilm(CinemaService.getInstance().getKioskControl().readFilm());
		CinemaService.getInstance().getKioskControl().setScreen(CinemaService.getInstance().getKioskControl().readScreen());
		new DetailInfFrame("KONG SKULL ISLAND");
	}
	
}
