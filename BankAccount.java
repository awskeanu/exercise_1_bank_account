public class BankAccount {
  private double balance;
  private boolean isFrozen;

  public BankAccount() {
    this.balance = 0;
    this.isFrozen = false;
  }

  public void deposit(double amount) {
    if (isFrozen) {
      throw new IllegalStateException("Account is frozen. Cannot deposit.");
    }
    if (amount <= 0) {
      throw new IllegalArgumentException("Deposit amount must be positive.");
    }
    balance += amount;
  }

  public void withdraw(double amount) {
    if (isFrozen) {
      throw new IllegalStateException("Account is frozen. Cannot withdraw.");
    }
    if (amount <= 0) {
      throw new IllegalArgumentException("Withdrawal amount must be positive.");
    }
    if (amount > balance) {
      throw new IllegalArgumentException("Insufficient funds.");
    }
    balance -= amount;
  }

  public double getBalance() {
    return balance;
  }

  public void freezeAccount() {
    isFrozen = true;
  }

  public void unfreezeAccount() {
    isFrozen = false;
  }

  public boolean isFrozen() {
    return isFrozen;
  }
}