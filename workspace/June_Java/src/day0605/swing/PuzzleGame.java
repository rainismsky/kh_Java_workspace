package day0605.swing;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;

public class PuzzleGame extends JFrame implements ActionListener {
	JMenuBar mb = new JMenuBar();

	JMenu menu_game = new JMenu("게임");
	JMenu menu_level = new JMenu("난이도");
	JMenu menu_option = new JMenu("옵션");

	JMenuItem menu_game_new = new JMenuItem("새게임");
	JMenuItem menu_game_start = new JMenuItem("게임시작");
	JMenuItem menu_game_exit = new JMenuItem("게임종료");

	JMenuItem menu_level_3 = new JMenuItem("3 X 3");
	JMenuItem menu_level_4 = new JMenuItem("4 X 4");
	JMenuItem menu_level_5 = new JMenuItem("5 X 5");
	JMenuItem menu_level_6 = new JMenuItem("6 X 6");
	JMenuItem menu_level_7 = new JMenuItem("7 X 7");
	JMenuItem menu_level_8 = new JMenuItem("8 X 8");
	JMenuItem menu_level_9 = new JMenuItem("9 X 9");

	JMenuItem menu_option_score = new JMenuItem("점수목록");

	JMenuItem menu_option_full = new JMenuItem("전체그림보기");
	JMenuItem menu_option_cho = new JMenuItem("조각그림보기");

	String[][] name = new String[7][10];
	int[][] jumsu = new int[7][10];

	GamePan gp = new GamePan(name, jumsu);

	public PuzzleGame() {
		super("퍼즐게임");

		Container cp = getContentPane();

		menu_game.add(menu_game_new);
		menu_game.add(menu_game_start);
		menu_game.addSeparator();
		menu_game.add(menu_game_exit);

		menu_level.add(menu_level_3);
		menu_level.add(menu_level_4);
		menu_level.add(menu_level_5);
		menu_level.add(menu_level_6);
		menu_level.add(menu_level_7);
		menu_level.add(menu_level_8);
		menu_level.add(menu_level_9);

		menu_option.add(menu_option_score);

		menu_option.add(menu_option_full);

		mb.add(menu_game);
		mb.add(menu_level);
		mb.add(menu_option);

		setJMenuBar(mb);

		cp.add(gp);

		for (int a = 0; a < 7; a++) {
			for (int b = 0; b < 10; b++) {
				name[a][b] = "";
				jumsu[a][b] = 0;
			}
		}

		setBounds(200, 200, 500, 500);

		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		menu_game_new.addActionListener(this);
		menu_game_start.addActionListener(this);
		menu_game_exit.addActionListener(this);

		menu_level_3.addActionListener(this);
		menu_level_4.addActionListener(this);
		menu_level_5.addActionListener(this);
		menu_level_6.addActionListener(this);
		menu_level_7.addActionListener(this);
		menu_level_8.addActionListener(this);
		menu_level_9.addActionListener(this);

		menu_option_score.addActionListener(this);

		menu_option_full.addActionListener(this);
		menu_option_cho.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o == menu_game_new) {
			gp.bStart = false;
			gp.bFull = true;

			gp.cnt = 0;

			gp.getRand();
			gp.getRect();
			gp.repaint();
		} else if (o == menu_game_start) {
			gp.bStart = true;
			gp.bFull = false;
			gp.repaint();
		} else if (o == menu_game_exit) {
			System.exit(0);
		} else if (o == menu_level_3) {
			gp.chasu = 3;
			gp.getRand();
			gp.getRect();
			gp.repaint();
		} else if (o == menu_level_4) {
			gp.chasu = 4;
			gp.getRand();
			gp.getRect();
			gp.repaint();
		} else if (o == menu_level_5) {
			gp.chasu = 5;
			gp.getRand();
			gp.getRect();
			gp.repaint();
		} else if (o == menu_level_6) {
			gp.chasu = 6;
			gp.getRand();
			gp.getRect();
			gp.repaint();
		} else if (o == menu_level_7) {
			gp.chasu = 7;
			gp.getRand();
			gp.getRect();
			gp.repaint();
		} else if (o == menu_level_8) {
			gp.chasu = 8;
			gp.getRand();
			gp.getRect();
			gp.repaint();
		} else if (o == menu_level_9) {
			gp.chasu = 9;
			gp.getRand();
			gp.getRect();
			gp.repaint();
		} else if (o == menu_option_score) {
			ScoreList sl = new ScoreList(name, jumsu, gp.chasu - 3);
			sl.show();
		} else if (o == menu_option_full || o == menu_option_cho) {
			if (!gp.bStart)
				return;

			if (gp.bFull) {
				// menu_option_full.setText("조각그림보기");
				menu_option.remove(1);
				menu_option.insert(menu_option_full, 1);
			} else {
				// menu_option_full.setText("전체그림보기");
				menu_option.remove(1);
				menu_option.insert(menu_option_cho, 1);
			}

			gp.bFull = !gp.bFull;
			gp.repaint();
		}
	}

	public static void main(String[] args) {
		new PuzzleGame();
	}
}

