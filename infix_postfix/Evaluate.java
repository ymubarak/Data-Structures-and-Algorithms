package infix_postfix;

import java.util.Scanner;
import java.util.Stack;

public class Evaluate {

	static Stack<String> s = new Stack<String>();
	static Scanner input = new Scanner(System.in);
	static String[] precedence = { "+-", "/*" };

	public static void main(String[] args) {

		System.out.print("Enter infix : ");
		System.out.println();
		String postfix = input.nextLine();
		double output = 0;

		if (!postfix.isEmpty())
			output = evalute(postfix);

		System.out.println("PostFix is  : " + output);

	}

	private static double evalute(String postfix) {
		int len = postfix.length();
		int start = 0;
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(postfix.charAt(i))) {
				start++;
				if (i + 1 >= len || !Character.isDigit(postfix.charAt(i + 1))) {
					s.push(postfix.substring(i + 1 - start, i + 1));
					start = 0;
				}
			} else {
				if (postfix.charAt(i) != ' ')
					s.push(calculate(Double.parseDouble(s.pop()), Double.parseDouble(s.pop()),
							postfix.charAt(i)));
			}
		}

		return Double.parseDouble(s.pop());
	}

	private static String calculate(double y, double x, char op) {

		switch (op) {
		case '+':
			return x + y + "";
		case '-':
			return x - y + "";
		case '*':
			return x * y + "";
		case '/':
			return x / y + "";
		default:
			return 0 + "";
		}

	}
}
