package problems;

import java.util.ArrayList;
import java.util.List;

import algorithms.Successor;
import algorithms.Node;

public class CustomProblemNode implements Node {
	
	private String name;
	private double heuristic;
	private boolean isGoal;
	private List<Successor> successors;
	
	public CustomProblemNode(String name, double heuristic, boolean isGoal) {
		this.name = name;
		this.heuristic = heuristic;
		this.isGoal = isGoal;
		this.successors = new ArrayList<Successor>();
	}
	
	public void addSuccessor(double cost, Node node) {
		this.successors.add(new Successor(cost, node));
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
	public List<Successor> getSuccessors() {
		return this.successors;
	}

	@Override
	public double getHeuristic() {
		return this.heuristic;
	}

}
