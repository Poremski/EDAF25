
public class MaxFlowTest {

    public static void main(String[] args) {
        MaxFlow maxFlow1 = new MaxFlow("lab5/small.txt");
        MaxFlow maxFlow2 = new MaxFlow("lab5/sixnodes.txt");
        MaxFlow maxFlow3 = new MaxFlow("lab5/rail.txt");

        System.out.println("Max flow: " + maxFlow1.maxFlow());
        System.out.println("Max flow: " + maxFlow2.maxFlow());
        System.out.println("Max flow: " + maxFlow3.maxFlow());
    }

}
