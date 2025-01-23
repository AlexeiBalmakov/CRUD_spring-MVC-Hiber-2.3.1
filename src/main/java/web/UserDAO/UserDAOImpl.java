package web.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.userconfig.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Service
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUser(int id) {
        return em.find(User.class, id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        em.persist(user);
    }
    @Transactional
    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        User user = em.find(User.class, id);
        if (user !=null){
            em.remove(user);
        }
    }
}
