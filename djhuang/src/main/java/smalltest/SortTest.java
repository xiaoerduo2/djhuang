package smalltest;

import java.util.Arrays;
import java.util.Map;

public class SortTest {

    public void quickSort(int [] nums,int left,int right){
        if(left>=right){
            return;
        }
        int i = left;
        int j = right;
        int key = nums[i];
        while(i<j){
            while (i<j && nums[j]>key){
                j--;
            }
            swap(nums,i,j);
            while(i<j && nums[i]<key){
                i++;
            }
            swap(nums,i,j);
        }
        quickSort(nums, left,i-1);
        quickSort(nums, j+1,right);
    }

    private void swap(int[] nums, int i, int j) {
        if(i!=j){
            nums[i]=nums[i]+nums[j];
            nums[j]=nums[i]-nums[j];
            nums[i]=nums[i]-nums[j];
        }
    }

    public void bubbleSort(int [] nums){
        for(int i=0; i<nums.length-1;i++){
            for (int j=0;j<nums.length-i-1;j++ ){
                if(nums[j]>nums[j+1]){
                    swap(nums, j, j+1);
                }
            }
        }
    }
    public static void main(String args[]){
        int[] nums = {5,2,6,3,8};
        SortTest sortTest = new SortTest();
        //sortTest.quickSort(nums,0,nums.length-1);
        sortTest.bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
