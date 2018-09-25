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
public class textEngine {

    public static void main(String[] args) {
        boolean[][] grid = new boolean[10][20];
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                grid[y][x] = false;
            }
        }
        grid[2][2]=true;
        grid[3][2]=true;
        grid[4][2]=true;
        
        Scanner input = new Scanner(System.in);
        while (true) {
            boolean[][] newGrid = grid;
            for (int y = 0; y < grid.length; y++) {
                for (int x = 0; x < grid[0].length; x++) {
                    if (numNeighbours(grid, y, x) < 2) {
                        newGrid[y][x] = false;
                    } else if (numNeighbours(grid, y, x) > 3) {
                        newGrid[y][x] = false;
                    } else if ((numNeighbours(grid, y, x) == 3) && (grid[y][x] == false)) {
                        newGrid[y][x] = true;
                    }
                }
            }
            grid = newGrid;

            for (int y = 0; y < grid.length; y++) {
                for (int x = 0; x < grid[0].length; x++) {
                    if(grid[y][x]==true){
                       System.out.print(1);
                    }else{
                       System.out.print(0);
                    }
                    
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
            input.nextLine();
        }

    }

    public static int numNeighbours(boolean[][] grid, int row, int col) {
        int numNeighbour = 0;
        try {
            for (int y = -1; y < 2; y++) {
                for (int x = -1; x < 2; x++) {
                    if ((grid[row+y][col+x] == true) && (y != 0) && (x != 0)) {
                        numNeighbour++;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {

        }

        return numNeighbour;

    }
}
