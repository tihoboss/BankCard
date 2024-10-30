public abstract class CreditCard extends BankCard {
    public CreditCard(int creditLimit, double creditBalance) {
        super(creditLimit, creditBalance);
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Начисление " + amount + " руб\n");
        if (creditBalance < creditLimit) {
            double availableCreditBalance = creditLimit - creditBalance;
            double minAmount = Math.min(amount, availableCreditBalance);
            double availableBalance = amount - availableCreditBalance;
            creditBalance += minAmount;
            balance += availableBalance;
        } else {
            balance += amount;
        }
    }

    @Override
    public boolean pay(double amount) {
        if (balance < amount) {
            double availableBalance = amount - balance;
            balance -= balance;
            if (creditBalance >= availableBalance) {
                creditBalance -= availableBalance;
                System.out.println("Списано " + amount + " руб\n");
            } else {
                System.out.println("Операция не удалась. Недостаточно средств\n");
            }
        } else if (balance >= amount) {
            balance -= amount;
            System.out.println("Списано " + amount + " руб\n");
        }
        return true;
    }

    @Override
    public void balance() {
        System.out.println("Информация о балансе: " + "\n"
                + "Кредитный лимит: " + creditLimit + "\n"
                + "Собственные средства: " + balance + "\n"
                + "Кредитные средства: " + creditBalance + "\n\n");
    }

    @Override
    public void availableMoney() {
        if (balance > 0) {
            System.out.println("Доступные собственные средства: " + balance);
        }
        if (creditBalance > 0) {
            System.out.println("Доступные кредитные средства: " + creditBalance);
        } else {
            System.out.println("Нет доступных средств");
        }
    }
}
