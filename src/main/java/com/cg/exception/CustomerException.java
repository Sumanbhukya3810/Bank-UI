package com.cg.exception;

public class CustomerException extends Exception 
{
	String msg;
	public CustomerException(String msg)
	{
		this.msg=msg;
		
	}

}
