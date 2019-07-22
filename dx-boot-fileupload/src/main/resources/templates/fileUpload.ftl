<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>fileUpload</title>

    <script type="text/javascript">
        //图片回显+图片格式+文件类型
        function showPic(obj) {
            var newPreview = document.getElementById('picture');
            if (obj) {
                //ie浏览器兼容
                if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
                    obj.select();
                    newPreview.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);";
                    var path = document.selection.createRange().text;
                    var flag = judgeImgSuffix(path);
                    if (flag) {
                        newPreview.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = document.selection.createRange().text;
                    } else {
                        alert("要求图片格式为png,jpg,jpeg,bmp");
                    }

                    return;
                }
                //firefox浏览器兼容
                else if (window.navigator.userAgent.indexOf("Firefox") >= 1) {
                    if (obj.files) {
                        newPreview.src = window.URL.createObjectURL(obj.files.item(0));
                        return;
                    }
                    newPreview.src = obj.value;
                    return;
                }
                newPreview.src = obj.value;
                return;
            }
        }

        function judgeImgSuffix(path) {
            var index = path.lastIndexOf('.');
            var suffix = "";
            if (index > 0) {
                suffix = path.substring(index + 1);
            }
            if ("png" == suffix || "jpg" == suffix || "jpeg" == suffix
                || "bmp" == suffix || "PNG" == suffix || "JPG" == suffix
                || "JPEG" == suffix || "BMP" == suffix) {
                return true;
            } else {
                //alert("请上传正确到的图片格式");
                return false;
            }

        }
    </script>
</head>
<body>


<div>
    <form action="/upload" enctype="multipart/form-data" method="post">
        <img id="picture" src="" width="106" alt=""> <br />
        上传文件目录：<input type="file" name="file" id='file' onchange="showPic(this)" />
        <br /> <input type="submit" value="提交" />
    </form>
</div>

</body>
</html>