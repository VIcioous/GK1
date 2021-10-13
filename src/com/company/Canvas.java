package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

public class Canvas extends JPanel  {
    private final JButton lineButton = new JButton();
    private final JButton triangleButton = new JButton();
    private final JButton circleButton = new JButton();
    private final JButton confirmButton = new JButton();

    private final JTextField x1Field = new JTextField();
    private final JTextField y1Field = new JTextField();
    private final JTextField x2Field = new JTextField();
    private final JTextField y2Field = new JTextField();
    private final JTextField x3Field = new JTextField();
    private final JTextField y3Field = new JTextField();
    private DrawDTO drawDTO;
    private String adding = null;
    private String drawing = null;

    private int type = 0;

    private Figure figure;
    private Point startPoint = new Point(0,0);
    private Point endPoint = new Point(0,0);

    {

        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endPoint = e.getPoint();
                repaint();

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                endPoint = e.getPoint();

            }
        });
    }

    Canvas() {
        this.figure = new LineComponent();
        setButtons();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;
        g.drawString("x1",460,35);
        if (startPoint != null) {
            figure.draw(graphics2D, startPoint, endPoint);

        }
        if (adding != null) {
            figure.drawShape(graphics2D, drawDTO);

            adding = null;
        }
    }


    private void setButtons() {
        lineButton.setBounds(10, 10, 100, 25);
        lineButton.setText("Line");
        triangleButton.setBounds(120, 10, 100, 25);
        triangleButton.setText("Triangle");
        circleButton.setBounds(230, 10, 100, 25);
        circleButton.setText("Circle");
        confirmButton.setBounds(460, 10, 100, 25);
        confirmButton.setText("Add");
        x1Field.setBounds(460, 45, 45, 25);
        y1Field.setBounds(515, 45, 45, 25);
        x2Field.setBounds(460, 80, 45, 25);
        y2Field.setBounds(515, 80, 45, 25);
        x3Field.setBounds(460, 115, 45, 25);
        y3Field.setBounds(515, 115, 45, 25);
        lineButton.addActionListener(e -> setLine());
        triangleButton.addActionListener(e -> setTriangle());
        circleButton.addActionListener(e -> setCircle());
        confirmButton.addActionListener(e -> drawShape());

        this.add(lineButton);
        this.add(triangleButton);
        this.add(circleButton);
        this.add(confirmButton);
        this.setLayout(null);
        this.add(x1Field);
        this.add(y1Field);
        this.add(x2Field);
        this.add(y2Field);
        this.add(x3Field);
        this.add(y3Field);

    }

    private void drawShape() {
        drawDTO = new DrawDTO();
        drawDTO.setX1(toNumber(x1Field.getText()));
        drawDTO.setX2(toNumber(x2Field.getText()));
        drawDTO.setX3(toNumber(x3Field.getText()));
        drawDTO.setY1(toNumber(y1Field.getText()));
        drawDTO.setY2(toNumber(y2Field.getText()));
        drawDTO.setY3(toNumber(y3Field.getText()));
        adding = "do it";
        repaint();
    }

    private int toNumber(String s) {
        int d;
        try {
            d = Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return 0;
        }
        return d;
    }

    private void setCircle() {
        this.figure = new CircleComponent();
        this.type = 2;
        System.out.println("Im a circle");
    }

    private void setTriangle() {
        this.figure = new TriangleComponent();
        this.type = 1;
        System.out.println("Im a triangle");

    }

    private void setLine() {
        this.figure = new LineComponent();
        this.type = 0;
        System.out.println("Im a line");
    }


}
