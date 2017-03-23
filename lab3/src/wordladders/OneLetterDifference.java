package wordladders;

/**
 * Klass som hanterar ord som är grannar och som skiljer sig åt på precis en bokstav.
 */
public class OneLetterDifference implements GraphStrategy {

    /**
     * Tar reda på om två ord är grannar och om dessa skiljer sig åt på precis en bokstav.
     * @param word1 Ord1
     * @param word2 Ord2
     * @return Returnerar sant om ord1 och ord2 är grannar och skiljer sig åt på precis en bokstav, annars falskt.
     */
    @Override
    public boolean adjacent(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }
        if (diff == 1) {
            return true;
        }
        return false;
    }

}
