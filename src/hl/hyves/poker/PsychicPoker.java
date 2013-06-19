package hl.hyves.poker;

import hl.hyves.poker.io.InputParser;
import hl.hyves.poker.model.Card;
import hl.hyves.poker.model.HandType;
import hl.hyves.poker.model.PsychicPlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Represents the Psychic Poker game.
 */
public class PsychicPoker {
  /** List of games to be evaluated */
  private List<List<Card>> games;
  /** The player that evaluates each game */
  private PsychicPlayer player;

  /**
   * Constructor.
   * 
   * @param games List of games to be evaluated.
   */
  public PsychicPoker(List<List<Card>> games) {
    this.games = games;
    this.player = new PsychicPlayer();
  }

  /**
   * Constructor.
   * 
   * @param filename Games's filename.
   * @throws FileNotFoundException If the game file does not exist.
   * @throws IOException If an I/O error occurs.
   */
  public PsychicPoker(String filename) throws FileNotFoundException,
    IOException {
    this(new InputParser().read(filename));
  }

  /**
   * Constructor.
   * 
   * @param gameInputs List of game's text representation.
   */
  public PsychicPoker(String[] gameInputs) {
    this(new InputParser().read(gameInputs));
  }

  /**
   * Runs the Psychic Poker Game.
   */
  private void run() {
    for (List<Card> game : games) {
      List<Card> hand = game.subList(0, 5);
      List<Card> deck = game.subList(5, 10);

      HandType handType = player.eval(hand, deck);

      System.out.println("Hand: " + hand.toString() + " Deck: "
        + deck.toString() + " Best Hand: " + handType);
    }
  }

  /**
   * This is a simple demo application that expects a input game file as an
   * argument.
   * 
   * @param args The first argument is the game's filename (optional).
   * @throws FileNotFoundException If the game file does not exist.
   * @throws IOException If an I/O error occurs.
   * @throws UnsupportedEncodingException If the named encoding is not
   *         supported.
   */
  public static void main(String[] args) throws FileNotFoundException,
    IOException {
    if (args.length == 0) {
      System.err.println("Usage: java PsychicPoker <filename>");
      System.exit(-1);
    }

    PsychicPoker poker = new PsychicPoker(args[0]);
    poker.run();
  }
}
