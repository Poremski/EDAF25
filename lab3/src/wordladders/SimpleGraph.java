package wordladders;
import java.util.Set;

/**
 * Interface som sköter sköter returnering av grafsträngar.
 */
public interface SimpleGraph {
	/**
	 * Returnerar mängden av de strängar som är grannar.
	 * @param s Nodsträng
	 * @return Returnerar mängden av de strängar som är grannar.
	 */
	public Set<String> adjacentTo(String s);
}
