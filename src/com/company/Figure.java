package com.company;

import java.awt.*;

public interface Figure {


    void draw(Graphics g, Point startPoint, Point endPoint);

    void drawShape(Graphics g, DrawDTO drawDTO);
}
