package problems;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import algorithms.IDAStar;
import algorithms.IDAStarNode;
import algorithms.ILBFS;
import algorithms.ILBFSNode;

public class FifteenPuzzle {
	
	public static void main(String[] args) {
		
		System.out.println("problem start");
		
//		testIDAStar();
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
		
		// custom state
		int[][] startState = new int[][] 
				{	{12, 5, 4, 2},
					{1, 14, 9, 3},
					{13, 0, 6, 11},
					{8, 10, 15, 7}
				};
		ILBFSNode start = new FifteenPuzzleILBFSNode(startState, null, 0);
		ILBFS ilbfs = new ILBFS(start);
		Instant begin = Instant.now();
		List<ILBFSNode> path = ilbfs.findPathToGoal();
		Instant end = Instant.now();
		Duration interval = Duration.between(begin, end);
		System.out.println("path to goal:");
		for(ILBFSNode n : path) {
			n.drawState();
		}
		System.out.println("moves: " + (path.size() - 1));
		System.out.println("time in seconds: " + interval.getSeconds());
		
		// solving for state 1
//		int[][] startState1 = new int[][] 
//				{	{1, 2, 3, 0},
//					{4, 5, 6, 7},
//					{8, 9, 10 ,11},
//					{12, 13, 14, 15}
//				};
//		ILBFSNode start1 = new FifteenPuzzleILBFSNode(startState1, null, 0);
//		ILBFS ilbfs1 = new ILBFS(start1);
//		Instant begin1 = Instant.now();
//		List<ILBFSNode> path1 = ilbfs1.findPathToGoal();
//		Instant end1 = Instant.now();
//		Duration interval1 = Duration.between(begin1, end1);
//		System.out.println("path to goal:");
//		for(ILBFSNode n : path1) {
//			n.drawState();
//		}
//		System.out.println("moves: " + (path1.size() - 1));
//		System.out.println("time in seconds: " + interval1.getSeconds());
		
		// solving for state 2
//		int[][] startState2 = new int[][] 
//				{	{0, 1, 2, 3},
//					{6, 4, 5, 7},
//					{8, 9, 10, 11},
//					{12, 13, 14, 15}
//				};
//		ILBFSNode start2 = new FifteenPuzzleILBFSNode(startState2, null, 0);
//		ILBFS ilbfs2 = new ILBFS(start2);
//		Instant begin2 = Instant.now();
//		List<ILBFSNode> path2 = ilbfs2.findPathToGoal();
//		Instant end2 = Instant.now();
//		Duration interval2 = Duration.between(begin2, end2);
//		System.out.println("path to goal:");
//		for(ILBFSNode n : path2) {
//			n.drawState();
//		}
//		System.out.println("moves: " + (path2.size() - 1));
//		System.out.println("time in seconds: " + interval2.getSeconds());
		
		// solving for state 3
//		int[][] startState3 = new int[][] 
//				{	{0, 5, 2, 3},
//					{1, 4, 6, 7},
//					{8, 9, 10, 11},
//					{12, 13, 14, 15}
//				};
//		ILBFSNode start3 = new FifteenPuzzleILBFSNode(startState3, null, 0);
//		ILBFS ilbfs3 = new ILBFS(start3);
//		Instant begin3 = Instant.now();
//		List<ILBFSNode> path3 = ilbfs3.findPathToGoal();
//		Instant end3 = Instant.now();
//		Duration interval3 = Duration.between(begin3, end3);
//		System.out.println("path to goal:");
//		for(ILBFSNode n : path3) {
//			n.drawState();
//		}
//		System.out.println("moves: " + (path3.size() - 1));
//		System.out.println("time in seconds: " + interval3.getSeconds());
		
		// solving for state 4
//		int[][] startState4 = new int[][] 
//				{	{0, 1, 6, 3},
//					{4, 2, 5, 7},
//					{8, 9, 10, 11},
//					{12, 13, 14, 15}
//				};
//		ILBFSNode start4 = new FifteenPuzzleILBFSNode(startState4, null, 0);
//		ILBFS ilbfs4 = new ILBFS(start4);
//		Instant begin4 = Instant.now();
//		List<ILBFSNode> path4 = ilbfs4.findPathToGoal();
//		Instant end4 = Instant.now();
//		Duration interval4 = Duration.between(begin4, end4);
//		System.out.println("path to goal:");
//		for(ILBFSNode n : path4) {
//			n.drawState();
//		}
//		System.out.println("moves: " + (path4.size() - 1));
//		System.out.println("time in seconds: " + interval4.getSeconds());
		
		// solving for state 5
//		int[][] startState5 = new int[][] 
//				{	{8, 0, 9, 6},
//					{15, 2, 7, 11},
//					{1, 6, 3, 13},
//					{14, 10, 4, 12}
//				};
//		ILBFSNode start5 = new FifteenPuzzleILBFSNode(startState5, null, 0);
//		ILBFS ilbfs5 = new ILBFS(start5);
//		Instant begin5 = Instant.now();
//		List<ILBFSNode> path5 = ilbfs5.findPathToGoal();
//		Instant end5 = Instant.now();
//		Duration interval5 = Duration.between(begin5, end5);
//		System.out.println("path to goal:");
//		for(ILBFSNode n : path5) {
//			n.drawState();
//		}
//		System.out.println("moves: " + (path5.size() - 1));
//		System.out.println("time in seconds: " + interval5.getSeconds());
		
	}

