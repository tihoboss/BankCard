public class StudentCard extends DebitCard {
    private static final double DISCOUNT = 0.25;
    private static final double DISCOUNT_THRESHOLD = 5000;

    public StudentCard() {
    }


    @Override
    public boolean pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            if (amount >= DISCOUNT_THRESHOLD) {
                double amountCash = amount * DISCOUNT;
                balance += amountCash;
                double discount_balance = amount - amountCash;
                System.out.println("Покупка с учетом скидки 25% " + discount_balance + "руб");
            } else {
                System.out.println("Покупка на " + amount + " руб\n");
            }
        } else {
            System.out.println("Операция не удалась. Недостаточно средств\n");
            return false;
        }
        return true;
    }

    @Override
    public void balance() {
        System.out.println("Информация о балансе: " + "\n"
                + "Баланс дебетовой карты: " + balance + "\n"
                + "Студенченская скидка: " + DISCOUNT * 100
                + " %" + "\n\n");
    }
}
