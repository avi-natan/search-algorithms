package algorithms;

public class Neighbor {

	private double cost;
	private Node node;
	
	public Neighbor(double cost, Node node) {
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
