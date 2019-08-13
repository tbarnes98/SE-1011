package practice;

import java.util.Scanner;

public class alphabeticalOrder {
        public static void main(String[] args) {
            System.out.println("Enter a three letter word:");
            Scanner in = new Scanner(System.in);
            String word = in.next();
            char first = word.charAt(0);
            char second = word.charAt(1);
            char third = word.charAt(2);
            if(first<=second && second<=third){
                System.out.println("ALPHABETICAL ORDER");
            } else if(first>=second && second>=third){
                System.out.println("REVERSE ALPHABETICAL");
            } else {
                System.out.println("NOT IN ORDER");
            }
        }
    }


