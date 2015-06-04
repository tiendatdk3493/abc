package com.tma.gbst.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Nghi Tran on 4/20/2015.
 */
@Entity
@Table(name="user_profile")
public class UserProfile {
    @Id
    private int id;

    private int badgeId;
    private int badgeIdMentor;
    private String school;
    private String degree;
    private String graduateDate;
    private double finalStudyResult;
    private int toeic;
    private String joinDate;
    private String workRole;
    private double experienceYears;
    private double experienceYearsInCurrentRole;
    private boolean professionalCertification;
    private boolean overseaWorkingExperience;
    private String policeClearanceStatus;
    private String cvUrl;
    private String imageUser;
    private String place;
    private boolean gender;
    private boolean needTracking;
    private String skypeId;
    private String ipAddress;
    private String generalStatus;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_USER", referencedColumnName = "id")
    private User user;

    public UserProfile() {
        this.id = 0;
        this.badgeId = 0;
        this.badgeIdMentor = 0;
        this.school = "";
        this.degree = "";
        this.graduateDate = "";
        this.finalStudyResult = 0;
        this.toeic = 0;
        this.joinDate = "";
        this.workRole = "";
        this.experienceYears = 0;
        this.experienceYearsInCurrentRole = 0;
        this.professionalCertification = false;
        this.overseaWorkingExperience = false;
        this.policeClearanceStatus = "";
        this.cvUrl = "";
        this.imageUser = "";
        this.place = "";
        this.gender = false;
        this.needTracking = true;
        this.skypeId = "";
        this.ipAddress = "";
        this.generalStatus = "";
        this.user = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(int badgeId) {
        this.badgeId = badgeId;
    }

    public int getBadgeIdMentor() {
        return badgeIdMentor;
    }

    public void setBadgeIdMentor(int badgeIdMentor) {
        this.badgeIdMentor = badgeIdMentor;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(String graduateDate) {
        this.graduateDate = graduateDate;
    }

    public double getFinalStudyResult() {
        return finalStudyResult;
    }

    public void setFinalStudyResult(double finalStudyResult) {
        this.finalStudyResult = finalStudyResult;
    }

    public int getToeic() {
        return toeic;
    }

    public void setToeic(int toeic) {
        this.toeic = toeic;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getWorkRole() {
        return workRole;
    }

    public void setWorkRole(String workRole) {
        this.workRole = workRole;
    }

    public double getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(double experienceYears) {
        this.experienceYears = experienceYears;
    }

    public double getExperienceYearsInCurrentRole() {
        return experienceYearsInCurrentRole;
    }

    public void setExperienceYearsInCurrentRole(double experienceYearsInCurrentRole) {
        this.experienceYearsInCurrentRole = experienceYearsInCurrentRole;
    }

    public boolean isProfessionalCertification() {
        return professionalCertification;
    }

    public void setProfessionalCertification(boolean professionalCertification) {
        this.professionalCertification = professionalCertification;
    }

    public boolean isOverseaWorkingExperience() {
        return overseaWorkingExperience;
    }

    public void setOverseaWorkingExperience(boolean overseaWorkingExperience) {
        this.overseaWorkingExperience = overseaWorkingExperience;
    }

    public String getPoliceClearanceStatus() {
        return policeClearanceStatus;
    }

    public void setPoliceClearanceStatus(String policeClearanceStatus) {
        this.policeClearanceStatus = policeClearanceStatus;
    }

    public String getCvUrl() {
        return cvUrl;
    }

    public void setCvUrl(String cvUrl) {
        this.cvUrl = cvUrl;
    }

    public String getImageUser() {
        return imageUser;
    }

    public void setImageUser(String imageUser) {
        this.imageUser = imageUser;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean isNeedTracking() {
        return needTracking;
    }

    public void setNeedTracking(boolean needTracking) {
        this.needTracking = needTracking;
    }

    public String getSkypeId() {
        return skypeId;
    }

    public void setSkypeId(String skypeId) {
        this.skypeId = skypeId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getGeneralStatus() {
        return generalStatus;
    }

    public void setGeneralStatus(String generalStatus) {
        this.generalStatus = generalStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", badgeId=" + badgeId +
                ", badgeIdMentor=" + badgeIdMentor +
                ", school='" + school + '\'' +
                ", degree='" + degree + '\'' +
                ", graduateDate='" + graduateDate + '\'' +
                ", finalStudyResult=" + finalStudyResult +
                ", toeic=" + toeic +
                ", joinDate='" + joinDate + '\'' +
                ", workRole='" + workRole + '\'' +
                ", experienceYears=" + experienceYears +
                ", experienceYearsInCurrentRole=" + experienceYearsInCurrentRole +
                ", professionalCertification=" + professionalCertification +
                ", overseaWorkingExperience=" + overseaWorkingExperience +
                ", policeClearanceStatus='" + policeClearanceStatus + '\'' +
                ", cvUrl='" + cvUrl + '\'' +
                ", imageUser='" + imageUser + '\'' +
                ", place='" + place + '\'' +
                ", gender=" + gender +
                ", needTracking=" + needTracking +
                ", skypeId='" + skypeId + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", generalStatus='" + generalStatus + '\'' +
                ", user=" + user +
                '}';
    }
}
