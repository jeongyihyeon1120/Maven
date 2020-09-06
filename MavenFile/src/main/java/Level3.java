import java.util.ArrayList;
import java.util.Arrays;

public class Level3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 8, 13, 17, 20)); // 배열 되있다고 가정
		ArrayList<Integer> result = new ArrayList<Integer>(0);
		int c;
		int index = 0;
		for (int i = 0; i < a.size() - 1; i++) {
			result.add(a.get(i + 1) - a.get(i));
		}
		c = result.get(0);
		System.out.println(result);
		for (int i = 1; i < result.size(); i++) {
			if (c > result.get(i)) {
				c = result.get(i);
				index++;
			}
		}
		
		System.out.print(a.get(index) + ", " + a.get(index + 1));
	}
}
