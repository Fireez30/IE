package dico;

public abstract class AbstractDictionary implements IDictionary {

	protected Object[] keys;
	protected Object[] values;
	protected int size;
	
	public Object get(Object key){
		int i=this.IndexOf(key);//index auquel est stocké la key et du coup la value
		if (i==-1){return null;}
		else return values[i];
	
}
	public boolean containsKey(Object key){
		return (this.IndexOf(key)!= -1);
	}
	
	public IDictionary put(Object key,Object value){
		int i= this.IndexOf(key); 
		if (i!=-1) {values[i]=value;}
		else{
			int index=this.IndexAt(key);//renvoi l'index ou pourra etre rentré la key et la value, et alloue l'espace si nécessaire
			keys[index]=key;
			values[index]=value;
			size++;
			}
		return this;
		}
	
	public boolean isEmpty(){
		return this.empty();
	}
	public int getSize(){
		return size;
	}
	
	protected abstract int IndexOf(Object key);
	protected abstract int IndexAt(Object key);
	protected abstract boolean empty();
}