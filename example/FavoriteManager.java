package org.example;

import java.util.*;

public class FavoriteManager {
    // username -> set of prescriptionId
    private Map<String, Set<Integer>> favorites = new HashMap<>();

    public void addFavorite(String username, int prescriptionId) {
        favorites.computeIfAbsent(username, k -> new HashSet<>()).add(prescriptionId);
    }

    public void removeFavorite(String username, int prescriptionId) {
        Set<Integer> set = favorites.get(username);
        if (set != null) set.remove(prescriptionId);
    }

    public List<Integer> getFavoriteIds(String username) {
        return new ArrayList<>(favorites.getOrDefault(username, Collections.emptySet()));
    }
}
