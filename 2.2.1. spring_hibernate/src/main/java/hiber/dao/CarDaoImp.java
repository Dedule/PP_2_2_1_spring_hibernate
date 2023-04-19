package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImp implements CarDao {
    @Autowired
    private SessionFactory sf;
    @Override
    public void add(Car car) {

    }

    @Override
    public List<Car> listCars() {
        return null;
    }
}
