/*
 * Das Package koennen Sie auf Ihre Beduerfnisse anpassen!
 */
package edu.hm.labyrinth.part1;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.hm.labyrinth.tile.Nook;
import edu.hm.labyrinth.tile.Straight;
import edu.hm.labyrinth.tile.Tile;
import edu.hm.labyrinth.tile.Tri;

/**
 * GUI-Klasse fuer den ersten Teil der Labyrinth-Aufgabe.
 * 
 * @author Axel Boettcher
 * 
 */
@SuppressWarnings("serial")
public class Application1 extends JFrame {

    /**
     * Initialisiert das GUI mit dem Panel zum Rotieren eines Tiles.
     * @param tile Das Tile, das dargestellt werden soll.
     */
    public Application1(Tile tile) {
        add(new RotatePanel(tile));
        setVisible(true);
        setTitle("Labyrinth Teil 1");
        pack();
    }

    /**
     * Main-Methode, die ein kleines GUI aufmacht, in dem eine Labyrinth-Kachel
     * angezeigt und gedreht werden kann.
     * 
     * @param args
     *            Als Kommandozeilenargument muss einer der Typnamen Nook, Tri
     *            oder Straight uebergeben werden. Diese Klasse wird
     *            instanziiert und das entsprechende Tile angezeigt.
     */
    public static void main(String... args) {
        if (args.length != 1) {
            System.err
                    .println("Die Anwendung benoetigt genau ein Kommandozeilenargument (\"Nook\", \"Straight\" oder \"Tri\")");
            System.exit(-1);
        }
        Tile tile = null;
        switch (args[0]) {
        case "Nook":
            tile = new Nook();
            break;
        case "Straight":
            tile = new Straight();
            break;
        case "Tri":
            tile = new Tri();
            break;
        default:
            System.err.println("Als Kommandozeilenargument sind nur \"Nook\", \"Straight\" oder \"Tri\" erlaubt!");
            System.err.println(args[0] + " ist unzulaessig!");
            System.exit(-1);
        }
        new Application1(tile);

    }

    /**
     * Private Klasse fuer das Panel mit den Anzeigekomponenten.
     * @author axel
     *
     */
    private class RotatePanel extends JPanel {

        static final int PREFERRED_SIZE = 100;
        private final JButton rotateButton = new JButton("rotate");
        private final JButton rotateRandomButton = new JButton("random rot.");
        private TilePanel tilePanel;

        /**
         * Initializes the panel with tile and button on it.
         * @param tile
         *            The tile as underlying model.
         */
        public RotatePanel(final Tile tile) {
            tilePanel = new TilePanel(tile);
            tilePanel.setPreferredSize(new Dimension(PREFERRED_SIZE, PREFERRED_SIZE));
            this.add(tilePanel);
            this.add(rotateButton);
            this.add(rotateRandomButton);
            rotateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tile.rotateClockwise();
                    RotatePanel.this.getParent().repaint();
                }
            });
            rotateRandomButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tile.randomlyRotate();
                    RotatePanel.this.getParent().repaint();
                }
            });
        }


    }
}
