package pack3;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import pack2.Constants;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel imageLabel;
	private ImageIcon transformedImageIcon;

	public ImagePanel() {

		this.imageLabel = new JLabel();

		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(Constants.IMAGE_LABEL_BORDER, Constants.IMAGE_LABEL_BORDER
				,Constants.IMAGE_LABEL_BORDER, Constants.IMAGE_LABEL_BORDER));

		add(imageLabel, BorderLayout.CENTER);

	}
	
	public void updateImage(final Image image){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				imageLabel.setIcon(new ImageIcon(scaleImage(image)));
			}
		});
	}
	
	private Image scaleImage(Image image){
		return image.getScaledInstance(700, 500,Image.SCALE_SMOOTH);
	}

	public void loadImage(File file) {

		this.transformedImageIcon = new ImageIcon(file.getAbsolutePath());
		Image image = transformedImageIcon.getImage();
		
		updateImage(image);
	}
}
