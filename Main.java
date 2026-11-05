import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("ACC001", "Xan", 50000);
        BankAccount account2 = new BankAccount("ACC002", "Danara", 10000);
        TransferService transferService = new TransferService();

        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Начальное состояние счетов ---");
        printBalances(account1, account2);

        System.out.print("\nВведите сумму перевода: ");
        String input = scanner.nextLine();

        try {
            double amount = Double.parseDouble(input);
            transferService.transfer(account1, account2, amount);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода числа: введено некорректное числовое значение.");
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректная сумма / данные: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Ошибка перевода: " + e.getMessage());
        } finally {
            System.out.println("Операция перевода завершена.");
        }

        System.out.println("\n--- Итоговое состояние счетов ---");
        printBalances(account1, account2);

        scanner.close();
    }

    private static void printBalances(BankAccount acc1, BankAccount acc2) {
        System.out.println(acc1.getOwner() + " (" + acc1.getAccountNumber() + "): " + acc1.getBalance());
        System.out.println(acc2.getOwner() + " (" + acc2.getAccountNumber() + "): " + acc2.getBalance());
    }
}
