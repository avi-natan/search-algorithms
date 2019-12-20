package problems;

import java.util.List;

import algorithms.ILBFS;
import algorithms.ILBFSNode;

public class CustomILBFSProblem {

	public static void main(String[] args) {
		
		/*
		 * 
		 *               ______a(2)_______
		 *              /                 \
		 *            b(3)               c(3)
		 *          /      \           /      \
		 *        d(5)     e(8)      f(6)     g(5)
		 *      /      \             /       /    \                      
		 *    h(8)     i(7)        j(9)    k(8)   l(6)
		 *              ^
		 *              |
		 *             goal
		 *             
		 *             
		 * 
		 */
		
		// creating nodes
		CustomILBFSProblemNode a = new CustomILBFSProblemNode("a", false, 2, Double.MAX_VALUE);
		CustomILBFSProblemNode b = new CustomILBFSProblemNode("b", false, 3, Double.MAX_VALUE);
		CustomILBFSProblemNode c = new CustomILBFSProblemNode("c", false, 3, Double.MAX_VALUE);
		CustomILBFSProblemNode d = new CustomILBFSProblemNode("d", false, 5, Double.MAX_VALUE);
		CustomILBFSProblemNode e = new CustomILBFSProblemNode("e", false, 8, Double.MAX_VALUE);
		CustomILBFSProblemNode f = new CustomILBFSProblemNode("f", false, 6, Double.MAX_VALUE);
		CustomILBFSProblemNode g = new CustomILBFSProblemNode("g", false, 5, Double.MAX_VALUE);
		CustomILBFSProblemNode h = new CustomILBFSProblemNode("h", false, 8, Double.MAX_VALUE);
		CustomILBFSProblemNode i = new CustomILBFSProblemNode("i", true, 7, Double.MAX_VALUE);
		CustomILBFSProblemNode j = new CustomILBFSProblemNode("j", false, 9, Double.MAX_VALUE);
		CustomILBFSProblemNode k = new CustomILBFSProblemNode("k", false, 8, Double.MAX_VALUE);
		CustomILBFSProblemNode l = new CustomILBFSProblemNode("l", false, 6, Double.MAX_VALUE);
		
		// adding children
		a.addChild(b);
		a.addChild(c);
		b.addChild(d);
		b.addChild(e);
		c.addChild(f);
		c.addChild(g);
		d.addChild(h);
		d.addChild(i);
		f.addChild(j);
		g.addChild(k);
		g.addChild(l);
		
		// adding parents
		a.setParent(null);
		b.setParent(a);
		c.setParent(a);
		d.setParent(b);
		e.setParent(b);
		f.setParent(c);
		g.setParent(c);
		h.setParent(d);
		i.setParent(d);
		j.setParent(f);
		k.setParent(g);
		l.setParent(g);
		
		ILBFS ilbfs = new ILBFS(a);
		List<ILBFSNode> path = ilbfs.findPathToGoal();
		for(ILBFSNode n : path) {
			System.out.print(n.getName() + ",");
		}
		System.out.println("");
		System.out.println("fin");
		

	}

}
