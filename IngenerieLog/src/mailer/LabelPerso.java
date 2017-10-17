package mailer;

public class LabelPerso extends Label {
	Gestionnaire g;
	
	public LabelPerso(String S){
		g= new Gestionnaire(S);
	}

	public String toString(){
		return "Label par defaut de type "+g.toString();
	}
}
