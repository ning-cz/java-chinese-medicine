package org.example;

import java.util.List;
import java.util.ArrayList;

public class PrescriptionManager {
    // 实际项目中应从数据库或DAO获取数据，这里仅作示例
    private IPrescriptionDAO prescriptionDAO = DAOFactory.getPrescriptionDAO();

    public List<Prescription> getAllPrescriptions() {
        return prescriptionDAO.getAllPrescriptions();
    }

    public Prescription getPrescriptionById(int id) {
        return prescriptionDAO.getPrescriptionById(id);
    }
}