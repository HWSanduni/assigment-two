package test;


import dao.DAOFactroy;
import dao.DAOType;
import dao.custom.QueryDAO;
import entity.CustomEntity;

import java.util.List;

public class QueryDAOImplTest {
    public static void main(String[] args) {
        /// one
//    QueryDAO queryDAO = DAOFactroy.getInstance().getDAO(DAOType.QUERY);
//    CustomEntity ce = queryDAO.getOrderDetail2("OD001");
//
//        System.out.println("Customer Name : " + ce.getCustomerName());
//        System.out.println("Order ID : " + ce.getOrderId());
//        System.out.println("Order Date : " + ce.getOrderDate());
//        System.out.println("Customer ID: " + ce.getCusromerId());

        // two
        //    QueryDAO queryDAO = DAOFactroy.getInstance().getDAO(DAOType.QUERY);
//    CustomEntity ce = queryDAO.getOrderDetail2("OD001");
//
//        System.out.println("Customer Name : " + ce.getCustomerName());
//        System.out.println("Order ID : " + ce.getOrderId());
//        System.out.println("Order Date : " + ce.getOrderDate());
//        System.out.println("Customer ID: " + ce.getCusromerId());


        QueryDAO queryDAO = DAOFactroy.getInstance().getDAO(DAOType.QUERY);
        List<CustomEntity> list = queryDAO.getOrderTotal();
        for (CustomEntity ce:list) {
            System.out.println("Customer Name : " + ce.getCustomerName());
            System.out.println("Order ID : " + ce.getOrderId());
            System.out.println("Order Date : " + ce.getOrderDate());
            System.out.println("Customer ID: " + ce.getCusromerId());
            System.out.println("Total: " + ce.getTotal());
            System.out.println("----------------------------");
        }





    }

}