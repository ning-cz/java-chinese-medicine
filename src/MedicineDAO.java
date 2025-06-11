import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 药材数据访问对象类，负责与数据库交互实现药材信息的增删改查操作
 */
public class MedicineDAO implements IMedicineDAO{
    // 修改数据库连接配置
    private static final String DB_URL = "jdbc:mysql://localhost:3306/药材?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "xz20060723";

    private void createTable() {
        // 修改建表SQL语法
        String sql = "CREATE TABLE IF NOT EXISTS medicines (\n"
                + "    id INT AUTO_INCREMENT PRIMARY KEY,\n"  // 修改自增语法
                + "    name VARCHAR(255) NOT NULL,\n"        // VARCHAR替代TEXT
                + "    flavor VARCHAR(255),\n"
                + "    classify VARCHAR(255),\n"
                + "    efficacy TEXT,\n"
                + "    therapy TEXT,\n"
                + "    usage TEXT,\n"
                + "    taboo TEXT\n"
                + ") ENGINE=InnoDB;";                         // 指定存储引擎

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("药材表已成功创建/存在");
        } catch (SQLException e) {
            System.err.println("创建药材表时发生错误：");
            e.printStackTrace();
        }
    }
    // 新增构造函数
    public MedicineDAO() {
        createTable();
    }

    // 实现接口方法
    @Override
    public void add(Medicine medicine) {
        addMedicine(medicine); // 重用原有实现
    }

    @Override
    public List<Medicine> getAll() {
        return getAllMedicines();
    }
    /**
     * 添加新药材到数据库
     * @param medicine 包含药材信息的对象
     */
    public void addMedicine(Medicine medicine) {
        String sql = "INSERT INTO medicines(name, flavor, classify, efficacy, therapy, usage, taboo) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // 设置预处理参数
            pstmt.setString(1, medicine.getName());
            pstmt.setString(2, medicine.getFlavor());
            pstmt.setString(3, medicine.getClassify());
            pstmt.setString(4, medicine.getEfficacy());
            pstmt.setString(5, medicine.getTherapy());
            pstmt.setString(6, medicine.getUsage());
            pstmt.setString(7, medicine.getTaboo());

            // 执行插入操作
            int affectedRows = pstmt.executeUpdate();
            System.out.println("已成功添加 " + affectedRows + " 条药材记录");
        } catch (SQLException e) {
            System.err.println("添加药材时发生错误：");
            e.printStackTrace();
        }
    }

    /**
     * 获取所有药材信息
     * @return 包含全部药材对象的列表
     */
    public List<Medicine> getAllMedicines() {
        List<Medicine> medicines = new ArrayList<>();
        String sql = "SELECT name, flavor, classify, efficacy, therapy, usage, taboo FROM medicines";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("正在查询药材数据...");
            while (rs.next()) {
                // 从结果集构建药材对象
                medicines.add(new Medicine(
                        rs.getString("name"),
                        rs.getString("flavor"),
                        rs.getString("classify"),
                        rs.getString("efficacy"),
                        rs.getString("therapy"),
                        rs.getString("usage"),
                        rs.getString("taboo")
                ));
            }
        } catch (SQLException e) {
            System.err.println("查询药材时发生错误：");
            e.printStackTrace();
        }
        return medicines;
    }


}