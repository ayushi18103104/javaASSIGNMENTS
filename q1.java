import java.util.Scanner;
class solution { 
      
    static int count(String pattern, String text) {         
        int psize = pattern.length();         
        int tsize = text.length();         
        int res = 0; 

        for (int i = 0; i <= tsize - psize; i++) { 
            int j;             
            for (j = 0; j < psize; j++) { 
                if (text.charAt(i + j) != pattern.charAt(j)) { 
                    break; 
                } 
            } 
            if (j == psize) {                 
                res++;                 
                j = 0;                 
            }             
        }         
        return res;         
    } 
    static public void main(String[] args) { 
        Scanner sc= new Scanner(System.in);
        String txt = sc.nextLine();         
        String pat = sc.nextLine();         
        System.out.println(count(pat, txt));         
    } 
} 