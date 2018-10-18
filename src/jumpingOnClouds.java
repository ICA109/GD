public class jumpingOnClouds {
    static int jumpingOnCloudsMethod(int[] c) {
        int minJumps = 0;
        int i=0;

        while (i < c.length-1) {
            if (i<c.length-2 && c[i+2] == 0) {
                minJumps++;
                i += 2;
            }
            else if (i<c.length-1 && c[i+1] == 0) {
                minJumps++;
                i += 1;
            }
        }
        return minJumps;
    }
}
