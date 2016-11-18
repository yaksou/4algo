package inlämningsuppgift4;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

	private String buttonText[] = { "7", "8", "9", "^", "C", "4", "5", "6", "(", ")", "1", "2", "3", "*", "/", "0", "+",
			"-", "=" };
	private JButton[] buttons = new JButton[19];
	private JTextField expressionField;
	private String exp = "";

	public Calculator() {
		super("Calculator");
		setSize(320, 240);
		expressionField = new JTextField();
		JPanel panel = new JPanel(new GridLayout(4, 5));
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(buttonText[i]);
			buttons[i].addActionListener(this);
			panel.add(buttons[i]);
		}
		panel.add(new Label());
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(expressionField, BorderLayout.NORTH);
		contentPane.add(panel, BorderLayout.CENTER);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "C") {
			exp = "";
			expressionField.setText(exp);
		} else if (e.getActionCommand() == "=") {
			expressionField.setText("" + evaluate(infixToPostfix(exp)));
		}

		else {
			exp = exp + e.getActionCommand();
			expressionField.setText(exp);
		}

	}

	public static void main(String[] arg) {

		Calculator calc = new Calculator();
		calc.setVisible(true);

	}

	public static LinkedList<String> infixToPostfix(String exp) {
		Stack<String> stack = new Stack<String>();
		Scanner input = new Scanner(System.in);

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

		return list;
	}

	public static double evaluate(LinkedList<String> exp) {
		Stack<Double> a = new Stack<Double>();
		while (!exp.isEmpty()) {
			String s = exp.pop();

			if (s.equals("+"))
				a.push(a.pop() + a.pop());
			else if (s.equals("*"))
				a.push(a.pop() * a.pop());
			else if (s.equals("/")) {
				Double first = a.pop();
				Double second = a.pop();
				a.push(first / second);
			} else if (s.equals("^")) {
				Double first = a.pop();
				Double second = a.pop();
				a.push(Math.pow(first, second));

			} else if (s.equals("-")) {
				Double first = a.pop();
				Double second = a.pop();
				a.push(second - first);

			} else {
				a.push(Double.valueOf(s));
			}
		}
		return a.pop();

	}

}