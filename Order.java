import java.util.ArrayList;
import java.util.Random;
public class Order implements OrderInterface, Comparable<Order> {
        private int ordernumber;
        private int ordertime;
        private DAY day;
        private Customer user;
        private ArrayList<Beverage> bev;
        public Order(int time, DAY currentday, Customer customer) {
        	ordertime = time;
            day = currentday;    
        	ordernumber = genOrderNum();
            bev = new ArrayList<>();
        	user = customer;
        }
        public Beverage getBeverage(int itemNum) {
            return bev.get(itemNum);
        }
        public boolean isWeekend() {
        	if (day == DAY.SUNDAY || day == DAY.SATURDAY) {
        		return true;
        	}else {
        		return false;
        	}
        }
        public int genOrderNum() {
        	Random generatednumber = new Random();
        	int number = generatednumber.nextInt(90000-10000)+10000;
        	return number;
        }
        public int compareTo(Order order) {
        	if (ordernumber > order.getOrderNo()) {
        		return 1;
        	}
        	else if (ordernumber == order.getOrderNo()) {
        		return 0;
        	}
        	else {
        		return -1;
        	}
        }
        public int findNumOfBeveType(TYPE ordertype) {
        	int total = 0;
        	for (Beverage beverage : bev) {
        		if (beverage.getType() == ordertype) {
        			total = total+1;
        		}
        	}
        	return total;
        }
        public double calcOrderTotal() {
        	double total = 0;
        	for (Beverage beverage : bev) {
        		total = total + beverage.calcPrice();
        	}
        	return total;
        }
        public int getTotalItems() {
                return bev.size();
        }
        public void addNewBeverage(String bevname, SIZE bevsize, boolean coffee, boolean syrup) {
        	Coffee coffeecup = new Coffee(bevname, bevsize, coffee, syrup);
        	bev.add(coffeecup);
        }
        public void addNewBeverage(String bevname, SIZE bevsize, int fruits, boolean protein) {
        	Smoothie smoothies = new Smoothie(bevname, bevsize, fruits, protein);
        	bev.add(smoothies);
        }
        public void addNewBeverage(String bevname, SIZE bevsize) {
        	boolean isWeekend = false;
        	if (day == DAY.SUNDAY || day == DAY.SATURDAY) {
        		isWeekend = true;
        	}
        	Alcohol alch = new Alcohol(bevname, bevsize, isWeekend);
        	bev.add(alch);
        }
        public DAY getOrderDay() {
        	return day;
        }
        public int getOrderNo() {
        	return ordernumber;
        }
        public int getOrderTime() {
        	return ordertime;
        }
        public ArrayList<Beverage> getBeverages() {
            return bev;
        }
        public void setOrderNum(int number) {
            ordernumber = number;
        }
        public void setOrderTime(int time) {
            ordertime = time;
        }
        public Customer getCustomer() {
        	return new Customer(user);
        }
        public void setOrderDay(DAY dayoforder) {
                day = dayoforder;
        }
        public void setCustomer(Customer custy) {
                user = custy;
        }
        public String toString() {
            String order = "-----------" +day.toString() +" time: " +ordertime + " \n " + user.toString() + " Order#: " +ordernumber;
            for (Beverage beverage : bev) {
                    order = order + ( " \n " + bev.toString());
            }
            order = order + ( " \n total: " +calcOrderTotal());
            return order;
        }
}