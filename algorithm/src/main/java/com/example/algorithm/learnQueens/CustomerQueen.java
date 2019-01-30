package com.example.algorithm.learnQueens;


/**
 * 回溯算法   eg:八皇后
 * 应用递归函数，
 * 1.寻找终止条件（终止）
 * 2.所需分块地方（分治法）
 */
public class CustomerQueen {
    int[] result = new int[8];

    private void cal8queens(int row) {
        //终止条件（条件1）
        if (row == 8) {
            print8queens(result);
            return;
        }

        for (int cal = 0; cal < 8; ++cal) {
            if (isok(row, cal)) {
                result[row] = cal;
                //寻找成功结果  继续下面查找（条件2）
                cal8queens(row + 1);
            }
        }
    }

    private boolean isok(int row, int cal) {
        int leftUp = cal - 1, rightUp = cal + 1;
        for (int i = row - 1; i >= 0; --i) {
            if (result[i] == cal) return false;

            if (leftUp >= 0) {
                if (result[i] == leftUp) {
                    return false;
                }
            }
            if (rightUp < 8) {
                if (result[i] == rightUp) {
                    return false;
                }
            }

            --leftUp; ++rightUp;
        }
        return true;
    }

    int count = 0;
    private void print8queens(int[] result) {
        count++;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (result[i] == j)
                    System.out.print("○ ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CustomerQueen cus = new CustomerQueen();
        cus.cal8queens(0);
        System.out.println(cus.count);
    }

}
