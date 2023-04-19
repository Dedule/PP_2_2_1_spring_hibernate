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
      String HQL="FROM User u WHERE u.car.model=:carMod AND u.car.series=:carSer";
      return sessionFactory.getCurrentSession().createQuery(HQL, User.class).setParameter("carMod", mod)
              .setParameter("carSer", ser).uniqueResult();

   }

}
