package dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import tools.StaticTool;

import main.MainFrame;

public class AboutSweeping extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel labelIcon;

	private JLabel labelOne;

	private JLabel labelTwo;

	private JLabel labelThree;

	private JLabel labelFour;

	private JLabel labelFive;

	private Box boxOne;

	private Box boxTwo;

	private Box boxThree;

	private Box boxFour;

	private Box boxFive;

	private JPanel panelT;

	AboutSweeping sweeping = null;

	public AboutSweeping(MainFrame mainFrame) {

		super(mainFrame);
		sweeping = this;
		this.setTitle("关于扫雷");
		this.add(getPanel());
		this.setSize(new Dimension(300, 200));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);

	}

	private JPanel getPanel() {
		JPanel panel = new JPanel();
		labelIcon = new JLabel(StaticTool.imageIcon);
		labelOne = new JLabel("扫雷，聪明者的游戏！");
		boxOne = Box.createHorizontalBox();
		boxOne.add(labelIcon);
		boxOne.add(Box.createHorizontalStrut(20));
		boxOne.add(labelOne);
		labelTwo = new JLabel("作品说明：javaSE项目    ");
		boxTwo = Box.createHorizontalBox();
		boxTwo.add(labelTwo);
		labelThree = new JLabel("指导老师：捷盈教育--李龙");
		boxThree = Box.createHorizontalBox();
		boxThree.add(labelThree);
		labelFour = new JLabel("版权所有：fjut--刘向峰  ");
		boxFour = Box.createHorizontalBox();
		boxFour.add(labelFour);
		labelFive = new JLabel("制作时间：2012.6.1      ");
		boxFive = Box.createHorizontalBox();
		boxFive.add(labelFive);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(boxOne);
		panel.add(boxTwo);
		panel.add(boxThree);
		panel.add(boxFour);
		panel.add(boxFive);
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sweeping.dispose();

			}
		});
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel1.add(button);
		panel.add(panel1);
		Border border = BorderFactory.createEtchedBorder();
		panel.setBorder(border);
		panelT = new JPanel(new BorderLayout());
		Border border2 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		panelT.add(panel);
		panelT.setBorder(border2);

		return panelT;

	}

}
