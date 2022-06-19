package DP;

//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/target-sum-subsets-dp-official/ojquestion
public class targetsum_subset {
    // RECURSIVE APPROACH
    public static void targetsumsubsetrec(int arr[], int index, int sum, String ans, int target) {
        if (index >= arr.length) {
            if (sum == target) {
                System.out.println(ans);
            }
            return;
        }
        // CALL TO INCLUDE THE ELEMENT AT CURRENT INDEX
        targetsumsubsetrec(arr, index + 1, sum + arr[index], ans + arr[index] + " ", target);
        // CALL TO EXCLUDE THE ELEMENT AT CURRENT INDEX
        targetsumsubsetrec(arr, index + 1, sum, ans, target);
    }

    // DP APPROACH
    public static boolean targetsumsubsetDP(int arr[], int target) {
        int m = arr.length;
        boolean dp[][] = new boolean[m + 1][target + 1];// M IS NO.OF ELEMENTS IN GIVEN ARRAY
        for (int i = 0; i < dp.length; i++) { // TARGET IS GIVEN TARGET
            for (int j = 0; j < dp[0].length; j++) { // WE WILL MAKE THE GRID OF GIVEN NO'S+1 VS TARGET+1;
                if (i == 0 && j == 0) { // IF FIRST ELEMENT = TRUE BECAUSE EMPTY SET IS A SUBSET OF EVERY SET WHOSE SUM
                                        // IS 0.
                    dp[i][j] = true;
                } else if (j == 0) {
                    dp[i][j] = true;// FIRST COLOUMN IS TRUE ALWAYS BECAUSE TARGET SUM IS 0;
                } else if (i == 0) {
                    dp[i][j] = false; // ALL VALUES OF FIRST ROW EXCEPT FIRST ELEMENT IS FALSE,BECAUSE FIRST ELEMENT
                                      // IS EMPTY
                } else {
                    if (dp[i - 1][j] == true) { // IF AT PREVIOUS ROW INDEX i.e(WHEN ELEMENT OF ARRAY INDEX IS NOT GOING
                                                // TO PARTICIPATE ) IF THAT VALUE IS TRUE THE CURRENT DP ARRAY INDEX
                                                // VALUE IS TRUE;
                        dp[i][j] = true;
                    } else {
                        int val = arr[i - 1];

                        if (j >= val) { // CURRENT ELEMENT OF ARRAY SHOULD BE GREATER THAN OR EQUAL TO CURRENT J OF DP
                                        // ARRAY .
                            if (dp[i - 1][j - val] == true) {// IF CURRENT ELEMENT ARRAY INDEX IS GOING TO PARTICIPATE
                                                             // THEN SUBTRACT THAT ELEMENT FROM J OF DP ARRAY i.e
                                                             // CURRENT TARGET
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        return dp[m][target];
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 7, 1, 3 };
        int target = 10;
        targetsumsubsetrec(arr, 0, 0, " ", target);
        System.out.println(targetsumsubsetDP(arr, target));
    }

}
