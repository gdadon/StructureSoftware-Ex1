package ex1.handlers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import ex1.algo.Graph_algo;
import ex1.resources.Graph;

public class QueryHandler {

	/**
	 * Handler to queries, get array of queries and returns its answeres.
	 * @param g - graph to run queries on.
	 * @param queries - queries to run.
	 * @return - HashMap of the form <Query, Answer>
	 */
	public static Map<String[],String> handlQueries(Graph g, ArrayList<String[]> queries){
		Map<String[], String> respond = new LinkedHashMap<String[], String>();

		for (String[] query : queries) {
			int vStart, vEnd, blSize;
			double dist;
			// clear the graph to its begin mode
			Graph.clearGraph(g);
			switch(query.length){
			case 1:
				// info query
				respond.put(query, Graph_algo.getGraphStatics(g));
				break;
			case 3:
				// shortest path between - without Black List
				vStart = Integer.parseInt(query[0]);
				vEnd = Integer.parseInt(query[1]);
				dist = Graph_algo.getShortestPathBetween(g, vStart, vEnd);
				respond.put(query, ""+dist);
				break;
			default:
				// shortest path between - with Black List
				vStart = Integer.parseInt(query[0]);
				vEnd = Integer.parseInt(query[1]);
				blSize = Integer.parseInt(query[2]);
				LinkedList<Integer> blackList = new LinkedList<Integer>();
				// i = 3 - 3 is where the blackList vertice begin
				for (int i = 1; i < blSize+1; i++) {
					int v = Integer.parseInt(query[2+i]);
					blackList.add(v);
				}
				dist = Graph_algo.getShortestPathWithBlackList(g, vStart, vEnd, blackList);
				respond.put(query, ""+dist);
				break;
			}
		}
		return respond;

	}
}
