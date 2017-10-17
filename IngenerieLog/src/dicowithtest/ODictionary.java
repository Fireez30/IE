package dicowithtest;

public class ODictionary extends AbstractDictionary{

	public ODictionary()
	{
		keys = new Object[0];
		values = new Object[0];
		size=0;
	}
	

	
	@Override
	protected int IndexOf(Object key) {
		for (int i=0;i<keys.length;i++){
			if (keys[i]==key) {return i;}
		}
		return -1;
	}

	@Override
	protected int IndexAt(Object key) {
		Object[] keys2 = new Object[keys.length+1];
		Object[] values2 = new Object[values.length+1];
		for (int i=0;i<keys.length;i++){
			keys2[i]=keys[i];
			values2[i]=values[i];
		}
		keys2[keys.length]=null;
		values2[keys.length]=null;
		
		keys=keys2;
		values=values2;
		
		return keys.length-1;
	}
	/* correction int IndexAt(Object key){
		Object[] tmpkeys = new Object[keys.lenght+1];
		Object[] tmpvalues = new Object[values.lenght+1];
		
		for(int i=0;i<keys.lenght;i++){
		tmpkeys[i]=keys[i];
		tmpvalues[i]=values[i];
		}
		keys=tmpkeys;
		values=tmpvalues;
		return getSize();
	 */

	@Override
	protected boolean empty() {
		return (size==0);
	}
	

}
