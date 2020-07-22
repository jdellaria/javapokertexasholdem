package com.cantero.games.poker.texasholdem;

public interface IDeck {
	public Card pop();
	public Card place();
	public int size();
	public Card place(int index);
}
