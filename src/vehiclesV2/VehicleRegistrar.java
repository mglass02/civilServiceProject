/**
 * 
 */
package vehiclesV2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * This class contains all the complicated rules and logic needed to register a vehicle. 
 * 
 */
public class VehicleRegistrar {
	
	/**
	 * Give vehicles their registration number 
	 */
	public VehicleRegistrations register(List<Vehicle> vehicles) {

		System.out.println("Registering "+vehicles.size() + " vehicles...");
		// check each vehicle in the list of vehicles
		for(Vehicle v : vehicles) {
			// assign the various parts of the reg code 
			// PART 1 - location code - but if not set then go onto the next vehicle
			String locationCode = getLocationCode(v.getRegArea());
			if(locationCode.equals("")) {
				continue;
			}
			// PART 2 - Date Code
			String dateCode = getDateCode(v.getManufactureDate());
			// PART 3 - Random Code
			String randomCode = getRandomCode();
			
			// add the pieces together to create full reg and update vehicle
			String reg = locationCode + " " + dateCode + " " + randomCode;
			v.setRegNumber(reg);	
		} 
		return new VehicleRegistrations(vehicles);		
	}
	
	/**
	 * Method to create a random string between A-Z but excluded I, M, K, Y
	 * @return
	 */
	String getRandomCode() {
		Random r = new Random();
		String reg = "";
		
		// List of valid letters excluding 'I', 'M', 'K', and 'Y'
        char[] validLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'L', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Z'};
        
        for (int i = 0; i < 3; i++) {
            // Generate a random index within the validLetters array length
            char randomLetter = validLetters[r.nextInt(validLetters.length)];
            reg += randomLetter;
        }
		return reg;
	}
	
	/**
	 * Method to retrieve the date for each reg
	 * @param mDate
	 * @return
	 */
	 String getDateCode(LocalDate mDate) {
		String reg = "";
		
		// get the year associated with the current vehicle 
		String year = Integer.toString(mDate.getYear());
		
		// set the last 2 digits of the array to the last 2 characters 
		String last2digits = year.charAt(2) +""+ year.charAt(3);
		
		// set the date part of reg number based off the month 
		if(mDate.getMonthValue() >=3 && mDate.getMonthValue() <=8) {
			reg += last2digits;
			
		} else if(mDate.getMonthValue() <3 || mDate.getMonthValue() >8) {
			// add 50 to the current year 
			int mYear = mDate.getYear()+50;
			// turn int to string to last 2 chars can be accessed and added
			year = Integer.toString(mYear);
			reg += year.charAt(2) +""+ year.charAt(3);
		} else {
			reg += "N/a";
		}
		
		return reg;
	}
	
	/**
	 * Determine the first 2 letters of the reg number
	 * @param regArea
	 * @return
	 */
     String getLocationCode(String regArea) {
		Random r = new Random();
		// Create a random letter for a vehicle from swansea that is between A and K
		char randomLetterSw = (char) ('A' + r.nextInt(11));
		String secondLetterSw = Character.toString(randomLetterSw);
		// Create a random letter for a vehicle from cardiff that is between L and Z
		char randomLetterCa = (char) ('L' + r.nextInt(15));
		String secondLetterCa = Character.toString(randomLetterSw);
		// Create a random letter for a vehicle from birmingham that is between A-B
		char randomLetterBi = (char) ('A' + r.nextInt(3));
		String secondLetterBi = Character.toString(randomLetterBi);
		
		String reg = "";
		// Add first and second letters to the reg depending on where the vehicle is located
		// convert to switch statement if gets bigger
		if(regArea.equalsIgnoreCase("swansea")) {
			reg += "C";
			reg += secondLetterSw;
		} else if(regArea.equalsIgnoreCase("cardiff")) {
			reg+="C";
			reg += secondLetterCa;
		} else if(regArea.equalsIgnoreCase("birmingham")) {
			reg += "B";
			reg += secondLetterBi;
		}
		return reg;
	}
	
	
}
