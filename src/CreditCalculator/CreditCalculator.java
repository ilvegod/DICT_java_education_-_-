import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to calculate?");
        System.out.println("type \"n\" for number of monthly payments,");
        System.out.println("type \"a\" for annuity monthly payment amount,");
        System.out.println("type \"p\" for loan principal:");
        char choice = scanner.next().charAt(0);

        if (choice == 'n') {
            System.out.println("Enter the loan principal:");
            double principal = scanner.nextDouble();

            System.out.println("Enter the monthly payment:");
            double monthlyPayment = scanner.nextDouble();

            System.out.println("Enter the loan interest:");
            double annualInterest = scanner.nextDouble();
            double monthlyInterest = annualInterest / 12 / 100;

            double numOfPayments = Math.log(monthlyPayment / (monthlyPayment - monthlyInterest * principal))
                    / Math.log(1 + monthlyInterest);

            int months = (int) Math.ceil(numOfPayments);
            int years = months / 12;
            months = months % 12;

            if (years > 0) {
                System.out.print("It will take " + years + " year" + (years > 1 ? "s" : ""));
                if (months > 0) {
                    System.out.print(" and " + months + " month" + (months > 1 ? "s" : ""));
                }
                System.out.println(" to repay this loan!");
            } else {
                System.out.println("It will take " + months + " month" + (months > 1 ? "s" : "") + " to repay this loan!");
            }

        } else if (choice == 'a') {
            System.out.println("Enter the loan principal:");
            double principal = scanner.nextDouble();

            System.out.println("Enter the number of periods:");
            int periods = scanner.nextInt();

            System.out.println("Enter the loan interest:");
            double annualInterest = scanner.nextDouble();
            double monthlyInterest = annualInterest / 12 / 100;

            double annuityPayment = principal * monthlyInterest * Math.pow(1 + monthlyInterest, periods)
                    / (Math.pow(1 + monthlyInterest, periods) - 1);

            System.out.println("Your monthly payment = " + (int) Math.ceil(annuityPayment) + "!");

        } else if (choice == 'p') {
            System.out.println("Enter the annuity payment:");
            double annuityPayment = scanner.nextDouble();

            System.out.println("Enter the number of periods:");
            int periods = scanner.nextInt();

            System.out.println("Enter the loan interest:");
            double annualInterest = scanner.nextDouble();
            double monthlyInterest = annualInterest / 12 / 100;

            double principal = annuityPayment
                    / (monthlyInterest * Math.pow(1 + monthlyInterest, periods)
                    / (Math.pow(1 + monthlyInterest, periods) - 1));

            System.out.println("Your loan principal = " + (int) principal + "!");
        }
    }
}
