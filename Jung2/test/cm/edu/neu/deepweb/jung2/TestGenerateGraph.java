package cm.edu.neu.deepweb.jung2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.util.List;

import javax.swing.JFrame;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.samples.SimpleGraphDraw;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

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
		
		Layout<Integer, String> layout=new CircleLayout<Integer, String>(g);
		layout.setSize(new Dimension(300,300));
		BasicVisualizationServer<Integer, String> vv=new BasicVisualizationServer<Integer, String>(layout);
		vv.setPreferredSize(new Dimension(350,360));
		vv.getRenderContext().setVertexFillPaintTransformer(new Transformer<Integer, Paint>() {
	
			@Override
			public Paint transform(Integer arg0) {
				// TODO Auto-generated method stub
				return Color.GREEN;
			}
		});
		vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<String>());
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(vv);
		frame.pack();
		frame.setVisible(true);
	}
}
