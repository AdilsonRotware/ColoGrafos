package graphcoloringregisterallocation;

import java.util.HashSet;
import java.util.Set;

public class GraphColoring {
    private Graph grafo;

    public GraphColoring(Graph grafo) {
        this.grafo = grafo;
    }

    public void colorirGrafo() {
        for (Node no : grafo.getNos()) {
            Set<Integer> coresUsadas = new HashSet<>();
            for (Node vizinho : no.getVizinhos()) {
                if (vizinho.getCor() != -1) {
                    coresUsadas.add(vizinho.getCor());
                }
            }

            int cor = 0;
            while (coresUsadas.contains(cor)) {
                cor++;
            }
            no.setCor(cor);
        }
    }

    public void construirArvore(String raizNome) {
        Node raiz = grafo.getNoPorNome(raizNome);
        if (raiz != null) {
            construirSubArvore(raiz, null);
        }
    }

    private void construirSubArvore(Node no, Node pai) {
        no.setVisitado(true);
        if (pai != null) {
            pai.adicionarVizinho(no);
        }

        for (Node vizinho : no.getVizinhos()) {
            if (!vizinho.isVisitado()) {
                construirSubArvore(vizinho, no);
            }
        }
    }
}
