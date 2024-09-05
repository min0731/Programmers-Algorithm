import java.util.*;


class Solution {
    static  Set<Integer> set;
    static boolean check [];
    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        String s ="";
        
        char[] arr = numbers.toCharArray();
        check = new boolean [numbers.length()];
        
        for (int i=1; i<=numbers.length(); i++){
                getPrime(s, arr, i, 0);   
        }
          // 소수만 추출하여 answer에 카운트
        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void getPrime ( String s, char[] arr, int N, int cnt){
        if (N == cnt){ 
            set.add(Integer.parseInt(s));
            
            return;
        }
        
        for (int i=0; i< arr.length; i++){
            if(!check[i]){
                check[i]= true;
                getPrime(s+arr[i], arr,N,cnt+1);
                check[i]=false;
            }
        }
    }
    
       // 소수 판별 함수
    public boolean isPrime(int num) {
        if (num < 2) return false;  // 1보다 작은 숫자는 소수가 아님
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}