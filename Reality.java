import java.util.Scanner;
import java.io.File; // Import the File class
import java.io.IOException; // Import the IOException class to 
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
public class Reality implements In1 {
    private int leftExpense;
    private int leftFundamentalExpense;
    private int leftNiceToHaveExpense;
    private int leftWaste;
    private LinkedList<Node> thisMonthFundamentalExpense  = new LinkedList<>();
    private LinkedList<Node> thisMonthNiceToHaveExpense  = new LinkedList<>();
    private LinkedList<Node> thisMonthWaste  = new LinkedList<>();
   
    

     // Default constructor initializing all LinkedLists to empty
     public Reality() {
        this.leftExpense = 0;
        this.leftFundamentalExpense = 0;
        this.leftNiceToHaveExpense = 0;
        this.leftWaste = 0;
        this.thisMonthFundamentalExpense = new LinkedList<>();
        this.thisMonthNiceToHaveExpense = new LinkedList<>();
        this.thisMonthWaste = new LinkedList<>();
    }

    // Getters
    public int getleftExpense() {
        return leftExpense;
    }

    public int getleftFundamentalExpense() {
        return leftFundamentalExpense;
    }

    public int getleftNiceToHaveExpense() {
        return leftNiceToHaveExpense;
    }

    public int getleftWaste() {
        return leftWaste;
    }

    // Setters
    public void setleftExpense(int leftExpense) {
        this.leftExpense = leftExpense;
    }

    public void setleftFundamentalExpense(int leftFundamentalExpense) {
        this.leftFundamentalExpense = leftFundamentalExpense;
    }

    public void setleftNiceToHaveExpense(int leftNiceToHaveExpense) {
        this.leftNiceToHaveExpense = leftNiceToHaveExpense;
    }

    public void setleftWaste(int leftWaste) {
        this.leftWaste = leftWaste;
    }

