import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Łukasz on 2016-06-07.
 */
public class ColorPanel extends JPanel
{
    ColorPanel()
    {
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(300,300));
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(RGBTester.mainColor);

        g2d.fillRect(10,10,280,280);
    }
}
