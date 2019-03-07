package com.dje.advice;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import com.dje.pojo.Users;

public class MyAfter implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		Logger logger=Logger.getLogger(MyAfter.class);
		Users users=(Users) arg2[0];
		if (logger!=null) {
			logger.info(users.getUsername()+"��¼�ɹ�");
		}else {
			logger.info(users.getUsername()+"��¼ʧ��");
		}		
	}	
}
