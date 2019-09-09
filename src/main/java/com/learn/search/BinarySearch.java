package com.learn.search;

public class BinarySearch {
  public int search(int[] arr, int n, int value) {
    int low = 0;
    int high = n - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == value) {
        return mid;
      } else if (arr[mid] < value) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return -1;
  }

  public int search2(int[] arr, int n, int value) {
    return bsearchInternally(arr, 0, n - 1, value);
  }

  private int bsearchInternally(int[] arr, int low, int high, int value) {
    if (low > high) {
      return -1;
    }

    int mid = low + ((high - low) >> 1);
    if (arr[mid] == value) {
      return mid;
    } else if (arr[mid] < value) {
      return bsearchInternally(arr, mid + 1, high, value);
    } else {
      return bsearchInternally(arr, 0, high - 1, value);
    }
  }

  public int getFirst(int[] arr, int n, int value) {
    int low = 0;
    int high = n - 1;

    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (arr[mid] < value) {
        low = mid + 1;
      } else if (arr[mid] > value) {
        high = mid - 1;
      } else {
        if ((mid == 0) || (arr[mid - 1] != value)) {
          return mid;
        } else {
          high = mid - 1;
        }
      }
    }

    return -1;
  }

  public int getLast(int[] arr, int n, int value) {
    int low = 0;
    int high = n - 1;

    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (arr[mid] < value) {
        low = mid + 1;
      } else if (arr[mid] > value) {
        high = mid - 1;
      } else {
        if ((mid == n - 1) || (arr[mid + 1] != value)) {
          return mid;
        } else {
          low = mid + 1;
        }
      }
    }

    return -1;
  }

  public int getFirstGreatThan(int[] arr, int n, int value) {
    int low = 0;
    int high = n - 1;

    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (arr[mid] >= value) {
        if ((mid == 0) || (arr[mid - 1] < value)) {
          return mid;
        } else {
          high = mid - 1;
        }
      } else {
        low = mid + 1;
      }
    }

    return -1;
  }

  public int getLastLessThan(int[] arr, int n, int value) {
    int low = 0;
    int high = n - 1;

    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (arr[mid] <= value) {
        if ((mid == n - 1) || (arr[mid + 1] != value)) {
          return mid;
        } else {
          low = mid + 1;
        }
      } else {
        high = mid - 1;
      }
    }

    return -1;
  }
}
