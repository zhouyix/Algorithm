package wang;

public class BinarySearches {
    //binary search
    public int search(int[] arr, int num) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] == num)
                return mid;
            if (num > arr[mid]) {
                l = mid + 1;
            } else {

                r = mid - 1;
            }
        }

        return -1;
    }

    //find the first number equals num
    public int search1(int[] arr, int num) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] == num && (mid-1 <0 || arr[mid-1]!=num))
                return mid;
            if (num > arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    //find the first number bigger or equals num
    public int search2(int[] arr, int num) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);

            if (num <= arr[mid]) {
                if(mid == 0 || arr[mid-1] < num)
                    return mid;
                else
                    r=mid-1;

            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    //find the last number equals num
    public int search3(int[] arr, int num) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] == num && (mid-1 <0 || arr[mid+1]!=num))
                return mid;
            if (num < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }


    //find the last number smaller or equals num
    public int search4(int[] arr, int num) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);

            if (num >= arr[mid]) {
                if(mid == arr.length-1 || arr[mid+1] > num)
                    return mid;
                else
                  l = mid+1;

            } else {
               r= mid-1;
            }
        }

        return -1;
    }


    //find index of a number in a rotated arr
    public int search5(int[] arr, int num) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] == num)
                return mid;
            if (num > arr[mid]) {
                l = mid + 1;
            } else {
                if (num > arr[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return -1;
    }
}
