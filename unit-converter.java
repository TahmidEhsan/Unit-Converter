package tests;

class Converter{
    private String dimension;
    private double num;
    private String convert;

    public Converter(String dimension, double num) {
        this.dimension = dimension;
        this.num = num;
    }

    public double convertTo(String convert) { 
        this.convert = convert;
        switch(convert){
            case "k":return num/1000;
            case "c":return num*100;
            case "m":return num*1000;
            case "d": return num*10;
            case "D":return num/10;
          default:return num;
        }
    }

    public String getConvertedUnit(){
        return convert;
    }
    public String getUnit(){
        return dimension;
    }
    public double getOriginalValue(){
        return num;
    }
    public String unitName(){
        switch(dimension){
            case "m":return "metres";
            case "g":return "grams";
            case "L":return "litres";
            case "A": return "Amperes";
            case "mol":return "moles";
          default:return "No unit given";
        }
    }
    
    public String newUnit(){
        switch(convert){
            case "k":return "kilo"+unitName();
            case "c":return "centi"+unitName();
            case "m":return "milli"+unitName();
            case "d": return "deci"+unitName();
            case "D":return "deca"+unitName();
          default:return unitName();
        }
    }

    public static void main(String[] args){
        Converter Bob = new Converter("m",12);
        Double origValue = Bob.getOriginalValue();
        String origDim = Bob.getUnit();
        Bob.convertTo("k");
        Double newValue = Bob.convertTo("k");
        String newUnit = Bob.newUnit();
        
        
        System.out.printf("%.2f %s has been converted to %.5f %s\n",origValue,origDim,newValue,newUnit);
    }
}
