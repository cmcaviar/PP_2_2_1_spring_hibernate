package hiber.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;


   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "car_id")
   private Car empCar;

   @Autowired
   public User() {}
   
   public User(String firstName, String lastName, String email, Car car) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      empCar = car;
   }

   public Car getEmpCar() {
      return empCar;
   }

   public void setEmpCar(Car empCar) {
      this.empCar = empCar;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }


   @Override
   public String toString() {
      return "User " +
              "Id = " + getId() + "\n" +
              "First Name = " + getFirstName() + "\n" +
              "Last Name = " + getLastName() + "\n" +
              "E-mail = " + getEmail() + "\n" +
              "Car = " + getEmpCar();
   }
}
