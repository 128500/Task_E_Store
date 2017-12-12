package test;

/**
 * Created by KUDIN ALEKSANDR on 10.12.2017.
 */
public class Main {
    public static void main(String[] args) {
        Product p = new Product();
        int i = -258;
        System.out.println(i);
        i = p.getId();
        System.out.println(i);
    }

    static class Product{
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        private int id;
    }
}


