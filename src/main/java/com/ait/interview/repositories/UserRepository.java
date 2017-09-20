package com.ait.interview.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.ait.interview.domain.User;
import com.ait.interview.domain.UserLocation;

@Transactional
public interface UserRepository extends Repository<User, Long> {
	List<User> getAllByLocationId(Long location_id);

	@Query(value = "select u.id as userId, u.username as userName, u.location as location, "
			+ " (select count(c) as count from Chat c where c.owner = u.id and c.status in (1,2) ) as countChat "
			+ " from User u "
			+ " inner join u.location l " 
			+ " where u.active in (1, 2) and (l.id = ?1 or l.parentId = ?1) and l.parentId <> 1"
			+ " group by u.id order by l.id DESC")
	public List<UserLocation> customUsersInLocation(Long locationId);

	public User findById(Long id);
}
