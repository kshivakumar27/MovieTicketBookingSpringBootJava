package com.ltts.bookticket.repo;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.ltts.bookticket.model.MovieBooking;

public interface Boookinrepo extends JpaRepository<MovieBooking, Integer> {
	
	@Query(value="select ntickets from Movie_Booking m where m.mname=?1 AND m.show_m=?2 AND m.dob=?3 AND m.type_m=?4",nativeQuery=true)
	public List<Integer> nticketsfinder( @RequestParam("mname")String mname,String show_m,Date dob,String type_m);
	
}
