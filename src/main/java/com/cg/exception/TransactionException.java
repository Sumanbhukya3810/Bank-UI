package com.cg.exception;

public class TransactionException extends Exception {
	String msg;
	public TransactionException(String msg)
	{
		this.msg=msg;
		
	}
}
