package ex1.handlers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ex1.resources.Graph;

public class FileHandler {

	private static BufferedReader br;
	private static String fileName = "";

	/**
	 * Read graph from file.
	 * @param path - path of the graph file.
	 * @return graph build from file description.
	 */
	public static Graph readGraph(String path) {
		// create new empty graph
		Graph g = new Graph();
		try {
			File fopen = new File(path);
			br = new BufferedReader(new FileReader(fopen));
			String currentLine = "";
			// two first lines are number of nodes and edges
			int nodes = Integer.parseInt(br.readLine());
			int edges = Integer.parseInt(br.readLine());
			g.setNumberOfNodes(nodes);
			g.setNumberOfEdeges(edges);
			// added each new vertex
			for (int i = 0; i < nodes; i++) {
				g.addVertex(i);
			}
			// added each new edge
			while ((currentLine = br.readLine()) != null) {
				String[] splitLine = currentLine.split(" ");
				g.addEdge(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]), Double.parseDouble(splitLine[2]));
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return g;
	}

	/**
	 * Handler to read the queries from give file
	 * @param path - file to read queries from.
	 * @return ArrayList of String[] with the queries.
	 */
	public static ArrayList<String[]> readQueries(String path){

		ArrayList<String[]> queries = new ArrayList<String[]>();
		try {
			File fopen = new File(path);
			fileName = fopen.getName();
			fileName = fileName.substring(0, fileName.indexOf('.'));
			br = new BufferedReader(new FileReader(fopen));
			// read each query and split it
			String currentLine = br.readLine();
			while ((currentLine = br.readLine()) != null) {
				String[] splitLine = currentLine.split(" ");
				queries.add(splitLine);
			}
		} catch (Exception ex) {
			System.out.println(ex);
			System.exit(1);
		}
		return queries;
	}

	/**
	 * create answers file with corresponding answers to the queries file. 
	 * @param respond - the answers to be written into file
	 */
	public static void writeAnswers(Map<String[], String> respond){
		fileName += "_ans.txt";
		File output = new File("Output/"+fileName);
		try {
//			if(!output.createNewFile()){
//				System.out.println("Failed to create answers file.");
//			}
			FileWriter fw = new FileWriter(output);
			BufferedWriter bw = new BufferedWriter(fw);
			
			Set<String[]> keys = respond.keySet();
			for (Iterator<String[]> i = keys.iterator(); i.hasNext();) {
				String[] key = i.next();
				String answer = "";
				for (String string : key) {
					answer += string+" ";
				}
				String value = respond.get(key);
				bw.write(answer + value + "\n");
//				System.out.println(answer + value);
			}
			bw.flush();
			bw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finish with queries to : "+ output.getPath());

	}
}
