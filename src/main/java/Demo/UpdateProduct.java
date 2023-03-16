package Demo;

import Domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateProduct {
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
        //load te object
        int id=2;
        Product p=ses.load(Product.class,id);
        p.setProductName("Lenovo");

//start the transction
        tx= ses.beginTransaction();
        ses.update(p);
        tx.commit();
        System.out.println("product update sucessfully");



    }
}
