var yfmenu = (function () {
    var $m = $("#menus");

    var bindRootmenu = function () {
        $("#menus>li").mouseover(function () {
            if ($(this).find("ul").length == 0) return;
            $("#menus>li>a").removeClass("hover");
            $("#menus ul").css("visibility", "hidden");
            var thisa = $(this).find("a:eq(0)");
            thisa.addClass("hover");
            thisa.next("ul").css("visibility", "visible");


        }).mouseleave(function () {
            $("#menus>li>a").removeClass("hover");
            $("#menus ul").css("visibility", "hidden");
        })

        $("#menus li").not("#menus>li").mouseover(function (e) {
            e.preventDefault();
            e.stopPropagation();

            var thisa2 = $(this).find("a:eq(0)");
            thisa2.next("ul").css("visibility", "visible");
        }).mouseleave(function (e) {

            var thisa2 = $(this).find("a:eq(0)");
            thisa2.next("ul").css("visibility", "hidden");
        })

    }

    var bindClick = function () {
        $m.find("li").click(function () {
            removeHover($(this));
        })
    }
    var removeHover = function (obj) {
        var rootitem = obj.prevUntil(".hover");
        rootitem.find("ul").hide();
    }

    var init = function () {
        bindRootmenu();
        bindClick();
    }

    return {
        rootmenu: bindRootmenu,
        menudrop: bindClick,
        hidemenu: removeHover,
        init: init
    }

})();

 

(function ($) {

    $.fn.turnPic = function () {
        var index = 0;
        var showUl = $(this).children("ul.pic_list").children("li");
        var len = showUl.length;
        var navList = $(this).children("div").children("a");
        var timer;
        navList.mouseover(function () {
            index = navList.index(this);
            showImg(index);
        }).eq(0).mouseover();
        $(this).hover(function () {
            clearInterval(timer);
        }, function () {
            timer = setInterval(function () {
                showImg(index);
                index++;
                if (index == len) {
                    index = 0;
                }
            }, 3000)
        }).trigger("moverleave");

        function showImg(index) {
            showUl.eq(index).stop(true, true).fadeIn("slow").siblings().fadeOut("slow");
            navList.removeClass("select").css("opacity", "0.7").eq(index).addClass("select").css("opacity", "1");
        }
    }

    jQuery.fn.extend({

        replaceClass: function (c1, c2) {
            return this.filter('.' + c1).removeClass(c1).addClass(c2).end();
        },

        /**
		@功能：设置切换盒组件
		@参数： def:"class1" 默认的按钮效果
				chg:"class2" 变化后的按钮效果	
				chglist:"具体的需要变化的列表对象选择" 
				wennull:"当chglist里的内容为空时是否需要显示该BOX" 	
				index:"默认显示第几个" 	
				bindevent:"绑定事件"
		@返回:  无
		@实例:  $(".index_top2 .box3 .list2 div").SwichBox({def:"b2",chg:"b1",chglist:".index_top2 .box3 .list2 ul"})	
		*/
        SwichBox: function (settings) {
            settings = $.extend({ def: "", chg: "", chglist: "", whennull: false, index: 0, bindevent: "mouseover" }, settings);
            var now = $(this);
            now.unbind();
            settings.chg = settings.chg.replace(".", "");
            settings.def = settings.def.replace(".", "");
            now.each(function (index) {
                if (index == settings.index) {
                    $(this).addClass(settings.chg);
                    $(settings.chglist).eq(index).css("display", "");
                    if (settings.whennull) {
                        if ($(settings.chglist).eq(index).html() == "") { $(settings.chglist).eq(index).css("display", "none") }
                    }

                } else {
                    $(this).removeClass(settings.chg).addClass(settings.def);
                    $(settings.chglist).eq(index).css("display", "none");
                }

                $(this).bind(
					settings.bindevent,
					function () {
					    if ($(this).hasClass("class") == settings.chg) return;
					    if ($(this).attr("disable")) { return; }

					    now.removeClass(settings.chg).addClass(settings.def);
					    $(this).removeClass(settings.def).addClass(settings.chg);

					    $(settings.chglist).css("display", "none");
					    $(settings.chglist).eq(index).fadeIn("fast");
					    if (settings.whennull) {
					        if ($(settings.chglist).eq(index).html() == "") { $(settings.chglist).eq(index).css("display", "none") }
					    }
					}
				)
            })
        }
    });
})(jQuery);