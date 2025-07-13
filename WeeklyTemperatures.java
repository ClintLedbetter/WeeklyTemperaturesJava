
import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperatures {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temps = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            System.out.print("Enter day of week (e.g., Monday): ");
            String day = input.nextLine();
            System.out.print("Enter average temperature for " + day + ": ");
            double temp = input.nextDouble();
            input.nextLine(); // consume newline

            days.add(day);
            temps.add(temp);
        }

        System.out.print("Type a day (e.g., Monday) or 'week' to display all temperatures and average: ");
        String response = input.nextLine();

        if (response.equalsIgnoreCase("week")) {
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
            System.out.println("Invalid input. Please restart the program.");
        }
    }
}
