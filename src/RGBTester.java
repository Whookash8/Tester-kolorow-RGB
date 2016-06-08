import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Łukasz on 2016-06-07.
 */
public class RGBTester
{
    static int red = 0;
    static int green = 0;
    static int blue = 0;
    static int alfa = 255;
    static Color mainColor = new Color(red , green , blue , alfa);

    JFrame mainFrame = new JFrame();

    JPanel colorPanel = new ColorPanel();
    JPanel selectionPanel = new JPanel();

    JSlider redSlider = new JSlider(SwingConstants.VERTICAL,0,255,0);
    JSlider greenSlider = new JSlider(SwingConstants.VERTICAL,0,255,0);
    JSlider blueSlider = new JSlider(SwingConstants.VERTICAL,0,255,0);
    JSlider alfaSlider = new JSlider(SwingConstants.VERTICAL,0,255,255);

    JLabel colorRedLabel = new JLabel("Red");
    JLabel colorGreenLabel = new JLabel("Green");
    JLabel colorBlueLabel = new JLabel("Blue");
    JLabel alfaLabel = new JLabel("Alfa");
    JLabel redValueLabel = new JLabel(Integer.toString(red));
    JLabel greenValueLabel = new JLabel(Integer.toString(green));
    JLabel blueValueLabel = new JLabel(Integer.toString(blue));
    JLabel alfaValueLabel = new JLabel(Integer.toString(alfa));

    Toolkit mainToolkit = Toolkit.getDefaultToolkit();
    GridBagConstraints GBC = new GridBagConstraints();
    Graphics gr = colorPanel.getGraphics();

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RGBTester();
            }
        });
    }

    RGBTester()
    {
        Dimension resolution = mainToolkit.getScreenSize();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(1,2));
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setLocation((int)resolution.getWidth()/2 - 250 , (int)resolution.getHeight()/2 - 150);
        mainFrame.setTitle("Tester kolorów RGB");

        redSlider.setSize(new Dimension(70,300));
        blueSlider.setSize(new Dimension(70,300));
        greenSlider.setSize(new Dimension(70,300));
        alfaSlider.setSize(new Dimension(70,300));

        redSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                red = redSlider.getValue();
                redValueLabel.setText(Integer.toString(red));
                mainColor = new Color(red , green , blue , alfa);
                colorPanel.repaint();
            }
        });

        greenSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                green = greenSlider.getValue();
                greenValueLabel.setText(Integer.toString(green));
                mainColor = new Color(red , green , blue , alfa);
                colorPanel.repaint();
            }
        });

        blueSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                blue = blueSlider.getValue();
                blueValueLabel.setText(Integer.toString(blue));
                mainColor = new Color(red , green , blue , alfa);
                colorPanel.repaint();
            }
        });

        alfaSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                alfa = alfaSlider.getValue();
                alfaValueLabel.setText(Integer.toString(alfa));
                mainColor = new Color(red , green , blue , alfa);
                colorPanel.repaint();
            }
        });

        selectionPanel.setSize(new Dimension(200,300));
        selectionPanel.setLayout(new GridBagLayout());

        GBC.anchor = GridBagConstraints.CENTER;
        GBC.ipadx = 20;
        selectionPanel.add(colorRedLabel , GBC);
        GBC.gridx = 1;
        selectionPanel.add(colorGreenLabel , GBC);
        GBC.gridx = 2;
        selectionPanel.add(colorBlueLabel , GBC);
        GBC.gridx = 3;
        selectionPanel.add(alfaLabel , GBC);

        GBC.gridx=0;
        GBC.gridy=1;
        selectionPanel.add(redSlider , GBC);
        GBC.gridx = 1;
        selectionPanel.add(greenSlider , GBC);
        GBC.gridx = 2;
        selectionPanel.add(blueSlider , GBC);
        GBC.gridx = 3;
        selectionPanel.add(alfaSlider , GBC);

        GBC.gridx=0;
        GBC.gridy=2;
        selectionPanel.add(redValueLabel , GBC);
        GBC.gridx = 1;
        selectionPanel.add(greenValueLabel , GBC);
        GBC.gridx = 2;
        selectionPanel.add(blueValueLabel , GBC);
        GBC.gridx = 3;
        selectionPanel.add(alfaValueLabel , GBC);

        mainFrame.add(colorPanel);
        mainFrame.add(selectionPanel);

        mainFrame.pack();
    }
}
