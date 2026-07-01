package Day1;

public class Customer {

    private String name;
    private String country;
    private boolean active;

    public Customer(String name, String country, boolean active) {
        this.name = name;
        this.country = country;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "Customer{ " +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", active=" + active +
                " }";
    }
}