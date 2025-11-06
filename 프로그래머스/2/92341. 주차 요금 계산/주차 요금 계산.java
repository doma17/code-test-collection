import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        TreeMap<String, Integer> feeRecordMap = new TreeMap<>();
        HashMap<String, Integer> timeRecordMap = new HashMap<>();
        
        // 입 출차 기록으로 차별 주차시간 저장
        for (var record : records) {
            String[] tmp = record.split(" ");
            int curTime = convertTimeFormat(tmp[0]);
            
            if (tmp[2].equals("IN")) {
                timeRecordMap.put(tmp[1], curTime);
            } else {
                int inTime = timeRecordMap.get(tmp[1]);
                timeRecordMap.remove(tmp[1]);
                
                // 차별 주차 시간 저장 (누적 시간으로 계산)
                int diff = curTime - inTime;
                feeRecordMap.put(tmp[1], feeRecordMap.getOrDefault(tmp[1], 0) + diff);
            }
        }
        
        // 출차 안한 차량 (23:59) 기준으로 출차시킴
        int outTime = convertTimeFormat("23:59");
        for (var x : timeRecordMap.entrySet()) {
            String carNum = x.getKey();
            int inTime = x.getValue();
            
            int diff = outTime - inTime;
            feeRecordMap.put(carNum, feeRecordMap.getOrDefault(carNum, 0) + diff);
        }
        
        // 차량번호 작은것 부터 (TreeMap 사용)
        ArrayList<Integer> list = new ArrayList<>();
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int timeSlice = fees[2];
        int timeFee = fees[3];
        
        for (var x : feeRecordMap.entrySet()) {
            // System.out.println(x.getKey() + " " + x.getValue());
            int timeByMin = x.getValue();
            int fee = defaultFee;
            
            if (timeByMin > defaultTime) {
                timeByMin -= defaultTime;
                fee += (timeByMin / timeSlice) * timeFee;
                fee += (timeByMin % timeSlice >= 1) ? timeFee : 0;
            }
            list.add(fee);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int convertTimeFormat(String time) {
        String[] tmp = time.split(":");
        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }
}