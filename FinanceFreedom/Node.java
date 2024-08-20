import java.time.LocalDate;

public class Node implements Comparable<Node> {
    private int value;
    private LocalDate date;
    private String category;  // New field

    // Constructor
    public Node(int value, LocalDate date, String category) {
        this.value = value;
        this.date = date;
        this.category = category;
    }

    // Getter and setter for 'category'
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Getter
    public int getValue() {
        return value;
    }

    // Setter
    public void setValue(int value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    // Setter
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public int compareTo(Node other){
    return this.date.compareTo(other.date);
    }
}
