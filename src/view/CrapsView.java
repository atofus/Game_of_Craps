package view;

import model.CrapGame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.security.Key;

/**
 * CrapsView class is used to design the frame and GUI for the craps game.
 */
public class CrapsView extends JFrame implements PropertyChangeListener {

    /** Label used to show current roll section.*/
    private JLabel myCurrentRoll;
    /** A button to roll the dice. */
    private JButton myRoll;
    /** Label used to show that it's die 1. */
    private JLabel myDie1;
    /** Text pane to show what Die 1 landed on. */
    private JTextPane myDie1Pane;
    /** Label used to show that it's die 2. */
    private JLabel myDie2;
    /** Pane to show Die 2 what Die 2 landed on. */
    private JTextPane myDie2Pane;
    /** Label used to show that it's the total of 2 die. */
    private JLabel myTotal;
    /** Pane to show the total of 2 dice. */
    private JTextPane myTotalPane;
    /** Label used to show that it's the point. */
    private JLabel myPoint;
    /** Text pane used to show the point of the current roll. */
    private JTextPane myPointPane;
    /** Label to show that it's the bank. */
    private JLabel myBank;
    /** Label used for the title. */
    private JLabel myTitle;
    /** Label used to insert dollar sign. */
    private JLabel myDollarSign;
    /** Button to play the game again. */
    private JButton myPlayAgain;
    /** Text field where we could insert our bank amount. */
    private JTextField myBankField;
    /** Text field where we could put in our betting amount. */
    private JTextField myBetField;
    /** Label used to indicate the betting section. */
    private JLabel myBet;
    /** Button used to set the bank value in the field. */
    private JButton mySetBank;
    /** Button used to set bet value to $1. */
    private JButton myBet$1;
    /** Button used to set bet value to $5. */
    private JButton myBet$5;
    /** Button used to set bet value to $10. */
    private JButton myBet$10;
    /** Button used to set bet value to $50. */
    private JButton myBet$50;
    /** Button used to set bet value to $100. */
    private JButton myBet$100;
    /** Button used to set bet value to $500. */
    private JButton myBet$500;
    /** Pane to show if the player won or not. */
    private JTextPane myWinnerPane;
    /** Label used to show where the win total is located. */
    private JLabel myWinTotal;
    /** Label to show where the player win amounts are. */
    private JLabel myPlayerWins;
    /** Pane to show the amount of times the player won. */
    private JTextPane myPlayerWinsPane;
    /** Label to show where the house win amounts are. */
    private JLabel myHouseWins;
    /** Pane to show the amount of times the house won. */
    private JTextPane myHouseWinsPane;
    /** The game menu for the GUI. */
    private JMenu myGameMenu;
    /** Sub menu in the game menu should start game. */
    private JMenuItem myStart;
    /** Sub menu in the game menu should reset game. */
    private JMenuItem myReset;
    /** Sub menu in the game menu should exit GUI. */
    private JMenuItem myExit;
    /** The help menu for the GUI. */
    private JMenu myHelpMenu;
    /** Sub menu in the help menu to talk about GUI. */
    private JMenuItem myAbout;
    /** Sub menu in the help menu to talk about game rules */
    private JMenuItem myRules;
    /** Sub menu in the help menu to tell key shortcuts. */
    private JMenuItem myShortcuts;
    /** Used to add all menu components. */
    private JMenuBar myJMenuBar;

