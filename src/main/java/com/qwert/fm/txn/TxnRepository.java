package com.qwert.fm.txn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TxnRepository extends JpaRepository<Txn, Long>{
		public List<Txn> findByStatus(String filterBy);
}
