public class Alcohol extends Beverage{
		private final double discount_weekend = .6;
		private boolean weekend;
		public Alcohol(String itemname, SIZE ordersize, boolean content) {
			super(itemname, TYPE.ALCOHOL, ordersize);
			weekend = content;
        }
        public boolean equals(Alcohol a) {
        	if (super.equals(a) && weekend == a.getIsWeekend()) {
        		return true;
        	}
        	else {
        		return false;
        	}
        }
        public double calcPrice() {
        	double startingprice = super.getBasePrice();
        	if (weekend == true) {
            	startingprice = startingprice + discount_weekend;
            }
                if (super.getSize() == SIZE.MEDIUM) {
                	startingprice = startingprice + super.getSizePrice();
                }
                else if (super.getSize() == SIZE.LARGE) {
                	startingprice = startingprice + ( 2 * super.getSizePrice());
                }
                return startingprice; 
        }
        public void setIsWeekend(boolean current) {
        	weekend = current;
        }
        public boolean getIsWeekend() {
                return weekend;
        }
        public double getWeekendFee() {
                return discount_weekend;
        }
        public String toString() {
            String beveragename = getBevName() + " size: " +getSize();
            if (weekend) {
                    beveragename = beveragename + " is Weekend!";
            }
            beveragename = beveragename +  " Cost is: $" +calcPrice();
            return beveragename;
    }
}