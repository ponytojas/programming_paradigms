/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdv.paradigmas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */
public class Log {
    private final String currentDirectory = System.getProperty("user.dir");
    private File log = new File(currentDirectory + "/airport.log");
    private Semaphore semaphore;

    public Log() throws IOException {
        this.semaphore = new Semaphore(1, true);

        if (!log.exists())
            this.createFile(false);
        else {
            File tmpDir = new File(this.currentDirectory + "/airport.log.lock");
            boolean exists = tmpDir.exists();
            System.out.println("En el directorio " + currentDirectory + ", existe un fichero airport.lock: " + exists);
            if (!exists)
                this.createFile(true);
            else {
                System.out.println("The program did not finish correctly in the last run");
                System.out.println("Creating error backup");
                File error = new File(this.currentDirectory + "/error-airport.log");
                InputStream is = null;
                OutputStream os = null;
                try {
                    is = new FileInputStream(this.log);
                    os = new FileOutputStream(error);
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = is.read(buffer)) > 0) {
                        os.write(buffer, 0, length);
                    }
                } finally {
                    is.close();
                    is = null;
                    os.close();
                    os = null;
                    error = null;
                    System.gc();
                }
            }
        }
    }

    private void createFile(boolean isLock) {
        if (isLock) {
            try {
                File file = new File(this.currentDirectory + "/airport.log.lock");
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                File fileLock = new File(this.currentDirectory + "/airport.log.lock");
                File fileLog = new File(this.currentDirectory + "/airport.log");
                fileLock.createNewFile();
                fileLog.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void writeToTheLog(String inputText, String inputType) {
        try {
            this.semaphore.acquire();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(currentDirectory + "/airport.log", true));
                Timestamp ts = new Timestamp(System.currentTimeMillis());

                switch (inputType) {
                case "Info":
                    inputText = ts + "  I/ " + inputText;
                    break;
                case "Error":
                    inputText = ts + "  E/ " + inputText;
                    break;
                default:
                    inputText = ts + "  W/ " + inputText;
                    break;
                }
                System.out.println(inputText);
                writer.append(inputText + "\n");
                writer.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.semaphore.release();
        }
    }
}
