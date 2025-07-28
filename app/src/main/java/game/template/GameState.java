package game.template;

import java.util.List;
import java.util.ArrayList;

public class GameState {
    private int balance;
    private PokerState pokerState;
    private PokerState outcome; 
    private List<Card> aiCards;
    private int aiValue;
    private List<Card> playerCards;
    private int playerValue;
    private List<Card> flopDeck; // Community cards (first 3)
    private Card turnCard; // Turn card (4th card)
    private Card riverCard; // River card (5th card)
    private int playerBetAmount;
    private int aiBetAmount;
    private Actions lastMove; 

    // Constructor
    public GameState() {
        this.balance = 0;
        this.pokerState = PokerState.WAITING_TO_START;
        this.outcome = PokerState.WAITING_TO_START; // Initialize outcome
        this.aiCards = new ArrayList<>();
        this.aiValue = 0;
        this.playerCards = new ArrayList<>();
        this.playerValue = 0;
        this.flopDeck = new ArrayList<>();
        this.turnCard = null;
        this.riverCard = null;
        this.playerBetAmount = 0;
        this.aiBetAmount = 0;
        this.lastMove = Actions.WAITING; // Default to waiting
    }

    // Getters
    public int getBalance() {
        return balance;
    }

    public PokerState getPokerState() {
        return pokerState;
    }

    public PokerState getOutcome() {
        return outcome;
    }

    public List<Card> getAiCards() {
        return aiCards;
    }

    public int getAiValue() {
        return aiValue;
    }

    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public int getPlayerValue() {
        return playerValue;
    }

    public List<Card> getFlopDeck() {
        return flopDeck;
    }

    public Card getTurnCard() {
        return turnCard;
    }

    public Card getRiverCard() {
        return riverCard;
    }

    public int getPlayerBetAmount() {
        return playerBetAmount;
    }

    public int getAiBetAmount() {
        return aiBetAmount;
    }

    public Actions getLastMove() {
        return lastMove;
    }

    // Setters
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setPokerState(PokerState pokerState) {
        this.pokerState = pokerState;
    }

    public void setOutcome(PokerState outcome) {
        this.outcome = outcome;
    }

    public void setAiCards(List<Card> aiCards) {
        this.aiCards = aiCards;
    }

    public void setAiValue(int aiValue) {
        this.aiValue = aiValue;
    }

    public void setPlayerCards(List<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public void setPlayerValue(int playerValue) {
        this.playerValue = playerValue;
    }

    public void setFlopDeck(List<Card> flopDeck) {
        this.flopDeck = flopDeck;
    }

    public void setTurnCard(Card turnCard) {
        this.turnCard = turnCard;
    }

    public void setRiverCard(Card riverCard) {
        this.riverCard = riverCard;
    }

    public void setPlayerBetAmount(int playerBetAmount) {
        this.playerBetAmount = playerBetAmount;
    }

    public void setAiBetAmount(int aiBetAmount) {
        this.aiBetAmount = aiBetAmount;
    }

    public void setLastMove(Actions lastMove) {
        this.lastMove = lastMove;
    }

    // Utility Methods
    public void addAiCard(Card card) {
        aiCards.add(card);
    }

    public void addPlayerCard(Card card) {
        playerCards.add(card);
    }

    public void addFlopCard(Card card) {
        flopDeck.add(card);
    }

    public void resetGame() {
        balance = 0;
        pokerState = PokerState.WAITING_TO_START;
        outcome = PokerState.ONGOING;
        aiCards.clear();
        aiValue = 0;
        playerCards.clear();
        playerValue = 0;
        flopDeck.clear();
        turnCard = null;
        riverCard = null;
        playerBetAmount = 0;
        aiBetAmount = 0;
        lastMove = Actions.WAITING;
    }
    public void newGame() {
        pokerState = PokerState.WAITING_TO_START;
        outcome = PokerState.ONGOING;
        aiCards.clear();
        aiValue = 0;
        playerCards.clear();
        playerValue = 0;
        flopDeck.clear();
        turnCard = null;
        riverCard = null;
        playerBetAmount = 0;
        aiBetAmount = 0;
        lastMove = Actions.WAITING;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "pokerState=" + pokerState +
                ", outcome=" + outcome +
                ", aiCards=" + aiCards +
                ", aiValue=" + aiValue +
                ", playerCards=" + playerCards +
                ", playerValue=" + playerValue +
                ", flopDeck=" + flopDeck +
                ", turnCard=" + turnCard +
                ", riverCard=" + riverCard +
                ", playerBetAmount=" + playerBetAmount +
                ", aiBetAmount=" + aiBetAmount +
                ", lastMove=" + lastMove +
                ", balance=" + balance +
                '}';
    }
}