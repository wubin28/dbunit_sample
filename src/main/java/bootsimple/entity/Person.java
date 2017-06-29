package bootsimple.entity;

/**
 * Created by twer on 2017/6/28.
 */
public class Person {
    private Integer id;
    private String firstname;
    private String lastname;
    private String state;
    private String username;

    public Person(Integer id) {
        this.id = id;
    }

    public Person(Integer id, String firstname, String lastname, String state, String username) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.state = state;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
