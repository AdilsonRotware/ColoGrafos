package graphcoloringregisterallocation;

import java.util.ArrayList;
import java.util.List;

public class GraphManager {
    private List<Graph> grafos;

    public GraphManager() {
        this.grafos = new ArrayList<>();
    }

    public void adicionarGrafo(Graph grafo) {
        grafos.add(grafo);
    }

    public void removerGrafo(Graph grafo) {
        grafos.remove(grafo);
    }

    public List<Graph> getGrafos() {
        return grafos;
    }
}
