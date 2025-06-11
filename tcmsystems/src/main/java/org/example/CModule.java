package org.example;

import java.util.*;

public class CModule {
    private UserManager userManager;
    private QueryManager queryManager;
    private FavoriteManager favoriteManager;
    private CollectService collectService;
    private ExportManager exportManager;
    private PrintManager printManager;

    public CModule(PrescriptionManager pm) {
        this.userManager = new UserManager();
        this.favoriteManager = new FavoriteManager();
        this.queryManager = new QueryManager(pm);
        this.collectService = new CollectService(favoriteManager, pm);
        this.exportManager = new ExportManager();
        this.printManager = new PrintManager();
    }

    // 查询
    public List<Prescription> queryPrescriptions(String keyword) {
        return queryManager.queryPrescriptions(keyword);
    }

    // 收藏
    public void addFavorite(String username, int prescriptionId) {
        favoriteManager.addFavorite(username, prescriptionId);
    }
    public void removeFavorite(String username, int prescriptionId) {
        favoriteManager.removeFavorite(username, prescriptionId);
    }
    public List<Prescription> getFavorites(String username) {
        return collectService.getFavorites(username);
    }

    // 登录与权限
    public boolean login(String username, String password) {
        return userManager.login(username, password);
    }
    public Role getUserRole(String username) {
        return userManager.getUserRole(username);
    }

    // 导出
    public void exportPrescriptions(List<Prescription> prescriptions, ExportType type, String filePath) throws IOException {
        exportManager.exportPrescriptions(prescriptions, type, filePath);
    }

    // 打印
    public void printPrescription(Prescription prescription) {
        printManager.printPrescription(prescription);
    }
}
