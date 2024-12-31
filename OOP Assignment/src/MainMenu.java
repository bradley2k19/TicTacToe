import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import javax.swing.border.Border;

public class MainMenu {
    int boardwith = 400;
    int boardheight = 500;
    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel textLabel = new JLabel();   
    JPanel logoPanel = new JPanel();
    JPanel MainMenuPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JPanel boardPanel1 = new JPanel();
    JButton NormalBoardButton = new JButton();
    JButton ExpandedBoardButton = new JButton();
    JLabel logoLabel = new JLabel();
    JLabel MainMenuLabel = new JLabel();
    
    public MainMenu(){

        Border border = BorderFactory.createLineBorder(new Color(142, 82, 245));

        ImageIcon image = new ImageIcon("tictactoe.jpg");

        frame.setVisible(true);
        frame.setSize(boardwith, boardheight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground( new Color(12,30,62));
        frame.setIconImage(image.getImage());

        logoPanel.setBackground(new Color(12,30,62));
        logoPanel.setBounds(30, 20, 340, 50);
       
        frame.add(logoPanel);

        MainMenuPanel.setBackground(new Color(12,30,62));
        MainMenuPanel.setBounds(50, 90, 300, 50);
        frame.add(MainMenuPanel);

        
        NormalBoardButton.setBounds(100, 200, 200, 30);
        NormalBoardButton.setFocusable(false);
        NormalBoardButton.setBackground(new Color(12,30,62));
        NormalBoardButton.setBorder(border);
        NormalBoardButton.setForeground(Color.WHITE);
        NormalBoardButton.setText("Normal Board");
        frame.add(NormalBoardButton);

        ExpandedBoardButton.setBounds(100, 280, 200, 30);
        ExpandedBoardButton.setFocusable(false);
        ExpandedBoardButton.setBackground(new Color(12,30,62));
        ExpandedBoardButton.setBorder(border);
        ExpandedBoardButton.setForeground(Color.WHITE);
        ExpandedBoardButton.setText("Expanded Board");
        frame.add(ExpandedBoardButton);

        logoLabel.setFont(new Font("MV Boli", Font.PLAIN, 35));
        logoLabel.setForeground(Color.green);
        logoLabel.setText("Tic Tac Toe");
        logoPanel.add(logoLabel);

        MainMenuLabel.setFont(new Font("Arial", Font.BOLD, 40));
        MainMenuLabel.setForeground(new Color(252, 15, 245));
        MainMenuLabel.setText("Main Menu");
        MainMenuPanel.add(MainMenuLabel);
        
        NormalBoardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton buttons = (JButton) e.getSource();
                if(buttons.getText()=="Normal Board"){
                     new TicTacToe();
                    frame.dispose();
                }
            }
        });
        
        ExpandedBoardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton buttons = (JButton) e.getSource();
                if(buttons.getText()=="Expanded Board"){
                    new Expanded_Board();
                    frame.dispose();
                }
            }
        });
     }
}


