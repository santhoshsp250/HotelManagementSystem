package hba;

import java.util.*;

class Room {
 protected int roomNo;
 protected String type;
 protected double basePrice;
 protected boolean isAvailable=true;

 public Room(int roomNo, String type, double basePrice) {
     this.roomNo = roomNo;
     this.type = type;
     this.basePrice = basePrice;
 }

 public boolean checkAvailability() {
     return isAvailable;
 }

 public void book() {
     if (isAvailable) {
         isAvailable = false;
         System.out.println("Room " + roomNo + " booked successfully.");
     } else {
         System.out.println("Room " + roomNo + " is not available.");
     }
 }

 public void book(boolean withBreakfast) {  // Overloaded
     book();
     if (withBreakfast) {
         System.out.println("Breakfast included for Room " + roomNo);
     }
 }

 public void cancel() {
     isAvailable = true;
     System.out.println("Booking for Room " + roomNo + " cancelled.");
 }

 public double computeBill(int nights) {
     return basePrice * nights;
 }

 public int getRoomNo() { return roomNo; }
 public String getType() { return type; }
 public double getBasePrice() { return basePrice; }
 public boolean isAvailable() { return isAvailable; }
 public void setAvailable(boolean status) { this.isAvailable = status; }
}

