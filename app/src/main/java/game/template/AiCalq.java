package game.template;

import java.util.Random;

public class AiCalq {
    
    private GameState state;
    private Random random;

    // Constructor
    public AiCalq(GameState state) {
        this.state = state;
        this.random = new Random(); // Initialize Random object
    }

    public void aiDecision() {
        int aiScore = state.getAiValue(); // Get AI's hand value
        int luckFactor = random.nextInt(10); // Random factor between 0-9
        int aiBet = state.getAiBetAmount(); // Get AI's current bet amount
        
        boolean cautiousBetting = aiBet >= 100; // AI is less likely to raise if bet amount is high
        boolean weakHand = aiScore + luckFactor < 12; // AI considers its hand weak
        boolean shouldFold = weakHand && random.nextInt(4) == 0; // AI folds more often with weak hands

        if (aiScore + luckFactor >= 28 && !cautiousBetting) { // Strong hand + lucky boost, AI raises if betting isn't cautious
            aiRaise();
        } else if (aiScore + luckFactor >= 14) { // Decent hand, AI might call, raise, or check
            if (state.getLastMove() == Actions.RAISE || state.getLastMove() == Actions.BET) {
                if (!cautiousBetting && random.nextBoolean()) { // 50% chance to raise, but less likely if cautious betting
                    aiRaise();
                } else {
                    aiCall();
                }
            } else {
                aiCheck(); // AI checks if last move was not a bet or raise
            }
        } else { // Weak hand, AI considers folding more
            if (shouldFold) { // If AI has a bad hand, it's more likely to fold
                aiFold();
            } else { // AI still has a chance to gamble
                if (state.getLastMove() == Actions.RAISE || state.getLastMove() == Actions.BET) {
                    aiCall();
                } else {
                    aiCheck();
                }
            }
        }
    }

    private void aiRaise() {
        state.setLastMove(Actions.RAISE);
        state.setAiBetAmount(state.getAiBetAmount() + 10);
        System.out.println("AI raises");
    }

    private void aiCall() {
        if (state.getLastMove() == Actions.RAISE || state.getLastMove() == Actions.BET) {
            state.setLastMove(Actions.CALL);
            state.setAiBetAmount(state.getPlayerBetAmount());
            System.out.println("AI calls");
        } else {
            System.out.println("AI cannot call, last move was not a raise or bet");
        }
    }

    private void aiCheck() {
        state.setLastMove(Actions.CHECK);
        System.out.println("AI checks");
    }

    private void aiFold() {
        state.setLastMove(Actions.FOLD);
        state.setOutcome(PokerState.PLAYER_WINS);
        System.out.println("AI folds");
    }

    
}
