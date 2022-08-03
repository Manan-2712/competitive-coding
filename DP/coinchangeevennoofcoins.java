package DP;
/*
Problem:
	Coin change
	Given an unlimited supply of coins of given denominations,
	find the total number of ways to make a change of size n, by
	using an even number of coins.
	// 1, 3, 5, 10
	f[i][0] = f[i-1][1] + f[i-3][1] + f[i-5][1] + f[i-10][1]
	f[i][1] = f[i-1][0] + f[i-3][0] + f[i-5][0] + f[i-10][0]
*/
//https://www.youtube.com/watch?v=nbh8kfCJcb0&list=PLVrpF4r7WIhTT1hJqZmjP10nxsmrbRvlf&index=14
public class coinchangeevennoofcoins {
  public static int evenno_ofcoins(int n,int coins[]){ // 0= odd
    int dp [][]= new int [n+1][2];                     // 1= even  
    dp[0][0]=1;
    dp[0][1]=1;
    for(int i=1;i<=n;i++){
      for(int j=0;j<coins.length;j++){
        if(i-coins[j]>=0){
            dp[i][0]+= dp[i-coins[j]][1]; // after using denomination if before odd than it become even.
            dp[i][1]+= dp[i-coins[j]][0]; // after using denomination if before even than it become odd.
        
        }
      }
    }
    return dp[n][1];// condition to return even no.of coins
  }                 // if question demand is to return odd no. of coins just replace return codition with dp[n][0];
  public static void main(String[]args){
    int n = 6;
    int coins[]={1,3,5,10};
    System.out.println(evenno_ofcoins(n, coins));
    // when n ==6 . ways to change 6 using coins
    // (1,1,1,1,1,1), (1,1,1,3), (1,1,3,1), (1,3,1,1), (3,1,1,1), (3,3), (1,5), (5,1)
    // when n ==4 ,ways to change 4 using coins\
     // (1,1,1,1), (1,3), (3,1)

  }
}
