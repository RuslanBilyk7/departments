package com.learn.web.holder;

import com.learn.web.model.Department;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RUSLAN77 on  29.01.2018 in Ukraine
 */
public class DepartmentsHolder {
    private static Map<Integer, Department> departmentMap = new HashMap<>();

    public static void addDepartment(Department department) {
        departmentMap.put(department.getId(), department);
    }

    public static Collection getDepartments() {
        return departmentMap.values();
    }

    public static Integer getNewDepartmentId() {
        int maxId = 0;
        for (Integer integer : departmentMap.keySet()) {
            if (integer > maxId) {
                maxId = integer;
            }
        }
        return maxId + 1;

    }

    public static Department getDepartmentById(Integer id) {
        return departmentMap.get(id);
    }

    public static void removeDepartment (Integer paramId){
        departmentMap.remove(paramId);
    }

}

