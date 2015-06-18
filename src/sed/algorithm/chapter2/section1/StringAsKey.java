package sed.algorithm.chapter2.section1;

import edu.princeton.cs.introcs.StdRandom;

public class StringAsKey implements Comparable<StringAsKey>{
	public String key="abcdefghjk";
	public double value=1.111;
	public StringAsKey() {
		this.value = StdRandom.uniform();
		this.key = String.valueOf(this.value);
	}
	
	@Override
	public int compareTo(StringAsKey o){
		return this.key.compareTo(o.key);
	}
}
