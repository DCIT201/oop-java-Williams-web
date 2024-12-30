public class Truck extends Vehicle implements Rentable{
    private int capacity;
    private boolean hasTrailer;

    public Truck(String vehicle_name, String vehicle_Id, int baseRentalRate, boolean isAvailable,int capacity,boolean hasTrailer) {
        super(vehicle_name, vehicle_Id, 100,isAvailable);
        if(capacity < 0){
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        this.capacity=capacity;
        this.hasTrailer=hasTrailer;
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate()*days;
        if(capacity>1000){
            cost = cost + 50;
        }
        if(hasTrailer){
            cost = cost + 20;
        }
        return cost;
    }

    @Override
    public boolean isAvailableForRental() {
        return false;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isHasTrailer() {
        return hasTrailer;
    }

    public void setHasTrailer(boolean hasTrailer) {
        this.hasTrailer = hasTrailer;
    }

    @Override
    public void rent(Customer customer, int days) {
        if(isAvailable()){
            setIsAvailable(false);
            System.out.println("Truck rented to " + customer.getName() + " for " + days + " days");
        }
    }

    @Override
    public void returnVehicle() {
    if(!isAvailable()){
        setIsAvailable(true);
        System.out.println("Truck returned");
    }
    }
}
