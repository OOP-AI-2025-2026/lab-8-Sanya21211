package ua.opnu;

public class Main {
    public static void main(String[] args) {

        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName);
        System.out.println("isPresent: " + middleName.isPresent());
        System.out.println("orElse: " + middleName.orElse("немає"));

        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username);
        System.out.println("isPresent: " + username.isPresent());
        System.out.println("get(): " + username.get());
        System.out.println("orElse: " + username.orElse("guest"));

        try {
            String test = middleName.get();
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }


        System.out.println("\n=== Task 2: BookData Comparable ===");

        BookData b1 = new BookData("Algorithms", "Sedgewick", 100, 450.0);
        BookData b2 = new BookData("Clean Code", "Martin",     50,  245.0);
        BookData b3 = new BookData("Java Concurrency", "Goetz", 0,    0.0);
        BookData b4 = new BookData("Algorithms", "Other",      100, 450.0);

        java.util.List<BookData> list = new java.util.ArrayList<>();
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);

        System.out.println("Before sort:");
        list.forEach(System.out::println);

        java.util.Collections.sort(list);

        System.out.println("\nAfter sort (higher rating first; ties by title):");
        list.forEach(System.out::println);


        System.out.println("\n=== Task 3: Printer.printArray ===");

        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};

        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);


        System.out.println("\n=== Task 4: FilterUtil.filter ===");


        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        Integer[] even = FilterUtil.filter(numbers, n -> n % 2 == 0);
        System.out.println("Парні числа:");
        for (int n : even) System.out.println(n);


        String[] words = {"apple", "banana", "cherry", "avocado"};
        String[] startsWithA = FilterUtil.filter(words, s -> s.startsWith("a"));
        System.out.println("\nРядки, що починаються з 'a':");
        for (String s : startsWithA) System.out.println(s);


        System.out.println("\n=== Task 5: ContainsUtil.contains ===");

        String[] fruits = {"apple", "banana", "cherry"};
        System.out.println("fruits contains 'banana'? " +
                ContainsUtil.contains(fruits, "banana"));
        System.out.println("fruits contains 'plum'? " +
                ContainsUtil.contains(fruits, "plum"));

        Integer[] nums = {10, 20, 30};
        System.out.println("nums contains 20? " +
                ContainsUtil.contains(nums, 20));
        System.out.println("nums contains 25? " +
                ContainsUtil.contains(nums, 25));

        BookData[] books = {
                new BookData("Algorithms", "Sedgewick", 100, 450.0),
                new BookData("Clean Code", "Martin",     50,  245.0),
                new BookData("Java Concurrency", "Goetz", 0,    0.0)
        };

        BookData probeSameRankAndTitle =
                new BookData("Algorithms", "OtherAuthor", 100, 450.0);

        System.out.println("books contains (4.5, 'Algorithms' by any author) ? " +
                ContainsUtil.contains(books, probeSameRankAndTitle));

        BookData probeDifferent =
                new BookData("Algorithms II", "Someone", 100, 450.0);
        System.out.println("books contains different? " +
                ContainsUtil.contains(books, probeDifferent));

      
        System.out.println("\n=== Task 6: GenericTwoTuple / GenericThreeTuple ===");

        GenericTwoTuple<String, Integer> studentRating =
                new GenericTwoTuple<>("Іванов Іван", 91);
        System.out.println("Student rating: " + studentRating);

        BookData book = new BookData("Clean Code", "Martin", 50, 245.0);
        GenericThreeTuple<BookData, Boolean, Double> bookInfo =
                new GenericThreeTuple<>(book, true, 799.0);
        System.out.println("Book info: " + bookInfo);
        System.out.println("first title = " + bookInfo.getFirst().getTitle());
        System.out.println("second isBestseller = " + bookInfo.getSecond());
        System.out.println("three price = " + bookInfo.getThree());

        GenericTwoTuple<String, Integer> p = new GenericTwoTuple<>("apples", 5);
        GenericThreeTuple<String, Integer, Boolean> p3 = new GenericThreeTuple<>("oranges", 10, false);
        System.out.println("Pair: " + p);
        System.out.println("Triple: " + p3);

        System.out.println("Triple.pair = " + p3.getPair());

    }
}