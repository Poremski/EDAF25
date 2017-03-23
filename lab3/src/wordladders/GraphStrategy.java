package wordladders;

/**
 * Ett interface som tar reda på om två ord är grannar.
 */
public interface GraphStrategy {
	/**
	 * Tar reda på om två ord är grannar.
	 * @param word1 Ord1
	 * @param word2 Ord2
	 * @return Returnerar sant om ord1 och ord2 är grannar, annars falskt.
	 */
	public boolean adjacent(String word1, String word2);
}
