package dao.impl;

import dao.CustomerDAO;
import db.DBConnection;
import entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    public  List<Customer> findAllCustomers(){

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
            ArrayList<Customer> customers = new ArrayList<>();
            while (rst.next()){
                customers.add(new Customer(rst.getString(1),
                        rst.getString(2),
                        rst.getString(3)));
            }
            return customers;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }


    }

    public  Customer findCustomer(String id){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT FROM Customer where id=?");

            while (rst.next()){
                return (new Customer(rst.getString(1),
                        rst.getString(2),
                        rst.getString(3)));
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    public  boolean saveCustomer (Customer customer){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer VALUES (?,?,?)");

            preparedStatement.setObject(1,customer.getId());
            preparedStatement.setObject(2,customer.getName());
            preparedStatement.setObject(3,customer.getAddress());

            return preparedStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }


    }

    public  boolean updateCustomer (Customer customer){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customer SET name=?,address=? WHERE id=?");

            preparedStatement.setObject(3,customer.getId());
            preparedStatement.setObject(2,customer.getName());
            preparedStatement.setObject(1,customer.getAddress());

            return preparedStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public  boolean deleteCustomer (String id){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM customer WHERE id=?");
            preparedStatement.setObject(1,id);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    public  String getLastCustomerId() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM Customer ORDER BY id DESC LIMIT 1");
            if (!rst.next()){
                return null;
            }else{
                return rst.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }



}
