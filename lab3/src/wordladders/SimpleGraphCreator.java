package wordladders;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Klass som skapar en graf utifrån indata.
 */
public class SimpleGraphCreator implements SimpleGraph {

    private Map<String, Set<String>> graph = new HashMap<String, Set<String>>();

    /**
     * Konstruktor som läser in ord från fil och bygger upp grafen utifrån filen.
     * @param file Filnamn
     * @param graph Graf av typen GraphStrategy.
     */
    public SimpleGraphCreator(String file, GraphStrategy graph) {
        Scanner scan = null;
        try {
            scan = new Scanner(new File("lab3/src/" + file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("### Kunde inte öppna filen: " + file + " ###");
            System.exit(1);
        }
        while (scan.hasNext()) {
            this.graph.put(scan.next(), new HashSet<String>());
        }

        for (String w1 : this.graph.keySet()) {
            for (String w2 : this.graph.keySet()) {
                // Interface GraphStrategy: Kollar om två ord är grannar.
                if (graph.adjacent(w1, w2)) {
                    this.graph.get(w1).add(w2);
                }
            }
        }
        scan.close();
    }

    /**
     * Returnerar mängden av de strängar som är grannar med ett givet ord.
     * @param s Ord
     * @return Returnerar mängdne av de strängar som är grammar med det givna ordet.
     */
    @Override
    public Set<String> adjacentTo(String s) {
        return graph.get(s);
    }
}