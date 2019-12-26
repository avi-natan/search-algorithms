package problems;

import java.util.ArrayList;
import java.util.List;

import algorithms.ILBFSNode;

public class PancakeProblemILBFSNode implements ILBFSNode{
	
	private int[] pile;
	private PancakeProblemILBFSNode parent;
	
	private double g;
	private double h;
	private double f;
	private double F;
	
	public PancakeProblemILBFSNode(int[] pile, PancakeProblemILBFSNode parent, double g) {
		this.pile = pile;
		this.parent = parent;
		
		this.g = g;
		this.h = calculate_h();
		this.f = this.g + this.h;
		this.F = Double.MAX_VALUE;
	}

	@Override
	public String getName() {
		String name = "";
		
		for(int i : this.pile) {
			name += "," + i;
		}
		name = name.substring(1);
		return "stack" + name;
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
	public List<ILBFSNode> getChildren() {
		List<ILBFSNode> children = new ArrayList<ILBFSNode>();
		
		
		for(int i = 0; i < pile.length - 1; i++) {
			int[] new_pile = new int[pile.length];
			
			for(int j = 0; j < i; j++) {
				new_pile[j] = pile[j];
			}
			
			for(int j = i; j < new_pile.length; j++) {
				new_pile[j] = pile[pile.length-1 - j + i];
			}
			
			ILBFSNode child = new PancakeProblemILBFSNode(new_pile, this, this.g+1);
			children.add(child);
			
		}
		
		return children;
	}

	@Override
	public double getg() {
		return this.g;
	}

	@Override
	public double geth() {
		return this.h;
	}

	@Override
	public double getf() {
		return this.f;
	}

	@Override
	public double getF() {
		return this.F;
	}

	@Override
	public void setf(double f) {
		this.f = f;
	}

	@Override
	public void setF(double F) {
		this.F = F;
	}

	@Override
	public ILBFSNode getParent() {
		return this.parent;
	}
	
	private double calculate_h() {
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