class GamePan extends JPanel {
	Image img = Toolkit.getDefaultToolkit().getImage("src/day0605/swing/pooh.jpg");
	MediaTracker mt = new MediaTracker(this);

	int chasu;
	int width, high;
	Rectangle[][] panRect = new Rectangle[9][9];
	Rectangle[][] grimRect = new Rectangle[9][9];

	int[][] su = new int[9][9];

	int drow, dcol, brow, bcol;

	boolean bFull, bStart;

	int cnt = 0;
	int score;

	String[][] name;
	int[][] jumsu;

	RegDlg rd;
	int a;

	public GamePan(String[][] name, int[][] jumsu) {
		chasu = 3;
		width = 500;
		high = 500;
		bFull = true;
		bStart = false;

		this.name = name;
		this.jumsu = jumsu;

		mt.addImage(img, 0);

		try {
			mt.waitForAll(); // MediaTracker에 있는 모든 그림을 로딩한다.
		} catch (Exception e) {
		}

		getRand();
		getRect();

		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				width = getWidth();
				high = getHeight();

				getRect();
				repaint();
			}
		});

		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (!(e.getModifiers() == InputEvent.BUTTON1_MASK))
					return;

				cnt += 10;

				drawCheck(e);
			}
		});
	}

	public void drawCheck(MouseEvent e) {
		for (int a = 0; a < chasu; a++) {
			for (int b = 0; b < chasu; b++) {
				if (panRect[a][b].contains(e.getPoint())) {
					if (a == brow && b == bcol)
						return;

					su[brow][bcol] = su[a][b];
					su[a][b] = chasu * chasu - 1;

					drow = brow;
					dcol = bcol;
					brow = a;
					bcol = b;

					repaint();

					boolean bEnd = endCheck();

					if (bEnd) {
						int sel = JOptionPane.showConfirmDialog(this, "모자이크가 완성되었습니다", "게임종료",
								JOptionPane.DEFAULT_OPTION);

						rankCheck();

						getRect();
						getRand();
						repaint();
						return;
					}
				}
			}
		}
	}

	void getRand() {
		int[] imsi = new int[81];

		int rs;
		boolean bDasi;
		int rand = -1;
		Random random = new Random();
		for (int a = 0; a < chasu * chasu; a++) {
			bDasi = true;
			while (bDasi) {
				bDasi = false;
				rand = random.nextInt(chasu * chasu);
				for (int b = 0; b < a; b++) {
					if (rand == imsi[b])
						bDasi = true;
				}
			}
			imsi[a] = rand;
			su[a / chasu][a % chasu] = rand;

			if (rand == chasu * chasu - 1) {
				brow = a / chasu;
				bcol = a % chasu;
			}
		}
	}

	public void getRect() {
		for (int a = 0; a < chasu; a++) {
			for (int b = 0; b < chasu; b++) {
				panRect[a][b] = new Rectangle(b * width / chasu, a * high / chasu, width / chasu, high / chasu);

				grimRect[a][b] = new Rectangle(b * img.getWidth(this) / chasu, a * img.getHeight(this) / chasu,
						img.getWidth(this) / chasu, img.getHeight(this) / chasu);
			}
		}
	}

	public boolean endCheck() {
		int a, b, n = 0;
		for (a = 0; a < chasu; a++) {
			for (b = 0; b < chasu; b++) {
				if (su[a][b] != n)
					return false;
				n++;
			}
		}
		return true;
	}

	public void rankCheck() {

		score = 1000000 - cnt * 10;
		for (a = 0; a < 10; a++) {
			if (jumsu[chasu - 3][a] < score)
				break;
		}

		if (a == 10)
			return;

		rd = new RegDlg();
		rd.tf_rank.setText(new Integer(a + 1).toString());
		rd.tf_count.setText(new Integer(cnt).toString());
		rd.tf_score.setText(new Integer(score).toString());

		for (int b = 9; b > a; b--) {
			name[chasu - 3][b] = name[chasu - 3][b - 1];
			jumsu[chasu - 3][b] = jumsu[chasu - 3][b - 1];
		}

		rd.show();

		rd.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				name[chasu - 3][a] = rd.tf_name.getText();
				jumsu[chasu - 3][a] = score;
			}
		});
	}

	public void paint(Graphics g) {
		super.paint(g);

		if (bFull) {
			// g.drawImage(img,0,0,width,high,
			// 0,0,img.getWidth(this),img.getHeight(this),this);
			g.drawImage(img, 0, 0, width, high, this);
			return;
		}

		int x;
		int y;

		for (int a = 0; a < chasu; a++) {
			for (int b = 0; b < chasu; b++) {
				x = su[a][b] / chasu;
				y = su[a][b] % chasu;

				g.drawImage(img, panRect[a][b].x, panRect[a][b].y, b * panRect[a][b].width + panRect[a][b].width,
						a * panRect[a][b].height + panRect[a][b].height, grimRect[x][y].x, grimRect[x][y].y,
						y * grimRect[x][y].width + grimRect[x][y].width,
						x * grimRect[x][y].height + grimRect[x][y].height, this);
			}
		}

		g.fillRect(panRect[brow][bcol].x, panRect[brow][bcol].y, panRect[brow][bcol].width, panRect[brow][bcol].height);

	}

}

