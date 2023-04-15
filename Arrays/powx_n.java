package Arrays;
//https://leetcode.com/problems/powx-n/description/
public class powx_n {
        public double myPow(double x, int n) {
            // Brute Force 
            // int nn =n;
            // if (nn < 0){
            //     nn = -1*nn;
            // }
            // double ans =1;
            // for(int i=0;i<nn;i++){
            //    ans = ans*x;
            // }
            // if(n < 0){
            //     ans = 1/ans;
            // }
            // return ans;
    
            // OPTIMAL SOLUTION
            
             long nn = n;
             if(nn < 0){
                 nn = -1*nn;
             }
                double ans =1.0;
             while( nn > 0){
                if(nn %2 ==1){
                    ans = ans *x;
                    nn = nn-1;
                }
                else {
                    x = x *x;
                    nn = nn/2;
                }
             }
             if( n < 0){
                 ans = (double)1.0/ (double)ans;
             }
             return ans;
      
                    
            
    }
    }

