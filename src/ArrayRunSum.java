public class ArrayRunSum {

    public static void main(String[] args) {
        int[] sample = {-3, 5, -1, 17, 3, -15, -23, 1, 50};
        System.out.println("iterSum: " + iterSum(sample));
        System.out.println("recSum: " + recSum(sample, 0, 0));
        System.out.println("recSum2: " + recSum2(sample, sample.length-1));
    }

    public static int iterSum(int[] input) {
        int answer = 0;
        for (int i=0; i<input.length; i++) {
            answer += input[i];
        }
        return answer;
    }

    public static int recSum(int[] input, int acc, int index) {
        if (index == input.length) {
            return acc;
        }
        //return acc+recSum(input, input[index], index+1);  //Also works
        return recSum(input, acc+input[index], index+1);    //Works as well
    }

    //Alternative
    public static int recSum2(int[] input2, int index2) {
        if (index2 == 0) {
            return input2[0];
        }
        return recSum2(input2, index2-1) + input2[index2];
    }

}
