package com.omiphane.test;

import com.omiphane.service.NodeGroupService;
import com.omiphane.utilities.PageConstant;
import com.omiphane.utilities.XConverter;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class UserTest {

private NodeGroupService nodeGroupService;
	
	@Before
	public void before(){                                                                    

//		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/applicationContext.xml"
//				,"classpath:conf/spring-mybatis.xml"});
//		nodeGroupService = (NodeGroupService) context.getBean("userServiceImpl");
	}
	
	@Test
	public void addUser(){

		byte[] b= new byte[4];
		b[3] = (byte)0xd9;
		b[2] = (byte)0x1d;
		b[1] = (byte)0xc8;
		b[0] = (byte)0x01;
		int n = PageConstant.byte2Int(b);
		System.out.println(n);

	}

	@Test
	public void testConverter(){
		String str = "01A3DD";
		byte[] b = XConverter.hexStr2Bytes(str);
		System.out.println(XConverter.byte2HexStr(b,b.length));
		System.out.println(XConverter.hexStr2Str(str));
	}
}
