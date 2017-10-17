package mailer;

public class Gestionnaire {
	
	String type;
	
		public Gestionnaire(String S){
			this.type = S;
		}
		
		public String toString(){
			return " type = "+type; 
		}
}