    /**
     * Default constructor for the GUI. It should set everything up in the GUI by initializing them.
     * It should also show what components are activated when the game starts.
     */
    public CrapsView() {
        JOptionPane.showMessageDialog(null, "Please set your bank amount before playing");
        myTitle = new JLabel("The Game of Craps");
        myPlayAgain = new JButton("Play Again");
        myPlayAgain.setEnabled(false);
        myCurrentRoll = new JLabel("CURRENT ROLL:");
        myRoll = new JButton("Roll Dice");
        myRoll.setMnemonic(KeyEvent.VK_D);
        myRoll.setEnabled(false);
        myDie1 = new JLabel("Die 1:");
        myDie1Pane = new JTextPane();
        myDie1Pane.setEnabled(false);
        myDie1Pane.setDisabledTextColor(Color.BLACK);
        myDie2 = new JLabel("Die 2:");
        myDie2Pane = new JTextPane();
        myDie2Pane.setEnabled(false);
        myDie2Pane.setDisabledTextColor(Color.BLACK);
        myTotal = new JLabel("Total:");
        myTotalPane = new JTextPane();
        myTotalPane.setEnabled(false);
        myTotalPane.setDisabledTextColor(Color.BLACK);
        myPoint = new JLabel("Point:");
        myPointPane = new JTextPane();
        myPointPane.setEnabled(false);
        myPointPane.setDisabledTextColor(Color.BLACK);
        myBank = new JLabel("BANK:");
        myDollarSign = new JLabel("$");
        myBankField = new JTextField();
        myBankField.setEnabled(false);
        myBankField.setDisabledTextColor(Color.BLACK);
        mySetBank = new JButton("SET BANK");
        mySetBank.setEnabled(false);
        myBetField = new JTextField();
        myBetField.setEnabled(false);
        myBetField.setDisabledTextColor(Color.BLACK);
        myBet$1 = new JButton("+$1");
        myBet$1.setEnabled(false);
        myBet$5 = new JButton("+$5");
        myBet$5.setEnabled(false);
        myBet$10 = new JButton("+$10");
        myBet$10.setEnabled(false);
        myBet$50 = new JButton("+$50");
        myBet$50.setEnabled(false);
        myBet$100 = new JButton("+$100");
        myBet$100.setEnabled(false);
        myBet$500 = new JButton("+$500");
        myBet$500.setEnabled(false);
        myWinnerPane = new JTextPane();
        myWinnerPane.setEnabled(false);
        myWinnerPane.setDisabledTextColor(Color.BLACK);
        myBet = new JLabel("BET:");
        myWinTotal = new JLabel("WIN TOTALS:");
        myPlayerWins = new JLabel("Player Win Total:");
        myPlayerWinsPane = new JTextPane();
        myPlayerWinsPane.setEnabled(false);
        myPlayerWinsPane.setDisabledTextColor(Color.BLACK);
        myHouseWins = new JLabel("House Win Total:");
        myHouseWinsPane = new JTextPane();
        myHouseWinsPane.setEnabled(false);
        myHouseWinsPane.setDisabledTextColor(Color.BLACK);

        setJMenuBar(createMenuBar());
        layoutComponents();
        addListeners();
    }

    /**
     * This method is used to create the menu for the GUI.
     * @return the JMenu Bar
     */
    private JMenuBar createMenuBar() {
        myJMenuBar = new JMenuBar();
        myGameMenu = new JMenu("Game");
        myJMenuBar.add(myGameMenu);
        myGameMenu.setMnemonic(KeyEvent.VK_G); //keyboard shortcut to get into game menu
        myHelpMenu = new JMenu("Help");
        myJMenuBar.add(myHelpMenu);
        myHelpMenu.setMnemonic(KeyEvent.VK_H); //keyboard shortcut to get to help menu
        myStart = new JMenuItem("Start");
        myStart.setMnemonic(KeyEvent.VK_T); //keyboard shortcut to start
        myReset = new JMenuItem("Reset");
        myReset.setMnemonic(KeyEvent.VK_R);
        myReset.setEnabled(false);
        myExit = new JMenuItem("Exit");
        myExit.setMnemonic(KeyEvent.VK_E);
        myGameMenu.add(myStart);
        myGameMenu.add(myReset);
        myGameMenu.add(myExit);
        myAbout = new JMenuItem("About");
        myAbout.setMnemonic(KeyEvent.VK_A);
        myRules = new JMenuItem("Rules");
        myRules.setMnemonic(KeyEvent.VK_Q);
        myShortcuts = new JMenuItem("Shortcuts");
        myShortcuts.setMnemonic(KeyEvent.VK_S);
        myHelpMenu.add(myAbout);
        myHelpMenu.add(myRules);
        myHelpMenu.add(myShortcuts);

        return myJMenuBar;
    }

    /**
     * Method is going to take every component that's already been initialized and place them where
     * it's needed in the frame.
      */
    private void layoutComponents() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        myTitle.setHorizontalAlignment(SwingConstants.CENTER);
        myTitle.setFont(new Font("Arial Black", Font.PLAIN, 20));
        myTitle.setBounds(153, 11, 216, 29);
        add(panel.add(myTitle));


