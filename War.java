//Canaan McKenzie
//CS 110
//War Class

import javax.swing.*;
import java.util.ArrayList;

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
   
   public War()
   {
      playerCardStack = new ArrayList<Card>();
      computerCardStack = new ArrayList<Card>();


      Deck2 warDeck = new Deck2();

      
      for(int i = 0; i < 26; i++)
      {
         playerCardStack.add(warDeck.drawFromDeck());
      }
      
      for(int i = 26; i < 52; i++)
      {
         computerCardStack.add(warDeck.drawFromDeck());
      }       
        
   }
   public ArrayList<Card> getPlayerStack()
   {
      return playerCardStack;
   }
   
   
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
   
   
   public int getPlayerStackSize()
   {
      return playerCardStack.size();
   }
   
   
   public int getComputerStackSize()
   {
      return computerCardStack.size();
   }
   

   public Card getPlayerCard()
   {
      return playerCardStack.get(0);
   }
   
   
   public Card getComputerCard()
   {
      return computerCardStack.get(0);
   }
   
   public boolean isEmpty()
   {
      return isEmpty;
   }
}  