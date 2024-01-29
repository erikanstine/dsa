package week_4;

import model.Edge;

import java.util.*;
import java.util.stream.Collectors;

public class KargerMinCut {
    public Integer findMinCut(Map<Integer, List<Integer>> graph) {
        int sufficientlyLargeNumRepetitions = (int) Math.pow(graph.size(), 2);
        int runningMin = Integer.MAX_VALUE;
        // Repeat enough times to reliably yield correct answer
        for (int i = 0; i < sufficientlyLargeNumRepetitions; i++) {
            if (i % 10 == 0) {
                System.out.println("Iterations:" + i + " min: " + runningMin);
            }
            Random rand = new Random();
            Map<Integer, List<Integer>> gCopy = graph
                    .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> List.copyOf(e.getValue())));
            int numVertices = gCopy.size();
            // Contract until we have 2 vertices
            while (numVertices > 2) {
                List<Edge> edges = getEdges(gCopy);
                // Pick random edge
                int randomIdx = rand.nextInt(edges.size());
                Edge randomEdge = edges.get(randomIdx);

                // Contract
                contractGraph(gCopy, randomEdge);
                numVertices = gCopy.size();
            }
            int crossingEdges = gCopy.get(gCopy.keySet().toArray()[0]).size();
            runningMin = Math.min(crossingEdges, runningMin);

        }

        return runningMin;
    }

    private void contractGraph(Map<Integer, List<Integer>> graph, Edge randomEdge) {

        Integer a = randomEdge.getFirst();
        Integer b = randomEdge.getSecond();
        // 1. add all non-first values from graph[b] to graph[a]
        addEdgesToVertex(graph, randomEdge);

        // 2. iterate through graph and update any b edges to a
        graph.forEach((key, val) -> {
            List<Integer> l = val.stream().map(x -> !Objects.equals(x, b) ? x: a).toList();
            graph.replace(key, l);
        });

        // 3. remove self-loops
        graph.replace(a, graph.get(a).stream().filter(v -> !Objects.equals(v, a)).collect(Collectors.toList()));

        // 4. remove graph[b]
        graph.remove(b);
    }

    private void addEdgesToVertex(Map<Integer, List<Integer>> graph, Edge edge) {
        List<Integer> n = new ArrayList<>(graph.get(edge.getFirst()));
        n.addAll(graph.get(edge.getSecond()));
        graph.replace(edge.getFirst(), n);
    }

    // Return list of all edges
    private List<Edge> getEdges(Map<Integer, List<Integer>> graph) {
        List<Edge> edges = new ArrayList<>();
        for (Integer key: graph.keySet()) {
            for (Integer val: graph.get(key)) {
                edges.add(new Edge(key, val));
            }
        }
        return edges;
    }
}
