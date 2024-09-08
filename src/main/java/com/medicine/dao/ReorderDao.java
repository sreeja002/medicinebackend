package com.medicine.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.medicine.entity.Reorder;

@Repository
public interface ReorderDao extends JpaRepository<Reorder,Long>{


}
