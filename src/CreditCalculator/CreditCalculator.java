public class CreditCalculator {
    public static void main(String[] args) {
        String type = System.getProperty("type");
        String principalStr = System.getProperty("principal");
        String periodsStr = System.getProperty("periods");
        String interestStr = System.getProperty("interest");
        String paymentStr = System.getProperty("payment");

        try {
            if (type == null || (!type.equals("annuity") && !type.equals("diff"))) {
                throw new IllegalArgumentException("Incorrect parameters");
            }

            Double principal = principalStr != null ? Double.parseDouble(principalStr) : null;
            Integer periods = periodsStr != null ? Integer.parseInt(periodsStr) : null;
            Double interest = interestStr != null ? Double.parseDouble(interestStr) : null;
            Double payment = paymentStr != null ? Double.parseDouble(paymentStr) : null;

            if (interest == null || interest <= 0) {
                throw new IllegalArgumentException("Incorrect parameters");
            }

            double monthlyInterestRate = interest / 12 / 100;

            if (type.equals("diff")) {
                if (principal == null || periods == null || payment != null) {
                    throw new IllegalArgumentException("Incorrect parameters");
                }
                calculateDifferentiatedPayments(principal, periods, monthlyInterestRate);
            } else if (type.equals("annuity")) {
                if (principal == null && payment == null && periods == null) {
                    throw new IllegalArgumentException("Incorrect parameters");
                }
                if (principal == null) {
                    calculateLoanPrincipal(payment, periods, monthlyInterestRate);
                } else if (payment == null) {
                    calculateAnnuityPayment(principal, periods, monthlyInterestRate);
                } else if (periods == null) {
                    calculatePeriods(principal, payment, monthlyInterestRate);
                }
            } else {
                throw new IllegalArgumentException("Incorrect parameters");
            }
        } catch (Exception e) {
            System.out.println("Incorrect parameters");
        }
    }

    private static void calculateDifferentiatedPayments(double principal, int periods, double monthlyInterestRate) {
        double totalPayment = 0;
        for (int m = 1; m <= periods; m++) {
            double differentiatedPayment = (principal / periods) +
                    monthlyInterestRate * (principal - (principal * (m - 1) / periods));
            totalPayment += Math.ceil(differentiatedPayment);
            System.out.println("Month " + m + ": payment is " + (int) Math.ceil(differentiatedPayment));
        }
        System.out.println("Overpayment = " + (int) (totalPayment - principal));
    }

    private static void calculateAnnuityPayment(double principal, int periods, double monthlyInterestRate) {
        double annuityPayment = principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, periods) /
                (Math.pow(1 + monthlyInterestRate, periods) - 1);
        System.out.println("Your annuity payment = " + (int) Math.ceil(annuityPayment) + "!");
    }

    private static void calculateLoanPrincipal(double payment, int periods, double monthlyInterestRate) {
        double principal = payment / ((monthlyInterestRate * Math.pow(1 + monthlyInterestRate, periods)) /
                (Math.pow(1 + monthlyInterestRate, periods) - 1));
        System.out.println("Your loan principal = " + (int) Math.floor(principal) + "!");
    }

    private static void calculatePeriods(double principal, double payment, double monthlyInterestRate) {
        double periods = Math.log(payment / (payment - monthlyInterestRate * principal)) /
                Math.log(1 + monthlyInterestRate);
        int months = (int) Math.ceil(periods);
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
    }
}
