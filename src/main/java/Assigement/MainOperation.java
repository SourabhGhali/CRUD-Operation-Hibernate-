package Assigement;

import Domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class MainOperation {
   static void UpdatePrice(int id, double price){
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
//step1-->activate hibernate framework
        cfg = new Configuration();
        cfg = cfg.configure();
//step2-->establish communication
        factory = cfg.buildSessionFactory();
//step3-->satrt the session
        ses = factory.openSession();
//step4-->load the object
        Product p=ses.load(Product.class,id);
        p.setProductPrice(price);
//step5-->start the transction
        tx=ses.beginTransaction();
        ses.update(p);
        tx.commit();
       System.out.println("product details update sucessfully");
    }
    static void UpdateCategory(String name , int id){
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
//step1-->activate hibernate framework
        cfg = new Configuration();
        cfg = cfg.configure();
//step2-->establish communication
        factory = cfg.buildSessionFactory();
//step3-->satrt the session
        ses = factory.openSession();
//step4-->load the object
        Product p=ses.load(Product.class,id);
        p.setProductCategory(name);
//step5-->start the transction
        tx=ses.beginTransaction();
        ses.update(p);
        tx.commit();
        System.out.println("product details update sucessfully");
    }
    static void UpdateName(int id,String name){
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
//step1-->activate hibernate framework
        cfg = new Configuration();
        cfg = cfg.configure();
//step2-->establish communication
        factory = cfg.buildSessionFactory();
//step3-->satrt the session
        ses = factory.openSession();
//step4-->load the object
        Product p=ses.load(Product.class,id);
        p.setProductName(name);
//step5-->start the transction
        tx=ses.beginTransaction();
        ses.update(p);
        tx.commit();
        System.out.println("product details update sucessfully");
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the id to Modify the records");
        int id=sc.nextInt();
        System.out.println("which field need to modify");
        System.out.println("1-->Modify Name\n2-->Modify category\n3-->Modify Price");
        int choice=sc.nextInt();
        if(choice==1){
            System.out.println("Enter new Product Name");
            String name=sc.next();
            UpdateName(id,name);
        } else if (choice==2) {
            System.out.println("Enter new Product Category");
            String name=sc.next();
            UpdateCategory(name,id);
        }else if (choice==3){
            System.out.println("Enter new Product Price");
            double price=sc.nextDouble();
            UpdatePrice(id,price);
        }else {
            System.out.println("invalid option");
        }
    }
    }
