public class HasQuarterState implements State {
    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
      this.gumballMachine = gumballMachine;
    }

    public void insertQuater() {
      System.out.println("You can't inserted another quarter");
    }

    public void ejectQuater() {
      System.out.println("Quarter returned");
      gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    public void turnCrank() {
      System.out.println("You turned...");
      gumballMachine.setState(gumballMachine.getSoldState());
    }

    public void dispense() {
      System.out.println("No gumball dispensed");
    }
}
