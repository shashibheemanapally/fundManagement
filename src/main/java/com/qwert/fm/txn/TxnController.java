package com.qwert.fm.txn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TxnController {
	
	@Autowired
	private TxnService txnService;
	
	@RequestMapping("/sayHello")
	public String sayHello() {
		return "Hello..";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/txns")
	public String addTxn(@RequestBody Txn txn){
		Txn rtxn=txnService.addTxn(txn);
		return "Transaction added with status - "+rtxn.getStatus();
	}
	@RequestMapping("/txns")
	public List<Txn> getTxns(){
		return txnService.getAllTxns();
	}
	@RequestMapping("/txn/{id}")
	public Txn getTxn(@PathVariable Long id) throws Exception {
		
		return txnService.getTxn(id);
	}
	@RequestMapping("/txns/{filterBy}")
	public List<Txn> getTxns(@PathVariable String filterBy){
		return txnService.getTxnsByFilter(filterBy);
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/deleteTxn/{id}")
	public void deleteTxn(@PathVariable Long id){
		txnService.deleteTxn(id);
	}
}
