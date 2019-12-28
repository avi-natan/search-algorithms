package problems;

import java.util.ArrayList;
import java.util.List;

import algorithms.IDAStarNode;
import algorithms.IDAStarSuccessor;

public class PancakeProblemIDAStarNode implements IDAStarNode {
	
	private int[] pile;
	
	public PancakeProblemIDAStarNode(int[] pile) {
		this.pile = pile;
	}

	@Override
	public String getName() {
		String name = "";
		
		for(int i : this.pile) {
			name += "," + i;
		}
		name = name.substring(1);
		return "pile" + name;
	}

	@Override
	public boolean isGoal() {
		if(pile.length == 0) {
			return true;
		}
		
		for(int i = 0; i < pile.length - 1; i++) {
			if(pile[i] < pile[i+1]) return false;
		}
		
		return true;
	}

	@Override
	public List<IDAStarSuccessor> getSuccessors() {
		List<IDAStarSuccessor> successors = new ArrayList<IDAStarSuccessor>();
		
		
		for(int i = 0; i < pile.length - 1; i++) {
			int[] new_pile = new int[pile.length];
			
			for(int j = 0; j < i; j++) {
				new_pile[j] = pile[j];
			}
			
			for(int j = i; j < new_pile.length; j++) {
				new_pile[j] = pile[pile.length-1 - j + i];
			}
			
			IDAStarNode child = new PancakeProblemIDAStarNode(new_pile);
			IDAStarSuccessor successor = new IDAStarSuccessor(1.0, child);
			successors.add(successor);
			
		}
		
		return successors;
	}

	@Override
	public double getHeuristic() {
		double h = 0;
		
		for(int i = 0; i < pile.length - 1; i++) {
			if(Math.abs(pile[i+1] - pile[i]) > 1) {
				h += 1;
			}
		}
		
		return h;
	}

	@Override
	public void drawState() {
		System.out.println(getName());
	}

}
