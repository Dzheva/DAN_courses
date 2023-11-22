package homework2;

import java.util.Random;
import java.util.Scanner;

public class AreaShooting {
    static void initializeGameBoard(int[][] gameBoard) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                gameBoard[row][col] = 0; // Заповнюємо ігрове поле
            }
        }
    }

    static void printGameBoard(int[][] gameBoard) {
        System.out.println("0 | 1 | 2 | 3 | 4 | 5 |");
        for (int row = 0; row < 5; row++) {
            System.out.print((row + 1) + " | ");
            for (int col = 0; col < 5; col++) {
                if (gameBoard[row][col] == -1) {
                    System.out.print("* | "); // Позначаємо постріл
                } else if (gameBoard[row][col] == 1) {
                    System.out.print("x | "); // Позначаємо попадання
                } else {
                    System.out.print("- | ");
                }
            }
            System.out.println();
        }
    }


    static int placeTarget() {
        Random random = new Random();
        return random.nextInt(5); // Повертаємо випадковий рядок для цілі
    }

    static int[] getShotFromPlayer(Scanner scanner, int[][] gameBoard) {
        int[] shot = new int[2];
        do {
            System.out.print("Enter the row (1-5): ");
            shot[0] = getUserInput(scanner) - 1; //shotRow
            System.out.print("Enter the column (1-5): ");
            shot[1] = getUserInput(scanner) - 1; //shotColumn
        } while (!isValidShot(shot, gameBoard));

        return shot;
    }

    static int getUserInput(Scanner scanner) {
        while (true) {
            System.out.print("Input the number, from 1 to 5: ");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }


    static boolean isValidShot(int[] shot, int[][] gameBoard) {
        if (shot[0] < 0 || shot[0] > 4 || shot[1] < 0 || shot[1] > 4) {
            System.out.println("Invalid input. Row and column must be between 1 and 5.");
            return false;
        } else if (gameBoard[shot[0]][shot[1]] == -1) {
            System.out.println("You've already shot there! Try again.");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] gameBoard = new int[5][5];
        initializeGameBoard(gameBoard); // Ініціалізуємо ігрове поле
        int targetRow = placeTarget(); // Розташовуємо ціль
        int targetCol = placeTarget(); // Розташовуємо ціль

        Scanner scanner = new Scanner(System.in);
        System.out.println("All Set. Get ready to rumble!");

        while (true) {
            printGameBoard(gameBoard);
            int[] shot = getShotFromPlayer(scanner, gameBoard);
            gameBoard[shot[0]][shot[1]] = -1; // Позначаємо постріл

            if (shot[0] == targetRow && shot[1] == targetCol) {
                gameBoard[shot[0]][shot[1]] = 1; //Позначаємо попадання в ціль
                printGameBoard(gameBoard);
                System.out.println("You have won!");
                break;
            }
        }
    }
}

