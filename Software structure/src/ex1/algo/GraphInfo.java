package ex1.algo;

import java.util.LinkedList;

import ex1.resources.Graph;
import ex1.resources.Vertex;

public class GraphInfo {

	/**
	 * checks for the Triangle inequality in the graph 
	 * @param g - graph to check on
	 * @return true if the graph keeps the inequality, false otherwise.
	 */
	public static boolean isTriangle(Graph g) {
		LinkedList<Vertex> vertices = g.getVertices();
		for (int i = 0; i < g.getNumberOfNodes(); i++) {
			ShortesPath.computePaths(g, vertices.get(i).getId());
			for (int j = 0; j < vertices.get(i).getAdjacencies().size(); j++) {
				if (vertices.get(vertices.get(i).getAdjacencies().get(j).getTarget().getId()).getMinDistance()
						!= vertices.get(i).getAdjacencies().get(j).getWeight()) {
					return false;
				}
			}
			clearGraph(g);
		}
		return true;
	}

	/**
	 * function to get the radius and diameter of given graph
	 * @param g - graph to get the info from
	 * @return - String contains diameter and radius.
	 */
	public static String getDiameterAndRadius(Graph g){

		double diameter = 0;
		double radius = 0;
		double[] tempDist = new double[2];

		for (Vertex v : g.getVertices()) {
			// calculating the shortest path to current vertex
			ShortesPath.computePaths(g, v.getId());

			// get the farest and closest vertices of current vertex
			tempDist = getDistances(g, v.getId());

			if(tempDist[0] > diameter)
				diameter = tempDist[0];

			if(tempDist[1] < radius)
				radius = tempDist[1];

			clearGraph(g);
		}

		return "Diameter: "+diameter+", Radius: "+radius;
	}

	/**
	 * return the closest and most far vertices of each vertex vId
	 * @param g - graph
	 * @param vId - vertex to search its closest and most far vertices.
	 * @return an array of the form [Farest Vertex, Closest Vertex]
	 */
	private static double[] getDistances(Graph g, int vId){
		double farest = 0.;
		double closest = Double.POSITIVE_INFINITY;
		for (Vertex v : g.getVertices()) {
			double dist = v.getMinDistance();
			if(farest < dist && dist != Double.POSITIVE_INFINITY){
				farest = dist;
			}
			else if(closest > dist && dist > 0){
				closest = dist;
			}
		}
		double[] diamAndRad = {farest, closest};
		return diamAndRad;
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
		for (Vertex v : g.getVertices()) {
			v.setMinDistance(Double.POSITIVE_INFINITY);
			v.setPrevious(null);
		}
	}
}
