package greektrust;

public class MetroCard {
    private final String passengerType;
    private int balance;

    public MetroCard(String passengerType, int balance) {
        this.passengerType = passengerType;
        this.balance = balance;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public int getBalance() {
        return balance;
    }

    public void recharge(int amount) {
        balance += amount;
    }

    public void deduct(int amount) {
        balance -= amount;
    }
}
