public class SavingsCard extends CreditCard {
    private double saving;

    public SavingsCard(int creditLimit, double creditBalance) {
        super(creditLimit, creditBalance);
    }

    @Override
    public void deposit(double amount) {
        if (creditBalance < creditLimit) {
            double availableCreditBalance = creditLimit - creditBalance;
            double minAmount = Math.min(amount, availableCreditBalance);
            double availableBalance = amount - availableCreditBalance;
            creditBalance += minAmount;
            balance += availableBalance;
        } else {
            balance += amount;
        }
        double savingPoints = amount * 0.00005;
        saving += savingPoints;
        balance += savingPoints;
        System.out.println("Начисление " + amount + " руб\n"
                + "Накопленно: " + savingPoints + " руб\n");
    }

    @Override
    public void balance() {
        System.out.println("Информация о балансе: " + "\n"
                + "Кредитный лимит: " + creditLimit + "\n"
                + "Собственные средства: " + balance + "\n"
                + "Кредитные средства: " + creditBalance + "\n"
                + "Накопления: " + saving + "\n\n");
    }
}
