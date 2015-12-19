package processing;

import io.Pair;
import tree.Node;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by He on 2015/12/18.
 */
public class Semantics {
	public static void main(String[] args) throws IOException {
		Node n = new Node("program");
		List<Pair<String, String>> stack_info = new ArrayList<>();
		List<String> input_info = new ArrayList<>();
		List<String> output_info = new ArrayList<>();

		Lexer lexer = new Lexer("test.txt");
		List<Node> treeNode = Syntax.scan(n, stack_info, input_info, output_info, lexer);
		for (Node node : treeNode)
			Syntax.DrawTree(node);
		transiton(treeNode);
	}

	public static void transiton(List<Node> treeNode) {
		String stmt;
		for (Node node : treeNode) {
			List<Node> tmpnode = node.getChilds();
			stmt = node.getName();
			switch (stmt) {
				case ("assgstmt"):
					transiton(tmpnode);
					node.getChilds().get(0).setVal(node.getChilds().get(2).getVal());
					break;
				case ("arithexpr"):
					transiton(tmpnode);
					node.setVal(node.getChilds().get(0).getVal() + node.getChilds().get(1).getVal());
					break;
				case ("multexpr"):
					transiton(tmpnode);
					node.setVal(node.getChilds().get(0).getVal() + node.getChilds().get(1).getVal());
					break;
				case ("simpleexpr"):
					if (node.getChilds().size() != 1) {
						transiton(tmpnode);
						node.setVal(node.getChilds().get(1).getVal());
					} else
						node.setVal(node.getChilds().get(0).getVal());
					break;
				case ("multexprprime"):
					if (node.getChilds().size() != 1) {
						transiton(tmpnode);
						node.setVal(node.getChilds().get(0).getVal() + node.getChilds().get(1).getVal() + node.getChilds().get(2).getVal());
					}
					break;
				case ("arithexprprime"):
					if (node.getChilds().size() != 1) {
						transiton(tmpnode);
						node.setVal(node.getChilds().get(0).getVal() + node.getChilds().get(1).getVal() + node.getChilds().get(2).getVal());
					}
					break;
			}
		}
	}
}

