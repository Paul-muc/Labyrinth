/*
 * Das Package koennen Sie auf Ihre Beduerfnisse anpassen!
 */
package edu.hm.labyrinth.part1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import edu.hm.labyrinth.Direction;
import edu.hm.labyrinth.Tile;

/**
 * Panel to represent a single tile. The tile is displayed as a 3X3 arrangement whose  
 * parts show either a "road" or "no road".
 * @author <a href="mailto:ab@cs.hm.edu>Axel Boettcher</a>
 *
 */
@SuppressWarnings("serial")
public class TilePanel extends JPanel {

    /**
     * The number of rows a tile is composed of. 
     */
    public static final int NUM_ROWS = 3;
    /**
     * The number of columns a tile is composed of. 
     */
    public static final int NUM_COLS = 3;
    
    /* border to be drawn around a tile */
    private final Border blackline = BorderFactory.createLineBorder(Color.black);
    
    /* backgroundColor to indicate that there is no road at the given position */
    
    private final Color backgroundColor = new Color(10, 100, 150);
    
    /* backgroundColor to indicate that there is a part of the road at a given position */
    private final Color roadColor = new Color(80, 200, 10);

    private GridLayout layout = new GridLayout(NUM_ROWS, NUM_COLS); 

    private JPanel[][] grid = new JPanel[NUM_ROWS][NUM_COLS];
    /* the underlying tile which is displayed by this component. */
    private Tile tile;

    /**
     * Panel to display a tile. The corners are grey. The center is alwasy part 
     * of the way through a tile and the sideways borders are colored depending
     * on existence of a connection to the respective side.
     * @param tile The tile to show in this panel.
     */
    TilePanel(Tile tile) {
        this.tile = tile;
        setBorder(blackline);
        setLayout(layout);
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                grid[row][col] = new JPanel();
                grid[row][col].setBackground(backgroundColor);
                this.add(grid[row][col]);
            }
        }
    }

    /**
     * Draws the current tile by setting it's background color either to the <code>roadColor</code>
     * or to the default background color. The middle tile is always a part of the road through this tile.
     * Draws a magic item onto the tile if there is one attached to it.
     * Draws a player onto the tile if there is one attached to it.
     * @param g The graphics context to draw on.
     */
    @Override
    public void paint(Graphics g) {
        grid[1][1].setBackground(roadColor);
        grid[0][1].setBackground(tile.isConnectedTo(Direction.NORTH) ? roadColor : backgroundColor);
        grid[2][1].setBackground(tile.isConnectedTo(Direction.SOUTH) ? roadColor : backgroundColor);
        grid[1][0].setBackground(tile.isConnectedTo(Direction.WEST) ? roadColor : backgroundColor);
        grid[1][2].setBackground(tile.isConnectedTo(Direction.EAST) ? roadColor : backgroundColor);
        super.paint(g);
    }

}
