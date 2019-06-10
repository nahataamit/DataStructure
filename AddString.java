package otherProblems;

public class AddString {

    public String addStrings(String num1, String num2) {
//        int i = num1.length()-1;
//        int j = num2.length()-1;
//
//        int carry = 0;
//        int sum =0;
//
//        StringBuffer sb = new StringBuffer();
//
//        while(i>=0 || j>=0 || carry !=0){
//            sum = ((i>=0) ? (num1.charAt(i--) - '0') : 0 )+ ( (j>=0) ? (num2.charAt(j--)-'0') : 0);
//            sb.append(sum%10);
//            carry = sum/10;
//
//        }
//
//        return sb.reverse().toString();
//
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0, sum = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            sum = ((i >= 0) ? (num1.charAt(i--) - '0') : 0) + ((j >= 0) ? (num2.charAt(j--) - '0') : 0) + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        AddString addString = new AddString();
        System.out.println(addString.addStrings("222","19"));
    }
}
