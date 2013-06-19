package hl.hyves.poker.model;

import java.util.List;

/**
 * Represents the poker player that is psychic. He knows which cards are on top
 * of the deck. Thus, the player can decided which cards to discard so as to
 * maximize the value of the resulting hand.
 */
public class PsychicPlayer {

  /**
   * Evaluates the given hand and that returns the best hand type available.
   * 
   * @param hand Player's cards.
   * @param deck Deck's cards.
   * @return The maximized value of the resulting hand.
   */
  public HandType eval(List<Card> hand, List<Card> deck) {
    for (HandType handType : HandType.values()) {
      if (handType.contains(hand, deck)) {
        return handType;
      }
    }
    // It should never get to this point cause highest card evaluation should always return true.
    throw new AssertionError("No handtype was found for hand | deck: "
      + hand.toString() + " | " + deck.toString());
  }
}
