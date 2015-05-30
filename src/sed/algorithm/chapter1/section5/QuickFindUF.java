package sed.algorithm.chapter1.section5;



import edu.princeton.cs.algs4.Count;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class QuickFindUF {
	private int[] uf ;
	private int count;
	private int total=0;
	
	public QuickFindUF(int max) {
		this.uf = new int[max];
		this.count=max;
		for (int i = 0; i < uf.length; i++) {
			this.uf[i] = i;
		}
	}
	
	public int total(){
		return this.total;
	}
	public int count(){
		return this.count;
	}
	public int find(int p){
		total +=1;
		return this.uf[p];
	}
	
	public boolean connect(int p , int q){
		return find(p)==find(q);
	}
	
	public void union(int p, int q){
		int pRep = find(p);
		int qRep = find(q);
		
		if (pRep != qRep) {
			for (int i = 0; i < uf.length; i++) {
				total += 1;
				if (this.uf[i]==pRep) {
					total +=1;
					this.uf[i]=qRep;
				}
			}
			count--;
		}
	}
	
	public static void main(String[] args) {
//		int N = StdIn.readInt();
		
		In in = new In("resources/mediumUF.txt");
		int N = in.readInt();
		QuickFindUF uf = new QuickFindUF(N);
		int prevTotal = 0;
		int countPairs = 0;
		System.out.println(N);
		
		StdDraw.setXscale(0, 1200);
		StdDraw.setYscale(0, 1300);
		StdDraw.setPenRadius(.005);
		
		while (!in.isEmpty()) {
			countPairs++;
			int p = in.readInt();	
			int q = in.readInt();
			
			StdOut.println(p+ " : " + q);
			
			if (uf.connect(p, q)) {
				continue;
			}
			uf.union(p, q);
			
			int current = uf.total()-prevTotal;
			prevTotal=uf.total;
			double average = prevTotal*1.0/countPairs;
			
			StdDraw.setPenColor(StdDraw.DARK_GRAY);
			StdDraw.point(countPairs, current);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(countPairs, average);
			
		}
		
		StdOut.println("count : " + uf.count());
	}
}
