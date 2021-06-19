package com;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: pgajjar
 * @since: 9/12/17
 */
public class PatternExamples {
    private static final String HLS_GRADE_REGEX = ".*(HLS[\\d]+).*";

    public static void main(String[] args) {
        final Pattern pattern = Pattern.compile(HLS_GRADE_REGEX);
        // final String tierFile = "Job09b7ec24-e8d2-41fd-a5c7-5a131aaaf755-97956558_Merged_Main_sdrHevc_Normal_HEVCHLS587_tier13.mov";
        // final String tierFile = "Job36522278-a3f6-49bf-ae50-190ec1e5adb6-93824265_Merged_Main_Tier5_Normal_HDRHLS763.mov";
        final String tierFile = "Job36522278-a3f6-49bf-ae50-190ec1e5adb6-93824265_Merged_Main_Tier5_Normal_HLS205.mov";
        // final String tierFile = "Job36522278-a3f6-49bf-ae50-190ec1e5adb6-93824265_Merged_Main_Tier5_Normal_AtvHD.mov";
        Matcher matcher = pattern.matcher(tierFile);
        //if (matcher.matches()) {
            // final String tierHLSGrade = Arrays.stream(tierFile.split("_")).filter(e -> pattern.matcher(e).matches()).findFirst().get();
        final String tierHLSGrade1 = Iterables.getFirst(Iterables.filter(Splitter.on(CharMatcher.anyOf("_.")).trimResults().omitEmptyStrings().split(tierFile), e -> pattern.matcher(e).matches()), null);

            // System.out.println("tierHLSGrade: " + tierHLSGrade);
            System.out.println("tierHLSGrade1: " + tierHLSGrade1);
//        } else {
//            System.out.println("Did not match the HLS pattern");
//        }
    }
}
