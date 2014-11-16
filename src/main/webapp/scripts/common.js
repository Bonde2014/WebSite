

function pageLink(url){
	window.location.href=root+url;
}

function productDetail(productId){
	var productDetailUrl = root+"/searchProduct.do?productId="+productId;
	window.open(productDetailUrl, "克莱姆购物平台");
}

function productSearch(keyword, catalog, page) {
	if (keyword) {
		$('#keyword').val(keyword);
	}
	if (catalog) {
		$('#catalog').val(catalog);
	}
	if (page) {
		$('#page').val(page);
	}
	if(!$('#page').val()){
		$('#page').val(1);
	}
	$('#searchForm').attr("action",root+"/doSearch.do");
	$('#searchForm').submit();
}

function catalogSearch(catalog,page) {
	if (catalog) {
		$('#catalog').val(catalog);
	}
	if (page) {
		$('#page').val(page);
	}
	if(!$('#page').val()){
		$('#page').val(1);
	}
	$('#searchForm').attr("action",root+"/searchCatalog.do");
	$('#searchForm').submit();
}


/**
 * 从后台获取商品分类树，组织分类导航链接
 * @param dldm 获取某个大类代码的分类树
 * @return
 */
function requestCatalogTree(dldm){
	$.ajax({
		type : "GET",
		url : root+"/getCatalog.do?"+Math.random(),// 请求的action路径
		data : {
			"spflDm" : dldm  //大类代码
		},
		async : false,
		error : function() {// 请求失败处理函数
			alert("call error...");
		},
		success : function(data) {
			if(!data){
				return;
			}
		   var dllb = eval("("+data+")")
		   var catlogstr="";
		   var isOdd=true;
		   //循环大类列表
		   for(var i=0; i< dllb.length; i++) {
		      listr= isOdd?"<li>":"<li class=\"odd\">";  //奇偶行样式不同
		      isOdd=!isOdd;
		      listr=listr+"<h2><a href=\"javascript:void(0)\" onclick=\"catalogSearch("+dllb[i].dldm+",1)\" >"+dllb[i].dlmc+"</a></h2>"; 
		      var xllb=dllb[i].xllb;
		      if (xllb.length==0)  listr=listr+"<span></span>"; //空白行
		      //循环小类列表
		      for (var j=0; j< xllb.length; j++){
		        listr=listr+"<span><a href=\"javascript:void(0)\" onclick=\"catalogSearch("+xllb[j].spflDm+",1)\" >"+xllb[j].spflMc+"</a></span>";
		      }
		      catlogstr=catlogstr+listr+"</li>"
		   }
		   $('#catalogtree').html(catlogstr);  //如果没有“catlogTree”这一层，是不是就是result[0]取值
		}
	});
   }
