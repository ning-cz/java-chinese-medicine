package org.example;

import java.util.*;

public class CollectService {
    private FavoriteManager favoriteManager;
    private PrescriptionManager prescriptionManager;

    public CollectService(FavoriteManager fm, PrescriptionManager pm) {
        this.favoriteManager = fm;
        this.prescriptionManager = pm;
    }

    public List<Prescription> getFavorites(String username) {
        List<Integer> ids = favoriteManager.getFavoriteIds(username);
        List<Prescription> result = new ArrayList<>();
        for (int id : ids) {
            Prescription p = prescriptionManager.getPrescriptionById(id);
            if (p != null) result.add(p);
        }
        return result;
    }
}
