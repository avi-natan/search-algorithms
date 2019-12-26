package problems;

import java.util.ArrayList;
import java.util.List;

import algorithms.IDAStarSuccessor;
import algorithms.IDAStarNode;

public class CustomIDAStarProblemNode implements IDAStarNode {
	
	private String name;
	private double heuristic;
	private boolean isGoal;
	private List<IDAStarSuccessor> successors;
	
	public CustomIDAStarProblemNode(String name, double heuristic, boolean isGoal) {
		this.name = name;
		this.heuristic = heuristic;
		this.isGoal = isGoal;
		this.successors = new ArrayList<IDAStarSuccessor>();
	}
	
	public void addSuccessor(double cost, IDAStarNode node) {
		this.successors.add(new IDAStarSuccessor(cost, node));
	}
	

	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public boolean isGoal() {
		return this.isGoal;
	}

	@Override
	public List<IDAStarSuccessor> getSuccessors() {
		return this.successors;
	}

	@Override
	public double getHeuristic() {
		return this.heuristic;
	}
	
	@Override
	public void drawState() {
		System.out.println(this.name);
	}

}
