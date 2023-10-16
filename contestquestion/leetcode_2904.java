package contestquestion;
public class leetcode_2904 {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String res = "";
//int i = 0;
        int j = 0;
        int count = 0;
        for(int i= 0;i<n;i++){
            if(s.charAt(i) =='1'){
                count ++;
            }
          
            if(count == k){
                while(j < n && count == k){
                    String temp = s.substring(j,i+1);
                    if(res.isEmpty() || temp.length() < res.length()){
                        res = temp;
                    }
                    else if(temp.length() == res.length()){
                        res = (res.compareTo(temp) < 0) ? res: temp;
                    }
                    if(s.charAt(j) == '1'){
                        count--;
                    }
                    j++;
                }
            }
            
            
            
        }
        return res;
        
        
        
        
    }
}