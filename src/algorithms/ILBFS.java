package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Implementation of the ILBFS algorithm a described in A.Felner "Position Paper: The Collapse Macro in Best-first Search Algorithms 
 * and an Iterative Variant of RBFS", Eighth Annual Symposium on Combinatorial Search, 2015
 * 
 * @author Avi
 *
 */
public class ILBFS {
	
	private ILBFSNode root;
	
	public ILBFS(ILBFSNode root) {
		this.root = root;
	}

	public List<ILBFSNode> findPathToGoal() {
		return ilbfs(this.root);
	}
	
	private List<ILBFSNode> ilbfs(ILBFSNode root) {
		// the path to return
		List<ILBFSNode> path = new ArrayList<ILBFSNode>();
		
		// set root.F to root.f
		root.setF(root.getf());
		
		// Insert R into OPEN and TREE
		PriorityQueue<ILBFSNode> open = new PriorityQueue<ILBFSNode>(new Comparator<ILBFSNode>() {
			@Override
			public int compare(ILBFSNode first, ILBFSNode second) {
				// comparing to the F. prio to the greater F
				if(first.getF() < second.getF()) {
					return -1;
				} else if (first.getF() > second.getF()) {
					return 1;
				} else {
					// F is same, comparing if the node is collapsed or not. prio to the one that is not collapsed
					if(first.getF() == first.getf() && second.getF() > second.getf()) {
						return -1;
					} else if(first.getF() > first.getf() && second.getF() == second.getf()) {
						return 1;
					} else {
						// both nodes are collapsed or both are not collapsed, compare lexicographically. lexical prio
						if (first.getName().compareTo(second.getName()) < 0) {
							return -1;
						} else if(first.getName().compareTo(second.getName()) > 0) {
							return 1;
						} else {
							return 0;
						}
					}
				}
			}
		});
		List<ILBFSNode> tree = new ArrayList<ILBFSNode>();
		open.add(root);
		tree.add(root);
		
		// oldbest=NULL
		ILBFSNode oldbest = null;
		
		// while OPEN not empty do
		while(!open.isEmpty()) {
			// best=extract min(OPEN)
			ILBFSNode best = open.remove();
			
			// if the best is a goal state, construct the path and return it
			// if goal(best) then
			if(best.isGoal()) {
				// exit
				ILBFSNode temp = best;
				while(temp != null) {
					path.add(0, temp);
					temp = temp.getParent();
				}
				break;
			}
			
			// collapse macro
			// while (oldbest != best.parent) do
			while(oldbest != null && !oldbest.equals(best.getParent())) {
				// oldbest.val <- min(values of oldbest children)
				List<ILBFSNode> oldbestChildren = oldbest.getChildren();
				// do this only if this node has children (i.e. not a dead end)
				if(!oldbestChildren.isEmpty()) {
					Double minFVal = Double.MAX_VALUE;
					for(ILBFSNode child : oldbestChildren) {
						minFVal = Math.min(minFVal, child.getF());
					}
					oldbest.setF(minFVal);
					// Insert oldbest to OPEN
					open.add(oldbest);
					// Delete all children of oldbest from OPEN and TREE
					for(ILBFSNode child : oldbestChildren) {
						open.remove(child);
						tree.remove(child);
					}
				} else {
					oldbest.setF(Double.MAX_VALUE);
					oldbest.setf(Double.MAX_VALUE);
				}
				
				// oldbest <- oldbest.parent
				oldbest = oldbest.getParent();
			}
			
			// restore macro
			// foreach child C of best do
			for(ILBFSNode c : best.getChildren()) {
				// F(C) <- f(C)
				c.setF(c.getf());
				
				// if F(best) > f(best) and F(best) > F(C) then
				if(best.getF() > best.getf() && best.getF() > c.getF()) {
					// F(C) <- F(best)
					c.setF(best.getF());
				}
				
				// Insert C to OPEN and TREE
				open.add(c);
				tree.add(c);
			}
			
			// oldbest <- best
			oldbest = best;
		}
		
		// return the path found
		return path;
	}

}
