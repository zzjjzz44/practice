import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Saolei extends JFrame {

    static final int ROWS = 10;
    static final int COLS = 10;
    static final int MINES = 10;

    int[][] mineField = new int[ROWS][COLS];
    int[][] hintNumbers = new int[ROWS][COLS];
    JButton[][] buttons = new JButton[ROWS][COLS];
    boolean gameOver = false;
    int remainingMines = MINES;
    int[][] cellState = new int[ROWS][COLS];

    JPanel mainPanel = new JPanel(new GridBagLayout());
    JPanel gamePanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();


    public Saolei() {
        super("扫雷游戏");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
            init();


    }
    void init() {
        gamePanel.removeAll();
        gamePanel.setLayout(new GridBagLayout());


        gbc.insets = new Insets(3, 3, 3, 3);


        JButton b1 = new JButton("开始游戏 ");
        JButton b2 = new JButton("设置难度 ");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.5;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(b1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;

        gbc.weightx = 1.5;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(b2, gbc);

        add(mainPanel);

    b1.addActionListener(e -> gamestart());



    setSize(1000, 600);
    setLocationRelativeTo(null);
    setVisible(true);

    }

    void gamestart () {
            mainPanel.removeAll();
            mainPanel.setLayout(new GridBagLayout());

            //setContentPane(gamePanel);

            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    buttons[i][j] = new JButton();
                    buttons[i][j].setFont(new Font("Arial", Font.BOLD, 20));
                    buttons[i][j].addActionListener(e -> handleClick(e));
                    int finalI = i;
                    int finalJ = j;
                    buttons[i][j].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            if (SwingUtilities.isRightMouseButton(e)) {
                                toggleFlag(finalI, finalJ);
                            }
                        }
                    });
                    gbc.anchor = GridBagConstraints.CENTER;
                    gbc.gridx = j;
                    gbc.gridy = i;
                    gbc.weightx = 0.5;
                    gbc.weighty = 0.5;
                    gbc.insets = new Insets(1, 1, 1, 1);
                    buttons[i][j].setPreferredSize(new Dimension(10, 10));
                    gbc.fill = GridBagConstraints.BOTH;
                    gamePanel.add(buttons[i][j], gbc);
                }
            }

            /*JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
            statusBar.add(new JLabel("剩余地雷: " + remainingMines));
            statusBar.add(new JLabel("时间: "));

            add(statusBar);*/



            gbc.fill = GridBagConstraints.BOTH;
            add(gamePanel, gbc);

            // 初始化游戏
            initGame();


            gamePanel.setSize(890, 600);
            revalidate();
            repaint();
    }


    void handleClick(ActionEvent e) {
        if (gameOver) return;

        JButton btn = (JButton) e.getSource();
        int x = btn.getParent().getComponentZOrder(btn) / COLS;
        int y = btn.getParent().getComponentZOrder(btn) % COLS;

        if (cellState[x][y] == 1) return; // 已翻开

        if (mineField[x][y] == -1) { // 踩雷
            btn.setText("*");
            gameOver = true;
            revealAllMines();
            int option = JOptionPane.showConfirmDialog(
                    this,
                    "很遗憾，你踩到地雷了！\n是否重新开始游戏？",
                    "游戏结束",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.ERROR_MESSAGE
            );
            if (option == JOptionPane.YES_OPTION) {
                init();
            } else {
                System.exit(0);
            }

        }
        else {
            revealCell(x, y);
            checkwin();
        }
    }


    void initGame() {
        remainingMines = MINES;
        gameOver = false;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                mineField[i][j] = 0;
                hintNumbers[i][j] = 0;
                cellState[i][j] = 0;
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }

        Random r = new Random();
        int placedMines = 0;
        while (placedMines < MINES) {
            int x = r.nextInt(0,ROWS);
            int y = r.nextInt(0,COLS);
            if (mineField[x][y] != -1) {
                mineField[x][y] = -1;
                placedMines++;
            }
        }
        calculateHints();
    }



    void calculateHints() {
    for(int i = 0; i < ROWS; i++)
    {
        for (int j = 0; j < COLS; j++) {
            int c=0;
            if(mineField[i][j]==-1){
                hintNumbers[i][j]=-1;
                continue;
            }
            for(int x=-1;x<=1;x++){
                for(int y=-1;y<=1;y++){
                    if(x+i>=0&&y+j>=0&&x+i<ROWS&&y+j<COLS){
                        if(mineField[x+i][y+j]==-1){
                            c++;
                        }
                    }
                }
            }
            hintNumbers[i][j]=c;
        }
    }
}


    void revealCell(int x, int y) {
        if (x < 0 || y < 0 || x >= ROWS || y >= COLS || cellState[x][y] == 1) return;
        cellState[x][y] = 1;
        buttons[x][y].setText(String.valueOf(hintNumbers[x][y]));
        buttons[x][y].setEnabled(false);
        if (hintNumbers[x][y] == 0) {
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    revealCell(x + dx, y + dy);
                }
            }
        }
    }


    void toggleFlag(int x, int y) {
        if (cellState[x][y] == 0) {
            buttons[x][y].setText("F");
            cellState[x][y] = 2; // 标记
            remainingMines--;
        } else if (cellState[x][y] == 2) {
            buttons[x][y].setText("");
            cellState[x][y] = 0;
            remainingMines++;// 取消标记
        }
    }

    void revealAllMines() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (mineField[i][j] == -1) {
                    buttons[i][j].setText("*");
                }
            }
        }
    }


    void checkwin(){
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(mineField[i][j]!=-1&&cellState[i][j]!=1){
                    return;
                }
            }
        }
        gameOver=true;
        JOptionPane.showMessageDialog(this,"恭喜你赢了！");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->new Saolei());
    }
}
