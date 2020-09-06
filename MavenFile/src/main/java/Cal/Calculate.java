package Cal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculate {

	public static void main(String[] args) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		String interger = "";
		int r = 0;
		int oper = 0;

		while (true) {
			Scanner s = new Scanner(System.in);
			System.out.print("숫자 한개, 연산자, d, e");
			String firstInt = s.next();
			if (firstInt.equals("+")) {
				oper = 1;
				result.add(Integer.parseInt(interger));
				interger = "";
			} else if (firstInt.equals("-")) {
				oper = 2;
				result.add(Integer.parseInt(interger));
				interger = "";
			} else if (firstInt.equals("=")) {
				if (oper == 1) {
					result.add(Integer.parseInt(interger));
					r = result.get(0) + result.get(1);
					System.out.println(r);
					for (int i = 0; i < result.size(); i++) {
						result.remove(i);
						i--;
					}
					interger = Integer.toString(r);
					r = 0;
				} else if (oper == 2) {
					result.add(Integer.parseInt(interger));
					r = result.get(0) - result.get(1);
					System.out.println(r);
					for (int i = 0; i < result.size(); i++) {
						result.remove(i);
						i--;
					}
					interger = Integer.toString(r);
					r = 0;
				}
			} else if (firstInt.equals("d")) {
				interger = interger.substring(0, interger.length() - 1);
			} else if (firstInt.equals("e")) {
				System.out.println("종료");
				break;
			} else {
				interger = interger + firstInt;
			}
		}

	}

}
