
/**
 * Write a description of Quiz2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


import edu.duke.*;
import java.io.*;



public class Quiz2 {

    public void findAbc(String input){
        int index = input.indexOf("abc");
        while (true){
            if (index == -1 || index >= input.length() - 3){
                break;
            }
            
            System.out.println("temp = " + index);
            String found = input.substring(index+1, index+4);
            System.out.println(found);
            index = input.indexOf("abc",index+1);
        }
    }

    public void test(){
        //findAbc("abcd");
        System.out.println("== start test1 ==");
        findAbc("abcabcabcabca");
        System.out.println("== test2 ==");
        findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
    }   
    
}
