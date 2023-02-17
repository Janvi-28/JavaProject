package Asc;

import java.util.Scanner;

class Parked_CarOwner_Details {
    private String ownerName;
    private String carModel;
    private int carNO;
    private String ownerMobileNo;
    private String ownerAddress;

    // Constructor
    public Parked_CarOwner_Details(String ownerName, String carModel, int carNO, String ownerMobileNo, String ownerAddress) {
        this.ownerName = ownerName;
        this.carModel = carModel;
        this.carNO = carNO;
        this.ownerMobileNo = ownerMobileNo;
        this.ownerAddress = ownerAddress;
    }

    // Getter and Setter methods
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarNO() {
        return carNO;
    }

    public void setCarNO(int carNO) {
        this.carNO = carNO;
    }

    public String getOwnerMobileNo() {
        return ownerMobileNo;
    }

    public void setOwnerMobileNo(String ownerMobileNo) {
        this.ownerMobileNo = ownerMobileNo;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }
}

class ParkingSlot {
    private String ownerName;
    private int carNumber;
    private int token;
    private int level;
    private int section;
    private int slot;

    // Constructor
    public ParkingSlot(String ownerName, int carNumber, int token, int level, int section, int slot) {
        this.ownerName = ownerName;
        this.carNumber = carNumber;
        this.token = token;
        this.level = level;
        this.section = section;
        this.slot = slot;
    }

    // Getter and Setter methods
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}

class Parked_CarOwenerList {
    int levels = 3;
    int sections = 4;
    int slots = 20;

    ParkingSlot[][][] parkingSlots = new ParkingSlot[levels][sections][slots];

    // Method to add a new car to the parking list
    public void add_new_car(Parked_CarOwner_Details obj) {
        int level = 0, section = 0, slot = 0;
        boolean isCarParked = false;
        for (int i = 0; i < levels; i++) {
            for (int j = 0; j < sections; j++) {
                for                (int k = 0; k < slots; k++) {
                    if (parkingSlots[i][j][k] == null) {
                        parkingSlots[i][j][k] = new ParkingSlot(obj.getOwnerName(), obj.getCarNO(), k+1, i+1, j+1, k+1);
                        System.out.println("Car parked successfully at Level " + (i+1) + ", Section " + (j+1) + ", Slot " + (k+1) + ".");
                        isCarParked = true;
                        break;
                    }
                }
                if (isCarParked) {
                    break;
                }
            }
            if (isCarParked) {
                break;
            }
        }
        if (!isCarParked) {
            System.out.println("Sorry, parking is full.");
        }
    }

    // Method to remove a car from the parking list
    public void remove_car(String name,int carNo) {
        boolean isCarFound = false;
        for (int i = 0; i < levels; i++) {
            for (int j = 0; j < sections; j++) {
                for (int k = 0; k < slots; k++) {
                    ParkingSlot parkingSlot = parkingSlots[i][j][k];
                    if (parkingSlot != null && parkingSlot.getOwnerName().equals(name) && parkingSlot.getCarNumber() == carNo) {
                        parkingSlots[i][j][k] = null;
                        System.out.println("Car removed successfully from Level " + (i+1) + ", Section " + (j+1) + ", Slot " + (k+1) + ".");
                        isCarFound = true;
                        break;
                    }
                }
                if (isCarFound) {
                    break;
                }
            }
            if (isCarFound) {
                break;
            }
        }
        if (!isCarFound) {
            System.out.println("Car not found.");
        }
    }

    // Method to get the location of a parked car
    public String get_parked_car_location(int token) {
        for (int i = 0; i < levels; i++) {
            for (int j = 0; j < sections; j++) {
                for (int k = 0; k < slots; k++) {
                    ParkingSlot parkingSlot = parkingSlots[i][j][k];
                    if (parkingSlot != null && parkingSlot.getToken() == token) {
                        return "Level " + (i+1) + ", Section " + (j+1) + ", Slot " + (k+1);
                    }
                }
            }
        }
        return "Invalid Token";
    }
}

public class Assignment3Q7 {
private static Scanner scanner = new Scanner(System.in);
public static void main(String[] args) {
    Parked_CarOwenerList parkedCarOwnerList = new Parked_CarOwenerList();
    int choice = 0;
    do {
        System.out.println("1. Park a Car");
        System.out.println("2. Remove a Car");
        System.out.println("3. Get Parked Car Location");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                scanner.nextLine();
                System.out.print("Enter Owner Name: ");
                String ownerName = scanner.nextLine();
                System.out.print("Enter Car Model: ");
                String carModel = scanner.nextLine();
                System.out.print("Enter Car Number: ");
                int carNo = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Mobile Number: ");
                String mobileNumber = scanner.nextLine();
                System.out.print("Enter Address: ");
                String address = scanner.nextLine();
                Parked_CarOwner_Details obj = new Parked_CarOwner_Details(ownerName, carModel, carNo, mobileNumber, address);
                parkedCarOwnerList.add_new_car(obj);
                break;
            case 2:
                scanner.nextLine();
                System.out.print("Enter Owner Name: ");
                ownerName = scanner.nextLine();
                System.out.print("Enter Car Number: ");
                carNo = scanner.nextInt();
                parkedCarOwnerList.remove_car(ownerName, carNo);
                break;
            case 3:
                System.out.print("Enter Token Number: ");
                int token = scanner.nextInt();
                String location = parkedCarOwnerList.get_parked_car_location(token);
                System.out.println(location);
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    } while (choice != 4);
}
}




