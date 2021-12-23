import java.io.*;
import java.util.*;

public class Property {

	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;

	public Property() {
		propertyName = "";
		city = "";
		rentAmount = 0;
		owner = "";
		plot = new Plot(0, 0, 1, 1);
	}

	public Property(Property p) {
		this.propertyName = p.propertyName;
		this.city = p.city;
		this.rentAmount = p.rentAmount;
		this.owner = p.owner;
		this.plot = new Plot(p.getPlot());
	}

	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
	}

	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width,
			int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);

	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getCity() {
		return city;
	}

	public Plot getPlot() {
		return plot;
	}

	public Plot setPlot(int x, int y, int width, int depth) {
		return this.plot = new Plot(x, y, width, depth);
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String toString() {
		String str = "";
		str += "\nProperty Name: " + this.propertyName;
		str += "\n Located in " + this.city;
		str += "\n Belonging to: " + this.owner;
		str += "\n Rent Amount: " + this.rentAmount;
		return str;
	}

}