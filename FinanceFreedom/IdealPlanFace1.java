import java.util.Scanner;
import java.io.File; // Import the File class
import java.io.IOException; // Import the IOException class to 
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
public class IdealPlanFace1 implements In1 {
    private int averageIncome;
    private int pathWay;
    private int currentSavings;
    private int fundamentalExpense;
    private int targetSavings;
    private int niceToHave ;
    private int netSavings;
    private int expectedDoneDate;
    private int waste;

    public IdealPlanFace1(int averageIncome, int pathWay, int fundamentalExpense, int niceToHave, int waste, int currentSavings){
        this.averageIncome = averageIncome;
        this.pathWay = pathWay;
        this.fundamentalExpense = fundamentalExpense;
        this.niceToHave = niceToHave;
        this.waste = waste;
        this.currentSavings = currentSavings;
    }

    
    public void setAverageIncome(int averageIncome) {
        this.averageIncome = averageIncome;
    }

    // Getters and setters for pathWay
    public int getPathWay() {
        return pathWay;
    }

    public void setPathWay(int pathWay) {
        this.pathWay = pathWay;
    }

    // Getters and setters for currentSavings
    public int getCurrentSavings() {
        return currentSavings;
    }

    public void setCurrentSavings(int currentSavings) {
        this.currentSavings = currentSavings;
    }

    // Getters and setters for fundamentalExpense
    public int getFundamentalExpense() {
        return fundamentalExpense;
    }

    public void setFundamentalExpense(int fundamentalExpense) {
        this.fundamentalExpense = fundamentalExpense;
    }

    // Getters and setters for targetSavings
    public int getTargetSavings() {
        return targetSavings;
    }

    public int getnetSavings() {
        return netSavings;
    }

    public int getexpectedDoneDate() {
        return expectedDoneDate;
    }



    // Getters and setters for niceToHave
    public int getNiceToHave() {
        return niceToHave;
    }

    public void setNiceToHave(int niceToHave) {
        this.niceToHave = niceToHave;
    }


    
@Override
    public void cal(){
        int targetSavings =  fundamentalExpense* this.pathWay  ;
        int netSavings = this.averageIncome - this.fundamentalExpense - this.niceToHave;
        int expectedDoneDate = (targetSavings - this.currentSavings)/netSavings;
        this.targetSavings = targetSavings;
        this.netSavings = netSavings;
        this.expectedDoneDate= expectedDoneDate; 
    }

@Override
public void save(){
    Scanner planInput = new Scanner(System.in);
    System.out.println("Set a name for the ouput file");
    String planFileName = planInput.nextLine();
    File outFile = new File(planFileName);
    try{
        if(!outFile.exists()){
            System.out.println(" New file succesfully created");

        }
        else{
            System.out.println("File already exists");
            planFileName = planInput.nextLine();
            outFile = new File(planFileName);
        }
    
        try (FileOutputStream outF1 = new FileOutputStream(outFile);
        PrintStream out = new PrintStream(outF1)) {

        out.println("Average Income: " + averageIncome);
        out.println("Pathway: " + pathWay);
        out.println("Current Savings: " + currentSavings);
        out.println("Fundamental Expense: " + fundamentalExpense);
        out.println("Target Savings: " + targetSavings);
        out.println("Nice to Have: " + niceToHave);
        out.println( "Waste: " + waste);
        out.println("Net Savings: " + netSavings);
        out.println("Plan finish after (month): " + expectedDoneDate);
        
       
            }  
    }catch(IOException e){
        System.out.println("Theres an error");
        e.printStackTrace();    

    }
   
}


@Override

public void viewFile(){
    Scanner planInput = new Scanner(System.in);
    System.out.println("whats your file's");
    String planFileNamei = planInput.nextLine();
    File planInFile = new File(planFileNamei);
    try{
        if(!planInFile.exists()){
            System.out.println("invalid name. Please enter again!");
            planFileNamei = planInput.nextLine();
            planInFile = new File(planFileNamei);
        }
        try( Scanner in = new Scanner(planInFile); ){
while( in.hasNextLine()){
    String data = in.nextLine();
    System.out.println(data);
}

        }
    }catch(IOException e){
        System.out.println("Theres an error");
        e.printStackTrace();

    }
}

@Override
public void load() {
    Scanner planInput = new Scanner(System.in);
    System.out.println("Enter your plan file's name to load:");
    String planFileName = planInput.nextLine();
    File planInFile = new File(planFileName);

    try {
        if (!planInFile.exists() || planInFile.length() == 0) {
            System.out.println("File not found or is empty: " + planFileName);
            // Handle appropriately (reset plan state, return, or throw exception)
            return;
        }

        try (Scanner in = new Scanner(planInFile)) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] parts = line.split(": ");
                if (parts.length < 2) {
                    continue;
                }
                String key = parts[0].trim();
                int value = Integer.parseInt(parts[1].trim());

                switch (key) {
                    case "Average Income":
                        this.averageIncome = value;
                        break;
                    case "Pathway":
                        this.pathWay = value;
                        break;
                    case "Current Savings":
                        this.currentSavings = value;
                        break;
                    case "Fundamental Expense":
                        this.fundamentalExpense = value;
                        break;
                    case "Target Savings":
                        this.targetSavings = value;
                        break;
                    case "Nice to Have":
                        this.niceToHave = value;
                        break;
                    case "Net Savings":
                        this.netSavings = value;
                        break;
                    case "Plan finish after (month)":
                        this.expectedDoneDate = value;
                        break;
                    
                }
            }

            System.out.println("Plan state loaded successfully from " + planFileName);
        }
    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + e.getMessage());
        e.printStackTrace();
    } catch (IOException e) {
        System.out.println("Error reading file: " + e.getMessage());
        e.printStackTrace();
    } catch (NumberFormatException e) {
        System.out.println("Error parsing file. Ensure the file format is correct.");
        e.printStackTrace();
    }
}

}



