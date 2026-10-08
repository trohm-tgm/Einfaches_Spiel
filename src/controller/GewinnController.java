package controller;

import model.GewinnModel;
import view.GewinnView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Verbindet Model und View und reagiert auf Eingaben.
 * @author Thomas Rohm
 * @version 2026-28-09
 */
public class GewinnController {

    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;

        this.view.addSpielerZahlListener(new SpielerZahlListener());
        this.view.addNochEinmalListener(new NochEinmalListener());
    }
    //ein anderer Kommentar
    //Ein Kommentar, um die Änderungen zu markieren
    // Wird ausgelöst, wenn der Spieler im Zahlenfeld Enter drückt
    private class SpielerZahlListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int spielerZahl;
            try {
                spielerZahl = Integer.parseInt(view.getSpielerZahl().trim());
            } catch (NumberFormatException ex) {
                return; // keine gültige Zahl -> ignorieren
            }

            if (spielerZahl < 1 || spielerZahl > 9) {
                return;
            }

            model.berechneComputerZahl();
            model.berechneRunde(spielerZahl);

            view.zeigeComputerZahl(model.getComputerZahl());
            view.zeigeRundenErgebnis(model.getRundenErgebnis());
            view.zeigeGesamtPunkte(model.getGesamtPunkte());

            view.rundeGespielt();

            if (model.hatGewonnen()) {
                view.zeigeGewonnen();
            } else if (model.hatVerloren()) {
                view.zeigeVerloren();
            }

            Color farbe = bestimmeFarbe();
            view.setErgebnisFarbe(farbe);
            view.setPunkteFarbe(farbe);
        }
    }

    // Button "Noch einmal!": nächste Runde bzw. Neustart nach Spielende
    private class NochEinmalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (model.hatGewonnen() || model.hatVerloren()) {
                view.hardreset();
            }
            view.zurueckSetzen();
        }
    }

    // Grün bei Gewinn/Plus, Rot bei Verlust/Minus
    private Color bestimmeFarbe() {
        if (model.hatGewonnen() || model.getRundenErgebnis() > 0) {
            return Color.GREEN;
        } else if (model.hatVerloren() || model.getRundenErgebnis() < 0) {
            return Color.RED;
        } else {
            return Color.WHITE;
        }
    }
}
