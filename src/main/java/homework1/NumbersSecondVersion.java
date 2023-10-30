package homework1;

import java.util.Random;
import java.util.Scanner;

public class NumbersSecondVersion {
    static int getUserGuess(Scanner scanner) {
        while (true) {
            System.out.print("Input the year: ");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid year.");
            }
        }
    }

    static boolean checkGuess(int secretYear, int guessedYear, String playerName) {
        if (secretYear > guessedYear) {
            System.out.println("The event happened after the guessed year. Please, try again.");
        } else if (secretYear < guessedYear) {
            System.out.println("The event happened before the guessed year. Please, try again.");
        } else {
            System.out.println("You are right! Congratulations, " + playerName + "!");
            return true;
        }
        return false;
    }

    //Тут трохи інакше описав сортування, просто грався для себе
    static void bubbleSortGuesses(int[] arr, int attempts) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < attempts - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    static void printGuesses(int[] guesses, int attempts) {
        bubbleSortGuesses(guesses, attempts);
        System.out.print("Your guesses: ");
        for (int i = 0; i < attempts; i++) {
            System.out.print(guesses[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] guesses = new int[100];
        int attempts = 0;

        String[][] historicalEvents = {
                {"First successful airplane flight by the Wright brothers", "1903"},
                {"End of World War I", "1918"},
                {"World War II began", "1939"},
                {"First human on the Moon", "1969"},
                {"Chernobyl disaster", "1986"},
                {"Berlin Wall fell", "1989"},
                {"Orange Revolution in Ukraine", "2004"}
        };

        Random random = new Random();
        int randomIndex = random.nextInt(historicalEvents.length);
        String[] selectedEvent = historicalEvents[randomIndex];
        String event = selectedEvent[0];
        int year = Integer.parseInt(selectedEvent[1]);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("When did " + event + "?" + " Input year, only integer numbers.");

        while (true) {
            int y = getUserGuess(scanner);
            guesses[attempts] = y;
            attempts++;

            if (checkGuess(year, y, name)) {
                break;
            }
        }

        printGuesses(guesses, attempts);
    }

}
