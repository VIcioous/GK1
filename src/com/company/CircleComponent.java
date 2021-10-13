package com.company;

import javax.swing.*;
import java.awt.*;

public class CircleComponent extends JComponent implements Figure {



    @Override
    public void draw(Graphics g, Point startPoint, Point endPoint) {


        int width = Math.abs(startPoint.x - endPoint.x);
        int height = Math.abs(startPoint.y - endPoint.y);

        if (startPoint.y > endPoint.y && startPoint.x > endPoint.x) {
            g.drawOval(startPoint.x - width, startPoint.y - height, width, height);
        } else if (startPoint.x > endPoint.x)
            g.drawOval(startPoint.x - width, startPoint.y, width, height);
        else if (startPoint.y > endPoint.y) {
            g.drawOval(startPoint.x, startPoint.y - height, width, height);
        } else
            g.drawOval(startPoint.x, startPoint.y, width, height);


    }

    @Override
    public void drawShape(Graphics g, DrawDTO drawDTO) {
        g.drawOval(drawDTO.getX1(), drawDTO.getY1(), drawDTO.getX2(), drawDTO.getY2());
    }
}
