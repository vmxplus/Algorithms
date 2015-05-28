package sed.algorithm.chapter1.section4;


public class Timer {
	private final long timeStart;
	public Timer() {
		timeStart = System.currentTimeMillis();
	}
	
	public  double elapsedTime(){
		long now = System.currentTimeMillis();
		
		return (now-timeStart)/1000.0;
	}
}
