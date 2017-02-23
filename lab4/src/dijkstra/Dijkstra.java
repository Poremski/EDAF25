package dijkstra;
import graph.Graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;


public class Dijkstra<V,E> {
	
	private Comparator<E> cmp;
	
	/**
	 * Räkna ut den kortaste väg mellan 'from' och 'to'.
	 * 
	 * @param g
	 * @param from
	 * @param to
	 * @param cmp
	 * @param adder
	 * @return E
	 */
	public E shortestPath(Graph<V,E> g, Graph.Vertex<V,E> from, Graph.Vertex<V,E> to, Comparator<E> cmp, Adder<E> adder) {
		
		this.cmp = cmp;
		
		// Skapa ny PrioQueueEntryComparator() för att jämföra PrioQueueEntry med varandra.
		PrioQueueEntryComparator queueCmp = new PrioQueueEntryComparator();
		// Tomt prioritetskö.
		PriorityQueue<PrioQueueEntry> priorityQueue = new PriorityQueue<PrioQueueEntry>(queueCmp);
		// HashMap för att lagra noderna och dess kostnad.
		Map<Graph.Vertex<V, E>, E> vertexMap = new HashMap<Graph.Vertex<V, E>, E>();
		// Huvudkö
		HashSet<PrioQueueEntry> queue = new HashSet<PrioQueueEntry>();
		// Lägg in noden 'from' till prioritetskön. 
		priorityQueue.offer(new PrioQueueEntry(from, adder.getZero()));
		vertexMap.put(from, adder.getZero());
		
		while (!priorityQueue.isEmpty()) {
			// Hämtar ut och tar bort huvudnod från kön.
			PrioQueueEntry act = priorityQueue.poll();
			// Kontrollerar om huvudnoden är lika med destinationsnoden.
			if (act.vertex == to) {
				return act.distance;
			} else {
				// Lägger in huvudnod i huvudkön.
				queue.add(act);
				// För varje båge från huvudnoden
				for (Graph.Edge<V, E> e : act.vertex) {
					// Beräkna nytt avstånd 
					E newDist = adder.add(act.distance, e.getValue());
					// Grannod
					Graph.Vertex<V, E> w = e.destination();
					// Om grannoden ännu ej är besökt
					if (!vertexMap.containsKey(w) || (cmp.compare(newDist, vertexMap.get(w)) < 0)) {
						// Lägg 'w' till prioritetskön
						priorityQueue.offer(new PrioQueueEntry(w, newDist));
						// Markera 'w' som besökt
						vertexMap.put(w, newDist);
					}
				}
			}
		}

		return null;
	}
	
	/**
	 * Inre privatklass för de element som läggs in i prioritetskön.
	 */
	private class PrioQueueEntry {
		
		private Graph.Vertex<V, E> vertex;
		private E distance;
		
		/**
		 * Konstruktorn
		 * 
		 * @param vertex Referens till en nod i grafen.
		 * @param distance Avståndet på den hittils kortaste vägen till noden 'vertex'.
		 */
		public PrioQueueEntry(Graph.Vertex<V, E> vertex, E distance) {
			this.vertex = vertex;
			this.distance = distance;
		}
		
	}
	
	/**
	 * Inre privatklass för att jämföra PrioQueueEntry med varandra.
	 */
	private class PrioQueueEntryComparator implements Comparator<PrioQueueEntry> {
		
		@Override
		/**
		 * Jämför två PrioQueueEntry med varandra.
		 * 
		 * @param a
		 * @param b
		 * @return jämförelsetal given av Comparator.compare() mellan 'a' och 'b'.
		 */
		public int compare(Dijkstra<V, E>.PrioQueueEntry a, Dijkstra<V, E>.PrioQueueEntry b) {
			return cmp.compare(a.distance, b.distance);
		}
	}
	
}
