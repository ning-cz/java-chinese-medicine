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
    /**
     * 获取药材名称。
     *
     * @return 药材名称
     */
    public String getName() { return name; }

    /**
     * 设置药材名称。
     *
     * @param name 要设置的药材名称
     */
    public void setName(String name) { this.name = name; }

    /**
     * 获取药材味道。
     *
     * @return 药材味道
     */
    public String getFlavor() { return flavor; }

    /**
     * 设置药材味道。
     *
     * @param flavor 要设置的药材味道
     */
    public void setFlavor(String flavor) { this.flavor = flavor; }

    /**
     * 获取药材分类。
     *
     * @return 药材分类
     */
    public String getClassify() { return classify; }

    /**
     * 设置药材分类。
     *
     * @param classify 要设置的药材分类
     */
    public void setClassify(String classify) { this.classify = classify; }

    /**
     * 获取药材功效。
     *
     * @return 药材功效
     */
    public String getEfficacy() { return efficacy; }

    /**
     * 设置药材功效。
     *
     * @param efficacy 要设置的药材功效
     */
    public void setEfficacy(String efficacy) { this.efficacy = efficacy; }

    /**
     * 获取药材治疗方法。
     *
     * @return 药材治疗方法
     */
    public String getTherapy() { return therapy; }

    /**
     * 设置药材治疗方法。
     *
     * @param therapy 要设置的药材治疗方法
     */
    public void setTherapy(String therapy) { this.therapy = therapy; }

    /**
     * 获取药材使用方法。
     *
     * @return 药材使用方法
     */
    public String getUsage() { return usage; }

    /**
     * 设置药材使用方法。
     *
     * @param usage 要设置的药材使用方法
     */
    public void setUsage(String usage) { this.usage = usage; }

    /**
     * 获取药材禁忌。
     *
     * @return 药材禁忌
     */
    public String getTaboo() { return taboo; }

    /**
     * 设置药材禁忌。
     *
     * @param taboo 要设置的药材禁忌
     */
    public void setTaboo(String taboo) { this.taboo = taboo; }}
