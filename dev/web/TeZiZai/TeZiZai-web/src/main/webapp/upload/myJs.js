jQuery(document).ready(function () {

//	isLegalFiletype();
//	contactAjaxFileUpload();
});

//校验上传文件类型
function isLegalFiletype(filename) {
//	var pattern = /(.jpg|.zip|.html|.htm)$/;
//	if (!pattern.exec(filename)) {
//		alert("文件格式不正确!");
//		return false;
//	}
    return true;
}

function contactAjaxFileUpload() {
//	$("#showTable").empty();
    $("#loadingimg").ajaxStart(function () {
        // 开始上传文件时显示一个图片
        $(this).show();
        alert("上传开始显示提示框");
    }).ajaxComplete(function () {
        // 文件上传完成将图片隐藏起来
        alert("上传完成准备隐藏提示框");
        $(this).hide();
    });

    //
    if (isLegalFiletype($("#uploadToImportFile").val())) {
        $.ajaxFileUpload({
            url: 'http://localhost/TeZiZai-web/upload.do',
            secureuri: false,// 一般设置为false
            fileElementId: 'avatar', // 文件上传控件的id属性 <input
            dataType: 'json',
            success: function (data) { // 服务器成功响应处理函数
                alert("上传成功"+data);
                return;
            },
            error: function (data, e) { // 服务器响应失败处理函数
                alert(e.stack);
                alert("上传失败" + data.timestamp);
                return;
            }
        });
    }
}