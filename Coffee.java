public class Coffee extends Beverage{
        private boolean coffee;
        private boolean syrup;
        private final double coffeecost = .5;
        private final double syrupcost = .5;
        public Coffee(String bevname, SIZE bevsize, boolean coffeeshot, boolean syrupshot) {
        	super(bevname, TYPE.COFFEE, bevsize);
        	coffee  = coffeeshot;
        	syrup = syrupshot;
        }
        public double calcPrice() {
        	double total = super.getBasePrice();
        	if (super.getSize() == SIZE.MEDIUM) {
        		total = total + (super.getSizePrice());
        	}
        	else if (super.getSize() == SIZE.LARGE) {
        		total = total + (2 * super.getSizePrice());
        	}
        	if (coffee) {
        		total = (total + coffeecost);
        	}
        	else if (syrup) {
        		total = (total + syrupcost);
        	}
        	return total;
        }
        public boolean equals(Coffee coffeecup) {
        	if (syrup == coffeecup.getExtraSyrup() && super.equals(coffeecup) && coffee == coffeecup.getExtraShot()) {
        		return true;
        	}
        	else {
        		return false;
        	}
        }
        public void setExtraShot(boolean extracost) {
            coffee = extracost;
        }
        public void setExtraSyrup(boolean extracost) {
            syrup = extracost;
        }
        public boolean getExtraShot() {
                return coffee;
        }
        public double getShotCost() {
            return coffeecost;
        }
        public boolean getExtraSyrup() {
                return syrup;
        }
        public double getSyrupCost() {
                return syrupcost;
        }
        public String toString() {
        	String bevname = getBevName() +"  with size " +getSize();
        	if (coffee) {
        		bevname = bevname + " with coffee shot";
        	}
        	else if (syrup) {
        		bevname = bevname + " with syrup shot";
        	}
        	bevname  = bevname +  " cost is $" + calcPrice();
        	return bevname;
        }
}