       // play again button
        myPlayAgain.setBounds(85, 51, 350, 29);
        add(panel.add(myPlayAgain));


        //Roll Dice button
        myRoll.setBounds(21, 102, 98, 29);
        add(panel.add(myRoll));


        //Current Roll Label
        myCurrentRoll.setFont(new Font("Tahoma", Font.BOLD, 17));
        myCurrentRoll.setBounds(153, 119, 146, 29);
        add(panel.add(myCurrentRoll));
        //Die 1 Label
        myDie1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        myDie1.setBounds(163, 143, 51, 29);
        add(panel.add(myDie1));
        //Pane for die 1
        myDie1Pane.setBounds(211, 152, 58, 20);
        add(panel.add(myDie1Pane));
        //Die 2 Label
        myDie2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        myDie2.setBounds(163, 171, 51, 29);
        add(panel.add(myDie2));
        //Pane for die 2
        myDie2Pane.setBounds(211, 180, 58, 20);
        add(panel.add(myDie2Pane));
        //Total Label
        myTotal.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        myTotal.setBounds(163, 200, 51, 29);
        add(panel.add(myTotal));
        //Pane for total
        myTotalPane.setBounds(211, 209, 58, 20);
        add(panel.add(myTotalPane));

        //Point Label
        myPoint.setFont(new Font("Tahoma", Font.PLAIN, 15));
        myPoint.setBounds(21, 142, 58, 20);
        add(panel.add(myPoint));
        //Point pane
        myPointPane.setBounds(61, 142, 58, 20);
        add(panel.add(myPointPane));

        //Bank Label
        myBank.setFont(new Font("Tahoma", Font.BOLD, 17));
        myBank.setBounds(350, 99, 146, 29);
        add(panel.add(myBank));
        //Bank text field
        myBankField.setBounds(372, 126, 83, 20);
        add(panel.add(myBankField));
        myBankField.setColumns(10);
        //$ label
        myDollarSign.setFont(new Font("Tahoma", Font.PLAIN, 17));
        myDollarSign.setBounds(360, 126, 18, 14);
        add(panel.add(myDollarSign));
        //Bet Label
        myBet.setFont(new Font("Tahoma", Font.BOLD, 17));
        myBet.setBounds(350, 180, 58, 29);
        add(panel.add(myBet));
        //Bet text field
        myBetField.setColumns(10);
        myBetField.setBounds(352, 206, 83, 20);
        add(panel.add(myBetField));
        //Set bet button
        mySetBank.setBounds(360, 148, 100, 23);
        add(panel.add(mySetBank));

        //The set bet money buttons
        myBet$1.setBounds(358, 234, 77, 23);
        add(panel.add(myBet$1));
        myBet$5.setBounds(358, 265, 77, 23);
        add(panel.add(myBet$5));
        myBet$10.setBounds(358, 299, 77, 23);
        add(panel.add(myBet$10));
        myBet$50.setBounds(358, 333, 77, 23);
        add(panel.add(myBet$50));
        myBet$100.setBounds(358, 367, 77, 23);
        add(panel.add(myBet$100));
        myBet$500.setBounds(358, 401, 77, 23);
        add(panel.add(myBet$500));

