package TwentyThree.March;

import java.util.ArrayList;
import java.util.List;

public class temp {

    static class Emoticons{
        int price;
        int discount;
        Emoticons(int price, int percent){
            this.price = price;
            this.discount = percent;
        }
    }
    static int[] sales = {10, 20, 30, 40};
    static List<Emoticons> emoticonsList = new ArrayList<>();
    static int maxJoin = Integer.MIN_VALUE, maxPrice = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int[][] us = {
                {40, 10000}, {25, 10000}
        };
        int[] em = {7000, 9000};
        int[] result = solution(us, em);
        for (int a : result){
            System.out.println(a);
        }
    }

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        // dfs
        dfs(0, users, emoticons);

        answer[0] = maxJoin;
        answer[1] = maxPrice;

        return answer;
    }

    public static void dfs(int depth, int[][] users, int[] emoticons){
        if(depth == emoticons.length){
            int total = 0;
            int join = 0;

            for(int i=0;i<users.length;i++){
                int userPercent = users[i][0];
                int userPrice = users[i][1];

                int sum = 0;
                for(int j=0;j<emoticonsList.size();j++){
                    Emoticons cur = emoticonsList.get(j);
                    int targetPrice = cur.price;
                    int targetDiscount = cur.discount;
                    System.out.println("tp: "+ targetPrice);
                    System.out.println("td: "+ targetDiscount);
                    if(targetDiscount >= userPercent)
                        sum += targetPrice;
                }
                if(sum >= userPrice)
                    join++;
                else{
                    total += sum;
                }
            }

            if(maxJoin < join){
                maxPrice = total;
                maxJoin = join;
            }else if(maxJoin == join && maxPrice < total){
                maxPrice = total;
            }

            return;
        }

        for(int i=0;i<sales.length;i++){
            emoticonsList.add(new Emoticons(((100-sales[i])*(emoticons[depth])/100), (sales[i])));
            dfs( depth+1, users, emoticons);
            emoticonsList.remove(emoticonsList.size()-1);
        }
    }
}
