package com.cantero.games.poker.texasholdem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class GameTexasHoldemRunner {

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
//			String fullFileName = currDir + "/2PlayerGame" + executions + "-full.csv";
//			run2PlayerGameFull(fullFileName, executions);
//			System.out.println("run2PlayerGameFull - OK - " + fullFileName);
			
			String fullFileName = currDir + "/3PlayerGame" + executions + "-full.csv";
			run3PlayerGameFull(fullFileName, executions);
			System.out.println("run3PlayerGameFull - OK - " + fullFileName);

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
		bwFull
				.write("DEALER DEAL;PLAYER DEAL;DEALER CALL FLOP;PLAYER CALL FLOP;DEALER BET TURN;PLAYER BET TURN;DEALER BET RIVER;PLAYER BET RIVER;WINNER;COUNT;PERCENT\n");
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
		//Header
		bwFull.write("Player1 DEAL;Player2 DEAL;"
				+ "Player1 CALL FLOP;Player2 CALL FLOP;"
				+ "Player1 BET TURN;Player2 BET TURN;"
				+ "Player1 BET RIVER;Player2 BET RIVER;"
				+ "WINNER;"
				+ "Player 1 Card1 Rank;Player 1 Card1 Suite;Player 1 Card2 Rank;Player 1 Card2 Suite;"
				+ "Player 2 Card1 Rank;Player 2 Card1 Suite;Player 2 Card2 Rank;Player 2 Card2 Suite;"
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
			int x = 0;
			for (Card card : tableCards) {
				retLine +=  card.getRank() + ";" + card.getSuit() + ";";
//				System.out.println("Table Card " + card.getRank() + " " + card.getSuit());
				x++;
			}
			System.out.println(x + " Table Cards ");
			
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
			}
			
			else if (player2.getCards()[0].getRank().toString().equals("ACE") && player2.getCards()[1].getRank().toString().equals("ACE"))
			{
				retLine += "ACES;";
			}
			else if (player3.getCards()[0].getRank().toString().equals("ACE") && player3.getCards()[1].getRank().toString().equals("ACE"))
			{
				retLine += "ACES;";
			}
			else
			{
				retLine += ";";
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

	private static void addHandLabel(String path)
	{
		
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
