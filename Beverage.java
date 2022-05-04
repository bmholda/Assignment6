public abstract class Beverage {
        private String beveragename;
        private TYPE beveragetype;
        private SIZE beveragesize;
        private final double startingprice = 2.0;
        private final double startingsizeprice = 1.0;
        public Beverage(String bevname, TYPE bevtype, SIZE bevsize) {
                beveragename = bevname;
                beveragetype = bevtype;
                beveragesize = bevsize;
        }
        
        public abstract double calcPrice();
        public boolean equals(Beverage bev) {
                if (beveragetype == bev.getType() && beveragesize == bev.getSize() && beveragename.equals(bev.getBevName())) {
                        return true;
                }
                else {
                        return false;
                }
        }
        public String getBevName() {
                return beveragename;
        }
        public void setName(String bevname) {
            beveragename = bevname;
        }
        public TYPE getType() {
                return beveragetype;
        }
        public void setType(TYPE bevtype) {
    		beveragetype= bevtype;
        }
        public SIZE getSize() {
                return beveragesize;
        }
        public void setSize(SIZE bevsize) {
    		beveragesize = bevsize;
        }
        public double getBasePrice() {
                return startingprice;
        }
        public double getSizePrice() {
                return startingsizeprice;
        }
        public String toString() {
            return beveragename + " , with size " + beveragesize;
        }
        
}