package dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import main.MainFrame;

import tools.StaticTool;

import bean.HeroBean;

public class HeroDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private JPanel panel = null;
	JTextArea textArea = new JTextArea();
	private int level = 0;

	public HeroDialog(int level, MainFrame mainFrame) {
		super(mainFrame);
		this.level = level;
		this.setTitle("É¨À×Ó¢ÐÛ°ñ");
		this.add(getPanel());
		this.setSize(new Dimension(220, 150));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);
	}

	public JPanel getPanel() {
		textArea.setEditable(false);
		textArea.setLineWrap(true);

		JScrollPane scrollPane = new JScrollPane(textArea);
		addMessage();
		panel = new JPanel(new BorderLayout());
		panel.add(scrollPane);
		return panel;
	}

	private void addMessage() {
		if (level == 1) {
			for (HeroBean heroBean : StaticTool.treeSetC) {
				textArea.append(heroBean.toString() + "\n");
			}

		} else if (level == 2) {
			for (HeroBean heroBean : StaticTool.treeSetZ) {
				textArea.append(heroBean.toString() + "\n");
			}
		} else {
			for (HeroBean heroBean : StaticTool.treeSetG) {
				textArea.append(heroBean.toString() + "\n");
			}
		}
	}

}
