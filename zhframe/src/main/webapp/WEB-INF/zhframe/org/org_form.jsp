<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="windowAddOrg" class="easyui-window" title="添加机构" 
	data-options="modal:true,closed:true,iconCls:'icon-add'" 
	style="width:300px;height:200px;padding:10px;">
	
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center'" style="padding:10px;">
			 <form id="formOrg" method="post">
			 	<input id="pid" name="pid" hidden="hidden"/>
			 
		    	<table cellpadding="5">
		    		<tr>
		    			<td>部门名称:</td>
		    			<td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
		    		</tr>
		    		<tr>
		    			<td>备注:</td>
		    			<td><input class="easyui-textbox" type="text" name="comments" data-options="required:false"></input></td>
		    		</tr>
		    	</table>
		    </form>
		</div>
		<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
			<a class="easyui-linkbutton" id="btnOk" data-options="iconCls:'icon-ok'" href="javascript:void(0)" style="width:80px">确定</a>
			<a class="easyui-linkbutton" id="btnCancel" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" style="width:80px">取消</a>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(function(){
		 $("#btnOk").on("click", function() {
			var data = $("#formOrg").serialize();
			$.ajax({
				url: cxtPath + "/org/insertOrg.do",
				data: data,
				type: "post",
				success: function() {
					$.messager.alert('提示','保存成功!');
					$('#windowAddOrg').dialog('close');
					$('#orgTree').tree('reload');
				}
			});
		 });
		 
		 $("#btnCancel").on("click", function(data) {
			 $('#windowAddOrg').dialog('close');
		 });
	});
</script>