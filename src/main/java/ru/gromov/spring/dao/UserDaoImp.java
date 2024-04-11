package ru.gromov.spring.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import ru.gromov.spring.model.User;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public List<User> getUserList() {
      TypedQuery<User> query = entityManager.createQuery("from User", User.class);
      return query.getResultList();
   }

   @Override
   public User getUser(long id){
      return entityManager.find(User.class, id);
   }

   @Override
   public void saveUser(User user){
      entityManager.persist(user);
   }

   @Override
   public void deleteUser(long id) {
      Query query = entityManager.createQuery("delete from User u where u.id = :id");
      query.setParameter("id", id);
      query.executeUpdate();
   }

   @Override
   public void updateUser(User user){
      entityManager.merge(user);
   }
}
