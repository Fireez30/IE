package mailer;

public class Labelpardefaut extends Label {
	type t;
	
	public Labelpardefaut(type t){
		this.t=t;
	}

	public String toString(){
		return "Label par defaut de type "+t;
	}
}