    // Getters
public LinkedList<Node> getThisMonthFundamentalExpense() {
    return thisMonthFundamentalExpense;
}

public LinkedList<Node> getThisMonthNiceToHaveExpense() {
    return thisMonthNiceToHaveExpense;
}

public LinkedList<Node> getThisMonthWaste() {
    return thisMonthWaste;
}

// Setters
public void setThisMonthFundamentalExpense(LinkedList<Node> thisMonthFundamentalExpense) {
    this.thisMonthFundamentalExpense = thisMonthFundamentalExpense;
}

public void setThisMonthNiceToHaveExpense(LinkedList<Node> thisMonthNiceToHaveExpense) {
    this.thisMonthNiceToHaveExpense = thisMonthNiceToHaveExpense;
}

public void setThisMonthWaste(LinkedList<Node> thisMonthWaste) {
    this.thisMonthWaste = thisMonthWaste;
}

public void update(){
Scanner input = new Scanner(System.in);

    System.out.println("Input amount of money");
        int amount = input.nextInt();

       
     System.out.println("Is it today expense ? (y/n)");
     LocalDate date = LocalDate.now();
     char select = input.next().charAt(0);
     if (select != 'y' && select != 'Y') {

        System.out.println("Enter the date (in the format YYYYMMDD):");
        int dateInput = input.nextInt();
        int year = dateInput / 10000;
        int month = (dateInput % 10000) / 100;
        int day = dateInput % 100;
         date = LocalDate.of(year, month, day);
     }
        
    
    System.out.println("choosing type");
    System.out.println("1 for fundamental expense");
    System.out.println("2 for nice to have expense");
    System.out.println("3 for waste");
    boolean check ;
do{
    check = false;
        int choosingType = input.nextInt(); 

        switch(choosingType){
        case 1:
        this.thisMonthFundamentalExpense.add(new Node(amount,date,"Fundamental"));
        
        break;
        case 2:
        this.thisMonthNiceToHaveExpense.add(new Node(amount,date,"Nice to have"));
        
        break;
        case 3:
        this.thisMonthWaste.add(new Node(amount,date,"Waste"));
        
        break;
        default :
        System.out.println(" Invalid choice");
        check = true;
        
}
}while(check);

}

@Override
public void cal(){
   IdealPlanFace1 plan = new IdealPlanFace1(0,0,0,0,0,0);
   plan.load();
   // total money has been spent
   int totalExpense = 0;
   int totalFundamentalExpense =0;
   int totalNiceToHaveExpense =0;
   int totalWaste =0;
   for( Node p : this.thisMonthFundamentalExpense){
    totalFundamentalExpense += p.getValue();
   }

   for( Node p : this.thisMonthNiceToHaveExpense){
    totalNiceToHaveExpense += p.getValue();
   }

   for( Node p : this.thisMonthWaste){
    totalWaste += p.getValue();
   }


 
   totalExpense = totalFundamentalExpense + totalNiceToHaveExpense + totalWaste;
this.leftExpense = plan.getFundamentalExpense() +plan.getNiceToHave() - totalExpense;
this.leftFundamentalExpense = plan.getFundamentalExpense() -totalFundamentalExpense;
this.leftNiceToHaveExpense = plan.getNiceToHave() - totalNiceToHaveExpense;
this.leftWaste = - totalWaste ;
}


@Override
public void save() {
    Scanner input = new Scanner(System.in);
    System.out.println("Set a name for the output file");
    String F = input.nextLine();
    File outFile = new File(F);

    boolean allEmpty = true;

    // Check if all lists are empty
    if (!thisMonthFundamentalExpense.isEmpty() ||
        !thisMonthNiceToHaveExpense.isEmpty() ||
        !thisMonthWaste.isEmpty()) {
        allEmpty = false;
    }

    try {
        if (!outFile.exists()) {
            outFile.createNewFile();
            System.out.println("New file successfully created");
        } else {
            System.out.println("File already exists. Enter a new name:");
            F = input.nextLine();
            outFile = new File(F);
            outFile.createNewFile();
        }

        if (!allEmpty) {
            LinkedList<Node> combinedList = new LinkedList<>();
            combinedList.addAll(thisMonthFundamentalExpense);
            combinedList.addAll(thisMonthNiceToHaveExpense);
            combinedList.addAll(thisMonthWaste);
            Collections.sort(combinedList);
            
           
            try (PrintStream out = new PrintStream(new FileOutputStream(outFile))) {
                
                    for (int i = 0; i < combinedList.size(); i++) {
                        Node p = combinedList.get(i);
                        out.print(p.getCategory() + ": ");
                        out.println(p.getValue() + "," + p.getDate());
                    }
                
                

                out.println("leftExpense, " + leftExpense);
                out.println("leftFundamentalExpense, " + leftFundamentalExpense);
                out.println("leftNiceToHaveExpense, " + leftNiceToHaveExpense);
                out.println("leftWaste, " + leftWaste);
            }
        } 
    } catch (IOException e) {
        System.out.println("Error parsing file. Ensure the file format is correct.");
        e.printStackTrace();
    }
}



@Override

public void load() {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the name of your previous reality file to load:");
    String realityFileName = input.nextLine();
    File inFile = new File(realityFileName);

    try {
        if (!inFile.exists() || inFile.length() == 0) {
            System.out.println("File not found or is empty: " + realityFileName);

            // Set every data to their base case (empty lists)
            this.thisMonthFundamentalExpense.clear();
            this.thisMonthNiceToHaveExpense.clear();
            this.thisMonthWaste.clear();

            return;
        }

        try (Scanner in = new Scanner(inFile)) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] parts = line.split(": ");
                if (parts.length < 2) {
                    continue;
                }
                String category = parts[0].trim();
                String[] valueDate = parts[1].trim().split(",");
                if (valueDate.length < 2) {
                    continue;
                }
                int value = Integer.parseInt(valueDate[0].trim());
                LocalDate date = LocalDate.parse(valueDate[1].trim());

                // Create a new Node with the category
                Node node = new Node(value, date, category);

                // Add node to the appropriate linked list based on category
                switch (category) {
                    case "Fundamental":
                        this.thisMonthFundamentalExpense.add(node);
                        break;
                    case "Nice to have":
                        this.thisMonthNiceToHaveExpense.add(node);
                        break;
                    case "Waste":
                        this.thisMonthWaste.add(node);
                        break;
                }
            }

            System.out.println("Reality state loaded successfully from " + realityFileName);
        }
    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + e.getMessage());
        e.printStackTrace();
    } catch (IOException e) {
        System.out.println("Error reading file: " + e.getMessage());
        e.printStackTrace();
    }
}


@Override
public void viewFile(){
    IdealPlanFace1 plan = new IdealPlanFace1(0,0,0,0,0,0);
    
    
    
    
    Scanner input = new Scanner(System.in);
    System.out.println("whats your reality file's name");
    String Fi = input.nextLine();
    File inFile = new File(Fi);

    try{
        if(!inFile.exists()){
            System.out.println("invalid name. Please enter again!");
            Fi = input.nextLine();
            inFile = new File(Fi);
        }
        try( Scanner in = new Scanner(inFile); ){
            
            System.out.println("Your plan ");
            plan.viewFile();
            System.out.println();
    
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


}



