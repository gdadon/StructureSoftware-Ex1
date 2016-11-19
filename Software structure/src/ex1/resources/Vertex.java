package ex1.resources;

import java.util.LinkedList;

public class Vertex implements Comparable<Vertex> {
 
    protected final int id;
    protected LinkedList<Edge> adjacencies;
    protected double minDistance = Double.POSITIVE_INFINITY;
    protected Vertex previous;
 
    /**
     * Vertex constructor 
     * @param argName - ID of vertex
     */
    public Vertex(int argName) {
        id = argName;
    }
    
    // Getters & Setters.
 
    public LinkedList<Edge> getAdjacencies() {
		return adjacencies;
	}

	public void setAdjacencies(LinkedList<Edge> adjacencies) {
		this.adjacencies = adjacencies;
	}

	public double getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
	}

	public Vertex getPrevious() {
		return previous;
	}

	public void setPrevious(Vertex previous) {
		this.previous = previous;
	}

	public int getId() {
		return id;
	}

	public String toString() {
        return "" + id;
    }
 
    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }
}