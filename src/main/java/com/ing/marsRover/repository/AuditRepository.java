package com.ing.marsRover.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ing.marsRover.dto.AuditNasaCalls;

/**
 * @author kalfie
 *
 */

@Repository
public interface AuditRepository extends JpaRepository<AuditNasaCalls, Long> {

}
