package com.zk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class Work01 {

    public void input() {

        boolean flag = true;
        while (flag) {
            int low = 0;
            int high = 0;

            log.info("------start-----");
            System.out.println("输入起始和终止值：");
            Scanner inScan = new Scanner(System.in);
            String[] low_high = inScan.nextLine().split("\\s+");
            if (isNumberic(low_high[0]) && isNumberic(low_high[1])) {
                low = Integer.parseInt(low_high[0]);
                high = Integer.parseInt(low_high[1]);
                if (low > high) {
                    log.info("起始值>终止值: 重新输入");
                    continue;
                }
            } else {
                log.info("非法字符,请输入数字");
                continue;
            }
            log.info("起始数值：{}", low);
            log.info("终止数值：{}", high);
            boolean invalidDiv = true;
            String[] arr_first = null;
            while (invalidDiv) {
                log.info("输入两个除数整数:");
                String[] two_div = new Scanner(System.in).nextLine().split("\\s+");
                if (checkNum(two_div)) {
                    arr_first = two_div;
                    invalidDiv = false;
                } else {
                    log.info("输入除数不为数字或包含0,重新输入");
                }
            }
            printArr(arr_first, low, high);
            invalidDiv = true;
            String[] arr_second = null;
            while (invalidDiv){
                log.info("输入3个除数整数");
                String[] three_div = new Scanner(System.in).nextLine().split("\\s+");
                if (checkNum(three_div)) {
                    arr_second = three_div;
                    invalidDiv  =false;
                } else{
                    log.info("输入除数不为数字或包含0,重新输入");
                }
            }
            printArr(arr_second, low, high);
        }

    }

    public static void main(String[] args) {
        Work01 work01 = new Work01();
        work01.input();
    }

    public void printArr(String[] arr_first, int low, int high){
        if (!StringUtils.isEmpty(arr_first)) {
            List<Integer> canList = new ArrayList<>();
            for (int i = low; i <= high; i++) {
                if (canDivInArr(i, arr_first)) {
                    canList.add(i);
                }
            }
            if (canList.size() != 0) {
                System.out.println("可以被整除的数: " + canList.toString());
            }else{
                System.out.println("没有可以被整除的数");
            }
        }
    }

    public boolean canDivInArr(int dividend, String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (dividend % Integer.parseInt(arr[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean checkNum(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (!isNumberic(arr[i])) {
                return false;
            }
            if (arr[i].equals("0")) {
                return false;
            }
        }
        return true;
    }

    public boolean isNumberic(String s) {
        if (s == null || s.trim().length() == 0) {
            return false;
        }
        String rule = "(-|\\+)?([0-9]+)";
        if (s.matches(rule)) {
            return true;
        } else {
            return false;
        }
    }
}
