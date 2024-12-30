public abstract class Vehicle {
private String vehicle_name;
private String vehicle_Id;
private int baseRentalRate;
private boolean isAvailable;

public Vehicle(String vehicle_name, String vehicle_Id, int baseRentalRate, boolean isAvailable) {
    if (vehicle_name == null){
        throw new IllegalArgumentException("Vehicle name cannot be null");
    }
    if(vehicle_Id == null){
        throw new IllegalArgumentException("Vehicle ID cannot be null");
    }
    if(baseRentalRate < 0){
        throw new IllegalArgumentException("Base rental rate cannot be negative");
    }
    this.vehicle_name = vehicle_name;
    this.vehicle_Id = vehicle_Id;
    this.baseRentalRate = baseRentalRate;
    this.isAvailable = true;
}
// getters and setters

    public String getVehicle_name(){
    return vehicle_name;
    }
    public void setVehicle_name(String vehicle_name){
     if (vehicle_name == null || vehicle_name.isEmpty()){
         throw new IllegalArgumentException("vehicle_name cannot be null or empty");
     }
     this.vehicle_name = vehicle_name;
    }

    public String getVehicle_Id(){
    return vehicle_Id;
    }
    public void setVehicle_Id(String vehicle_Id){
    if (vehicle_Id == null || vehicle_Id.isEmpty()){
        throw new IllegalArgumentException("Vehicle_Id cannot be null or empty");
    }
    this.vehicle_Id = vehicle_Id;
    }

    public int getBaseRentalRate(){
    return baseRentalRate;
    }
    public void setBaseRentalRate(int baseRentalRate){
    if (baseRentalRate < 0){
        throw new IllegalArgumentException("baseRentalRate cannot be negative");
    }
    this.baseRentalRate = baseRentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public void setIsAvailable(boolean isAvailable){
    this.isAvailable = isAvailable;
    }

    // Abstract methods
    public abstract double calculateRentalCost(int days);
    public abstract boolean isAvailableForRental();


    }

