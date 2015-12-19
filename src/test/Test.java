package test;

import io.Pair;
import io.Token;
import processing.Lexer;
import processing.Syntax;
import tree.Node;

import java.io.IOException;
import java.util.*;

/**
 * Created by Roy Gao on 11/26/2015.
 */
public class Test {

	// I'm another comment!
	// Hello, Kevin, this is a comment.

	public static void main(String[] args) throws IOException {

		Node n = new Node("Program");
		List<Pair<String, String>> stack_info = new ArrayList<>();
		List<String> input_info = new ArrayList<>();
		List<String> output_info = new ArrayList<>();

		Lexer lexer = new Lexer("test.txt");
		Syntax.scan(n, stack_info, input_info, output_info, lexer);

//		for (int i = 0; i < stack_info.size(); i++) {
//			System.out.print(stack_info.get(i) + "\t\t\t\t\t\t\t\t");
//			System.out.print(input_info.get(i) + "\t\t\t\t\t\t\t\t");
//			System.out.println(output_info.get(i));
//		}
//		Syntax.DrawTree(n);
//		n.printAllNode(n);

		List<Token> tokens = lexer.getTokenList();
		System.out.println("Token list size :\t" + tokens.size());
		for (Token token : tokens)
			System.out.println(token);

	}
}
