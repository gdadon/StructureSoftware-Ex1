package ex1.test;

import java.util.ArrayList;
import java.util.Map;

import ex1.handlers.FileHandler;
import ex1.handlers.QueryHandler;
import ex1.resources.Graph;

public class GraphTest {

	/*
	 *  Graph G0:
	 *  
	 *		(0)---[1.1]----(4)---[4.2]-----(1)
	 * 		 |  			| \				|
	 * 		 |			  [2.2]\			|
	 * 		 |   			|	\			|
	 * 		 |-----[3]-----(5) 	 \		   [3]
	 * 		 |				|	  \			|
	 * 		 |			  [0.3]	   ---[2.2] |
	 * 		 |				|			   \|
	 * 		 L----[0.3]----(3)---[5.16]----(2)
	 * 
	 */

	public static void main(String[] args) {
		
		testGraph("Data/test_Ex1.txt", "Data/test1_Ex1_run.txt");
		
	}
	
	public static void testGraph(String graphFile, String graphQuery){
		Graph g = new Graph(graphFile);
		
		ArrayList<String[]> queries = FileHandler.readQueries(graphQuery);
		
		Map<String[], String> ans = QueryHandler.handlQueries(g, queries);
		
		FileHandler.writeAnswers(ans);
		
	}
}
