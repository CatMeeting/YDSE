package test;

import java.io.*;


public class LogTest {
	public void log(Exception eMessage, String s){
	    try{
	      File file = new File("D:\\workspace\\WebContent\\log\\test.txt");

	      if (checkBeforeWritefile(file)){
	        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

	        pw.println(s);
	        eMessage.printStackTrace(pw);

	        pw.close();
	      }else{
	        System.out.println("ファイルに書き込めません");
	      }
	    }catch(IOException e){
	      System.out.println(e);
	    }
	  }

	public void logException(Exception eMessage){
	    try{
	      File file = new File("D:\\workspace\\WebContent\\log\\error.txt");

	      if (checkBeforeWritefile(file)){
	        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

	        eMessage.printStackTrace(pw);

	        pw.close();
	      }else{
	        System.out.println("ファイルに書き込めません");
	      }
	    }catch(IOException e){
	      System.out.println(e);
	    }
	  }

	public void logText(String s){
	    try{
	      File file = new File("D:\\workspace\\WebContent\\log\\text.txt");

	      if (checkBeforeWritefile(file)){
	        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

	        pw.println(s);

	        pw.close();
	      }else{
	        System.out.println("ファイルに書き込めません");
	      }
	    }catch(IOException e){
	      log(e, "f");
	    }
	  }

	  private static boolean checkBeforeWritefile(File file){
	    if (file.exists()){
	      if (file.isFile() && file.canWrite()){
	        return true;
	      }
	    }

	    return false;
	  }

}
