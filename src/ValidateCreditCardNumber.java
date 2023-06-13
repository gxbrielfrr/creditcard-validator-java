public class ValidateCreditCardNumber {
    public static boolean validateCreditCard(String cardNumber) {
        cardNumber = cardNumber.replaceAll("[^0-9]", "");

        int [] cardDigits = new int [cardNumber.length()];
        int sumVerifier = 0;

        double remainderVerifier = 0;
        
        boolean shouldDouble = false;

        if(cardNumber.length() != 16) {
            return false;
        }

        for(int i = 0; i < cardDigits.length; i++) {
            char cardDigit = cardNumber.charAt(i);
            int digit = Character.getNumericValue(cardDigit);
            cardDigits[i] = digit;
        }


        for(int i = cardDigits.length - 1; i >= 0 ; i--) {
            int digit = cardDigits[i];

            if (shouldDouble && (digit = digit * 2) > 9) {
                digit = digit - 9;
            }
            
            sumVerifier = sumVerifier + digit;
            shouldDouble = !shouldDouble;
          }

        remainderVerifier = sumVerifier % 10;

        if(remainderVerifier == 0) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
       System.out.println(validateCreditCard("5102 1617 9997 3553"));
    }
}
