package entity;

/**
 * Author: nyq
 * Date：2022/5/19
 * Description: 院系
 * Version： 1.0
 */
public class Faculty {
    private String FacultyId;//院系id
    private String FacultyName;//院系名称
    private String TeacherId;//院系主任id

    public String getFacultyId() {
        return FacultyId;
    }

    public void setFacultyId(String facultyId) {
        FacultyId = facultyId;
    }

    public String getFacultyName() {
        return FacultyName;
    }

    public void setFacultyName(String facultyName) {
        FacultyName = facultyName;
    }

    public String getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(String teacherId) {
        TeacherId = teacherId;
    }

    public Faculty(String facultyId, String facultyName, String teacherId) {
        FacultyId = facultyId;
        FacultyName = facultyName;
        TeacherId = teacherId;
    }

    public Faculty() {
    }
}
