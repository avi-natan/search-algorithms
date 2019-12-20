package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the algorithm pseudo code as described in https://en.wikipedia.org/wiki/Iterative_deepening_A*
 * 
 * @author Avi
 *
 */
public class IDAStar {

	private IDAStarNode root;
	
	public IDAStar (IDAStarNode root) {
		this.root = root;
	}
	
	public List<IDAStarNode> findPathToGoal() {
		return ida_star(this.root);
	}
	
	
	private List<IDAStarNode> ida_star(IDAStarNode root) {
		double threshold = root.getHeuristic();
		List<IDAStarNode> path = new ArrayList<IDAStarNode>();
		path.add(root);
		
		// ** For debug **
		List<IDAStarNode> visited = new ArrayList<IDAStarNode>();
		visited.add(root);
		// ** For debug **
		
		while(true) {
			double t = search(path, 0, threshold, visited);
			
			// ** For debug **
			System.out.print("Visited for threshold " + threshold + ": ");
			for(IDAStarNode n : visited) {
				System.out.print(n.getName() + ",");
			}
			System.out.println("");
			while(!visited.isEmpty()) {
				visited.remove(0);
			}
			visited.add(root);
			// ** For debug **
			
			if(t == -1) {
				return path;
			} else {
				threshold = t;
			}
		}
	}
	
	private double search(List<IDAStarNode> path, double g, double threshold, List<IDAStarNode> visited) {
		IDAStarNode node = path.get(path.size() - 1);
		double f = g + node.getHeuristic();
		if(f > threshold) return f;
		
		// ** For debug **
		if(!visited.contains(node)) visited.add(node);
		// ** For debug **
		
		if(node.isGoal()) {
			System.out.println("found!");
			return -1;
		}
		double min = Double.MAX_VALUE;
		for(IDAStarSuccessor succ : node.getSuccessors()) {
			if(!path.contains(succ.getNode())) {
				path.add(succ.getNode());
				double t = search(path, g + succ.getCost(), threshold, visited);
				if(t == -1) return -1;
				if(t < min) min = t;
				path.remove(path.size() - 1);
			}
		}
		return min;
	}

}
