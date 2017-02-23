package dfs_applications;

import java.util.ArrayList;
import java.util.Iterator;
import graph.Graph;


public class DFS  {
	
	public static <V,E> void dfs(Graph<V,E> g) {
		g.unvisit();
		for (Graph.Vertex<V,E> v : g) {
			if (!v.isVisited()) {
				dfs(v);
			}
		}
	}
	
	private static <V,E> void dfs(Graph.Vertex<V,E> v) {
		v.visit();
		for (Graph.Edge<V,E> e : v) {
			Graph.Vertex<V,E> w = e.destination();
			if (!w.isVisited()) {
				dfs(w);
			}
		}
	}
	
	/**
	 * True om grafen 'g' är sammanhängande, annars false.
	 * @param g
	 * @return
	 */
	public static <V,E> boolean isConnected(Graph<V,E> g) {
		
		/*
		g.unvisit();
		dfs(g);
		for (Graph.Vertex<V,E> v : g) {
			if (!v.isVisited()) {
				return false;
			}
		}
		return true;
		*/
		
		g.unvisit();
		dfs(g.iterator().next());
		Iterator<Graph.Vertex<V, E>> itr = g.iterator();
		while (itr.hasNext()) {
			if (!itr.next().isVisited()) {
				return false;
			}
		}
		return true;
		
	}
	
	/**
	 * Returnerar antalet komponenter i grafen 'g'.
	 * @param g
	 * @return
	 */
	public static <V,E> int nbrOfComponents(Graph<V,E> g) {
		g.unvisit();
		int count = 0;
		for (Graph.Vertex<V, E> v : g) {
			if (!v.isVisited()) {
				dfs(v);
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Undersöker om det finns en väg från u till v i grafen 'g'.
	 * @param g
	 * @param v
	 * @param u
	 * @return
	 */
	public static <V,E> boolean pathExists(Graph<V,E> g,
			Graph.Vertex<V,E> v, Graph.Vertex<V,E> u) {
		
		if (isConnected(g)) {
			return true;
		} else {
			g.unvisit();
			
			for (Graph.Edge<V, E> e : v) {
				if (e.destination() == u) {
					return true;
				} else {
					return searchPath(e.destination(), u);
				}
			}
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param c current
	 * @param t target
	 * @return
	 */
	private static <V, E> boolean searchPath(Graph.Vertex<V, E> c,
			Graph.Vertex<V, E> t) {
		if (!c.isVisited()) {
			c.visit();
			
			for (Graph.Edge<V, E> e : c) {
				if (e.destination() == t) {
					return true;
				} else {
					return searchPath(e.destination(), t);
				}
			}
		}
		return false;
	}
	
	/**
	 * Returnerar en lista med startnod 'v' och slutnod 'u'.
	 * @param g
	 * @param v
	 * @param u
	 * @return
	 */
	/*public static <V,E> List<Graph.Vertex<V,E>> findPath(Graph<V,E> g,
			Graph.Vertex<V,E> v, Graph.Vertex<V,E> u) {
		
		List<Graph.Vertex<V, E>> list = new ArrayList<Graph.Vertex<V, E>>();
		g.unvisit();
		dfs(g.iterator().next());
		
		if (pathExists(g, v, u)) {
			v.visit();
			list.add(v);
			
			list.addAll(searchFindPath(v, u, list));
		}
		
		return list;
	}
	
	private static <V,E> List<Graph.Vertex<V,E>> searchFindPath(Graph.Vertex<V, E> c,
			Graph.Vertex<V, E> t, List<Graph.Vertex<V,E>> l) {
		
		c.visit();
		for (Graph.Edge<V, E> e : c) {
			if (e.destination() == t) {
				l.add(t);
			} else {
				l.addAll(searchFindPath(e.destination(), t, l));
			}
		}
		
		return l;
	}
	*/
}

