

import java.io.Serializable;

public class Ticket implements Serializable{
private double discount = 1.0;
private double price = 16.0;
private int ID;//32-bit system or above for 8-digit ID
private Film film;
private Screen screen;
private String seat;
private String type;
private static final long serialVersionUID = 2355007526823567943L;

public Ticket(int id,Film f, Screen s, String st){
	film = f;
	screen = s;
	ID = id;
	seat = st;
}



public double getDiscount(){
	return discount;
}

public void setDiscount(double d){
	discount = d;
}

public double getPrice(){
	return price;
}

public void setPrice(double p){
	price = p;
}

public int getID(){
	return ID;
}

public void setID(int id){
	ID = id;
}

public Film getFilm(){
	return film;
}

public Screen getScreen(){
	return screen;
}

public void setFilm(Film f){
	film = f;
}

public void setScreen(Screen s){
	screen = s;
}

public void setSeat(String s){
	seat = s;
}

public String getSeat(){
	return seat;
}

public String getType(){
	return type;
}

public void setType(String t)
{
	type = t;
}

}