class ScoreList extends JFrame implements ItemListener {
	JLabel l1 = new JLabel("난이도별");
	JComboBox com = new JComboBox();

	String[][] data = new String[10][3];
	String[] cols = { "등수", "이름", "점수" };

	DefaultTableModel mod = new DefaultTableModel(data, cols);
	JTable table = new JTable(mod);

	String[][] name;
	int[][] jumsu;
	int chasu;

	public ScoreList(String[][] name, int[][] jumsu, int chasu) {
		super("리스트");

		this.name = name;
		this.jumsu = jumsu;
		this.chasu = chasu;

		Container cp = getContentPane();
		JScrollPane sp = new JScrollPane(table);

		com.addItem("3 X 3");
		com.addItem("4 X 4");
		com.addItem("5 X 5");
		com.addItem("6 X 6");
		com.addItem("7 X 7");
		com.addItem("8 X 8");
		com.addItem("9 X 9");

		JPanel p = new JPanel();
		p.add(l1);
		p.add(com);

		cp.add("North", p);
		cp.add("Center", sp);

		for (int a = 0; a < 10; a++) {
			data[a][0] = new Integer(a + 1).toString();
			data[a][1] = name[chasu][a];
			data[a][2] = new Integer(jumsu[chasu][a]).toString();
		}

		table.setModel(new DefaultTableModel(data, cols));

		pack();

		com.addItemListener(this);
	}

	public void itemStateChanged(ItemEvent e) {
		chasu = com.getSelectedIndex();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				data[i][j] = "";
			}
		}

		for (int a = 0; a < 10; a++) {
			data[a][0] = new Integer(a + 1).toString();
			data[a][1] = name[chasu][a];
			data[a][2] = new Integer(jumsu[chasu][a]).toString();
		}

		table.setModel(new DefaultTableModel(data, cols));
	}
}

class RegDlg extends JFrame {
	JLabel l1 = new JLabel("등        수");
	JLabel l2 = new JLabel("이동횟수");
	JLabel l3 = new JLabel("점        수");
	JLabel l4 = new JLabel("이        름");

	JTextField tf_rank = new JTextField(10);
	JTextField tf_count = new JTextField(10);
	JTextField tf_score = new JTextField(10);
	JTextField tf_name = new JTextField(10);

	JPanel[] p = new JPanel[4];
	JPanel p1 = new JPanel(new GridLayout(0, 1));

	public RegDlg() {
		super("등록");

		Container cp = getContentPane();

		for (int a = 0; a < p.length; a++) {
			p[a] = new JPanel();
		}

		p[0].add(l1);
		p[0].add(tf_rank);
		p[1].add(l2);
		p[1].add(tf_count);
		p[2].add(l3);
		p[2].add(tf_score);
		p[3].add(l4);
		p[3].add(tf_name);

		for (int a = 0; a < p.length; a++)
			p1.add(p[a]);

		cp.add(p1);

		tf_rank.setEnabled(false);
		tf_count.setEnabled(false);
		tf_score.setEnabled(false);
		tf_name.requestFocus();

		pack();

	}
}