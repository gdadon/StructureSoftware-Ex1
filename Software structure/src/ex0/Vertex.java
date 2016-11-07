package ex0;

import java.util.LinkedList;

class Vertex implements Comparable<Vertex> {
 
    public final int id;
    public LinkedList<Edge> adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
 
    public Vertex(int argName) {
        id = argName;
    }
 
    public String toString() {
        return "" + id;
    }
 
    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }
}