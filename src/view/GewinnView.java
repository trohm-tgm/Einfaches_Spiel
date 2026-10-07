package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Thomas Rohm
 * @version 2026-28-09
 */
public class GewinnView extends JFrame {

    private JLabel lblRundenergebnis;
    private JLabel lblGesamtpunkte;
    private JTextField txtSpielerZahl;
    private JTextField txtComputerZahl;
    private JButton btnNochEinmal;

    public GewinnView() {
        super("Zahlen-Gewinnspiel");
//        start();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}