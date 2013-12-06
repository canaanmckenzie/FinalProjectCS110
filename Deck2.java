//Canaan Mckenzie
//CS 110 Final Project
//Deck class

import java.util.Random;
import java.util.ArrayList;
	 
public class Deck2
{
   private ArrayList<Card> cards;
	 
   Deck2()
	{
	    cards = new ArrayList<Card>();
	    int index_1, index_2;
	    Random generator = new Random();
	    Card temp;
	 
	    for (int a=0; a<=3; a++)
	    {
	      for (int b=1; b<=13; b++)
	      {
	         cards.add( new Card(b,a) );
	      }
	    }
	 
	 
	    for (int i=0; i<100; i++)
       {
	       index_1 = generator.nextInt( cards.size() - 1 );
          index_2 = generator.nextInt( cards.size() - 1 );
 
	       temp = (Card) cards.get( index_2 );
          cards.set( index_2 , cards.get( index_1 ) );
	       cards.set( index_1, temp );
       }
	 }
	 
	 public Card drawFromDeck()
	 {     
	   return cards.remove(0);
    }
	 
	 public int getTotalCards()
	 {
      return cards.size();
	 }
    
    public String toString()
    {
      return (cards.remove(0).toString());
    }
}