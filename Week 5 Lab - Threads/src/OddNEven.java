import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;

/**
 * Created by izaac on 3/04/2017.
 */
public class OddNEven implements Runnable
{
    //private final int OddNEven;
    private int number;
    private int delay;

    public OddNEven(int num, int time)
    {
        this.number = num;
        this.delay = time;
    }

    public void run()
    {
        for(int j=this.number; j<=10; j+=2)
        {
            System.out.print(j + " ");

                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


        }

    }

}
