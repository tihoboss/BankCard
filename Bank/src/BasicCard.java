public class BasicCard extends DebitCard {
    private double bonusPoint;
    private static final double BONUS_THRESHOLD = 100;
    private static final double DISCOUNT = 0.1;

    public BasicCard() {
        this.bonusPoint = 0;
    }

    @Override
    public boolean pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            bonusPoint += amount * 0.01;
            if (bonusPoint >= BONUS_THRESHOLD) {
                System.out.println("Вы набрали 100 бонусных баллов! У вас скидка 10%!");
                bonusPoint = 0;
                double discount = 0.0;
                discount += amount * DISCOUNT;
                balance += discount;
                double disBalance = amount - discount;
                System.out.println("Покупка на " + disBalance + "руб");
            } else {
                System.out.println("Покупка на " + amount + "руб");
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
                + "Накопленные бонусы: " + bonusPoint + "\n\n");
    }

    @Override
    public void availableMoney() {
        super.availableMoney();
        if (bonusPoint > 0) {
            System.out.println("Доступные бонусы: " + bonusPoint);
        }
    }
}
