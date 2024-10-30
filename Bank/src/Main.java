import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankCard selectedCard = null;

        int cardChoice = 0;
        while (cardChoice < 1 || cardChoice > 3) {
            System.out.println("Выберите тип карты:");
            System.out.println("1. Студенческая дебетовая карта");
            System.out.println("2. Basic дебетовая карта");
            System.out.println("3. Кредитная карта накопления");
            System.out.print("Ваш выбор: ");
            cardChoice = scanner.nextInt();
        }

        switch (cardChoice) {
            case 1:
                selectedCard = new StudentCard();
                break;
            case 2:
                selectedCard = new BasicCard();
                break;
            case 3:
                selectedCard = new SavingsCard(5000, 5000);
                break;
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Пополнить");
            System.out.println("2. Оплатить");
            System.out.println("3. Посмотреть баланс");
            System.out.println("4. Посмотреть доступные средства");
            System.out.println("5. Выход");
            System.out.print("Ваш выбор: ");

            int operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    System.out.print("Введите сумму пополнения: ");
                    double depositAmount = scanner.nextDouble();
                    selectedCard.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Введите сумму оплаты: ");
                    double payAmount = scanner.nextDouble();
                    selectedCard.pay(payAmount);
                    break;
                case 3:
                    selectedCard.balance();
                    break;
                case 4:
                    selectedCard.availableMoney();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Некорректный выбор.");
            }
        }
        scanner.close();
    }
}
