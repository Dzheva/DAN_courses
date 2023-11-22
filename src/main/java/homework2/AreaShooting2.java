package homework2;

import java.util.Random;
import java.util.Scanner;

public class AreaShooting2 {
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

    static void placeTarget(int[][] target, int[][] gameBoard) {
        Random random = new Random();

        // Визначаємо напрям цілі (горизонтальний чи вертикальний)
        boolean isHorizontal = random.nextBoolean();

        // Визначаємо початкові координати цілі
        int targetRow, targetCol;

        do {
            if (isHorizontal) {
                targetRow = random.nextInt(gameBoard.length);
                targetCol = random.nextInt(gameBoard[0].length - 2); // враховуємо розмір цілі
            } else {
                targetRow = random.nextInt(gameBoard.length - 2); // враховуємо розмір цілі
                targetCol = random.nextInt(gameBoard[0].length);
            }
        } while (isInvalidTargetLocation(targetRow, targetCol, isHorizontal, gameBoard));

        // Заповнюємо масив target координатами цілі
        for (int i = 0; i < 3; i++) {
            if (isHorizontal) {
                target[i][0] = targetRow;
                target[i][1] = targetCol + i;
            } else {
                target[i][0] = targetRow + i;
                target[i][1] = targetCol;
            }
        }
    }

    static boolean isInvalidTargetLocation(int targetRow, int targetCol, boolean isHorizontal, int[][] gameBoard) {
        // Перевірка, щоб ціль не виходила за межі поля
        for (int i = 0; i < 3; i++) {
            if (isHorizontal) {
                if (targetCol + i >= gameBoard[0].length || gameBoard[targetRow][targetCol + i] != 0) {
                    return true;
                }
            } else {
                if (targetRow + i >= gameBoard.length || gameBoard[targetRow + i][targetCol] != 0) {
                    return true;
                }
            }
        }
        return false;
    }


    static int[][] getShotFromPlayer(Scanner scanner, int[][] gameBoard) {
        int[][] shot = new int[1][2];
        do {
            System.out.print("Enter the row (1-5): ");
            shot[0][0] = getUserInput(scanner) - 1;
            System.out.print("Enter the column (1-5): ");
            shot[0][1] = getUserInput(scanner) - 1;
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

    static boolean isValidShot(int[][] shot, int[][] gameBoard) {
        int row = shot[0][0];
        int col = shot[0][1];

        if (row < 0 || row >= gameBoard.length || col < 0 || col >= gameBoard[0].length) {
            System.out.println("Invalid input. Row and column must be between 1 and 5.");
            return false;
        } else if (gameBoard[row][col] == -1) {
            System.out.println("You've already shot there! Try again.");
            return false;
        }

        return true;
    }

    static boolean isHit(int[][] target, int[][] shot) {
        int shotRow = shot[0][0];
        int shotCol = shot[0][1];

        int targetRow1 = target[0][0];
        int targetCol1 = target[0][1];

        int targetRow2 = target[1][0];
        int targetCol2 = target[1][1];

        int targetRow3 = target[2][0];
        int targetCol3 = target[2][1];

        if ((shotRow == targetRow1 && shotCol == targetCol1)
                || (shotRow == targetRow2 && shotCol == targetCol3)
                || (shotRow == targetRow3 && shotCol == targetCol3)
        ) return true;

        return false;
    }

    public static void run() {
        int[][] gameBoard = new int[5][5];
        initializeGameBoard(gameBoard);
        printGameBoard(gameBoard);

        int[][] target = new int[3][2];
        placeTarget(target, gameBoard);

        Scanner scanner = new Scanner(System.in);
        System.out.println("All Set. Get ready to rumble!");

        int hits = 0;

        while (true) {
            int[][] shot = getShotFromPlayer(scanner, gameBoard);
            gameBoard[shot[0][0]][shot[0][1]] = -1; // Позначаємо постріл
            printGameBoard(gameBoard);

            if (isHit(target, shot)) {
                gameBoard[shot[0][0]][shot[0][1]] = 1; //Позначаємо влучання в ціль
                hits++;
                printGameBoard(gameBoard);
                System.out.println("You have shot!");
            }

            if (hits == 3) {
                printGameBoard(gameBoard);
                System.out.println("You have won!");
                break;
            }

        }
    }

    public static void main(String[] args) {
        AreaShooting2.run();
    }

}

