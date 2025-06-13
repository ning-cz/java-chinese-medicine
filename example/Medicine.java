package org.example;
/**
 * 该类表示药材的实体类，包含药材的基本信息。
 */
public class Medicine {
    // 药材名称
    private String name;
    // 药材味道
    private String flavor;
    // 药材分类
    private String classify;
    // 药材功效
    private String efficacy;
    // 药材治疗方法
    private String therapy;
    // 药材使用方法
    private String usage;
    // 药材禁忌
    private String taboo;

    /**
     * 构造函数，用于初始化药材对象。
     *
     * @param name 药材名称
     * @param flavor 药材味道
     * @param classify 药材分类
     * @param efficacy 药材功效
     * @param therapy 药材治疗方法
     * @param usage 药材使用方法
     * @param taboo 药材禁忌
     */
    public Medicine(String name, String flavor, String classify, String efficacy, String therapy, String usage, String taboo) {
        this.name = name;
        this.flavor = flavor;
        this.classify = classify;
        this.efficacy = efficacy;
        this.therapy = therapy;
        this.usage = usage;
        this.taboo = taboo;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getFlavor() { return flavor; }
    public void setFlavor(String flavor) { this.flavor = flavor; }
    public String getClassify() { return classify; }
    public void setClassify(String classify) { this.classify = classify; }
    public String getEfficacy() { return efficacy; }
    public void setEfficacy(String efficacy) { this.efficacy = efficacy; }
    public String getTherapy() { return therapy; }
    public void setTherapy(String therapy) { this.therapy = therapy; }
    public String getUsage() { return usage; }
    public void setUsage(String usage) { this.usage = usage; }
    public String getTaboo() { return taboo; }
    public void setTaboo(String taboo) { this.taboo = taboo; }

    // 兼容导出和查询功能的补充方法
    public String getMainEffect() {
        // TODO: 实际应返回主治信息，这里暂用efficacy字段
        return efficacy;
    }
    public String getMedicineNames() {
        // TODO: 实际应返回药材名，这里暂用name字段
        return name;
    }
    public int getPopularity() {
        // TODO: 实际应返回人气值，这里返回0
        return 0;
    }
}