package com.cantero.games.poker.texasholdem;

import java.io.Serializable;
import java.util.List;


public class Player implements IPlayer, Serializable {

	private static final long serialVersionUID = 4664480702994610549L;

	private Card[] cards = new Card[2];

	private RankingEnum rankingEnum = null;

	private List<Card> rankingList = null;

	private Card highCard = null;

	private String Name = this.toString();
	
	public Player(String name) {
		this.Name = name;
	}
	
	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getName()
	{
		return Name;
	}

	public Card getHighCard() {
		return highCard;
	}

	public void setHighCard(Card highCard) {
		this.highCard = highCard;
	}

	public RankingEnum getRankingEnum() {
		return rankingEnum;
	}

	public void setRankingEnum(RankingEnum rankingEnum) {
		this.rankingEnum = rankingEnum;
	}

	public List<Card> getRankingList() {
		return rankingList;
	}

	public void setRankingList(List<Card> rankingList) {
		this.rankingList = rankingList;
	}

	public Card[] getCards() {
//		System.out.println("line " + cards.toString());
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}
}
