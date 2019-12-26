package problems;

import java.util.List;

import algorithms.ILBFS;
import algorithms.ILBFSNode;

public class PancakeProblem {

	public static void main(String[] args) {

		System.out.println("problem start");
		
		testIDAStar();
		testILBFS();
		
		System.out.println("problem end");

	}

	private static void testILBFS() {

		int[] startState1 = new int[] {1, 6, 2, 5, 3, 4, 7, 9, 10, 8};
		ILBFSNode start1 = new PancakeProblemILBFSNode(startState1, null, 0);
		ILBFS ilbfs1 = new ILBFS(start1);
		List<ILBFSNode> path1 = ilbfs1.findPathToGoal();
		System.out.println("path to goal:");
		for(ILBFSNode n : path1) {
			n.drawState();
		}
		System.out.println("moves: " + (path1.size() - 1));
		
	}

	private static void testIDAStar() {
		// TODO Auto-generated method stub
		
	}

}
