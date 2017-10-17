package dicofonctionnel;


abstract class AbstractDictionary implements IDictionary{
	
	protected Object[] key; //valeur est dans un tableau 
	protected Object[] value;
	protected int nb_case = 0;
	
	public int getNbCase(){
		return nb_case;
	}
	public AbstractDictionary(){
		Object[] key, value;
		key = new Object[4];
		value = new Object[4];
		this.key = key;
		this.value = value;
	}
	
	public boolean isEmpty(){
		return nb_case !=0;
	}
	
	public boolean containsKey(Object key){
				return this.indexof(key)!= -1;
			
	}
	
	public Object get(Object key){
		int i = this.indexof(key);
		if(i== -1) return null;
		else return value[i];
	}
	
	protected abstract int indexof(Object key); //renvois l'index ou est stocké la clef
	protected abstract int newindexof(Object key); //renvois la valeur de stockage à la fin
	
	public IDictionary put(Object key, Object value){
		int i = this.indexof(key);
		if(i != -1) {
			this.value[i] = value;
		}
		else{
			i = this.newindexof(key);
			this.value[i] = value;
			this.key[i] = key;
		}
		return this;
	}
		

}
