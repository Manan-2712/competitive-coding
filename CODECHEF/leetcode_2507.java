package CODECHEF;
//https://leetcode.com/contest/weekly-contest-324/problems/smallest-value-after-replacing-with-sum-of-prime-factors/
class leetcode_2507 {
    // first check for prime 
    public boolean isprime(int n ){
      if(n==2){
          return true;
      }
        for(int i=2;i<Math.sqrt(n)+1;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
}
// then get the first prime factor of n 
    public int getfirstprime(int n){
        if(isprime(n)){
            return n;
        }
        for(int i=2;i<n;i++){
            if(n%i==0){
                return i;
            }
        }
        return n;
    }
    // then repeatedly get the first prime factor of n after reducing n =n/m(m == first prime factor of n )
    public int getsumofprime(int n){
        int sum =0;
        while(!isprime(n)){
            int m = getfirstprime(n);
            n/=m;
            sum +=m;
        }
        sum +=n;
        return sum;
    }
    public int smallestValue(int n) {
        if(isprime(n)){
            return n;
        }     
        int sum = getsumofprime(n);
        if(sum ==n){
            return n ;
        }
        return smallestValue(sum);
        
    }
}