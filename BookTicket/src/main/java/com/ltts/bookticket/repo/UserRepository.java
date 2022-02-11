package com.ltts.bookticket.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ltts.bookticket.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	public User findByEmail(String email);
	
	
	public static final SessionFactory sf = null;
	
	public static boolean process_register(User u) {
		System.out.println("Insise User-Beg");
		Session s=sf.openSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();
		s.close();
		System.out.println("Inside User Bo-End");
	  return false;
	}
	
	
	
	
	
	
}
