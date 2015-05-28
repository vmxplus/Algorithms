package sed.algorithm.chapter1.section4;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class CostOfAutoBoxing {
	
	public static  double timeTrialGenereic() throws Exception{
		FixedCapacityStack<Integer> stackGeneric = new FixedCapacityStack<>();
		Timer timer = new Timer();
		while (!stackGeneric.isFull()) {			
			stackGeneric.push(StdRandom.uniform(99999));
		}
		while(! stackGeneric.isEmpty()){
			stackGeneric.pop();
		}
		return timer.elapsedTime();
	}
	

	public static  double timeTrialInts() throws Exception{
		FixedCapacityStackOfInts stackInts = new FixedCapacityStackOfInts();
		Timer timer = new Timer();
		while (!stackInts.isFull()) {			
			stackInts.push(StdRandom.uniform(1000));
		}
		while(! stackInts.isEmpty()){
			stackInts.pop();
		}
		return timer.elapsedTime();
	}
	
	public static void main(String[] args)throws Exception  {
		StdOut.println(timeTrialGenereic());
		StdOut.println(timeTrialInts());
		
		
	}
}
