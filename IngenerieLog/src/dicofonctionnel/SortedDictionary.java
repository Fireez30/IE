package dicofonctionnel;

public class SortedDictionary extends AbstractDictionary {
	//protected Comparable<Object>[] key;
	public SortedDictionary(){
		super();
		/*Object[] value;
		Comparable<Object>[] key;
		key = new Comparable[4];
		value = new Object[4];
		this.key = key;
		this.value = value;*/
	}
	
	

	@Override
	protected int indexof(Object key) {
		int millieu;
		int fin = this.key.length;
		int debut = 0;
		int retour = -1;
		boolean trouve = false;
		int comparaison;
		if(this.nb_case != 0) {
			Comparable<Object>[] compkey = new Comparable[this.nb_case];
			
			for(int i = 0; i < this.nb_case;i++) {
				compkey[i] = (Comparable<Object>) this.key[i];
			}
			while(trouve == false && debut < fin) {
				millieu = (debut+fin)/2;
				comparaison = compkey[millieu].compareTo(key);
				if( comparaison == 0) {
					trouve = true;
					retour = millieu;
					
				}else {
					if(comparaison < 0) {
						debut = millieu +1;
					}else {
						fin = millieu -1;
					}
					
				}
			}
		}
		return retour;
		
		/*for(int i = 0; i < this.key.length;i++){
			if(this.key[i] == key)return i;
		}
		return -1;*/
	}

	@Override
	protected int newindexof(Object key) {
		
		int indice_insert = -1;
		int i;
		Comparable<Object>[] compkey = new Comparable[this.nb_case];
		
		
		/////////Comparaison des valeurs pour insertion////////////
		for(i = 0; i < this.nb_case;i++) {
			compkey[i] = (Comparable<Object>) this.key[i];
			if(compkey[i].compareTo(key) > 0 && indice_insert == -1) {
				indice_insert = i;
			}
		}
		if(indice_insert == -1) {
			indice_insert= nb_case;
		}
		///////////////////////////////////////////////////////////
		this.nb_case++;
		Object[] newkey = new Object[this.nb_case];
		Object[] newValue = new Object[this.nb_case];
		
		for(i= 0; i<this.nb_case;i++){
			if(i < indice_insert) {
				newkey[i] = this.key[i];
				newValue[i] = this.value[i];
			}else if (i > indice_insert) {
				newkey[i] = this.key[i-1];
				newValue[i] = this.value[i-1];
			}else if (i == indice_insert) {
				newkey[i] = null;
				newValue[i] = null;
			}
		}
		
		
		this.value = newValue;
		this.key = newkey;
		
		return indice_insert;
	}
	
	

}
