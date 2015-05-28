package sed.algorithm.chapter1.section4;

public class LinearArrayLocalMinimum {
	public static int  getLocalMinimum(int[] array){
		if (array.length == 0) {
			return -1;
		}
		
		if (array.length == 1) {
			return 0;
		}
		
		if (array[0] < array[1]) {
			return array[0];
		}
		
		if (array[array.length-1] < array[array.length-2]) {
			return array[array.length-1];
		}
		
		int left = 1;
		int right = array.length-2;
		
		while (left < right) {
			int mid = (left + right)/2;
			
			if (array[mid] > array[mid-1]) {
				right = mid -1;
			}else if(array[mid] > array[mid + 1]) {
				left = mid+1;
			}else {
				return mid;
			}
			
		}
		
		return left;
	}
	
	
	public static void main(String[] args) {
		int[] array = {2,1,3,4,3,2,4};
		
		System.out.println(getLocalMinimum(array));
	}
}
