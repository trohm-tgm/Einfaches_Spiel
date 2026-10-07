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
        start();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void start() {
        setLayout(new BorderLayout(10, 10));
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel infoPanel = new JPanel(new GridLayout(3, 2, 10, 5));
        infoPanel.add(new JLabel("Rundenergebnis:"));
        infoPanel.add(new JLabel("Gesamtpunkte:"));

//        lblRundenergebnis = wertLabel("Tippe eine Zahl von 1 bis 9");
//        lblGesamtpunkte = wertLabel("30");

        infoPanel.add(lblRundenergebnis);
        infoPanel.add(lblGesamtpunkte);
        infoPanel.add(new JLabel("Deine Zahl:"));
        infoPanel.add(new JLabel("Computer:"));

//        txtSpielerZahl = zahlFeld();
//        txtComputerZahl = zahlFeld();
        txtComputerZahl.setEditable(false);

        JPanel eingabePanel = new JPanel(new GridLayout(1, 2, 10, 5));
        eingabePanel.add(txtSpielerZahl);
        eingabePanel.add(txtComputerZahl);

        JPanel zentrum = new JPanel(new BorderLayout(10, 10));
        zentrum.add(infoPanel, BorderLayout.NORTH);
        zentrum.add(eingabePanel, BorderLayout.CENTER);
        add(zentrum, BorderLayout.CENTER);

        btnNochEinmal = new JButton("Noch einmal!");
        btnNochEinmal.setEnabled(false);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnNochEinmal);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}