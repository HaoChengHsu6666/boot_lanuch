package com.chris.bootlaunch.practice;

import java.util.ArrayList;
import java.util.Random;

public class Try {

    public static ArrayList<Integer> allList(Integer ii){
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i<ii; i++){
            int allList = random.nextInt(100)+1;
            list.add(allList);
        }
        return list;
    }

    public static ArrayList<Integer> oddList(ArrayList<Integer> list){
        ArrayList<Integer> oddList = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            if (list.get(i)%2==0){
                oddList.add(list.get(i));
            }else {
                continue;
            }
        }
        return oddList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> all = allList(20);
        System.out.println("全部整數元素為:");
        for (int i=0; i<all.size(); i++){
            System.out.print(all.get(i)+",");
        }
        System.out.println();
        System.out.println("全部整數元素中的偶數為:");
        ArrayList<Integer> odd = oddList(all);
        for (int i=0; i<odd.size(); i++){
            System.out.print(odd.get(i)+",");
        }
    }

}
