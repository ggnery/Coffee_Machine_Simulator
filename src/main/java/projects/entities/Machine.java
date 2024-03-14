package projects.entities;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Machine {
    int balance = 550;
    int water = 400;
    int milk = 540;
    int coffee = 120;
    int disposableCups = 9;
    public void printState(){
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", this.water);
        System.out.printf("%d ml of milk\n", this.milk);
        System.out.printf("%d g of coffee beans\n", this.coffee);
        System.out.printf("%d disposable cups\n", this.disposableCups);
        System.out.printf("$%d of money\n", this.balance);
        System.out.println();

    }

    public void buyCoffee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String option = scanner.nextLine();

        switch (option){
            case "1":
                buyEspresso();
                break;
            case "2":
                buyLatte();
                break;
            case "3":
                buyCappuccino();
                break;
            case "back":
                break;
        }
    }

    public void fill(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water you want to add:");
        int newWater= scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        int newMilk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        int newCoffee = scanner.nextInt();

        System.out.println("Write how many disposable cups you want to add:");
        int newDisposableCups = scanner.nextInt();

        this.water += newWater;
        this.milk += newMilk;
        this.coffee += newCoffee;
        this.disposableCups += newDisposableCups;
    }

    public void take(){
        System.out.printf("I gave you $%d\n", this.balance);
        this.balance = 0;
    }

    private boolean canMakeEspresso(){
        int remainingWater = this.water - Espresso.water;
        int remainingCoffee = this.coffee - Espresso.coffee;
        List<String> runningOutOf = new ArrayList<String>();

        if(remainingWater < 0 ){
            runningOutOf.add("water");
        }
        if(remainingCoffee < 0 ) {
            runningOutOf.add("coffee");
        }
        if(this.disposableCups == 0){
            runningOutOf.add("disposable cups");
        }

        printRunningOut(runningOutOf);

        return runningOutOf.isEmpty();
    }
    private void buyEspresso(){
        if(canMakeEspresso()){
            this.water -= Espresso.water;
            this.coffee -= Espresso.coffee;
            this.balance += Espresso.price;
            this.disposableCups--;

        }
    }

    private void buyLatte(){
        if(canMakeLatte()){
            this.water -= Latte.water;
            this.milk -= Latte.milk;
            this.coffee -= Latte.coffee;
            this.balance += Latte.price;
            this.disposableCups--;

        }
    }

    private void printRunningOut(List<String> runningOutOf){
        if (runningOutOf.isEmpty()){
            System.out.println("I have enough resources, making you a coffee!");

        }else{
            System.out.print("Sorry, not enough");

            for(int i =0 ; i<runningOutOf.size() - 1; i++){
                System.out.printf(" %s,", runningOutOf.get(i));
            }
            System.out.printf(" %s",runningOutOf.get(runningOutOf.size() - 1));
            System.out.println("!");
        }
    }
    private boolean canMakeLatte() {
        int remainingWater = this.water - Latte.water;
        int remainingCoffee = this.coffee - Latte.coffee;
        int remainingMilk = this.milk - Latte.milk;
        List<String> runningOutOf = new ArrayList<String>();

        if(remainingWater < 0 ){
            runningOutOf.add("water");
        }
        if(remainingCoffee < 0 ) {
            runningOutOf.add("coffee");
        }
        if(remainingMilk < 0){
            runningOutOf.add("milk");
        }
        if(this.disposableCups == 0){
            runningOutOf.add("disposable cups");
        }

        printRunningOut(runningOutOf);

        return runningOutOf.isEmpty();
    }

    private boolean canMakeCappuccino(){
        int remainingWater = this.water - Cappuccino.water;
        int remainingCoffee = this.coffee - Cappuccino.coffee;
        int remainingMilk = this.milk - Cappuccino.milk;
        List<String> runningOutOf = new ArrayList<String>();

        if(remainingWater < 0 ){
            runningOutOf.add("water");
        }
        if(remainingCoffee < 0 ) {
            runningOutOf.add("coffee");
        }
        if(remainingMilk < 0){
            runningOutOf.add("milk");
        }
        if(this.disposableCups == 0){
            runningOutOf.add("disposable cups");
        }

        printRunningOut(runningOutOf);

        return runningOutOf.isEmpty();
    }
    private void buyCappuccino(){
        if(canMakeCappuccino()){
            this.water -= Cappuccino.water;
            this.milk -= Cappuccino.milk;
            this.coffee -= Cappuccino.coffee;
            this.balance += Cappuccino.price;
            this.disposableCups--;

        }

    }
}
