package com.cantero.games.poker.texasholdem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class GameTexasHoldemRunner {

	
	@SuppressWarnings("null")
	public static void mainJon(String[] args) throws IOException {


		IDeck deck = new Deck();
		Card card2 = new Card(CardSuitEnum.CLUBS, CardRankEnum.KING);
		Card card1 = new Card(CardSuitEnum.DIAMONDS, CardRankEnum.CARD_10);
		Card card3;
		Card card4;
		StartingHands allStartingHands = new StartingHands();

//		Map<String, Long> statsSimple = new HashMap<String, Long>();

		for (int i = 0; i < 1000000; i++) {
			GameTexasHoldem game = new GameTexasHoldem();
			IPlayer player1 = new Player("player1");
			IPlayer player2 = new Player("player2");
			IPlayer winner = new Player("winner");
			game.newGame(new Deck(), player1, player2);
			game.deal();

			game.callFlop();
			game.betTurn();
			game.betRiver();
			
			List<IPlayer> winnerList = game.getWinner();
			if (winnerList.size() == 1) {
				winner = game.getWinner().get(0);
				allStartingHands.add(winner.getCards()[0], winner.getCards()[1], StartingHandResultEnum.WIN);
				if (winner == player1)
				{
					allStartingHands.add(player2.getCards()[0], player2.getCards()[1], StartingHandResultEnum.LOSE);
				}
				else
				{
					allStartingHands.add(player1.getCards()[0], player1.getCards()[1], StartingHandResultEnum.LOSE);
				}
			} else {
				for (IPlayer player : winnerList) {
					allStartingHands.add(player.getCards()[0], player.getCards()[1], StartingHandResultEnum.DRAW);
				}
			}
		}

		String currDir = System.getProperty("user.dir");
		String path = currDir + "/2PlayerGame-1Million-StartingHands.csv";
		
		BufferedWriter bwFull = new BufferedWriter(new FileWriter(path));

		bwFull.write("item;Hand;Total Hands;Winner;Draw\n");
	
		
		for (int x = 0; x < allStartingHands.size(); x++)
		{
			bwFull.write(x + "; " + allStartingHands.get(x).startingHand.toString() + ";" + allStartingHands.get(x).count + ";" + allStartingHands.get(x).winner + ";" + allStartingHands.get(x).draw + "\n");

			System.out.println(x + ": " + allStartingHands.get(x).startingHand.toString() + "; " + allStartingHands.get(x).count + "; " + allStartingHands.get(x).winner + "; " + allStartingHands.get(x).draw);
		}
		//COUNT is how many times the same game occurs, PERCENT is the percentual of the COUNT compared with all executions
		System.out.println(" Table Cards ");
		bwFull.close();
	}
	
	
	public static void main(String[] args) throws IOException {
		Integer[] executionsList = new Integer[] { 10000, 100000 };
		for (Integer executions : executionsList) {
			//getMilliSecondsToExecute
			long milliSeconds = getMilliSecondsToExecute(executions);
			long seconds = milliSeconds / 1000;
			long minutes = seconds / 60;
			System.out.println("executions: " + executions + ", minutes: "
					+ minutes + ", seconds: " + seconds);
			String currDir = System.getProperty("user.dir");
			//getStatsSimple
			String simpleFileName = currDir + "/stats" + executions
					+ "-simple.csv";
//			getStatsSimple(simpleFileName, executions);
//			System.out.println("getStatsSimple - OK - " + simpleFileName);
			//getStatsFull

			
			String fullFileName = currDir + "/2PlayerGame" + executions + "-full.csv";
			/*
			run2PlayerGameFull(fullFileName, executions);
			System.out.println("run2PlayerGameFull - OK - " + fullFileName);
		
			fullFileName = currDir + "/3PlayerGame" + executions + "-full.csv";
			run3PlayerGameFull(fullFileName, executions);
			System.out.println("run3PlayerGameFull - OK - " + fullFileName);
			
			fullFileName = currDir + "/4PlayerGame" + executions + "-full.csv";
			run4PlayerGameFull(fullFileName, executions);
			System.out.println("run4PlayerGameFull - OK - " + fullFileName);
*/			
			fullFileName = currDir + "/5PlayerGame" + executions + "-full.csv";
			run5PlayerGameFull(fullFileName, executions);
			System.out.println("run5PlayerGameFull - OK - " + fullFileName);

//			fullFileName = currDir + "/FlushGame" + executions + "-full.csv";
//			run5PlayerGameFull(fullFileName, executions);
//			System.out.println("runFlushGame - OK - " + fullFileName);
			
//			run2PlayerGameFull(fullFileName, executions);
//			run2PlayerGameFullFLUSHProbability(fullFileName, executions);

		}
	}
	
	public static void main3PlayerGame(String[] args) throws IOException {
		GameTexasHoldem game = new GameTexasHoldem();
		IPlayer player1 = new Player("Jon");
		IPlayer player2 = new Player("Bene");
		IPlayer player3 = new Player("Maeva");
		List<IPlayer> winner;
		game.newGame(new Deck(), player1, player2, player3);
		System.out.println("Deal ");
		//		player.getCards()[1] = deck.pop();
//		player1.getCards()[0] = game.place();
//		player1.getCards()[1] = deck.place();
		game.deal();

		game.showAllPlayerCards();
		System.out.println(player1.getName() + " player1 rank " +  player1.getRankingEnum().toString());
		System.out.println(player2.getName() + " player2 rank " +  player2.getRankingEnum().toString());
		System.out.println(player3.getName() + " player3 rank " +  player3.getRankingEnum().toString());
//		System.out.println("player3 rank " +  player3.getRankingEnum().toString());
		showCurrentWinner( game );


		game.callFlop();
		System.out.println("");
		System.out.println("Flop ");
		game.showAllTableCards();
		System.out.println(player1.getName() + " player1 rank " +  player1.getRankingEnum().toString());
		System.out.println(player2.getName() + " player2 rank " +  player2.getRankingEnum().toString());
		System.out.println(player3.getName() + " player3 rank " +  player3.getRankingEnum().toString());
//		System.out.println("player3 rank " +  player3.getRankingEnum().toString());
		showCurrentWinner( game );
		
		System.out.println("");
		System.out.println("Turn ");
		game.betTurn();
		game.showAllTableCards();
		showCurrentWinner( game );
		System.out.println(player1.getName() + " player1 rank " +  player1.getRankingEnum().toString());
		System.out.println(player2.getName() + " player2 rank " +  player2.getRankingEnum().toString());
		System.out.println(player3.getName() + " player3 rank " +  player3.getRankingEnum().toString());
//		System.out.println("player3 rank " +  player3.getRankingEnum().toString());
		showCurrentWinner( game );

		System.out.println("");
		System.out.println("River ");
		game.betRiver();
		game.showAllTableCards();
		System.out.println(player1.getName() + " player1 rank " +  player1.getRankingEnum().toString());
		System.out.println(player2.getName() + " player2 rank " +  player2.getRankingEnum().toString());
		System.out.println(player3.getName() + " player3 rank " +  player3.getRankingEnum().toString());
//		System.out.println("player3 rank " +  player3.getRankingEnum().toString());
		showCurrentWinner( game );


	}
	
	public static void mainShowDeck(String[] args) throws IOException {
		GameTexasHoldem game = new GameTexasHoldem();
		IPlayer player = new Player();
		IPlayer dealer = new Player();
		List<IPlayer> winner;

		IDeck deck = new Deck();
		Card card;
		
		System.out.println("Deck  " + deck);
		
		for (int x = 0; x < 52; x++)
		{
			card = deck.pop();
			
			System.out.println("Deck pop " + x + ": " + card + " Deck size: " + deck.size());
		}



	}
	
	public static void mainOneTwoPlayerGame(String[] args) throws IOException {
		GameTexasHoldem game = new GameTexasHoldem();
		IPlayer player = new Player();
		IPlayer dealer = new Player();
		List<IPlayer> winner;
		game.newGame(new Deck(), dealer, player);
		System.out.println("Deal ");
		game.deal();

		game.showAllPlayerCards();
		System.out.println("Dealer rank " +  dealer.getRankingEnum().toString());;
		System.out.println("Player rank " +  player.getRankingEnum().toString());;
		showCurrentWinner( game );


		game.callFlop();
		System.out.println("");
		System.out.println("Flop ");
		game.showAllTableCards();
		System.out.println("Dealer rank " +  dealer.getRankingEnum().toString());;
		System.out.println("Player rank " +  player.getRankingEnum().toString());;
		showCurrentWinner( game );
		
		System.out.println("");
		System.out.println("Turn ");
		game.betTurn();
		game.showAllTableCards();
		showCurrentWinner( game );
		System.out.println("Dealer rank " +  dealer.getRankingEnum().toString());;
		System.out.println("Player rank " +  player.getRankingEnum().toString());;
		showCurrentWinner( game );

		System.out.println("");
		System.out.println("River ");
		game.betRiver();
		game.showAllTableCards();
		System.out.println("Dealer rank " +  dealer.getRankingEnum().toString());;
		System.out.println("Player rank " +  player.getRankingEnum().toString());;
		showCurrentWinner( game );
		
		


	}
	
	private static void showCurrentWinner(GameTexasHoldem game) {
		List<IPlayer> winners = game.getWinner();
		
		int index = 0;
		String winningPhrase = "The winners are: ";
		
		System.out.println("Winner size: " +  winners.size());
		
		if (winners.size() == 1) {
			winningPhrase = "The winner is: ";
		}
		else
		{
			System.out.println("Tie Game " );
		}
		System.out.println(winningPhrase);
		IPlayer myGuy;
		for (IPlayer player : winners) {
			myGuy = player;
			System.out.println(myGuy.getName());
		}
		for (index = 0; index < winners.size() ; index++) {
			myGuy = winners.get(index);
			System.out.println(myGuy.getName());
		}
		

	}

	
	public static void mainOrig(String[] args) throws IOException {
		Integer[] executionsList = new Integer[] { 10000, 100000 };
		for (Integer executions : executionsList) {
			//getMilliSecondsToExecute
			long milliSeconds = getMilliSecondsToExecute(executions);
			long seconds = milliSeconds / 1000;
			long minutes = seconds / 60;
			System.out.println("executions: " + executions + ", minutes: "
					+ minutes + ", seconds: " + seconds);
			String currDir = System.getProperty("user.dir");
			//getStatsSimple
			String simpleFileName = currDir + "/stats" + executions
					+ "-simple.csv";
			getStatsSimple(simpleFileName, executions);
			System.out.println("getStatsSimple - OK - " + simpleFileName);
			//getStatsFull
			String fullFileName = currDir + "/stats" + executions + "-full.csv";
			getStatsFull(fullFileName, executions);
			System.out.println("getStatsFull - OK - " + fullFileName);
		}
	}

	private static void getStatsFull(String path, int executions)
			throws IOException {
		Map<String, Long> statsSimple = new HashMap<String, Long>();
		BufferedWriter bwFull = new BufferedWriter(new FileWriter(path));
		//Header
		bwFull.write("DEALER DEAL;PLAYER DEAL;DEALER CALL FLOP;PLAYER CALL FLOP;DEALER BET TURN;PLAYER BET TURN;DEALER BET RIVER;PLAYER BET RIVER;WINNER;COUNT;PERCENT\n");
		for (int i = 0; i < executions; i++) {
			GameTexasHoldem game = new GameTexasHoldem();
			IPlayer player = new Player();
			IPlayer dealer = new Player();
			game.newGame(new Deck(), dealer, player);
			game.deal();
			String retLine = new String(dealer.getRankingEnum().toString()
					+ ";");
			retLine += player.getRankingEnum().toString() + ";";
			game.callFlop();
			retLine += dealer.getRankingEnum().toString() + ";";
			retLine += player.getRankingEnum().toString() + ";";
			game.betTurn();
			retLine += dealer.getRankingEnum().toString() + ";";
			retLine += player.getRankingEnum().toString() + ";";
			game.betRiver();
			retLine += dealer.getRankingEnum().toString() + ";";
			retLine += player.getRankingEnum().toString() + ";";
			List<IPlayer> winnerList = game.getWinner();
			if (winnerList.size() == 1) {
				retLine += (game.getWinner().get(0).equals(dealer)) ? "Dealer"
						: "Player";
			} else {
				retLine += "Draw Game";
			}
			Long count = statsSimple.get(retLine);
			if (count != null) {
				statsSimple.put(retLine, count + 1);
			} else {
				statsSimple.put(retLine, 1L);
			}
		}
		//COUNT is how many times the same game occurs, PERCENT is the percentual of the COUNT compared with all executions
		Iterator<String> it = statsSimple.keySet().iterator();
		while (it.hasNext()) {
			String stat = it.next();
			Long count = statsSimple.get(stat);
			bwFull.write(stat + ";" + count + ";"
					+ (double) ((count * 100) / (double) executions) + "%\n");
		}
		bwFull.close();
	}


	

	private static void run2PlayerGameFull(String path, int executions)
			throws IOException {
		Map<String, Long> statsSimple = new HashMap<String, Long>();
		BufferedWriter bwFull = new BufferedWriter(new FileWriter(path));
		StartingHands allStartingHands = new StartingHands();
		  
		//Header
		bwFull.write("Player1 DEAL;Player2 DEAL;"
				+ "Player1 CALL FLOP;Player2 CALL FLOP;"
				+ "Player1 BET TURN;Player2 BET TURN;"
				+ "Player1 BET RIVER;Player2 BET RIVER;"
				+ "WINNER;"
				+ "Player 1 Card1 Rank;Player 1 Card1 Suite;Player 1 Card2 Rank;Player 1 Card2 Suite;"
				+ "Player 2 Card1 Rank;Player 2 Card1 Suite;Player 2 Card2 Rank;Player 2 Card2 Suite;"
				+ "Winning Starting Hand;"
				+ "PAIR ACES;"
				+ "Take ACES;"
				+ "PAIR KINGS;"
				+ "Take KINGS;"
				+ "Table Card1 Rank;Table Card1 Suite;Table Card2 Rank;Table Card2 Suite;Table Card3 Rank;Table Card3 Suite;"
				+ "Table Card4 Rank;Table Card4 Suite;Table Card5 Rank;Table Card5 Suite\n");

		for (int i = 0; i < executions; i++) {
			GameTexasHoldem game = new GameTexasHoldem();
			IPlayer player1 = new Player("player1");
			IPlayer player2 = new Player("player2");
			IPlayer winner = new Player("winner");
			StartingHand myWinningHand = new StartingHand();
			
			game.newGame(new Deck(), player1, player2);
			game.deal();
			String retLine = new String(player1.getRankingEnum().toString()
					+ ";");
			retLine += player2.getRankingEnum().toString() + ";";
			game.callFlop();
			retLine += player1.getRankingEnum().toString() + ";";
			retLine += player2.getRankingEnum().toString() + ";";
			game.betTurn();
			retLine += player1.getRankingEnum().toString() + ";";
			retLine += player2.getRankingEnum().toString() + ";";
			game.betRiver();
			retLine += player1.getRankingEnum().toString() + ";";
			retLine += player2.getRankingEnum().toString() + ";";
			List<IPlayer> winnerList = game.getWinner();
			
		    if (winnerList.size() == 1) {
		    	winner = game.getWinner().get(0);
		    	retLine += (winner.getName()) + ";";
		        
		    	myWinningHand = allStartingHands.add(winner.getCards()[0], winner.getCards()[1], StartingHandResultEnum.WIN);
		        if (winner == player1)
		        {
		          allStartingHands.add(player2.getCards()[0], player2.getCards()[1], StartingHandResultEnum.LOSE);
		        }
		        else
		        {
		          allStartingHands.add(player1.getCards()[0], player1.getCards()[1], StartingHandResultEnum.LOSE);
		        }
		      } else {
		    	retLine += "Draw Game:";
		    	  
		        for (IPlayer player : winnerList) {
		        	retLine += player.getName() + " ";
		        	myWinningHand = allStartingHands.add(player.getCards()[0], player.getCards()[1], StartingHandResultEnum.DRAW);
		        }
		        retLine += ";";
		      }
			
//			game.showAllPlayerCards();
			retLine += player1.getCards()[0].getRank() + ";";
			retLine += player1.getCards()[0].getSuit() + ";";
			retLine += player1.getCards()[1].getRank() + ";";
			retLine += player1.getCards()[1].getSuit() + ";";
			retLine += player2.getCards()[0].getRank() + ";";
			retLine += player2.getCards()[0].getSuit() + ";";
			retLine += player2.getCards()[1].getRank() + ";";
			retLine += player2.getCards()[1].getSuit() + ";";
//			System.out.println(player.getName()  + " " + player1.getCards()[0].getRank() + " " +  player.getCards()[0].getSuit());
//			System.out.println(player.getName() + " " + player.getCards()[1].getRank() + " " +  player.getCards()[1].getSuit());

			retLine += myWinningHand.startingHand.toString() +";";
			if (player1.getCards()[0].getRank().toString().equals("ACE") && player1.getCards()[1].getRank().toString().equals("ACE"))
			{
				retLine += "ACES;";
				if ((winnerList.size() == 1) && (game.getWinner().get(0).getName().equals("player1")) )
				{
						retLine += "ACES Winner;";
				} else {
					retLine += ";";
				}
			}
			
			else if (player2.getCards()[0].getRank().toString().equals("ACE") && player2.getCards()[1].getRank().toString().equals("ACE"))
			{
				retLine += "ACES;";
				if ((winnerList.size() == 1) && (game.getWinner().get(0).getName().equals("player2")) )
				{
						retLine += "ACES Winner;";
				} else {
					retLine += ";";
				}
			}
			else
			{
				retLine += ";;";
			}

			
			if (player1.getCards()[0].getRank().toString().equals("KING") && player1.getCards()[1].getRank().toString().equals("KING"))
			{
				retLine += "KINGS;";
				if ((winnerList.size() == 1) && (game.getWinner().get(0).getName().equals("player1")) )
				{
						retLine += "KINGS Winner;";
				} else {
					retLine += ";";
				}
			}
			
			else if (player2.getCards()[0].getRank().toString().equals("KING") && player2.getCards()[1].getRank().toString().equals("KING"))
			{
				retLine += "KINGS;";
				if ((winnerList.size() == 1) && (game.getWinner().get(0).getName().equals("player2")) )
				{
						retLine += "KINGS Winner;";
				} else {
					retLine += ";";
				}
			}
			else
			{
				retLine += ";;";
			}
			
			
			List<Card> tableCards = game.getTableCards();
			int x = 0;
			for (Card card : tableCards) {
				retLine +=  card.getRank() + ";" + card.getSuit() + ";";
//				System.out.println("Table Card " + card.getRank() + " " + card.getSuit());
				x++;
			}
//			System.out.println(x + " Table Cards ");
			
			Long count = statsSimple.get(retLine);
			if (count != null) {
				statsSimple.put(retLine, count + 1);
			} else {
				statsSimple.put(retLine, 1L);
			}
		}
		//COUNT is how many times the same game occurs, PERCENT is the percentual of the COUNT compared with all executions
		Iterator<String> it = statsSimple.keySet().iterator();
		while (it.hasNext()) {
			String stat = it.next();
			Long count = statsSimple.get(stat);
			bwFull.write(stat + ";" + count + ";"
					+ (double) ((count * 100) / (double) executions) + "%\n");
		}
		bwFull.close();
	}




	private static void run2PlayerGameFullFLUSHProbability(String path, int executions)
			throws IOException {
		Map<String, Long> statsSimple = new HashMap<String, Long>();
		BufferedWriter bwFull = new BufferedWriter(new FileWriter(path));
		//Header
		bwFull.write("Player1 DEAL;Player2 DEAL;"
				+ "Player1 CALL FLOP;Player2 CALL FLOP;"
				+ "Player1 BET TURN;Player2 BET TURN;"
				+ "Player1 BET RIVER;Player2 BET RIVER;"
				+ "WINNER;"
				+ "Player 1 Card1 Rank;Player 1 Card1 Suite;Player 1 Card2 Rank;Player 1 Card2 Suite;"
				+ "Player 2 Card1 Rank;Player 2 Card1 Suite;Player 2 Card2 Rank;Player 2 Card2 Suite;"
				+ "Posssible Table Flush;"
				+ "Table Flush;"
				+ "Table Card1 Rank;Table Card1 Suite;Table Card2 Rank;Table Card2 Suite;Table Card3 Rank;Table Card3 Suite;"
				+ "Table Card4 Rank;Table Card4 Suite;Table Card5 Rank;Table Card5 Suite\n");

		for (int i = 0; i < executions; i++) {
			GameTexasHoldem game = new GameTexasHoldem();
			IPlayer player1 = new Player("player1");
			IPlayer player2 = new Player("player2");
			game.newGame(new Deck(), player1, player2);
			game.deal();
			String retLine = new String(player1.getRankingEnum().toString()
					+ ";");
			retLine += player2.getRankingEnum().toString() + ";";
			game.callFlop();
			retLine += player1.getRankingEnum().toString() + ";";
			retLine += player2.getRankingEnum().toString() + ";";
			game.betTurn();
			retLine += player1.getRankingEnum().toString() + ";";
			retLine += player2.getRankingEnum().toString() + ";";
			game.betRiver();
			retLine += player1.getRankingEnum().toString() + ";";
			retLine += player2.getRankingEnum().toString() + ";";
			List<IPlayer> winnerList = game.getWinner();
			if (winnerList.size() == 1) {
				retLine += (game.getWinner().get(0).getName()) + ";";
			} else {
				retLine += "Draw Game:";
				
//				IPlayer myGuy;
				for (IPlayer player : winnerList) {
//					myGuy = player;
					retLine += player.getName() + " ";
//					System.out.println(myGuy.getName());
				}
				retLine += ";";
			}
			
//			game.showAllPlayerCards();
			retLine += player1.getCards()[0].getRank() + ";";
			retLine += player1.getCards()[0].getSuit() + ";";
			retLine += player1.getCards()[1].getRank() + ";";
			retLine += player1.getCards()[1].getSuit() + ";";
			retLine += player2.getCards()[0].getRank() + ";";
			retLine += player2.getCards()[0].getSuit() + ";";
			retLine += player2.getCards()[1].getRank() + ";";
			retLine += player2.getCards()[1].getSuit() + ";";
//			System.out.println(player.getName()  + " " + player1.getCards()[0].getRank() + " " +  player.getCards()[0].getSuit());
//			System.out.println(player.getName() + " " + player.getCards()[1].getRank() + " " +  player.getCards()[1].getSuit());


			List<Card> tableCards = game.getTableCards();
			CardSuitEnum mySuit;
			int x = 0;
			mySuit = tableCards.get(0).getSuit();
			if (tableCards.get(0).getSuit().equals(tableCards.get(1).getSuit()))
			{
				System.out.println("Matching SUIT");
				x++;
				mySuit = tableCards.get(0).getSuit();
				retLine += "PFLUSH;";
			}
			else if (tableCards.get(0).getSuit().equals(tableCards.get(2).getSuit()))
			{
				System.out.println("Matching SUIT");
				x++;
				mySuit = tableCards.get(0).getSuit();
				retLine += "PFLUSH;";
			}
			else if (tableCards.get(1).getSuit().equals(tableCards.get(2).getSuit()))
			{
				System.out.println("Matching SUIT");
				x++;
				mySuit = tableCards.get(1).getSuit();
				retLine += "PFLUSH;";
			}
			else
			{
				retLine += ";";
			}
			if (x == 1)
			{
				System.out.println("First 3 Table Cards have 2 of the Same SUIT");
				if (tableCards.get(3).getSuit().equals(mySuit))
				{
					System.out.println("Flush was made");
					retLine += "TFLUSH;";
				}
				else if (tableCards.get(4).getSuit().equals(mySuit))
				{
					System.out.println("Flush was made");
					retLine += "TFLUSH;";
				}
				else
				{
					System.out.println("Flush was NOT made");
					retLine += ";";
				}
			}
			else
			{
				retLine += ";";
			}
			for (Card card : tableCards) {

				retLine +=  card.getRank() + ";" + card.getSuit() + ";";
//				System.out.println("Table Card " + card.getRank() + " " + card.getSuit());
				x++;
			}
//			System.out.println(x + " Table Cards ");
			
			Long count = statsSimple.get(retLine);
			if (count != null) {
				statsSimple.put(retLine, count + 1);
			} else {
				statsSimple.put(retLine, 1L);
			}
		}
		//COUNT is how many times the same game occurs, PERCENT is the percentual of the COUNT compared with all executions
		Iterator<String> it = statsSimple.keySet().iterator();
		while (it.hasNext()) {
			String stat = it.next();
			Long count = statsSimple.get(stat);
			bwFull.write(stat + ";" + count + ";"
					+ (double) ((count * 100) / (double) executions) + "%\n");
		}
		bwFull.close();
	}


	private static void run3PlayerGameFull(String path, int executions)
			throws IOException {
		Map<String, Long> statsSimple = new HashMap<String, Long>();
		BufferedWriter bwFull = new BufferedWriter(new FileWriter(path));
		//Header
		bwFull
				.write("Player1 DEAL;Player2 DEAL;Player3 DEAL;"
						+ "Player1 CALL FLOP;Player2 CALL FLOP;Player3 CALL FLOP;"
						+ "Player1 BET TURN;Player2 BET TURN;Player3 BET TURN;"
						+ "Player1 BET RIVER;Player2 BET RIVER;Player3 BET RIVER;"
						+ "WINNER;"
						+ "Player 1 Card1 Rank;Player 1 Card1 Suite;Player 1 Card2 Rank;Player 1 Card2 Suite;"
						+ "Player 2 Card1 Rank;Player 2 Card1 Suite;Player 2 Card2 Rank;Player 2 Card2 Suite;"
						+ "Player 3 Card1 Rank;Player 3 Card1 Suite;Player 3 Card2 Rank;Player 3 Card2 Suite;"
						+ "PAIRS;"
						+ "Take ACES;"
						+ "Table Card1 Rank;Table Card1 Suite;Table Card2 Rank;Table Card2 Suite;Table Card3 Rank;Table Card3 Suite;"
						+ "Table Card4 Rank;Table Card4 Suite;Table Card5 Rank;Table Card5 Suite\n");
		for (int i = 0; i < executions; i++) {
			GameTexasHoldem game = new GameTexasHoldem();
			IPlayer player1 = new Player("player1");
			IPlayer player2 = new Player("player2");
			IPlayer player3 = new Player("player3");
			game.newGame(new Deck(), player1, player2, player3);
			
			game.deal();
			String retLine = new String(player1.getRankingEnum().toString()
					+ ";");
			retLine += player2.getRankingEnum().toString() + ";";
			retLine += player3.getRankingEnum().toString() + ";";

			
			game.callFlop();
			retLine += player1.getRankingEnum().toString() + ";";
			retLine += player2.getRankingEnum().toString() + ";";
			retLine += player3.getRankingEnum().toString() + ";";
			
			game.betTurn();
			retLine += player1.getRankingEnum().toString() + ";";
			retLine += player2.getRankingEnum().toString() + ";";
			retLine += player3.getRankingEnum().toString() + ";";
			
			game.betRiver();
			retLine += player1.getRankingEnum().toString() + ";";
			retLine += player2.getRankingEnum().toString() + ";";
			retLine += player3.getRankingEnum().toString() + ";";
			
			List<IPlayer> winnerList = game.getWinner();
			if (winnerList.size() == 1) {
				retLine += (game.getWinner().get(0).getName()) + ";";
			} else {
				retLine += "Draw Game:";
				
//				IPlayer myGuy;
				for (IPlayer player : winnerList) {
//					myGuy = player;
					retLine += player.getName() + " ";
//					System.out.println(myGuy.getName());
				}
				retLine += ";";
			}
			
//			game.showAllPlayerCards();
			retLine += player1.getCards()[0].getRank() + ";";
			retLine += player1.getCards()[0].getSuit() + ";";
			retLine += player1.getCards()[1].getRank() + ";";
			retLine += player1.getCards()[1].getSuit() + ";";
			
			retLine += player2.getCards()[0].getRank() + ";";
			retLine += player2.getCards()[0].getSuit() + ";";
			retLine += player2.getCards()[1].getRank() + ";";
			retLine += player2.getCards()[1].getSuit() + ";";
			
			retLine += player3.getCards()[0].getRank() + ";";
			retLine += player3.getCards()[0].getSuit() + ";";
			retLine += player3.getCards()[1].getRank() + ";";
			retLine += player3.getCards()[1].getSuit() + ";";
/*
			if (player1.getCards()[0].getRank() == player1.getCards()[1].getRank())
			{
				retLine += "PAIR;";
			}
			
			else if (player2.getCards()[0].getRank() == player2.getCards()[1].getRank())
			{
				retLine += "PAIR;";
			}
			else if (player3.getCards()[0].getRank() == player3.getCards()[1].getRank())
			{
				retLine += "PAIR;";
			}
			else
			{
				retLine += ";";
			}*/
			
			if (player1.getCards()[0].getRank().toString().equals("ACE") && player1.getCards()[1].getRank().toString().equals("ACE"))
			{
				retLine += "ACES;";
				if ((winnerList.size() == 1) && (game.getWinner().get(0).getName().equals("player1")) )
				{
						retLine += "ACES Winner;";
				} else {
					retLine += ";";
				}
			}
			
			else if (player2.getCards()[0].getRank().toString().equals("ACE") && player2.getCards()[1].getRank().toString().equals("ACE"))
			{
				retLine += "ACES;";
				if ((winnerList.size() == 1) && (game.getWinner().get(0).getName().equals("player2")) )
				{
						retLine += "ACES Winner;";
				} else {
					retLine += ";";
				}
			}
			else if (player3.getCards()[0].getRank().toString().equals("ACE") && player3.getCards()[1].getRank().toString().equals("ACE"))
			{
				retLine += "ACES;";
				if ((winnerList.size() == 1) && (game.getWinner().get(0).getName().equals("player3")) )
				{
						retLine += "ACES Winner;";
				} else {
					retLine += ";";
				}
			}
			else
			{
				retLine += ";;";
			}
			
//			System.out.println(player.getName()  + " " + player1.getCards()[0].getRank() + " " +  player.getCards()[0].getSuit());
//			System.out.println(player.getName() + " " + player.getCards()[1].getRank() + " " +  player.getCards()[1].getSuit());

			List<Card> tableCards = game.getTableCards();
//			int x = 0;
			for (Card card : tableCards) {
				retLine +=  card.getRank() + ";" + card.getSuit() + ";";
//				System.out.println("Table Card " + card.getRank() + " " + card.getSuit());
//				x++;
			}
//			System.out.println(x + " Table Cards ");
			
			Long count = statsSimple.get(retLine);
			if (count != null) {
				statsSimple.put(retLine, count + 1);
			} else {
				statsSimple.put(retLine, 1L);
			}
		}
		//COUNT is how many times the same game occurs, PERCENT is the percentual of the COUNT compared with all executions
		Iterator<String> it = statsSimple.keySet().iterator();
		while (it.hasNext()) {
			String stat = it.next();
			Long count = statsSimple.get(stat);
			bwFull.write(stat + ";" + count + ";"
					+ (double) ((count * 100) / (double) executions) + "%\n");
		}
		bwFull.close();
	}


	private static void run4PlayerGameFull(String path, int executions)
			throws IOException {
		Map<String, Long> statsSimple = new HashMap<String, Long>();
		BufferedWriter bwFull = new BufferedWriter(new FileWriter(path));
		//Header
		bwFull
				.write("Player1 DEAL;Player2 DEAL;Player3 DEAL;Player4 DEAL;"
						+ "Player1 CALL FLOP;Player2 CALL FLOP;Player3 CALL FLOP;Player4 CALL FLOP;"
						+ "Player1 BET TURN;Player2 BET TURN;Player3 BET TURN;Player4 BET TURN;"
						+ "Player1 BET RIVER;Player2 BET RIVER;Player3 BET RIVER;Player4 BET RIVER;"
						+ "WINNER;"
						+ "Player 1 Card1 Rank;Player 1 Card1 Suite;Player 1 Card2 Rank;Player 1 Card2 Suite;"
						+ "Player 2 Card1 Rank;Player 2 Card1 Suite;Player 2 Card2 Rank;Player 2 Card2 Suite;"
						+ "Player 3 Card1 Rank;Player 3 Card1 Suite;Player 3 Card2 Rank;Player 3 Card2 Suite;"
						+ "Player 4 Card1 Rank;Player 4 Card1 Suite;Player 4 Card2 Rank;Player 4 Card2 Suite;"
						+ "PAIRS;"
						+ "Take ACES;"
						+ "Table Card1 Rank;Table Card1 Suite;Table Card2 Rank;Table Card2 Suite;Table Card3 Rank;Table Card3 Suite;"
						+ "Table Card4 Rank;Table Card4 Suite;Table Card5 Rank;Table Card5 Suite\n");
		for (int i = 0; i < executions; i++) {
			GameTexasHoldem game = new GameTexasHoldem();
			IPlayer player1 = new Player("player1");
			IPlayer player2 = new Player("player2");
			IPlayer player3 = new Player("player3");
			IPlayer player4 = new Player("player4");
			game.newGame(new Deck(), player1, player2, player3, player4);
			
			game.deal();
			String retLine = new String(player1.getRankingEnum().toString()
					+ ";");
			retLine += player2.getRankingEnum().toString() + ";";
			retLine += player3.getRankingEnum().toString() + ";";
			retLine += player4.getRankingEnum().toString() + ";";
			
			game.callFlop();
			retLine += player1.getRankingEnum().toString() + ";";
			retLine += player2.getRankingEnum().toString() + ";";
			retLine += player3.getRankingEnum().toString() + ";";
			retLine += player4.getRankingEnum().toString() + ";";
			
			game.betTurn();
			retLine += player1.getRankingEnum().toString() + ";";
			retLine += player2.getRankingEnum().toString() + ";";
			retLine += player3.getRankingEnum().toString() + ";";
			retLine += player4.getRankingEnum().toString() + ";";
			
			game.betRiver();
			retLine += player1.getRankingEnum().toString() + ";";
			retLine += player2.getRankingEnum().toString() + ";";
			retLine += player3.getRankingEnum().toString() + ";";
			retLine += player4.getRankingEnum().toString() + ";";
			
			List<IPlayer> winnerList = game.getWinner();
			if (winnerList.size() == 1) {
				retLine += (game.getWinner().get(0).getName()) + ";";
			} else {
				retLine += "Draw Game:";
				
//				IPlayer myGuy;
				for (IPlayer player : winnerList) {
//					myGuy = player;
					retLine += player.getName() + " ";
//					System.out.println(myGuy.getName());
				}
				retLine += ";";
			}
			
//			game.showAllPlayerCards();
			retLine += player1.getCards()[0].getRank() + ";";
			retLine += player1.getCards()[0].getSuit() + ";";
			retLine += player1.getCards()[1].getRank() + ";";
			retLine += player1.getCards()[1].getSuit() + ";";
			
			retLine += player2.getCards()[0].getRank() + ";";
			retLine += player2.getCards()[0].getSuit() + ";";
			retLine += player2.getCards()[1].getRank() + ";";
			retLine += player2.getCards()[1].getSuit() + ";";
			
			retLine += player3.getCards()[0].getRank() + ";";
			retLine += player3.getCards()[0].getSuit() + ";";
			retLine += player3.getCards()[1].getRank() + ";";
			retLine += player3.getCards()[1].getSuit() + ";";
			
			retLine += player4.getCards()[0].getRank() + ";";
			retLine += player4.getCards()[0].getSuit() + ";";
			retLine += player4.getCards()[1].getRank() + ";";
			retLine += player4.getCards()[1].getSuit() + ";";
/*
			if (player1.getCards()[0].getRank() == player1.getCards()[1].getRank())
			{
				retLine += "PAIR;";
			}
			
			else if (player2.getCards()[0].getRank() == player2.getCards()[1].getRank())
			{
				retLine += "PAIR;";
			}
			else if (player3.getCards()[0].getRank() == player3.getCards()[1].getRank())
			{
				retLine += "PAIR;";
			}
			else
			{
				retLine += ";";
			}*/
			
			if (player1.getCards()[0].getRank().toString().equals("ACE") && player1.getCards()[1].getRank().toString().equals("ACE"))
			{
				retLine += "ACES;";
				if ((winnerList.size() == 1) && (game.getWinner().get(0).getName().equals("player1")) )
				{
						retLine += "ACES Winner;";
				} else {
					retLine += ";";
				}
			}
			
			else if (player2.getCards()[0].getRank().toString().equals("ACE") && player2.getCards()[1].getRank().toString().equals("ACE"))
			{
				retLine += "ACES;";
				if ((winnerList.size() == 1) && (game.getWinner().get(0).getName().equals("player2")) )
				{
						retLine += "ACES Winner;";
				} else {
					retLine += ";";
				}
			}
			else if (player3.getCards()[0].getRank().toString().equals("ACE") && player3.getCards()[1].getRank().toString().equals("ACE"))
			{
				retLine += "ACES;";
				if ((winnerList.size() == 1) && (game.getWinner().get(0).getName().equals("player3")) )
				{
						retLine += "ACES Winner;";
				} else {
					retLine += ";";
				}
			}
			else if (player4.getCards()[0].getRank().toString().equals("ACE") && player4.getCards()[1].getRank().toString().equals("ACE"))
			{
				retLine += "ACES;";
				if ((winnerList.size() == 1) && (game.getWinner().get(0).getName().equals("player4")) )
				{
						retLine += "ACES Winner;";
				} else {
					retLine += ";";
				}
			}
			else
			{
				retLine += ";;";
			}
			
//			System.out.println(player.getName()  + " " + player1.getCards()[0].getRank() + " " +  player.getCards()[0].getSuit());
//			System.out.println(player.getName() + " " + player.getCards()[1].getRank() + " " +  player.getCards()[1].getSuit());

			List<Card> tableCards = game.getTableCards();
//			int x = 0;
			for (Card card : tableCards) {
				retLine +=  card.getRank() + ";" + card.getSuit() + ";";
//				System.out.println("Table Card " + card.getRank() + " " + card.getSuit());
//				x++;
			}
//			System.out.println(x + " Table Cards ");
			
			Long count = statsSimple.get(retLine);
			if (count != null) {
				statsSimple.put(retLine, count + 1);
			} else {
				statsSimple.put(retLine, 1L);
			}
		}
		//COUNT is how many times the same game occurs, PERCENT is the percentual of the COUNT compared with all executions
		Iterator<String> it = statsSimple.keySet().iterator();
		while (it.hasNext()) {
			String stat = it.next();
			Long count = statsSimple.get(stat);
			bwFull.write(stat + ";" + count + ";"
					+ (double) ((count * 100) / (double) executions) + "%\n");
		}
		bwFull.close();
	}


	private static void run5PlayerGameFull(String path, int executions)
			throws IOException {
		Map<String, Long> statsSimple = new HashMap<String, Long>();
		BufferedWriter bwFull = new BufferedWriter(new FileWriter(path));
		
		StartingHands allStartingHands = new StartingHands();
		//Header
		bwFull
				.write("Player1 DEAL;Player2 DEAL;Player3 DEAL;Player4 DEAL;Player5 DEAL;"
						+ "Player1 CALL FLOP;Player2 CALL FLOP;Player3 CALL FLOP;Player4 CALL FLOP;Player5 CALL FLOP;"
						+ "Player1 BET TURN;Player2 BET TURN;Player3 BET TURN;Player4 BET TURN;Player5 BET TURN;"
						+ "Player1 BET RIVER;Player2 BET RIVER;Player3 BET RIVER;Player4 BET RIVER;Player4 BET RIVER;"
						+ "WINNER;"
						+ "Player 1 Card1 Rank;Player 1 Card1 Suite;Player 1 Card2 Rank;Player 1 Card2 Suite;"
						+ "Player 2 Card1 Rank;Player 2 Card1 Suite;Player 2 Card2 Rank;Player 2 Card2 Suite;"
						+ "Player 3 Card1 Rank;Player 3 Card1 Suite;Player 3 Card2 Rank;Player 3 Card2 Suite;"
						+ "Player 4 Card1 Rank;Player 4 Card1 Suite;Player 4 Card2 Rank;Player 4 Card2 Suite;"
						+ "Player 5 Card1 Rank;Player 5 Card1 Suite;Player 5 Card2 Rank;Player 5 Card2 Suite;"
					    + "Winning Starting Hand;"
					    + "Player 1 Starting Hand;"
					    + "Player 2 Starting Hand;"	
					    + "Player 3 Starting Hand;"
					    + "Player 4 Starting Hand;"
					    + "Player 5 Starting Hand;"
						+ "PAIRS;"
						+ "Take ACES;"
						+ "Table Card1 Rank;Table Card1 Suite;Table Card2 Rank;Table Card2 Suite;Table Card3 Rank;Table Card3 Suite;"
						+ "Table Card4 Rank;Table Card4 Suite;Table Card5 Rank;Table Card5 Suite\n");
		for (int i = 0; i < executions; i++) {
			GameTexasHoldem game = new GameTexasHoldem();
			IPlayer player1 = new Player("player1");
			IPlayer player2 = new Player("player2");
			IPlayer player3 = new Player("player3");
			IPlayer player4 = new Player("player4");
			IPlayer player5 = new Player("player5");
		    IPlayer winner = new Player("winner");
		    StartingHand myWinningHand = new StartingHand();
		    StartingHand player1StartingHand = new StartingHand();
		    StartingHand player2StartingHand = new StartingHand();
		    StartingHand player3StartingHand = new StartingHand();
		    StartingHand player4StartingHand = new StartingHand();
		    StartingHand player5StartingHand = new StartingHand();
		    
			game.newGame(new Deck(), player1, player2, player3, player4, player5);
			
			game.deal();
			String retLine = new String(player1.getRankingEnum().toString()
					+ ";");
			retLine += player2.getRankingEnum().toString() + ";";
			retLine += player3.getRankingEnum().toString() + ";";
			retLine += player4.getRankingEnum().toString() + ";";
			retLine += player5.getRankingEnum().toString() + ";";
			
			game.callFlop();
			retLine += player1.getRankingEnum().toString() + ";";
			retLine += player2.getRankingEnum().toString() + ";";
			retLine += player3.getRankingEnum().toString() + ";";
			retLine += player4.getRankingEnum().toString() + ";";
			retLine += player5.getRankingEnum().toString() + ";";
			
			game.betTurn();
			retLine += player1.getRankingEnum().toString() + ";";
			retLine += player2.getRankingEnum().toString() + ";";
			retLine += player3.getRankingEnum().toString() + ";";
			retLine += player4.getRankingEnum().toString() + ";";
			retLine += player5.getRankingEnum().toString() + ";";
			
			game.betRiver();
			retLine += player1.getRankingEnum().toString() + ";";
			retLine += player2.getRankingEnum().toString() + ";";
			retLine += player3.getRankingEnum().toString() + ";";
			retLine += player4.getRankingEnum().toString() + ";";
			retLine += player5.getRankingEnum().toString() + ";";
			
			List<IPlayer> winnerList = game.getWinner();
/*			if (winnerList.size() == 1) {
				retLine += (game.getWinner().get(0).getName()) + ";";
			} else {
				retLine += "Draw Game:";
				
//				IPlayer myGuy;
				for (IPlayer player : winnerList) {
//					myGuy = player;
					retLine += player.getName() + " ";
//					System.out.println(myGuy.getName());
				}
				retLine += ";";
			}*/
			
	      if (winnerList.size() == 1) {
	          winner = game.getWinner().get(0);
	          retLine += (winner.getName()) + ";";
	            
	          myWinningHand = allStartingHands.add(winner.getCards()[0], winner.getCards()[1], StartingHandResultEnum.WIN);
	            if (winner == player1)
	            {
	              player2StartingHand = allStartingHands.add(player2.getCards()[0], player2.getCards()[1], StartingHandResultEnum.LOSE);
	              player3StartingHand = allStartingHands.add(player3.getCards()[0], player3.getCards()[1], StartingHandResultEnum.LOSE);
	              player4StartingHand = allStartingHands.add(player4.getCards()[0], player4.getCards()[1], StartingHandResultEnum.LOSE);
	              player5StartingHand = allStartingHands.add(player5.getCards()[0], player5.getCards()[1], StartingHandResultEnum.LOSE);
	              player1StartingHand = myWinningHand ;
	              
	            }
	            else if (winner == player2)
	            {
	            	
					player1StartingHand = allStartingHands.add(player1.getCards()[0], player1.getCards()[1], StartingHandResultEnum.LOSE);
					player3StartingHand = allStartingHands.add(player3.getCards()[0], player3.getCards()[1], StartingHandResultEnum.LOSE);
					player4StartingHand = allStartingHands.add(player4.getCards()[0], player4.getCards()[1], StartingHandResultEnum.LOSE);
					player5StartingHand = allStartingHands.add(player5.getCards()[0], player5.getCards()[1], StartingHandResultEnum.LOSE);
					player2StartingHand = myWinningHand ;
	            }
	            else if (winner == player3)
	            {
	            	player1StartingHand = allStartingHands.add(player1.getCards()[0], player1.getCards()[1], StartingHandResultEnum.LOSE);
	            	player2StartingHand = allStartingHands.add(player2.getCards()[0], player2.getCards()[1], StartingHandResultEnum.LOSE);
	            	player4StartingHand = allStartingHands.add(player4.getCards()[0], player4.getCards()[1], StartingHandResultEnum.LOSE);
	            	player5StartingHand = allStartingHands.add(player5.getCards()[0], player5.getCards()[1], StartingHandResultEnum.LOSE);
	              player3StartingHand = myWinningHand ;
	            }
	            else if (winner == player4)
	            {
	            	player1StartingHand = allStartingHands.add(player1.getCards()[0], player1.getCards()[1], StartingHandResultEnum.LOSE);
	            	player2StartingHand = allStartingHands.add(player2.getCards()[0], player2.getCards()[1], StartingHandResultEnum.LOSE);
	            	player3StartingHand =  allStartingHands.add(player3.getCards()[0], player3.getCards()[1], StartingHandResultEnum.LOSE);
	            	player5StartingHand = allStartingHands.add(player5.getCards()[0], player5.getCards()[1], StartingHandResultEnum.LOSE);
	              player4StartingHand = myWinningHand ;
	            }
	            else if (winner == player5)
	            {
	            	player1StartingHand = allStartingHands.add(player1.getCards()[0], player1.getCards()[1], StartingHandResultEnum.LOSE);
	            	player2StartingHand = allStartingHands.add(player2.getCards()[0], player2.getCards()[1], StartingHandResultEnum.LOSE);
	            	player3StartingHand = allStartingHands.add(player3.getCards()[0], player3.getCards()[1], StartingHandResultEnum.LOSE);
	            	player4StartingHand = allStartingHands.add(player4.getCards()[0], player4.getCards()[1], StartingHandResultEnum.LOSE);
	              player5StartingHand = myWinningHand ;
	            }
	          } else {
	          retLine += "Draw Game:";
	            
	            for (IPlayer player : winnerList) {
	              retLine += player.getName() + " ";
	              myWinningHand = allStartingHands.add(player.getCards()[0], player.getCards()[1], StartingHandResultEnum.DRAW);
	            }
	            retLine += ";";
	          }
			
//			game.showAllPlayerCards();
			retLine += player1.getCards()[0].getRank() + ";";
			retLine += player1.getCards()[0].getSuit() + ";";
			retLine += player1.getCards()[1].getRank() + ";";
			retLine += player1.getCards()[1].getSuit() + ";";
			
			retLine += player2.getCards()[0].getRank() + ";";
			retLine += player2.getCards()[0].getSuit() + ";";
			retLine += player2.getCards()[1].getRank() + ";";
			retLine += player2.getCards()[1].getSuit() + ";";
			
			retLine += player3.getCards()[0].getRank() + ";";
			retLine += player3.getCards()[0].getSuit() + ";";
			retLine += player3.getCards()[1].getRank() + ";";
			retLine += player3.getCards()[1].getSuit() + ";";
			
			retLine += player4.getCards()[0].getRank() + ";";
			retLine += player4.getCards()[0].getSuit() + ";";
			retLine += player4.getCards()[1].getRank() + ";";
			retLine += player4.getCards()[1].getSuit() + ";";
			
			retLine += player5.getCards()[0].getRank() + ";";
			retLine += player5.getCards()[0].getSuit() + ";";
			retLine += player5.getCards()[1].getRank() + ";";
			retLine += player5.getCards()[1].getSuit() + ";";

			retLine += myWinningHand.startingHand.toString() +";";
			retLine += player1StartingHand.startingHand.toString() +";";
			retLine += player2StartingHand.startingHand.toString() +";";
			retLine += player3StartingHand.startingHand.toString() +";";
			retLine += player4StartingHand.startingHand.toString() +";";
			retLine += player5StartingHand.startingHand.toString() +";";

/*
			if (player1.getCards()[0].getRank() == player1.getCards()[1].getRank())
			{
				retLine += "PAIR;";
			}
			
			else if (player2.getCards()[0].getRank() == player2.getCards()[1].getRank())
			{
				retLine += "PAIR;";
			}
			else if (player3.getCards()[0].getRank() == player3.getCards()[1].getRank())
			{
				retLine += "PAIR;";
			}
			else
			{
				retLine += ";";
			}*/
			
			if (player1.getCards()[0].getRank().toString().equals("ACE") && player1.getCards()[1].getRank().toString().equals("ACE"))
			{
				retLine += "ACES;";
				if ((winnerList.size() == 1) && (game.getWinner().get(0).getName().equals("player1")) )
				{
						retLine += "ACES Winner;";
				} else {
					retLine += ";";
				}
			}
			
			else if (player2.getCards()[0].getRank().toString().equals("ACE") && player2.getCards()[1].getRank().toString().equals("ACE"))
			{
				retLine += "ACES;";
				if ((winnerList.size() == 1) && (game.getWinner().get(0).getName().equals("player2")) )
				{
						retLine += "ACES Winner;";
				} else {
					retLine += ";";
				}
			}
			else if (player3.getCards()[0].getRank().toString().equals("ACE") && player3.getCards()[1].getRank().toString().equals("ACE"))
			{
				retLine += "ACES;";
				if ((winnerList.size() == 1) && (game.getWinner().get(0).getName().equals("player3")) )
				{
						retLine += "ACES Winner;";
				} else {
					retLine += ";";
				}
			}
			else if (player4.getCards()[0].getRank().toString().equals("ACE") && player4.getCards()[1].getRank().toString().equals("ACE"))
			{
				retLine += "ACES;";
				if ((winnerList.size() == 1) && (game.getWinner().get(0).getName().equals("player4")) )
				{
						retLine += "ACES Winner;";
				} else {
					retLine += ";";
				}
			}
			else if (player5.getCards()[0].getRank().toString().equals("ACE") && player5.getCards()[1].getRank().toString().equals("ACE"))
			{
				retLine += "ACES;";
				if ((winnerList.size() == 1) && (game.getWinner().get(0).getName().equals("player5")) )
				{
						retLine += "ACES Winner;";
				} else {
					retLine += ";";
				}
			}
			else
			{
				retLine += ";;";
			}
			
//			System.out.println(player.getName()  + " " + player1.getCards()[0].getRank() + " " +  player.getCards()[0].getSuit());
//			System.out.println(player.getName() + " " + player.getCards()[1].getRank() + " " +  player.getCards()[1].getSuit());

			List<Card> tableCards = game.getTableCards();
//			int x = 0;
			for (Card card : tableCards) {
				retLine +=  card.getRank() + ";" + card.getSuit() + ";";
//				System.out.println("Table Card " + card.getRank() + " " + card.getSuit());
//				x++;
			}
//			System.out.println(x + " Table Cards ");
			
			Long count = statsSimple.get(retLine);
			if (count != null) {
				statsSimple.put(retLine, count + 1);
			} else {
				statsSimple.put(retLine, 1L);
			}
		}
		//COUNT is how many times the same game occurs, PERCENT is the percentual of the COUNT compared with all executions
		Iterator<String> it = statsSimple.keySet().iterator();
		while (it.hasNext()) {
			String stat = it.next();
			Long count = statsSimple.get(stat);
			bwFull.write(stat + ";" + count + ";"
					+ (double) ((count * 100) / (double) executions) + "%\n");
		}
		bwFull.close();
		
		String currDir = System.getProperty("user.dir");
		
		String path2 = currDir + "/5PlayerGame-StartingHands" + executions
				+ "-stats.csv";

		BufferedWriter bwStartingHands = new BufferedWriter(new FileWriter(path2));
		
		bwStartingHands.write("item;Hand;Total Hands;Winner;Draw\n");


		for (int x = 0; x < allStartingHands.size(); x++)
		{
		  bwStartingHands.write(x + "; " + allStartingHands.get(x).startingHand.toString() + ";" + allStartingHands.get(x).count + ";" + allStartingHands.get(x).winner + ";" + allStartingHands.get(x).draw + "\n");

		  System.out.println(x + ": " + allStartingHands.get(x).startingHand.toString() + "; " + allStartingHands.get(x).count + "; " + allStartingHands.get(x).winner + "; " + allStartingHands.get(x).draw);
		}
		//COUNT is how many times the same game occurs, PERCENT is the percentual of the COUNT compared with all executions

		bwStartingHands.close();
	}

	
	private static void getStatsSimple(String path, int executions)
			throws IOException {
		Map<RankingEnum, Long> statsSimple = new HashMap<RankingEnum, Long>();
		for (int i = 0; i < executions; i++) {
			GameTexasHoldem game = new GameTexasHoldem();
			IPlayer player = new Player();
			IPlayer dealer = new Player();
			game.newGame(new Deck(), dealer, player);
			game.deal();
			game.callFlop();
			game.betTurn();
			game.betRiver();
			IPlayer winner = game.getWinner().get(0);
			Long count = statsSimple.get(winner.getRankingEnum());
			if (count != null) {
				statsSimple.put(winner.getRankingEnum(), count + 1);
			} else {
				statsSimple.put(winner.getRankingEnum(), 1L);
			}
		}
		BufferedWriter bwFull = new BufferedWriter(new FileWriter(path));
		bwFull.write("STATS;COUNT;PERCENT\n");
		//COUNT is how many times the same game occurs, PERCENT is the percentual of the COUNT compared with all executions
		Iterator<RankingEnum> it = statsSimple.keySet().iterator();
		while (it.hasNext()) {
			RankingEnum stat = it.next();
			Long count = statsSimple.get(stat);
			bwFull.write(stat.toString() + ";" + count + ";"
					+ (double) ((count * 100) / (double) executions) + "%\n");
		}
		bwFull.close();
	}

	/*
	 * Macbook pro
	 * HD ATA de 320 GB (5.400 rpm)
	 * Memory 4GB 1066MHz DDR3 SDRAM - 2x2GB
	 * Processor 2.53GHz Intel Core 2 Duo
	 * O.S. Snow Leopard
	 * 100000 executions = 10 seconds
	 * 10000 executions = 2 seconds
	 */
	private static long getMilliSecondsToExecute(int executions) {
		long timeToMillisInitial = System.currentTimeMillis();
		for (int i = 0; i < executions; i++) {
			GameTexasHoldem game = new GameTexasHoldem();
			IPlayer player = new Player();
			IPlayer dealer = new Player();
			game.newGame(new Deck(), dealer, player);
			game.deal();
			game.callFlop();
			game.betTurn();
			game.betRiver();
			game.getWinner();
		}
		long timeToMillisFinal = System.currentTimeMillis();
		return (timeToMillisFinal - timeToMillisInitial);
	}
}
