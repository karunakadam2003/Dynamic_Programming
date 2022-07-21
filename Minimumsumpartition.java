/*
Given an array arr of size N containing non-negative integers, the task is to divide it into two sets S1 and S2 
such that the absolute difference between their sums is minimum and find the minimum difference
*/

class Solution

{
      
    public ArrayList<Integer> SubsetSum(int n,int arr[],int sum){
        // 2D Matrix[n+1][sum+1] 
        boolean t[][] = new boolean [n+1][sum+1];
        
        for(int i = 0;i<n+1;i++){
            for(int j =0;j<sum+1;j++){
                if(i == 0){
                    t[i][j] = false;
                    
                }
                if(j == 0){
                    t[i][j] = true;
                    
                        
                }
            }
        }
        
         for(int i = 1;i<n+1;i++){
            for(int j =1;j<sum+1;j++){
                
                if(arr[i-1] <= j){
                    t[i][j] = (t[i-1][j-arr[i-1]]  || t[i-1][j]);
                    
                }else{
                    t[i][j] =  t[i-1][j];
                }
                
            }
        }
        ArrayList<Integer> al = new  ArrayList<Integer>();
        
        // Getting only last row till sum(range)/2
        for(int i =0;i<=((sum)/2);i++){
           if(t[n][i] == true){
         //   System.out.println(i);
               al.add(i);
               
           }
        }
        
        return al;
        
        
        
    }

	public int minDifference(int arr[], int n) 
	{ 
	    int mn = Integer.MAX_VALUE;
	    ArrayList<Integer> al = new  ArrayList<Integer>();
	    int sum =0;
	    for(int i =0;i<n;i++){
	        sum += arr[i];
	        
	    }
        al = SubsetSum( n,arr, sum);
    
    // To Minimize (s1-s2) or (s2-s1)
    // range - s1 - s1
    // range - 2s1 
    <0 1 2 3 4 5 ........ range>
        
	    for(int i =0;i<al.size();i++){
	        
	        mn  = Math.min(mn,(sum -(2 * al.get(i) )));
	        
	    }

	    
	    return mn;
	    
	   
	} 
}

