<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />

<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />

<!-- 分页所需 -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/autoComplete.css" />
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/product/common.css" />

<title>学员列表</title>
</head>
<body>
<nav class="breadcrumb" style="padding:0px 15px">
	<i class="Hui-iconfont">&#xe67f;</i> 
	学员管理 <span class="c-gray en">&gt;</span> 
	学员信息 <span class="c-gray en">&gt;</span> 
	<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="/driving-school/queryUserInfoList" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
	<div class="text-c">
		<button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button>
	 <span class="select-box inline">
		<select name="" class="select">
			<option value="0">全部分类</option>
			<option value="1">分类一</option>
			<option value="2">分类二</option>
		</select>
		</span> 日期范围：
		<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}' })" id="logmin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d' })" id="logmax" class="input-text Wdate" style="width:120px;">
		<input type="text" name="" id="" placeholder="学员姓名" style="width:250px" class="input-text">
		<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i>搜索</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" data-title="添加资讯" data-href="article-add.html" onclick="Hui_admin_tab(this)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加资讯</a></span> <span class="r">共有数据：<strong>${schoolUserList.total}</strong> 条</span> </div>
	
	<section class="main-panel">
		<div class="mt-20" ><#include "/user/user_info_list.ftl"/></div>
	    <div class="pane-bottom clearfix">
	      <div class="pane-bottom-num pull-left">
	       	   每页显示
	        <div class="dropdown">
		          <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" value="${schoolUserList.pageSize}" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
		            		${schoolUserList.pageSize}
		            <span class="caret"></span>
		          </button>
		          <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
		          	<li><a href="/retail-shop/bizBranch/queryBizBranchPageList.do?pageSize=15">15</a></li>
		            <li><a href="/retail-shop/bizBranch/queryBizBranchPageList.do?pageSize=30">30</a></li>
		            <li><a href="/retail-shop/bizBranch/queryBizBranchPageList.do?pageSize=50">50</a></li>
		            <li><a href="/retail-shop/bizBranch/queryBizBranchPageList.do?pageSize=100">100</a></li>
		          </ul>
	        </div>
	                       条
	      </div>
	      <nav class="pull-right" aria-label="Page navigation">
	        <p class="page-num-total">共 <span>${schoolUserList.total}</span> 条记录</p>
	        <input type="hidden" id="totalNum" value="${schoolUserList.pages}"/>
	        <ul id="pagination" class="pagination"></ul>
	        <div class="page-jump">
	          	跳至<input type="text" id="page"  <#if schoolUserList.pages lte 1>disabled="disabled"</#if>  class="form-control">页
	          <button class="btn btn-default" <#if schoolUserList.pages lte 1>disabled="disabled"</#if>>确定</button>
	        </div>
	      </nav>
	    </div>
	</section>
</div>

<!--_footer 作为公共模版分离出去-->
<!-- <script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>  -->
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>

<!-- 分页所需 -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/pagination.min.js"></script>
<script type="text/javascript" src="js/user/user_info.js"></script>
</body>
</html>