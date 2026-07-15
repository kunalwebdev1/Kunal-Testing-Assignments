package com.FileHandlingDemo.Examples;

import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {

        try {
            File myObj = new File("K:/files/kunal.xlsx");

            if (myObj.delete()) {
                System.out.println("File deleted: " + myObj.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}