package AnotherMain;
import java.io.*;
import java.util.ArrayList;
class main {
    public static void WriteFile(String fileName, ArrayList<String> data){
        try{
            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fileName);
            for(int i =0; i<data.size();i++){
                pw.println(data.get(i));
            }
            pw.close();
        }
        catch(Exception e){
            System.out.println("Error writting to file " +fileName);
        }
    }
    public static void main(String[] args){
        //create some data
        ArrayList<String> items=new ArrayList<String>();
        items.add("Bread");
        items.add("MIlk");
        items.add("Pasta");
        items.add("Bresdaad");
        //output to screen
        for(int i =0; i<items.size();i++){
            System.out.println(items.get(i));
        }
        //output to File

        WriteFile("Shopping.txt",items);
    }
}
