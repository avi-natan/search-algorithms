package problems;

import java.util.List;

import algorithms.IDAStar;
import algorithms.IDAStarNode;

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
        //create initial node (root node)
		CustomProblemIDAStarNode a = new CustomProblemIDAStarNode("a", 4, false);
		// generate the graph with the following parameters
        // h_increase - how much the heuristic increases between father to child (we random between 0 to that value)
        // b_low - minimum number of children for each node
        // b_high - maximum number of children for each node
        // current height - it is recursive, so it is the current height (level in the graph)
        // height - the maximum depth of the graph.
        // the goal is every vertex in the last level (we can change it later)

		generate_graph(a, 2, 4,6,0,6);

		IDAStar sa = new IDAStar(a);
		List<IDAStarNode> path = sa.findPathToGoal();
		for(IDAStarNode n : path) {
			System.out.print(n.getName() + ",");
		}
		System.out.println("");
		System.out.println("fin");
	}

	private static void generate_graph(CustomProblemIDAStarNode root, int h_increase, int b_low, int b_high, int current_height,int height) {
		if(current_height<height)
		{
			boolean isGoal=false;
			if(current_height==(height-1))
				isGoal=true;
			int b_factor = (int )((Math.random() * (b_high - b_low)) + b_low);
			for(int child=0; child<b_factor; child++)
			{
				int h_factor = (int )((Math.random() * h_increase));
				CustomProblemIDAStarNode tmp_child = new CustomProblemIDAStarNode(root.getName() + String.valueOf(child), root.getHeuristic() + h_factor, isGoal);
				root.addSuccessor(1, tmp_child);
				generate_graph(tmp_child, h_increase,b_low,b_high, current_height+1,height);
			}
		}
	}
}
