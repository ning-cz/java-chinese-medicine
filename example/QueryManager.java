package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class QueryManager {
    private PrescriptionManager prescriptionManager;

    public QueryManager(PrescriptionManager pm) {
        this.prescriptionManager = pm;
    }

    public List<Prescription> queryPrescriptions(String keyword) {
        String kw = keyword.toLowerCase();
        return prescriptionManager.getAllPrescriptions().stream()
                .filter(p -> p.getName().toLowerCase().contains(kw)
                        || p.getMainEffect().toLowerCase().contains(kw)
                        || p.getMedicineNames().toLowerCase().contains(kw))
                .collect(Collectors.toList());
    }
}
