package problems;

import java.util.List;

import algorithms.ILBFS;
import algorithms.ILBFSNode;

public class FifteenPuzzle {
	
	public static void main(String[] args) {
		
		System.out.println("problem start");
		
		testIDAStar();
		testILBFS();
		
		System.out.println("problem end");
	}

	private static void testILBFS() {
		/*
		 * 
		 * The node we are going to start with: (0 indicates blank space)
		 * 
		 *       1   2   3   0
		 *       4   5   6   7
		 *       8   9  10  11
		 *      12  13  14  15
		 * 
		 * The node we want to end with:
		 * 
		 *       0   1   2   3
		 *       4   5   6   7
		 *       8   9  10  11
		 *      12  13  14  15
		 * 
		 */
		
		int[][] startState1 = new int[][] 
		{	{1, 2, 3, 0},
			{4, 5, 6, 7},
			{8, 9, 10 ,11},
			{12, 13, 14, 15}
		};
		
		ILBFSNode start1 = new FifteenPuzzleILBFSNode(startState1, null, 0);
		
		// checking getName function
		System.out.println(start1.getName());
		
		// checking isGoal function
		System.out.println(start1.isGoal());
		
		// checking getChildren
		List<ILBFSNode> ch = start1.getChildren();
		for(ILBFSNode c: ch) {
			System.out.println(c.getName());
		}
		
		// checking getParent
		for(ILBFSNode c: ch) {
			System.out.println("name: " + c.getName() + ", parent: " + c.getParent().getName());
		}
		
		// checking h
		System.out.println(start1.geth());
		for(ILBFSNode c: ch) {
			System.out.println(c.geth());
		}
		
		// checking g
		System.out.println(start1.getg());
		for(ILBFSNode c: ch) {
			System.out.println(c.getg());
		}
		
		// checking f
		System.out.println(start1.getf());
		for(ILBFSNode c: ch) {
			System.out.println(c.getf());
		}
		
		
		// solving the starting state
		ILBFS ilbfs1 = new ILBFS(start1);
		List<ILBFSNode> path1 = ilbfs1.findPathToGoal();
		for(ILBFSNode n : path1) {
			n.drawState();
		}
		System.out.println("moves: " + (path1.size() - 1));
		
		// solving for state 2
		int[][] randomState = new int[][] 
				{	{0, 1, 2, 3},
					{6, 4, 5, 7},
					{8, 9, 10, 11},
					{12, 13, 14, 15}
				};
				
		ILBFSNode random = new FifteenPuzzleILBFSNode(randomState, null, 0);
		ILBFS ilbfs2 = new ILBFS(random);
		List<ILBFSNode> path2 = ilbfs2.findPathToGoal();
		for(ILBFSNode n : path2) {
			n.drawState();
		}
		System.out.println("moves: " + (path2.size() - 1));
		
	}

	private static void testIDAStar() {
		// TODO Auto-generated method stub
		
	}
	

}
