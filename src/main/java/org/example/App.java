package org.example;


import java.time.DayOfWeek;
import java.util.Calendar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        Predicate<Integer> isCommonNumber = x -> {
            for (int i = 2; i < x; x++){
                if (x % i == 0){
                    return false;
                }
            }
            return true;
        };

        System.out.println(isCommonNumber.test(6));

        Consumer<Integer> oneToNum = x -> {
            for (int i = 0; i <= x; i++){
                System.out.print(i+" ");
            }
        };

        oneToNum.accept(6);
        System.out.println();

        Supplier<Integer> dayOfWeekSupplier = () -> {

            int n = Calendar.DAY_OF_WEEK;

            /*switch (n){
                case 0:
                    return DayOfWeek.SUNDAY;
                    break;
                case 1:
                    return DayOfWeek.MONDAY;
                    break;
                case 2:
                    return DayOfWeek.TUESDAY;
                    break;
                case 3:
                    return DayOfWeek.WEDNESDAY;
                    break;
                case 4:
                    return DayOfWeek.THURSDAY;
                    break;
                case 5:
                    return DayOfWeek.FRIDAY;
                    break;
                case 6:
                    return DayOfWeek.SATURDAY;
                    break;
                default:
                    return DayOfWeek.SATURDAY;
            }*/
            return n;
        };
        System.out.println(dayOfWeekSupplier.get());

        Function<Double, Long> round = x -> {
            return  (Long) Math.round(x);
        };
        System.out.println(round.apply(3.49));

        UnaryOperator<Integer> fibonachi = x ->{
            int num1 = 0;
            int num2 = 1;
            int temp;
            int l = 0;
            while (true){
                l++;
                temp = num2;
                num2 = num1+num2;
                num1 = temp;

                if (x==0) return x;
                if (l == x) return num2;
            }
        };
        System.out.println(fibonachi.apply(4));



    }

    //Перевірка, чи є число простим
    @FunctionalInterface
    public interface Predicate<T>{
        boolean test(T t);
    }
    //Генерує число від 0 до заданого та виводить в консоль
    @FunctionalInterface
    public interface Consumer<T>{
        void accept (T t);
    }
    //Повертає день тижня
    @FunctionalInterface
    public interface Supplier<T>{
        T get();
    }
    //Округляє Double у Long за правилами математики
    @FunctionalInterface
    public interface Function<T,R>{
        R apply(T t);
    }

    //Обчислює число Фібоначчі
    @FunctionalInterface
    public interface UnaryOperator<T> extends Function<T, T> {
        static <T> UnaryOperator<T> identity() {
            return t -> t;
        }
    }

}

