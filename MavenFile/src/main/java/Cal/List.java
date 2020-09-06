package Cal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(4,0,3,1,9,7));
		
		
		for (int i = 0; i < a.size() -1 ; i++) {
			int b = a.size(); 
			int j = i;
			if (a.get(i) > a.get(i + 1)) {
				while (j < b) {
					if (a.get(j) > a.get(i + 1)) {
						Collections.swap(a, j, i + 1);
						continue;
					}
					j--;
				}
				Collections.swap(a, i, i + 1); 
			}
			if (a.get(j) < a.get(i + 1)) {
				if(a.get(i + 1) < a.get(j)) {
				Collections.swap(a, j, i + 1);
				}
			}
		}
		System.out.println(a);
	}
}
