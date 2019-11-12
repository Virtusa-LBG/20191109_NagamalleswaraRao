/**
 * Converter to convert numbers to English words.
 * @author Nagamalleswara Rao
 *
 */
public class NumberToWordsConverter  {
    /**
     * String array to have all English words below number 20
     */
    private static final String[] oneDigitWords = { "", " one", " two", " three", " four", " five", " six", " seven", " eight",  " nine", " ten", 
    		" eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"  };
    
    /**
     * String array to have all English words below number 100 and they are divisible by 10
     */
    private static final String[] twoDigitWords = { "", " ten"," twenty"," thirty"," forty", " fifty", " sixty", " seventy", " eighty", " ninety"  };
    
    /**
     * String array to have all English words above number 1000 
     */    
    private static final String[] otherWords = { "", " thousand", " million", " billion"  };
    
    /**
     * Converts the given number that is less than 1000 to English words
     * @param number
     * @return converted word
     */
    private String convertNumber(int number) {
        String currentNumber;
        
        if (number % 100 < 20){
            currentNumber = oneDigitWords[number % 100];
            number /= 100;
        } else {
            currentNumber = oneDigitWords[number % 10];
            number /= 10;
            
            currentNumber = twoDigitWords[number % 10] + currentNumber;
            number /= 10;
        }
        if (number == 0) return currentNumber;
        return oneDigitWords[number] + " hundred" + currentNumber;
    }
    
    /**
     * Converts the given number to English words
     * @param number
     * @return the converted number
     */
    public String convert(int number) {

        if (number == 0) { return "zero"; }
        
        String prefix = "";
        
        if (number < 0) {
            number = -number;
            prefix = "negative";
        }
        
        String currentNumber = "";
        int position = 0;
        
        do {
            int n = number % 1000;
            if (n != 0){
                String s = convertNumber(n);
                currentNumber = s + otherWords[position] + currentNumber;
            }
            position++;
            number /= 1000;
        } while (number > 0);
        
        return (prefix + currentNumber).trim();
    }
    
    /**
     * Main method to call converter function
     * @param args
     */
    public static void main(String[] args) {    	
        NumberToWordsConverter converter = new NumberToWordsConverter();
        System.out.println("The number 967834528 is converto words:" + converter.convert(967834528));
        System.out.println("The number -55034 is converto words: " + converter.convert(-55034));
    }
}