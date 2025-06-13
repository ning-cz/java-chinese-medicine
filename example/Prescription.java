package org.example;
/**
 * 该类表示药方的实体类，包含药方的基本信息。
 */
public class Prescription {
    // 药方ID
    private int id;
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
     * @param id 药方ID
     * @param name 药方名称
     * @param from 药方来源
     * @param composition 药方成分
     * @param efficiency 药方功效
     * @param therapy 药方对应的治疗方法
     * @param usage 药方的使用方法
     * @param taboo 药方的禁忌
     */
    public Prescription(int id, String name, String from, String composition, String efficiency, String therapy, String usage, String taboo) {
        this.id = id;
        this.name = name;
        this.from = from;
        this.composition = composition;
        this.efficiency = efficiency;
        this.therapy = therapy;
        this.usage = usage;
        this.taboo = taboo;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getComposition() {
        return composition;
    }
    public void setComposition(String composition) {
        this.composition = composition;
    }
    public String getEfficiency() {
        return efficiency;
    }
    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
    public String getTherapy() {
        return therapy;
    }
    public void setTherapy(String therapy) {
        this.therapy = therapy;
    }
    public String getUsage() {
        return usage;
    }
    public void setUsage(String usage) {
        this.usage = usage;
    }
    public String getTaboo() {
        return taboo;
    }
    public void setTaboo(String taboo) {
        this.taboo = taboo;
    }

    // 兼容导出和查询功能的补充方法
    public String getMainEffect() {
        // TODO: 实际应返回主治信息，这里暂用efficiency字段
        return efficiency;
    }
    public String getMedicineNames() {
        // TODO: 实际应返回药材名列表，这里暂用composition字段
        return composition;
    }
    public int getPopularity() {
        // TODO: 实际应返回人气值，这里返回0
        return 0;
    }
}