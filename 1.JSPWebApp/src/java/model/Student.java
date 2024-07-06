package model;

/**
 *
 * @author Shabab-1281539
 */
public class Student {

    private Long id;
    private String name;
    private Integer roll;
    private String cell;
    private String address;

    public Student() {
    }

    public Student(Long id) {
        this.id = id;
    }

    public Student(String name, Integer roll, String cell, String address) {
        this.name = name;
        this.roll = roll;
        this.cell = cell;
        this.address = address;
    }

    public Student(Long id, String name, Integer roll, String cell, String address) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.cell = cell;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
