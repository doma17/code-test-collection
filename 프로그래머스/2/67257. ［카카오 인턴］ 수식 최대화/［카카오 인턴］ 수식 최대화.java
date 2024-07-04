import java.util.*;

class Solution {
     public long solution(String expression) {
        long answer = 0;

        String[] operators = {"*", "+", "-"};
        List<String> operatorList = new ArrayList<>();
        List<String> operandList = new ArrayList<>();

        int start = 0;
        for (int i = 0; i < expression.length(); i++) {
            for (String operator : operators) {
                if (expression.charAt(i) == operator.charAt(0)) {
                    operatorList.add(operator);
                    operandList.add(expression.substring(start, i));
                    start = i + 1;
                }
            }
        }
        operandList.add(expression.substring(start));

        List<String> operatorPriority = new ArrayList<>();
        permutation(operators, 0, 3, 3, operatorPriority);

        for (String operator : operatorPriority) {
            List<String> tempOperandList = new ArrayList<>(operandList);
            List<String> tempOperatorList = new ArrayList<>(operatorList);

            for (int i = 0; i < operator.length(); i++) {
                for (int j = 0; j < tempOperatorList.size(); j++) {

                    if (operator.charAt(i) == tempOperatorList.get(j).charAt(0)) {
                        long result = 0;

                        if (operator.charAt(i) == '*') {
                            result = Long.parseLong(tempOperandList.get(j)) * Long.parseLong(tempOperandList.get(j + 1));
                        } else if (operator.charAt(i) == '+') {
                            result = Long.parseLong(tempOperandList.get(j)) + Long.parseLong(tempOperandList.get(j + 1));
                        } else if (operator.charAt(i) == '-') {
                            result = Long.parseLong(tempOperandList.get(j)) - Long.parseLong(tempOperandList.get(j + 1));
                        }

                        tempOperandList.set(j, String.valueOf(result));
                        tempOperandList.remove(j + 1);
                        tempOperatorList.remove(j);

                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(tempOperandList.get(0))));
        }

        return answer;
    }

    public void permutation(String[] arr, int depth, int n, int r, List<String> operatorPriority) {
        if (depth == r) {
            operatorPriority.add(arr[0] + arr[1] + arr[2]);
            return;
        }

        for (int i = depth; i < n; i++) {
            String temp = arr[depth];
            arr[depth] = arr[i];
            arr[i] = temp;

            permutation(arr, depth + 1, n, r, operatorPriority);

            temp = arr[depth];
            arr[depth] = arr[i];
            arr[i] = temp;
        }
    }
}