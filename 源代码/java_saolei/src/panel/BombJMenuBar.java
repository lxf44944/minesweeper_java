package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import dialog.AboutSweeping;
import dialog.HeroDialog;
import dialog.UserDefinedJDialog;

import tools.StaticTool;

import main.MainFrame;

public class BombJMenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JMenu menuGame = new JMenu("游戏(G)");

	JMenu menuHelp = new JMenu("帮助(H)");

	JMenuItem menuItemStart = new JMenuItem("开局");

	JMenuItem menuItemC = new JMenuItem("初级");

	JMenuItem menuItemZ = new JMenuItem("中级");

	JMenuItem menuItemG = new JMenuItem("高级");

	JMenu menuHero = new JMenu("英雄榜");
	JMenuItem menuHeroC = new JMenuItem("初级英雄榜");
	JMenuItem menuHeroZ = new JMenuItem("中级英雄榜");
	JMenuItem menuHeroG = new JMenuItem("高级英雄榜");
	JMenuItem menuItemCustom = new JMenuItem("自定义");
	JMenuItem menuItemExit = new JMenuItem("退出");

	JMenuItem menuItemAbout = new JMenuItem("关于扫雷");
	JMenuItem menuItemHole = new JMenuItem("后门进入");

	MainFrame mainFrame;

	public BombJMenuBar(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		init();
	}

	private void init() {
		menuGame.setMnemonic('G');// 设置快捷键 alt+ G 才会有效果
		menuHelp.setMnemonic('H');
		// 菜单项加入到菜单
		menuGame.add(menuItemStart);

		menuItemStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.reStartGame();
			}
		});

		menuGame.addSeparator();// 菜单加入分割线

		menuGame.add(menuItemC);
		menuItemC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StaticTool.allrow = 9;
				StaticTool.allcol = 9;
				StaticTool.allcount = 10;
				mainFrame.reStartGame();
			}
		});

		menuGame.add(menuItemZ);
		menuItemZ.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StaticTool.allrow = 16;
				StaticTool.allcol = 16;
				StaticTool.allcount = 40;
				mainFrame.reStartGame();
			}
		});

		menuGame.add(menuItemG);
		menuItemG.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StaticTool.allrow = 16;
				StaticTool.allcol = 30;
				StaticTool.allcount = 99;
				mainFrame.reStartGame();
			}
		});
		menuGame.addSeparator();// 菜单加入分割线
		menuGame.add(menuItemCustom);
		menuItemCustom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new UserDefinedJDialog(mainFrame);

			}
		});

		menuGame.addSeparator();// 菜单加入分割线
		menuGame.add(menuHero);
		menuHero.add(menuHeroC);
		menuHeroC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new HeroDialog(1, mainFrame);

			}
		});
		menuHero.add(menuHeroZ);
		menuHeroZ.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new HeroDialog(2, mainFrame);

			}
		});
		menuHero.add(menuHeroG);
		menuHeroG.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new HeroDialog(3, mainFrame);

			}
		});

		menuGame.addSeparator();// 菜单加入分割线
		menuGame.add(menuItemExit);
		menuItemExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);

			}
		});

		menuHelp.add(menuItemAbout);
		menuItemAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AboutSweeping(mainFrame);

			}
		});
		menuHelp.add(menuItemHole);
		menuItemHole.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				StaticTool.isHole = true;

			}
		});
		// 菜单加入到菜单条
		this.add(menuGame);
		this.add(menuHelp);

	}

}
