package listenner;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import main.MainFrame;

import tools.LayBomb;
import tools.StaticTool;

import bean.HeroBean;
import bean.MineLable;

public class Listener implements MouseListener {
	MineLable[][] mineLable;
	MainFrame mainFrame;
	private boolean isDoublePress = false;

	public Listener(MineLable[][] mineLable, MainFrame mainFrame) {
		this.mineLable = mineLable;
		this.mainFrame = mainFrame;

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		MineLable mineLable = (MineLable) e.getSource();

		int row = mineLable.getRowx();
		int col = mineLable.getColy();

		if (e.getModifiersEx() == InputEvent.BUTTON1_DOWN_MASK
				+ InputEvent.BUTTON3_DOWN_MASK) {
			isDoublePress = true;
			doublePress(row, col);

		} else if (e.getModifiers() == InputEvent.BUTTON1_MASK
				&& mineLable.isFlagTag() == false) {
			if (mineLable.isExpendTag() == false) {
				mineLable.setIcon(StaticTool.icon0);

			}
			mainFrame.getFaceJPanel().getLabelFace()
					.setIcon(StaticTool.clickIcon);
		} else if (e.getModifiers() == InputEvent.BUTTON3_MASK
				&& mineLable.isExpendTag() == false) {
			if (mineLable.getRightClickCount() == 0) {
				mineLable.setIcon(StaticTool.flagIcon);
				mineLable.setRightClickCount(1);
				mineLable.setFlagTag(true);
				StaticTool.bombCount--;
				mainFrame.getFaceJPanel().setNumber(StaticTool.bombCount);

			} else if (mineLable.getRightClickCount() == 1) {
				mineLable.setIcon(StaticTool.askIcon);
				mineLable.setRightClickCount(2);
				mineLable.setFlagTag(false);
				StaticTool.bombCount++;
				mainFrame.getFaceJPanel().setNumber(StaticTool.bombCount);

			} else {
				mineLable.setIcon(StaticTool.iconBlank);
				mineLable.setRightClickCount(0);
			}

		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		MineLable mineLable = (MineLable) e.getSource();
		int row = mineLable.getRowx();
		int col = mineLable.getColy();
		if (isDoublePress) {
			isDoublePress = false;
			if (mineLable.isExpendTag() == false
					&& mineLable.isFlagTag() == false) {
				backIcon(row, col);
			} else {

				boolean isEquals = isEquals(row, col);
				if (isEquals) {
					doubleExpend(row, col);
				} else {
					backIcon(row, col);

				}

			}
			mainFrame.getFaceJPanel().getLabelFace()
					.setIcon(StaticTool.smileIcon);

		} else if (e.getModifiers() == InputEvent.BUTTON1_MASK
				&& mineLable.isFlagTag() == false) {
			if (StaticTool.isStart == false) {
				LayBomb.lay(this.mineLable, row, col);

				StaticTool.isStart = true;

			}
			mainFrame.getTimer().start();

			if (mineLable.isMineTag() == true) {

				bombAction(row, col);

				mineLable.setIcon(StaticTool.bloodIcon);
				mainFrame.getFaceJPanel().getLabelFace()
						.setIcon(StaticTool.faultFaceIcon);
			} else {
				mainFrame.getFaceJPanel().getLabelFace()
						.setIcon(StaticTool.smileIcon);
				expand(row, col);

			}

		}

		isWin();
	}

	private void bombAction(int row, int col) {

		for (int i = 0; i < mineLable.length; i++) {
			for (int j = 0; j < mineLable[i].length; j++) {
				if (mineLable[i][j].isMineTag()) {
					if (mineLable[i][j].isFlagTag() == false) {
						mineLable[i][j].setIcon(StaticTool.blackBombIcon);
					}
				} else {
					if (mineLable[i][j].isFlagTag()) {
						mineLable[i][j].setIcon(StaticTool.errorBombIcon);
					}
				}
			}

		}

		mainFrame.getTimer().stop();

		for (int i = 0; i < mineLable.length; i++) {
			for (int j = 0; j < mineLable[i].length; j++) {
				mineLable[i][j].removeMouseListener(this);

			}
		}

	}

	private void expand(int x, int y) {

		int count = mineLable[x][y].getCounAround();

		if (mineLable[x][y].isExpendTag() == false
				&& mineLable[x][y].isFlagTag() == false) {

			if (count == 0) {
				mineLable[x][y].setIcon(StaticTool.num[count]);
				mineLable[x][y].setExpendTag(true);
				for (int i = Math.max(0, x - 1); i <= Math.min(
						mineLable.length - 1, x + 1); i++) {
					for (int j = Math.max(0, y - 1); j <= Math.min(
							mineLable[x].length - 1, y + 1); j++) {
						expand(i, j);

					}

				}

			} else {

				mineLable[x][y].setIcon(StaticTool.num[count]);
				mineLable[x][y].setExpendTag(true);

			}

		}

	}

	private void backIcon(int i, int j) {
		for (int x = Math.max(0, i - 1); x <= Math.min(StaticTool.allrow - 1,
				i + 1); x++) {
			for (int y = Math.max(0, j - 1); y <= Math.min(
					StaticTool.allcol - 1, j + 1); y++) {
				if (mineLable[x][y].isFlagTag() == false
						&& mineLable[x][y].isExpendTag() == false) {
					int rightClickCount = mineLable[x][y].getRightClickCount();
					if (rightClickCount == 2) {
						mineLable[x][y].setIcon(StaticTool.askIcon);
					} else {
						mineLable[x][y].setIcon(StaticTool.iconBlank);

					}
				}
			}
		}

	}

	private boolean isEquals(int i, int j) {
		int count = mineLable[i][j].getCounAround();
		int flagCount = 0;
		for (int x = Math.max(0, i - 1); x <= Math.min(StaticTool.allrow - 1,
				i + 1); x++) {
			for (int y = Math.max(0, j - 1); y <= Math.min(
					StaticTool.allcol - 1, j + 1); y++) {
				if (mineLable[x][y].isFlagTag()) {
					flagCount++;
				}
			}
		}
		if (count == flagCount) {
			return true;
		}
		return false;
	}

	private void doublePress(int i, int j) {
		for (int x = Math.max(0, i - 1); x <= Math.min(StaticTool.allrow - 1,
				i + 1); x++) {
			for (int y = Math.max(0, j - 1); y <= Math.min(
					StaticTool.allcol - 1, j + 1); y++) {
				if (mineLable[x][y].isExpendTag() == false
						&& mineLable[x][y].isFlagTag() == false) {
					int rightClickCount = mineLable[x][y].getRightClickCount();
					if (rightClickCount == 1) {
						mineLable[x][y].setIcon(StaticTool.askPressIcon);

					} else {
						mineLable[x][y].setIcon(StaticTool.icon0);

					}
				}
			}
		}
	}

	private void doubleExpend(int i, int j) {
		for (int x = Math.max(0, i - 1); x <= Math.min(StaticTool.allrow - 1,
				i + 1); x++) {
			for (int y = Math.max(0, j - 1); y <= Math.min(
					StaticTool.allcol - 1, j + 1); y++) {
				if (mineLable[x][y].isMineTag()) {
					if (mineLable[x][y].isFlagTag() == false) {
						bombAction(x, y);

					}
				} else {

					if (mineLable[x][y].isFlagTag() == false) {
						expand(x, y);
					}

				}

			}
		}

	}

	private void isWin() {

		int needCount = StaticTool.allrow * StaticTool.allcol
				- StaticTool.allcount;
		int expendCount = 0;
		for (int i = 0; i < mineLable.length; i++) {
			for (int j = 0; j < mineLable[i].length; j++) {
				if (mineLable[i][j].isExpendTag()) {
					expendCount++;
				}

			}

		}
		if (needCount == expendCount) {
			for (int i = 0; i < mineLable.length; i++) {
				for (int j = 0; j < mineLable[i].length; j++) {
					if (mineLable[i][j].isMineTag()
							&& mineLable[i][j].isFlagTag() == false) {
						mineLable[i][j].setIcon(StaticTool.flagIcon);
						mineLable[i][j].setFlagTag(true);
					}

				}

			}

			mainFrame.getFaceJPanel().setNumber(0);
			mainFrame.getTimer().stop();
			for (int i = 0; i < mineLable.length; i++) {
				for (int j = 0; j < mineLable[i].length; j++) {
					mineLable[i][j].removeMouseListener(this);

				}
			}

			mainFrame.getFaceJPanel().getLabelFace()
					.setIcon(StaticTool.winFaceIcon);
			int level = StaticTool.getLevel();
			if (level != 0) {
				if (level == 1) {
					String name = JOptionPane.showInputDialog(mainFrame,
							"好厉害！初级扫雷完成，请留下大名！");
					if (name != null) {
						StaticTool.treeSetC.add(new HeroBean(
								StaticTool.timecount, name));
					}
				} else if (level == 2) {
					String name = JOptionPane.showInputDialog(mainFrame,
							"好厉害！中级扫雷完成，请留下大名！");
					if (name != null) {
						StaticTool.treeSetZ.add(new HeroBean(
								StaticTool.timecount, name));
					}
				} else if (level == 3) {
					String name = JOptionPane.showInputDialog(mainFrame,
							"好厉害！高级扫雷完成，请留下大名！");
					if (name != null) {
						StaticTool.treeSetG.add(new HeroBean(
								StaticTool.timecount, name));
					}
				}

			}

		}

	}

}
