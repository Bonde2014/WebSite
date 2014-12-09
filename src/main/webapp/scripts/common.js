
function pageLink(url) {
	window.location.href = root + url;
}

function productDetail(productId) {
	var productDetailUrl = root + "/searchProduct.do?productId=" + productId;
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
	if (!$('#page').val()) {
		$('#page').val(1);
	}
	$('#searchForm').attr("action", root + "/doSearch.do");
	$('#searchForm').submit();
}

function catalogSearch(catalog, page) {
	if (catalog) {
		$('#catalog').val(catalog);
	}
	if (page) {
		$('#page').val(page);
	}
	if (!$('#page').val()) {
		$('#page').val(1);
	}
	$('#searchForm').attr("action", root + "/searchCatalog.do");
	$('#searchForm').submit();
}

/**
 * 从后台获取商品分类树，组织分类导航链接
 * 
 * @param dldm
 *            获取某个大类代码的分类树
 * @return
 */
function requestCatalogTree(dldm) {
	$
			.ajax({
				type : "GET",
				url : root + "/getCatalog.do?" + Math.random(),// 请求的action路径
				data : {
					"spflDm" : dldm
				// 大类代码
				},
				async : false,
				error : function() {// 请求失败处理函数
					alert("call error...");
				},
				success : function(data) {
					if (!data) {
						return;
					}
					var dllb = eval("(" + data + ")")
					var catlogstr = "";
					var isOdd = true;
					// 循环大类列表
					for (var i = 0; i < dllb.length; i++) {
						listr = isOdd ? "<li>" : "<li class=\"odd\">"; // 奇偶行样式不同
						isOdd = !isOdd;
						listr = listr
								+ "<h2><a href=\"javascript:void(0)\" onclick=\"catalogSearch("
								+ dllb[i].dldm + ",1)\" >" + dllb[i].dlmc
								+ "</a></h2>";
						var xllb = dllb[i].xllb;
						if (xllb.length == 0)
							listr = listr + "<span></span>"; // 空白行
						// 循环小类列表
						for (var j = 0; j < xllb.length; j++) {
							listr = listr
									+ "<span><a href=\"javascript:void(0)\" onclick=\"catalogSearch("
									+ xllb[j].spflDm + ",1)\" >"
									+ xllb[j].spflMc + "</a></span>";
						}
						catlogstr = catlogstr + listr + "</li>"
					}
					$('#catalogtree_dispaly').html(catlogstr);
				}
			});
	// 获取全部商品分类
	$
			.ajax({
				type : "POST",
				url : root + "/getAllCatalog.do",
				async : false,
				error : function() {
				},
				success : function(data) {
					if (!data) {
						return;
					}
					var catalogArray = eval("(" + data + ")")
					var catalogstr = "";
					var isOdd = true;
					// 循环大类列表
					for (var i = 0; i < catalogArray.length; i++) {
						var thirdChildStr ="<div class=\"othermenu\"><div class=\"mask\"></div>";
						catalogstr+=isOdd ? "<li>" : "<li class=\"odd\">"; // 奇偶行样式不同
						isOdd = !isOdd;
						var str1 = "<h2><a href=\"javascript:void(0)\" onclick=\"catalogSearch("
								+ catalogArray[i].id + ",1)\" >"
								+ catalogArray[i].name + "</a></h2>";
						var childArray = catalogArray[i].childList;
						if (childArray) {
							// 循环小类列表
							for (var j = 0; j < childArray.length; j++) {
								// 循环三级列表
								var thirdChildArray = childArray[j].childList;
								if (thirdChildArray) {
									thirdChildStr = "<dl><dt><a href=\"javascript:void(0)\" onclick=\"catalogSearch("
										+ childArray[j].id + ",1)\" >"
										+ childArray[j].name + "</a></dt><dd>";
									for (var k = 0; k < thirdChildArray.length; k++) {
										thirdChildStr+="<em><a href=\"javascript:void(0)\" onclick=\"catalogSearch("
										+ thirdChildArray[k].id + ",1)\" >"
										+ thirdChildArray[k].name + "</a></em>";
									}
									thirdChildStr+="</dd></dl>";
								}
								str1+= "<span><a href=\"javascript:void(0)\" onclick=\"catalogSearch("
										+ childArray[j].id + ",1)\" >"
										+ childArray[j].name + "</a></span>";
							}
						}
						thirdChildStr+="</div>";
						catalogstr+=thirdChildStr+ str1 + "</li>"
					}
					$('#catalogtree').html(catalogstr);
				}
			});
}
