public class Motorcycle extends Vehicle implements Rentable{
    private int engineCapacity;
    private boolean hasHelment;

    public Motorcycle(String vehicle_name, String vehicle_Id, int baseRentalRate, boolean isAvailable,int engineCapacity,boolean hasHelment) {
        super(vehicle_name, vehicle_Id, 50, isAvailable);
        if(engineCapacity < 0){
            throw new IllegalArgumentException("Engine capacity cannot be negative");
        }
        this.engineCapacity=engineCapacity;
        this.hasHelment=hasHelment;
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate() * days;
        if(hasHelment){
            cost = cost + 10;
        }
        return cost;
    }

    @Override
    public boolean isAvailableForRental() {
        return false;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public boolean isHasHelment() {
        return hasHelment;
    }

    public void setHasHelment(boolean hasHelment) {
        this.hasHelment = hasHelment;
    }

    @Override
    public void rent(Customer customer, int days) {
        if(isAvailable()){
            setIsAvailable(false);
            System.out.println("Motorcycle rented to " + customer.getName() + " for " + days + " days");
        }
    }

    @Override
    public void returnVehicle() {
        if(!isAvailable()){
            setIsAvailable(true);
            System.out.println("Motorcycle returned");
        }
    }
}