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
		 * State 1:
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
		
		// solving for state 1
//		int[][] startState1 = new int[][] 
//				{	{1, 2, 3, 0},
//					{4, 5, 6, 7},
//					{8, 9, 10 ,11},
//					{12, 13, 14, 15}
//				};
//		ILBFSNode start1 = new FifteenPuzzleILBFSNode(startState1, null, 0);
//		ILBFS ilbfs1 = new ILBFS(start1);
//		List<ILBFSNode> path1 = ilbfs1.findPathToGoal();
//		System.out.println("path to goal:");
//		for(ILBFSNode n : path1) {
//			n.drawState();
//		}
//		System.out.println("moves: " + (path1.size() - 1));
		
		// solving for state 2
//		int[][] startState2 = new int[][] 
//				{	{0, 1, 2, 3},
//					{6, 4, 5, 7},
//					{8, 9, 10, 11},
//					{12, 13, 14, 15}
//				};
//		ILBFSNode start2 = new FifteenPuzzleILBFSNode(startState2, null, 0);
//		ILBFS ilbfs2 = new ILBFS(start2);
//		List<ILBFSNode> path2 = ilbfs2.findPathToGoal();
//		System.out.println("path to goal:");
//		for(ILBFSNode n : path2) {
//			n.drawState();
//		}
//		System.out.println("moves: " + (path2.size() - 1));
		
		// solving for state 3
//		int[][] startState3 = new int[][] 
//				{	{0, 5, 2, 3},
//					{1, 4, 6, 7},
//					{8, 9, 10, 11},
//					{12, 13, 14, 15}
//				};
//		ILBFSNode start3 = new FifteenPuzzleILBFSNode(startState3, null, 0);
//		ILBFS ilbfs3 = new ILBFS(start3);
//		List<ILBFSNode> path3 = ilbfs3.findPathToGoal();
//		System.out.println("path to goal:");
//		for(ILBFSNode n : path3) {
//			n.drawState();
//		}
//		System.out.println("moves: " + (path3.size() - 1));
		
		// solving for state 4
		int[][] startState4 = new int[][] 
				{	{0, 1, 6, 3},
					{4, 2, 5, 7},
					{8, 9, 10, 11},
					{12, 13, 14, 15}
				};
		ILBFSNode start4 = new FifteenPuzzleILBFSNode(startState4, null, 0);
		ILBFS ilbfs4 = new ILBFS(start4);
		List<ILBFSNode> path4 = ilbfs4.findPathToGoal();
		System.out.println("path to goal:");
		for(ILBFSNode n : path4) {
			n.drawState();
		}
		System.out.println("moves: " + (path4.size() - 1));
		
	}

	private static void testIDAStar() {
		// TODO Auto-generated method stub
		
	}
	

}
