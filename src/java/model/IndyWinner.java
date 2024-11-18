package model;

/**
 * Represents an IndyWinner entity with id, name, and year attributes.
 */
public class IndyWinner {
    private int id; // Unique identifier for the Indy winner
    private String name; // Name of the Indy winner
    private int year; // Year of the Indy win

    // Constructor to initialize all fields
    public IndyWinner(int id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    // Getters and setters for accessing and modifying private fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
