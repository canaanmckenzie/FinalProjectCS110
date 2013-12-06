//Canaan McKenzie
//CS 110
//Assignment 5 problem 3 CardClass

/**
 This class represents a single playing card from a standard 52 card deck
 */
import javax.swing.*;
public class Card 
{
   ImageIcon cardImage = new ImageIcon();
   
   public final static int SPADES = 0;   // Codes for the 4 suits
   public final static int HEARTS = 1;
   public final static int DIAMONDS = 2;
   public final static int CLUBS = 3;
   
   public final static int ACE = 1;      // Codes for the non-numeric cards.
   public final static int JACK = 11;    //   Cards 2 through 10 have their 
   public final static int QUEEN = 12;   //   numerical values for their codes.
   public final static int KING = 13;
   
   private int Suit; 
  
   private int Rank;
      
 /**
 Constructor takes two integer variables to determine the kind of card being referenced
 by the user.
 @param the integer GivenRank describing the user defined rank of the card.
 @param the integer GivenSuite describing the user defined suite of the card as defined
 by the static values for suite.
 */
 
 
 
 
   public Card(int GivenRank, int GivenSuit) 
   {
  
      Rank = GivenRank;
      Suit = GivenSuit;
   }
   
   public Card(Card object)
   {
      this.Rank = object.getRank();
      this.Suit = object.getSuit();
   }

/**
This method returns the integer value of the suite
*/
  
   public int getSuit() 
   {
      return Suit;
   }
   
/**
This method returns the integer value of the rank of the card
*/   
   
   public int getRank() 
   {
      return Rank;
   }
  
/**
This method returns the string value of the suit, which is used by teh toString() method
to give the suite and rank of the card.
*/
  
   public String getSuitString() 
   {
      switch (Suit) 
      {
      case SPADES:   return "Spades";
      case HEARTS:   return "Hearts";
      case DIAMONDS: return "Diamonds";
      default:       return "Clubs";
      }
   }
   

/**
This method returns the string value of the rank, which is used by the toString() method
to give the suite and rank of the card.
*/
   
   public String getRankString() 
   {
         switch (Rank) 
         {
         case 1:   return "Ace";
         case 2:   return "2";
         case 3:   return "3";
         case 4:   return "4";
         case 5:   return "5";
         case 6:   return "6";
         case 7:   return "7";
         case 8:   return "8";
         case 9:   return "9";
         case 10:  return "10";
         case 11:  return "Jack";
         case 12:  return "Queen";
         default:  return "King";
         }
   }

/**
This method returns a the rank of a card and its value as strings.
*/
  
    
   public  String toString() 
   {
      
      String str = getRankString() + " of " + getSuitString();
      return str;
   }
   
/**
The equals method compares the rank of two cards and returns a boolean true or false 
if they are equal or not
*/
   
   
   public boolean equals(Card other)
   {
   
   boolean status;
   
      if (Rank == other.getRank())
      {
         status = true; 
      }
      else 
      {
         status = false;
      }
      
      return status;
   }


/**
This method setCardImage() takes the images representing each card and pairs it with the specific card created 
in this class
*/

