package model;

/**
 * Spiellogik: Spieler tippt eine Zahl von 1-9 gegen eine Zufallszahl des Computers.
 * Start mit 30 Punkten, gewonnen ab 100, verloren bei 0.
 * @author thomas rohm
 * @version 2026-28-09
 */
public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        berechneComputerZahl();
        this.rundenErgebnis = 0;
        this.gesamtPunkte = 30;
    }

    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    public int getComputerZahl() {
        return computerZahl;
    }

    public int getRundenErgebnis() {
        return rundenErgebnis;
    }

    // Zufallszahl von 1 bis 9
    public void berechneComputerZahl() {
        this.computerZahl = (int) (Math.random() * 9) + 1;
    }

    // Treffer: +20, um 1 daneben: +5, sonst: -10
    public void berechneRunde(int spielerZahl) {
        this.spielerZahl = spielerZahl;
        if (spielerZahl == computerZahl) {
            rundenErgebnis = 20;
        } else if (spielerZahl - 1 == computerZahl || spielerZahl + 1 == computerZahl) {
            rundenErgebnis = 5;
        } else {
            rundenErgebnis = -10;
        }
        gesamtPunkte += rundenErgebnis;
    }

    public boolean hatGewonnen() {
        return gesamtPunkte >= 100;
    }

    public boolean hatVerloren() {
        return gesamtPunkte <= 0;
    }
}
