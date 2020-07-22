package com.cantero.games.poker.texasholdem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Deck implements IDeck, Serializable {

	private static final long serialVersionUID = 2463644121163649891L;

	private List<Card> cards;
	private Random random;

	public Deck() {
		this(new Random());
	}

	public Deck(Random random) {
		this.random = random;
		createDeck();
	}

	private void createDeck() {
		cards = new ArrayList<Card>();
		for (CardSuitEnum suit : CardSuitEnum.values()) {
			for (CardRankEnum rank : CardRankEnum.values()) {
				cards.add(new Card(suit, rank));
			}
		}
	}

	public Card place(int cardNumber) {
		return cards.remove(cardNumber);
	}
	
	public Card pop() {
		return cards.remove(random.nextInt(cards.size()));
	}
	
	public int size() {
		return cards.size();
	}

	public Card place() {
		return cards.remove(0);
	}
}
