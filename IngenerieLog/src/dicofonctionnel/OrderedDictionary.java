package dicofonctionnel;

public class OrderedDictionary extends AbstractDictionary implements IDictionary {

	
	public OrderedDictionary(){
		super();
	}
	
	public OrderedDictionary(int nbentry){
		super();
		Object[] key, value;
		key = new Object[nbentry];
		value = new Object[nbentry];
		this.key = key;
		this.value = value;
	}
	
	
	@Override
	protected int indexof(Object key) {
		for(int i = 0; i < this.key.length;i++){
			if(this.key[i] == key)return i;
		}
		return -1;
	}

	@Override
	protected int newindexof(Object key) {
		this.nb_case++;
		int i;
		Object[] newkey = new Object[this.nb_case+1];
		Object[] newValue = new Object[this.nb_case+1];
		
		for(i= 0; i<this.nb_case;i++){
			newkey[i] = this.key[i];
			newValue[i] = this.value[i];
		}
		this.value = newValue;
		this.key = newkey;
		
		return this.nb_case;
	}

}
