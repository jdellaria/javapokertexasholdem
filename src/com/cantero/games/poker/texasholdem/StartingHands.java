package com.cantero.games.poker.texasholdem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class StartingHands {


	private List<StartingHand> hands = new ArrayList<StartingHand>();

	public StartingHands() {
		
	}

	public StartingHand add(Card cardOne, Card cardTwo, StartingHandResultEnum result) {
		StartingHand myHand = new StartingHand();
		
		
		// Make sure first card is the high card
		if (cardOne.getRankToInt() > cardTwo.getRankToInt())
		{
			myHand.card1 = cardOne;
			myHand.card2 = cardTwo;
		}
		else
		{
			myHand.card1 = cardTwo;
			myHand.card2 = cardOne;
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.ACE) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.ACE) == 0))
		{
			myHand.startingHand = StartingHandEnum.POCKET_ACES;
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.KING) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.KING) == 0))
		{
			myHand.startingHand = StartingHandEnum.POCKET_KINGS;
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.QUEEN) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.QUEEN) == 0))
		{
			myHand.startingHand = StartingHandEnum.POCKET_QUEENS;
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.JACK) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.JACK) == 0))
		{
			myHand.startingHand = StartingHandEnum.POCKET_JACKS;
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_10) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_10) == 0))
		{
			myHand.startingHand = StartingHandEnum.POCKET_TENS;
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_9) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_9) == 0))
		{
			myHand.startingHand = StartingHandEnum.POCKET_NINES;
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_8) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_8) == 0))
		{
			myHand.startingHand = StartingHandEnum.POCKET_EIGHTS;
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_7) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_7) == 0))
		{
			myHand.startingHand = StartingHandEnum.POCKET_SEVENS;
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_6) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_6) == 0))
		{
			myHand.startingHand = StartingHandEnum.POCKET_SIXES;
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_5) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_5) == 0))
		{
			myHand.startingHand = StartingHandEnum.POCKET_FIVES;
		}
	
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_4) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_4) == 0))
		{
			myHand.startingHand = StartingHandEnum.POCKET_FOURS;
		}
	
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_3) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_3) == 0))
		{
			myHand.startingHand = StartingHandEnum.POCKET_THREES;
		}
	
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_2) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_2) == 0))
		{
			myHand.startingHand = StartingHandEnum.POCKET_TWOS;
		}
// -----------	
		if((myHand.card1.getRank().compareTo(CardRankEnum.ACE) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.KING) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.ACE_KING_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.ACE_KING_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.ACE) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.QUEEN) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.ACE_QUEEN_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.ACE_QUEEN_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.ACE) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.JACK) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.ACE_JACK_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.ACE_JACK_OFFSUIT;
			}
		}
		
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.ACE) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_10) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.ACE_TEN_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.ACE_TEN_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.ACE) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_9) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.ACE_NINE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.ACE_NINE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.ACE) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_8) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.ACE_EIGHT_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.ACE_EIGHT_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.ACE) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_7) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.ACE_SEVEN_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.ACE_SEVEN_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.ACE) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_6) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.ACE_SIX_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.ACE_SIX_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.ACE) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_5) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.ACE_FIVE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.ACE_FIVE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.ACE) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_4) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.ACE_FOUR_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.ACE_FOUR_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.ACE) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_3) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.ACE_THREE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.ACE_THREE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.ACE) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_2) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.ACE_TWO_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.ACE_TWO_OFFSUIT;
			}
		}
//--------
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.KING) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.QUEEN) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.KING_QUEEN_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.KING_QUEEN_OFFSUIT;
			}
		}

		if((myHand.card1.getRank().compareTo(CardRankEnum.KING) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.JACK) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.KING_JACK_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.KING_JACK_OFFSUIT;
			}
		}
		
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.KING) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_10) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.KING_TEN_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.KING_TEN_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.KING) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_9) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.KING_NINE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.KING_NINE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.KING) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_8) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.KING_EIGHT_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.KING_EIGHT_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.KING) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_7) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.KING_SEVEN_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.KING_SEVEN_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.KING) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_6) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.KING_SIX_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.KING_SIX_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.KING) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_5) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.KING_FIVE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.KING_FIVE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.KING) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_4) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.KING_FOUR_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.KING_FOUR_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.KING) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_3) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.KING_THREE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.KING_THREE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.KING) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_2) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.KING_TWO_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.KING_TWO_OFFSUIT;
			}
		}

//--------


		if((myHand.card1.getRank().compareTo(CardRankEnum.QUEEN) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.JACK) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.QUEEN_JACK_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.QUEEN_JACK_OFFSUIT;
			}
		}
		
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.QUEEN) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_10) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.QUEEN_TEN_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.QUEEN_TEN_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.QUEEN) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_9) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.QUEEN_NINE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.QUEEN_NINE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.QUEEN) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_8) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.QUEEN_EIGHT_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.QUEEN_EIGHT_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.QUEEN) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_7) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.QUEEN_SEVEN_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.QUEEN_SEVEN_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.QUEEN) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_6) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.QUEEN_SIX_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.QUEEN_SIX_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.QUEEN) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_5) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.QUEEN_FIVE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.QUEEN_FIVE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.QUEEN) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_4) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.QUEEN_FOUR_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.QUEEN_FOUR_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.QUEEN) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_3) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.QUEEN_THREE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.QUEEN_THREE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.QUEEN) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_2) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.QUEEN_TWO_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.QUEEN_TWO_OFFSUIT;
			}
		}
	
