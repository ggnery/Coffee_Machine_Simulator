package projects;

import projects.entities.Machine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean active = true;
        Machine machine = new Machine();

        while(active){
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.nextLine();

            switch (action){
                case "fill":
                    machine.fill();
                    break;
                case "buy":
                    machine.buyCoffee();
                    break;
                case "take":
                    machine.take();
                    break;
                case "remaining":
                    machine.printState();
                    break;
                case "exit":
                    active = false;
                    break;

            }

        }
    }
}