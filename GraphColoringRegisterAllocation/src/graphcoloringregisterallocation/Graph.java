package graphcoloringregisterallocation;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Node> nos;

    public Graph() {
        this.nos = new ArrayList<>();
    }

    public void adicionarNo(Node no) {
        nos.add(no);
    }

    public void removerNo(String nome) {
        Node no = getNoPorNome(nome);
        if (no != null) {
            nos.remove(no);
            for (Node n : nos) {
                n.removerVizinho(no);
            }
        }
    }

    public List<Node> getNos() {
        return nos;
    }

    public Node getNoPorNome(String nome) {
        for (Node no : nos) {
            if (no.getNome().equals(nome)) {
                return no;
            }
        }
        return null;
    }

    public void adicionarAresta(String nome1, String nome2) {
        Node no1 = getNoPorNome(nome1);
        Node no2 = getNoPorNome(nome2);
        if (no1 != null && no2 != null) {
            no1.adicionarVizinho(no2);
        }
    }

    public void removerAresta(String nome1, String nome2) {
        Node no1 = getNoPorNome(nome1);
        Node no2 = getNoPorNome(nome2);
        if (no1 != null && no2 != null) {
            no1.removerVizinho(no2);
            no2.removerVizinho(no1);
        }
    }
}
