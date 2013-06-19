package hl.hyves.poker.model;

import hl.hyves.poker.util.HandTypeEvaluator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * List all possible valid hands.
 */
public enum HandType {
  /** Straight Flush score */
  STRAIGHT_FLUSH() {
    @Override
    protected boolean isValid(Card[] hand) {
      return HandTypeEvaluator.hasStraightFlush(hand);
    }
  },
  /** Four of a Kind score */
  FOUR_OF_A_KIND() {
    @Override
    protected boolean isValid(Card[] hand) {
      return HandTypeEvaluator.hasFourOfAKind(hand);
    }
  },
  /** Full House score */
  FULL_HOUSE() {
    @Override
    protected boolean isValid(Card[] hand) {
      return HandTypeEvaluator.hasFullHouse(hand);
    }
  },
  /** Flush score */
  FLUSH() {
    @Override
    protected boolean isValid(Card[] hand) {
      return HandTypeEvaluator.hasFlush(hand);
    }
  },
  /** Straight score */
  STRAIGHT() {
    @Override
    protected boolean isValid(Card[] hand) {
      return HandTypeEvaluator.hasStraight(hand);
    }
  },
  /** Three of a Kind score */
  THREE_OF_A_KIND() {
    @Override
    protected boolean isValid(Card[] hand) {
      return HandTypeEvaluator.hasThreeOfAKind(hand);
    }
  },
  /** Two Pairs score */
  TWO_PAIRS() {
    @Override
    protected boolean isValid(Card[] hand) {
      return HandTypeEvaluator.hasTwoPairs(hand);
    }
  },
  /** One Pair score */
  ONE_PAIR() {
    @Override
    protected boolean isValid(Card[] hand) {
      return HandTypeEvaluator.hasOnePair(hand);
    }
  },
  /** Highest Card score */
  HIGHEST_CARD() {
    @Override
    protected boolean isValid(Card[] hand) {
      return HandTypeEvaluator.hasHighestCard(hand);
    }
  };

  /**
   * Verify if a handType is present in a given hand.
   * 
   * @param hand Set of cards.
   * @return {@code true} if the hand type is present in the hand, {@code false}
   *         otherwise.
   */
  protected abstract boolean isValid(Card[] hand);

  /**
   * Verify if a hand type is present in a game. The idea is to maximize the use
   * of the deck (where the order matters). Thus, the search begins with all the
   * cards of the deck, avoiding the deck + hand combinations.
   * 
   * @param hand Player's cards.
   * @param deck Deck's cards.
   * @return {@code true} if the hand type is present in the game, {@code false}
   *         otherwise.
   */
  public boolean contains(List<Card> hand, List<Card> deck) {
    // Generate all the combinations with the hand
    List<List<Card>>[] allCombinations = getCombinations(hand);

    for (int i = deck.size(); i >= 0; i--) {
      int nSlots = deck.size() - i;

      // Case 1: Using all the deck
      if (nSlots == 0) {
        Card[] deckTest = deck.toArray(new Card[deck.size()]);
        Arrays.sort(deckTest);

        if (isValid(deckTest)) {
          return true;
        }
        continue;
      }

      // Case 2: Using the deck partially
      List<List<Card>> combinations = allCombinations[nSlots - 1];
      Card[] handTest = new Card[5];
      for (List<Card> combination : combinations) {
        // Get the deck's cards that will be used
        for (int j = 0; j < i; j++) {
          handTest[j] = deck.get(j);
        }

        // Check each hand combination
        for (int j = i; j < deck.size(); j++) {
          handTest[j] = combination.get(j - i);
        }

        Arrays.sort(handTest);

        if (isValid(handTest)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Generates all combinations in a list of cards.
   * 
   * @param originalList List.
   * @return All combinations.
   */
  public List<List<Card>>[] getCombinations(List<Card> originalList) {
    @SuppressWarnings("unchecked")
    List<List<Card>>[] allCombinations = new List[originalList.size()];
    for (int inx = 0; inx < allCombinations.length; inx++) {
      allCombinations[inx] = new ArrayList<List<Card>>();
    }

    int size = originalList.size();
    int threshold = (int) Math.pow(2, size) - 1;

    for (int i = 1; i <= threshold; ++i) {
      int count = size - 1;
      int iCopy = i;
      int nBits = 0;
      LinkedList<Card> individualCombinationList = new LinkedList<Card>();

      while (count >= 0) {
        if ((iCopy & 1) != 0) {
          individualCombinationList.addFirst(originalList.get(count));
          nBits++;
        }
        iCopy = iCopy >>> 1;
        --count;
      }
      allCombinations[nBits - 1].add(individualCombinationList);
    }
    return allCombinations;
  }
}
