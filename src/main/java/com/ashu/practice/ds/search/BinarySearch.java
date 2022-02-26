package com.ashu.practice.ds.search;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinarySearch {
    public static void main(String[] args) {
        int[] items = new int[]{1, 2, 3, 6, 7, 8, 9};
        log.info("searchIterative index={}", searchIterative(items, 2));
        log.info("searchRecursive index={}", searchRecursive(items, 2, 0, items.length));
    }

    public static int searchIterative(int[] items, int item) {
        int start = 0;
        int end = items.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            //log.info("start={},mid={},end={}", start, mid, end);
            try {
                if (items[mid] == item) return mid;
                else if (items[mid] > item) end = mid - 1;
                else start = mid + 1;
            } catch (RuntimeException e) {
                log.error("start={},mid={},end={}", start, mid, end);
                log.error(e.getMessage(), e);
                break;
            }
        }
        return -1;
    }

    public static int searchRecursive(int[] items, int item, int start, int end) {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            //log.info("start={},mid={},end={}", start, mid, end);
            if (items[mid] == item) return mid;
            else if (items[mid] > item) searchRecursive(items, item, start, mid - 1);
            else searchRecursive(items, item, start, mid + 1);
        }
        return -1;
    }
}
