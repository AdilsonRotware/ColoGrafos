package graphcoloringregisterallocation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GraphPanel extends JPanel {
    private Graph grafo;
    private Node noSelecionado;
    private int offsetX, offsetY;

    public GraphPanel(Graph grafo) {
        this.grafo = grafo;
        this.setBackground(Color.WHITE);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                noSelecionado = encontrarNo(e.getX(), e.getY());
                if (noSelecionado != null) {
                    offsetX = e.getX() - noSelecionado.getX();
                    offsetY = e.getY() - noSelecionado.getY();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                noSelecionado = null;
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (noSelecionado != null) {
                    noSelecionado.setX(e.getX() - offsetX);
                    noSelecionado.setY(e.getY() - offsetY);
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Node no : grafo.getNos()) {
            g.setColor(Color.BLACK);
            g.fillOval(no.getX() - 15, no.getY() - 15, 30, 30);
            g.setColor(Color.WHITE);
            g.drawString(no.getNome(), no.getX() - 5, no.getY() + 5);
            g.setColor(Color.BLACK);
            g.drawString("Cor: " + no.getCor(), no.getX() - 5, no.getY() + 20);

            g.setColor(Color.BLACK);
            for (Node vizinho : no.getVizinhos()) {
                g.drawLine(no.getX(), no.getY(), vizinho.getX(), vizinho.getY());
            }
        }
    }

    private Node encontrarNo(int x, int y) {
        for (Node no : grafo.getNos()) {
            if (Math.pow(x - no.getX(), 2) + Math.pow(y - no.getY(), 2) <= 225) { // 225 = raio^2 do nó
                return no;
            }
        }
        return null;
    }
}
