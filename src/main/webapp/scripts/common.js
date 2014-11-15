

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
	$('#searchForm').submit();
}