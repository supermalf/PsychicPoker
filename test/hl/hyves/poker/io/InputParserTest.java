package hl.hyves.poker.io;

import hl.hyves.poker.TestUtil;
import hl.hyves.poker.model.Card;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Unity test for the InputParser class.
 */
public class InputParserTest extends TestUtil {
  /** Input Parser */
  private InputParser inputParser;

  /**
   * SetUp.
   */
  @Before
  public void setUp() {
    inputParser = new InputParser();
  }

  /**
   * Hand Type contais test.
   */
  @Test
  public void testParser() {
    Assert.assertTrue(check("2C 3C 4C 5C 6C 7C 8C 9C TC JC QC KC AC", _2C, _3C,
      _4C, _5C, _6C, _7C, _8C, _9C, _TC, _JC, _QC, _KC, _AC));

    Assert.assertTrue(check("2H 3H 4H 5H 6H 7H 8H 9H TH JH QH KH AH", _2H, _3H,
      _4H, _5H, _6H, _7H, _8H, _9H, _TH, _JH, _QH, _KH, _AH));

    Assert.assertTrue(check("2S 3S 4S 5S 6S 7S 8S 9S TS JS QS KS AS", _2S, _3S,
      _4S, _5S, _6S, _7S, _8S, _9S, _TS, _JS, _QS, _KS, _AS));

    Assert.assertTrue(check("2D 3D 4D 5D 6D 7D 8D 9D TD JD QD KD AD", _2D, _3D,
      _4D, _5D, _6D, _7D, _8D, _9D, _TD, _JD, _QD, _KD, _AD));
  }

  /**
   * Compares a list of cards in a String format to a each Card object.
   * 
   * @param cardsTxt Cards String format.
   * @param cards List of cards.
   * @return {@code true} if the both represantations are equals, {@code false}
   *         otherwise.
   */
  private boolean check(String cardsTxt, Card... cards) {
    List<Card> parserList = inputParser.getGameCards(cardsTxt);

    for (int i = 0; i < cards.length; i++) {
      if (parserList.get(i).compareTo(cards[i]) != 0) {
        return false;
      }
    }
    return true;
  }

}
