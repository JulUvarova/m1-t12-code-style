import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
            return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void menu() {
        int period;
        int startAmount;
        int command;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        startAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        command = scanner.nextInt();
        double endAmount = 0;
        if (command == 1) {
            endAmount = calculateSimplePercent(startAmount, 0.06, period);
        } else if (command == 2) {
            endAmount = calculateComplexPercent(startAmount, 0.06, period);
        }
        System.out.println("Результат вклада: " + startAmount + " за " + period + " лет превратятся в " + endAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().menu();
    }
}
