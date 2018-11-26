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
        RandomAccessFile rafbt = new RandomAccessFile(args[0], "rwd"); 
        RandomAccessFile rafval = new RandomAccessFile(args[1], "rwd"); 
        File f = new File(args[0]);
        /*if(f.exists() && !f.isDirectory()) { 
                rafbt=RandomAccessFile(args[0],"rwd");
            }
            else{
                
            }*/
        int record = 0;
        Commands(rafbt,rafval,record);
        
        
        }
        
    
    public static void Commands(RandomAccessFile rafbt, RandomAccessFile rafval, int record){
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        String[] com = command.split(" ");
        if(com[0].equals("insert")) {
            Insert(com[1],com[2],rafval, rafbt,record);
        }
        else if(com[0].equals("update")) Update(com[1],com[2]);
        else if(com[0].equals("select")) Select(com[1],rafval,rafbt,record);
        else if(com[0].equals("exit")) Exit(rafval);
        else System.out.println("ERROR: invalid command.");
        
    }
    public static void Insert(String a, String b, RandomAccessFile RAF,RandomAccessFile RAFbt, int record){
        long key = Integer.parseInt(a);
        {
        
        String val = b;
        try{
            record+=1;
        RAF.seek(0);
        record = RAF.read();
        RAF.writeByte(record);
        RAF.seek(8+record*256);
        RAF.writeByte(val.length());
        RAF.writeBytes(val);
        
        System.out.printf("%s inserted at %d", val,key);
        
        }catch(IOException ae){
            System.out.println("IO Error at Insert");
        }
        }
        
        {
            
            
            try{
            RAFbt.writeLong(key);
            RAFbt.writeLong(record);
            
            
            } 
              catch (IOException ae)
            {
                System.out.println("File not found");
            }
            
        }
        Commands(RAFbt,RAF,record);
    }
    public static void Update(String a, String b){
        int key = Integer.parseInt(a);
        String val = b;
        
    }
    public static void Select(String a, RandomAccessFile RAF,RandomAccessFile rafbt, int record){
        int key = Integer.parseInt(a);
        try{
            rafbt.seek(1);
            RAF.seek(8+256);
        System.out.println(rafbt.read());
        System.out.println(RAF.read());
        System.out.println(RAF.readLine());
        }catch(IOException io){
            System.out.println("error at select");
        }catch(Exception z){
            System.out.println("Some error");
        }
        Commands(rafbt,RAF,record);
    }
    public static void Exit(RandomAccessFile RAF){
        
        try{
            System.out.println("Exiting");
        RAF.close();
       
        }catch(IOException ae){
            System.out.println("Error at Exit");
        }
        
    }
    
}
