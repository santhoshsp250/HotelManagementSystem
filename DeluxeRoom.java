package hba;

class DeluxeRoom extends Room {
	 private boolean hasMiniBar;

	 public DeluxeRoom(int roomNo, double basePrice, boolean hasMiniBar) {
	     super(roomNo, "Deluxe", basePrice);
	     this.hasMiniBar = hasMiniBar;
	 }

	 @Override
	 public double computeBill(int nights) {
	     double extraCharge = hasMiniBar ? 500 : 0;
	     return (basePrice + extraCharge) * nights * 1.05;
	 }
	}
