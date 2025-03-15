package tests; // Defines the package name

// Class to handle unit conversions
class Converter {
    // Private instance variables
    private String dimension; // Stores the original unit (e.g., "m" for meters, "g" for grams)
    private double num;       // Stores the numerical value to be converted
    private String convert;   // Stores the target conversion unit

    // Constructor to initialize the dimension and value
    public Converter(String dimension, double num) {
        this.dimension = dimension; // Assigns the unit
        this.num = num;             // Assigns the numeric value
    }

    // Method to convert the original value into another unit
    public double convertTo(String convert) { 
        this.convert = convert; // Stores the target conversion unit

        // Uses a switch statement to determine the conversion factor
        switch (convert) {
            case "k": return num / 1000; // Convert to kilo (÷ 1000)
            case "c": return num * 100;  // Convert to centi (× 100)
            case "m": return num * 1000; // Convert to milli (× 1000)
            case "d": return num * 10;   // Convert to deci (× 10)
            case "D": return num / 10;   // Convert to deca (÷ 10)
            default: return num;         // If no valid conversion, return original value
        }
    }

    // Method to retrieve the last conversion unit used
    public String getConvertedUnit() {
        return convert;
    }

    // Method to get the original unit
    public String getUnit() {
        return dimension;
    }

    // Method to retrieve the original numerical value before conversion
    public double getOriginalValue() {
        return num;
    }

    // Method to get the full name of the original unit
    public String unitName() {
        switch (dimension) {
            case "m": return "metres";
            case "g": return "grams";
            case "L": return "litres";
            case "A": return "Amperes";
            case "mol": return "moles";
            default: return "No unit given"; // Default message if no match
        }
    }

    // Method to get the full name of the converted unit with the correct prefix
    public String newUnit() {
        switch (convert) {
            case "k": return "kilo" + unitName();  // e.g., "kilometres"
            case "c": return "centi" + unitName(); // e.g., "centimetres"
            case "m": return "milli" + unitName(); // e.g., "millimetres"
            case "d": return "deci" + unitName();  // e.g., "decimetres"
            case "D": return "deca" + unitName();  // e.g., "decametres"
            default: return unitName();            // Return original unit name if no conversion
        }
    }

    // Main method to test the Converter class
    public static void main(String[] args) {
        // Create an instance of Converter with "m" (meters) and a value of 12
        Converter Bob = new Converter("m", 12);

        // Retrieve the original value and unit
        Double origValue = Bob.getOriginalValue();
        String origDim = Bob.getUnit();

        // Convert the value to kilometers
        Double newValue = Bob.convertTo("k");
        String newUnit = Bob.newUnit();

        // Print the conversion result using formatted output
        System.out.printf("%.2f %s has been converted to %.5f %s\n", origValue, origDim, newValue, newUnit);
    }
}
