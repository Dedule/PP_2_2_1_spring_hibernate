package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   public User getUserByCarModelAndId(String mod, int ser) {
      String HQL="FROM Car car WHERE car.model=:carMod AND car.series=:carSer";
      Car car = sessionFactory.getCurrentSession().createQuery(HQL, Car.class).setParameter("carMod", mod)
              .setParameter("carSer", ser).uniqueResult();
      return car.getUser();
   }


}
