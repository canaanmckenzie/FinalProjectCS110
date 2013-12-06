//Canaan Mckenzie
//CS 110 Final Project
//Deck class

import java.util.Random;
import java.util.ArrayList;

/**
Deck2 represents a deck made out of Card class objects
*/	 
public class Deck2
{
   private ArrayList<Card> cards;

/**
Constructor creates an array list of cards and then randomizes them 
using a switching values for a fixed amount of time which is greater than the 
total number of cards in a standard deck
*/	 
   public Deck2()
	{
	    cards = new ArrayList<Card>();
	    int index_1, index_2;
	    Random generator = new Random();
	    Card temp;
	 
      //generate cards by suite and rank
	    for (int a=0; a<=3; a++)
	    {
	      for (int b=1; b<=13; b++)
	      {
	         cards.add( new Card(b,a) );
	      }
	    }
	 
	 //"randomize" cards
	    for (int i=0; i<100; i++)
       {
	       index_1 = generator.nextInt( cards.size() - 1 );
          index_2 = generator.nextInt( cards.size() - 1 );
 
	       temp = (Card) cards.get( index_2 );
          cards.set( index_2 , cards.get( index_1 ) );
	       cards.set( index_1, temp );
       }
	 }
/**
drawFromDeck method returns the first object from the deck simulating a draw by removing it from the 
deck
@return the card from the top of the deck
*/
	 public Card drawFromDeck()
	 {     
	   return cards.remove(0);
    }
/**
getTotalCards method returns the total number of card from the deck 
@return the total size of the deck
*/	 
	 public int getTotalCards()
	 {
      return cards.size();
	 }
    
/**
toString method returns the first object from the deck simulating a draw by removing it from the 
deck and changing it to a string
@return the string representation of a card
*/    
    public String toString()
    {
      return (cards.remove(0).toString());
    }
}