package hba;

class SuiteRoom extends Room {
	 private boolean hasLivingRoom;

	 public SuiteRoom(int roomNo, double basePrice, boolean hasLivingRoom) {
	     super(roomNo, "Suite", basePrice);
	     this.hasLivingRoom = hasLivingRoom;
	 }

	 @Override
	 public double computeBill(int nights) {
	     double extraCharge = hasLivingRoom ? 1000 : 0;
	     return (basePrice + extraCharge) * nights * 1.10; // 10% luxury tax
	 }
	}
