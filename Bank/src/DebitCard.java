public abstract class DebitCard extends BankCard {

    public DebitCard() {
        super(0, 0);
    }

    @Override
    public boolean pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Покупка на " + amount + " руб\n");
        } else {
            System.out.println("Операция не удалась. Недостаточно средств\n");
            return false;
        }
        return true;
    }

    @Override
    public void availableMoney() {
        if (balance > 0) {
            System.out.println("Доступные средства: " + balance);
        } else {
            System.out.println("Нет доступных средств");
        }
    }
}
