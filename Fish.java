import java.util.*;
public class Fish implements Runnable {
    static List<Character> arr = new ArrayList<>(Arrays.asList('m', 'f', 'm', 'f', 'm', 'f', 'm', 'f', 'm', 'f', 'm', 'f', 'm', 'f', 'm', 'f', 'm', 'f', 'm', 'f')); //0=male, 1=female
    /*private final String threadname;
        private boolean exit;
        Fish(String threadname)
        {
            this.threadname=threadname;
        }
        System.out.println("Current thread entered "+threadname);*/
    Random random = new Random();
    public void run() {

        synchronized (arr) {
            int i = random.nextInt(arr.size());
            int j = random.nextInt(arr.size());
            while (i == j) //if fish is same generate again
                j = random.nextInt(arr.size());
            if (arr.get(i) == 'm' && arr.get(i) == 'm') {
                arr.remove(i);
                arr.remove(j);
                System.out.println("Two male fishes met and killed each other: " + arr);
                System.out.println("Current fishes : " + arr.size());
                //      checkarr(arr);

            } else if (arr.get(i) == 'f' && arr.get(j) == 'f') {

                arr.remove(j);
                System.out.println("Two Female Fishes met and one of them died!!: " + arr);
                System.out.println("Current fishes : " + arr.size());
            } else if ((arr.get(i) == 'f' && arr.get(j) == 'm') || (arr.get(i) == 'm' && arr.get(j) == 'f')) {
                int x = random.nextInt(arr.size());
                int y = random.nextInt(arr.size());
                if (x % 2 == 0) arr.add('f');
                else arr.add('m');
                if (y % 2 == 0) arr.add('f');
                else arr.add('m');
                System.out.println("A male,Female fish met they produce two other fishes: " + arr);
                System.out.println("Current fishes : " + arr.size());


            }
        }
    }

    //  @Override
    //public void stop() {
    //     exit=true;
    //  }
}
