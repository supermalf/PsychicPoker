package hl.hyves.poker.model;

import hl.hyves.poker.TestUtil;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Unity test for the PsychicPlayer class.
 */
public class PsychicPlayerTest extends TestUtil {
  /** Psychic Player */
  private PsychicPlayer player;

  /**
   * SetUp.
   */
  @Before
  public void setUp() {
    player = new PsychicPlayer();
  }

  /**
   * @param cards List of Cards(Hand+Deck).
   * @return {@code true} if the best result from deck+hand is the expected
   *         type, {@code false} otherwise.
   */
  private HandType eval(Card... cards) {
    List<Card> hand = new ArrayList<Card>(5);
    List<Card> deck = new ArrayList<Card>(5);

    for (int i = 0; i < 5; i++) {
      hand.add(cards[i]);
    }
    for (int i = 5; i < 10; i++) {
      deck.add(cards[i]);
    }
    return player.eval(hand, deck);
  }

  /**
   * Test the given examples.
   */
  @Test
  public void testBasicProblems() {
    Assert.assertEquals(eval(_TH, _JH, _QC, _QD, _QS, _QH, _KH, _AH, _2S, _6S),
      HandType.STRAIGHT_FLUSH);
    Assert.assertEquals(eval(_2H, _2S, _3H, _3S, _3C, _2D, _3D, _6C, _9C, _TH),
      HandType.FOUR_OF_A_KIND);
    Assert.assertEquals(eval(_2H, _2S, _3H, _3S, _3C, _2D, _9C, _3D, _6C, _TH),
      HandType.FULL_HOUSE);
    Assert.assertEquals(eval(_2H, _AD, _5H, _AC, _7H, _AH, _6H, _9H, _4H, _3C),
      HandType.FLUSH);
    Assert.assertEquals(eval(_AC, _2D, _9C, _3S, _KD, _5S, _4D, _KS, _AS, _4C),
      HandType.STRAIGHT);
    Assert.assertEquals(eval(_KS, _AH, _2H, _3C, _4H, _KC, _2C, _TC, _2D, _AS),
      HandType.THREE_OF_A_KIND);
    Assert.assertEquals(eval(_AH, _2C, _9S, _AD, _3C, _QH, _KS, _JS, _JD, _KD),
      HandType.TWO_PAIRS);
    Assert.assertEquals(eval(_6C, _9C, _8C, _2D, _7C, _2H, _TC, _4C, _9S, _AH),
      HandType.ONE_PAIR);
    Assert.assertEquals(eval(_3D, _5S, _2H, _QD, _TD, _6S, _KH, _9H, _AD, _QH),
      HandType.HIGHEST_CARD);
  }

  /**
   * Test some other problems
   */
  @Test
  public void testProblems() {
    Assert.assertEquals(eval(_2S, _4H, _5H, _6D, _7S, _2H, _3H, _6H, _2D, _3D),
      HandType.STRAIGHT_FLUSH);
    Assert.assertEquals(eval(_3C, _5H, _5D, _5S, _3D, _QH, _3H, _3S, _7H, _2D),
      HandType.FOUR_OF_A_KIND);
    Assert.assertEquals(eval(_3C, _AS, _3S, _3H, _KC, _8D, _8C, _3D, _6C, _TH),
      HandType.FULL_HOUSE);
    Assert.assertEquals(eval(_9C, _7H, _TH, _QC, _2D, _2C, _3C, _KC, _5H, _3H),
      HandType.FLUSH);
    Assert.assertEquals(eval(_TS, _5H, _5D, _5S, _7S, _QH, _JH, _KH, _AD, _3D),
      HandType.STRAIGHT);
    Assert.assertEquals(eval(_7C, _5H, _5D, _5S, _8D, _QH, _3H, _3S, _7H, _2D),
      HandType.THREE_OF_A_KIND);
    Assert.assertEquals(eval(_8H, _4C, _5S, _AD, _3C, _5H, _KS, _3S, _2D, _KD),
      HandType.TWO_PAIRS);
    Assert.assertEquals(eval(_3C, _5H, _8D, _TS, _3D, _QH, _7H, _2D, _3H, _3S),
      HandType.ONE_PAIR);
    Assert.assertEquals(eval(_2C, _8H, _4S, _TD, _QC, _5H, _7H, _AC, _KD, _2S),
      HandType.HIGHEST_CARD);
    Assert.assertEquals(eval(_2C, _8H, _4S, _TD, _QC, _5H, _7H, _AC, _KD, _3S),
      HandType.HIGHEST_CARD);
  }
}
