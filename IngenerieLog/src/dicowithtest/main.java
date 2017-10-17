package dicowithtest;

public class main {

	public static void main(String[] args) {
		ODictionary d= new ODictionary();
		d.put("test", "value1");
		System.out.println(d.get("test"));

		FDictionary f= new FDictionary();
		f.put(2,"value1");
		System.out.println(f.get(2));
	}

}
