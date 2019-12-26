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
	
	// ******   debug ******
	int iteration = 0;
	// ******   debug ******
	
	public IDAStar (IDAStarNode root) {
		this.root = root;
		this.iteration = 0;
	}
	
	public List<IDAStarNode> findPathToGoal() {
		return ida_star(this.root);
	}
	
	
	private List<IDAStarNode> ida_star(IDAStarNode root) {
		double threshold = root.getHeuristic();
		List<IDAStarNode> path = new ArrayList<IDAStarNode>();
		path.add(root);
		
		while(true) {
			double t = search(path, 0, threshold);
			if(t == -1) {
				return path;
			} else {
				threshold = t;
			}
		}
	}
	
	private double search(List<IDAStarNode> path, double g, double threshold) {
		IDAStarNode node = path.get(path.size() - 1);
		
		// ******   debug ******
		
		System.out.println("Threshold: " + threshold);
		System.out.println("g: " + g);
		System.out.println("Iteration: " + this.iteration++);
		node.drawState();
		
		// ******   debug ******
		
		
		double f = g + node.getHeuristic();
		if(f > threshold) return f;
		
		if(node.isGoal()) {
			System.out.println("found!");
			return -1;
		}
		double min = Double.MAX_VALUE;
		for(IDAStarSuccessor succ : node.getSuccessors()) {
			if(!path.contains(succ.getNode())) {
				path.add(succ.getNode());
				double t = search(path, g + succ.getCost(), threshold);
				if(t == -1) return -1;
				if(t < min) min = t;
				path.remove(path.size() - 1);
			}
		}
		return min;
	}

}
