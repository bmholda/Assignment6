public class Smoothie extends Beverage{
        private int totalfruits;
        private boolean protein;
        private final double fruitcost = .5;
        private final double proteincost = 1.5;
        public Smoothie(String bevname, SIZE bevsize, int fruitcount, boolean proteincount) {
        	super(bevname, TYPE.SMOOTHIE, bevsize);
        	totalfruits = fruitcount;
        	protein = proteincount;
        }
        public boolean equals(Smoothie smoothie) {
                if (totalfruits == smoothie.getNumOfFruits() && super.equals(smoothie) && protein ==smoothie.getAddProtien()) {
                	return true;
                }
                else {
                	return false;
                }
        }
        public double calcPrice() {
                double total = super.getBasePrice();
                if(super.getSize() == SIZE.LARGE) {
                	total = total + (2 * super.getSizePrice());
                }
                else if (super.getSize() == SIZE.MEDIUM) {
                	total = (total + super.getSizePrice());
                }
                total = total + (  totalfruits * fruitcost) ;
                if (protein) {
                	total = total + ( proteincost) ;
                }
                return total;
        }
        public int getNumOfFruits() {
                return totalfruits;
        }
        public double getFruitCost() {
            return fruitcost;
        }
        public void setNumOfFruits(int fruitcount) {
            totalfruits = fruitcount;
        }
        public boolean getAddProtien() {
                return protein;
        }
        public double getProteinCost() {
            return proteincost;
        }
        public void setProteinPowder(boolean proteincount) {
                protein = proteincount;
        }
        public String toString() {
        	String beverage = getBevName() +" size is:  " +getSize() +" fruit count: " + totalfruits ;
                if (protein) {
                	beverage += " total protein ";
                }
                beverage = beverage + (" price is: $" + calcPrice());
                return beverage;
        }
}