package com.netcrackerpractice.startup_social_network.repository;

import com.netcrackerpractice.startup_social_network.entity.Startup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface startupRepository extends JpaRepository<Startup, Long> {

}
