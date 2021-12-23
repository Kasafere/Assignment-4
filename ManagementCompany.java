import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class ManagementCompany {

	private String name;
	private String taxID;
	private Property[] properties;
	private double mgmFeePer;
	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Plot plot;
	private int propertyAccumulator = 0;

	public ManagementCompany() {
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}

	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}

	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(x, y, width, depth);
	}

	public ManagementCompany(ManagementCompany otherCompany) {
		ManagementCompany anotherCompany = new ManagementCompany(otherCompany);
	}

	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

	public Plot getPlot() {
		return plot;
	}

	public String getName() {
		return name;
	}

	public String getTaxID() {
		return taxID;
	}

	public int addProperty(Property property) {

		if (propertyAccumulator >= this.MAX_PROPERTY) {
			return -1;
		}

		if (Objects.isNull(property)) {
			return -2;
		}

		if (!plot.encompasses(property.getPlot())) {
			return -3;
		}

		for (int index = 0; index < propertyAccumulator; index++) {
			if (properties[index].getPlot().overlaps(property.getPlot())) {
				return -4;
			}
		}
		this.properties[propertyAccumulator] = new Property(property);

		return propertyAccumulator++;
	}

	public int addProperty(String name, String city, double rent, String owner) {
		Property newProperty = new Property(name, city, rent, owner);

		if (propertyAccumulator >= this.MAX_PROPERTY) {
			return -1;
		}

		if (Objects.isNull(newProperty)) {
			return -2;
		}

		if (!plot.encompasses(newProperty.getPlot())) {
			return -3;
		}

		for (int index = 0; index < propertyAccumulator; index++) {
			if (properties[index].getPlot().overlaps(newProperty.getPlot())) {
				return -4;
			}
		}

		this.properties[propertyAccumulator] = newProperty;

		return propertyAccumulator++;

	}

	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {

		Property newProperty = new Property(name, city, rent, owner, x, y, width, depth);

		for (int index = 0; index < this.properties.length; index++) {

			if (propertyAccumulator >= this.MAX_PROPERTY) {
				return -1;
			}

			if (Objects.isNull(newProperty)) {
				return -2;
			}

			if (!plot.encompasses(newProperty.getPlot())) {
				return -3;
			}

			for (index = 0; index < propertyAccumulator; index++) {
				if (properties[index].getPlot().overlaps(newProperty.getPlot())) {
					return -4;
				}
			}

		}

		this.properties[propertyAccumulator] = newProperty;

		return propertyAccumulator++;
	}

	public double totalRent() {
		double totalRent = 0;

		for (int index = 0; index < this.properties.length; index++) {
			if (this.properties[index] == null) {
				continue;
			}

			Property propGetter = this.properties[index];

			totalRent += propGetter.getRentAmount();
		}

		return totalRent;
	}

	public double maxRentProp() {

		double highest = 0;

		for (int index = 0; index < this.properties.length; index++) {
			Property propGetter = this.properties[index];

			if (propGetter == null) {
				continue;
			}
			if (propGetter.getRentAmount() > highest) {
				highest = propGetter.getRentAmount();
			}
		}

		return highest;
	}

	private int maxRentPropertyIndex() {
		if (properties == null || properties.length == 0) {
			return -1;
		}

		int highestIndex = 0;

		for (int index = 1; index < this.properties.length; index++) {
			Property propGetter = this.properties[index];
			Property propGetter2 = this.properties[highestIndex];

			if (propGetter == null) {
				continue;
			}
			if (propGetter.getRentAmount() > (propGetter2.getRentAmount())) {
				highestIndex = index;
			}
		}

		return highestIndex;
	}

	private String displayPropertyAtIndex(int i) {
		String str = "";

		Property propGetter = this.properties[i];

		str += propGetter.toString();

		return str;
	}

	public String toString() {
		String str = "";

		str += "\nList of properties for " + getName() + ", taxID: " + getTaxID() + "\n";
		str += "___________________________________________\n";

		for (int index = 0; index < this.properties.length; index++) {
			Property propGetter = this.properties[index];
			str += propGetter.toString();

		}

		str += "\n___________________________________________\n";
		str += "Total Management Fee: " + String.format("%.2f", (totalRent() / mgmFeePer));

		return str;

	}

}