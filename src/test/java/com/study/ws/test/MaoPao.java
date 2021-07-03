package com.study.ws.test;

import org.junit.Test;

import java.util.*;

public class MaoPao {
    static Object[] arr = null;
    final static Set<Integer> a = new HashSet();
    final static ArrayList<Integer> list = new ArrayList();
    static{
        final Random r = new Random( );
        while(a.size()<15 ){
            a.add(r.nextInt(30));
        }
        list.addAll(a);
        Collections.shuffle(list);
        arr = list.toArray();
    }
    @Test
    public void wakeng(){


    }
    @Test
    public void kuaisupaixu(){
        int tem = list.get(0);

    }
    public List<Integer> kuaisu(List<Integer> side){
        int tem = side.get(0);
        int zz = side.get(0);
        int z = 0;
        for (z = 0; z < side.size(); z++) {
            zz = side.get(z);
            if(zz>tem){
                break;
            }
        }
        int rr = side.get(side.size()-1);
        int r = side.size()-1;
        for (r = side.size()-1; r >=0 ; r--) {
            rr = side.get(r);
            if(rr<tem){
                break;
            }
        }
        if(r>z){
            side.set(z, rr);
            side.set(r, zz);
        }
        if(r<z){
            side.set(z, rr);
            side.set(r, zz);
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(list);
        int size = list.size();
        for (int i = 0; i < list.size(); i++) {
            size--;
            for (int j = 0; j < size; j++) {
                int a = list.get(j);
                int b = list.get(j+1);
                if(a>b){
                    int big = a;
                    int small = b;
                    list.set(j, small);
                    list.set(j+1, big);
                }
            }
        }
        System.out.println(list);

    }
}
