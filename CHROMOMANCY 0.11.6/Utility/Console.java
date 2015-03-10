package Utility;

public class Console {

	public int limit;
	public String[] array;
	public int size=0;
	
	public Console(int n) {
		limit=n;
		array=new String[limit];
	}
	
	public void add(String o) {
		if (size<limit) {
			array[size]=o;
			size++;
			return;
		}
		for (int i=0;i<array.length-1;i++) {
			array[i]=array[i+1];
		}
		array[array.length-1]=o;
		return;
	}

}