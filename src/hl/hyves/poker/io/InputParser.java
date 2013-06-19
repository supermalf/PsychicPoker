package hl.hyves.poker.io;

import hl.hyves.poker.model.Card;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsible to deal with an input and coverts into a valid list of cards for
 * each game.
 */
public class InputParser {

  /**
   * Reads and Parser a input file to return a list of cards for each game.
   * 
   * @param filename Input's filename.
   * @return List of cards for each game.
   * @throws FileNotFoundException If the game file does not exist.
   * @throws IOException If an I/O error occurs.
   */
  public List<List<Card>> read(String filename) throws IOException,
    FileNotFoundException {
    return parseGames(readFile(filename));
  }

  /**
   * Reads and Parser a input a list of games to return a list of cards for each
   * game.
   * 
   * @param gameInputs list of games string
   * @return list of cards for each game
   */
  public List<List<Card>> read(String[] gameInputs) {
    return parseGames(gameInputs);
  }

  /**
   * Reads a file and returns a list of games.
   * 
   * @param filename Input's filename.
   * @return List of games.
   * @throws FileNotFoundException If the game file does not exist.
   * @throws IOException If an I/O error occurs.
   */
  private String[] readFile(String filename) throws IOException,
    FileNotFoundException {
    List<String> inputLines = new ArrayList<String>();

    DataInputStream input = new DataInputStream(new FileInputStream(filename));
    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
    String line;

    while ((line = reader.readLine()) != null) {
      inputLines.add(line.trim());
    }
    input.close();
    return inputLines.toArray(new String[inputLines.size()]);
  }

  /**
   * Converts a list of games string into a valid list of cards to each game.
   * 
   * @param games List of games.
   * @return List of cards for each game.
   */
  private List<List<Card>> parseGames(String[] games) {
    List<List<Card>> gamesCards = new ArrayList<List<Card>>();
    for (String game : games) {
      gamesCards.add(getGameCards(game));
    }
    return gamesCards;
  }

  /**
   * Converts a single game's string representation into a list of cards (deck +
   * hand).
   * 
   * @param game single game's string
   * @return list of cards
   */
  public List<Card> getGameCards(String game) {
    List<Card> gameCards = new ArrayList<Card>();

    if (game != null) {
      String[] cards = game.split(" ");

      for (String card : cards) {
        gameCards.add(Card.valueOf(card));
      }
    }
    return gameCards;
  }
}
