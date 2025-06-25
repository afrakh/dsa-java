public class Strings {

    //Count how many times lowercase vowels occurred in a String entered by the user
    public static int countVowels(String str){
        int count = 0;
        char chr;
        for(int i = 0; i < str.length(); i++){
            chr = str.charAt(i) ;
            if (chr == 'a' || chr == 'e' || chr == 'i' || chr == 'o' || chr == 'u'){
                count++;
            }
        }
        return count;
    }

    public static void equalComp(){
        String str1 = "Los Angeles";
        String str2 = "Dallas";
        String str3 = "Los Angeles";

        System.out.println(str1.equals(str2) + " " + str1.equals(str3));
    }

    public static void checkAnagrams(String str1, String str2){

    }

    public static void main(String args[]){
        int total = countVowels("New York");
        System.out.println(total);

        equalComp();

        String str = "DataStructuresandAlgorithms".replace("u","");
        System.out.println(str);
    }
        
}
