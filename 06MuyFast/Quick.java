import java.util.*;
import java.io.*;


public class Quick{
    
    public static void main(String[] args){
	//	try{
	    int[] test = new int[Integer.parseInt(args[0])];
	    int[] test2 = new int[Integer.parseInt(args[0])];
	    for(int i =0; i < test.length; i++){
		Random seed= new Random();
		int num=seed.nextInt((Integer.parseInt(args[1])));
		if(seed.nextBoolean()){
		    num*=-1;
		}
		test[i]=num;
		test2[i]=num;

	    }
	    // System.out.println("PivAns:"+partition(test,0,test.length-1));
	    quicksort(test);
	    System.out.println("real:"+"\n"+toString(test));
	    //	    System.out.println("Before:"+"\n"+toString(test));
	    //	    quicksort(test);
	    //    System.out.println("After:"+"\n"+toString(test));
	    	    /*/	}
	catch(Exception IndexOutOfBounds){
	    System.out.println("After the file name insert the size of the array and the bounds for the numbers in the array"+"\n"+"EX: FileName 10 200"+"\n"+"Would give an array of size 10 with numbers ranging from -200 to 200");
	}
	/*/
    
    }

    
    public static void insertionSort(int[] data, int lo, int hi){
	for (int i=lo+1; i<=hi; ++i){
	    int sub = data[i];
	    int place = i;
	    while (place>lo && data[place-1] > sub){
		data[place] = data[place-1];
		place = place-1;
	    }
	    data[place] = sub;
	}
	
    }

    private static String toString(int[] list){
	String s="[";
	for (int i = 0; i < list.length-1; i++){
		s+=""+list[i]+",";	    	    
	}
	
	s+=""+list[list.length-1]+"]";
	return s;
    }
   
    public static int partition(int[] x,int lo, int hi){
	if(x.length<=1){
	    return lo;
	}
	Random seed= new Random();
	int piv=seed.nextInt((hi-lo));
	//	System.out.println(toString(x));
	swap(piv+lo,lo,x);
	int s2=lo;
	int i=lo+1;
	int a=x[lo];
	while(i<=hi){
	    //   System.out.println(toString(x));
	    if(x[i]< x[lo]){
		swap(i,s2,x);
		i++;
		s2++;
	    }
	    else if(x[i]>x [lo]){
		swap(i,hi,x);
		hi--;
	    }

	    else if(x[i]==x[lo]){
		i++;
	    }
	      
	}
	//	System.out.println(""+lo+","+hi);
	//	System.out.println("piv:"+a);
	
	
	return hi;
    }


    public static void quicksort(int[]ary){
	QSH(ary,0,ary.length-1);
    }

    private static void QSH(int ary[], int start, int end){
	if (end-start <= 30){
	    insertionSort(ary, start, end);
	}
	else if(end>start){
	       int i = (int)(Math.random() * ((end-start) + 1) + start);
	    int pivotal = ary[i];
	    int small = start;
	    int big = end;
	    int x = start + 1;

	    swap(ary, i, start);

	    //System.out.println(pivotal);
	    //toString(parti);

	    while (x <= big){
		//toString(parti);
		//System.out.println("LOL: "  + "small: " + small + " big: " + big + " i: " + i);
		//toString(parti);
		//System.out.println(pivotal);
		if (ary[x] < pivotal){
		    swap(ary, x, small);
		    small++;
		    x++;
		}
		else if (ary[x] == pivotal){
		    //System.out.println(i);
		    x++;
		    //toString(parti);
		    //System.out.println(pivotal);
		}
		else{
		    swap(ary, big, x);
		    big-=1;
		}
	    }
	    
	    QSH(ary,start,small-1);
	    QSH(ary,big+1,end);
	    
	}
    }

    private static void bs(int[] data){
 	for (int i=0; i <data.length-1;i++){
	    if(i<0)i=0;
 	    if (data[i]>data[i+1]){
 		int x=i;
 		while(x!=data.length-1 && data[x]>data[x+1]){
 		    int swap=data[x];
 		    data[x]=data[x+1];
		    data[x+1]=swap;
 		    x++;
 		    
 		}
 		i=i-2;
 	    }
	    
 	}
    }
    
    public static int quickselect(int[]ary, int k){
	return QSH(ary,k-1,0,ary.length-1);
    }

    private static int QSH(int[]ary, int k, int lo, int hi){
	int pos = partition(ary, lo, hi);
	if (pos-1 == k){
	    return ary[k];
	}
	if (k > pos+1){
	    return QSH(ary, k, pos + 1, ary.length -1);
	}
	if (k<pos-1){
	    return QSH(ary, k, 0, pos - 1);
	}
	
	return k;
	
    }

    public static void swap(int a, int b, int list[]){
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
    public static void swap(int list[], int a, int b){
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
}

