package org.example;

import org.math.plot.canvas.Plot3DCanvas;
import org.math.plot.render.AWTDrawer2D;
import org.math.plot.render.Projection3D;
import org.uma.jmetal.lab.visualization.html.Html;
import org.uma.jmetal.lab.visualization.html.HtmlComponent;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        double[] c1 = {0.0,1.1};
        double[] c2 = {1.0,0.0};
        double[] c3 = {0.6,0.4,0.9};

        Plot3DCanvas plot3DCanvas = new Plot3DCanvas();

        plot3DCanvas.add(new Label("Particle's Layers"));

        plot3DCanvas.addLinePlot("X vs Y",Color.RED, c1, c2,c3);
        //plot3DCanvas.addBarPlot("ASPECT",Color.BLUE, c3);
        //plot3DCanvas.addScatterPlot("SS",Color.BLUE,c1,c2,c3);
        plot3DCanvas.getGrid().setColor(Color.RED);
        //create a projection then give it a plot
        Projection3D projection3D = new Projection3D(new AWTDrawer2D(plot3DCanvas));

        double sin_p = projection3D.sin_phi;
        double cos_th = projection3D.cos_theta;
        //create a frame
        JFrame frame = new JFrame();

        frame.setSize(800, 600);

        frame.setVisible(true);

        frame.setTitle("Plot3D by Andy Duverneau");

        frame.add(plot3DCanvas);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Html html = new Html("Plot3D");


        html.addComponent(new HtmlComponent() {
            @Override
            public String getHtml() {

                return  "<p>Sin phi: " + sin_p + "</p>"+
                        "Cos phi: " + cos_th
                        + "<p>This is an example of a simple HTML component.</p>"
                        + "<table>"
                        + "<tr>"
                        + "<th>Column 1</th>"
                        + "<th>Column 2</th>"
                        + "</tr>"
                        + "<tr>"
                        + "<td>Row 1, Column 1</td>"
                        + "<td>Row 1, Column 2</td>"
                        + "</tr>"
                        + "<tr>"
                        + "<td>Row 2, Column 1</td>"
                        + "<td>Row 2, Column 2</td>"
                        + "</tr>"
                        + "</table>"+2+"</>";

            }

            @Override
            public String getCSS() {
                return null;
            }
        });
        html.show();



    }
}
