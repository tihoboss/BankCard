public abstract class BankCard {
    protected double balance;
    protected double creditBalance;
    protected int creditLimit;

    public BankCard(int creditLimit, double creditBalance) {
        this.creditLimit = creditLimit;
        this.creditBalance = creditBalance;
        this.balance = 0;
    }

    public void balance() {
        System.out.println("Информация о балансе: " + "\n"
                + "Баланс карты: " + balance + "\n\n");
    }

    public void deposit(double amount) {
        System.out.println("Начисление " + amount + " руб\n");
        balance += amount;
    }

    public abstract boolean pay(double amount);

    public abstract void availableMoney();
}
