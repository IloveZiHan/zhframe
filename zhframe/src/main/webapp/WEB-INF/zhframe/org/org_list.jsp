<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>组织机构管理</title>
	<%@include file="/common/easyui.jsp"%>
</head>
<body class="easyui-layout">
	<%@include file="org_form.jsp" %>

	<div data-options="region:'west',split:true,title:'组织机构树'" style="width:200px;padding:10px;">
		<ul class="easyui-tree" id="orgTree" data-options="url:'<%=cxtPath %>/org/listAll.do',method:'get',animate:true,lines:true,
				onContextMenu: function(e,node){
					e.preventDefault();
					$(this).tree('select',node.target);
					$('#treeCxtMenu').menu('show',{
						left: e.pageX,
						top: e.pageY
					});
				}">
		</ul>
	</div>
	<div data-options="region:'center'" class="easyui-layout">
		<div data-options="region:'center',border:false">
			<table class="easyui-datagrid" title="员工列表" style="width:100%;height:100%;"
				data-options="singleSelect:true,collapsible:false,url:'datagrid_data1.json',method:'post',toolbar:toolbar">
				<thead>
					<tr>
						<th data-options="field:'id',width:80">id</th>
						<th data-options="field:'name',width:100">姓名</th>
						<th data-options="field:'userid',width:80,align:'right'">登录帐号</th>
					</tr>
				</thead>
			</table>
		</div>
		<div data-options="region:'south',border:false">
			<div class="easyui-pagination" data-options="total:114"></div>
		</div>
	</div>
	
	<div id="treeCxtMenu" class="easyui-menu" style="width:120px;">
		<div onclick="onClickAddSubOrg()" data-options="iconCls:'icon-add'">添加子部门</div>
		<div onclick="" data-options="iconCls:'icon-add'">添加岗位</div>
		<div onclick="" data-options="iconCls:'icon-add'">添加员工</div>
		<div class="menu-sep"></div>
		<div onclick="onClickDeleteOrg()" data-options="iconCls:'icon-remove'">删除</div>
	</div>
	
	<script type="text/javascript">
	
		var toolbar = [{
			text:'添加',
			iconCls:'icon-add',
			handler:function(){ 
				alert("add!");
			}
		},{
			text:'编辑',
			iconCls:'icon-edit',
			handler:function(){alert('cut')}
		},{
			text:'删除',
			iconCls:'icon-remove',
			handler:function(){alert('save')}
		},'-', {
			text: "查看",
			iconCls:'icon-ok',
			handler:function(){alert('save')}
		}];

		function onClickAddSubOrg() {
			$('#pid').val(getSelectedOrgId());
			$('#windowAddOrg').window('open');
		}
		
		function getSelectedOrgId() {
			var selNode = $("#orgTree").tree('getSelected');
			
			return selNode.id;
		}
		
		function onClickDeleteOrg() {
			$.ajax({
				url: cxtPath + "/org/deleteOrg.do",
				data: 'orgId=' + getSelectedOrgId(),
				type: "post",
				success: function() {
					$.messager.alert('提示','删除成功!');
					$('#orgTree').tree('reload');
				}
			});
		}
	</script>
</body>
</html>