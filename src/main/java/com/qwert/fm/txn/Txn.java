package com.qwert.fm.txn;




import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Txns")
public class Txn {
	
	/*
	 * {
	 * 
	 * "amount":"100", "fromMember":"a", "toMember":"b", "fromAccountNumber":"123",
	 * "toAccountNumber":"234", "status":"", "submittedDate":"10-10-2021"
	 * 
	 * }
	 */
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@CreationTimestamp
	@Column(name = "date")
	private Date date;
	@Column(name = "status")
	private String status;
	
	//inputs from post
	@Column(name = "amount")
	private int amount;
	@Column(name = "fromName")
	private String fromName;
	@Column(name = "toName")
	private String toName;
	@Column(name = "toAccNo")
	private long toAccNo;
	@Column(name = "fromAccNo")
	private long fromAccNo;
	
	
	
	
	
	
	public Txn() {
		
	}
	
	
	public Txn(long id, int amount, String fromName, String toName, long toAccNo, long fromAccNo, String status,
			Date date) {
		super();
		this.id = id;
		this.amount = amount;
		this.fromName = fromName;
		this.toName = toName;
		this.toAccNo = toAccNo;
		this.fromAccNo = fromAccNo;
		this.status = status;
		this.date = date;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String getFromName() {
		return fromName;
	}


	public void setFromName(String fromName) {
		this.fromName = fromName;
	}


	public String getToName() {
		return toName;
	}


	public void setToName(String toName) {
		this.toName = toName;
	}


	public long getToAccNo() {
		return toAccNo;
	}


	public void setToAccNo(long toAccNo) {
		this.toAccNo = toAccNo;
	}


	public long getFromAccNo() {
		return fromAccNo;
	}


	public void setFromAccNo(long fromAccNo) {
		this.fromAccNo = fromAccNo;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	
	
    
}
