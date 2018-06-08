//https://www.geeksforgeeks.org/shortest-path-reach-one-prime-changing-single-digit-time/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(shortestPathPrime(1033, 8179, 4));
    }

    private static List<Integer> shortestPathPrime(int s, int d, int digits) {
        Set<Integer> primes = getPrimes(digits);
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> parent = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();

        q.add(s);
        visited.add(s);

        while(!q.isEmpty()) {
            int curr = q.poll();
            if(curr == d) {
                result = getPath(parent, d, s);
                break;
            }
            for(int p : primes) {
                if(isOneDigitApart(curr, p) && visited.add(p)) {
                    parent.put(p, curr);
                    q.add(p);
                }
            }
        }

        return result;
    }

    private static List<Integer> getPath(Map<Integer, Integer> parent, int d, int s) {
        List<Integer> result = new ArrayList<>();
        
        while(parent.get(d) != s) {
            result.add(d);
            d = parent.get(d);
        }
        result.add(s);
        return result; 
    }

    private static boolean isOneDigitApart(int i1, int i2) {
        String s1 = Integer.toString(i1);
        String s2 = Integer.toString(i2);
        int count = 0;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i))
                count++;
        }

        return count == 1;
    }

    private static Set<Integer> getPrimes(int digits) {
        Set<Integer> res = new HashSet<>();
        int n = (int)Math.pow(10, digits) - 1;
        boolean[] prime = new boolean[n+1];
        for(int i=0; i<=n; i++)
            prime[i] = true;

        for(int i=2; i * i <= n ; i++) {
            if(prime[i]) {
                for(int j=i * 2; j <= n; j+=i) {
                    prime[j] = false;
                }
            }
        }

        for(int i=(int)Math.pow(10, digits-1); i<n; i++) {
            if(prime[i])
                res.add(i);
        }

        return res;
    }

}