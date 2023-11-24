package homework3;

import java.util.Scanner;

public class TaskPlanner {
    static void initializeSchedule(String[][] schedule) {
        schedule[0][0] = "Sunday";
        schedule[0][1] = "do nothing";

        schedule[1][0] = "Monday";
        schedule[1][1] = "do work";

        schedule[2][0] = "Tuesday";
        schedule[2][1] = "go to courses";

        schedule[3][0] = "Wednesday";
        schedule[3][1] = "watch a film";

        schedule[4][0] = "Thursday";
        schedule[4][1] = "go to the gym";

        schedule[5][0] = "Friday";
        schedule[5][1] = "meet friends";

        schedule[6][0] = "Saturday";
        schedule[6][1] = "tidy up at home";
    }

    private static int getDayIndex(String day) {
        switch (day) {
            case "sunday":
                return 0;
            case "monday":
                return 1;
            case "tuesday":
                return 2;
            case "wednesday":
                return 3;
            case "thursday":
                return 4;
            case "friday":
                return 5;
            case "saturday":
                return 6;
            default:
                throw new IllegalArgumentException("Invalid day: " + day);
        }
    }

    static void displayTasks(String[][] schedule, String input) {
        switch (input) {
            case "sunday":
            case "monday":
            case "tuesday":
            case "wednesday":
            case "thursday":
            case "friday":
            case "saturday":
                int dayIndex = getDayIndex(input);
                System.out.println("Your tasks for " + schedule[dayIndex][0] + ": " + schedule[dayIndex][1] + ".");
                break;
            default:
                System.out.println("Sorry, I don't understand you, please try again.");
        }
    }

    static boolean shouldExit(String input) {
        if (input.equals("exit")) {
            System.out.println("Goodbye!");
            return true;
        }
        return false;
    }

    static boolean isValidDay(String dayOfWeek) {
        return dayOfWeek.equals("monday") || dayOfWeek.equals("tuesday") || dayOfWeek.equals("wednesday") || dayOfWeek.equals("thursday") || dayOfWeek.equals("friday") || dayOfWeek.equals("saturday") || dayOfWeek.equals("sunday");
    }

    static void updateTasks(String[][] schedule, String dayOfWeek, String newTasks) {
        int dayIndex = getDayIndex(dayOfWeek);
        schedule[dayIndex][1] = newTasks;
    }

    static boolean isChangeOrReschedule(String input) {
        return input.startsWith("change") || input.startsWith("reschedule");
    }

    static void handleChangeOrReschedule(Scanner scanner, String[][] schedule, String input) {
        String[] parts = input.split(" ");
        if (parts.length == 2 && isValidDay(parts[1])) {
            System.out.print("Please, input the new tasks for " + parts[1] + ": ");
            String newTasks = scanner.nextLine();
            updateTasks(schedule, parts[1], newTasks);
            System.out.println("Tasks for " + parts[1] + " updated successfully!");
        } else {
            System.out.println("Invalid input. Please try again.");
        }
    }

    static void run(Scanner scanner, String[][] schedule) {
        while (true) {
            System.out.print("Please, input the day of the week or type 'exit' to quit: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (shouldExit(input)) {
                break;
            }

            if (isChangeOrReschedule(input)) {
                handleChangeOrReschedule(scanner, schedule, input);
            } else {
                displayTasks(schedule, input);
            }
        }
    }

    public static void main(String[] args) {
        String[][] schedule = new String[7][2];
        initializeSchedule(schedule);
        Scanner scanner = new Scanner(System.in);
        run(scanner, schedule);
        scanner.close();
    }
}
