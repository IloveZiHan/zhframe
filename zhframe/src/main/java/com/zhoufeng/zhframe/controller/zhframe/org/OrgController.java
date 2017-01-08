package com.zhoufeng.zhframe.controller.zhframe.org;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhoufeng.zhframe.entity.easyui.TreeNode;
import com.zhoufeng.zhframe.entity.org.Organization;
import com.zhoufeng.zhframe.service.org.OrganizationService;

@Controller
@RequestMapping("/org")
@Scope("prototype")
public class OrgController {
	
	@Resource
	private OrganizationService organizationService;
	
	@RequestMapping("/mgr")
	public ModelAndView openOrgManagement() {
		ModelAndView view = new ModelAndView("/zhframe/org/org_list");
		return view;
	}
	
	@RequestMapping("/getByPid")
	@ResponseBody
	public List<Organization> listOrganization() {
		return organizationService.listOrganizationsByPid(null);
	}
	
	@RequestMapping("/listAll")
	@ResponseBody
	public List<TreeNode> listAll() {
		return organizationService.listAll();
	}
	
	@RequestMapping("/insertOrg")
	@ResponseBody
	public void insertOrg(Organization org) {
		organizationService.insert(org);
	}
	
	@RequestMapping("/deleteOrg")
	@ResponseBody
	public void deleteOrg(Integer orgId) {
		organizationService.delete(orgId);
	}
}
