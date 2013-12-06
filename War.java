//Canaan McKenzie
//CS 110
//War Class

import javax.swing.*;
import java.util.ArrayList;

/**
War class represents the functionality needed to play the card game war
*/
public class War
{
   private int playerScore = 0, computerScore = 0;
   private Card playerCard, computerCard;
   private int winner, warStackSize;
   private final int HALF_DECK = 26;
   
   private final int COMPUTER_WIN = 1, PLAYER_WIN = 2, OUT_OF_CARDS = 3, WAR = 4; 
   private ArrayList<Card> playerCardStack, computerCardStack;
   private ImageIcon playerCardImage, computerCardImage;
   private Deck2 warDeck;
   private boolean isEmpty = false;
  
 /**
 constructor creates an array list of half a randomized deck of card objects
 */
   public War()
   {
      playerCardStack = new ArrayList<Card>();
      computerCardStack = new ArrayList<Card>();


      Deck2 warDeck = new Deck2();

      //taking the first half of the deck for user
      for(int i = 0; i < 26; i++)
      {
         playerCardStack.add(warDeck.drawFromDeck());
      }
      //taking the second half of the deck for computer
      for(int i = 26; i < 52; i++)
      {
         computerCardStack.add(warDeck.drawFromDeck());
      }       
        
   }
/**
getPlayerStack returns the playerStack (26 cards)
@return 26 card objects
*/

   public ArrayList<Card> getPlayerStack()
   {
      return playerCardStack;
   }
   
/**
drawPlayerCard returns a card object from the top of the player's stack
if the card stack is empty (out of cards) the boolean isEmpty is tripped
@return null or the top card from the stack
*/   
   public Card drawPlayerCard()
   {
      if (playerCardStack.size() == 0)
      {
         isEmpty = true;
         return null;
      }
      
      else
      return playerCardStack.remove(0);        
   }
   
/**
drawComputerCard returns a card object from the top of the computer's stack
if the card stack is empty (out of cards) the boolean isEmpty is tripped
@return null or the top card from the stack
*/   
   public Card drawComputerCard()
   {
     if (playerCardStack.size() == 0)
     {   
         isEmpty = true;
         return null;
     }
     else
     return computerCardStack.remove(0);
      
   }  
/**
getPlayerstackSize returns the integer amount of cards in the stack
@return number of cards in the stack
*/ 
   public int getPlayerStackSize()
   {
      return playerCardStack.size();
   }
   
/**
getComputerStackSize returns the integer amount of cards in the stack
@return number of cards in the stack
*/    
   
   public int getComputerStackSize()
   {
      return computerCardStack.size();
   }
   
/**
getPlayerCard returns the card object in the top of the stack, without removing it
@return card object
*/    
   
   public Card getPlayerCard()
   {
      return playerCardStack.get(0);
   }
   
/**
getPlayerStackSize returns the integer amount of cards in the stack
@return card object
*/    
     
   public Card getComputerCard()
   {
      return computerCardStack.get(0);
   }
   
/**
get isEmpty returns the boolean indicating if there are cards or not in the stack
@return if there are cards or not in either stack
*/   
     
   public boolean isEmpty()
   {
      return isEmpty;
   }
}  