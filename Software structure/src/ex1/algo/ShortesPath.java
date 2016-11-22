package ex1.algo;

import java.util.PriorityQueue;

import ex1.resources.Edge;
import ex1.resources.Graph;
import ex1.resources.Vertex;

public class ShortesPath {
	
	public static void computePaths(Graph g, int vertexId) {
		Vertex source = g.getVertexById(vertexId);
        source.setMinDistance(0D);
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);
 
        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();
 
            for (Edge e : u.getAdjacencies()) {
                if (!g.getBlackList().contains(e.getTarget().getId())) {
                    Vertex v = e.getTarget();
                    double weight = e.getWeight();
                    double distanceThroughU = u.getMinDistance() + weight;
                    if (distanceThroughU < v.getMinDistance()) {
                        vertexQueue.remove(v);
                        v.setMinDistance(distanceThroughU);
                        v.setPrevious(u);
                        vertexQueue.add(v);
                    }
                }
            }
        }
    }
	
}
