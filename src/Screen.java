
import java.io.Serializable;
import java.util.GregorianCalendar;

public class Screen implements Serializable{
private boolean[] seat;//default false means no reservation
private GregorianCalendar time;
private  int type;
private static final long serialVersionUID = 2355007526823567942L;
public Screen(GregorianCalendar d){
	time = d;
}

public void setSeat(int[] i){
	for(int e: i){
		seat[e]=true;
	}
}

public boolean getSeat(int i){
	return seat[i];
}

public void creatSeat(int number){
	seat = new boolean[number];
	for(int i = 0; i<seat.length; i++){
		seat[i] = false;
	}
}

public boolean[] getList(){
	return seat;
}

public GregorianCalendar getDate(){
	return time;
}

public void setDate(GregorianCalendar d){
	time = d;
}

public void setType(int i){
	type = i;
}

public int getScreenType(){
	return type;
}

}
