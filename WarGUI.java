//Canaan McKenzie
//CS 110 Final
//

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class WarGUI extends JFrame
{
   private int playerScore = 0, computerScore = 0;
   
   private JPanel centerPanel, computerPanel, playerPanel, titlePanel, topPanel, bottomPanel; //break up regions
   private JButton flipButton; //button grid
   private JLabel status; //game status
   private JLabel title; //game title (War)
   
   private JLabel playerCard;
   private JLabel computerCard;
   private JLabel cardBack;
   
   private War newGame;
   private ImageIcon computerLabelIcon, playerLabelIcon;
   private String winner;
   
   private ArrayList<Card> playerWinnings, computerWinnings;
   private boolean gameOver;
   private Card userCard, compCard, userCard2, compCard2, userCard3, compCard3;
    
   public WarGUI()
   {
      
            
   playerWinnings = new ArrayList<Card>();
   computerWinnings = new ArrayList<Card>();
          
      centerPanel = new JPanel(new GridLayout(1,2));
      
      //declare computer panel
      computerPanel = new JPanel();
      
      //declare icon for labels
      computerLabelIcon = new ImageIcon("images/back.jpg"); 
      
      //place icon in label
      computerCard = new JLabel(computerLabelIcon);
   
      //add icon to panel
      computerPanel.add(computerCard);
      
      //set background color
      computerPanel.setBackground(Color.green);
      
      //add to main panel
      centerPanel.add(computerPanel);
      
      //declare player panel
      playerPanel = new JPanel();
      
      //declare icon for labels
      playerLabelIcon = new ImageIcon("images/back.jpg"); 
      
      //set label with the icon
      playerCard = new JLabel(playerLabelIcon);
      
      //add label to panel
      playerPanel.add(playerCard);
      
      //set background color
      playerPanel.setBackground(Color.blue);
      
      //add to center panel 
      centerPanel.add(playerPanel);
     
      
      add(centerPanel,BorderLayout.CENTER);
      

      
      flipButton = new JButton("Flip");
      flipButton.addActionListener(new ButtonListener());
      add(flipButton,BorderLayout.SOUTH);
      
      
      
      titlePanel = new JPanel(new GridLayout(2,1));
      
     // titlePanel.setBackground(Color.red);
      topPanel = new JPanel();
      titlePanel.add(topPanel);
      
      bottomPanel = new JPanel();
      titlePanel.add(bottomPanel);
      
      add(titlePanel,BorderLayout.NORTH);

      title = new JLabel("War");
      title.setFont(new Font("HELVETICA",Font.ITALIC,36));
      //title.setForeGround(Color.RED);
      topPanel.add(title);
      
      status = new JLabel(" Computer Score = " + playerScore + " " + " Player Score = " + computerScore);
      status.setFont(new Font("ARIAL",Font.BOLD,24));
      bottomPanel.add(status);


   
   }
   public class ButtonListener implements ActionListener
   {
      War newGame = new War();
      public void actionPerformed(ActionEvent e)
      {  
         
         
         //click flip button
         if (e.getSource() == flipButton)
         
         {   
            userCard = newGame.drawPlayerCard();
            compCard = newGame.drawComputerCard();
            
            
            //change image icons to those of drawn cards
            if (newGame.isEmpty())
            {
                computerLabelIcon = new ImageIcon("images/back.jpg");
                playerLabelIcon = new ImageIcon("images/back.jpg");
   
                computerCard.setIcon(computerLabelIcon);
                playerCard.setIcon(playerLabelIcon);
            }
            else
            {
               computerLabelIcon = compCard.getCardImage();
               playerLabelIcon = userCard.getCardImage();
            }
            //set label to new image Icon
            computerCard.setIcon(computerLabelIcon);
            playerCard.setIcon(playerLabelIcon);
            
            if (!newGame.isEmpty())
            { 
               if (compCard.getRank() > userCard.getRank())
               {
                  //computer win      
                  computerWinnings.add(userCard);
                  computerWinnings.add(compCard);
               
                  status.setText(" Computer Score = " + computerWinnings.size()  + " Player Score = " + playerWinnings.size() );    
               }
               
               else if (userCard.getRank() > compCard.getRank())
               {
                  //player win
                  playerWinnings.add(userCard);
                  playerWinnings.add(compCard);
               
                  status.setText(" Computer Score = " + computerWinnings.size() + " Player Score = " + playerWinnings.size());
            
               }
               
               else if (userCard.getRank() == compCard.getRank())
               {
                  userCard2 = newGame.drawPlayerCard();
                  compCard2 = newGame.drawComputerCard();
                  
                  status.setText("WAR!");
                  
                  userCard3 = newGame.drawPlayerCard();
                  compCard3 = newGame.drawComputerCard();
                  
                  if (compCard3.getRank() > userCard3.getRank())
                  {
                     //computer win      
                     computerWinnings.add(userCard);
                     computerWinnings.add(compCard);
                     computerWinnings.add(userCard2);
                     computerWinnings.add(compCard2);
                     computerWinnings.add(userCard3);
                     computerWinnings.add(compCard3);
               
                     status.setText(" Computer Score = " + computerWinnings.size()  + " Player Score = " + playerWinnings.size() );    
                  }  
               
               else if (userCard3.getRank() > compCard3.getRank())
               {
                     //player win
                     playerWinnings.add(userCard);
                     playerWinnings.add(compCard);
                     playerWinnings.add(userCard2);
                     playerWinnings.add(compCard2);
                     playerWinnings.add(userCard3);
                     playerWinnings.add(compCard3);
               
                     status.setText(" Computer Score = " + computerWinnings.size() + " Player Score = " + playerWinnings.size());
            
               }
                  
                                    
                    
               }
             }  
             else
               {
                  //out of cards
                  if (playerWinnings.size() > computerWinnings.size())
                     winner = "Player wins!";
                  else
                     winner = "Computer wins!";
                   
                  status.setText("Game Over : " + winner);
               
                           
               }
                       
          }
  
      }
  }  
   
   public static void main(String [] args)
   {
      JFrame frame = new WarGUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
      // OR
      frame.setSize(500,500);
      frame.validate();
      frame.setVisible(true);


   
   
   }

   
   
}