package exception;

import java.io.*;

import test.*;

public class MyException extends IOException{
	public MyException(Exception e, String s) {
		LogTest test = new LogTest();
		test.log(e, s);
	}

}
