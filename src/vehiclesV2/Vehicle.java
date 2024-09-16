package vehiclesV2;

import java.time.LocalDate;

/**
 * The class represents a Vehicle - both unregistered and registered (registered = has a reg number).
 */
public class Vehicle {

	// Variables 
		private String make;
		private String colour;
		private LocalDate manufactureDate;
		private String vin;
		private String regArea;
		private String regNumber;
		
		// Constructor 
		public Vehicle() {
		}
	
		// allows creation on an unregistered vehicle which has no regNumber
		public Vehicle(String make, String colour, LocalDate manufactureDate, String vin, String regArea) {
			this.make = make;
			this.colour = colour;
			this.manufactureDate = manufactureDate;
			this.vin = vin;
			this.regArea = regArea;
		}
		
		/*
		 * return the reg number of vehicles with a valid reg number
		 */
		public boolean isRegistered() {
			return regNumber != null;
		}
		
		// Getters and setter 

		public String getMake() {
			return make;
		}

		public void setMake(String make) {
			this.make = make;
		}

		public String getColour() {
			return colour;
		}

		public void setColour(String colour) {
			this.colour = colour;
		}

		public LocalDate getManufactureDate() {
			return manufactureDate;
		}

		public void setManufactureDate(LocalDate manufactureDate) {
			this.manufactureDate = manufactureDate;
		}

		public String getVin() {
			return vin;
		}

		public void setVin(String vin) {
			this.vin = vin;
		}

		public String getRegArea() {
			return regArea;
		}

		public void setRegArea(String regArea) {
			this.regArea = regArea;
		}
		
		public String getRegNumber() {
			return regNumber;
		}

		public void setRegNumber(String regNumber) {
			this.regNumber = regNumber;
		}
		
		
		// To string

		@Override
		public String toString() {
			return "Vehicle [make=" + make + ", colour=" + colour + ", manufactureDate=" + manufactureDate + ", vin=" + vin
					+ ", regArea=" + regArea + ", regNumber=" + regNumber + "]\n";
		}

}
