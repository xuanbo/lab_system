<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- labActivityList css -->
<link rel="stylesheet" type="text/css" href="assets/my/teacher/labActivityState.css">

    <div class="labActivityStateBar">
        <a href="teacher/${TEACHERID }/labActivity/state/process">
            <button id="process" class="btn btn-default glyphicon glyphicon-question-sign">
                预约待处理
            </button>
        </a>
        <a href="teacher/${TEACHERID }/labActivity/state/fail">
            <button id="fail" class="btn btn-default glyphicon glyphicon-remove-sign">
                预约失败
            </button>
        </a>
        <a href="teacher/${TEACHERID }/labActivity/state/success">
            <button id="success" class="btn btn-default glyphicon glyphicon-ok-sign">
                预约成功
            </button>
        </a>
        <a href="teacher/labActivity/add">
            <button id="add" class="btn btn-default glyphicon glyphicon-plus-sign">
                新增预约
            </button>
        </a>
        
        <a onclick="window.history.back()">
            <button class="btn btn-default glyphicon glyphicon-chevron-left">
                返回
            </button>
        </a>
                   
        <a href="teacher/${TEACHERID }/labActivity/state/end">
            <button class="btn btn-danger glyphicon glyphicon glyphicon-thumbs-up" style="margin-left: 5%;">
                实验结束
            </button>
        </a>
    </div>
    <hr>