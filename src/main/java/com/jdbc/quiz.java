package com.jdbc;

import java.util.Arrays;

public class quiz {
    public static String findMajor(int q1, int q2, int q3, int q4, int q5,
                                   int q6, int q7, int q8, int q9, int q10 ) {
        String major  = "";

        int[] newData = new int[]{q1,q2,q3,q4,q5,q6,q7,q8,q9,q10};

        String AA= "Electrical and Computer Engineering";
        String AB= "Management";
        String AC= "Image Arts";
        String AD= "CS";
        String AE= "CS & Business";

        int[] BA = new int[]{2,4,5,3,2,4,2,3,4,4};
        int[] BB = new int[]{5,1,3,5,5,3,3,5,1,1};
        int[] BC = new int[]{4,1,1,3,3,5,5,3,1,4};
        int[] BD = new int[]{1,4,5,1,1,1,1,3,5,5};
        int[] BE = new int[]{5,4,4,5,5,1,4,4,5,4};

        int aa = Math.abs(BA[1]-q1)^2+2*Math.abs(BA[2]-q2);
        int ab=Math.abs(BB[1]-q1)^2+2*Math.abs(BB[2]-q2);
        int ac =Math.abs(BC[1]-q1)^2+2*Math.abs(BC[2]-q2);
        int ad=Math.abs(BD[1]-q1)^2+2*Math.abs(BD[2]-q2);
        int ae=Math.abs(BE[1]-q1)^2+2*Math.abs(BE[2]-q2);

        for (int i = 3; i <= 9; i++) {
            aa=aa+Math.abs(BA[i]-newData[i]);
            ab=ab+Math.abs(BB[i]-newData[i]);
            ac=ac+Math.abs(BC[i]-newData[i]);
            ad=ad+Math.abs(BD[i]-newData[i]);
            ae=ae+Math.abs(BE[i]-newData[i]);

        }

        int bb = 0;
        int[] arr = new int[]{aa,ab,ac,ad,ae};
        Arrays.sort(arr);
        bb=arr[0];

        int[] c = new int[]{aa,ab,ac,ad,ae};
        Arrays.sort(c);
        int cc = c[1]; //0 based indexing

        if (aa==bb) {
            if (ab==cc){
                major =(AA + " and " + AB);
            }
            if (ac==cc){
                major =(AA + " and " + AC);
            }
            if (ad==cc){
                major =(AA + " and " + AD);
            }
            if (ae==cc) {
                major =(AA + " and " + AE);
            }
        }


        else if (ab==bb) {
            if (aa==cc){
                major =(AB + " and " + AA);
            }
            if (ac==cc){
                major =(AB + " and " + AC);
            }
            if (ad==cc){
                major =(AB + " and " + AD);
            }
            if (ae==cc) {
                major =(AB + " and " + AE);
            }
        }

        else if (ac==bb) {
            if (aa == cc) {
                major = (AC + " and " + AA);
            }
            if (ab == cc) {
                major = (AC + " and " + AB);
            }
            if (ad == cc) {
                major = (AC + " and " + AD);
            }
            if (ae == cc) {
                major = (AC + " and " + AE);
            }
        }

        else if (ad==bb) {
              if (aa==cc){
                  major =(AD + " and " + AA);
              }
              if (ab==cc){
                  major =(AD + " and " + AB);
              }
              if (ac==cc) {
                  major = (AD + " and " + AC);
              }
              if (ae == cc) {
                  major = (AD + " and " + AE);
              }
        }

        else {
            if (aa == cc) {
                major = (AE + " and " + AA);
            }
            if (ab == cc) {
                major = (AE + " and " + AB);
            }
            if (ac == cc) {
                major = (AE + " and " + AC);
            } else {
                major = (AE + " and " + AD);
            }
        }

        return major;
    }




}
