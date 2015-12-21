package test;

import io.Pair;
import io.Token;
import processing.Lexer;
import processing.Semantics;
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

		Lexer lexer = new Lexer("test.txt");

		List<Token> tokens = lexer.getTokenList();
		System.out.println("Token list size :\t" + tokens.size());
		tokens.forEach(System.out::println);
		System.out.println();

		Syntax syntax = new Syntax(n, lexer);
		List<Pair<String, String>> stackInfo = syntax.getStackInfo();
		List<String> inputInfo = syntax.getInputInfo();
		List<String> outputInfo = syntax.getOutputInfo();
		List<String> syntaxErrorInfo = syntax.getErrorInfo();
		List<Node> treeNode = syntax.getTreeNode();

		for (Node node : treeNode)
			Syntax.DrawTree(node);

		Semantics semantics;

		if (syntaxErrorInfo.size() == 0) {
			for (int i = 0; i < stackInfo.size(); i++) {
				System.out.print(stackInfo.get(i) + "\t\t\t\t\t\t\t\t");
				System.out.print(inputInfo.get(i) + "\t\t\t\t\t\t\t\t");
				System.out.println(outputInfo.get(i));
			}
			System.out.println();

			semantics = new Semantics(treeNode, tokens);
			List<String> threeAddressInfo = semantics.getThreeAddressInfo();
			List<String> semanticsErrorInfo = semantics.getErrorInfo();

			if (semanticsErrorInfo.size() == 0) {
				threeAddressInfo.forEach(System.out::print);
				System.out.println("\n");
				tokens.forEach(System.out::println);
			} else
				semanticsErrorInfo.forEach(System.out::print);
		} else
			syntaxErrorInfo.forEach(System.out::println);


	}
}
