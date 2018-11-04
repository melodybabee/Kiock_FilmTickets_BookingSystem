
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;


public class CinemaService implements Serializable{
	private static CinemaService instance = new CinemaService();
	private KioskControl kiosk = new KioskControl();
	private CinemaService(){}
	private static final long serialVersionUID = 2355007526823567944L;
	public static CinemaService getInstance(){
		return instance;
	}
	public KioskControl getKioskControl() {
		return kiosk;
	}
	public void setKioskControl(KioskControl kiosk) {
		this.kiosk = kiosk;
	}
}
