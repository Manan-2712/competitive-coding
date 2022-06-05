//https://www.interviewbit.com/problems/step-by-step/hints/
package Interviewbit.maths;

public class stepbystep {

    public int solve(int A) {
        // O(n)approach
        A = Math.abs(A);
        // int i=0;
        // int running_sum =0;
        // while(running_sum<A){
        // i+=1;
        // running_sum+=i;
        // }
        // while((running_sum - A)%2!=0){ // // value to be removed has to be even
        // // //because to remove y from running sum we have to
        // // // remove y/2 from sequence.(where y= overshooted value )
        // i+=1;
        // running_sum+=i;
        // }

        // return i;

        // return -1;
        // 2ND METHOD
        // using -b+-(Math.sqrt(b*b-4ac))/2a;
        // this method will take our i to the nearest value of (n)whose sum of value is
        // equal to A;
        // and our running_sum is directly going to start from i*(i+1)/2;
        // eg take discriminant formula equal to 45 ;find n and find sum ;
        int i = ((int) (Math.sqrt(1 + 8 * A) - 1)) / 2;
        int running_sum = i * (i + 1) / 2;
        while (running_sum < A || (running_sum - A) % 2 != 0) {
            i += 1;
            running_sum += i;
        }
        return i;

    }
}
