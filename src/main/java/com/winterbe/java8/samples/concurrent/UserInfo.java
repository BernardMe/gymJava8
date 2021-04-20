package com.winterbe.java8.samples.concurrent;


import java.io.Serializable;
import java.util.List;

/**
 *
 */

public class UserInfo
        implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Long userId;
    private String role;
    private boolean schoolManager;
    private boolean gradeManager;
    private boolean dormitoryManager;
    private List<Long> schoolManagerClassIds;
    private List<Long> gradeManagerClassIds;
    private Boolean isSystemUser;
    private Boolean isChinaMobile;

    public Long getUserId()
    {
        return this.userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public String getRole()
    {
        return this.role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public boolean isSchoolManager()
    {
        return this.schoolManager;
    }

    public void setSchoolManager(boolean schoolManager)
    {
        this.schoolManager = schoolManager;
    }

    public boolean isGradeManager()
    {
        return this.gradeManager;
    }

    public void setGradeManager(boolean gradeManager)
    {
        this.gradeManager = gradeManager;
    }

    public boolean isDormitoryManager()
    {
        return this.dormitoryManager;
    }

    public void setDormitoryManager(boolean dormitoryManager)
    {
        this.dormitoryManager = dormitoryManager;
    }

    public List<Long> getSchoolManagerClassIds()
    {
        return this.schoolManagerClassIds;
    }

    public void setSchoolManagerClassIds(List<Long> schoolManagerClassIds)
    {
        this.schoolManagerClassIds = schoolManagerClassIds;
    }

    public List<Long> getGradeManagerClassIds()
    {
        return this.gradeManagerClassIds;
    }

    public void setGradeManagerClassIds(List<Long> gradeManagerClassIds)
    {
        this.gradeManagerClassIds = gradeManagerClassIds;
    }

    public Boolean getIsSystemUser()
    {
        return this.isSystemUser;
    }

    public void setIsSystemUser(Boolean isSystemUser)
    {
        this.isSystemUser = isSystemUser;
    }

    public Boolean getIsChinaMobile()
    {
        return this.isChinaMobile;
    }

    public void setIsChinaMobile(Boolean isChinaMobile)
    {
        this.isChinaMobile = isChinaMobile;
    }
}
