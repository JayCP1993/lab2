package model;

/**
 * Represents an Indy Winner record.
 */
public class IndyWinner {
    // Fields for ID, name, and year of the winner
    private int id;
    private String name;
    private int year;

    // Getter for the 'id' field
    public int getId() {
        return id;
    }

    // Setter for the 'id' field
    public void setId(int id) {
        this.id = id;
    }

    // Getter for the 'name' field
    public String getName() {
        return name;
    }

    // Setter for the 'name' field
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the 'year' field
    public int getYear() {
        return year;
    }

    // Setter for the 'year' field
    public void setYear(int year) {
        this.year = year;
    }
}
