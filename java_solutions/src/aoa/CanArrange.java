package aoa;

import java.util.HashMap;
import java.util.Map;

public class CanArrange {
    public boolean canArrange(int[] arr, int k) {
        int pairCount = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            num = num % k;
            int search = (k - num);
            if (map.containsKey(search)) {
                System.out.println("Found pait for i = " + i + " " + arr[i] + " at " + map.get(search) + " search : " + search);
                pairCount++;
                map.remove(search);
            } else {
                map.put(num, i);
            }

        }
//        System.out.println("pairCount " + pairCount);
        return map.isEmpty();
    }

//    public boolean canArrange(int[] arr, int k) {
//        HashMap<Integer,Integer> hs = new HashMap<>();
//        ///agar array even hi ni hoga to pair to vese hi ni ban payenge
//        if(arr.length%2!=0){
//            return false;
//        }
//        for(int j=0;j<= arr.length-1; j++){
//            int val = arr[j];
//            int mod = val%k;
//            if(mod<0){
//                mod = k+mod;
//            }
//            hs.put(mod,hs.getOrDefault(mod,0)+1);
//        }
//        ///fir hm hash map par treverse kar ke dekhenge
//        for(Integer val : hs.keySet()){
//            int get = hs.get(val);
//            ///agar 0 hai to oska difference k hi hoga jo ki hash map me hoga hi nahi to 0 ke liye check kar lenge agar oski frequency even hai to pair up kar sakta hai
//            /// dusra for the even k  agar val k ka half hai to k-val=val hi hoga to os case me bhi val ki frequency even honi chaie
//            if((val==0&&get%2!=0)||(k%2==0&&val*2==k&&get%2!=0)){
//                return false;
//            }else if(val!=0&&val*2!=k){
//                int diff = k-val;
//                ///agar diff hai and oska frequency even hai to hm answer true hoga
//                if(!hs.containsKey(diff)||!hs.get(diff).equals(hs.getOrDefault(val,0))){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
    public static void main(String[] args) {
        CanArrange arrange = new CanArrange();
//        arrange.canArrange(new int[]{1,2,3,4,5,10,6,7,8,9}, 5);
        arrange.canArrange(new int[]{5,10}, 5);
    }
}