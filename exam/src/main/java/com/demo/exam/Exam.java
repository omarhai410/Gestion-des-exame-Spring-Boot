package com.demo.exam;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String semester;
    private String session;
    private String type;
    private String date;
    private String startTime;
    private Double plannedDuration;
    private Double actualDuration;
    private String coordinator;
    private String academicYear;

    @ElementCollection
    @CollectionTable(name = "exam_salle", joinColumns = @JoinColumn(name = "exam_id"))
    @Column(name = "nom_salle")
    private List<String> salleNoms;
    @ElementCollection
    private List<String> venue;

    @ElementCollection
    private List<String> invigilators;

    @ElementCollection
    private List<String> absenceControllers;

    private String report;
    private String examPaper;
    private String proceedings;

    // Attributs de l'élément pédagogique
    private String elementPedagogiqueName;

    // Constructeur

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Double getPlannedDuration() {
        return plannedDuration;
    }

    public void setPlannedDuration(Double plannedDuration) {
        this.plannedDuration = plannedDuration;
    }

    public Double getActualDuration() {
        return actualDuration;
    }

    public void setActualDuration(Double actualDuration) {
        this.actualDuration = actualDuration;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public List<String> getVenue() {
        return venue;
    }

    public void setVenue(List<String> venue) {
        this.venue = venue;
    }

    public List<String> getInvigilators() {
        return invigilators;
    }

    public void setInvigilators(List<String> invigilators) {
        this.invigilators = invigilators;
    }

    public List<String> getAbsenceControllers() {
        return absenceControllers;
    }

    public void setAbsenceControllers(List<String> absenceControllers) {
        this.absenceControllers = absenceControllers;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getExamPaper() {
        return examPaper;
    }

    public void setExamPaper(String examPaper) {
        this.examPaper = examPaper;
    }

    public String getProceedings() {
        return proceedings;
    }

    public void setProceedings(String proceedings) {
        this.proceedings = proceedings;
    }

    public String getElementPedagogiqueName() {
        return elementPedagogiqueName;
    }

    public void setElementPedagogiqueName(String elementPedagogiqueName) {
        this.elementPedagogiqueName = elementPedagogiqueName;
    }

    public List<String> getSalleNoms() {
        return salleNoms;
    }

    public void setSalleNoms(List<String> salleNoms) {
        this.salleNoms = salleNoms;
    }
}
