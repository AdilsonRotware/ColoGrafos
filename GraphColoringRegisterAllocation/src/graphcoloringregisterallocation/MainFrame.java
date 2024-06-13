package graphcoloringregisterallocation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private Graph grafoAtual;
    private GraphPanel painelGrafo;

    public MainFrame() {
        grafoAtual = new Graph();
        inicializarGrafo();
        painelGrafo = new GraphPanel(grafoAtual);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.add(painelGrafo, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        JButton botaoColorir = new JButton("Colorir Grafo");
        botaoColorir.addActionListener(e -> {
            GraphColoring coloracao = new GraphColoring(grafoAtual);
            coloracao.colorirGrafo();
            painelGrafo.repaint();
        });
        painelBotoes.add(botaoColorir);

        JButton btnAddNode = new JButton("Adicionar Nó");
        btnAddNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nodeName = JOptionPane.showInputDialog("Digite o nome do nó:");
                if (nodeName != null && !nodeName.isEmpty()) {
                    grafoAtual.adicionarNo(new Node(nodeName, 100, 100)); // Posição inicial fixa
                    painelGrafo.repaint();
                }
            }
        });
        painelBotoes.add(btnAddNode);

        JButton btnRemoveNode = new JButton("Remover Nó");
        btnRemoveNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nodeName = JOptionPane.showInputDialog("Digite o nome do nó a ser removido:");
                if (nodeName != null && !nodeName.isEmpty()) {
                    grafoAtual.removerNo(nodeName);
                    painelGrafo.repaint();
                }
            }
        });
        painelBotoes.add(btnRemoveNode);

        JButton btnAddEdge = new JButton("Adicionar Aresta");
        btnAddEdge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nodeName1 = JOptionPane.showInputDialog("Digite o nome do primeiro nó:");
                String nodeName2 = JOptionPane.showInputDialog("Digite o nome do segundo nó:");
                if (nodeName1 != null && !nodeName1.isEmpty() && nodeName2 != null && !nodeName2.isEmpty()) {
                    grafoAtual.adicionarAresta(nodeName1, nodeName2);
                    painelGrafo.repaint();
                }
            }
        });
        painelBotoes.add(btnAddEdge);

        JButton btnRemoveEdge = new JButton("Remover Aresta");
        btnRemoveEdge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nodeName1 = JOptionPane.showInputDialog("Digite o nome do primeiro nó:");
                String nodeName2 = JOptionPane.showInputDialog("Digite o nome do segundo nó:");
                if (nodeName1 != null && !nodeName1.isEmpty() && nodeName2 != null && !nodeName2.isEmpty()) {
                    grafoAtual.removerAresta(nodeName1, nodeName2);
                    painelGrafo.repaint();
                }
            }
        });
        painelBotoes.add(btnRemoveEdge);

        JButton btnBuildTree = new JButton("Construir Árvore");
        btnBuildTree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rootName = JOptionPane.showInputDialog("Digite o nome do nó raiz:");
                if (rootName != null && !rootName.isEmpty()) {
                    GraphColoring coloracao = new GraphColoring(grafoAtual);
                    coloracao.construirArvore(rootName);
                    painelGrafo.repaint();
                }
            }
        });
        painelBotoes.add(btnBuildTree);

        this.add(painelBotoes, BorderLayout.SOUTH);
    }

    private void inicializarGrafo() {
        Node noA = new Node("A", 100, 100);
        Node noB = new Node("B", 200, 100);
        Node noC = new Node("C", 200, 200);
        Node noD = new Node("D", 100, 200);

        grafoAtual.adicionarNo(noA);
        grafoAtual.adicionarNo(noB);
        grafoAtual.adicionarNo(noC);
        grafoAtual.adicionarNo(noD);

        grafoAtual.adicionarAresta("A", "B");
        grafoAtual.adicionarAresta("A", "C");
        grafoAtual.adicionarAresta("B", "C");
        grafoAtual.adicionarAresta("C", "D");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        });
    }
}
