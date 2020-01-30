package problems;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import algorithms.IDAStar;
import algorithms.IDAStarNode;
import algorithms.ILBFS;
import algorithms.ILBFSNode;

public class PancakeProblem {

	public static void main(String[] args) {

		System.out.println("problem start");
		
		testIDAStar();
//		testILBFS();
		
		System.out.println("problem end");

	}

	private static void testILBFS() {

		int[] startState1 = new int[] {1, 6, 2, 5, 3, 4, 7, 9, 10, 8, 11, 12, 20, 19, 18, 17, 13, 16, 15, 14};
		ILBFSNode start1 = new PancakeProblemILBFSNode(startState1, null, 0);
		ILBFS ilbfs1 = new ILBFS(start1);
		Instant begin1 = Instant.now();
		List<ILBFSNode> path1 = ilbfs1.findPathToGoal();
		Instant end1 = Instant.now();
		Duration interval1 = Duration.between(begin1, end1);
		System.out.println("path to goal:");
		for(ILBFSNode n : path1) {
			n.drawState();
		}
		System.out.println("moves: " + (path1.size() - 1));
		System.out.println("time in seconds: " + interval1.getSeconds());
		
	}

	private static void testIDAStar() {
		
		int[] startState1 = new int[] {1, 6, 2, 5, 3, 4, 7, 9, 10, 8, 11, 12, 20, 19, 18, 17, 13, 16, 15, 14};
		IDAStarNode start1 = new PancakeProblemIDAStarNode(startState1);
		IDAStar idastar1 = new IDAStar(start1);
		Instant begin1 = Instant.now();
		List<IDAStarNode> path1 = idastar1.findPathToGoal();
		Instant end1 = Instant.now();
		Duration interval1 = Duration.between(begin1, end1);
		System.out.println("path to goal:");
		for(IDAStarNode n : path1) {
			n.drawState();
		}
		System.out.println("moves: " + (path1.size() - 1));
		System.out.println("time in seconds: " + interval1.getSeconds());
		
	}

}
