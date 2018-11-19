/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
import java.util.*;
public class CS110_Project_Montoya_Patajo_Salvador_Commands {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        String[] com = command.split(" ");
        if(com[0].equals("insert")) Insert(com[1],com[2]);
        else if(com[0].equals("update")) Update(com[1],com[2]);
        else if(com[0].equals("select")) Select(com[1]);
        else if(com[0].equals("exit")) Exit();
        else System.out.println("ERROR: invalid command.");
        
    }
    public static void Insert(String a, String b){
        int key = Integer.parseInt(a);
        String val = b;
        
    }
    public static void Update(String a, String b){
        int key = Integer.parseInt(a);
        String val = b;
        
    }
    public static void Select(String a){
        int key = Integer.parseInt(a);
        
        
    }
    public static void Exit(){
        
        
        
    }
}
