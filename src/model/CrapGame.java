package model;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * CrapGame class is used to design the craps game logic.
 */
public class CrapGame {

    private PropertyChangeSupport changes = new PropertyChangeSupport(this);
    /** Used to randomize dice rolls. */
    private static final Random roller = new Random();
    /** The point in current roll. */
    private int myPoints;
    /** Amount of player wins. */
    private int playerWins;
    /** Amount of house wins. */
    private int houseWins;
    /** Die 1 result. */
    private int die1;
    /** Die 2 result. */
    private int die2;
    /** The total of die 1 and die 1. */
    private int myRollTotal;
    /** The bank account. */
    private BigDecimal myBank;
    /** The bet amount. */
    private BigDecimal myBetAmount;
    /** The game activity. */
    private boolean myGameActive;
    /** If the game is won. */
    private boolean myGameWon;
    /** Used for singleton. */
    private static CrapGame myInstance = new CrapGame();

    /**
     * Default constructor will start the game.
     */
    private CrapGame() {
        startGame();
    }

    /**
     * Method is used for singleton.
     * @return the craps game instance.
     */
    public static CrapGame getCrapsInstance() {
        return myInstance;
    }

    /**
     * Will initialize everything when the game starts.
     */
    public void startGame() {
        setGameActive(true);
        setGameWon(false);
        setPoints(0);
        setBank(new BigDecimal("0.00"));
        setBetAmount(new BigDecimal("0.00"));
        setPlayerWins(0);
        setHouseWins(0);
    }

    /**
     * Method is used to make the game active or not.
     * @param theGameActive true if they want game to be active, false otherwise.
     */
    public void setGameActive(final boolean theGameActive) {
        myGameActive = theGameActive;
        if (!myGameActive) {
            changes.firePropertyChange("active", null, false);
        }
    }

    /**
     * Is the game active?
     * @return true if the game is active; false otherwise.
     */
    public boolean getGameActive() {
        return myGameActive;
    }

    /**
     * Will set if the game is won or not.
     * @param theGameWon true if the player won, false otherwise.
     */
    public void setGameWon(final boolean theGameWon) {
        myGameWon = theGameWon;
    }

    /**
     * Did the player win the game?
     * @return true if player won; false otherwise.
     */
    public boolean getGameWon() {
        return myGameWon;
    }

    /**
     * Will set what the points are during the current roll.
     * @param thePoints the point of current roll.
     */
    public void setPoints(final int thePoints) {
        myPoints = thePoints;
    }

    /**
     * What is the point?
     * @return the point value.
     */
    public int getPoints() {
        return myPoints;
    }

    /**
     * Method is used to when we want to roll the dice. For the first roll,
     * if the sum is 7 or 11, the player wins. If the sum is 2, 3, or 12, the
     * player loses. If the sum is 4, 5, 6, 8, 9, or 10, that sum becomes the player's
     * 'point.' It'll continue rolling until the 2 die hit the player point or 7. The player
     * should roll the 'point' total before rolling a 7 to win.
     */
    public void roll() {
        die1 = roller.nextInt(6) + 1;
        die2 = roller.nextInt(6) + 1;
        setTotal(die1 + die2);
        if (myPoints == 0) {
            if (myRollTotal == 7 || myRollTotal == 11) {
                winner();
            } else if (myRollTotal == 2 || myRollTotal == 3 || myRollTotal == 12) {
                loser();
            } else {
                setPoints(myRollTotal);
            }
        }
        else {
            if (myRollTotal == myPoints) {
                winner();
            }
            else if(myRollTotal == 7) {
                loser();
            }
        }
    }

    /**
     * Method is used when the player won. Will incremement player wins
     * and add the bet amount to the bank.
     */
    public void winner() {
        setPlayerWins(playerWins + 1);
        setBank(myBank.add(myBetAmount));
        setGameActive(false);
        setGameWon(true);
    }

    /**
     * Method is used when the player won. Will incremement house wins
     * and add the bet amount to the bank.
     */
    public void loser() {
        setHouseWins(houseWins + 1);
        setBank(myBank.subtract(myBetAmount));
        setGameActive(false);
        setGameWon(false);
    }

    /**
     * Set the bank amount.
     * @param theBank the amount we want in the bank.
     */
    public void setBank(final BigDecimal theBank) {
        myBank = theBank.setScale(2, RoundingMode.HALF_EVEN);
    }

    /**
     * What is the bank amount?
     * @return the bank amount.
     */
    public BigDecimal getBank() {
        return myBank;
    }

    /**
     * Set the betting amount.
     * @param theBetAmount how much we want to bet.
     */
    public void setBetAmount(final BigDecimal theBetAmount) {
        if (theBetAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
       /* if (theBetAmount < 0) {
            throw new IllegalArgumentException();
        } */
        myBetAmount = theBetAmount.setScale(2, RoundingMode.HALF_EVEN);
    }

    /**
     * What is the bet amount?
     * @return The bet amount.
     */
    public BigDecimal getBetAmount() {
        return myBetAmount;
    }

    /**
     * Set total of die 1 and die 2.
     * @param theTotal the total of die 1 and die 2.
     */
    public void setTotal(final int theTotal) {
        if (theTotal < 0) {
            throw new IllegalArgumentException();
        }
        myRollTotal = theTotal;
    }

    /**
     * What is the total of die 1 and die 2?
     * @return total of die 1 and die 2.
     */
    public int getTotal() {
        return myRollTotal;
    }

    /**
     * How many wins does the player have?
     * @return the amount of wins the player have.
     */
    public int getPlayerWins() {
        return playerWins;
    }

    /**
     * Set the player win amount.
     * @param thePlayerWins How much wins we want players to have.
     */
    public void setPlayerWins(final int thePlayerWins) {
        if (thePlayerWins < 0) {
            throw new IllegalArgumentException();
        }
        playerWins = thePlayerWins;
    }

    /**
     * How many wins does house have?
     * @return the amount of house wins has.
     */
    public int getHouseWins() {
        return houseWins;
    }

    /**
     * Set the house win amount.
     * @param theHouseWins How much wins we want the house to have.
     */
    public void setHouseWins(final int theHouseWins) {
        if (theHouseWins < 0) {
            throw new IllegalArgumentException();
        }
        houseWins = theHouseWins;
    }

    /**
     * What is the die 1 result?
     * @return the die 1 result.
     */
    public int getDie1() {
        return die1;
    }

    /**
     * What is the die 2 result?
     * @return the die 1 result.
     */
    public int getDie2() {
        return die2;
    }

    /**
     * Method is used to reset all the game data. It'll
     * also turn game the game back on.
     */
    public void clear() {
        setGameActive(true);
        setPlayerWins(0);
        setPoints(0);
        setHouseWins(0);
        setTotal(0);
        setBetAmount(new BigDecimal("0.00"));
        setBank(new BigDecimal("0.00"));
    }


    public void addPropertyChangeListener(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }
    public void removePropertyChangeListener(PropertyChangeListener l) {
        changes.removePropertyChangeListener(l);
    }
}
