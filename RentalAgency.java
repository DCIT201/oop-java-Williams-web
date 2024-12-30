import java.util.LinkedList;
import java.util.List;

public class RentalAgency {
    private final List<Car> availableCars;
    private final List <Truck> availableTrucks;
    private final List <Motorcycle> availableMotorcycles;
    private List <Vehicle> vehicleFleet;
    private int carsRented;
    private int trucksRented;
    private int motorcyclesRented;
    private int totalIncome;

    public RentalAgency(List<Car> availableCars, List<Truck> availableTrucks, List<Motorcycle> availableMotorcycles) {
        this.availableCars = availableCars;
        this.availableTrucks = availableTrucks;
        this.availableMotorcycles = availableMotorcycles;
        this.carsRented = 0;
        this.trucksRented = 0;
        this.motorcyclesRented = 0;
        this.totalIncome = 0;
        this.vehicleFleet = new LinkedList<>();
    }

    public List<Car> getAvailableCars() {
        return availableCars;
    }

    public List<Truck> getAvailableTrucks() {
        return availableTrucks;
    }

    public List<Motorcycle> getAvailableMotorcycles() {
        return availableMotorcycles;
    }

    public List<Vehicle> getVehicleFleet() {
        return vehicleFleet;
    }

    public int getCarsRented() {
        return carsRented;
    }

    public int getTrucksRented() {
        return trucksRented;
    }

    public int getMotorcyclesRented() {
        return motorcyclesRented;
    }

    public int getTotalIncome() {
        return totalIncome;
    }

    public String report(){
        return "Cars rented: " + carsRented + "\n" +
                "Trucks rented: " + trucksRented + "\n" +
                "Motorcycles rented: " + motorcyclesRented + "\n" +
                "Total income: " + totalIncome;
    }

    public void rentCar(Customer customer, int days){
        if(!availableCars.isEmpty()){
            Car car = availableCars.getFirst();
            car.rent(customer, days);
            availableCars.removeFirst();
            carsRented++;
            totalIncome += (int) car.calculateRentalCost(days);
        }
    }

    public void rentTruck(Customer customer, int days){
        if(!availableTrucks.isEmpty()){
            Truck truck = availableTrucks.getFirst();
            truck.rent(customer, days);
            availableTrucks.removeFirst();
            trucksRented++;
            totalIncome += (int) truck.calculateRentalCost(days);
        }
    }
    public void rentMotorcycle(Customer customer, int days){
        if(!availableMotorcycles.isEmpty()){
            Motorcycle motorcycle = availableMotorcycles.getFirst();
            motorcycle.rent(customer, days);
            availableMotorcycles.removeFirst();
            motorcyclesRented++;
            totalIncome += (int) motorcycle.calculateRentalCost(days);
        }
    }

    public void returnCar(Car car){
        car.returnVehicle();
        availableCars.add(car);
    }

    public void returnTruck(Truck truck){
        truck.returnVehicle();
        availableTrucks.add(truck);
    }

    public void returnMotorcycle(Motorcycle motorcycle){
        motorcycle.returnVehicle();
        availableMotorcycles.add(motorcycle);
    }

    public void addVehicle(Vehicle vehicle){
        vehicleFleet.add(vehicle);
        if(vehicle instanceof Car){
            availableCars.add((Car) vehicle);
        }else if(vehicle instanceof Truck){
            availableTrucks.add((Truck) vehicle);
        }else if(vehicle instanceof Motorcycle){
            availableMotorcycles.add((Motorcycle) vehicle);
        }
    }

    public void removeVehicle(Vehicle vehicle){
        vehicleFleet.remove(vehicle);
        if(vehicle instanceof Car){
            availableCars.remove(vehicle);
        }else if(vehicle instanceof Truck){
            availableTrucks.remove(vehicle);
        }else if(vehicle instanceof Motorcycle){
            availableMotorcycles.remove(vehicle);
        }
    }

}
