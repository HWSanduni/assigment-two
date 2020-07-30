package dao;

import java.util.List;

public interface SuperDAO {

    public List<Object> findAll();
    public  Object find(Object pk);
    public  boolean save (Object obj);
    public  boolean update (Object obj);
    public  boolean delete (Object pk);

}
