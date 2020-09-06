package Cal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String interger = "";
		int r = 0;
		int oper = 0;
		while (true) {
			Scanner s = new Scanner(System.in);
			System.out.print("숫자 한개, 연산자, d, e");
			String firstInt = s.next();
			if (firstInt.equals("+")) {
				oper = 1;
				r = r + Integer.parseInt(interger);
				interger = "";
			} else if (firstInt.equals("-")) {
				oper = 2;
				r = r - Integer.parseInt(interger);
				interger = "";
			} else if (firstInt.equals("=")) {
				if (oper == 1) {
					r = r + Integer.parseInt(interger);
					System.out.println(r);
				} else if (oper == 2) {
					r = r - Integer.parseInt(interger);
					System.out.println(r);
				}
				interger = "0";
			} else if (firstInt.equals("d")) {
				interger = interger.substring(0, interger.length() - 1);
			} else {
				interger = interger + firstInt;
			}
		}

	}

}
