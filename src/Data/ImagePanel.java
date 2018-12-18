package Data;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class ImagePanel extends JPanel {
	public Image img;
	public static boolean isDraw;
	public ImagePanel() {}
        
	public ImagePanel(Image ximg) {
		img = ximg;
	}
	public void setImage(Image img) {
		this.img = img;
		repaint();
	}
	public Image getImage() {
		return img;
	}
	public void paint(Graphics g) {
		if(img != null) {
			isDraw = true;
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), 0, 0, img.getWidth(this), img.getHeight(this), this);
		}
		else { 
			isDraw = false;
			g.fillRect(0, 0, getWidth(), getHeight());
		}
		
	}
}