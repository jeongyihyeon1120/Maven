import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("요리 재료 갯수");
		Scanner s = new Scanner(System.in);
		int number = s.nextInt();

		System.out.print("창고 재료");
		Scanner s1 = new Scanner(System.in);
		String countain = s1.nextLine();

		System.out.print("필요 개수");
		Scanner s2 = new Scanner(System.in);
		String need = s2.nextLine();

		ArrayList<Integer> cal = new ArrayList<Integer>();

		int num1;
		int num2;

		String[] words1 = countain.split("\\s");
		String[] words2 = need.split("\\s");

		for (int i = 0; i < number; i++) {
			if (words1.length != number || words2.length != number) {
				System.out.println("입력값이 잘못 되었습니다.");
				System.exit(0);
			}
			num1 = Integer.parseInt(words1[i]);
			num2 = Integer.parseInt(words2[i]);
			cal.add(num1 / num2);
		}
		Collections.sort(cal);
		System.out.println(cal.get(0));

	}

}
