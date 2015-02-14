package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import tools.StaticTool;

import main.MainFrame;

public class FaceJPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel labelCountG = new JLabel();

	private JLabel labelCountS = new JLabel();

	private JLabel labelCountB = new JLabel();

	private JLabel labelTimeG = new JLabel();

	private JLabel labelTimeS = new JLabel();

	private JLabel labelTimeB = new JLabel();

	private JLabel labelFace = new JLabel();

	MainFrame mainFrame;

	public JLabel getLabelFace() {
		return labelFace;
	}

	public FaceJPanel(MainFrame frame) {
		this.mainFrame = frame;
		this.setLayout(new BorderLayout());

		init();

	}

	private void init() {
		JPanel panel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.LINE_AXIS);
		panel.setLayout(boxLayout);

		FaceLableListener faceLableListener;
		faceLableListener = new FaceLableListener();
		panel.addMouseListener(faceLableListener);

		Icon icon0 = new ImageIcon("./image/d0.gif");
		Icon icon1 = new ImageIcon("./image/d" + StaticTool.allcount / 10
				+ ".gif");
		Icon icon2 = new ImageIcon("./image/d" + StaticTool.allcount % 10
				+ ".gif");
		Icon iconSmile = new ImageIcon("./image/face0.gif");
		labelCountG.setIcon(icon2);
		labelCountS.setIcon(icon1);
		labelCountB.setIcon(icon0);

		labelTimeS.setIcon(icon0);
		labelTimeG.setIcon(icon0);
		labelTimeB.setIcon(icon0);

		labelFace.setIcon(iconSmile);

		panel.add(Box.createHorizontalStrut(2));
		panel.add(labelCountB);
		panel.add(labelCountS);
		panel.add(labelCountG);
		panel.add(Box.createHorizontalGlue());
		panel.add(labelFace);
		panel.add(Box.createHorizontalGlue());
		panel.add(labelTimeB);
		panel.add(labelTimeS);
		panel.add(labelTimeG);
		panel.add(Box.createHorizontalStrut(2));

		Border borderLow = BorderFactory.createLoweredBevelBorder();

		Border borderEmpty = BorderFactory.createEmptyBorder(2, 2, 2, 2);
		Border borderCom1 = BorderFactory.createCompoundBorder(borderLow,
				borderEmpty);

		panel.setBorder(borderCom1);
		panel.setBackground(Color.LIGHT_GRAY);

		this.add(panel);
		Border borderEmpty2 = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		this.setBorder(borderEmpty2);
		this.setBackground(Color.LIGHT_GRAY);

	}

	public void setTime(int count) {
		int g = count % 10;
		int s = count / 10 % 10;
		int b = count / 100;

		labelTimeG.setIcon(StaticTool.time[g]);
		labelTimeS.setIcon(StaticTool.time[s]);
		labelTimeB.setIcon(StaticTool.time[b]);

	}

	public void setNumber(int count) {
		int b = 0;
		if (count < 0) {

			b = 10;

		} else {

			b = count / 100;
		}

		int g = Math.abs(count) % 10;
		int s = Math.abs(count) / 10 % 10;

		labelCountG.setIcon(StaticTool.time[g]);
		labelCountS.setIcon(StaticTool.time[s]);
		labelCountB.setIcon(StaticTool.time[b]);

	}

	public class FaceLableListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
				labelFace.setIcon(StaticTool.downSmileIcon);
				mainFrame.getTimer().stop();
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
				mainFrame.reStartGame();
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.getModifiers() == InputEvent.BUTTON1_MASK) {

				mainFrame.getTimer().start();
				labelFace.setIcon(StaticTool.smileIcon);
			}
		}

	}

}
