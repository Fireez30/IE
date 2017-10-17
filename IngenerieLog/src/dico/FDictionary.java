package dico;

public class FDictionary extends AbstractDictionary {

	
	public FDictionary(){
		keys = new Object[0];
		values = new Object[0];
		size=0;
	}
	
	public FDictionary(int taille){
		int tailler=(int) (taille+(0.25*taille));
		
		keys= new Object[tailler];
		values = new Object[tailler];
		size=taille;
	}
	
	@Override
	protected int IndexOf(Object key) {
		int hash=Math.abs(keys.hashCode())%keys.length;
		if(keys[hash]==key){return hash;}
		for (int i=hash+1;i<keys.length;i++){if (keys[i]==key) return i;}
		for (int i=0;i<hash-1;i++){if (keys[i]==key) return i;}
		return -1;
	}

	@Override
	protected int IndexAt(Object key) {
		int hash=Math.abs(keys.hashCode())%keys.length;
		if (keys[hash]==null) {grow();return hash;}
		for (int i=hash+1;i<keys.length;i++){if (keys[i]==null) {grow();return i;}}
		for (int i=0;i<hash-1;i++){if (keys[i]==key) {grow();return i;}}
		return -1;
	}

	@Override
	protected boolean empty() {
		return (size==0);
	}
	
	private boolean mustGrow(){	
		double x=keys.length;
		double y=size*1.25;
		return (y<x);
	}
	
	protected void grow(){
		if (mustGrow()){
		int tmp=(int) ((size+1)*1.25);
		Object[] keys2 = new Object[tmp];
		Object[] values2 = new Object[tmp];
		for (int i=0;i<keys.length;i++){
				keys2[i]=keys[i];
			values2[i]=values[i];
		}

		keys=keys2;
		values=values2;	
		}
	}
	

}
