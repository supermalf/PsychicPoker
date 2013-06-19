package hl.hyves.poker.util;

import hl.hyves.poker.TestUtil;
import hl.hyves.poker.model.Card;
import junit.framework.Assert;

import org.junit.Test;

/**
 * Unity test for the HandTypeEvaluator class.
 */
public class HandTypeEvaluatorTest extends TestUtil {
  /**
   * Tests if a given hand contains a Pair.
   */
  @Test
  public void testOnePair() {
    Assert.assertFalse(HandTypeEvaluator.hasOnePair(new Card[] { _AC }));
    Assert.assertTrue(HandTypeEvaluator.hasOnePair(new Card[] { _AC, _AH }));
    Assert.assertTrue(HandTypeEvaluator
      .hasOnePair(new Card[] { _KC, _AH, _AS }));
    Assert.assertTrue(HandTypeEvaluator
      .hasOnePair(new Card[] { _KC, _KH, _AS }));
    Assert.assertTrue(HandTypeEvaluator.hasOnePair(new Card[] { _2C, _3C, _4C,
        _5C, _6C, _7H, _7C, _8H, _9H, _TH, _QH, _KH, _AH }));
    Assert.assertFalse(HandTypeEvaluator.hasOnePair(new Card[] { _2H, _3H, _4H,
        _5H, _6H, _7H, _8H, _9H, _TH, _QH, _KH, _AH }));
  }

  /**
   * Tests if a given hand contains Two Pairs.
   */
  @Test
  public void testTwoPairs() {
    Assert.assertFalse(HandTypeEvaluator.hasTwoPairs(new Card[] { _AC }));
    Assert.assertFalse(HandTypeEvaluator.hasTwoPairs(new Card[] { _AC, _AH }));
    Assert.assertTrue(HandTypeEvaluator.hasTwoPairs(new Card[] { _AC, _AH, _AS,
        _AD }));
    Assert.assertTrue(HandTypeEvaluator.hasTwoPairs(new Card[] { _2C, _2S, _KC,
        _AH, _AS }));
    Assert.assertTrue(HandTypeEvaluator.hasTwoPairs(new Card[] { _2H, _2S, _4H,
        _5H, _6H, _7H, _8H, _9H, _TH, _QH, _AH, _AS }));
    Assert.assertFalse(HandTypeEvaluator.hasOnePair(new Card[] { _2H, _3H, _4H,
        _5H, _6H, _7H, _8H, _9H, _TH, _QH, _KH, _AH }));
    Assert.assertTrue(HandTypeEvaluator.hasOnePair(new Card[] { _2H, _3H, _4H,
        _5H, _6H, _7H, _7S, _9H, _TH, _QH, _QS, _AH, }));
  }

  /**
   * Tests if a given hand contains Three Of A Kind.
   */
  @Test
  public void testThreeOfAKind() {
    Assert.assertFalse(HandTypeEvaluator.hasThreeOfAKind(new Card[] { _AC, }));
    Assert.assertFalse(HandTypeEvaluator
      .hasThreeOfAKind(new Card[] { _AC, _AH }));
    Assert.assertTrue(HandTypeEvaluator.hasThreeOfAKind(new Card[] { _AC, _AH,
        _AS }));
    Assert.assertTrue(HandTypeEvaluator.hasThreeOfAKind(new Card[] { _2S, _AC,
        _AH, _AS }));
    Assert.assertTrue(HandTypeEvaluator.hasThreeOfAKind(new Card[] { _2S, _3C,
        _4D, _AC, _AH, _AS }));
    Assert.assertTrue(HandTypeEvaluator.hasThreeOfAKind(new Card[] { _2S, _3C,
        _4D, _AC, _AH, _AS }));
    Assert.assertTrue(HandTypeEvaluator.hasThreeOfAKind(new Card[] { _2S, _2C,
        _2D, _QC, _KH, _AS }));
    Assert.assertTrue(HandTypeEvaluator.hasThreeOfAKind(new Card[] { _2S, _3C,
        _4D, _4C, _4H, _4S, _QC, _KH, _AS }));
  }

  /**
   * Tests if a given hand contains Three Of A Kind.
   */
  @Test
  public void testStraight() {
    Assert.assertFalse(HandTypeEvaluator.hasStraight(new Card[] { _AC }));
    Assert.assertFalse(HandTypeEvaluator.hasStraight(new Card[] { _2C, _3H }));
    Assert.assertFalse(HandTypeEvaluator
      .hasStraight(new Card[] { _2C, _3H, _4S }));
    Assert.assertFalse(HandTypeEvaluator.hasStraight(new Card[] { _2C, _3H,
        _4S, _5H }));
    Assert.assertTrue(HandTypeEvaluator.hasStraight(new Card[] { _2C, _3H, _4S,
        _5H, _AH }));
    Assert.assertTrue(HandTypeEvaluator.hasStraight(new Card[] { _2C, _3H, _4S,
        _5H, _6H }));
    Assert.assertTrue(HandTypeEvaluator.hasStraight(new Card[] { _TC, _JH, _QS,
        _KH, _AH }));
    Assert.assertFalse(HandTypeEvaluator.hasStraight(new Card[] { _JC, _TH,
        _QS, _KH, _AH }));
    Assert.assertTrue(HandTypeEvaluator.hasStraight(new Card[] { _3C, _TC, _JH,
        _QS, _KH, _AH }));
    Assert.assertTrue(HandTypeEvaluator.hasStraight(new Card[] { _2C, _4H, _5H,
        _6C, _7C, _8H, _JS, _JH, _KS, _KD, _AH }));
  }

