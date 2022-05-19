package entity;

/**
 * Author: nyq
 * Date：2022/5/19
 * Description: 专业
 * Version： 1.0
 */
public class Subject {
    private String SubjectId;//专业id
    private String SubjectName;//专业名称
    private String SubjectIntroduce;//专业介绍
    private String FacultyId;//学院id

    public String getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(String subjectId) {
        SubjectId = subjectId;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public String getSubjectIntroduce() {
        return SubjectIntroduce;
    }

    public void setSubjectIntroduce(String subjectIntroduce) {
        SubjectIntroduce = subjectIntroduce;
    }

    public String getFacultyId() {
        return FacultyId;
    }

    public void setFacultyId(String facultyId) {
        FacultyId = facultyId;
    }

    public Subject(String subjectId, String subjectName, String subjectIntroduce, String facultyId) {
        SubjectId = subjectId;
        SubjectName = subjectName;
        SubjectIntroduce = subjectIntroduce;
        FacultyId = facultyId;
    }

    public Subject() {
    }
}
