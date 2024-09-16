package vehiclesV2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * This class has the following responsibilities:
 * 
 * 1 - Handles the running of the program - has a main() method
 * 2 - Loads the input file
 * 3 - Creates Registrar and Registers Vehicles
 * 4 - Allows Users to query the outcome of the reg process
 * 
 */

public class VehicleManager {
	
	private List<Vehicle> unregisteredVehicles = new ArrayList();
	private VehicleRegistrations registeredVehicles;
	private static String FILE = "vehicles.csv";

	public static void main(String[] args) {
		VehicleManager manager = new VehicleManager();
		manager.registerVehicles();
		manager.menu();
	}
	
	List<Vehicle> getUnregisteredVehicles() {
		return unregisteredVehicles;
	}
		
	VehicleRegistrations getRegisteredVehicles() {
		return registeredVehicles;
	}
	
	
	/**
	 * Method that sets up the environment needed for the menu to function 
	 */
	void registerVehicles() {
		readFile(FILE);
		VehicleRegistrar registrar = new VehicleRegistrar();
		this.registeredVehicles = registrar.register(unregisteredVehicles);
	}
		
	/**
	 * Starting menu to make checking output more efficient 
	 */
	public void menu() {
		boolean start = true;
		Scanner s = new Scanner(System.in);
		do {
			System.out.println("--------------------");
			System.out.println("Choose an option\n"
					+ "1. Generate Vehicle Registration Numbers\n"
					+ "2. Total Number of Registration Numbers Generated\n"
					+ "3. Total Number of Registration Numbers Generated per Registration Area\n"
					+ "4. Could Any Registration Numbers Not Be Generated? How Many?\n"
					+ "5. Exit\n");
			int input = s.nextInt();
			switch(input) {
			case 1:
				System.out.println(printRegNumbers());
				break;
			case 2:
				System.out.println(printRegisteredTotal());
				break;
			case 3:
				System.out.println(printRegNumbersByArea());
				break;
			case 4:
				System.out.println(printUnregisteredTotal());
				break;
			case 5: 
				System.out.println("Bye...");
				start = false;
				break;
			default:
				System.out.println("Input must be 1, 2, 3, or 4. Try again...");
				break;
			}
			System.out.println("--------------------");
		} while(start);
		s.close();
	}

	
	/**
	 * Method to return the output required to show the number of unregistered vehicles
	 * @return
	 */
	String printUnregisteredTotal() {
		return "Not registered total: " + registeredVehicles.totalUnregistered();
	}
	
	
	/**
	 * Method to return the output required to show the total number of registered vehicles
	 * @return
	 */
	String printRegisteredTotal() {
		return "Registered total: " + registeredVehicles.totalRegistered();
	}
	
	
	/**
	 * Method to return the output required to show all of the generated reg numbers
	 * @return
	 */
	
	String printRegNumbers() {
		return "Reg Numbers: " + registeredVehicles.getAllRegNumbers();
	}
	
	/**
	 * Method to return the output required to show the number of registered vehicles per location
	 * @return
	 */
	String printRegNumbersByArea() {
		// set up map based off 
		Map<String, Integer> areaToRegMap = registeredVehicles.regNumsPerArea();
		String response = "Registrations By Area: \n";
		// iterate through the areas within the map
		for (String area : areaToRegMap.keySet()) {
			// set response
			response = response + area + " " + areaToRegMap.get(area) + " \n";
		}
		return response;
	}
	
	
	/**
	 * Method that retrieves all info from the given csv and loads into variable
	 * @param fileName
	 */
	public void readFile(String fileName){
		
		// set file name
		File file = new File(fileName);
		String line;
		
		// use try with resources to read file so automatic close
		try(FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr)){
			
			// remove reading header
			br.readLine();
			
			// while the current line is not null complete the following 
			while((line = br.readLine()) != null) {
				// split each line into specific parts (make etc)
				String[] vehicleInfo = line.split(",");
				
				// initialise a new vehicle and set its variables
				Vehicle v = new Vehicle();
				v.setMake(vehicleInfo[0]);
				v.setColour(vehicleInfo[1]);
				String[] dateSplit = vehicleInfo[2].split("-");
				int day = Integer.parseInt(dateSplit[0]);
				int month = Integer.parseInt(dateSplit[1]);
				int year = Integer.parseInt(dateSplit[2]);
				LocalDate mDate = LocalDate.of(year, month, day);
				v.setManufactureDate(mDate);
				v.setVin(vehicleInfo[3]);
				v.setRegArea(vehicleInfo[4]);
				// add the vehicle to the list of vehicles 
				unregisteredVehicles.add(v);
			}
			
		} catch(IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
	}
}
