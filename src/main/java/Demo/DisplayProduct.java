package Demo;

import Domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DisplayProduct {
    public static void main(String[] args) {

            Configuration cfg;
            SessionFactory factory;
            Session ses;
            Transaction tx;
//activate hibernate framework
            cfg=new Configuration();
            cfg=cfg.configure();


//establish communication link
            factory= cfg.buildSessionFactory();
//start session
            ses= factory.openSession();

//read the data from table
            int id=1;
        Product p=ses.load(Product.class,id);
        System.out.println(p.getProductId());
        System.out.println(p.getProductName());
        System.out.println(p.getProductCategory());
        System.out.println(p.getProductPrice());
    }
}
