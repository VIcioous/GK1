package com.company;

import javax.swing.*;
import java.awt.*;

public class LineComponent extends JComponent implements Figure {

    private Point startPoint;
    private Point endPoint;

    @Override
    public void draw(Graphics g, Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }

    @Override
    public void drawShape(Graphics g, DrawDTO drawDTO) {
        startPoint.setLocation(drawDTO.getX1(), drawDTO.getY1());
        endPoint.setLocation(drawDTO.getX2(), drawDTO.getY2());
        g.drawLine(drawDTO.getX1(), drawDTO.getY1(), drawDTO.getX2(), drawDTO.getY2());

    }
}
