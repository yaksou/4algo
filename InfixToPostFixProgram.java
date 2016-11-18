package inlämningsuppgift4;

import java.util.*;

public class InfixToPostFixProgram {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		Scanner input = new Scanner(System.in);
		String exp = input.next();
		LinkedList<String> list = new LinkedList<String>();
		boolean numbers = false;

		for (int i = 0; i < exp.length(); i++) {

			String s = exp.charAt(i) + "";
			if (s.equals("+") || s.equals("-")) {
				numbers = false;
				while (!stack.isEmpty()) {
					String tkn = stack.pop();
					if (tkn.equals("*") || tkn.equals("/") || tkn.equals("+") || tkn.equals("-") || tkn.equals("^"))
						list.add(tkn);
					else {
						stack.push(tkn);
						break;
					}
				}
				stack.push(s);

			} else if (s.equals("*") || s.equals("/") || s.equals("^")) {
				numbers = false;
				while (!stack.isEmpty()) {
					String tkn = stack.pop();
					if (tkn.equals("/") || tkn.equals("*") || tkn.equals("^")) {
						list.add(tkn);
					} else {
						stack.push(tkn);
						break;
					}
				}
				stack.push(s);
			}

			else if (s.equals(")")) {
				numbers = false;
				while (!stack.peek().equals("(") && !stack.isEmpty()) {

					list.add(stack.pop());
				}
				stack.pop();
			} else if (s.equals("(")) {
				numbers = false;
				stack.push(s);

			} else {
				if (numbers) {
					String last = list.getLast();
					list.removeLast();
					String combine = last + s;
					list.add(combine);
					numbers = true;
				} else {
					list.add(s);
					numbers = true;
				}
			}

		}
		while (!stack.isEmpty()) {

			list.add(stack.pop());
		}

		System.out.println(list);

	}
}
