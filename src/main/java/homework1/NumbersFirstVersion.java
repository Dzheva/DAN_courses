package homework1;

import java.util.Random;
import java.util.Scanner;

public class NumbersFirstVersion {
    // Метод для отримання введеного числа
    static int getUserGuess(Scanner scanner) {
        while (true) {
            System.out.print("Input the number, from 0 to 100: ");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    // Метод для перевірки введеного числа
    static boolean checkGuess(int secretNumber, int guessedNumber, String playerName) {
        if (secretNumber > guessedNumber) {
            System.out.println("Your number is too small. Please, try again.");
        } else if (secretNumber < guessedNumber) {
            System.out.println("Your number is too big. Please, try again.");
        } else {
            System.out.println("You are right! Congratulations, " + playerName + " !");
            return true;
        }
        return false;
    }

    //Метод сортування масиву із введеними значеннями
    static void bubbleSortGuess(int[] arr, int attempts) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < attempts - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Метод для виведення всіх введених чисел
    static void printGuesses(int[] guesses, int attempts) {
        bubbleSortGuess(guesses, attempts);
        System.out.print("Your guesses: ");
        for (int i = 0; i < attempts; i++) {
            System.out.print(guesses[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] guesses = new int[100];
        int attempts = 0;

        Random random = new Random();
        int x = random.nextInt(101);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        while (true) {
            int y = getUserGuess(scanner);
            guesses[attempts] = y;
            attempts++;

            if (checkGuess(x, y, name)) {
                break;
            }
        }

        printGuesses(guesses, attempts);
    }

}
