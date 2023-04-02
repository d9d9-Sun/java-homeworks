package by.mad;

public class Factory {
    private Sweet sweet;
    private int count;
    private String factoryName;
    private String factoryOwner;

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public Factory(Sweet sweet, int count) {
        this.sweet = sweet;
        this.count = count;
    }

    public void start() {
        System.out.println("Фабрика - " + factoryName + "\n владелец - " + factoryOwner);
        for (int i = 0; i < count; i++) {
            sweet.run();
        }
    }
}
