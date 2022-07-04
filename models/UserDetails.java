package models;

public class UserDetails {
    private int id;
    private String fullname;
    private String job;
    private Long nic;
    private int tan;
    private double tax;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Long getNic() {
        return nic;
    }

    public void setNic(Long nic) {
        this.nic = nic;
    }

    public int getTan() {
        return tan;
    }

    public void setTan(int tan) {
        this.tan = tan;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
