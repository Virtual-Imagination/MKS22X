import java.util.*;
import java.io.*;

public class Merge{

      public static void main(String[] args){
	    int[] test = new int[Integer.parseInt(args[0])];
	    for(int i =0; i < test.length; i++){
		Random seed= new Random();
		int num=seed.nextInt((Integer.parseInt(args[1])));
		if(seed.nextBoolean()){
		    num*=-1;
		}
		test[i]=num;
	    }

	    System.out.println("Test:"+"\n"+toString(test));
	    mergesort(test);
	    System.out.println("Test:"+"\n"+toString(test));
	    System.out.println("Test:"+"\n"+toString(arr));		   
      }

    public static String toString(int[] list){
	String s="[";
	for (int i = 0; i < list.length-1; i++){
		s+=""+list[i]+",";	    	    
	}
	
	s+=""+list[list.length-1]+"]";
	return s;
    }
    
    public static void mergesort(int[] data){
	int [] temp= new int[data.length];
	msort(data,temp, 0, data.length-1);
    }
    
    private static void msort(int [] data, int [] temp, int lo, int hi){
	if(lo<hi){
	    for(int i=0; i< data.length;i++){
		temp[i]=data[i];

	    }
	    int mid = (hi+lo)/2;
	    msort(data,temp,lo,mid);
	    msort(data,temp,mid+1,hi);
	    merge(data,temp,lo,mid,hi);
	}
	
    }

    
  
    private static void merge(int [] x, int [] y, int lo,int mid, int hi){
	int pos=lo;
	int m2=mid+1;
	while(lo<=mid && m2<=hi){
	    if(y[lo]<=y[m2]){
		x[pos]=y[lo];
		lo++;
	    }	    
	    else{
		x[pos]=y[m2];
		m2++;
	    }
	    pos++;
	}
	while (lo <= mid){
            x[pos] = y[lo];
            lo++;
            pos++;
        }
	while (m2 <=hi){
            x[pos] = y[m2];
            m2++;
            pos++;
        }
    }

    

}
