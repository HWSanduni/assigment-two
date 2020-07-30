package dao;

import dao.custom.impl.CustomerDAOImpl;
import dao.custom.impl.ItemDAOImpl;
import dao.custom.impl.OrderDAOImpl;
import dao.custom.impl.OrderDetailsDAOImpl;

public class DAOFactroy {

    private static DAOFactroy daoFactroy;

    private DAOFactroy(){}

    public static DAOFactroy getInstance(){
        return (daoFactroy == null) ? daoFactroy = new DAOFactroy() : daoFactroy;
    }

    public <T extends SuperDAO> T getDAO (DAOType daoType){
        switch (daoType){
            case CUSTOMER:
                return (T) new CustomerDAOImpl();

            case ITEM:
                return (T) new ItemDAOImpl();

            case ORDER:
                return (T) new OrderDAOImpl();

            case ORDER_DETAILS:
                return (T) new OrderDetailsDAOImpl();
            default:
                return null;
        }
    }
}
