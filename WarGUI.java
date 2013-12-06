//Canaan McKenzie
//CS 110 Final
//

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
WarGUI class creates a GUI represenation of the card game of War
*/
public class WarGUI extends JFrame
{
   private int playerScore = 0, computerScore = 0; //initialize score
   
   private JPanel centerPanel, computerPanel, playerPanel, titlePanel, topPanel, bottomPanel; //break up regions
   private JButton flipButton; //button grid
   private JLabel status; //game status
   private JLabel title; //game title (War)
   
   private JLabel playerCard; //user card holding imageIcons
   private JLabel computerCard; //player card holding imageIcons
   private JLabel cardBack; //imageIcon for back of cards
   
   private War newGame; //new War object
   private ImageIcon computerLabelIcon, playerLabelIcon; //imageIcons
   private String winner; 
   
   private ArrayList<Card> playerWinnings, computerWinnings; //holds cards the players have won
   private boolean gameOver; 
   private Card userCard, compCard, userCard2, compCard2, userCard3, compCard3; //card objects drawn

/**
Constructor generates a GUI with sections divided to hold the information needed for the game
*/    
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
      

      //declare button that flips cards
      flipButton = new JButton("Flip");
      //add functionality to react to the button
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
/**
ButtonListener allows for functionality in the game, by hitting the button the user 
can cause changes to occur (e.g. play war)
*/
   public class ButtonListener implements ActionListener
   {
      //create new War Game
      War newGame = new War();
/**
actionPerformed is the method that causes the button to be reactive
@param ActionEvent e is the button being pressed
*/
      public void actionPerformed(ActionEvent e)
      {  
         
         
         //click flip button
         if (e.getSource() == flipButton)
         
         {   
            userCard = newGame.drawPlayerCard();
            compCard = newGame.drawComputerCard();
            
            
            //change image icons to those of drawn cards
            //make sure that on pressing there are still cards in either of the user's or computer's stacks
            if (newGame.isEmpty())
            {
               //start with back of cards
                computerLabelIcon = new ImageIcon("images/back.jpg");
                playerLabelIcon = new ImageIcon("images/back.jpg");
                
                //set icon as cards change
                computerCard.setIcon(computerLabelIcon);
                playerCard.setIcon(playerLabelIcon);
            }
            else
            {
               //if the icons are not empty (still in stacks)
               computerLabelIcon = compCard.getCardImage();
               playerLabelIcon = userCard.getCardImage();
            }
            //set label to new image Icon
            computerCard.setIcon(computerLabelIcon);
            playerCard.setIcon(playerLabelIcon);
            
            //if there still are cards 
            if (!newGame.isEmpty())
            { 
               //compare value of cards
               if (compCard.getRank() > userCard.getRank())
               {
                  //computer win      
                  computerWinnings.add(userCard);
                  computerWinnings.add(compCard);
                  //change text to represent score
                  status.setText(" Computer Score = " + computerWinnings.size()  + " Player Score = " + playerWinnings.size() );    
               }
               
               //compare value of cards
               else if (userCard.getRank() > compCard.getRank())
               {
                  //player win
                  playerWinnings.add(userCard);
                  playerWinnings.add(compCard);
                  //change text to relect score
                  status.setText(" Computer Score = " + computerWinnings.size() + " Player Score = " + playerWinnings.size());
            
               }
               //if there is a war
               else if (userCard.getRank() == compCard.getRank())
               {
               
               //draw another card to ante
                  userCard2 = newGame.drawPlayerCard();
                  compCard2 = newGame.drawComputerCard();
                  //change text to War
                  status.setText("WAR!");
                  //card to compare 
                  userCard3 = newGame.drawPlayerCard();
                  compCard3 = newGame.drawComputerCard();
                  
                  //if the computer wins the war
                  if (compCard3.getRank() > userCard3.getRank())
                  {
                     //computer win  add all the cards    
                     computerWinnings.add(userCard);
                     computerWinnings.add(compCard);
                     computerWinnings.add(userCard2);
                     computerWinnings.add(compCard2);
                     computerWinnings.add(userCard3);
                     computerWinnings.add(compCard3);
                     //reset score
                     status.setText(" Computer Score = " + computerWinnings.size()  + " Player Score = " + playerWinnings.size() );    
                  }  
               //if the user wins
               else if (userCard3.getRank() > compCard3.getRank())
               {
                     //player win add all the cards in the ante
                     playerWinnings.add(userCard);
                     playerWinnings.add(compCard);
                     playerWinnings.add(userCard2);
                     playerWinnings.add(compCard2);
                     playerWinnings.add(userCard3);
                     playerWinnings.add(compCard3);
                     //change to reset score
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
 /**
 driver class allows the GUI to be run and determines close behavior and dimensions
 */  
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