package ilya.responsabilitychainlaba.Realization;

public final class Player {
    private final String name;
    private int balance; // сколько монет на счету
    private int plays; // сколько раз сыграл

    public Player(final String name, final int balance) {
        this.name = name;
        this.balance = balance;
        this.plays = 0;
    }

    public boolean pay(final int amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            ++this.plays;
            return true;
        }

        return false;
    }

    public void addNumber(final int amount) {
        this.balance += amount;
    }

    public int getBalance() {
        return this.balance;
    }

    public int getPlays() {
        return this.plays;
    }

    public String getName() {
        return this.name;
    }
}