	private static void testIDAStar() {
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
		
		// custom state
		int[][] startState = new int[][] 
				{	{12, 5, 4, 2},
					{1, 14, 9, 3},
					{13, 0, 6, 11},
					{8, 10, 15, 7}
				};
		IDAStarNode start = new FifteenPuzzleIDAStarNode(startState, null);
		IDAStar idastar = new IDAStar(start);
		Instant begin = Instant.now();
		List<IDAStarNode> path = idastar.findPathToGoal();
		Instant end = Instant.now();
		Duration interval = Duration.between(begin, end);
		System.out.println("path to goal:");
		for(IDAStarNode n : path) {
			n.drawState();
		}
		System.out.println("moves: " + (path.size() - 1));
		System.out.println("time in seconds: " + interval.getSeconds());
		
		// solving for state 1
//		int[][] startState1 = new int[][] 
//				{	{1, 2, 3, 0},
//					{4, 5, 6, 7},
//					{8, 9, 10 ,11},
//					{12, 13, 14, 15}
//				};
//		IDAStarNode start1 = new FifteenPuzzleIDAStarNode(startState1);
//		IDAStar idastar1 = new IDAStar(start1);
//		Instant begin1 = Instant.now();
//		List<IDAStarNode> path1 = idastar1.findPathToGoal();
//		Instant end1 = Instant.now();
//		Duration interval1 = Duration.between(begin1, end1);
//		System.out.println("path to goal:");
//		for(IDAStarNode n : path1) {
//			n.drawState();
//		}
//		System.out.println("moves: " + (path1.size() - 1));
//		System.out.println("time in seconds: " + interval1.getSeconds());
		
		// solving for state 2
//		int[][] startState2 = new int[][] 
//				{	{0, 1, 2, 3},
//					{6, 4, 5, 7},
//					{8, 9, 10, 11},
//					{12, 13, 14, 15}
//				};
//		IDAStarNode start2 = new FifteenPuzzleIDAStarNode(startState2);
//		IDAStar idastar2 = new IDAStar(start2);
//		Instant begin2 = Instant.now();
//		List<IDAStarNode> path2 = idastar2.findPathToGoal();
//		Instant end2 = Instant.now();
//		Duration interval2 = Duration.between(begin2, end2);
//		System.out.println("path to goal:");
//		for(IDAStarNode n : path2) {
//			n.drawState();
//		}
//		System.out.println("moves: " + (path2.size() - 1));
//		System.out.println("time in seconds: " + interval2.getSeconds());
		
		// solving for state 3
//		int[][] startState3 = new int[][] 
//				{	{0, 5, 2, 3},
//					{1, 4, 6, 7},
//					{8, 9, 10, 11},
//					{12, 13, 14, 15}
//				};
//		IDAStarNode start3 = new FifteenPuzzleIDAStarNode(startState3);
//		IDAStar idastar3 = new IDAStar(start3);
//		Instant begin3 = Instant.now();
//		List<IDAStarNode> path3 = idastar3.findPathToGoal();
//		Instant end3 = Instant.now();
//		Duration interval3 = Duration.between(begin3, end3);
//		System.out.println("path to goal:");
//		for(IDAStarNode n : path3) {
//			n.drawState();
//		}
//		System.out.println("moves: " + (path3.size() - 1));
//		System.out.println("time in seconds: " + interval3.getSeconds());
		
		// solving for state 4
//		int[][] startState4 = new int[][] 
//				{	{0, 1, 6, 3},
//					{4, 2, 5, 7},
//					{8, 9, 10, 11},
//					{12, 13, 14, 15}
//				};
//		IDAStarNode start4 = new FifteenPuzzleIDAStarNode(startState4);
//		IDAStar idastar4 = new IDAStar(start4);
//		Instant begin4 = Instant.now();
//		List<IDAStarNode> path4 = idastar4.findPathToGoal();
//		Instant end4 = Instant.now();
//		Duration interval4 = Duration.between(begin4, end4);
//		System.out.println("path to goal:");
//		for(IDAStarNode n : path4) {
//			n.drawState();
//		}
//		System.out.println("moves: " + (path4.size() - 1));
//		System.out.println("time in seconds: " + interval4.getSeconds());
		
		// solving for state 5
//		int[][] startState5 = new int[][] 
//				{	{8, 0, 9, 6},
//					{15, 2, 7, 11},
//					{1, 6, 3, 13},
//					{14, 10, 4, 12}
//				};
//		IDAStarNode start5 = new FifteenPuzzleIDAStarNode(startState5);
//		IDAStar idastar5 = new IDAStar(start5);
//		Instant begin5 = Instant.now();
//		List<IDAStarNode> path5 = idastar5.findPathToGoal();
//		Instant end5 = Instant.now();
//		Duration interval5 = Duration.between(begin5, end5);
//		System.out.println("path to goal:");
//		for(IDAStarNode n : path5) {
//			n.drawState();
//		}
//		System.out.println("moves: " + (path5.size() - 1));
//		System.out.println("time in seconds: " + interval5.getSeconds());
		
	}
	

}
