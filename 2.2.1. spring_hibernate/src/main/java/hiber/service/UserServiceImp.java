package hiber.service;

import hiber.dao.UserDao;
import hiber.dao.UserDaoImp;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private final UserDao userDao;
   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }
   @Transactional
   @Override
   public void add(Car car) {
      userDao.add(car);
   }


   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public List<Car> listCars() {
      return userDao.listCars();
   }

   @Override
   public User getUserByCar(String model, int series) {
      return userDao.getUserByCarDao(model, series);
   }


}
