package sed.algorithm.chapter1.section5;

import java.awt.Point;
import java.util.Iterator;

import edu.princeton.cs.algs4.Bag;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;



public class RandomGrid {
	
	public  static Bag<Connection> generate(int max){
		Bag<Connection> conBag = new Bag<>();
		
		for (int i = 0; i <90; i++) {
		
			int p = StdRandom.uniform(1,max);
			int q = StdRandom.uniform(1,max);
			Connection connection = new Connection(p, q);
			conBag.add(connection);
			
		}
		
		return conBag;
		
	}
	
	
	private static class Connection{
		int p;
		int q;
		public Connection(int p, int q){
		this.p = p; 
		this.q = q;
		}
	}
	public static void drawline(int p , int q, int N){
		int xp;
		int yp;
		if (p % N == 0) {
			 xp = p/N;
			 yp = N ;
		}else {
			 xp = p/N +1;
			 yp = p%N ;
		}		
		int xq ;
		int yq;
		if (q % N == 0) {
			xq = q/N;
			yq = N ;
		}else {
			xq = q/N+1;
			yq = q%N ;
		}
		
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.point(xp, yp);
		StdDraw.point(xq, yq);
		StdOut.println(p+" : "+ q);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(xp, yp, xq, yq);
	}
	
	
	public static void main(String[] args) {
		int N = 10;
		
		Bag<Connection> conBag = generate(N*N);
		
		Iterator<Connection> iterator = conBag.iterator();
		
		StdDraw.setXscale(0, N+1);
		StdDraw.setYscale(0, N+1);
		StdDraw.setPenRadius(0.005);
		
		for (int i = 0; i <= N+1; i++) {
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(0, i);
		}
		for (int i = 0; i <= N+1; i++) {
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.point(i,0);
		}
		PathCompressWeightedQuickUnionUF uf = new PathCompressWeightedQuickUnionUF((N+2)*(N+2));
		
		while(iterator.hasNext()){
			Connection connection = iterator.next();
			
			if (!uf.connected(connection.p, connection.q)) {
				uf.union(connection.p, connection.q);
				int p = connection.p;
				int q = connection.q;
				
				if (p-1>0 && uf.connected(p-1, q)  && (p-1) % N !=0) {
					drawline(p,p-1,N);
					
				}else if (uf.connected(p+1, q) && p % N != 0) {
					drawline(p,p+1,N);
					
				}else if(p-N >0 && uf.connected(p-N, q) && p>N){
					drawline(p,p-N,N);
					
				}else if(uf.connected(p+N,q)&& p+N<=N*N){
					drawline(p,p+N,N);
				}
								
			}
			
		}
		
		for (int i = 1; i <= N*N; i++) {
			if (i-1>0 && uf.connected(i , i-1) && (i-1) % N !=0) {
				drawline(i,i-1,N);
			}
			if (uf.connected(i, i+1) && i % N != 0) {
				drawline(i,i+1,N);
			}
			if(i-N >0 && uf.connected(i, i-N) && i>N){
				drawline(i,i-N,N);
			}
			if(uf.connected(i, i+N)&& i+N<=N*N){
				drawline(i,i+N,N);
			}
		}
		
	}
	
}
