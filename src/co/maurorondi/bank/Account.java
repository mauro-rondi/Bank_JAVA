package co.maurorondi.bank;

public class Account {
    private static final int MAX_LENGTH = 12; // constante
    private String ag;
    private String cc;
    private String name;
    private double balance;
    private Log logger;

    // CONSTRUTOR
    public Account(String ag, String cc, String name){
        this.ag = ag;
        this.cc = cc;
        setName(name);
        logger = new Log();
    }

    // SETTERS
    public void setName(String name){
        if(name.length() > MAX_LENGTH){
            this.name = name.substring(0,MAX_LENGTH);
        }
        else{
            this.name = name;
        }

    }

    // DEPÓSITO
    public void deposit(double value){
        balance += value;
        logger.out("DEPOSITO: R$" + value);
        logger.out("Saldo Atual: R$" + balance);
    }

    // SAQUE
    public boolean withDraw(double value){
        if(balance < value){
            logger.out("Saldo atual: R$" + balance);
            return false;
        }
        balance -= value;
        logger.out("SAQUE: R$" + value);
        logger.out("Saldo Atual: R$" + balance);
        return true;
    }

    // GETTERS
    // RETORNA O VALOR NO BANCO
    public double getBalance(){
        return balance;
    }

    @Override
    public String toString() {
        String result = "A conta " + this.name + " " + this.ag + "/" + this.cc + " possui: R$" + balance;
        return result;
    }
}
