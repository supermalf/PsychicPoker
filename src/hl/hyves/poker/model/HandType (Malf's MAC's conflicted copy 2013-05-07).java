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
      return HandTypeEvaluator.isStraightFlush(hand);
    }
  },
  /** Four of a Kind score */
  FOUR_OF_A_KIND() {
    @Override
    protected boolean isValid(Card[] hand) {
      return HandTypeEvaluator.isFourOfAKind(hand);
    }
  },
  /** Full House score */
  FULL_HOUSE() {
    @Override
    protected boolean isValid(Card[] hand) {
      return HandTypeEvaluator.isFullHouse(hand);
    }
  },
  /** Flush score */
  FLUSH() {
    @Override
    protected boolean isValid(Card[] hand) {
      return HandTypeEvaluator.isFlush(hand);
    }
  },
  /** Straight score */
  STRAIGHT() {
    @Override
    protected boolean isValid(Card[] hand) {
      return HandTypeEvaluator.isStraight(hand);
    }
  },
  /** Three of a Kind score */
  THREE_OF_A_KIND() {
    @Override
    protected boolean isValid(Card[] hand) {
      return HandTypeEvaluator.isThreeOfAKind(hand);
    }
  },
  /** Two Pairs score */
  TWO_PAIRS() {
    @Override
    protected boolean isValid(Card[] hand) {
      return HandTypeEvaluator.isTwoPairs(hand);
    }
  },
  /** One Pair score */
  ONE_PAIR() {
    @Override
    protected boolean isValid(Card[] hand) {
      return HandTypeEvaluator.isOnePair(hand);
    }
  },
  /** Highest Card score */
  HIGHEST_CARD() {
    @Override
    protected boolean isValid(Card[] hand) {
      return HandTypeEvaluator.isHighestCard(hand);
    }
  };

  /**
   * Verify if a hand type is present in a game. The idea is to maximize the use
   * of the deck (where the order matters). Thus, the search begins with all the
   * cards of the deck, avoiding the deck + hand combinations.
   * 
   * @param hand Player's cards.
   * @param deck Deck's cards.
   * @return True if the hand type is present in the game, false otherwise.
   */
  // Aqui vc explica por que vc quer completar o deck com cartas da mao 
  // ao inves de querer trocar cartas da mao por cartas do 

  public boolean contains(List<Card> hand, List<Card> deck) {
    for (int i = deck.size(); i >= 0; i--) {
      Card[] handTest = new Card[5];

      // Get the deck's cards that will be used
      for (int j = 0; j < i; j++) {
        handTest[j] = deck.get(j);
      }

      // Generate all the combinations with the remaining hand's spots
      int nSlots = deck.size() - i;
      List<List<Card>> combinations = getCombinations(hand, nSlots);

      if (combinations.isEmpty()) {
        //TODO: Remover copia
        Card[] sortedHand = handTest.clone();
        Arrays.sort(sortedHand);

        if (isValid(sortedHand)) {
          return true;
        }
      }

      for (List<Card> combination : combinations) {
        // Check each hand combination
        for (int j = i; j < deck.size(); j++) {
          handTest[j] = combination.get(j - i);
        }

        //TODO: Remover copia
        Card[] sortedHand1 = handTest.clone();
        Arrays.sort(sortedHand1);

        if (isValid(sortedHand1)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Verify if a handType is present in a given hand.
   * 
   * @param hand Set of cards.
   * @return True if the hand type is present in the hand, false otherwise.
   */
  protected abstract boolean isValid(Card[] hand);

  private List<List<Card>>[] getCombinations(List<Card> originalList) {
    @SuppressWarnings("unchecked")
    List<List<Card>>[] allCombinations = new List[originalList.size()];
    for (int inx = 0; inx < allCombinations.length; inx++) {
      allCombinations[inx] = new ArrayList<List<Card>>();
    }

    int size = originalList.size();
    int threshold = (int) Math.pow(2, size) - 1;

    for (int i = 1; i <= threshold; ++i) {
      LinkedList<Card> individualCombinationList = new LinkedList<Card>();
      int count = size - 1;

      int clonedI = i; // clone do i
      int nBits = 0;
      while (count >= 0) { // passar por todos os items fornecidos
        if ((clonedI & 1) != 0) { //ímpar, último bit ligado, pegar todos ligados
          individualCombinationList.addFirst(originalList.get(count)); //adicionar item individual
          nBits++;
        }

        clonedI = clonedI >>> 1; // passar para próximo ligado
        --count;
      }

      allCombinations[nBits - 1].add(individualCombinationList);
    }

    return allCombinations;
  }

  /*
   * 
   */
  private List<List<Card>> getCombinations2(List<Card> originalList, int k) {
    List<List<Card>> combinations = new LinkedList<List<Card>>();

    int size = originalList.size();
    int threshold = (int) Math.pow(2, size) - 1;

    for (int i = 1; i <= threshold; ++i) {
      LinkedList<Card> individualCombinationList = new LinkedList<Card>();
      int count = size - 1;

      int clonedI = i; // clone do i
      int nBits = 0;
      while (count >= 0) { // passar por todos os items fornecidos
        if ((clonedI & 1) != 0) { //ímpar, último bit ligado, pegar todos ligados
          individualCombinationList.addFirst(originalList.get(count)); //adicionar item individual
          nBits++;
        }

        clonedI = clonedI >>> 1; // passar para próximo ligado
        --count;
      }

      if (nBits == k) { //verificar subset desejado
        combinations.add(individualCombinationList);
      }

    }

    return combinations;
  }
}
