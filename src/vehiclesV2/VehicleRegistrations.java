package vehiclesV2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class has two main functions:
 * 1 - Holds a list of all of the vehicles post registration process - note, including those not registered
 * 2 - Provides a set of query methods which provide insight into the registration outcome 
 * 
 */
public class VehicleRegistrations {
	private List<Vehicle> vehicles;
	
	/**
	 * Constructor for the VehicleRegistrations class
	 * @param vehicles
	 */
	public VehicleRegistrations(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	/**
	 * Return the number of vehicles asked to be request 
	 * @return
	 */
	public int totalInRegistrationRequest() {
		return vehicles.size();
	}
	
	/**
	 * return the number of vehicles that are registered 
	 * @return
	 */
	public int totalRegistered() {
		return getAllRegNumbers().size();
	}

	
	/**
	 * Method used to calculate the total number of registered vehicles
	 * @return
	 */
	public List<String> getAllRegNumbers() {
		// create list to be returned
		List<String> result = new ArrayList();
		
		// iterate through list of vehicles
		for (Vehicle v : vehicles) {
			// check if registered
			if (v.isRegistered()) {
				// if registered, add to result list
				result.add(v.getRegNumber());
			}
		}
		return result;
	}
	
	
	/**
	 * Method used to calculate the total number of unregistered vehicles
	 * @return
	 */
	public int totalUnregistered() {
		// set the starting num of unregistered vehicles
		int unregistered = 0;
		
		// iterate through list of vehicles
		for (Vehicle v : vehicles) {
			// if vehicle is unregistered then increment count of unregistered
			if (!v.isRegistered()) unregistered++;
		}
		return unregistered;
	}
	
	/**
	 * Method to work out the total number of reg nums in area 
	 * @return
	 */
	Map<String, Integer> regNumsPerArea() {
		Map<String, Integer> areaToReg = new HashMap();
		
		for (Vehicle v : vehicles) {
			// if no value for area then create one - so we can see all areas even with no regs
			if (!areaToReg.containsKey(v.getRegArea()))
				areaToReg.put(v.getRegArea(), 0);
			// if not registered then go on to the next one
			if (!v.isRegistered()) continue;
			// increment the value and update map
			int count = areaToReg.get(v.getRegArea());
			count++;
			areaToReg.put(v.getRegArea(), count);
		}
		return areaToReg;
	}

	
}
