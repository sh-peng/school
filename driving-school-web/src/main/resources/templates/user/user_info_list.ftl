<table id="table" class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
	<thead class="thead" id="${schoolUserList.pages}">
	<tr class="text-c">
		<th width="25"><input type="checkbox" name="" value=""></th>
		<th width="80">姓名</th>
		<th width="80">性别</th>
		<th width="120">邮箱</th>
		<th width="75">有效性</th>
		<th width="60">创建时间</th>
		<th width="80">更新时间</th>
		<th width="120">操作</th>
	</tr>
</thead>
<tbody>
	<#if schoolUserList??>
  		<#if schoolUserList.list?? && schoolUserList.list?size &gt; 0>
  			 <#list schoolUserList.list as schoolUser>
  			 	<tr  class="text-c">
					<td><input name="" type="checkbox" value="${schoolUser.userId}" /></td>
					<td>${schoolUser.userName}</td>
					<td>${schoolUser.sex}</td>
					<td>${schoolUser.email}</td>
					<td class="td-status"><span class="label label-success radius">
						<#if schoolUser.cancelFlag == 'Y'>
							有效
						</#if>
						<#if schoolUser.cancelFlag == 'N'>
							无效
						</#if>
					</span></td>
					<td>${schoolUser.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
					<td>${schoolUser.updateTime?string("yyyy-MM-dd HH:mm:sss")}</td>
					<td class="f-14 td-manage"><a class="colse" style="text-decoration:none" href="javascript:;" title="无效"><i class="Hui-iconfont">&#xe6de;</i></a> <a style="text-decoration:none" class="ml-5" onClick="article_edit('资讯编辑','article-add.html','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="article_del(this,'10001')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
					</tr>
	  			 </#list>
	       	 <#else>
	  		  <tr></tr> 
  			 </#if>
  		</#if>
	</tbody>
</table>