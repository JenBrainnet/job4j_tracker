package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        int totalScore = 0;
        int subjectCount = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            subjectCount += pupil.subjects().size();
        }
        return (double) totalScore / subjectCount;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> averageScores = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            double average = (double) totalScore / pupil.subjects().size();
            averageScores.add(new Label(pupil.name(), average));
        }
        return averageScores;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> averageScores = new ArrayList<>();
        Map<String, Integer> subjectScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScores.put(
                        subject.name(),
                        subjectScores.getOrDefault(subject.name(), 0) + subject.score()
                );
            }
        }
        for (String subjectName : subjectScores.keySet()) {
            double average = (double) subjectScores.get(subjectName) / pupils.size();
            averageScores.add(new Label(subjectName, average));
        }
        return averageScores;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> studentScores = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            studentScores.add(new Label(pupil.name(), totalScore));
        }
        studentScores.sort(Comparator.naturalOrder());
        return studentScores.getLast();
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectTotals = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectTotals.put(
                        subject.name(),
                        subjectTotals.getOrDefault(subject.name(), 0) + subject.score()
                );
            }
        }
        List<Label> subjectScores = new ArrayList<>();
        for (String subjectName : subjectTotals.keySet()) {
            subjectScores.add(new Label(subjectName, subjectTotals.get(subjectName)));
        }
        subjectScores.sort(Comparator.naturalOrder());
        return subjectScores.getLast();
    }

}
