package by.gomel.clevertec.utils;

import by.gomel.clevertec.beans.Byn;

import java.util.Arrays;
import java.util.Formatter;

public enum Column {
	NAME("name", -10), PRICE("price", 10),
	DISCOUNT("promo price", 15),UNITS_NUMBER("number", 9),
	COST("cost", 12);

	private final String name;
	private final int colLength;
	Column(final String name, final int colLength) {
		this.name = name;
		this.colLength = colLength;
	}
	public String getName() {
		return name;
	}
	public int getColLength() {
		return colLength;
	}
	public String getValueFormat() {
		return "%" + colLength + "s"; 
	}
	public String getHeaderFormat() {
		return "%" + colLength + "s"; 
	}
	public static String getHeader() {
		Formatter fmt = new Formatter();
		for(Column column : values()) {
			fmt.format(column.getHeaderFormat(), column.getName());
		}
		return fmt.toString();
	}
	private static int getTotalColLength(int colNumber) {
		int sum = 0;
		for(int i=0; i<colNumber; i++) { 
			sum += Math.abs(values()[i].getColLength());
		}
		return sum;
	}
	public final static String HORIZONTAL_LINE;
	static {
		final char LINE_CHAR = '-';
		char[] hLine = new char[getTotalColLength(values().length)];
		Arrays.fill(hLine, LINE_CHAR);
		HORIZONTAL_LINE = new String(hLine);
	}

	public static String getRow(String csvPurchase) {
		Formatter fmt = new Formatter();
		String[] values = csvPurchase.split(";");
		//a few tricks below
		//1. save cost i.e. last value
		String strCost = values[values.length -1];
		Column[] columnValues = Column.values();
		//2. replace last value for null discount
		if (values.length == 4) {
			values[values.length -1] = values[values.length-2];
			values[values.length - 2] = "-";
		}
		//3. push input values
		for (int i = 0; i < columnValues.length - 1; i++) {
			fmt.format(columnValues[i].getValueFormat(), values[i]);
		}
		//4. push cost
		fmt.format(COST.getValueFormat(), strCost);
		return fmt.toString();
	}
	
	public static String getFooter(Byn totalCost) {
		Formatter fmt = new Formatter();
		final String TOTAL_COST = "Total cost";
		int numSpaces = - TOTAL_COST.length() + getTotalColLength(values().length);
		fmt.format(TOTAL_COST + "%" + numSpaces + "s", totalCost);
		return  fmt.toString();
	}
}
