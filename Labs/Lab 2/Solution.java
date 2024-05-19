import java.util.Arrays;

public class Solution{
    public static boolean isAnagram(String s, String t){
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        if(s.length()==t.length()){
            for(int i = 0;i<array1.length;i++){
                if(array1[i]!=array2[i]) return false;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "listen";
        String t = "silent";
        System.out.println(isAnagram(s, t));
        String a = "listen";
        String b = "silnt";
        System.out.println(isAnagram(a, b));
    }
}