package model;

public class Edge {
    private final Integer first;
    private final Integer second;

    public Edge(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }

    public Integer getFirst() {
        return first;
    }

    public Integer getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    // You can override equals and hashCode if needed
}
