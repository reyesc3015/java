//Caster Troy R.

//M4HW2

//3/7/2024

// This program helps a salesperson know how much cash they're making. They type in their name, how many widgets they sold, and how many they returned. The program then calculates the numbers to show the salesperson how many widgets they really sold, the money they made, commission, and their total monthly salary. It's like a calculator for sales staff

import java.util.Scanner;

public class WidgetSalesProgram {
    private static final double BASE_SALARY = 2000;
    private static final double WIDGET_PRICE = 4.79;
    private static final double[] COMMISSION_RATES = {0.1, 0.15, 0.2, 0.25};
    private static final int[] COMMISSION_THRESHOLDS = {100, 200, 300};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Troy Reyes: ");
        String name = scanner.nextLine();

        System.out.print("Enter widgets sold: ");
        int widgetsSold = scanner.nextInt();

        System.out.print("Enter widgets returned: ");
        int widgetsReturned = scanner.nextInt();

        int netWidgetsSold = widgetsSold - widgetsReturned;
        double widgetSalesAmount = netWidgetsSold * WIDGET_PRICE;
        double commissionRate = getCommissionRate(netWidgetsSold);
        double commissionAmount = commissionRate * widgetSalesAmount;
        double monthlySalary = BASE_SALARY + commissionAmount;

        System.out.println("\nSalesperson: " + name);
        System.out.println("Net widgets sold: " + netWidgetsSold);
        System.out.println("Widget sales amount: $" + String.format("%.2f", widgetSalesAmount));
        System.out.println("Commission amount: $" + String.format("%.2f", commissionAmount));
        System.out.println("Monthly salary: $" + String.format("%.2f", monthlySalary));

        scanner.close();
    }

    private static double getCommissionRate(int netWidgetsSold) {
        for (int i = 0; i < COMMISSION_THRESHOLDS.length; i++) {
            if (netWidgetsSold <= COMMISSION_THRESHOLDS[i]) {
                return COMMISSION_RATES[i];
            }
        }
        return COMMISSION_RATES[COMMISSION_RATES.length - 1];
    }
}