   public void setCardImage()
   {
   
      switch (getRankString() + "|" + getSuitString()) 
      {
       
         case "10|Clubs" :   cardImage = new ImageIcon("images/10c.jpg");break;
         case "10|Diamonds" :   cardImage = new ImageIcon("images/10d.jpg");break;
         case "10|Hearts" :   cardImage = new ImageIcon("images/10h.jpg");break;
         case "10|Spades" :   cardImage = new ImageIcon("images/10s.jpg");break;
         case "2|Clubs" :    cardImage = new ImageIcon("images/2c.jpg");break;
         case "2|Diamonds" :    cardImage = new ImageIcon("images)/2d.jpg");break;
         case "2|Hearts" :    cardImage = new ImageIcon("images/2h.jpg");break;
         case "2|Spades" :    cardImage = new ImageIcon("images/2s.jpg");break;
         case "3|Clubs":   cardImage = new ImageIcon("images/3c.jpg");break;
         case "3|Diamonds":  cardImage = new ImageIcon("images/3d.jpg");break;
         case "3|Hearts":  cardImage = new ImageIcon("images/3h.jpg");break;
         case "3|Spades" :  cardImage = new ImageIcon("images/3s.jpg");break;

         case "4|Clubs" :   cardImage = new ImageIcon("images/4c.jpg");break;
         case "4|Diamonds" :   cardImage = new ImageIcon("images/4d.jpg");break;
         case "4|Hearts" :   cardImage = new ImageIcon("images/4h.jpg");break;
         case "4|Spades" :   cardImage = new ImageIcon("images/4s.jpg");break;
         case "5|Clubs" :    cardImage = new ImageIcon("images/5c.jpg");break;
         case "5|Diamonds" :    cardImage = new ImageIcon("images/5d.jpg");break;
         case "5|Hearts" :    cardImage = new ImageIcon("images/5h.jpg");break;
         case "5|Spades" :    cardImage = new ImageIcon("images/5s.jpg");break;
         case "6|Clubs":   cardImage = new ImageIcon("images/6c.jpg");break;
         case "6|Diamonds":  cardImage = new ImageIcon("images/6d.jpg");break;
         case "6|Hearts":  cardImage = new ImageIcon("images/6h.jpg");break;
         case "6|Spades" :  cardImage = new ImageIcon("images/6s.jpg");break;
 

         case "7|Clubs" :   cardImage = new ImageIcon("images/7c.jpg");break;
         case "7|Diamonds" :   cardImage = new ImageIcon("images/7d.jpg");break;
         case "7|Hearts" :   cardImage = new ImageIcon("images/7h.jpg");break;
         case "7|Spades" :   cardImage = new ImageIcon("images/7s.jpg");break;
         case "8|Clubs" :    cardImage = new ImageIcon("images/8c.jpg");break;
         case "8|Diamonds" :    cardImage = new ImageIcon("images/8d.jpg");break;
         case "8|Hearts" :    cardImage = new ImageIcon("images/8h.jpg");break;
         case "8|Spades" :    cardImage = new ImageIcon("images/8s.jpg");break;
         case "9|Clubs":   cardImage = new ImageIcon("images/9c.jpg");break;
         case "9|Diamonds":  cardImage = new ImageIcon("images/9d.jpg");break;
         case "9|Hearts":  cardImage = new ImageIcon("images/9h.jpg");break;
         case "9|Spades" :  cardImage = new ImageIcon("images/9s.jpg");break;
 
         case "Ace|Clubs" :   cardImage = new ImageIcon("images/acec.jpg");
         case "Ace|Diamonds" :   cardImage = new ImageIcon("images/aced.jpg");
         case "Ace|Hearts" :   cardImage = new ImageIcon("images/aceh.jpg");
         case "Ace|Spades" :   cardImage = new ImageIcon("images/aces.jpg");
         case "Jack|Clubs" :    cardImage = new ImageIcon("images/jackc.jpg");
         case "Jack|Diamonds" :    cardImage = new ImageIcon("images/jackd.jpg");
         case "Jack|Hearts" :    cardImage = new ImageIcon("images/jackh.jpg");
         case "Jack|Spades" :    cardImage = new ImageIcon("images/jacks.jpg");
         case "Queen|Clubs":   cardImage = new ImageIcon("images/queenc.jpg");
         case "Queen|Diamonds":  cardImage = new ImageIcon("images/queend.jpg");
         case "Queen|Hearts":  cardImage = new ImageIcon("images/queenh.jpg");
         case "Queen|Spades" :  cardImage = new ImageIcon("images/queens.jpg");
         case "King|Clubs":   cardImage = new ImageIcon("images/kingc.jpg");
         case "King|Diamonds":  cardImage = new ImageIcon("images/kingd.jpg");
         case "King|Hearts":  cardImage = new ImageIcon("images/kingh.jpg");
         case "King|Spades" :  cardImage = new ImageIcon("images/kings.jpg");

 
      }   
   
   }
   /**
   This getter method getCardImage returns the imageIcon value associated with the card
   */
   public ImageIcon getCardImage()
   {
      setCardImage();
      return cardImage;
   }
   
} 