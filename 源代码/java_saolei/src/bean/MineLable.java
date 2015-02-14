package bean;

import javax.swing.JLabel;

public class MineLable extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean mineTag;
	private boolean expendTag;
	private boolean flagTag;
	private int rowx;
	private int coly;
	private int counAround;
	private int rightClickCount;

	public MineLable(int x, int y) {
		this.rowx = x;
		this.coly = y;

	}

	public boolean isMineTag() {
		return mineTag;
	}

	public void setMineTag(boolean mineTag) {
		this.mineTag = mineTag;
	}

	public boolean isExpendTag() {
		return expendTag;
	}

	public void setExpendTag(boolean expendTag) {
		this.expendTag = expendTag;
	}

	public boolean isFlagTag() {
		return flagTag;
	}

	public void setFlagTag(boolean flagTag) {
		this.flagTag = flagTag;
	}

	public int getRowx() {
		return rowx;
	}

	public void setRowx(int rowx) {
		this.rowx = rowx;
	}

	public int getColy() {
		return coly;
	}

	public void setColy(int coly) {
		this.coly = coly;
	}

	public int getCounAround() {
		return counAround;
	}

	public void setCounAround(int counAround) {
		this.counAround = counAround;
	}

	public int getRightClickCount() {
		return rightClickCount;
	}

	public void setRightClickCount(int rightClickCount) {
		this.rightClickCount = rightClickCount;
	}

}
