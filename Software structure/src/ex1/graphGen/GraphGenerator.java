package ex1.graphGen;

import java.io.PrintWriter;
import java.util.Vector;

import ex1.resources.Edge;
import ex1.resources.Graph;

public class GraphGenerator {

	Graph g;
	static int numOfGraphText;
	
	/**
	 * constructor
	 */
	public GraphGenerator() {
		g = new Graph();
		numOfGraphText = 1;
	}
	
	public GraphGenerator(int RetryNum) {
		g = new Graph();
		numOfGraphText = RetryNum;
	}
	/**
	 * Generate a new graph and print him in text file
	 * @param vertex - amount of vertex in the graph
	 */
	public void GenerateAndPrint(int vertex)
	{
		Graph g = GraphGenerat(vertex);
		Vector<Number> vec = calcEdge(g, vertex);
		printGraph(vec);
	}

	private Graph GraphGenerat(int sumVertex) {

		if (sumVertex > 0) {
			int id = 0, temp = 0, randomIfAddEdge;
			boolean oneEdgeAtLeast = false;
			g.addVertex(id);
			sumVertex--;
			id++;
			while (sumVertex > 0) {
				g.addVertex(id);
				oneEdgeAtLeast = false;
				while (!oneEdgeAtLeast) {
					temp = id;
					while (temp > 0) {
						randomIfAddEdge = (int) (Math.random() * 2);
						if (randomIfAddEdge == 1) {
							double randomWeight = (double) (Math.random() * 100) + 1;
							g.addEdge(id, --temp, randomWeight);
							oneEdgeAtLeast = true;
						} else
							temp--;
					}
				}

				id++;
				sumVertex--;
			}
		}
		g.printGraph();
		return g;
	}

	private Vector<Number> calcEdge(Graph g, int vertex) {
		Vector<Number> vec = new Vector<Number>();
		vec.add(vertex);
		vec.add(-1);
		int amountEdge = 0;

		for (int i = 0; i < vertex; i++) {
			for (Edge e : g.getVertexById(i).getAdjacencies()) {
				if (e.getTarget().getId() > i) {
					vec.add(i);
					vec.add(e.getTarget().getId());
					vec.add(e.getWeight());
					amountEdge++;
				}
			}

		}
		vec.setElementAt(amountEdge, 1);
		return vec;
	}

	private void printGraph(Vector<Number> vec) {
		try {
			PrintWriter writer = new PrintWriter("Graph " + numOfGraphText++
					+ ".txt", "UTF-8");
			writer.println(vec.elementAt(0));
			writer.println(vec.elementAt(1));
			
			for (int i = 2; i < vec.size(); i++) {
				writer.println(vec.elementAt(i++) + " " + vec.elementAt(i++) + " " + vec.elementAt(i));
			}	
			writer.close();
		} catch (Exception e) {
			// do something
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 10; i++) {
			GraphGenerator g = new GraphGenerator(i+1);
			g.GenerateAndPrint((int)(Math.random()*20)+1);
		}
		
		
		
			
		
		

	}

}
