package cm.edu.neu.deepweb.jung2;

import java.util.List;

import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;

public class TestGenerateGraph {
	public static void main(String[] args) {
		Graph<Integer, String> g=new SparseMultigraph<Integer, String>();
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addEdge("Eage-A", 1,2);
		g.addEdge("Eage-B", 2,3);
		System.out.println(g.toString());
		DijkstraShortestPath<Integer, String> alg=new DijkstraShortestPath<Integer, String>(g);
		List<String> result=alg.getPath(1, 3);
		System.out.println("path is:"+result.toString());
		
	}
}
