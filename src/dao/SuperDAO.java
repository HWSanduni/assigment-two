package dao;

import java.util.List;

public interface SuperDAO <T,ID> {

    public List<T> findAll();
    public  T find(ID pk);
    public  boolean save (T obj);
    public  boolean update (T obj);
    public  boolean delete (ID pk);

}
