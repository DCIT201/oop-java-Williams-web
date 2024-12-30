import java.time.LocalDate;

public class RentalTransaction {
    private Vehicle vehicle;
    private Customer customer;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private int rentalDays;

    public RentalTransaction(Customer customer, Vehicle vehicle, int rentaldays) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
        this.rentalDate = LocalDate.now();
        this.returnDate = rentalDate.plusDays(rentalDays);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    public Customer getCustomer() {
        return customer;
    }
    public int getRentalDays(){
        return rentalDays;
    }
    public LocalDate getRentalDate(){
        return rentalDate;
    }
    public LocalDate getReturnDate(){
        return returnDate;
    }

    @Override
    public String toString() {
        return "RentalTransaction{" +
                "vehicle=" + vehicle +
                ", customer=" + customer +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", rentalDays=" + rentalDays +
                '}';
    }
}
