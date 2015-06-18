package sed.algorithm.chapter2.section1;


import edu.princeton.cs.introcs.StdRandom;

public class DoubleAsKey implements Comparable<DoubleAsKey>{
	public double key;
	public String value1;
	public String value2;
	public String value3;
	public String value4;
	public String value5;
	public String value6;
	public String value7;
	public String value8;
	public String value9;
	public String value10;
	
	public DoubleAsKey() {
		this.key = StdRandom.uniform();
		this.value1= String.valueOf(StdRandom.uniform());
		this.value2= String.valueOf(StdRandom.uniform());
		this.value3= String.valueOf(StdRandom.uniform());
		this.value4= String.valueOf(StdRandom.uniform());
		this.value5= String.valueOf(StdRandom.uniform());
		this.value6= String.valueOf(StdRandom.uniform());
		this.value7= String.valueOf(StdRandom.uniform());
		this.value8= String.valueOf(StdRandom.uniform());
		this.value9= String.valueOf(StdRandom.uniform());
		this.value10= String.valueOf(StdRandom.uniform());
	}
	
	@Override
	public int compareTo(DoubleAsKey o){
		if (this.key < o.key) {
			return -1;
		}else if (this.key > o.key){
			return 1;
		}else{
			return 0;
		}		
	}
}
