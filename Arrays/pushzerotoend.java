//https://www.codingninjas.com/codestudio/problems/push-zeros-to-end_583?leftPanelTab=1
package Arrays;
public class pushzerotoend {
 
    public static void pushZerosAtEnd(int[] arr) { // using arrayrotation concept
        int rot = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[rot++] = arr[i];
            }
        }
        for (int i = rot; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

}
