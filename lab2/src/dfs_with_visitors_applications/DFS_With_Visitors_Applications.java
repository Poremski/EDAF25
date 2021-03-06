package dfs_with_visitors_applications;
import graph.Graph;
import dfs_with_visitor.*;

public class DFS_With_Visitors_Applications {
	
	public static <V,E> boolean isConnected(Graph<V,E> g) {
		g.unvisit();
		DFS.dfs(g.iterator().next(), new VertexVisitor<V,E>());
		for (Graph.Vertex<V,E> v : g) {
			if (! v.isVisited()) {
				return false;
			}
		}
		return true;
	}
	
	public static <V,E> int componentSize(Graph<V,E> g,
								Graph.Vertex<V,E> v) {
		g.unvisit();
		CountingVisitor<V,E> cv= new CountingVisitor<V,E>();
		DFS.dfs(v,cv);
		return cv.count;
	}
	
	public static <V,E> boolean pathExists(Graph<V,E> g,
							Graph.Vertex<V,E> v,
							Graph.Vertex<V,E> u) {
		
		g.unvisit();
		PathVisitor<V,E> pathVisitor = new PathVisitor<V,E>(u);
		DFS.dfs(v , pathVisitor);
		
		return pathVisitor.path;
	}
	
	static class CountingVisitor<V,E> extends VertexVisitor<V,E> {
		private int count;
		
		public CountingVisitor() {
			super();
			count = 0;
		}
		
		public void preVisit(Graph.Vertex<V,E> v) {
			count++;
		}		
	
	}
	
	static class PathVisitor<V, E> extends VertexVisitor<V, E> {
		private boolean path;
		
		Graph.Vertex<V, E> v;
		
		public PathVisitor(Graph.Vertex<V, E> v) {
			super();
			path = false;
			this.v = v;
		}
		
		public void preVisit(Graph.Vertex<V, E> v) {
			if (this.v == v) {
				path = true;
				
			}
		}
		
	}
	
}
