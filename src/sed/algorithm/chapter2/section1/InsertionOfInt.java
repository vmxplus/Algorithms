package sed.algorithm.chapter2.section1;

public class InsertionOfInt {
	
	public static void sort(int[] a){
		int N =a.length;
		for (int i = 0; i < N; i++) {
			for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
				exch(a, j, j-1);
			}
		}
	}
	
	private static boolean less(int v, int w){
		if (v < w) {
			return true;
		}else {
			return false;
		}
	}
	
	private static void exch(int a[], int i , int j){
		int temp= a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
