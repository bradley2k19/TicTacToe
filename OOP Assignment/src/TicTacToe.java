import java.awt.*;

import javax.swing.*;

import javax.swing.border.Border;

import java.awt.event.*;

public class TicTacToe {
    int boardwith = 800;
    int boardheight = 600;
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;
    int playerXScore=0;
    int playerOScore=0;
    boolean gameOver = false;
    int turns = 0;

    JFrame frame = new JFrame("Tic-Tac-Toe");
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JPanel scorePanel = new JPanel();
    JButton restartButton = new JButton();
    JButton main_menuButton = new JButton();
    JLabel textLabel = new JLabel();
    JLabel Xscore = new JLabel();
    JLabel Oscore = new JLabel();
    JButton[][] board = new JButton[3][3];

    public TicTacToe(){

        ImageIcon image = new ImageIcon("tictactoe.jpg");

        frame.setVisible(true);
        frame.setSize(boardwith, boardheight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(null);
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground( new Color(12,30,62));
        
        textPanel.setBackground(new Color(12,30,62));
        textPanel.setBounds(0, 0,550,50);

        textLabel.setBackground(new Color(12,30,62));
        textLabel.setForeground(new Color(252, 15, 245));
        textLabel.setFont(new Font("MV Boli", Font.PLAIN, 37));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        textPanel.add(textLabel);
    
        boardPanel.setBounds(0, 50,550,510);
        
        scorePanel.setBackground(new Color(12,30,62));
        scorePanel.setBounds(560, 100,220,220);
        scorePanel.setFocusable(false);
        scorePanel.setLayout(null);

        Border border = BorderFactory.createLineBorder(new Color(142, 82, 245));
        scorePanel.setBorder(border);
         
        restartButton.setBackground(new Color(12,30,62));
        restartButton.setBorder(border);
        restartButton.setForeground(new Color(252, 15, 245));
        restartButton.setText("Restart");
        restartButton.setFocusable(false);
        restartButton.setBounds(560, 325, 90, 50);
       
        main_menuButton.setBackground(new Color(12,30,62));
        main_menuButton.setBorder(border);
        main_menuButton.setForeground(new Color(252, 15, 245));
        main_menuButton.setText("Main Menu");
        main_menuButton.setFocusable(false);
        main_menuButton.setBounds(685, 325, 95, 50);
        
        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(new Color(12,30,62));
        
        for(int r = 0 ; r < 3 ; r++){
            for(int c = 0 ; c < 3 ; c++){
                JButton tile = new JButton();
                board[r][c] = tile;
                boardPanel.add(tile);
                tile.setBackground(new Color(12,30,62));
                tile.setForeground(Color.white);
                tile.setFont(new Font("MV BOLI", Font.PLAIN,120));
                tile.setFocusable(false);
                //tile.setText(currentPlayer);
                check_Action(tile);
            }
        }
        
        Xscore.setBackground(new Color(12,30,62));
        Xscore.setForeground(new Color(252, 15, 245));
        Xscore.setFont(new Font("MV BOLI", Font.PLAIN, 20));
        Xscore.setText("Player X score : " + playerXScore );
        Xscore.setOpaque(true);
        Xscore.setBounds(10, 30, 200, 50);

        scorePanel.add(Xscore);

        Oscore.setBackground(new Color(12,30,62));
        Oscore.setForeground(new Color(252, 15, 245));
        Oscore.setFont(new Font("MV BOLI", Font.PLAIN, 20));
        Oscore.setText("Player O score : " + playerOScore );
        Oscore.setOpaque(true);
        Oscore.setBounds(10, 110, 200, 50);

        scorePanel.add(Oscore);

        frame.add(textPanel);
        frame.add(boardPanel);
        frame.add(scorePanel);
        frame.add(restartButton);
        frame.add(main_menuButton);
        frame.add(boardPanel);

        restart();
        MainMenu();
    }   

     protected void check_Action(JButton tile) {
        tile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (gameOver)return;
                JButton tile = (JButton) e.getSource();
                setTile(tile);
            } 
        });
        
    }

    protected void setTile(JButton tile) {
        if (tile.getText()==""){
            tile.setText(currentPlayer);
            turns ++;
            checkWinner();
            if(!gameOver){
            currentPlayer = currentPlayer ==playerX ? playerO : playerX;
            textLabel.setText(currentPlayer + "'s turn");
            }
        }
    }

    protected void checkWinner(){
        for(int r = 0 ; r < 3 ; r++){
            if (board[r][0].getText()=="")continue;
            if(board[r][0].getText() == board[r][1].getText() &&
             board[r][1].getText() == board[r][2].getText() ){
                for(int i = 0 ; i < 3 ; i++){
                    setWinner(board[r][i]);
                }
                gameOver=true;
                return;
             }
        }
        for(int c = 0 ; c < 3 ; c++){
            if (board[0][c].getText()=="")continue;
            if(board[0][c].getText() == board[1][c].getText() &&
               board[1][c].getText() == board[2][c].getText() ){
                for(int i = 0 ; i < 3 ; i++){
                    setWinner(board[i][c]);
                }
                gameOver=true;
                return;
             }
        }
        if (board[0][0].getText() == board[1][1].getText() &&
            board[1][1].getText() == board[2][2].getText() &&
            board[0][0].getText() != ""){
                for(int i = 0; i < 3 ; i++){
                    setWinner(board[i][i]);
                }
                gameOver=true;
                return;
            }
        if (board[0][2].getText() == board[1][1].getText() &&
            board[1][1].getText() == board[2][0].getText() &&
            board[0][2].getText() != ""){
                setWinner(board[0][2]);
                setWinner(board[1][1]);
                setWinner(board[2][0]);
                gameOver=true;
                return;
            }
        if (turns==9){
            for(int r = 0 ; r < 3 ; r++){
                for(int c = 0 ; c < 3 ; c++){
                    setTie(board[r][c]);
                }
            }
            gameOver=true;
        }
    }

    protected void setWinner(JButton tile){
        JLabel textLabel1 = new JLabel();
        JLabel textLabel2 = new JLabel();
        textLabel1.setBackground(Color.darkGray);
        textLabel1.setForeground(Color.white);
        textLabel2.setBackground(Color.darkGray);
        textLabel2.setForeground(Color.white);
        textLabel1.setOpaque(true);
        textLabel2.setOpaque(true);
        tile.setForeground(new Color(56, 251, 219));
        tile.setBackground(new Color(18, 44, 90)); 
        textLabel.setText(currentPlayer + " is the winner");
        if(currentPlayer==playerX){
            playerXScore++;
            Xscore.setText("Player X Score : " + (playerXScore)/3);  
        }else if(currentPlayer==playerO){
            playerOScore++;
            Oscore.setText("Player O Score : " + (playerOScore)/3);
        }  
    }
    
    protected void setTie(JButton tile){
            tile.setForeground(Color.orange);
            tile.setBackground(new Color(18, 44, 90));
            textLabel.setText("Tie!");
    }

    protected void restart() {
        restartButton.addActionListener(new ActionListener() {
          public  void actionPerformed(ActionEvent e){
            JButton button = (JButton) e.getSource();
            if(button.getText()=="Restart"){
                for( int r = 0 ; r < 3 ; r++){
                    for(int c = 0 ; c < 3 ; c++){
                        Restart(board[r][c]);     
                    }
                }
                turns = 0;
                gameOver=false;
            }
          }  
        });
    }

    protected void MainMenu() {
        main_menuButton.addActionListener(new ActionListener() {
          public  void actionPerformed(ActionEvent e){
            JButton button = (JButton) e.getSource();
            if(button.getText()=="Main Menu"){
                new MainMenu();
                frame.dispose();
                }
          }  
        });
    }

    protected void Restart(JButton tile){
        tile.setForeground(Color.white);
        tile.setBackground(new Color(12,30,62));
        tile.setText("");
    }

} 