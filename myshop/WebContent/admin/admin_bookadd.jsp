<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">图书管理</a><span class="crumb-step">&gt;</span><span>新增图书</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/myshop/admin/admin_dobookadd" method="post" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>书名：</th>
                                <td>
                                    <input class="common-text required" id="title" name="bookName" size="50" value="" type="text">
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>图片：</th>
                                <td>
                                    <input class="common-text required" id="title" name="bookFileName" size="50" value="" type="text">
                                </td>
                            </tr>
                           <!--   <tr>
                                <th><i class="require-red">*</i>图片：</th>
                                <td><input name="smallimg" id="" type="file"><input type="submit" onclick="submitForm('/jscss/admin/design/upload')" value="上传图片"/></td>
                            </tr> -->
                             <tr>
                                <th><i class="require-red">*</i>价格：</th>
                                <td>
                                    <input class="common-text required" id="title" name="bookPrice" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>