package wordladders;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 *
 */
public class Main {

    /**
     * Bygger en graf utgående från de ord som finns på filen 'wordfile'.
     * @param strategy Grannstrategi
     * @param wordfile Lista med ord innehållandes ett ord per rad
     * @param infile Fil till ordpar
     */
	public static void processRequests(GraphStrategy strategy, String wordfile, String infile) {
        SimpleGraph g = new SimpleGraphCreator(wordfile, strategy);
        Scanner scan = null;
        try {
            scan = new Scanner(new File("lab3/src/" + infile));
        } catch (FileNotFoundException e) {
            System.err.println("Couldn't open file: " + infile);
            System.exit(1);
        }
        while (scan.hasNext()) {
            String word1 = scan.next();
            String word2 = scan.next();
            System.out.println(ShortestPath.shortestPath(g, word1, word2));
        }
        scan.close();
	}

}
