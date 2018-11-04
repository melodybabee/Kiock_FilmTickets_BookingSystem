
import java.io.Serializable;
import java.util.ArrayList;

public class Film implements Serializable{
private String title;
private String director;
private String actor;
private String language;
private int length;
private ArrayList<Screen> screen = new ArrayList<Screen>();
private static final long serialVersionUID = 2355007526823567941L;


public Film(String t, String d, String a, String l, int length){
	title =t;
	director= d;
	actor= a;
	language= l;
	this.length = length;
}

public String getTitle(){
	return title;
}

public void setTitle(String t){
	title = t;
}

public String getDirector(){
	return director;
}

public void setDirector(String d){
	director = d;
}


public String getActor(){
	return actor;
}

public void setActor(String a){
	actor= a;
}



public String getLanguage(){
	return language;
}

public int getLength(){
	return length;
}

public ArrayList<Screen> getScreen(){
	return screen;
}

public void addScreen(Screen s){
	screen.add(s);
}


}
