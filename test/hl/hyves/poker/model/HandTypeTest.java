package hl.hyves.poker.model;

import hl.hyves.poker.TestUtil;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Unity test for the HandType class.
 */
public class HandTypeTest extends TestUtil {

  /**
   * Hand Type contais test.
   */
  @Test
  public void testContains() {
    Assert.assertTrue(contains(HandType.STRAIGHT_FLUSH, _TH, _JH, _QC, _QD,
      _QS, _QH, _KH, _AH, _2S, _6S));
    Assert.assertTrue(contains(HandType.FOUR_OF_A_KIND, _TH, _JH, _QC, _QD,
      _QS, _QH, _KH, _AH, _2S, _6S));
    Assert.assertFalse(contains(HandType.FULL_HOUSE, _TH, _JH, _QC, _QD, _QS,
      _QH, _KH, _AH, _2S, _6S));
    Assert.assertTrue(contains(HandType.FLUSH, _TH, _JH, _QC, _QD, _QS, _QH,
      _KH, _AH, _2S, _6S));
    Assert.assertTrue(contains(HandType.STRAIGHT, _TH, _JH, _QC, _QD, _QS, _QH,
      _KH, _AH, _2S, _6S));
    Assert.assertTrue(contains(HandType.THREE_OF_A_KIND, _TH, _JH, _QC, _QD,
      _QS, _QH, _KH, _AH, _2S, _6S));
    Assert.assertTrue(contains(HandType.TWO_PAIRS, _TH, _JH, _QC, _QD, _QS,
      _QH, _KH, _AH, _2S, _6S));
    Assert.assertTrue(contains(HandType.ONE_PAIR, _TH, _JH, _QC, _QD, _QS, _QH,
      _KH, _AH, _2S, _6S));
    Assert.assertFalse(contains(HandType.STRAIGHT_FLUSH, _2H, _2S, _3H, _3S,
      _3C, _2D, _3D, _6C, _9C, _TH));
    Assert.assertTrue(contains(HandType.FOUR_OF_A_KIND, _2H, _2S, _3H, _3S,
      _3C, _2D, _3D, _6C, _9C, _TH));
    Assert.assertTrue(contains(HandType.FULL_HOUSE, _2H, _2S, _3H, _3S, _3C,
      _2D, _3D, _6C, _9C, _TH));
    Assert.assertFalse(contains(HandType.FLUSH, _2H, _2S, _3H, _3S, _3C, _2D,
      _3D, _6C, _9C, _TH));
    Assert.assertFalse(contains(HandType.STRAIGHT, _2H, _2S, _3H, _3S, _3C,
      _2D, _3D, _6C, _9C, _TH));
    Assert.assertTrue(contains(HandType.THREE_OF_A_KIND, _2H, _2S, _3H, _3S,
      _3C, _2D, _3D, _6C, _9C, _TH));
    Assert.assertTrue(contains(HandType.TWO_PAIRS, _2H, _2S, _3H, _3S, _3C,
      _2D, _3D, _6C, _9C, _TH));
    Assert.assertTrue(contains(HandType.ONE_PAIR, _2H, _2S, _3H, _3S, _3C, _2D,
      _3D, _6C, _9C, _TH));
    Assert.assertFalse(contains(HandType.STRAIGHT_FLUSH, _2H, _2S, _3H, _3S,
      _3C, _2D, _9C, _3D, _6C, _TH));
    Assert.assertFalse(contains(HandType.FOUR_OF_A_KIND, _2H, _2S, _3H, _3S,
      _3C, _2D, _9C, _3D, _6C, _TH));
    Assert.assertTrue(contains(HandType.FULL_HOUSE, _2H, _2S, _3H, _3S, _3C,
      _2D, _9C, _3D, _6C, _TH));
    Assert.assertFalse(contains(HandType.FLUSH, _2H, _2S, _3H, _3S, _3C, _2D,
      _9C, _3D, _6C, _TH));
    Assert.assertFalse(contains(HandType.STRAIGHT, _2H, _2S, _3H, _3S, _3C,
      _2D, _9C, _3D, _6C, _TH));
    Assert.assertTrue(contains(HandType.THREE_OF_A_KIND, _2H, _2S, _3H, _3S,
      _3C, _2D, _9C, _3D, _6C, _TH));
    Assert.assertTrue(contains(HandType.TWO_PAIRS, _2H, _2S, _3H, _3S, _3C,
      _2D, _9C, _3D, _6C, _TH));
    Assert.assertTrue(contains(HandType.ONE_PAIR, _2H, _2S, _3H, _3S, _3C, _2D,
      _9C, _3D, _6C, _TH));
    Assert.assertFalse(contains(HandType.STRAIGHT_FLUSH, _2H, _AD, _5H, _AC,
      _7H, _AH, _6H, _9H, _4H, _3C));
    Assert.assertFalse(contains(HandType.FOUR_OF_A_KIND, _2H, _AD, _5H, _AC,
      _7H, _AH, _6H, _9H, _4H, _3C));
    Assert.assertFalse(contains(HandType.FULL_HOUSE, _2H, _AD, _5H, _AC, _7H,
      _AH, _6H, _9H, _4H, _3C));
    Assert.assertTrue(contains(HandType.FLUSH, _2H, _AD, _5H, _AC, _7H, _AH,
      _6H, _9H, _4H, _3C));
    Assert.assertFalse(contains(HandType.STRAIGHT, _2H, _AD, _5H, _AC, _7H,
      _AH, _6H, _9H, _4H, _3C));
    Assert.assertTrue(contains(HandType.THREE_OF_A_KIND, _2H, _AD, _5H, _AC,
      _7H, _AH, _6H, _9H, _4H, _3C));
    Assert.assertFalse(contains(HandType.TWO_PAIRS, _2H, _AD, _5H, _AC, _7H,
      _AH, _6H, _9H, _4H, _3C));
    Assert.assertTrue(contains(HandType.ONE_PAIR, _2H, _AD, _5H, _AC, _7H, _AH,
      _6H, _9H, _4H, _3C));
  }

  /**
   * @param handType Hand Type to evaluate.
   * @param cards List of Cards(Hand+Deck).
   * @return {@code true} if the Hand+Deck contais the type, {@code false}
   *         otherwise.
   */
  private boolean contains(HandType handType, Card... cards) {
    List<Card> hand = new ArrayList<Card>(5);
    List<Card> deck = new ArrayList<Card>(5);

    for (int i = 0; i < 5; i++) {
      hand.add(cards[i]);
    }
    for (int i = 5; i < 10; i++) {
      deck.add(cards[i]);
    }
    return handType.contains(hand, deck);
  }
}
