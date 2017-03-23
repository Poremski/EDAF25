package wordladders;
import java.util.HashSet;
import java.util.Set;

/**
 * Klass som bestämmer ut kortaste vägen mellan två ord.
 */
public class ShortestPath {

    /**
     * Algoritm för att bestämma kortaste vägen mellan två ord.
     * @param g SimpleGraph Innehåller mängden av de strängar som är grannar.
     * @param source Inord
     * @param dest Utord
     * @return Returnerar heltalsvärde som representerar avstånd; -1 om inord är tomt.
     */
	public static int shortestPath(SimpleGraph g, String source, String dest) {
		Set<String> visited = new HashSet<>();
		Set<String> actLevel = new HashSet<>();
		int distance = 0;

		visited.add(source);
		actLevel.add(source);

		while (!actLevel.isEmpty()) {
		    Set<String> nextLevel = new HashSet<String>();
		    for (String s : actLevel) {
		        if (s.equals(dest)) {
		            return distance;
                }
                for (String n : g.adjacentTo(s)) {
		            if (!visited.contains(n)) {
		                visited.add(n);
		                nextLevel.add(n);
                    }
                }
            }
            distance++;
		    actLevel = nextLevel;
        }
		return -1;
	}

}
