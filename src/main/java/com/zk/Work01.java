package com.zk;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Scanner;

@Slf4j
public class Work01 {

    public void input(){

        boolean flag = true;
        while (flag){
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
            } else{
                log.info("非法字符,请输入数字");
                continue;
            }
            log.info("起始数值：{}", low);
            log.info("终止数值：{}", high);
            log.info("选择两个整数整除");
            log.info("输入两个除数整数:");
            boolean invalidDiv = true;
            while (invalidDiv){
                inScan = new Scanner(System.in);
                String[] arr = inScan.nextLine().split("\\s+");
                if (checkNum(arr)) {

                }
            }
        }

    }

    public static void main(String[] args){
        Work01 work01 = new Work01();
        work01.input();
    }


    public boolean checkNum(String[] arr){
        for (int i = 0; i< arr.length; i++){
            if (!isNumberic(arr[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isNumberic(String s){
        if (s==null || s.trim().length() ==0) {
            return false;
        }
        String rule = "(-|\\+)?([0-9]+)";
        if (s.matches(rule)) {
            return true;
        } else{
            return false;
        }
    }
}
