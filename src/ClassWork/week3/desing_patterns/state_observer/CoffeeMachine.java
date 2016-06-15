package ClassWork.week3.desing_patterns.state_observer;

/**
 * Created by gorobec on 05.06.16.
 */
public class CoffeeMachine implements State, MyObserver{

    private State noMoney;
    private State makeChoice;
    private State outOfOrder;
    private State inProcess;


    private State currentState;

    private int coffeePrice;
    private int teaPrice;

    public void setCoffeePrice(int coffeePrice) {
        this.coffeePrice = coffeePrice;
    }

    public int getTeaPrice() {
        return teaPrice;
    }

    public void setTeaPrice(int teaPrice) {
        this.teaPrice = teaPrice;
    }

    public CoffeeMachine(){
        this.noMoney = new NoMoneyState(this);
        this.makeChoice = new MakeChoiseState(this);
        this.outOfOrder = new OutOfOrderState(this);
        this.inProcess = new InProcessState(this);

        currentState = noMoney;


    }

    @Override
    public void moneyIn() {
        currentState.moneyIn();
    }

    @Override
    public void makeChoice() {
        currentState.makeChoice();
    }

    @Override
    public void makeDrink() {
        currentState.makeDrink();

    }

    @Override
    public void cancel() {
        currentState.makeChoice();
    }

    @Override
    public void giveMoney() {
        currentState.giveMoney();
    }


    public State getCurrentState(){
        return currentState;
    }

    public void setCurrentState(State state){
        this.currentState = state;
    }


    public State getNoMoney() {
        return noMoney;
    }

    public State getMakeChoice() {
        return makeChoice;
    }

    public State getOutOfOrder() {
        return outOfOrder;
    }

    public State getInProcess() {
        return inProcess;
    }

    public int getCoffeePrice() {
        return coffeePrice;
    }

    @Override
    public void update(int coffeePrice, int teaPrice) {
        this.coffeePrice = coffeePrice;
        this.teaPrice = teaPrice;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoffeeMachine that = (CoffeeMachine) o;

        if (coffeePrice != that.coffeePrice) return false;
        if (teaPrice != that.teaPrice) return false;
        if (noMoney != null ? !noMoney.equals(that.noMoney) : that.noMoney != null) return false;
        if (makeChoice != null ? !makeChoice.equals(that.makeChoice) : that.makeChoice != null) return false;
        if (outOfOrder != null ? !outOfOrder.equals(that.outOfOrder) : that.outOfOrder != null) return false;
        if (inProcess != null ? !inProcess.equals(that.inProcess) : that.inProcess != null) return false;
        return !(currentState != null ? !currentState.equals(that.currentState) : that.currentState != null);

    }

    @Override
    public int hashCode() {
        int result = noMoney != null ? noMoney.hashCode() : 0;
        result = 31 * result + (makeChoice != null ? makeChoice.hashCode() : 0);
        result = 31 * result + (outOfOrder != null ? outOfOrder.hashCode() : 0);
        result = 31 * result + (inProcess != null ? inProcess.hashCode() : 0);
        result = 31 * result + (currentState != null ? currentState.hashCode() : 0);
        result = 31 * result + coffeePrice;
        result = 31 * result + teaPrice;
        return result;
    }

    @Override
    public String toString() {
        return "CoffeeMachine{" +
                "coffeePrice=" + coffeePrice +
                ", teaPrice=" + teaPrice +
                '}';
    }
}
