
import java.util.Arrays;

public class Sort {

	/**
	 * 直接插入排序
	 * 
	 * @param arr
	 * @return
	 */
	public static void InsertSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int t = arr[i];
			while (j >= 0 && arr[j] > t) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = t;
		}
	}

	/**
	 * 折半插入排序
	 * 
	 * @param arr
	 * @return
	 */
	public static void InsertSort1(int[] arr) {
		int low, high;
		for (int i = 1; i < arr.length; i++) {
			int t = arr[i];
			low = 0;
			high = i - 1;
			// 折半查找
			while (low <= high) {
				int mid = (low + high) / 2;
				if (arr[mid] > t) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			// 元素后移动
			for (int j = i - 1; j >= high + 1; j--) {
				arr[j + 1] = arr[j];
			}
			arr[high + 1] = t;
		}
	}

	/**
	 * 冒泡排序
	 * 
	 * @param arr
	 */
	public static void BubbleSort(int[] arr) {
		// 向右 冒泡
		for (int i = 0; i < arr.length - 1; i++) {
			boolean flag = false;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int t = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = t;
					flag = true;
				}
				// 若已经有序则直接返回
				if (!flag) {
					return;
				}
			}
		}
	}

	/**
	 * 快速排序
	 * 
	 * @param arr
	 */
	public static void QuickSort(int[] arr, int start, int end) {

		if (start < end) {
			int i = start;
			int j = end;
			int key = arr[start];// 基准
			// while找三个位置，一个大于key，一个小于key,一个key放置的位置
			while (i != j) {
				while (i < j && arr[j] >= key) {// 从右向左扫描，找第1个小于key的arr[j]
					j--;
				}
				arr[i] = arr[j];
				while (i < j && arr[i] <= key) {// 从左向右扫描，找第1个大于key的arr[j]
					i++;
				}
				arr[j] = arr[i];
			}
			arr[i] = key;

			QuickSort(arr, start, i - 1);
			QuickSort(arr, i + 1, end);
		}
	}

	/**
	 * 选择排序
	 * 
	 * @param arr
	 */
	public static void SelectSort(int[] arr) {
		// 排序结果归左
		for (int i = 0; i < arr.length - 1; i++) {
			int maxIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[maxIndex] < arr[j]) {
					maxIndex = j;
				}
			}

			if (i != maxIndex) {// swap
				int t = arr[i];
				arr[i] = arr[maxIndex];
				arr[maxIndex] = t;
			}
		}
	}

	/**
	 * 堆排序
	 * 
	 * @param arr
	 */
	public static void HeapSort(int[] arr) {
		// 构造初始堆,从第一个非叶子节点开始调整,左右孩子节点中较大的交换到父节点中
		for (int i = (arr.length) / 2 - 1; i >= 0; i--) {
			HeapAdjust(arr, i, arr.length);
		}

		// 排序，将最大的节点放在堆尾，然后从根节点重新调整
		for (int i = arr.length - 1; i >= 1; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			HeapAdjust(arr, 0, i);
		}
	}

	/**
	 * 调整堆
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 */

	private static void HeapAdjust(int[] arr, int low, int high) {
		int k = low, temp = arr[low], index = 2 * k + 1;

		while (index < high) {
			if (index + 1 < high) {
				if (arr[index] < arr[index + 1]) {
					index = index + 1;
				}
			}
			if (arr[index] > temp) {
				arr[k] = arr[index];
				k = index; // 修改值，继续筛选
				index = 2 * k + 1;
			} else {
				break;
			}
		}
		arr[k] = temp;

	}

	/**
	 * 归并排序
	 * 
	 * @param arr
	 * @param left
	 * @param mid
	 * @param right
	 */

	public static void Merge(int[] arr, int left, int mid, int right) {

		int[] rs = new int[arr.length];
		int i = left;
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= right) {
			if (arr[i] > arr[j]) {
				rs[k++] = arr[j];
				j++;
			} else {
				rs[k++] = arr[i];
				i++;
			}
		}
		while (i <= mid) {
			rs[k++] = arr[i];
			i++;
		}

		while (j <= right) {
			rs[k++] = arr[j];
			j++;
		}
		for (k = 0, i = left; i <= right; k++, i++) {
			arr[i] = rs[k];
		}

	}

	/**
	 * 归并---二路划分
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void MergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			MergeSort(arr, start, mid);
			MergeSort(arr, mid + 1, end);
			Merge(arr, start, mid, end);
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 102, 52, 13, 4, 32, 28 };
//		InsertSort(arr);
//		InsertSort1(arr);
//		BubbleSort(arr);
		QuickSort(arr, 0, arr.length - 1);
//		SelectSort(arr);
//		HeapSort(arr);
//		MergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));

	}

}
