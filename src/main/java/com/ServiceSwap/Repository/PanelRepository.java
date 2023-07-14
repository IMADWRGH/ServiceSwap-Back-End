package com.ServiceSwap.Repository;

import com.ServiceSwap.Model.Panel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanelRepository extends JpaRepository<Panel,Integer> {
}
