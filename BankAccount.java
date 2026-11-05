public class BankAccount {
    private String accountNumber;
    private String owner;
    private double balance;

    public BankAccount(String accountNumber, String owner, double balance) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер счёта не может быть пустым.");
        }
        if (owner == null || owner.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя владельца не может быть пустым.");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным.");
        }
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма пополнения должна быть больше нуля.");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма снятия должна быть больше нуля.");
        }
        if (amount > this.balance) {
            throw new InsufficientFundsException("Недостаточно средств на счёте.");
        }
        this.balance -= amount;
    }
}
