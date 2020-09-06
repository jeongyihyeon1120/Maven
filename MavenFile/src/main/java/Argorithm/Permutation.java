package Argorithm;

public class Permutation {
	
	public static void main(String[] args) {
		int n = 365;
		int r = 30;
		long result1 = 1;
		long result2 = 0;
		
		for (int i = 0; i < r; i++) {
			result1 = Math.abs((n - i) * result1);
		}
		result2 = (long) Math.pow(n, r);
		System.out.println(result2);
		System.out.println(result1);
		System.out.println((float)(result2-result1)/result2*100);
	}
		

}
