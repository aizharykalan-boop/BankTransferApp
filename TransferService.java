public class TransferService {
    public void transfer(BankAccount from, BankAccount to, double amount) throws InsufficientFundsException {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Счета отправителя и получателя должны существовать.");
        }
        if (from.getAccountNumber().equalsIgnoreCase(to.getAccountNumber())) {
            throw new IllegalArgumentException("Отправитель и получатель должны быть разными счетами.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма перевода должна быть положительной.");
        }

        // Списание средств (может выбросить InsufficientFundsException)
        from.withdraw(amount);
        // Зачисление средств
        to.deposit(amount);

        System.out.println("Успешный перевод " + amount + " тг. от " + from.getOwner() + " к " + to.getOwner());
    }
}
