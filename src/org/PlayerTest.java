package org;




public class PlayerTest {
    private Player testPlayer;
    private Card c1;
    /** Constant for passing test output */
    public static final String PASS = "PASS";
    /** Constant for failing test output */
    public static final String FAIL = "FAIL";
    /** Counter for test cases */
    public static int testCounter = 0;
    /** Counter for passing test cases */
    public static int passingTestCounter = 0;
    private void setUp(){
        testPlayer = new Player("Human", 1);
        c1 = new Card(3, 'c');
    }
public Card getCard(int index){
        return null;

}
    public void testAddCard() {
        setUp();
        // Test that there are no cards in hand
        String id = "testTakeCard - empty";
        String desc = "testPlayer.getCard(0)";
        String exp = "null";
        String act = "" + testPlayer.getCard(0);
        testResult(id, desc, exp, act);
        // Add a card to the hand
        testPlayer.addCard(c1);
        id = "testTakeCard - one card";
        desc = "testPlayer.getCard(0)";
        exp = "c3";
        act = "" + testPlayer.getCard(0);
        testResult(id, desc, exp, act);
        // TODO write test case here
    }

    public void testAddToHandPoints() {
        setUp();

        // Test that a new player starts at 0 hand points
        String id = "testAddToHandPoints - new player";
        String desc = "testPlayer.getHandPoints()";
        String exp = "0";
        String act = "" + testPlayer.getHandPoints();
        testResult(id, desc, exp, act);

        // TODO write test case here
    }

    public void testAddToOverallPoints() {
        setUp();

        // Test that a new player starts at 0 overall points
        String id = "testAddToOverallPoints - new player";
        String desc = "testPlayer.getOverallPoints()";
        String exp = "0";
        String act = "" + testPlayer.getOverallPoints();
        testResult(id, desc, exp, act);

        // TODO write test case here
    }

    public void testResetHandPoints() {
        setUp();

        // Check that points are reset even if there are no points
        testPlayer.resetHandPoints();
        String id = "testResetHandPoints - new player";
        String desc = "testPlayer.getHandPoints()";
        String exp = "0";
        String act = "" + testPlayer.getHandPoints();
        testResult(id, desc, exp, act);

        // TODO write test case here
    }

    public void testToString() {
        setUp();

        // TODO write test case here
    }

    public void testGetCard() {
        setUp();

        // Test that a card in the hand is null when the player is first created
        String id = "testGetCard - no cards in hand";
        String desc = "testPlayer.getCard(7)";
        String exp = "null";
        String act = "" + testPlayer.getCard(7);
        testResult(id, desc, exp, act);

        // TODO write test case here
    }

    public void testHasActiveCardOfSuit() {
        setUp();

        // Add a card and test that the card is active for the suit
        testPlayer.addCard(c1);
        String id = "testHasActiveCardOfSuit - clubs";
        String desc = "testPlayer.hasActiveCardOfSuit('c')";
        String exp = "true";
        String act = "" + testPlayer.hasActiveCardOfSuit('c');
        testResult(id, desc, exp, act);

        // TODO write test case here
    }

    public void testOnlyHasHearts() {
        setUp();

        // Add a card and test if the player only has hearts
        testPlayer.addCard(c1);
        String id = "testOnlyHasHearts - has clubs";
        String desc = "testPlayer.onlyHasHearts()";
        String exp = "false";
        String act = "" + testPlayer.onlyHasHearts();
        testResult(id, desc, exp, act);

        // TODO write test case here
    }

    public void testGetCardNames() {
        setUp();

        // TODO write test case here
    }

    public static void main(String[] args) {
        PlayerTest test = new PlayerTest();

        test.testAddCard();
        test.testAddToHandPoints();
        test.testAddToOverallPoints();
        test.testResetHandPoints();
        test.testToString();
        test.testGetCard();
        test.testHasActiveCardOfSuit();
        test.testOnlyHasHearts();
        test.testGetCardNames();

        System.out.println("\n***************************************");
        System.out.println("*               Results               *");
        System.out.println("***************************************");
        System.out.printf("%4d / %4d passing tests%n", passingTestCounter, testCounter);
    }

    /**
     * Prints the test information for tests whose actual result is an int.
     * 
     * @param id id of the test
     * @param desc description of the test (e.g., method call)
     * @param exp expected result of the test
     * @param act actual result of the test
     */
    private static void testResult(String id, String desc, String exp, String act) {
        testCounter++;
        String result = FAIL;
        if (exp.equals(act)) {
            result = PASS;
            passingTestCounter++;
        }
        System.out.printf("\n%3d  %-38s%-48s%7s%16s%16s\n", testCounter, id, desc, result, exp,
                        act);
    }

}
