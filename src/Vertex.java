import java.util.*;

public class Vertex<T> {
    private T data;
    private Map<Vertex<T>, Double> adjacentVertices;

    // getters&setters constructors
    // equals

    public Vertex(T data) {
        this.data = data;
        adjacentVertices = new HashMap<>();
    }

    public Vertex<T> getVertex(T data) {
        for (Vertex<T> vertex : adjacentVertices.keySet()) {
            if (vertex.data.equals(data)) {
                return vertex;
            }
        }
        return null;
    }

    public Map<Vertex<T>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void addAdjacentVertex(Vertex<T> vertex, Double weight) {
        adjacentVertices.put(vertex, weight);
    }

    public void addAdjacentVertex(T vertex) {
        adjacentVertices.put(new Vertex<T>(vertex), null);
    }

    public boolean contains(T vertex) {
        return adjacentVertices.containsKey(new Vertex<>(vertex));
    }

    public List<T> adjacencyList(){
        List<T> list = new LinkedList<>();

        for (Vertex<T> v : adjacentVertices.keySet()) {
            list.add(v.data);
        }

        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data) && Objects.equals(adjacentVertices, vertex.adjacentVertices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, adjacentVertices);
    }

    public double getWeight(T vertex) {
        return adjacentVertices.get(new  Vertex<>(vertex));
    }

    public int size() {
        return  adjacentVertices.size();
    }

}
