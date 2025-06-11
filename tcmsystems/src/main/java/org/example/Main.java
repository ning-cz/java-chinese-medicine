package org.example;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        CModule c = new CModule(prescriptionManager);

// 登录
        boolean success = c.login("user", "user123");
        Role role = c.getUserRole("user");

// 查询
        List<Prescription> result = c.queryPrescriptions("感冒");

// 收藏
        c.addFavorite("user", 1);
        List<Prescription> favs = c.getFavorites("user");

// 导出
        c.exportPrescriptions(result, ExportType.CSV, "output.csv");

// 打印
        c.printPrescription(result.get(0));
    }
}