import java.util.*;
//leetcode 31
//https://leetcode.com/problems/palindrome-partitioning/description/
public class palindromepartitioning {
        public boolean palindrome(String s ,int start,int end){
            while(start <= end){
                if(s.charAt(start++)!= s.charAt(end--)){
                    return false;
                }
            }
            return true;
        }
        public void helper(int index,String s,List<String> temp,List<List<String >> res){
            if(index == s.length()){
                res.add(new ArrayList<>(temp));
                return ;
            }
            for(int i= index;i<s.length();i++){
                if(palindrome(s,index,i)){
                    temp.add(s.substring(index,i+1));
                    helper(i+1,s,temp,res);
                    temp.remove(temp.size()-1);
                }
            }
        }
        public List<List<String>> partition(String s) {
            List<String> res = new ArrayList<>();
            List<List<String>>finalres= new ArrayList<>();
            helper(0,s,res,finalres);
            return finalres;
    
    
            
        }
    }

