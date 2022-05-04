import java.util.ArrayList;

public class BevShop implements BevShopInterface{
        private int alcInOrder;
        private int orderID;
        private ArrayList<Order> orderlist;
        public BevShop() {
        	orderlist = new ArrayList<>();
        }
        public boolean validAge(int userage) {
        	if (userage >= MIN_AGE_FOR_ALCOHOL) {
        		return true;
        	}else {
        		return false;
        	}
        }
        public boolean eligibleForMore() {
        	if(alcInOrder < 3) {
        		return true;
        	}else {
        		return false;
        	}
        }
        public boolean validTime(int currentime) {
        	if (currentime <= MAX_TIME && currentime >= MIN_TIME ) {
        		return true;
        	}else {
        		return false;
        	}
        }
        public boolean isMaxFruit(int fruitcount) {
        	if(fruitcount > MAX_FRUIT) {
        		return true;
        	}else {
        		return false;
        	}
        }
        public void startNewOrder(int currenttime, DAY currentday, String name, int age) {
        	alcInOrder = 0;   
        	Customer custy = new Customer(name, age);
        	Order cart = new Order(currenttime, currentday, custy);
        	orderlist.add(cart);
        	orderID = orderlist.indexOf(cart);
        }
        public void processSmoothieOrder(String name, SIZE bevsize, int fruits, boolean protein) {
        	orderlist.get(orderID).addNewBeverage(name, bevsize, fruits, protein);
        }
        public void processAlcoholOrder(String name, SIZE bevsize) {
        	alcInOrder = alcInOrder + 1;
            orderlist.get(orderID).addNewBeverage(name, bevsize);
        }
        public void processCoffeeOrder(String name, SIZE bevsize, boolean coffee, boolean syrup) {
        	orderlist.get(orderID).addNewBeverage(name, bevsize, coffee, syrup);
        }
        public int findOrder(int ordernumber) {
        	for (int i = 0; i < orderlist.size(); i++) {
        		if (orderlist.get(i).getOrderNo() == ordernumber) {
        			return i;
        		}
        	}
                return -1;
        }
        public int totalNumOfMonthlyOrders() {
            return orderlist.size();
        }
        public double totalOrderPrice(int ordernumber) {
        	double total = 0;
        	for (Order current : orderlist) {
        		if (current.getOrderNo() == ordernumber) {
        			for (Beverage beverages : current.getBeverages()) {
        				total = (total +  beverages.calcPrice());
        			}
        		}
        	}
        	return total;
        }
        public double totalMonthlySale() {
        	double total = 0;    
        	for (Order current : orderlist) {
        		for (Beverage beverages : current.getBeverages()) {
        			total = (total +  beverages.calcPrice());
        		}
        	}
                return total;
        }
        public Order getOrderAtIndex(int orderplace) {
            return orderlist.get(orderplace);
        }
        public Order getCurrentOrder() {
            return orderlist.get(orderID);
        }
        public void sortOrders() {
        	for (int l = 0; l < orderlist.size()-1; l++) {
        		int lowestindex = l;
        		for (int k = l+1; k < orderlist.size(); l++) {
        			if (orderlist.get(k).getOrderNo() < orderlist.get(lowestindex).getOrderNo()) {
        				lowestindex = k;
        			}
        		}
        		Order currentorder = orderlist.get(lowestindex);
        		orderlist.set(lowestindex, orderlist.get(l));
        		orderlist.set(l, currentorder);
        	}
        }
        public int getMaxOrderForAlcohol() {
            return MAX_ORDER_FOR_ALCOHOL;
        }
        public int getNumOfAlcoholDrink() {
                return alcInOrder;
        }
        public int getMinAgeForAlcohol() {
                return MIN_AGE_FOR_ALCOHOL;
        }
        public String toString() {
        	String orders = "This months Orders: \n";
        	for (Order totalorders : orderlist) {
        		orders += totalorders.toString();
        	}
        	orders += "Current Sale: " + totalMonthlySale();
        	return orders;
        }
}