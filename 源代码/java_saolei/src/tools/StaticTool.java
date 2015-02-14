package tools;

import java.util.TreeSet;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import bean.HeroBean;

public class StaticTool {

	public static int allcount = 10;
	public static int allcol = 9;
	public static int allrow = 9;
	public static int timecount = 0;
	public static int bombCount = allcount;

	public static boolean isStart = false;
	public static boolean isHole = false;

	public static Icon[] num = new Icon[10];
	public static Icon[] time = new Icon[11];

	public static ImageIcon imageIcon = new ImageIcon("./image/icon.gif");
	public static Icon iconBlank = new ImageIcon("./image/blank.gif");
	public static Icon bloodIcon = new ImageIcon("./image/blood.gif");
	public static Icon icon0 = new ImageIcon("./image/0.gif");
	public static Icon clickIcon = new ImageIcon("./image/face2.gif");
	public static Icon smileIcon = new ImageIcon("./image/face0.gif");
	public static Icon faultFaceIcon = new ImageIcon("./image/face3.gif");
	public static Icon winFaceIcon = new ImageIcon("./image/face4.gif");
	public static Icon flagIcon = new ImageIcon("./image/flag.gif");
	public static Icon askIcon = new ImageIcon("./image/ask.gif");
	public static Icon askPressIcon = new ImageIcon("./image/ask1.gif");
	public static Icon downSmileIcon = new ImageIcon("./image/face1.gif");
	public static Icon errorBombIcon = new ImageIcon("./image/error.gif");
	public static Icon blackBombIcon = new ImageIcon("./image/mine.gif");
	public static Icon holeIcon = new ImageIcon("./image/hole.gif");

	static {

		for (int i = 0; i < num.length; i++) {
			num[i] = new ImageIcon("./image/" + i + ".gif");
		}
		for (int j = 0; j <= num.length; j++) {
			time[j] = new ImageIcon("./image/d" + j + ".gif");
		}

	}

	public static TreeSet<HeroBean> treeSetC = new TreeSet<HeroBean>();
	public static TreeSet<HeroBean> treeSetZ = new TreeSet<HeroBean>();
	public static TreeSet<HeroBean> treeSetG = new TreeSet<HeroBean>();
	static {

		treeSetC.add(new HeroBean(999, "ÄäÃû"));
		treeSetZ.add(new HeroBean(999, "ÄäÃû"));
		treeSetG.add(new HeroBean(999, "ÄäÃû"));

	}

	public static int getLevel() {
		if (allrow == 9 && allcol == 9 && allcount == 10) {
			return 1;
		} else if (allrow == 16 && allcol == 16 && allcount == 40) {
			return 2;
		} else if (allrow == 16 && allcol == 30 && allcount == 99) {
			return 3;
		} else {
			return 0;
		}
	}

}
