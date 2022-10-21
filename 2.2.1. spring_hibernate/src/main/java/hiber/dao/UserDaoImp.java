package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


   private final SessionFactory sessionFactory;

   @Autowired
   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public void add(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }


   @Override
   public List<Car> listCars() {
      TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("FROM Car", Car.class);
      return query.getResultList();
   }


   @Override
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User", User.class);
      return query.getResultList();
   }


   @Override
   public User getUserByCarDao (String model, int series) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User AS user WHERE " +
              "user.empCar.model =:model AND user.empCar.series =:series", User.class);
      query.setParameter("model", model).setParameter("series", series);
      return query.getSingleResult();
   }

}
