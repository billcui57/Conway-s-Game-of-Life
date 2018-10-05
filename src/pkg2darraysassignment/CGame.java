/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2darraysassignment;

import java.util.Scanner;

/**
 *
 * @author 348848128
 */
public class CGame {

   boolean[][]grid;

   /**
    * 
    * @param rows number of rows
    * @param cols number of columns
    * creates an array and fills it with dead cells
    */
    public  void initializeGrid(int rows, int cols) {
        grid=new boolean[rows][cols];
        
        // sets the entire array to dead
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                grid[y][x] = false;
            }
        }
    }

    /**
     * 
     * @param rows number of rows
     * @param cols number of columns
     * @return returns the updated grid after cells have died or respawned
     * Updates the grid according to the basic rules
     * if less then 2 or more than 3 neighbours, then dead
     * if cell is dead and has 3 neighbours exact, then respawn
     * if cell is alive and has 2 or 3 neighbours, then no change
     */
    public boolean[][] updateGrid(int rows, int cols) {
       
        boolean[][] newGrid = new boolean[rows][cols];
        
        //duplicates from reference grid to change
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                newGrid[y][x] = grid[y][x];
            }
        }

        //cell condition checker and updater
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {

                //gets the number of neighbours
                int neighbours = numNeighbours( y, x);
                //if less then 2 or more than 3 neighbours, then dead
                //if cell is dead and has 3 neighbours exact, then respawn
                //if cell is alive and has 2 or 3 neighbours, then no change
                if (neighbours < 2) {
                    newGrid[y][x] = false;
                } else if (neighbours > 3) {
                    newGrid[y][x] = false;
                } else if ((neighbours == 3) && (grid[y][x] == false)) {
                    newGrid[y][x] = true;
                }
            }
        }

        //updates reference grid after it has been updated
        grid = newGrid;
        
        
        return grid;
    }

    /**
     * 
     * @param row number of rows
     * @param col number of columns
     * @return returns the number of neighbours that each cell has
     * finds the number of neighbours that each cell has
     */
    public int numNeighbours( int row, int col) {
        int numNeighbour = 0;
        //checks 3 by 3 area around a cell to determine number of neighbours
        try {
            for (int y = -1; y < 2; y++) {
                for (int x = -1; x < 2; x++) {
                    if ((y == 0) && (x == 0)) {
                    } else {
                        if ((grid[row + y][col + x] == true)) {
                            numNeighbour++;
                        }
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {

        }

        return numNeighbour;
    }

    /**
     * 
     * @param row number of rows
     * @param col number of columns
     * clears the grid by killing all cells
     */
    public void clearGrid(int row,int col){
        //sets the entire array to false
        for(int y=0;y<row;y++){
            for(int x=0;x<col;x++){
                grid[y][x]=false;
            }
        }
    }
    
    /**
     * 
     * @param row number of rows
     * @param col number of columns
     * sets the grid into a preset configuration - the + shaped configuration
     */
    public void preset1(int row,int col){
        //sets an entire column to alive
        for(int y=0;y<row;y++){
            grid[y][(int)col/2]=true;
        }
        //sets an entire row to alive
        for(int x=0;x<col;x++){
            grid[(int)row/2][x]=true;
        }
    }
    
    /**
     * 
     * @param row number of rows
     * @param col number of columns
     * sets the grid into a preset configuration - the infinite growth configuration
     * these configurations take up a lot of lines, perhaps storing them in a .json file would be better 
     */
    public void preset2(int row,int col){
        grid[row/2][col/2]=true;
        grid[row/2][col/2+1]=true;
        grid[row/2][col/2+2]=true;
        grid[row/2][col/2+4]=true;
        grid[row/2+1][col/2]=true;
        grid[row/2+2][col/2+3]=true;
        grid[row/2+2][col/2+4]=true;
        grid[row/2+3][col/2+1]=true;
        grid[row/2+3][col/2+2]=true;
        grid[row/2+3][col/2+4]=true;
        grid[row/2+4][col/2]=true;
        grid[row/2+4][col/2+2]=true;
        grid[row/2+4][col/2+4]=true;
    }
    
    
    
    
    
    
    /**
     * 
     * basic console text display of the engine
     */
    public void textDisplay() {
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == true) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }

            }
            System.out.println();
        }
        System.out.println();
    }
}
