import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FoolRPL {
    public static void main(String[] args) {

        System.out.println("Enter the size of the stack (bigger than 2): \n");
        Scanner sc = new Scanner(System.in);
        int size;
        do{
            size = sc.nextInt();
        }while(size<2); // i didn't verify if it was an int
        
        PileRPL pile = new PileRPL(size);

        ObjEmp oe2 = new NumberEmp(-10);
        ObjEmp oe4 = new NumberEmp(5);
        ObjEmp oe5 = new VecteurEmp(4,5,2);
        ObjEmp oe6 = new VecteurEmp(5,-43,20);
        ObjEmp oe7 = new ComplexEmp(34, -7);
        ObjEmp oe8 = new ComplexEmp(7, 7);
        
        String in;

        System.out.println(pile);
        pile.stack(oe2);
        System.out.println(pile);
        pile.stack(oe4);
        System.out.println(pile);
        pile.add();
        System.out.println(pile);
        pile.stack(oe5);
        System.out.println(pile);
        pile.stack(oe6);
        System.out.println(pile);
        pile.add();
        System.out.println(pile);
        pile.stack(oe7);
        System.out.println(pile);
        pile.stack(oe8);
        System.out.println(pile);
        pile.sub();
        System.out.println(pile);
        pile.stack(oe8);
        System.out.println(pile);

        do{
            in = sc.nextLine();
            switch(in){
                case "+":
                    pile.add();
                    break;
                case "-":
                    pile.sub();
                    break;
                case "*":
                    pile.mul();
                    break;
                case ":":
                    pile.div();
                    break;
                case "scal":
                    pile.scal();
                    break;
                case "q":
                    break;
                case "pop":
                    pile.pop();
                    break;
                default:
                    if(null == detect(in))
                    System.out.println("please enter a valid value or 'q' to quit the program");
                    else
                    pile.stack(detect(in));
                    break;
            }
            //oe = new ObjEmp(sc.nextLine());
            System.out.println(pile);
        }while(!in.equals("q"));

        sc.close();
    }

    public void printError(String s){
        System.out.println(s);
    }

    public static ObjEmp detect(String c){
        String num = c.replaceAll("\\s","");
        // source: https://codereview.stackexchange.com/questions/
        //121741/parsing-a-complex-number-using-regular-expressions
        // Ex: 3.145
        Pattern patternA = Pattern.compile("([-]?[0-9]+\\.?[0-9]?)$");
        // Ex: -3-2.0i
        Pattern patternB = Pattern.compile("([-]?[0-9]+\\.?[0-9]?)([-|+]+[0-9]+\\.?[0-9]?)[i$]+");
        // Ex: -10i
        Pattern patternC = Pattern.compile("([-]?[0-9]+\\.?[0-9]?)[i$]");

        Matcher matcherA = patternA.matcher(num);
        Matcher matcherB = patternB.matcher(num);
        Matcher matcherC = patternC.matcher(num);

        double x1=0,x2=0;
        try {
            if (matcherA.find()) {
                return new NumberEmp(Double.parseDouble(matcherA.group(1)));
            }
            if (matcherB.find()) {
                x1 = Double.parseDouble(matcherB.group(1));
                x2 = Double.parseDouble(matcherB.group(2));
                return new ComplexEmp(x1, x2);
            }
            if (matcherC.find()) {
                x1 = 0;
                x2 = Double.parseDouble(matcherC.group(1));
                return new ComplexEmp(x1, x2);
            }
            if(num.contains(",")){
                String tab[] = num.split(",");
                switch (tab.length){
                    case 1:
                        return new NumberEmp(Double.parseDouble(tab[0]));
                    case 2:
                        return new VecteurEmp(Double.parseDouble(tab[0]),Double.parseDouble(tab[1]));
                    case 3:
                        return new VecteurEmp(Double.parseDouble(tab[0]),Double.parseDouble(tab[1]),Double.parseDouble(tab[2]));
                    default:
                        System.out.println("Please enter a vector of maximum 3 elements");
                        return null;
                }
            }
        } catch (Exception e) {
            System.out.println("Cant understand your expression please retry");
            return null;
        }
        return null;
        
    }

}