//--------
	
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.JACK) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_10) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.JACK_TEN_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.JACK_TEN_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.JACK) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_9) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.JACK_NINE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.JACK_NINE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.JACK) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_8) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.JACK_EIGHT_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.JACK_EIGHT_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.JACK) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_7) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.JACK_SEVEN_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.JACK_SEVEN_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.JACK) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_6) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.JACK_SIX_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.JACK_SIX_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.JACK) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_5) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.JACK_FIVE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.JACK_FIVE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.JACK) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_4) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.JACK_FOUR_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.JACK_FOUR_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.JACK) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_3) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.JACK_THREE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.JACK_THREE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.JACK) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_2) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.JACK_TWO_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.JACK_TWO_OFFSUIT;
			}
		}
	
//--------
	

		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_10) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_9) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.TEN_NINE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.TEN_NINE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_10) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_8) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.TEN_EIGHT_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.TEN_EIGHT_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_10) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_7) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.TEN_SEVEN_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.TEN_SEVEN_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_10) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_6) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.TEN_SIX_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.TEN_SIX_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_10) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_5) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.TEN_FIVE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.TEN_FIVE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_10) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_4) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.TEN_FOUR_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.TEN_FOUR_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_10) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_3) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.TEN_THREE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.TEN_THREE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_10) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_2) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.TEN_TWO_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.TEN_TWO_OFFSUIT;
			}
		}
		
		
//--------
	


		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_9) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_8) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.NINE_EIGHT_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.NINE_EIGHT_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_9) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_7) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.NINE_SEVEN_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.NINE_SEVEN_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_9) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_6) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.NINE_SIX_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.NINE_SIX_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_9) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_5) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.NINE_FIVE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.NINE_FIVE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_9) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_4) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.NINE_FOUR_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.NINE_FOUR_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_9) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_3) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.NINE_THREE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.NINE_THREE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_9) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_2) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.NINE_TWO_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.NINE_TWO_OFFSUIT;
			}
		}

		
//--------
	



		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_8) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_7) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.EIGHT_SEVEN_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.EIGHT_SEVEN_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_8) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_6) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.EIGHT_SIX_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.EIGHT_SIX_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_8) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_5) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.EIGHT_FIVE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.EIGHT_FIVE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_8) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_4) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.EIGHT_FOUR_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.EIGHT_FOUR_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_8) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_3) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.EIGHT_THREE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.EIGHT_THREE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_8) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_2) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.EIGHT_TWO_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.EIGHT_TWO_OFFSUIT;
			}
		}

//--------
	


		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_7) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_6) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.SEVEN_SIX_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.SEVEN_SIX_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_7) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_5) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.SEVEN_FIVE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.SEVEN_FIVE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_7) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_4) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.SEVEN_FOUR_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.SEVEN_FOUR_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_7) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_3) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.SEVEN_THREE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.SEVEN_THREE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_7) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_2) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.SEVEN_TWO_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.SEVEN_TWO_OFFSUIT;
			}
		}

		
//--------
	

	
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_6) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_5) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.SIX_FIVE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.SIX_FIVE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_6) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_4) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.SIX_FOUR_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.SIX_FOUR_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_6) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_3) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.SIX_THREE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.SIX_THREE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_6) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_2) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.SIX_TWO_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.SIX_TWO_OFFSUIT;
			}
		}
		

		
//--------
	


		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_5) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_4) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.FIVE_FOUR_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.FIVE_FOUR_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_5) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_3) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.FIVE_THREE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.FIVE_THREE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_5) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_2) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.FIVE_TWO_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.FIVE_TWO_OFFSUIT;
			}
		}
		
//--------
	

		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_4) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_3) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.FOUR_THREE_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.FOUR_THREE_OFFSUIT;
			}
		}
		
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_4) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_2) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.FOUR_TWO_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.FOUR_TWO_OFFSUIT;
			}
		}

		
//--------			
		if((myHand.card1.getRank().compareTo(CardRankEnum.CARD_3) == 0) && (myHand.card2.getRank().compareTo(CardRankEnum.CARD_2) == 0))
		{
			if(myHand.card1.getSuit().equals(myHand.card2.getSuit() ) )
			{
				myHand.startingHand = StartingHandEnum.THREE_TWO_SUITED;
			}
			else
			{
				myHand.startingHand = StartingHandEnum.THREE_TWO_OFFSUIT;
			}
		}	
		
		int index = exists(myHand);
		if (index >= 0)
		{
			myHand = hands.get(index);
			myHand.count = myHand.count + 1;
			if (result == StartingHandResultEnum.WIN)
			{
				myHand.winner = myHand.winner + 1;
			}
			else if(result == StartingHandResultEnum.DRAW)
			{
				myHand.draw = myHand.draw + 1;
			}
			hands.set(index, myHand);
		}
		else
		{
			myHand.count = 1;
			if (result == StartingHandResultEnum.WIN)
			{
				myHand.winner = myHand.winner + 1;
			}
			else if(result == StartingHandResultEnum.DRAW)
			{
				myHand.draw = myHand.draw + 1;
			}
			hands.add(myHand);
		}
		return myHand;

	}
	

	public int exists(StartingHand hand) {
		StartingHand existingHand = new StartingHand();
		int x = hands.size();
		
		while (x != 0)
		{
			existingHand = hands.get(x - 1);
			int rank1 = existingHand.card1.getRankToInt();
			
			if(existingHand.startingHand == hand.startingHand )
			{
				return(x - 1);
			}
			
/*			if((existingHand.card1.getRank() == hand.card1.getRank()) && (existingHand.card1.getSuit() == hand.card1.getSuit())  )
			{
				return(x - 1);
			}*/
			x--;
			
		}
		return -1;
	}
	
	public int size() {
		
		return hands.size();
	}
	
	public StartingHand get(int index) {
		return hands.get(index);
	}
}
