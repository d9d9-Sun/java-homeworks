package homework36;

public class CashRegister {
    private String number;
    private int sumCash;
    private Client client;

    public CashRegister(String number, int sumCash) {
        this.number = number;
        this.sumCash = sumCash;
    }

    public String getNumber() {
        return number;
    }

    public int getSumCash() {
        return sumCash;
    }

    public void setSumCash(int sumCash) {
        this.sumCash = sumCash;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void selectionOperation() {
        switch (client.getOperationType()) {
            case GET_MONEY:
                getCash();
                break;

            case PUT_MONEY:
                putCash();
                break;

            case PAY_MONEY:
                payCash();
                break;

            case TRANSACTION_MONEY:
                transactionCash();
                break;

            case EXCHANGE_MONEY:
                exchangeCash();
                break;

            default: throw new IllegalArgumentException("Не верная операция!");
        }
    }

    public void getCash() {
        if (client.getCash() == null || client.getCash() < 0) {
            throw new IllegalArgumentException("Не верна введена сумма");
        }

        double resultSum = client.getSum() - client.getCash();
        if (resultSum < 0) {
            throw new IllegalArgumentException("Недостаточно денег для операции");
        } else {
            System.out.println("Клиент " + client.getName() + " снял(а)" +
                    " " + client.getCash() + "$. " + number + ": " + Thread.currentThread().getName());
            setSumCash(getSumCash() + client.getCash());
            client.setSum(resultSum);
        }
    }

    public void putCash() {
        if (client.getCash() == null || client.getCash() < 0) {
            throw new IllegalArgumentException("Не верна введена сумма");
        }

        double resultSum = client.getSum() + client.getCash();
        System.out.println("Клиент " + client.getName() + " пополнил(а) на " + client.getCash() + "$. "
                + number + ": " + Thread.currentThread().getName());
        setSumCash(getSumCash() + client.getCash());
        client.setSum(resultSum);

    }

    public void payCash() {
        if (client.getCash() == null || client.getCash() < 0) {
            throw new IllegalArgumentException("Не верна введена сумма");
        }

        double resultSum = client.getSum() - client.getCash();
        if (resultSum < 0) {
            throw new IllegalArgumentException("Недостаточно денег для операции");
        } else {
            System.out.println("Клиент " + client.getName() + " оплатил(а) услугу №" +
                    ((int) (Math.random() * 99)) + " на " + client.getCash() + "$. " + number + ": " + Thread.currentThread().getName());
            setSumCash(getSumCash() + client.getCash());
            client.setSum(resultSum);
        }
    }

    public void transactionCash() {
        if (client.getCash() == null || client.getCash() < 0) {
            throw new IllegalArgumentException("Не верна введена сумма");
        }

        double resultSum = client.getSum() - client.getCash();
        if (resultSum < 0) {
            throw new IllegalArgumentException("Недостаточно денег для операции");
        } else {
            System.out.println("Клиент " + client.getName() + " перевел(а) на счет №" +
                    ((int) (Math.random() * 99)) + " - " + client.getCash() + "$. " +
                    number + ": " + Thread.currentThread().getName());
            setSumCash(getSumCash() + client.getCash());
            client.setSum(resultSum);
        }
    }

    public void exchangeCash() {
        double course = 2.6;
        if (client.getCash() == null || client.getCash() < 0) {
            throw new IllegalArgumentException("Не верна введена сумма");
        }

        double resultSum = client.getSum() - client.getCash() * course;
        if (resultSum < 0) {
            throw new IllegalArgumentException("Недостаточно денег для операции");
        } else {
            System.out.println("Клиент " + client.getName() + " обменял(а) в BYN " + client.getCash() + "$. " +
                    number  + ": " + Thread.currentThread().getName());
            setSumCash(getSumCash() + client.getCash());
            client.setSum(resultSum);
        }
    }
}