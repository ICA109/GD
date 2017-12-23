import java.util.ArrayList;

public class SubDup {


    public static void main(String[] args) {
        ArrayList<String> testCases = new ArrayList<String>();

        //If even (since starting index 0) then test case, if odd then it's (previous) element's result

        testCases.add("acccb");
        testCases.add("aa");

        testCases.add("ac");
        testCases.add("b");

        testCases.add("acacac");
        testCases.add("bbb");

        testCases.add("aac");
        testCases.add("c");

        testCases.add("abc");
        testCases.add("cc");

        testCases.add("accc");
        testCases.add("b");

        testCases.add("aabbcc");
        testCases.add("bb");

        for (int i=0; i<testCases.size(); i++) {
            if (i%2 == 0) {
                System.out.println("Input: " + testCases.get(i) + "     ");
                subDuplicates(testCases.get(i));
            }
            else {
                System.out.println("Output (Expected): " + testCases.get(i) + "     ");
                System.out.println("------------------");
            }
        }

        //For older test cases without print function
        //System.out.println(subDuplicates("acccb"));
        //System.out.println(subDuplicates("ac"));
        //System.out.println(subDuplicates("acacac"));
        //System.out.println(subDuplicates("aac"));
        //System.out.println(subDuplicates("abc"));
        //System.out.println(subDuplicates("accc"));
        //System.out.println(subDuplicates("aabbcc"));

        //acccb -> bca x -> aa x
        //ac -> b x
        //acacac -> bbb x
        //aac -> ab x -> c x
        //abc -> cc x
        //accc->bcc x-> ac -> b x
        //aabbcc-> acac x-> bb x

    }

