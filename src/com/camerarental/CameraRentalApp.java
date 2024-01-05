package com.camerarental;

import java.util.ArrayList;
import java.util.List;

public class CameraRentalApp {
    private List<Camera> availableCameras;
    private Wallet userWallet;

    public CameraRentalApp() {
        availableCameras = new ArrayList<>();
        userWallet = new Wallet();
    }
    public void addCamera(Camera camera) {
        availableCameras.add(camera);
    }

    public void removeCamera(int cameraIndex) {
        if (cameraIndex >= 1 && cameraIndex <= availableCameras.size()) {
            availableCameras.remove(cameraIndex - 1);
            System.out.println("Camera removed successfully.");
        } else {
            System.out.println("Invalid camera selection.");
        }
    }

    public void displayAvailableCameras() {
        if (availableCameras.isEmpty()) {
            System.out.println("No Data Present at This Moment.");
        } else {
            System.out.println("Available Cameras:");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------------------");
            for (int i = 0; i < availableCameras.size(); i++) {
                Camera camera = availableCameras.get(i);
                
                System.out.println( (i + 1) + ".   Brand: " + camera.getBrand() +
                        "     Model: " + camera.getModel() +
                        "     Rental Amount: $" + camera.getRentalAmount() + "   per day "+ checkAvailability(camera));
            }
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------------------");
        }
    }
    private String checkAvailability(Camera camera) {
    	
    	return camera.isRented()? "Rented":"availavle";
    }

    public void rentCamera(int cameraIndex) {
        if (cameraIndex >= 1 && cameraIndex <= availableCameras.size()) {
            Camera selectedCamera = availableCameras.get(cameraIndex - 1);
            if (userWallet.getBalance() >= selectedCamera.getRentalAmount()) {
                userWallet.setBalance(userWallet.getBalance() - selectedCamera.getRentalAmount());
                selectedCamera.setRented(true);
                System.out.println("Camera rented successfully!");
            } else {
                System.out.println("Insufficient Wallet Amount. Please deposit money.");
            }
        } else {
            System.out.println("Invalid camera selection.");
        }
    }


    public void depositMoney(double amount) {
        userWallet.deposit(amount);
        System.out.println("Deposit successful. Current wallet balance: $" + userWallet.getBalance());
    }

    public double checkWalletBalance() {
        return userWallet.getBalance();
    }

    
}
