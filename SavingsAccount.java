/**
 * A bank account associated with a named owner.
 */
public class SavingsAccount extends BankAccount {
  private final String ownerName;

  /**
   * Creates an unfrozen savings account for the specified owner.
   *
   * @param ownerName name of the account owner
   */
  public SavingsAccount(String ownerName) {
    super();
    if (ownerName == null || ownerName.trim().isEmpty()) {
      throw new IllegalArgumentException("Owner name must not be blank.");
    }
    this.ownerName = ownerName;
  }

  /**
   * Returns the account owner's name.
   *
   * @return account owner's name
   */
  public String getOwnerName() {
    return ownerName;
  }
}