  /**
   * Tests if a given hand contains a Flush.
   */
  @Test
  public void testFlush() {
    Assert.assertFalse(HandTypeEvaluator.hasFlush(new Card[] { _AC }));
    Assert.assertFalse(HandTypeEvaluator.hasFlush(new Card[] { _2H, _3H }));
    Assert
      .assertFalse(HandTypeEvaluator.hasFlush(new Card[] { _2H, _3H, _4H }));
    Assert.assertFalse(HandTypeEvaluator.hasFlush(new Card[] { _2H, _3H, _4H,
        _5H }));
    Assert.assertTrue(HandTypeEvaluator.hasFlush(new Card[] { _2H, _3H, _4H,
        _5H, _6H }));
    Assert.assertTrue(HandTypeEvaluator.hasFlush(new Card[] { _2H, _3H, _4H,
        _5H, _6H, _AS }));
    Assert.assertTrue(HandTypeEvaluator.hasFlush(new Card[] { _2S, _3H, _4H,
        _5H, _6H, _AH }));
    Assert.assertTrue(HandTypeEvaluator.hasFlush(new Card[] { _2S, _3H, _4S,
        _5H, _6S, _7S, _8H, _9C, _TH, _JC, _QC, _KD, _AH, }));
    Assert.assertFalse(HandTypeEvaluator.hasFlush(new Card[] { _2S, _3H, _4S,
        _5C, _6S, _7S, _8H, _9C, _TD, _JC, _QC, _KD, _AH, }));
  }

  /**
   * Tests if a given hand contains a Full H,ouse.
   */
  @Test
  public void testFullHouse() {
    Assert.assertFalse(HandTypeEvaluator.hasFullHouse(new Card[] { _AC }));
    Assert.assertFalse(HandTypeEvaluator.hasFullHouse(new Card[] { _2H, _2C }));
    Assert.assertFalse(HandTypeEvaluator.hasFullHouse(new Card[] { _2H, _2C,
        _2D }));
    Assert.assertFalse(HandTypeEvaluator.hasFullHouse(new Card[] { _2H, _2C,
        _2D, _3H }));
    Assert.assertTrue(HandTypeEvaluator.hasFullHouse(new Card[] { _2H, _2C,
        _2D, _3H, _3D }));
    Assert.assertTrue(HandTypeEvaluator.hasFullHouse(new Card[] { _2H, _2C,
        _2D, _3H, _3D, _4D }));
    Assert.assertTrue(HandTypeEvaluator.hasFullHouse(new Card[] { _2H, _3C,
        _3D, _3H, _4D, _4D }));
    Assert.assertTrue(HandTypeEvaluator.hasFullHouse(new Card[] { _2H, _3C,
        _3D, _4H, _5D, _6D, _7H, _7D, _7C, _8S, _9S }));
  }

  /**
   * Tests if a given hand contains a Four Of A Kind.
   */
  @Test
  public void testFourOfAKind() {
    Assert.assertFalse(HandTypeEvaluator.hasFourOfAKind(new Card[] { _AC }));
    Assert.assertFalse(HandTypeEvaluator
      .hasFourOfAKind(new Card[] { _AC, _AH }));
    Assert.assertFalse(HandTypeEvaluator.hasFourOfAKind(new Card[] { _AC, _AH,
        _AS }));
    Assert.assertTrue(HandTypeEvaluator.hasFourOfAKind(new Card[] { _AC, _AH,
        _AS, _AD }));
    Assert.assertTrue(HandTypeEvaluator.hasFourOfAKind(new Card[] { _2S, _AC,
        _AH, _AS, _AD }));
    Assert.assertTrue(HandTypeEvaluator.hasFourOfAKind(new Card[] { _2S, _2C,
        _2H, _2D, _AC }));
    Assert.assertTrue(HandTypeEvaluator.hasFourOfAKind(new Card[] { _2S, _2C,
        _2D, _2H, _QC, _KH, _AS }));
    Assert.assertTrue(HandTypeEvaluator.hasFourOfAKind(new Card[] { _2S, _3C,
        _4D, _4C, _4H, _4S, _QC, _KH, _AS }));
  }
}
