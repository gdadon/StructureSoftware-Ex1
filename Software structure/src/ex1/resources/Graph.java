package ex1.resources;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ex1.handlers.FileHandler;;
 
public class Graph {
 
    private LinkedList<Vertex> vertices = new LinkedList<>();
    private LinkedList<Integer> blackList = new LinkedList<Integer>();
    private int numberOfNodes;
    private int numberOfEdeges;
    
    /**
     * Default constructor.
     */
    public Graph(){
    }
    
    /**
     * Copy constructor
     * @param g - graph to copy
     */
    public Graph(Graph g){
    	this.vertices = g.vertices;
    	this.blackList = g.blackList;
    	this.numberOfNodes = g.numberOfNodes;
    	this.numberOfEdeges = g.numberOfEdeges;
    }
 
    /**
     * Graph constructor
     * @param path - File with the graph info to be build.
     */
    public Graph(String path) {
    	this(FileHandler.readGraph(path));
    }
   
    /**
     * create and add new vertex to graph. 
     * @param id - new vertex id. 
     */
    public void addVertex(int id) {
        Vertex temp = new Vertex(id);
        temp.adjacencies = new LinkedList<>();
        vertices.add(temp);
    }
    
    /**
     * Get vertex by id.
     * @param id - id of desire vertex.
     * @return vertex with desired id.
     */
    public Vertex getVertexById(int id){
    	for (Vertex vertex : vertices) {
			if(vertex.getId() == id)
				return vertex;
		}
    	return null;
    }
 
    /**
     * add edge to graph
     * @param fromID - start vertex
     * @param toID - end vertex
     * @param weight - edge weight
     */
    public void addEdge(int fromID, int toID, double weight) {
        vertices.get(fromID).adjacencies.add(new Edge(vertices.get(toID), weight));
        vertices.get(toID).adjacencies.add(new Edge(vertices.get(fromID), weight));
    }
    
    /**
     * print the graph info - vertices, edges and adjacencies.
     */
    public void printGraph() {
    	for (Vertex vertice : vertices) {
    		System.out.println(vertice);
    		for (int i = 0; i < vertice.adjacencies.size(); i++) {
    			System.out.println(vertice.adjacencies.get(i));
    		}
    	}
    }
    
    /**
     * print the graph info as list.
     */
    public void printGraphAsList(){
    	ArrayList<Integer> printed = new ArrayList<Integer>();  
    	for (Vertex v1 : vertices) {
    		int currentV = v1.id;
    		for (Edge e : v1.adjacencies) {
    			if(!printed.contains(e.target.id))
    				System.out.println("["+currentV+", "+e.target+": "+e.weight+"]");
			}
    		printed.add(currentV);
    	}
    }
    
    // Getters and setters.
    
    public LinkedList<Integer> getBlackList() {
		return blackList;
	}

	public void setBlackList(LinkedList<Integer> blackList) {
		this.blackList = blackList;
	}

	public int getNumberOfNodes() {
		return numberOfNodes;
	}

	public void setNumberOfNodes(int numberOfNodes) {
		this.numberOfNodes = numberOfNodes;
	}

	public int getNumberOfEdeges() {
		return numberOfEdeges;
	}

	public void setNumberOfEdeges(int numberOfEdeges) {
		this.numberOfEdeges = numberOfEdeges;
	}

	public LinkedList<Vertex> getVertices() {
		return vertices;
	}

}