package sed.algorithm.chapter1.section4;

import edu.princeton.cs.introcs.StdOut;

public class DoubleBinarySearch {
	public static int doubleBinarySearch(int a[], int key ){
		int index=-1;
		int lo =0;
		int hi = a.length-1;
		while (lo <= hi) {
			int mid = lo +(hi -lo) / 2;
			if (a[mid] > a[mid-1]) {
				index=rank_up(a, key, lo, mid);
				if (index >= 0) {
					return index;
				}
				lo=mid+1;
			}else {
				index=rank_down(a, key, mid-1, hi);
				if (index >= 0) {
					return index;
				}
				hi = mid-2;
			}
			
		}
		
		return -1;
	}
	
	public static int rank_up(int a[] , int key, int lo, int hi){
		while (lo <= hi) {
			int mid = lo + (hi-lo)/2;
			
			if (a[mid] < key) {
				lo = mid+1;
			}else if(a[mid]> key) {
				hi = mid -1;
			}else {
				return mid;
			}
		}
		
		return -1;
	}
	
	public static int rank_down(int a[], int key, int lo , int hi){
		
		while (lo <= hi) {
			int mid = lo + (hi-lo)/2;
			
			if (a[mid] > key) {
				lo = mid+1;
			}else if(a[mid] < key) {
				hi = mid -1;
			}else {
				return mid;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,6,7,6,4,3,2,1};
		
		StdOut.println(doubleBinarySearch(a, 4));
	}
}
