import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Create some customers
         Customer customer1 = new Customer("John Doe", "C001");
        Customer customer2 = new Customer("Jane Smith", "C002");

        // Create some vehicles
        RentalAgency rentalAgency = new RentalAgency(new LinkedList<>(), new LinkedList<>(), new LinkedList<>());
        Car car1 = new Car("Toyota Camry", "V001", 50, true, 4,true,true);
        Truck truck1 = new Truck("Ford F-150", "V002", 80, true,1000,true);
        Motorcycle motorcycle1 = new Motorcycle("Harley Davidson", "V003", 40, true,1000,true);

        // Add vehicles to the rental agency

        rentalAgency.addVehicle(car1);
        rentalAgency.addVehicle(truck1);
        rentalAgency.addVehicle(motorcycle1);

        // Rent a car
        rentalAgency.rentCar(customer1, 5);

        // Rent a truck
        rentalAgency.rentTruck(customer2, 3);

        // Return the car
        rentalAgency.returnCar(car1);

        // Print the rental agency report
        System.out.println(rentalAgency.report());
    }
}

