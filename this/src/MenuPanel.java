import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
public class MenuPanel extends JPanel
{
    private String imgName;
    public MenuPanel(String image)
    {
        super();
        setLayout(null);
        setSize(1280, 720);
        imgName = image;
        setVisible(true);
    }
    public void paintComponent(Graphics g)
    {
        if(!imgName.equals(""))
        {
            try
            {
                MediaTracker mt = new MediaTracker (this);
                Image intro = Toolkit.getDefaultToolkit().getImage(imgName);
                mt.addImage(intro, 0);
                mt.waitForID(0);
                g.drawImage(intro, 0, 0, this);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
