package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPokerTest {

	@Test
	public void RoyalFlushTest() {
		System.out.println("Royal Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.RoyalFlush, hsp.geteHandStrength());
		assertEquals(eRank.ACE, hsp.getHiCard().geteRank());
		assertNull(hsp.getKickers());
		
		System.out.println("");
	}
	
	@Test
	public void StraightFlushTest() {
		System.out.println("Straight Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.NINE));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.StraightFlush, hsp.geteHandStrength());
		assertEquals(eRank.KING, hsp.getHiCard().geteRank());
		assertNull(hsp.getKickers());
		
		System.out.println("");
	}
	
	@Test
	public void FourOfAKindTest1() {
		System.out.println("Four of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.FourOfAKind, hsp.geteHandStrength());
		assertEquals(eRank.TWO, hsp.getHiCard().geteRank());
		assertEquals(1, hsp.getKickers().size());
		assertEquals(eRank.THREE, hsp.getKickers().get(0).geteRank());
		assertEquals(eSuit.CLUBS, hsp.getKickers().get(0).geteSuit());
		
		System.out.println("");
	}
	
	@Test
	public void FourOfAKindTest2() {
		System.out.println("Four of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.THREE));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.THREE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.FourOfAKind, hsp.geteHandStrength());
		assertEquals(eRank.THREE, hsp.getHiCard().geteRank());
		assertEquals(1, hsp.getKickers().size());
		assertEquals(eRank.TWO, hsp.getKickers().get(0).geteRank());
		assertEquals(eSuit.CLUBS, hsp.getKickers().get(0).geteSuit());
		
		System.out.println("");
	}
	
	@Test
	public void FullHouseTest1() {
		System.out.println("Full House");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.FullHouse, hsp.geteHandStrength());
		assertEquals(eRank.FIVE, hsp.getHiCard().geteRank());
		assertEquals(eRank.TWO, hsp.getLoCard().geteRank());
		assertNull(hsp.getKickers());
		
		System.out.println("");
	}
	
	@Test
	public void FullHouseTest2() {
		System.out.println("Full House");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.FullHouse, hsp.geteHandStrength());
		assertEquals(eRank.TWO, hsp.getHiCard().geteRank());
		assertEquals(eRank.FIVE, hsp.getLoCard().geteRank());
		assertNull(hsp.getKickers());
		
		System.out.println("");
	}
	
	@Test
	public void FlushTest() {
		System.out.println("Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.NINE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.Flush, hsp.geteHandStrength());
		assertEquals(eRank.ACE, hsp.getHiCard().geteRank());
		assertEquals(4, hsp.getKickers().size());

		System.out.println("");
	}
	
	@Test
	public void StraightTest1() {
		System.out.println("Straight");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.SEVEN));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.SIX));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.Straight, hsp.geteHandStrength());
		assertEquals(eRank.EIGHT, hsp.getHiCard().geteRank());
		assertNull(hsp.getKickers());
		
		System.out.println("");
	}
	
	@Test
	public void StraightTest2() {
		System.out.println("Straight");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.Straight, hsp.geteHandStrength());
		assertEquals(eRank.FIVE, hsp.getHiCard().geteRank());
		assertEquals(eRank.ACE, hsp.getLoCard().geteRank());
		assertNull(hsp.getKickers());
		
		System.out.println("");
	}
	
	@Test
	public void StraightTest3() {
		System.out.println("Straight");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.JACK));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.Straight, hsp.geteHandStrength());
		assertEquals(eRank.ACE, hsp.getHiCard().geteRank());
		assertEquals(eRank.TEN, hsp.getLoCard().geteRank());
		assertNull(hsp.getKickers());
		
		System.out.println("");
	}
	
	@Test
	public void StraightTest4() {
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.SIX));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.HighCard, hsp.geteHandStrength());
		assertEquals(eRank.ACE, hsp.getHiCard().geteRank());
		assertEquals(4, hsp.getKickers().size());
		
		System.out.println("");
	}
	
	@Test
	public void ThreeOfAKindTest1() {
		System.out.println("Three of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.ThreeOfAKind, hsp.geteHandStrength());
		assertEquals(eRank.TWO, hsp.getHiCard().geteRank());
		assertEquals(2, hsp.getKickers().size());
		
		System.out.println("");
	}
	
	@Test
	public void ThreeOfAKindTest2() {
		System.out.println("Three of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.ThreeOfAKind, hsp.geteHandStrength());
		assertEquals(eRank.FIVE, hsp.getHiCard().geteRank());
		assertEquals(2, hsp.getKickers().size());
		
		System.out.println("");
	}
	
	@Test
	public void ThreeOfAKindTest3() {
		System.out.println("Three of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.EIGHT));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TEN));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.THREE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.ThreeOfAKind, hsp.geteHandStrength());
		assertEquals(eRank.THREE, hsp.getHiCard().geteRank());
		assertEquals(2, hsp.getKickers().size());
		
		System.out.println("");
	}
	
	@Test
	public void TwoPairTest1() {
		System.out.println("Two Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.TwoPair, hsp.geteHandStrength());
		assertEquals(eRank.FIVE, hsp.getHiCard().geteRank());
		assertEquals(eRank.TWO, hsp.getLoCard().geteRank());
		assertEquals(1, hsp.getKickers().size());
		assertEquals(eRank.THREE, hsp.getKickers().get(0).geteRank());
		assertEquals(eSuit.CLUBS, hsp.getKickers().get(0).geteSuit());
		
		System.out.println("");
	}
	
	@Test
	public void TwoPairTest2() {
		System.out.println("Two Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.SIX));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.SIX));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.TwoPair, hsp.geteHandStrength());
		assertEquals(eRank.SIX, hsp.getHiCard().geteRank());
		assertEquals(eRank.TWO, hsp.getLoCard().geteRank());
		assertEquals(1, hsp.getKickers().size());
		assertEquals(eRank.FIVE, hsp.getKickers().get(0).geteRank());
		assertEquals(eSuit.DIAMONDS, hsp.getKickers().get(0).geteSuit());
		
		System.out.println("");
	}
	
	@Test
	public void PairTest1() {
		System.out.println("Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.NINE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.NINE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.Pair, hsp.geteHandStrength());
		assertEquals(eRank.NINE, hsp.getHiCard().geteRank());
		assertEquals(3, hsp.getKickers().size());
		
		System.out.println("");
	}
	
	@Test
	public void PairTest2() {
		System.out.println("Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.NINE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.Pair, hsp.geteHandStrength());
		assertEquals(eRank.EIGHT, hsp.getHiCard().geteRank());
		assertEquals(3, hsp.getKickers().size());
		
		System.out.println("");
	}
	
	@Test
	public void HighCardTest1() {
		System.out.println("High Card");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.NINE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TEN));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.HighCard, hsp.geteHandStrength());
		assertEquals(eRank.ACE, hsp.getHiCard().geteRank());
		assertEquals(4, hsp.getKickers().size());
		
		System.out.println("");
	}
	
	@Test
	public void HighCardTest2() {
		System.out.println("High Card");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.NINE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TEN));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.HighCard, hsp.geteHandStrength());
		assertEquals(eRank.TEN, hsp.getHiCard().geteRank());
		assertEquals(4, hsp.getKickers().size());
		
		System.out.println("");
	}
	
	@Test
	public void HighCardTest3() {
		System.out.println("High Card");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.NINE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.SIX));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.SPADES, eRank.THREE));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.HighCard, hsp.geteHandStrength());
		assertEquals(eRank.NINE, hsp.getHiCard().geteRank());
		assertEquals(4, hsp.getKickers().size());
		
		System.out.println("");
	}
	
	@Test
	public void HighCardTest4() {
		System.out.println("High Card");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.NINE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TEN));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.HighCard, hsp.geteHandStrength());
		assertEquals(eRank.ACE, hsp.getHiCard().geteRank());
		assertEquals(4, hsp.getKickers().size());
		
		System.out.println("");
	}
	
	@Test
	public void HighCardTest5() {
		System.out.println("High Card");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.NINE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.AddCard(new Card(eSuit.SPADES, eRank.KING));
		hp.ScoreHand();
		
		HandScorePoker hsp = hp.getHSP();
		
		assertEquals(eHandStrength.HighCard, hsp.geteHandStrength());
		assertEquals(eRank.KING, hsp.getHiCard().geteRank());
		assertEquals(4, hsp.getKickers().size());
		
		System.out.println("");
	}

}
