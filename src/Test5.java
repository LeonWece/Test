
public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  int a[]={1,2,3,4,5};
		  int b[]={7,5,8,4,6};

		  int temp[]=new int[a.length+b.length];

		  //连接两个数组
		  for(int i=0;i<a.length;i++){
		    temp[i]=a[i];
		  }
		  for(int i=0;i<b.length;i++){
		    temp[a.length+i]=b[i];
		  }

		  //连接数组完成,开始清除重复元素
		  int size=temp.length;
		  for(int i=0;i<temp.length;i++){
		   if(temp[i]!=-1){
		     for(int j=i+1;j<temp.length;j++){
		       if(temp[i]==temp[j]){
		         temp[j]=-1;//将发生重复的元素赋值为-1
		         size--;
		       }
		     }
		   }
		  }

		  int[] result=new int[size];
		  for(int i=0,j=0;j<size && i<temp.length;i++,j++){
		    if(temp[i]==-1){
		      j--;
		    }
		    else{
		      result[j]=temp[i];
		    }
		  }
		  
		  //冒泡排序（从小到大）
		  int tp;
		  for (int i = 0; i < result.length - 1; i++) {		
				for (int j= i+1; j < result.length; j++) {
					if (result[j] < result[i]) {
						tp = result[i];
						result[i] = result[j];
						result[j] = tp;
					}
				}	
			}

		  for (int i : result) {
			  System.err.println(i);
		}
		  
		 
		
	}

}
