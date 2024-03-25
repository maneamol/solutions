public class ZigZagPrint {
    public String convert(String s, int numRows) {

        StringBuilder sb = new StringBuilder();
        int step = numRows + (numRows - 2);

        int currentIndex = 0;
        int temp = 0;
        for (int i = 0; i < numRows; i++) {
            currentIndex = i;
//            step = numRows + (numRows - 2) - i;
            while (currentIndex < s.length()) {
                sb.append(s.charAt(currentIndex));
                currentIndex += step;
                 if ( i != 0 && i != numRows - 1) {
                     temp = currentIndex - (2 * i);
                     if (temp < s.length()) {
                         sb.append(s.charAt(temp));
                     }
                 }
//                currentIndex += step;
//                System.out.println(currentIndex);
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        ZigZagPrint obj = new ZigZagPrint();
        obj.convert("PAYPALISHIRING", 3);
    }
}
