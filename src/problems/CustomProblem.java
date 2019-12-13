package problems;

import java.util.List;

import algorithms.IDAStar;
import algorithms.Node;
import algorithms.SearchAlgorithm;

public class CustomProblem {

	public static void main(String[] args) {
		
		/*
		 * 
		 *          a (4)
		 *         /     \
		 *        b (4)   c (6)
		 *       /     \
		 *      d (5)   e (6)
		 *     /     \
		 *    f (7)   g (5)
		 *           /     \
		 *          h (6)   i (7)
		 * 
		 */

		CustomProblemNode a = new CustomProblemNode("a", 4, false);
		CustomProblemNode b = new CustomProblemNode("b", 4, false);
		CustomProblemNode c = new CustomProblemNode("c", 6, false);
		CustomProblemNode d = new CustomProblemNode("d", 5, false);
		CustomProblemNode e = new CustomProblemNode("e", 6, false);
		CustomProblemNode f = new CustomProblemNode("f", 7, false);
		CustomProblemNode g = new CustomProblemNode("g", 5, false);
		CustomProblemNode h = new CustomProblemNode("h", 6, true);
		CustomProblemNode i = new CustomProblemNode("i", 7, false);
		
		a.addSuccessor(1, b);
		a.addSuccessor(1, c);
		b.addSuccessor(1, d);
		b.addSuccessor(1, e);
		d.addSuccessor(1, f);
		d.addSuccessor(1, g);
		g.addSuccessor(1, h);
		g.addSuccessor(1, i);
		
		SearchAlgorithm sa = new IDAStar(a);
		List<Node> path = sa.findPathToGoal();
		for(Node n : path) {
			System.out.print(n.getName() + " ");
		}
		System.out.println("");
		System.out.println("fin");
	}

}
