package ex1.algo;

import ex1.resources.Graph;

public class GraphInfo {
	
	/**
	 * checks for the Triangle inequality in the graph 
	 * @param g - graph to check on
	 * @return true if the graph keeps the inequality, false otherwise.
	 */
	public static boolean isTriangle(Graph g) {
		throw new UnsupportedOperationException();
    }
	
	/**
	 * function to get the radius and diameter of given graph
	 * @param g - graph to get the info from
	 * @return - String contains diameter and radius.
	 */
	public static String getDiameterAndRadius(Graph g){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * return the closest and most far vertices of each vertex vId
	 * @param g - graph
	 * @param vId - vertex to search its closest and most far vertices.
	 * @return an array of the form [Farest Vertex, Closest Vertex]
	 */
	private static double[] getDistances(Graph g, int vId){
		throw new UnsupportedOperationException();
	}
	
	public static void getRadius(Graph g){
		// Another way to get the radius
		// could be to run at Edges array
		// and get the "cheapest" edge
	}
	
	/**
	 * returns the graph to its start point, no distance between nodes and no previus.
	 * @param g
	 */
	public static void clearGraph(Graph g){
		throw new UnsupportedOperationException();
	}
}
