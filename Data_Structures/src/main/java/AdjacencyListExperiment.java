import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyListExperiment {

    public static void main(String[] args) {
//        List<Integer>[] adjList = new ArrayList[5];
//        for (int i = 0; i < 5; i++) {
//            adjList[i] = new ArrayList<>();
//        }
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        addEdge2(adjList, 0, 1);
        addEdge2(adjList, 0, 4);
        addEdge2(adjList, 1, 2);
        addEdge2(adjList, 1, 3);
        addEdge2(adjList, 1, 4);

        printGraph2(adjList);
    }

    public static void addEdge2(Map<Integer, List<Integer>> adjList, int src, int dest) {
        if (!adjList.containsKey(src)) {
            adjList.put(src, new ArrayList<>());
        }
        if (!adjList.containsKey(dest)) {
            adjList.put(dest, new ArrayList<>());
        }

        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    public static void printGraph2(Map<Integer, List<Integer>> adjList) {
        for (Integer key : adjList.keySet()) {
            System.out.print(key + " -> " + adjList.get(key));
            System.out.println();
        }
    }

    public static void addEdge(List<Integer>[] adjList, int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);  // Remove for directed graphs
    }

    public static void printGraph(List<Integer>[] adjList) {
        for (int i = 0; i < adjList.length; i++) {
            System.out.print(i + " -> " + adjList[i]);
            System.out.println();
        }
    }
}
