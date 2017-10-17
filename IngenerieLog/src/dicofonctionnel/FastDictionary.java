package dicofonctionnel;

public class FastDictionary extends AbstractDictionary implements IDictionary {
	
	public FastDictionary(){
		Object[] key, value;
		key = new Object[4];
		value = new Object[4];
		this.key = key;
		this.value = value;
		this.nb_case = 4;
	}
	
	protected int size(){
		int nb_elem = 0;
		for(int i = 0; i< value.length; i++){
			if(value[i] != null)
				nb_elem++;
		}
		return nb_elem;
	}
	
	protected boolean mustGrow(){
		if((float)(this.size())/(float)(this.nb_case) > 0.74) {
			return true;
		}
		else {
			return false;
		}
	}
	
	protected void grow(){
		
		while(mustGrow()){
			nb_case++;
		}
		Object[] key, value;
		key = new Object[nb_case];
		value = new Object[nb_case];
		for(int i = 0; i < this.key.length;i++){
			key[i] = this.key[i];
			value[i] = this.value[i];
		}
		this.key = key;
		this.value = value;
	}

	
	@Override
	protected int indexof(Object key) {
		int code = Math.abs(key.hashCode());
		code = code%this.nb_case;
		int i = code;
		int tampon = -1;
		do
		{
			if(this.key[i] != null) {
				if(this.key[i].equals(key)){
					tampon = i;
					i=code;
				}else{
					i = (i+1)%nb_case;
				}
			}else{
				i = (i+1)%nb_case;
			}
		}while(i != code);
		
		return tampon;
		
	}

	@Override
	protected int newindexof(Object key) {
		// TODO Auto-generated method stub
		int i,f;
		int code;
		if(mustGrow()){
			
			grow();		
			Object[] newkey = new Object[this.nb_case];
			Object[] newValue = new Object[this.nb_case];
			
			for(i= 0; i<this.nb_case;i++){
				if(this.key[i] != null) {
					code = Math.abs(this.key[i].hashCode());
					code = code%this.nb_case;
					f = code;
					do
					{
						if(newkey[f] != null) {
							f = (f+1)%nb_case;
						}else{
							newkey[f] = this.key[i];
							newValue[f] = this.value[i];
							f = code;
						}
					}while(f != code);
				}
				
				
				
			}
			this.value = newValue;
			this.key = newkey;
		}
		
		code = Math.abs(key.hashCode());
		code = code%this.nb_case;
		i = code;
		int tampon = 0;
		do
		{
			if(this.key[i] != null) {
				if(this.key[i].equals(key)){
					tampon = i;
					i=code;
				}else{
					i = (i+1)%nb_case;
				}
			}else{
				tampon = i;
				i=code;
			}
		}while(i != code);
		
		
		return tampon;
	}
	
	public static void main(String args[]) {
		int preuve = 8/3;
		//System.out.println("Bonjour");
		
		FastDictionary dico = new FastDictionary();
		dico.put("Patrick", "Sebastien");
		dico.put("Jean", "Marcel");
		dico.put("Gerard", "Baste");
		dico.put("Fallout", "New Vegas");
		dico.put("Francky", "Vincent");
		dico.put("Jack", "Torrence");
		dico.put("Borderlands", "bitch");
		dico.put("ZZ", "test");
		dico.put("Mon nom", "Personne");
		dico.put("Manuel", "Calavera");
		dico.put("Mercedes", "Coromar");
		String bidule =  (String)dico.get("ZZ");
	//System.out.println(bidule);
		
	}
	

}
