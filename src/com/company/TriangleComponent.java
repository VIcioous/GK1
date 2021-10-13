package com.company;


import javax.swing.*;
import java.awt.*;

public class TriangleComponent extends JComponent implements Figure {


    @Override
    public void draw(Graphics g, Point startPoint, Point endPoint) {

        int width = Math.abs(startPoint.x - endPoint.x);
        int height = Math.abs(startPoint.y - endPoint.y);


        if (startPoint.y > endPoint.y && startPoint.x > endPoint.x) {
            g.drawLine(startPoint.x, startPoint.y, endPoint.x + width / 2, endPoint.y);
            g.drawLine(startPoint.x, startPoint.y, startPoint.x - width, startPoint.y);
            g.drawLine(endPoint.x + width / 2, endPoint.y, startPoint.x - width, startPoint.y);
        } else if (startPoint.x > endPoint.x) {
            g.drawLine(startPoint.x, startPoint.y + height, endPoint.x, endPoint.y);
            g.drawLine(startPoint.x, startPoint.y + height, startPoint.x - width / 2, startPoint.y);
            g.drawLine(endPoint.x, endPoint.y, startPoint.x - width / 2, startPoint.y);
        } else if (startPoint.y > endPoint.y) {
            g.drawLine(startPoint.x, startPoint.y, endPoint.x - width / 2, endPoint.y);
            g.drawLine(startPoint.x, startPoint.y, startPoint.x + width, startPoint.y);
            g.drawLine(endPoint.x - width / 2, endPoint.y, startPoint.x + width, startPoint.y);
        } else {

            g.drawLine(startPoint.x, startPoint.y + height, endPoint.x, endPoint.y);
            g.drawLine(startPoint.x, startPoint.y + height, startPoint.x + (width / 2), startPoint.y);
            g.drawLine(endPoint.x, endPoint.y, startPoint.x + (width / 2), startPoint.y);
        }

    }

    @Override
    public void drawShape(Graphics g, DrawDTO drawDTO) {
        g.drawLine(drawDTO.getX1(), drawDTO.getY1(), drawDTO.getX2(), drawDTO.getY2());
        g.drawLine(drawDTO.getX3(), drawDTO.getY3(), drawDTO.getX2(), drawDTO.getY2());
        g.drawLine(drawDTO.getX1(), drawDTO.getY1(), drawDTO.getX3(), drawDTO.getY3());
    }
}
