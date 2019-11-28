/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdv.paradigmas;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Date;
import java.sql.Timestamp;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */
public class Log {
    private final String currentDirectory = System.getProperty("user.dir");

    public Log() throws IOException {
        File tmpDir = new File(this.currentDirectory + "/airport.log.lock");
        boolean exists = tmpDir.exists();
        System.out.println("En el directorio " + currentDirectory + ", existe un fichero airport.lock: " + exists);
        if (!exists)
            this.createLockFile();
        else{
            System.out.println("The program did not finish correctly in the last run");
            System.out.println("Creating error backup");
            File errorCopyFile = new File(this.currentDirectory + "/error-airport.log.lock");
            
        }
    }

    private void createLockFile() {
        try {
            File file = new File(this.currentDirectory + "/airport.log.lock");
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
