package graph_util_tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import graph.Graph;
import digraph.DiGraph;
import graph_util.GraphUtilities;

public class TestGraphUtilities {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNbrOfVerticesNoVertices() {
		Graph<String,Integer> g = new DiGraph<String,Integer>();
		assertEquals(0, GraphUtilities.nbrOfVertices(g));
	}
	
	@Test
	public void testNbrOfVerticesOneVertex() {
		Graph<String,Integer> g = new DiGraph<String,Integer>();
		g.addVertex("a");
		assertEquals(1, GraphUtilities.nbrOfVertices(g));
	}
	
	@Test
	public void testNbrOfVerticesTwoVertices() {
		Graph<String,Integer> g = new DiGraph<String,Integer>();
		g.addVertex("a");
		g.addVertex("b");
		assertEquals(2, GraphUtilities.nbrOfVertices(g));
	}
	
	@Test
	public void testNbrOfVerticesFiveVertices() {
		Graph<String,Integer> g = new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 = g.addVertex("b");
		Graph.Vertex<String,Integer> v3 = g.addVertex("c");
		Graph.Vertex<String,Integer> v4 = g.addVertex("d");
		Graph.Vertex<String,Integer> v5 = g.addVertex("e");
		g.addEdge(1,v1,v2);
		g.addEdge(4,v2,v3);
		g.addEdge(3,v3,v4);
		g.addEdge(7,v4,v5);
		g.addEdge(2,v5,v1);
		
		/*
		 	— (a) —
		  / 		\ 1
		  |	2    	 (b)
		  | 		  | 4
		  (e)		 (c)
		 	\ 7    / 3
		 	    (d)	 
		 
		 */
		
		assertEquals(5, GraphUtilities.nbrOfVertices(g));
	}
	
	@Test
	public void testEdgeBetweenNoEdge() {
		Graph<String,Integer> g = new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 = g.addVertex("b");
		assertFalse(GraphUtilities.edgeBetween(v1,v2));
	}
	
	@Test
	public void testNbrOfEdges() {
		Graph<String,Integer> g = new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 = g.addVertex("b");
		Graph.Vertex<String,Integer> v3 = g.addVertex("c");
		g.addEdge(1, v1, v2);
		g.addEdge(1, v2, v3);
		g.addEdge(1, v3, v1);
		/*
		 	(b) — (c)
		 	  \   /
		 	   (a)
		 */
		assertEquals(1, GraphUtilities.nbrOfEdges(g, false));
		assertEquals(3, GraphUtilities.nbrOfEdges(g, true));
	}
	
	@Test
	public void testEdgeBetweenEdge() {
		Graph<String,Integer> g = new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 = g.addVertex("b");
		Graph.Vertex<String,Integer> v3 = g.addVertex("c");
		g.addEdge(1, v1, v2);
		g.addEdge(1, v2, v3);
		g.addEdge(1, v3, v1);
		/*
	 	(b) — (c)
	 	  \   /
	 	   (a)
		 */
		assertTrue(GraphUtilities.edgeBetween(v1,v2));
		assertTrue(GraphUtilities.edgeBetween(v2,v3));
		assertTrue(GraphUtilities.edgeBetween(v3,v1));
	}
	

}