    //Version 0.4 working
    public static String subDuplicates(String input) {

        String workingCopy = input; //Make working copy of input String that we can safely modify
        boolean modifiedAtLeastOnce = true;

        //Run the procedure until one exists where no possible replacements occurs
        while (modifiedAtLeastOnce) {

            modifiedAtLeastOnce = false; //Don't run again unless triggered by procedure
            String tentativeAnswer = "";
            String toCompare = "";

            for (int i = 0; i <= workingCopy.length() - 1; i++) {

                //I can't believe this was the missing core insight...
                if (i == workingCopy.length() - 1)
                    toCompare = workingCopy.substring(i, i + 1); //Just final char by itself

                else
                    toCompare = workingCopy.substring(i, i + 2);


                String simplified = "";  //Needs to be reset every time
                i++;    //Assumed to be true unless "un-triggered" by default case

                switch (toCompare) {
                    case "ab":
                        simplified = "c";
                        modifiedAtLeastOnce = true;
                        break;
                    case "ba":
                        simplified = "c";
                        modifiedAtLeastOnce = true;
                        break;
                    case "ac":
                        simplified = "b";
                        modifiedAtLeastOnce = true;
                        break;
                    case "ca":
                        simplified = "b";
                        modifiedAtLeastOnce = true;
                        break;
                    case "bc":
                        simplified = "a";
                        modifiedAtLeastOnce = true;
                        break;
                    case "cb":
                        simplified = "a";
                        modifiedAtLeastOnce = true;
                        break;
                    default:
                        simplified = toCompare.substring(0, 1); //We got repeats of the same character
                        i--;
                        break;
                }
                tentativeAnswer += simplified;
            }
            workingCopy = tentativeAnswer;  //Overwrite input with found answer
        }
        System.out.println("Output (Actual): " + workingCopy);
        return workingCopy;
    }






/*    //Version 3 working
    public static String subDuplicates(String input) {
        final String orgCopyOfInput = input;

        System.out.println("wasad: " + orgCopyOfInput); //Why is this being modified???? Because input is changing...
        String workingCopy = input; //Make working copy of input String that we can safely modify
        System.out.println("workingCopy: " + workingCopy);
        boolean modifiedAtLeastOnce = true;





        while (modifiedAtLeastOnce) {
            //Run the procedure until one exists where no possible replacements occurs
            modifiedAtLeastOnce = false; //Don't run again unless triggered by procedure

            String tentativeAnswer = "";
            String toCompare = "";

            for (int i = 0; i <= input.length() - 1; i++) {

                //I can't believe this was the missing core insight...
                if (i == input.length() - 1)
                    toCompare = input.substring(i, i + 1); //Just final char by itself

                else
                    toCompare = input.substring(i, i + 2);


                String simplified = "";  //Needs to be reset every time
                i++;    ////Factors assumed to be true unless "un-triggered" by default case

                switch (toCompare) {
                    case "ab":
                        simplified = "c";
                        modifiedAtLeastOnce = true;
                        break;
                    case "ba":
                        simplified = "c";
                        modifiedAtLeastOnce = true;
                        break;
                    case "ac":
                        simplified = "b";
                        modifiedAtLeastOnce = true;
                        break;
                    case "ca":
                        simplified = "b";
                        modifiedAtLeastOnce = true;
                        break;
                    case "bc":
                        simplified = "a";
                        modifiedAtLeastOnce = true;
                        break;
                    case "cb":
                        simplified = "a";
                        modifiedAtLeastOnce = true;
                        break;
                    default:
                        simplified = toCompare.substring(0, 1); //We got doubles of the same character
                        //modified = false;
                        i--;
                        break;
                }
                tentativeAnswer += simplified;
            }

            //Overwrite input with found answer
            input = tentativeAnswer;



        }

        return input;
    }*/


//Version 0.2
/*
    public static String subDuplicates(String input) {

        String tentativeAnswer = "";
        String toCompare = "";
        //String tentativeAnswer = input;

        for (int i = 0; i <= input.length() - 1; i++) {
            //System.out.println(input.substring(i,i+2));


            if (i == input.length() - 1)
                toCompare = input.substring(i, i + 1); //Just final char by itself

            else
                toCompare = input.substring(i, i + 2);


            String simplified = toCompare;  //default should just be org. non-modified pair

            //If we're at the end of the string, then the last org. char must not have been modded (don't run toComp)



            //i++; //Prep for incrementing if sub occurs
            //i++;
            boolean modified = true;

            switch (toCompare) {
                case "ab":
                    simplified = "c";
                    i++;
                    break;
                case "ba":
                    simplified = "c";
                    i++;
                    break;
                case "ac":
                    simplified = "b";
                    i++;
                    break;
                case "ca":
                    simplified = "b";
                    i++;
                    break;
                case "bc":
                    simplified = "a";
                    i++;
                    break;
                case "cb":
                    simplified = "a";
                    i++;
                    break;
                default:
                    //System.out.println("default reached");
                    simplified = toCompare.substring(0,1); //We got double's of the same character
                    //Assume no modification has taken place, then no need to skip to next element in original string
                    //i--;
                    //simplified = "";
                    modified = false;
                    //i--;
                    break;
            }

            tentativeAnswer += simplified;

            */
/*
            if (modified) {
                tentativeAnswer = simplified + tentativeAnswer.substring(i+1, tentativeAnswer.length());
            }

            else {
                tentativeAnswer = simplified + tentativeAnswer.substring(i, tentativeAnswer.length());
            }
            *//*

            //tentativeAnswer =

            //tentativeAnswer = tentativeAnswer + simplified;
            //input += simplified;

        }

        //tentativeAnswer += input.charAt(input.length()-1);  //Temp. append last character
        //tentativeAnswer = input;

        return tentativeAnswer;
    }
*/


    //Version 0.1
    /*public static String subDuplicates(String input) {

        //String tentativeAnswer = "";
        String tentativeAnswer = input;

        for (int i = 0; i < tentativeAnswer.length() - 1; ) {
            //System.out.println(input.substring(i,i+2));




            String toCompare = tentativeAnswer.substring(i, i + 2);
            String simplified = toCompare;  //default should just be org. non-modified pair

            //i++; //Prep for incrementing if sub occurs
            i++;
            boolean modified = true;

            switch (toCompare) {
                case "ab":
                    simplified = "c";
                    break;
                case "ba":
                    simplified = "c";
                    break;
                case "ac":
                    simplified = "b";
                    break;
                case "ca":
                    simplified = "b";
                    break;
                case "bc":
                    simplified = "a";
                    break;
                case "cb":
                    simplified = "a";
                    break;
                default:
                    simplified = toCompare.substring(0,1); //We got double's of the same character
                    //Assume no modification has taken place, then no need to skip to next element in original string
                    //i--;
                    //simplified = "";
                    modified = false;
                    //i--;
                    break;
            }

            if (modified) {
                tentativeAnswer = simplified + tentativeAnswer.substring(i+1, tentativeAnswer.length());
            }

            else {
                tentativeAnswer = simplified + tentativeAnswer.substring(i, tentativeAnswer.length());
            }

            //tentativeAnswer = tentativeAnswer + simplified;
            //input += simplified;

        }

        //tentativeAnswer += input.charAt(input.length()-1);  //Temp. append last character
        //tentativeAnswer = input;

        return tentativeAnswer;
    }*/

}
