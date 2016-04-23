package cn.springmvc.model;


import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户表
 * @author xulq
 * 2014年2月11日
 */
public class NodeGroup {

	private Integer nid ;
	private String id;
	private Integer parentId;
	private String text;
	private String memo;
	private Integer userGroupId;
	private String expanded;
	private String url;
	private boolean leaf;
	private boolean checked;
	private List<NodeGroup> children;

	public NodeGroup(){
		this.checked = false;
		this.leaf = true;
		this.children = new ArrayList<NodeGroup>();
	}
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Integer userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<NodeGroup> getChildren() {
		return children;
	}

	public void setChildren(List<NodeGroup> children) {
		this.children = children;
	}

	public String getExpanded() {
		return expanded;
	}

	public void setExpanded(String expanded) {
		this.expanded = expanded;
	}

	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
