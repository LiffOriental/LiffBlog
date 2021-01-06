layui.use(['element','jquery','layer'], function(){
    var element = layui.element;
    var $=layui.jquery;
    var layer=layui.layer;

    $('#login').click(function (){
        layer.open({
            type: 2,
            title: '登录',
            shadeClose: true,
            shade: 0.8,
            area: ['500PX', '375PX'],
            content: '../user/tologin',

            success:function (layero, index){
                //获取当前iframe的文档对象
                // var body = parent.layui.layer.getChildFrame('body', index);
                // var iframeWin = window[layero.find('iframe')[0]['name']];

                // var obj = $(layero).find("iframe")[0].contentWindow;

            }
        });
    });
    $('#register').click(function (){
        layer.open({
            type: 2,
            title: '注册',
            shadeClose: true,
            shade: 0.8,
            area: ['500PX', '375PX'],
            content: '../user/toregister',
            success:function (layero, index){

            }



        });
    });
    var sessionStorage = window.sessionStorage;
    var userjson = JSON.parse(sessionStorage.getItem("user"));
    var user = $.parseJSON(userjson);
    if(user==null){
        $("#unlogin",window.document).attr("display","inline");
        $("#unlogin",window.document).show();

    }else{
        $("#unlogin",window.document).hide();
        $("#enlogin",window.document).show();
    }

    $('#articleedit').click(function () {
        layer.open({
            type: 2,
            title: '编辑',
            shadeClose: true,
            shade: 0.8,
            area: ['60%', '80%'],
            content: '../article/toedit',
            success: function (layero, index) {

            }
        });
    });

});




