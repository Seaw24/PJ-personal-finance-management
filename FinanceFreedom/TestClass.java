import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("1 for plan");
            System.out.println("2 for Reality");
            System.out.println("3 for quit");
            int choice = input.nextInt();
            System.out.println();



            switch (choice) {
                case 1:
                    boolean planQuit = false;
                    while (!planQuit) {
                        System.out.println("1 for creating new plan");
                        System.out.println("2 for viewing your plan");
                        System.out.println("3 for quit to main menu");
                        int planChoice = input.nextInt();
                        System.out.println();

                        IdealPlanFace1 plan = new IdealPlanFace1(0, 0, 0, 0, 0, 0);

                        switch (planChoice) {
                            case 1:
                                // Set data
                                System.out.println("Input your average income: ");
                                int averageIncome = input.nextInt();
                                plan.setAverageIncome(averageIncome);

                                System.out.println("Input your desired pathway: ");
                                int pathWay = input.nextInt();
                                plan.setPathWay(pathWay);

                                System.out.println("Input your current saving: ");
                                int currentSavings = input.nextInt();
                                plan.setCurrentSavings(currentSavings);

                                int fundamentalExpense = averageIncome / 2;
                                System.out.println("Suggested fundamental expense in this phase is 1/2 income. Do you want to change it? (y/n)");
                                char select = input.next().charAt(0);
                                if (select == 'y' || select == 'Y') {
                                    System.out.println("Change to?");
                                    fundamentalExpense = input.nextInt();
                                }

                                plan.setFundamentalExpense(fundamentalExpense);

                                int niceToHave = 0;
                                System.out.println("Suggested nice-to-have expense in this phase is 0. Do you want to change it? (y/n)");
                                select = input.next().charAt(0);
                                if (select == 'y' || select == 'Y') {
                                    System.out.println("Change to?");
                                    niceToHave = input.nextInt();
                                }

                                plan.setNiceToHave(niceToHave);
                                plan.cal();

                                // Save and view file
                                plan.save();
                                System.out.println("Plan was created!");
                                break;

                            case 2:                          
                                plan.viewFile();
                                break;

                            case 3:
                                planQuit = true;
                                break;

                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                    break;

                case 2:
                    boolean realityQuit = false;
                    while (!realityQuit) {
                        System.out.println("1 for creating new month update");
                        System.out.println("2 for continuing update");
                        System.out.println("3 for viewing file");
                        System.out.println("4 for quit to main menu");                        
                        int realityChoice = input.nextInt();
                        System.out.println();
                        
                        Reality reality = new Reality();
                        
                        
                        switch (realityChoice) {
                            case 1:
                                reality.save();
                                break;

                            case 2:
                                reality.load();
                                reality.update();
                                reality.cal();
                                reality.save();
                                break;

                            case 3:
                                reality.viewFile();
                                break;

                            case 4:
                                realityQuit = true;
                                break;

                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                    break;

                case 3:
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        input.close();
      
}
}