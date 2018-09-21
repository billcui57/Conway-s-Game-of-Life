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
public class textBase {

    public static void main(String[] args) {
        int rows = 6;
        int cols = 10;
        boolean[][] grid = new boolean[rows][cols];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                grid[y][x] = false;
            }
        }
        Scanner input = new Scanner(System.in);
        grid[2][1] = true;
        grid[2][2] = true;
        grid[2][3] = true;
        while (true) {
            boolean[][] newGrid = grid;

            for (int y = 1; y < grid.length - 1; y++) {
                for (int x = 1; x < grid[0].length - 1; x++) {
                    int neighbours = 0;

                    //neighbour detection
                    if (grid[y + 1][x] == true) {
                        neighbours++;
                    }
                    if (grid[y - 1][x] == true) {
                        neighbours++;
                    }
                    if (grid[y][x + 1] == true) {
                        neighbours++;
                    }
                    if (grid[y][x - 1] == true) {
                        neighbours++;
                    }
                    if (grid[y + 1][x + 1] == true) {
                        neighbours++;
                    }
                    if (grid[y - 1][x - 1] == true) {
                        neighbours++;
                    }
                    if (grid[y + 1][x] == true) {
                        neighbours++;
                    }
                    if (grid[y - 1][x] == true) {
                        neighbours++;
                    }

                    if (grid[y][x] == true) {
                        if (neighbours < 2) {
                            newGrid[y][x] = false;
                        } else if (neighbours > 3) {
                            newGrid[y][x] = false;
                        } else if ((neighbours == 3) || (neighbours == 2)) {

                        }
                    } else {
                        if (neighbours == 3) {
                            newGrid[y][x] = true;
                        }
                    }

                }

            }

            grid = newGrid;
            draw(grid);
            input.nextLine();
        }

    }

    public static void draw(boolean[][] grid) {
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == true) {
                    System.out.print("|O|");
                } else {
                    System.out.print("|X|");
                }
            }
            System.out.println("\n");
        }
        System.out.println("\n\n\n");
    }
}
