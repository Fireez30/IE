package dicowithtest;

public class FDictionary extends AbstractDictionary {

		private int taillefdico;
	
	public FDictionary(){
		keys = new Object[4];
		values = new Object[4];
		size=4;
		taillefdico=4;
	}
	
	
	@Override
	protected int IndexOf(Object key) {
		int hash=Math.abs(keys.hashCode())%taillefdico;
		if(keys[hash]==key){return hash;}
		for (int i=hash+1;i<keys.length;i++){if (keys[i]==key) return i;}
		for (int i=0;i<hash-1;i++){if (keys[i]==key) return i;}
		return -1;
	}

	@Override
	protected int IndexAt(Object key) {
		int hash=Math.abs(keys.hashCode())%taillefdico;
		if (keys[hash]==null) {grow();return hash;}
		for (int i=hash;i<keys.length;i++){if (keys[i]==null) {grow();return i;}}
		for (int i=0;i<hash-1;i++){if (keys[i]==key) {grow();return i;}}
		return -1;
	}

	@Override
	protected boolean empty() {
		boolean test=true;
		for(int i=0;i<keys.length;i++){
			if (keys[i]!=null){test=false;break;}
		}
		
		return test;
	}
	
	private boolean mustGrow(){	
if((float) (this.getSize())/(float)(this.taillefdico) > 0.74) return true;
else return false;
	}
	
	protected void grow(){
		while (mustGrow()){
		taillefdico++;}
		Object[] keys2 = new Object[taillefdico];
		Object[] values2 = new Object[taillefdico];
		for (int i=0;i<keys.length;i++){
				keys2[i]=keys[i];
			values2[i]=values[i];
		}

		keys=keys2;
		values=values2;	

	}
	

}
