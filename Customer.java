public class Customer {
        private String customername = " ";
        private int customerage = 0;
        public Customer(String name, int age) {
        	customername = name;
        	customerage = age;
        }
        public Customer(Customer customer) {
        	customername = customer.getName();
        	customerage = customer.getAge();
        }
        public String getName() {
        	return customername;
        }
        public int getAge() {
        	return customerage;
        }
        public void setName(String name) {
        	customername = name;
        }
        public void setAge(int age) {
        	customerage = age;
        }
        public String toString() {
            return customername + " and is " + customerage +"y/o";
    }
}