public class Car extends Vehicle implements Rentable{
    private int numberOfSeats;
    private boolean hasAirConditioning;
    private boolean hasRadio;

    public Car(String vehicle_name, String vehicle_Id, int baseRentalRate, boolean isAvailable, int numberOfSeats, boolean hasAirConditioning, boolean hasRadio) {
        super(vehicle_name, vehicle_Id, 70, isAvailable);
        if (numberOfSeats < 0){
            throw new IllegalArgumentException("Number of seats cannot be negative");
        }
        this.numberOfSeats = numberOfSeats;
        this.hasAirConditioning = hasAirConditioning;
        this.hasRadio = hasRadio;
    }

    @Override
    public double calculateRentalCost(int days) {
    double cost = getBaseRentalRate() * days;
    if(hasAirConditioning){
        cost = cost + 20;
    }
    if(hasRadio) {
        cost = cost + 10;
    }
    return cost;
    }

    @Override
    public boolean isAvailableForRental() {
        return false;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isHasRadio() {
        return hasRadio;
    }

    public void setHasRadio(boolean hasRadio) {
        this.hasRadio = hasRadio;
    }

    public boolean isHasAirConditioning() {
        return hasAirConditioning;
    }

    public void setHasAirConditioning(boolean hasAirConditioning) {
        this.hasAirConditioning = hasAirConditioning;
    }

    @Override
    public void rent(Customer customer, int days) {
        if(isAvailable()){
            setIsAvailable(false);
            System.out.println("Car is rented to " + customer.getName() + " for " + days + " days");
        }else {
            System.out.println("Car is not available for rent");
        }
    }

    @Override
    public void returnVehicle() {
        if(isAvailable()){
            System.out.println("Car is already available");
        }else {
            setIsAvailable(true);
            System.out.println("Car is returned");
        }
    }
}
