package com.example.pw_assignment;

import java.util.List;

public class Student {
    String name;
    List<String> subjects;
    List<String> qualifications;
    String profileLink;

    public Student(String name, List<String> subjects, List<String> qualifications, String profileLink) {
        this.name = name;
        this.subjects = subjects;
        this.qualifications = qualifications;
        this.profileLink = profileLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<String> qualifications) {
        this.qualifications = qualifications;
    }

    public String getProfileLink() {
        return profileLink;
    }

    public void setProfileLink(String profileLink) {
        this.profileLink = profileLink;
    }
}
