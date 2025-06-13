package org.example;

import java.util.List;

public interface IPrescriptionDAO extends GenericDAO<Prescription> {
    // 可以添加药方特有的方法
    Prescription getPrescriptionById(int id);

    List<Prescription> getAllPrescriptions();
}