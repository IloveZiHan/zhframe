package com.zhoufeng.zhframe.service.org;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.zhoufeng.zhframe.dao.org.OrganizationDao;
import com.zhoufeng.zhframe.entity.easyui.TreeNode;
import com.zhoufeng.zhframe.entity.org.Organization;

@Service
public class OrganizationService {

	@Resource
	private OrganizationDao organizationDao;
	
	@Transactional
	public void insert(Organization org) {
		organizationDao.save(org);
	}
	
	@Transactional
	public void delete(Integer id) {
		deleteOrgRecursion(id);
	}
	
	/**
	 * 递归删除部门
	 * @param orgId 部门id
	 */
	private void deleteOrgRecursion(Integer orgId) {
		List<Organization> subOrgs = this.listOrganizationsByPid(orgId);
		
		for(Organization subOrg : subOrgs) {
			deleteOrgRecursion(subOrg.getId());
			organizationDao.delete(subOrg.getId(), Organization.class);
		}
		
		organizationDao.delete(orgId, Organization.class);
	}
	
	@Transactional
	public void update(Organization org) {
		organizationDao.update(org);
	}
	
	@Transactional
	public List<TreeNode> listAll() {
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		List<Organization> orgs = organizationDao.listRootOrganizations();
		treeNodes = convertOrgsToTreeNodes(orgs);
		
		for(TreeNode treeNode : treeNodes) {
			treeNode.setChildren(listAllOrgsRecursion(Integer.parseInt(treeNode.getId())));
		}
		
		return treeNodes;
	}
	
	/**
	 * 递归获取树节点
	 * @param pid 父节点id
	 * @return 当前父节点下的节点
	 */
	public List<TreeNode> listAllOrgsRecursion(Integer pid) {
		List<TreeNode> treeNodes = new ArrayList<>();
		List<Organization> orgs = organizationDao.listOrganizationByPid(pid);
		
		treeNodes = convertOrgsToTreeNodes(orgs);
		
		for(TreeNode treeNode : treeNodes) {
			List<TreeNode> subTreeNodes = listAllOrgsRecursion(Integer.parseInt(treeNode.getId()));
			treeNode.setChildren(subTreeNodes);
		}
		
		return treeNodes;
	}
	
	private List<TreeNode> convertOrgsToTreeNodes(List<Organization> orgs) {
		List<TreeNode> treeNodes = new ArrayList<>();
		
		for(Organization org : orgs) {
			treeNodes.add(convertOrgToTreeNode(org));
		}
		
		return treeNodes;
	}
	
	private TreeNode convertOrgToTreeNode(Organization org) {
		TreeNode treeNode = new TreeNode();
		
		treeNode.setId(org.getId().toString());
		treeNode.setText(org.getName());
		
		return treeNode;
	}

	@Transactional
	public List<Organization> listOrganizationsByPid(Integer pid) {
		List<Organization> organizations = new ArrayList<Organization>();
		
		organizations = organizationDao.listOrganizationByPid(pid);
		
		return organizations;
	}
}
