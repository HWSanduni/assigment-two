package dao.custom.impl;

import dao.custom.QueryDAO;
import db.DBConnection;
import entity.CustomEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public CustomEntity getOrderDetail(String orderId) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT  o.id, c.name, o.date FROM `Order` o  \n" +
                    "INNER JOIN Customer c on o.customerId = c.id\n" +
                    "WHERE o.id=?");
            pstm.setObject(1,orderId);
            ResultSet rst = pstm.executeQuery();
            if (rst.next()){
                return new CustomEntity(rst.getString(1),
                        rst.getString(2),
                        rst.getString(3));
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public CustomEntity getOrderDetail2(String orderId) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.
                    prepareStatement("SELECT  c.id, c.name, o.id FROM `Order` o\n" +
                            "INNER JOIN Customer c on o.customerId = c.id\n" +
                            "WHERE o.id=?");
            pstm.setObject(1,orderId);
            ResultSet rst = pstm.executeQuery();
            if (rst.next()){
                return new CustomEntity(rst.getString(1),
                        rst.getString(2),
                        rst.getString(3));
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<CustomEntity> getOrderTotal() {
        try {

            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rst = statement.executeQuery("SELECT o.id,c.name,o.date,o.customerId,(od.qty * od.unitPrice) \n" +
                    "AS od_total from (( customer c INNER JOIN `order` o on c.id = o.customerId) \n" +
                    "INNER JOIN orderdetail od on o.id = od.orderId)");
            ArrayList<CustomEntity> customs = new ArrayList<>();
            while (rst.next()){
                customs.add(new CustomEntity(rst.getString(1),
                        rst.getString(2),
                        rst.getDate(3),
                        rst.getString(4),
                        rst.getDouble(5)));
            }
            return customs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
