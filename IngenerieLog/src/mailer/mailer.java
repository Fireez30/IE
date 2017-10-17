package mailer;

import java.util.ArrayList;

public class mailer {
		private BoiteReception r;
		private ArrayList<Compactage> c;
		private Label l;
		
	public mailer(Compactage c,BoiteReception r,Label l){
		this.c= new ArrayList<Compactage>();
		if (!this.c.contains(c)) {this.c.add(c);}
		this.r = r;
		this.l= l;
	}
	
	public void ajoutCompactage(Compactage c1){
		if (c.contains(c1) || c.size()==2){System.out.println("Impossible d'ajouter ce compactage! ");} else {c.add(c1);}
	}
	public String toString(){
		return "Mailer : Compactage "+c.toString()+" , "+r.toString()+" , "+l.toString();
	}

	public static void main(String[] args) {
		BoiteReception r = new BoiteReceptionSimple();
		Compactage c1 = new Compactageauto();
		Compactage c2 = new Compactagemanuel();
		Compactage c3 = new Compactagemanuel();
		Label l = new Labelpardefaut(type.Travail);
		mailer m = new mailer(c1,r,l);
		m.ajoutCompactage(c2);
		m.ajoutCompactage(c3);
		
		System.out.println(m.toString());
	}

}