        //Winner Pane
        myWinnerPane.setBounds(21, 234, 77, 20);
        add(panel.add(myWinnerPane));
        //Win Total Label
        myWinTotal.setFont(new Font("Tahoma", Font.BOLD, 17));
        myWinTotal.setBounds(21, 269, 146, 29);
        add(panel.add(myWinTotal));
        //Player Win Total
        myPlayerWins.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        myPlayerWins.setBounds(31, 294, 125, 29);
        add(panel.add(myPlayerWins));
        //Player win Pane
        myPlayerWinsPane.setBounds(153, 299, 98, 20);
        add(panel.add(myPlayerWinsPane));
        //House Win Total
        myHouseWins.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        myHouseWins.setBounds(31, 349, 125, 29);
        add(panel.add(myHouseWins));
        //House Win pane
        myHouseWinsPane.setBounds(153, 358, 98, 20);
        add(panel.add(myHouseWinsPane));
    }

    /**
     * Add listeners (event handlers) to any GUI components that require handling.
     */
    private void addListeners() {
        myStart.addActionListener(e -> {
            myStart.setEnabled(false);
            CrapGame craps = CrapGame.getCrapsInstance();
            craps.startGame();
            myPointPane.setText(String.valueOf(craps.getPoints()));
            myPlayerWinsPane.setText(String.valueOf(craps.getPlayerWins()));
            myHouseWinsPane.setText(String.valueOf(craps.getHouseWins()));
            myBankField.setText(String.valueOf(craps.getBank()));
            myBetField.setText(String.valueOf(craps.getBetAmount()));
            mySetBank.setEnabled(true);
            myBet$1.setEnabled(true);
            myBet$5.setEnabled(true);
            myBet$10.setEnabled(true);
            myBet$50.setEnabled(true);
            myBet$100.setEnabled(true);
            myBet$500.setEnabled(true);
            myBankField.setEnabled(true);
            myBetField.setEnabled(true);
        });

        myBankField.addActionListener(e -> {
            CrapGame craps = CrapGame.getCrapsInstance();
            BigDecimal initial = craps.getBank();
            try {
                BigDecimal res = new BigDecimal(myBankField.getText());
                if (res.compareTo(BigDecimal.ZERO) < 0) {
                    myBankField.setText(String.valueOf(initial));
                    JOptionPane.showMessageDialog(null, "Please enter a positive value.");
                } else {
                    craps.setBank(res);
                    System.out.println(craps.getBank());
                    mySetBank.setEnabled(false);
                    //myRoll.setEnabled(true);
                    myBankField.setEnabled(false);
                    rollDiceOn();
                    myReset.setEnabled(true);
                }
            }catch (NumberFormatException nfe) {
                myBankField.setText(String.valueOf(initial));
                JOptionPane.showMessageDialog(null, "Please enter a number value.");
            }
        });

        mySetBank.addActionListener(e -> {
            CrapGame craps = CrapGame.getCrapsInstance();
            BigDecimal initial = craps.getBank();
            try {
                BigDecimal res = new BigDecimal(myBankField.getText());
                if (res.compareTo(BigDecimal.ZERO) < 0) {
                    myBankField.setText(String.valueOf(initial));
                    JOptionPane.showMessageDialog(null, "Please enter a positive value please.");
                } else {
                    craps.setBank(res);
                    mySetBank.setEnabled(false);
                    //myRoll.setEnabled(true);
                    myBankField.setEnabled(false);
                    rollDiceOn();
                    myReset.setEnabled(true);
                }
            }catch (NumberFormatException nfe) {
                myBankField.setText(String.valueOf(initial));
                JOptionPane.showMessageDialog(null, "Please enter a number value please.");
            }
        });

        myBetField.addActionListener(e -> {
            CrapGame craps = CrapGame.getCrapsInstance();
            BigDecimal initial = craps.getBetAmount();
            try {
                BigDecimal res = new BigDecimal(myBetField.getText());
                if (res.compareTo(BigDecimal.ZERO) < 0) {
                    myBetField.setText(String.valueOf(initial));
                    JOptionPane.showMessageDialog(null, "Please enter a positive value.");
                } else {
                    craps.setBetAmount(res);
                    myBetField.setEnabled(false);
                    myBet$1.setEnabled(false);
                    myBet$5.setEnabled(false);
                    myBet$10.setEnabled(false);
                    myBet$50.setEnabled(false);
                    myBet$100.setEnabled(false);
                    myBet$500.setEnabled(false);
                    rollDiceOn();
                    myReset.setEnabled(true);
                }
            } catch (NumberFormatException nfe) {
                myBetField.setText(String.valueOf(initial));
                JOptionPane.showMessageDialog(null, "Please enter a number value.");
            }
        });

        myRoll.addActionListener(e -> {
            CrapGame craps = CrapGame.getCrapsInstance();
            if (craps.getGameActive()) {
                craps.roll();
                myDie1Pane.setText(String.valueOf(craps.getDie1()));
                myDie2Pane.setText(String.valueOf(craps.getDie2()));
                myTotalPane.setText(String.valueOf(craps.getTotal()));
                System.out.println(craps.getGameWon());
                if (craps.getPoints() != 0) {
                    myPointPane.setText(String.valueOf(craps.getPoints()));
                }
            }
            //when the game is over and player lost or won
            if (!craps.getGameActive() && craps.getGameWon()) {
                myWinnerPane.setText("You Won!");
                myPlayerWinsPane.setText(String.valueOf(craps.getPlayerWins()));
                myPlayAgain.setEnabled(true);
                myRoll.setEnabled(false);
                myBankField.setText(String.valueOf(craps.getBank()));
                myBetField.setText("0.00");
            } else if (!craps.getGameActive() && !craps.getGameWon()) {
                myWinnerPane.setText("You Lost!");
                myHouseWinsPane.setText(String.valueOf(craps.getHouseWins()));
                if (craps.getBank().compareTo(BigDecimal.ZERO) <= 0) {
                    JOptionPane.showMessageDialog(null,
                            "You are now poor. Thanks for playing! " +
                                    "Reset if you want to play again!");
                    myReset.setEnabled(true);
                    myRoll.setEnabled(false);
                    myBet$1.setEnabled(false);
                    myBet$5.setEnabled(false);
                    myBet$10.setEnabled(false);
                    myBet$50.setEnabled(false);
                    myBet$100.setEnabled(false);
                    myBet$500.setEnabled(false);
                } else {
                    myPlayAgain.setEnabled(true);
                    myRoll.setEnabled(false);
                }
                myBankField.setText(String.valueOf(craps.getBank()));
                myBetField.setText("0.00");
            }
        });

        myPlayAgain.addActionListener(e -> {
            CrapGame craps = CrapGame.getCrapsInstance();
            craps.setGameActive(true);
            myPlayAgain.setEnabled(false);
            myPointPane.setText("");
            myDie1Pane.setText("");
            myDie2Pane.setText("");
            myTotalPane.setText("");
            myBetField.setEnabled(true);
            myWinnerPane.setText("");
            myBet$1.setEnabled(true);
            myBet$5.setEnabled(true);
            myBet$10.setEnabled(true);
            myBet$50.setEnabled(true);
            myBet$100.setEnabled(true);
            myBet$500.setEnabled(true);
        });

        myBet$1.addActionListener(e -> {
            CrapGame craps = CrapGame.getCrapsInstance();
            myBetField.setText("1.00");
            myBetField.setEnabled(false);
            rollDiceOn();
            craps.setBetAmount(new BigDecimal("1.00"));
            myBet$1.setEnabled(false);
            myBet$5.setEnabled(false);
            myBet$10.setEnabled(false);
            myBet$50.setEnabled(false);
            myBet$100.setEnabled(false);
            myBet$500.setEnabled(false);
        });

        myBet$5.addActionListener(e -> {
            CrapGame craps = CrapGame.getCrapsInstance();
            myBetField.setText("5.00");
            myBetField.setEnabled(false);
            rollDiceOn();
            craps.setBetAmount(new BigDecimal("5.00"));
            myBet$1.setEnabled(false);
            myBet$5.setEnabled(false);
            myBet$10.setEnabled(false);
            myBet$50.setEnabled(false);
            myBet$100.setEnabled(false);
            myBet$500.setEnabled(false);
        });

        myBet$10.addActionListener(e -> {
            CrapGame craps = CrapGame.getCrapsInstance();
            myBetField.setText("10.00");
            myBetField.setEnabled(false);
            rollDiceOn();
            craps.setBetAmount(new BigDecimal("10.00"));
            myBet$1.setEnabled(false);
            myBet$5.setEnabled(false);
            myBet$10.setEnabled(false);
            myBet$50.setEnabled(false);
            myBet$100.setEnabled(false);
            myBet$500.setEnabled(false);
        });

        myBet$50.addActionListener(e -> {
            CrapGame craps = CrapGame.getCrapsInstance();
            myBetField.setText("50.00");
            myBetField.setEnabled(false);
            rollDiceOn();
            craps.setBetAmount(new BigDecimal("50.00"));
            myBet$1.setEnabled(false);
            myBet$5.setEnabled(false);
            myBet$10.setEnabled(false);
            myBet$50.setEnabled(false);
            myBet$100.setEnabled(false);
            myBet$500.setEnabled(false);
        });

        myBet$100.addActionListener(e -> {
            CrapGame craps = CrapGame.getCrapsInstance();
            myBetField.setText("100.00");
            myBetField.setEnabled(false);
            rollDiceOn();
            craps.setBetAmount(new BigDecimal("100.00"));
            myBet$1.setEnabled(false);
            myBet$5.setEnabled(false);
            myBet$10.setEnabled(false);
            myBet$50.setEnabled(false);
            myBet$100.setEnabled(false);
            myBet$500.setEnabled(false);
        });

        myBet$500.addActionListener(e -> {
            CrapGame craps = CrapGame.getCrapsInstance();
            myBetField.setText("500.00");
            myBetField.setEnabled(false);
            rollDiceOn();
            craps.setBetAmount(new BigDecimal("500.00"));
            myBet$1.setEnabled(false);
            myBet$5.setEnabled(false);
            myBet$10.setEnabled(false);
            myBet$50.setEnabled(false);
            myBet$100.setEnabled(false);
            myBet$500.setEnabled(false);
        });

        myReset.addActionListener(e -> {
            CrapGame craps = CrapGame.getCrapsInstance();
            craps.clear();
            myBankField.setEnabled(true);
            myBankField.setText(String.valueOf(craps.getBank()));
            mySetBank.setEnabled(true);
            myPointPane.setText("");
            myDie1Pane.setText("");
            myDie2Pane.setText("");
            myTotalPane.setText("");
            myBetField.setEnabled(true);
            myBetField.setText(String.valueOf(craps.getBetAmount()));
            myWinnerPane.setText("");
            myBet$1.setEnabled(true);
            myBet$5.setEnabled(true);
            myBet$10.setEnabled(true);
            myBet$50.setEnabled(true);
            myBet$100.setEnabled(true);
            myBet$500.setEnabled(true);
            myPlayerWinsPane.setText(String.valueOf(craps.getPlayerWins()));
            myHouseWinsPane.setText(String.valueOf(craps.getHouseWins()));
        });

        myExit.addActionListener(e -> {
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to leave?",
                    "Exit", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        myAbout.addActionListener(e -> JOptionPane.showMessageDialog(null,
                "Created by: Alan To \n" +
                "Java Version: JavaSE-19 \n" +
                        "Created in: March, 2023", "About", JOptionPane.INFORMATION_MESSAGE));

        myRules.addActionListener(e -> JOptionPane.showMessageDialog(null,
                "A player rolls two dice " +
                "where each die has six faces in the usual way (values 1 through 6).\n" +
                "After the dice have come to rest the sum of the two upward faces is calculated.\n" +
                "The first roll/throw\n" +
                "If the sum is 7 or 11 on the first throw the roller/player wins.\n" +
                "If the sum is 2, 3 or 12 the roller/player loses, that is the house wins.\n" +
                "If the sum is 4, 5, 6, 8, 9, or 10, that sum becomes the roller/player's 'point'.\n" +
                "Continue rolling given the player's point\n" +
                "Now the player must roll the 'point' total before rolling a 7 in order to win.\n" +
                "If they roll a 7 before rolling the point value they got on the first roll the " +
                "roller/player loses (the 'house' wins).", "Rules", JOptionPane.INFORMATION_MESSAGE));

        myShortcuts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Game Menu: Alt + G\n" +
                        "   -Start Game: Alt + T\n" + "   -Reset Game: Alt + R\n" +
                        "   -Exit Game: Alt + E\n" + "Help Menu: Alt + H\n" + "   -About Menu: Alt + A\n" +
                        "   -Rules Menu: Alt + Q\n" + "   -Shortcuts menu: Alt + S", "Shortcuts",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    /**
     * Helper method. If both the bank field and bet field are both turned off, it would mean
     * that the user has already inserted their bank and bets. This should turn
     * on the roll dice button.
     */
    private void rollDiceOn() {
        if (!myBankField.isEnabled() && !myBetField.isEnabled()) {
            myRoll.setEnabled(true);
        }
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName() == "active")
            if((boolean)evt.getNewValue() == false) {
                myRoll.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Game is not active!");
            }
    }



}
