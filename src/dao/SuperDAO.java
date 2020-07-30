package dao;

import entity.SuperEntity;

import java.io.Serializable;
import java.util.List;

public interface SuperDAO <T extends SuperEntity,ID extends Serializable> {

    public List<T> findAll();
    public  T find(ID pk);
    public  boolean save (T obj);
    public  boolean update (T obj);
    public  boolean delete (ID pk);

}
