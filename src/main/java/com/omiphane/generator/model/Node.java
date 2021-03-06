package com.omiphane.generator.model;

public class Node {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column node.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column node.parent_id
     *
     * @mbggenerated
     */
    private Integer parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column node.text
     *
     * @mbggenerated
     */
    private String text;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column node.leaf
     *
     * @mbggenerated
     */
    private String leaf;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column node.cls
     *
     * @mbggenerated
     */
    private Integer cls;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column node.icon_cls
     *
     * @mbggenerated
     */
    private String iconCls;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column node.checked
     *
     * @mbggenerated
     */
    private String checked;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column node.page
     *
     * @mbggenerated
     */
    private String page;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column node.node_type
     *
     * @mbggenerated
     */
    private String nodeType;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column node.id
     *
     * @return the value of node.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column node.id
     *
     * @param id the value for node.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column node.parent_id
     *
     * @return the value of node.parent_id
     *
     * @mbggenerated
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column node.parent_id
     *
     * @param parentId the value for node.parent_id
     *
     * @mbggenerated
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column node.text
     *
     * @return the value of node.text
     *
     * @mbggenerated
     */
    public String getText() {
        return text;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column node.text
     *
     * @param text the value for node.text
     *
     * @mbggenerated
     */
    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column node.leaf
     *
     * @return the value of node.leaf
     *
     * @mbggenerated
     */
    public String getLeaf() {
        return leaf;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column node.leaf
     *
     * @param leaf the value for node.leaf
     *
     * @mbggenerated
     */
    public void setLeaf(String leaf) {
        this.leaf = leaf == null ? null : leaf.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column node.cls
     *
     * @return the value of node.cls
     *
     * @mbggenerated
     */
    public Integer getCls() {
        return cls;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column node.cls
     *
     * @param cls the value for node.cls
     *
     * @mbggenerated
     */
    public void setCls(Integer cls) {
        this.cls = cls;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column node.icon_cls
     *
     * @return the value of node.icon_cls
     *
     * @mbggenerated
     */
    public String getIconCls() {
        return iconCls;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column node.icon_cls
     *
     * @param iconCls the value for node.icon_cls
     *
     * @mbggenerated
     */
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls == null ? null : iconCls.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column node.checked
     *
     * @return the value of node.checked
     *
     * @mbggenerated
     */
    public String getChecked() {
        return checked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column node.checked
     *
     * @param checked the value for node.checked
     *
     * @mbggenerated
     */
    public void setChecked(String checked) {
        this.checked = checked == null ? null : checked.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column node.page
     *
     * @return the value of node.page
     *
     * @mbggenerated
     */
    public String getPage() {
        return page;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column node.page
     *
     * @param page the value for node.page
     *
     * @mbggenerated
     */
    public void setPage(String page) {
        this.page = page == null ? null : page.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column node.node_type
     *
     * @return the value of node.node_type
     *
     * @mbggenerated
     */
    public String getNodeType() {
        return nodeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column node.node_type
     *
     * @param nodeType the value for node.node_type
     *
     * @mbggenerated
     */
    public void setNodeType(String nodeType) {
        this.nodeType = nodeType == null ? null : nodeType.trim();
    }
}