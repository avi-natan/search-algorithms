package algorithms;

public class Successor {

	private double cost;
	private Node node;
	
	public Successor(double cost, Node node) {
		this.cost = cost;
		this.node = node;
	}
	
	public double getCost() {
		return this.cost;
	}
	
	public Node getNode() {
		return this.node;
	}
	
}
