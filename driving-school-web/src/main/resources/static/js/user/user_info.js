$(function () {

  var $document = $(document);
  var $pagination = $('#pagination');
  var $table = $('#table');
  var totalNum = $('#totalNum').val();
  
  //分页点击开始
  $('#pagination').pagination({
	  items: totalNum,
	  prevText:'上一页',
      nextText:'下一页',
	    onPageClick: function (pageNumber) {
	      var pageSize = $('#dropdownMenu1').val();
	      $.ajax({
	    	type:"POST",
	        url: '/driving-school/queryStudentInfoListAjax',
	        dataType: 'html',
	        data:{
	        	pageNum:pageNumber,
	        	pageSize:pageSize
	        },
	        success: function (data) {
	        	 //填充数据
	            var $tableContainer = $(data);
	            var $tableContent = $($tableContainer.html());
	            //渲染表格数据
	            $table.empty();
	            $table.append($tableContent);
	            //刷新分页数据
	            var totals = $('.thead').attr('id');
	            $pagination.pagination('updateItems',totals);
	        },
	        error: function (err) {
	          console.log("获取分页数据失败" + err)
	        }
	      })
	    }
	});
  //分页点击结束
  
  //点击跳转某一页开始
  $document.on('click','.btn-default',function () {
  	 var page = $('#page').val();
  	 if(page==''){
  		 return false;
  	 }
  	 if(parseInt(page)>parseInt(totalNum)){
  		 page = totalNum;
  	 }
  	 if(parseInt(page)==parseInt(0)){
  		 page = 1;
  	 }
  	 if(parseInt(page)<parseInt(0)){
  		 page = 1;
  	 }
  	$('#page').val(page);
  	 //翻页的时候
  	 //branchName = $('#search-attr-name').val();
  	 $pagination.pagination('selectPage', page);
  });
  //点击跳转某一页结束
  
  //设置无效
  $document.on('click','.colse',function(){
	  var $this = $(this);
	  var id = '10001';
	  layer.confirm('确认要设为无效吗吗？',function(index){
		  $this.parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_start(this,id)" href="javascript:;" title="无效"><i class="Hui-iconfont">&#xe603;</i></a>');
		  $this.parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已无效</span>');
		  $this.remove();
	  	  layer.msg('已无效!',{icon: 5,time:1000});
	  });
  });
  
  $document.on('click','.dropdown-toggle',function(){
	  if($(".dropdown").hasClass("open")){
		  $(".dropdown").removeClass("open"); // 追加样式
	  }else{
		  $(".dropdown").addClass("open"); // 追加样式
	  }
  });
  
  /*资讯-添加*/
  function article_add(title,url,w,h){
  	var index = layer.open({
  		type: 2,
  		title: title,
  		content: url
  	});
  	layer.full(index);
  }
  /*资讯-编辑*/
  function article_edit(title,url,id,w,h){
  	var index = layer.open({
  		type: 2,
  		title: title,
  		content: url
  	});
  	layer.full(index);
  }
  /*资讯-删除*/
  function article_del(obj,id){
  	layer.confirm('确认要删除吗？',function(index){
  		$.ajax({
  			type: 'POST',
  			url: '',
  			dataType: 'json',
  			success: function(data){
  				$(obj).parents("tr").remove();
  				layer.msg('已删除!',{icon:1,time:1000});
  			},
  			error:function(data) {
  				console.log(data.msg);
  			},
  		});		
  	});
  }

  /*资讯-审核*/
  function article_shenhe(obj,id){
  	layer.confirm('审核文章？', {
  		btn: ['通过','不通过','取消'], 
  		shade: false,
  		closeBtn: 0
  	},
  	function(){
  		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
  		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
  		$(obj).remove();
  		layer.msg('已发布', {icon:6,time:1000});
  	},
  	function(){
  		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
  		$(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
  		$(obj).remove();
      	layer.msg('未通过', {icon:5,time:1000});
  	});	
  }
  /*资讯-下架*/
  function article_stop(obj,id){
  	layer.confirm('确认要下架吗？',function(index){
  		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
  		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
  		$(obj).remove();
  		layer.msg('已下架!',{icon: 5,time:1000});
  	});
  }

  /*资讯-发布*/
  function article_start(obj,id){
  	layer.confirm('确认要发布吗？',function(index){
  		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
  		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
  		$(obj).remove();
  		layer.msg('已发布!',{icon: 6,time:1000});
  	});
  }
  /*资讯-申请上线*/
  function article_shenqing(obj,id){
  	$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
  	$(obj).parents("tr").find(".td-manage").html("");
  	layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
  }
  
})