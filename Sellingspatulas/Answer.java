package Sellingspatulas;


import java.io.IOException;

public class Answer {

    public static void main(String[] args) throws IOException, InterruptedException {

        Kattio scanner = new Kattio(System.in);

        int ventesCount;
        while ((ventesCount = scanner.getInt()) != 0) {
            int startMaxProfit = scanner.getInt();
            int endMaxProfit = startMaxProfit;
            double profitMax = scanner.getDouble() - 0.08;
            int startCheck = startMaxProfit;
            int endCheck = endMaxProfit;
            double profitCheck = profitMax;

            for (int i = 1; i < ventesCount; i++) {
                int minute=scanner.getInt();
                double value=scanner.getDouble();
                profitCheck += (value - (minute - endCheck) * 0.08);
                endCheck = minute;
                if (profitCheck <= 0 || value-0.08 >= profitCheck) {
                    startCheck = endCheck;
                    profitCheck = value - 0.08;
                } 
                

                if ((profitCheck > profitMax || 
                        (profitCheck >= profitMax  && endCheck-startCheck < endMaxProfit-startMaxProfit))
                        && profitCheck > 0) {
                    startMaxProfit = startCheck;
                    endMaxProfit = endCheck;
                    profitMax = profitCheck;
                }

            }

            System.out.println(profitMax > 0 ? String.format("%.2f",profitMax) + " " + startMaxProfit + " " + endMaxProfit : "no profit");
           

        }

    }

   
}
