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
import java.io.File;
import java.io.RandomAccessFile; 
import java.io.*; 

public class CS110_Commands {
    public static void main(String args[]) throws FileNotFoundException {
        
        RandomAccessFile raf1 = new RandomAccessFile(args[0], "rwd"); 
        RandomAccessFile raf2 = new RandomAccessFile(args[1], "rwd"); 
        
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        String[] com = command.split(" ");
        if(com[0].equals("insert")) Insert(com[1],com[2],raf2);
        else if(com[0].equals("update")) Update(com[1],com[2]);
        else if(com[0].equals("select")) Select(com[1]);
        else if(com[0].equals("exit")) Exit();
        else System.out.println("ERROR: invalid command.");
        
    }
    
    public static void Insert(String a, String b, RandomAccessFile RAF){
        int key = Integer.parseInt(a);
        String val = b;
        try{
        RAF.writeByte(val.length());
        RAF.writeBytes(val);
        RAF.close();
        System.out.printf("%s inserted at %d", val,key);
        }catch(IOException ae){
            System.out.println("Something happened");
        }
        
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
