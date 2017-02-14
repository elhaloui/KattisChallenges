package Sellingspatulas;


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author F43538
 */
public class LogGenerator {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
       FileWriter writer = new FileWriter("sample.in"); 
      List<String> lines=new ArrayList<>();
        int minute=15;
        lines.add("15 0.37\n");
        while((minute+=(int) (Math.random()*2)+1) < 1440)
          lines.add(minute+" "+(round(Math.random()*25-13,2))+"\n");
         
        writer.write(lines.size()+"\n");
       for(String s:lines) writer.write(s);
       writer.write("0");
       writer.close();
    }
    
    private static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
}
    
}
