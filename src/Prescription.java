/**
 * 该类表示药方的实体类，包含药方的基本信息。
 */
public class Prescription {
    // 药方名称
    private String name;
    // 药方来源
    private String from;
    // 药方成分
    private String composition;
    // 药方功效
    private String efficiency;
    // 药方对应的治疗方法
    private String therapy;
    // 药方的使用方法
    private String usage;
    // 药方的禁忌
    private String taboo;

    /**
     * 构造函数，用于初始化药方对象。
     *
     * @param name 药方名称
     * @param from 药方来源
     * @param composition 药方成分
     * @param efficiency 药方功效
     * @param therapy 药方对应的治疗方法
     * @param usage 药方的使用方法
     * @param taboo 药方的禁忌
     */
    public Prescription(String name, String from, String composition, String efficiency, String therapy, String usage, String taboo) {
        this.name = name;
        this.from = from;
        this.composition = composition;
        this.efficiency = efficiency;
        this.therapy = therapy;
        this.usage = usage;
        this.taboo = taboo;
    }

    // Getters and Setters
    /**
     * 获取药方名称。
     *
     * @return 药方名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置药方名称。
     *
     * @param name 要设置的药方名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取药方来源。
     *
     * @return 药方来源
     */
    public String getFrom() {
        return from;
    }

    /**
     * 设置药方来源。
     *
     * @param from 要设置的药方来源
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * 获取药方成分。
     *
     * @return 药方成分
     */
    public String getComposition() {
        return composition;
    }

    /**
     * 设置药方成分。
     *
     * @param composition 要设置的药方成分
     */
    public void setComposition(String composition) {
        this.composition = composition;
    }

    /**
     * 获取药方功效。
     *
     * @return 药方功效
     */
    public String getEfficiency() {
        return efficiency;
    }

    /**
     * 设置药方功效。
     *
     * @param efficiency 要设置的药方功效
     */
    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    /**
     * 获取药方对应的治疗方法。
     *
     * @return 药方对应的治疗方法
     */
    public String getTherapy() {
        return therapy;
    }

    /**
     * 设置药方对应的治疗方法。
     *
     * @param therapy 要设置的药方对应的治疗方法
     */
    public void setTherapy(String therapy) {
        this.therapy = therapy;
    }

    /**
     * 获取药方的使用方法。
     *
     * @return 药方的使用方法
     */
    public String getUsage() {
        return usage;
    }

    /**
     * 设置药方的使用方法。
     *
     * @param usage 要设置的药方的使用方法
     */
    public void setUsage(String usage) {
        this.usage = usage;
    }

    /**
     * 获取药方的禁忌。
     *
     * @return 药方的禁忌
     */
    public String getTaboo() {
        return taboo;
    }

    /**
     * 设置药方的禁忌。
     *
     * @param taboo 要设置的药方的禁忌
     */
    public void setTaboo(String taboo) {
        this.taboo = taboo;
    }
}