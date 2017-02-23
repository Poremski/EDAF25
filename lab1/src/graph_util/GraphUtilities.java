package graph_util;
import graph.Graph;

import java.util.HashSet;
import java.util.Set;

public class GraphUtilities {
	
	/**
	 * Returnerar antalet noder i grafen g.
	 * @param g
	 * @return
	 */
	public static <V,E> int nbrOfVertices(Graph<V,E> g) {
		int count = 0;
		for (Graph.Vertex<V, E> v : g) {
			count++;
		}
		return count;
	}
	
	/**
	 * Returnera antalet bågar i grafen g. Metodens andra parameter (directed) anger 
	 * om grafen är riktad (enkelriktad digraf) eller inte. Om den inte är riktad förutsätter vi att 
	 * en båge mellan två noder representeras av två riktade bågar 
	 * då man bygger grafen. I detta fall måste alltså antalet bågar divideras 
	 * med 2 innan det returneras.
	 * @param g
	 * @param directed
	 * @return
	 */
	public static <V,E> int nbrOfEdges(Graph<V,E> g, boolean directed) {
		Set<Graph.Edge<V, E>> edges = new HashSet<Graph.Edge<V, E>>();

		for (Graph.Vertex<V, E> v : g) {
			for (Graph.Edge<V, E> e : v) {
				edges.add(e);
			}
		}
		return directed ? edges.size() : edges.size() / 2;
	}
	
	/**
	 * Undersöker om det finns en båge från noden 'from' till noden 'to'.
	 * @param from
	 * @param to
	 * @return
	 */
	public static <V,E> boolean edgeBetween(Graph.Vertex<V,E> from, Graph.Vertex<V,E> to) {
		for (Graph.Edge<V, E> e : from) {
			return (e.destination().equals(to));
		}
		return false;
	}
}
