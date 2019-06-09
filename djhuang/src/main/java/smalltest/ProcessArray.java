package smalltest;

public class ProcessArray {

    public static  void process(int[] array,Command command){
        command.process(array);
    }
     public  static  void  main(String []args){
        int[] array = {1,2,3};
        ProcessArray processArray = new ProcessArray();
        processArray.process(array, (int[] array2)-> {
                int sum = 0;
                for (int i=0;i<array2.length;i++){
                    sum+=array2[i];
                }
                System.out.println("sum="+sum);
            }
        );
     }

}
