/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.thegriffins.cale.downloader;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

/**
 *
 * @author Cale
 */
public class Downloader {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("URL: " + args[0]);
        
        int slash = args[0].lastIndexOf('/');
        String name = args[0].substring(slash+1);
        System.out.println("Name: " + name);
        FileOutputStream file = new FileOutputStream(name);
        
        URL url = new URL (args[0]);
        InputStream stream = url.openStream();
        byte[] bytes=new byte[10000];
        int size = 0;
        
        while (true) {
            int got = stream.read(bytes);
            if (got<0) {
                break;
            }

            size = size + got;
            file.write(bytes,0,got); 
        }
        
        System.out.println("Size: " + size);        
        stream.close();        
        file.close();
        
    }
}
