package graphcoloringregisterallocation;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String nome;
    private int x;
    private int y;
    private List<Node> vizinhos;
    private int cor;
    private boolean visitado;

    public Node(String nome, int x, int y) {
        this.nome = nome;
        this.x = x;
        this.y = y;
        this.vizinhos = new ArrayList<>();
        this.cor = -1; // -1 indica que nenhuma cor foi atribuída
        this.visitado = false; // Inicializa o nó como não visitado
    }

    public String getNome() {
        return nome;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public List<Node> getVizinhos() {
        return vizinhos;
    }

    public void adicionarVizinho(Node vizinho) {
        if (!this.vizinhos.contains(vizinho)) {
            this.vizinhos.add(vizinho);
            vizinho.adicionarVizinho(this);
        }
    }

    public void removerVizinho(Node vizinho) {
        vizinhos.remove(vizinho);
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
}
