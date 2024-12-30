import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String customerID;
    private List<RentalTransaction> rentalHistory;
    private List<RentalTransaction> currentRentals;

    public Customer(String name, String customerID) {
       if(customerID==null || customerID.isEmpty()){
           throw new IllegalArgumentException("CustomerID cannot be null or empty");
       }
        this.customerID = customerID;
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
        this.rentalHistory = new ArrayList<>();
        this.currentRentals = new ArrayList<>();
    }

    public List<RentalTransaction> getRentalHistory() {
        return rentalHistory;
    }

    public void setRentalHistory(List<RentalTransaction> rentalHistory) {
        this.rentalHistory = rentalHistory;
    }

    public List<RentalTransaction> getCurrentRentals() {
        return currentRentals;
    }

    public void setCurrentRentals(List<RentalTransaction> currentRentals) {
        this.currentRentals = currentRentals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
}
