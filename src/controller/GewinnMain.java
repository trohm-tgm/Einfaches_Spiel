package controller;

import model.GewinnModel;
import view.GewinnView;

/**
 * Die Main Klasse
 * @author Thomas Rohm
 * @version 2026-28-09
 */
public class GewinnMain {
    public static void main(String[] args) {
        GewinnModel model = new GewinnModel();
        GewinnView view = new GewinnView();
        new GewinnController(model, view);
    }
}
