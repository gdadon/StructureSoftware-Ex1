package ex1.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ex1.resources.Graph;
import ex1.resources.Vertex;

public class Graph_algo {
	
	public static double getShortestPathBetween(Graph g, int startVertex, int endVertex){
		ShortesPath.computePaths(g, startVertex);
		Vertex target = g.getVertexById(endVertex);
		return target.getMinDistance();
	}
	
	public static String getShortestPathTo(Graph g, int startVertex, int endVertex) {
		Vertex vertex = g.getVertexById(endVertex);
    	List<Vertex> path = new ArrayList<Vertex>();
    	for (; vertex != null; vertex = vertex.getPrevious()) {
    		path.add(vertex);
    	}
    	return path.toString();
	}
	
	public static double getShortestPathWithBlackList(Graph g, int startVertex, int endVertex, LinkedList<Integer> blackList){
		g.setBlackList(blackList);
		ShortesPath.computePaths(g, startVertex);
		Vertex target = g.getVertexById(endVertex);
		return target.getMinDistance();
	}
	
	public static String getGraphStatics(Graph g){
		long start = System.currentTimeMillis();
		String[] stat = new String[4];
		String radiusAndDiameter = GraphInfo.getDiameterAndRadius(g);
		stat[0] = "" + g.getNumberOfNodes();
		stat[1] = "" + g.getNumberOfEdeges();
		if(GraphInfo.isTriangle(g))
			stat[2] = "TIE";
		else
			stat[2] = "!TIE";
		long end = System.currentTimeMillis();
		stat[3] = "" + (end-start);
		
		return "Graph: |V|= "+stat[0]+", |E| = "+stat[1]+", "+ stat[2]+
				", " + radiusAndDiameter + ", Runtime = "+stat[3]+" ms";
	}

}
