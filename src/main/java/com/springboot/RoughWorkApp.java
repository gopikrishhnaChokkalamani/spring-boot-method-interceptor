package com.springboot;

public class RoughWorkApp {

	public static void main(String[] args) {
		long s = System.nanoTime();
		int num = fib_rec(5);
		long e = System.nanoTime();
		System.out.println(num);
		System.out.println(e - s);

		int num1 = fib_iter(5);
		System.out.println(num1);

		int[] arr = new int[] { 12, 23, 34, 45, 56, 67, 78, 89, 90 };

		System.out.println(binary_search(arr, 22, 0, arr.length - 1));
	}

	private static int fib_rec(int n) {
		if (n < 0) {
			System.out.println("cannot be negative");
			return 0;
		}
		if (n == 1 || n == 2)
			return n - 1;
		return (n - 1) + (n - 2);
	}

	private static int fib_iter(int n) {
		if (n < 0) {
			System.out.println("cannot be negative");
			return 0;
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			count = count + i;
		}
		return count;
	}

	private static boolean binary_search(int arr[], int element, int start, int end) {
		if (start == end) {
			if (arr[start] == element) {
				return true;
			} else {
				return false;
			}
		}
		int center = (start + end) / 2;
		if (arr[center] == element) {
			return true;
		} else if (arr[center] > element) {
			return binary_search(arr, element, start, center - 1);
		} else if (arr[center] < element) {
			return binary_search(arr, element, center + 1, end);
		} else {
			return false;
		}

	}
}
