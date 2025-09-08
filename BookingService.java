package hba;

import java.util.ArrayList;
import java.util.List;

class BookingService {
	 private List<Room> rooms;
	 private double totalRevenue;

	 public BookingService() {
	     rooms = new ArrayList<>();
	     totalRevenue = 0;
	 }

	 public void addRoom(Room room) {
	     rooms.add(room);
	 }

	 public void viewAvailability() {
	     System.out.println("\nAvailable Rooms:");
	     for (Room r : rooms) {
	         if (r.checkAvailability()) {
	             System.out.println("Room No: " + r.getRoomNo() + " | Type: " + r.getType() + " | Price: " + r.getBasePrice());
	         }
	     }
	 }

	 public void createBooking(int roomNo, int nights) {
	     for (Room r : rooms) {
	         if (r.getRoomNo() == roomNo && r.checkAvailability()) {
	             r.book();
	             double bill = r.computeBill(nights);
	             System.out.println("Bill for Room " + roomNo + ": ₹" + bill);
	             totalRevenue += bill;
	             return;
	         }
	     }
	     System.out.println("Room not available or not found.");
	 }

	 public void cancelBooking(int roomNo) {
	     for (Room r : rooms) {
	         if (r.getRoomNo() == roomNo && !r.checkAvailability()) {
	             r.cancel();
	             return;
	         }
	     }
	     System.out.println("No booking found for this room.");
	 }

	 public void dailyReport() {
	     int occupied = 0;
	     for (Room r : rooms) {
	         if (!r.checkAvailability()) occupied++;
	     }
	     System.out.println("\nDaily Report:");
	     System.out.println("Occupied Rooms: " + occupied);
	     System.out.println("Available Rooms: " + (rooms.size() - occupied));
	     System.out.println("Total Revenue: ₹" + totalRevenue);
	 }
	}

