/*1. Initialize two ArrayLists: one for days, one for temperatures

2. Repeat 7 times:
    a. Prompt user for a day of the week (e.g., Monday)
    b. Prompt user for the average temperature for that day
    c. Add the day and temperature to their respective ArrayLists

3. Set loop flag to true

4. While loop flag is true:
    a. Prompt user to enter:
        - A day name to display its temperature
        - "week" to display all days and calculate weekly average
        - "exit" to quit the program
    b. If input is "exit":
        - Display goodbye message
        - Set loop flag to false
    c. Else if input is "week":
        - For each item in the ArrayLists:
            i. Display day and temperature
            ii. Add temperature to a running total
        - Calculate and display weekly average temperature
    d. Else if input matches a day in the list:
        - Find the index of the day in the ArrayList
        - Display the temperature for that day
    e. Else:
        - Display "Invalid input. Please try again." */

import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperatures {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temps = new ArrayList<>();

        // Collect input for 7 days
        for (int i = 0; i < 7; i++) {
            System.out.print("Enter day of the week (e.g., Monday): ");
            String day = input.nextLine();
            System.out.print("Enter average temperature for " + day + ": ");
            double temp = input.nextDouble();
            input.nextLine(); // consume leftover newline

            days.add(day);
            temps.add(temp);
        }

        // Loop for user queries
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.print("Type a day (e.g., Monday), 'week' to display all temperatures and average, or 'exit' to quit: ");
            String response = input.nextLine();

            if (response.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                continueLoop = false;

            } else if (response.equalsIgnoreCase("week")) {
                double total = 0;
                for (int i = 0; i < days.size(); i++) {
                    System.out.println(days.get(i) + ": " + temps.get(i) + "°F");
                    total += temps.get(i);
                }
                double average = total / temps.size();
                System.out.println("Weekly average temperature: " + average + "°F");

            } else if (days.contains(response)) {
                int index = days.indexOf(response);
                System.out.println(response + ": " + temps.get(index) + "°F");

            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        input.close();
    }
}
