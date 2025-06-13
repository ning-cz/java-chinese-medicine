package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 药方数据访问对象类，负责与数据库交互实现药方信息的增删改查操作
 */
public class PrescriptionDAO implements IPrescriptionDAO {
    // 修改数据库连接配置
    private static final String DB_URL = "jdbc:mysql://localhost:3306/药方?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "xz20060723";

    private void createTable() {
        // 修改建表SQL语法并处理保留字
        String sql = "CREATE TABLE IF NOT EXISTS prescriptions (\n"
                + "    id INT AUTO_INCREMENT PRIMARY KEY,\n"
                + "    name VARCHAR(255) NOT NULL,\n"
                + "    `from` VARCHAR(255),\n"
                + "    composition TEXT,\n"
                + "    efficiency TEXT,\n"
                + "    therapy TEXT,\n"
                + "    usage TEXT,\n"
                + "    taboo TEXT\n"
                + ") ENGINE=InnoDB;";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("药方表已成功创建/存在");
        } catch (SQLException e) {
            System.err.println("创建药方表时发生错误：");
            e.printStackTrace();
        }
    }

    /**
     * 添加新药方到数据库
     * @param prescription 包含药方信息的对象
     */
    public void addPrescription(Prescription prescription) {
        String sql = "INSERT INTO prescriptions(name, from, composition, efficiency, therapy, usage, taboo) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // 设置预处理参数
            pstmt.setString(1, prescription.getName());
            pstmt.setString(2, prescription.getFrom());
            pstmt.setString(3, prescription.getComposition());
            pstmt.setString(4, prescription.getEfficiency());
            pstmt.setString(5, prescription.getTherapy());
            pstmt.setString(6, prescription.getUsage());
            pstmt.setString(7, prescription.getTaboo());

            // 执行插入操作
            int affectedRows = pstmt.executeUpdate();
            System.out.println("已成功添加 " + affectedRows + " 条药方记录");
        } catch (SQLException e) {
            System.err.println("添加药方时发生错误：");
            e.printStackTrace();
        }
    }

    /**
     * 获取所有药方信息
     * @return 包含全部药方对象的列表
     */
    public List<Prescription> getAllPrescriptions() {
        List<Prescription> prescriptions = new ArrayList<>();
        String sql = "SELECT id, name, `from`, composition, efficiency, therapy, usage, taboo FROM prescriptions";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("正在查询药方数据...");
            while (rs.next()) {
                // 从结果集构建药方对象
                prescriptions.add(new Prescription(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("from"),
                        rs.getString("composition"),
                        rs.getString("efficiency"),
                        rs.getString("therapy"),
                        rs.getString("usage"),
                        rs.getString("taboo")
                ));
            }
        } catch (SQLException e) {
            System.err.println("查询药方时发生错误：");
            e.printStackTrace();
        }
        return prescriptions;
    }

    public Prescription getPrescriptionById(int id) {
        String sql = "SELECT id, name, `from`, composition, efficiency, therapy, usage, taboo FROM prescriptions WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Prescription(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("from"),
                            rs.getString("composition"),
                            rs.getString("efficiency"),
                            rs.getString("therapy"),
                            rs.getString("usage"),
                            rs.getString("taboo")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("通过ID查询药方时发生错误：");
            e.printStackTrace();
        }
        return null;
    }

    // 新增构造函数
    public PrescriptionDAO() {
        createTable();
    }

    // 实现接口方法
    @Override
    public void add(Prescription prescription) {
        addPrescription(prescription);
    }

    @Override
    public List<Prescription> getAll() {
        return getAllPrescriptions();
    }
}