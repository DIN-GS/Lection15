package org.example;


import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

        Supplier<DayOfWeek> dayOfWeekSupplier = () -> {

            Date today = new Date();
            Integer dayOfWeek = today.getDay();
            if (dayOfWeek == 0) return DayOfWeek.SUNDAY;
            else if (dayOfWeek == 1)  return DayOfWeek.MONDAY;
            else if (dayOfWeek == 2) return DayOfWeek.TUESDAY;
            else if (dayOfWeek == 3) return DayOfWeek.WEDNESDAY;
            else if (dayOfWeek == 4) return DayOfWeek.THURSDAY;
            else if (dayOfWeek == 5) return DayOfWeek.FRIDAY;
            else return DayOfWeek.SATURDAY;

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

