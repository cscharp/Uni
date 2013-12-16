import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by taras on 16.12.13.
 */
public class PizzaMaker {
    public static void main(String[] args){
        char[] orders =new char[0];

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            String str = sc.next();
            if(str.equals("addempty")){
                orders=addempty(orders);
                System.out.println(Arrays.toString(orders));
            }
            else if(str.equals("addItem")){
                addItem(orders,sc.next().charAt(0));
                System.out.println(Arrays.toString(orders));
            }
            else if(str.equals("repeatPizza")){
                orders=repeatPizza(orders);
                System.out.println(Arrays.toString(orders));
            }
            else if(str.equals("totalPrice")){
                System.out.println(totalPrice(orders));

            }
        }
    }
    public static char[]  addempty(char[] orders){
        char[] returnArr = new char[orders.length+8];
        for(int i=orders.length;i<returnArr.length;i++){
                returnArr[i]='-';
        }
          return returnArr;
    }
    public static void addItem(char[] orders,char c){
        if(orders.length<=0){
                          System.out.println("wird nix gemacht");
                          System.exit(0);
        }else {

               final  int B_FLAG=orders.length-8;
               for(int i=B_FLAG;i<orders.length;i++){
                   if(orders[i]=='-'){
                       orders[i]=c;
                       break;
                   }
               }
        }

    }
    public static char[] repeatPizza(char orders[]){
        char[]  returnArray =new char[orders.length+8];
             if(orders.length<0){
                 System.out.println("nix passiert");
                 System.exit(0);
             }else{
                 final int B_FLAG=orders.length-8;
                 for(int i=0;i<orders.length;i++){
                     returnArray[i]=orders[i];
                 }
                 for(int j=orders.length;j<returnArray.length;j++){
                     returnArray[j]=orders[j-8];
                 }
             }
        return returnArray;
    }
    public String toString(char orders[]){
        String str;
        if(orders[0]=='-'){
            return "" ;
        }else{
            str=Arrays.toString(orders);
        }
        return str;
    }
    public static double totalPrice(char[] orders){
        double price=0.0;
     if(orders.length>0){
        for(int i=0;i<orders.length;i++){
            if(orders[i]=='T'){
                price+=0.70;
            }
            else if(orders[i]=='M'){
                    price+=0.70;
            }
            else if(orders[i]=='B'){
                price+=0.70;
            }
        }
    }
     return price+4.00;
    }
}
