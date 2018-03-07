/**
 * Created by bibinet on 2017-12-12.
 */

public class QuickSort {
    public static int divide(int[] a,int start ,int end){//分区操作
        int base=a[end];//每次都已数组的最右边为基准值
        //先从数组的左边向右边开始遍历
        while (start<end &&a[start]<=base){//数组左边小于右边，且小于基准值，则一直向右移动
            start++;
        }//如果不满足则说明左边的数大于基准值，需要进行交换操作
        if (start<end) {
            int temp=a[start];
            a[start]=a[end];
            a[end]=temp;
            //交换以后，左边的值切换到了右边，及与基准值进行了替换，所以右边要向前移动一位，所以
            end--;
        }
        //当左边的值比较完了以后再从右边开始比较
        while (start<end&&a[end]>=base){
            //从右边开始遍历如果比基准值大就继续向左走
            end--;
        }
        if (start<end) {
            int temp=a[end];
            a[end]=a[start];
            a[start]=temp;
            start++;
        }
        //这里返回start或者end皆可，此时的start和end都为基准值所在的位置
        return end;
    }
    /**
     * 排序
     * @param a
     * @param start
     * @param end
     */
    public static void sort(int[] a, int start, int end){
        if(start > end){
            //如果只有一个元素，就不用再排下去了
            return;
        }
        else{
            //如果不止一个元素，继续划分两边递归排序下去
            int partition = divide(a, start, end);
            sort(a, start, partition-1);
            sort(a, partition+1, end);
        }

    }

}
