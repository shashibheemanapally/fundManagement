package com.qwert.fm.txn;


import org.springframework.stereotype.Component;

@Component
public class TxnValidator {
	public boolean validate(Txn txn) {
		
		int k=(int)(Math.random()*10)+txn.getAmount();
		
		return k%2==0 ? true:false;
	}
}
