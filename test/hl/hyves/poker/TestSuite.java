package hl.hyves.poker;

import hl.hyves.poker.io.InputParserTest;
import hl.hyves.poker.model.HandTypeTest;
import hl.hyves.poker.model.PsychicPlayerTest;
import hl.hyves.poker.util.HandTypeEvaluatorTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test Suite that run all unity tests for the Psychic Poker.
 */
@RunWith(Suite.class)
@SuiteClasses({ InputParserTest.class, HandTypeTest.class,
    HandTypeEvaluatorTest.class, PsychicPlayerTest.class })
public class TestSuite {
}
