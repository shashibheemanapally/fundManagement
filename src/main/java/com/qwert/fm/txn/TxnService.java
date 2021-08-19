package com.qwert.fm.txn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class TxnService {
	@Autowired
	private TxnRepository txnRepository;
	@Autowired
	private TxnValidator txnValidator;
	
	public Txn addTxn(Txn txn) {
		
		if(txnValidator.validate(txn))
			txn.setStatus("success") ;
		else
			txn.setStatus("failed");
		
		return txnRepository.save(txn);
		
	}

	public List<Txn> getAllTxns() {
		List<Txn> txns=new ArrayList<>();
		txnRepository.findAll().forEach(txns::add);
		return txns;
	}

	public Txn getTxn(Long id) throws Exception {
		
		Optional<Txn> wTxn = txnRepository.findById(id);
		
		if(wTxn.isPresent()) {
			return wTxn.get();
		}
		else {
			throw new Exception("Transaction not found");
		}
		
	}

	public List<Txn> getTxnsByFilter(String filterBy) {
		List<Txn> txns=new ArrayList<>();
		txnRepository.findByStatus(filterBy).forEach(txns::add);
		return txns;
	}

	public void deleteTxn(Long id) {
		
		txnRepository.deleteById(id);
		
	}
	
}
