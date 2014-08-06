package net.yasite.model;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;


public class CFunction {
	 public static boolean checkTextMax(String str,int length){
	        if(str.length() > length)
	        {
	            return true;
	        }else{
	            return false;
	        }
	    }
	    public static boolean checkTextMin(String str,int length){
	        if(str.length() < length)
	        {
	            return true;
	        }else{
	            return false;
	        }
	    }
	    public static boolean checkText(String str,int length){
	        if(str.length() == length){
	            return true;
	        }else{
	            return false;
	        }
	    }
	    public static String fileSizeChange(Long size){
	        DecimalFormat df = new DecimalFormat("0.00");
	        if(size <= 1024){
	            return "1KB";
	        }else if(size <= 1048576){
	            return df.format((double)(size) / 1024) + "KB";
	        }else{
	            return df.format((double)(size) / 1024 / 1024) + "MB";
	        }
	    }
	    public static String fileSizeChangeKB(Long size){
	        DecimalFormat df = new DecimalFormat("0.00");
	        if(size <= 1024){
	            return size + "KB";
	        }else{
	            return df.format((double)(size) / 1024) + "MB";
	        }

	    }
}
