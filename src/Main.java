class BunkAccount{
    private String id;
    private double balance;

    public BunkAccount(String id, double balance) {
        this.id = id;
        this.balance = balance;
        if (balance<0){
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
        }
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount){
        balance+=amount;
        if(amount<=0){
            throw new IllegalArgumentException("Сумма депозита должна быть больше 0");
        }
        return amount;
    }

    public void withdraw(double amount){
        balance-=amount;
        if(amount>balance){
            throw new IllegalArgumentException("Недостаточно средств");
        }
        if(amount<=0){
            throw new IllegalArgumentException("Сумма вывода должна быть больше 0");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        BunkAccount bunkAccount = new BunkAccount("1",1111);

        }
    }
