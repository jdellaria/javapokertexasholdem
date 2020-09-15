package com.cantero.games.poker.texasholdem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class StartingHand {

	StartingHandEnum startingHand = StartingHandEnum.NULL;
	
	Card card1;
	Card card2;
	int count = 0;
	int winner = 0;
	int draw = 0;

	public String toString()
	{
	    return (super.toString());
	}

}
