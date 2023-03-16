package Demo;

import Domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Insert {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
//step1-->activate hibernate framework
        cfg=new Configuration();
        cfg=cfg.configure();
//step2-->establish communication
        factory=cfg.buildSessionFactory();
//step3-->satrt the session
        ses=factory.openSession();
//step4-->load the object
        Product p1=new Product();
        p1.setProductId(3);
        p1.setProductName("HP");
        p1.setProductCategory("Laptop");
        p1.setProductPrice(240000);
//step5-->start the transction
        tx=ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("Inserted Successfully");
    }
}
